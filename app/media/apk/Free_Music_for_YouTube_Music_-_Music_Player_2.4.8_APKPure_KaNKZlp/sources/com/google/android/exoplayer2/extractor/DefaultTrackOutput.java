package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class DefaultTrackOutput implements TrackOutput {
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_ENABLED = 0;
    private static final int STATE_ENABLED_WRITING = 1;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private Allocation lastAllocation;
    private int lastAllocationOffset;
    private boolean pendingSplice;
    private long sampleOffsetUs;
    private long totalBytesDropped;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private final InfoQueue infoQueue = new InfoQueue();
    private final LinkedBlockingDeque<Allocation> dataQueue = new LinkedBlockingDeque<>();
    private final BufferExtrasHolder extrasHolder = new BufferExtrasHolder();
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private final AtomicInteger state = new AtomicInteger();
    private boolean needKeyframe = true;

    /* loaded from: classes.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public DefaultTrackOutput(Allocator allocator) {
        this.allocator = allocator;
        this.allocationLength = allocator.getIndividualAllocationLength();
        this.lastAllocationOffset = this.allocationLength;
    }

    public void reset(boolean z) {
        int andSet = this.state.getAndSet(z ? 0 : 2);
        clearSampleData();
        this.infoQueue.resetLargestParsedTimestamps();
        if (andSet == 2) {
            this.downstreamFormat = null;
        }
    }

    public void sourceId(int i) {
        this.infoQueue.sourceId(i);
    }

    public void splice() {
        this.pendingSplice = true;
    }

    public int getWriteIndex() {
        return this.infoQueue.getWriteIndex();
    }

    public void discardUpstreamSamples(int i) {
        this.totalBytesWritten = this.infoQueue.discardUpstreamSamples(i);
        dropUpstreamFrom(this.totalBytesWritten);
    }

    private void dropUpstreamFrom(long j) {
        int i = (int) (j - this.totalBytesDropped);
        int i2 = i / this.allocationLength;
        int i3 = i % this.allocationLength;
        int size = (this.dataQueue.size() - i2) - 1;
        int i4 = i3 == 0 ? size + 1 : size;
        for (int i5 = 0; i5 < i4; i5++) {
            this.allocator.release(this.dataQueue.removeLast());
        }
        this.lastAllocation = this.dataQueue.peekLast();
        this.lastAllocationOffset = i3 == 0 ? this.allocationLength : i3;
    }

    public void disable() {
        if (this.state.getAndSet(2) == 0) {
            clearSampleData();
        }
    }

    public boolean isEmpty() {
        return this.infoQueue.isEmpty();
    }

    public int getReadIndex() {
        return this.infoQueue.getReadIndex();
    }

    public int peekSourceId() {
        return this.infoQueue.peekSourceId();
    }

    public Format getUpstreamFormat() {
        return this.infoQueue.getUpstreamFormat();
    }

    public long getLargestQueuedTimestampUs() {
        return this.infoQueue.getLargestQueuedTimestampUs();
    }

    public boolean skipToKeyframeBefore(long j) {
        long skipToKeyframeBefore = this.infoQueue.skipToKeyframeBefore(j);
        if (skipToKeyframeBefore == -1) {
            return false;
        }
        dropDownstreamTo(skipToKeyframeBefore);
        return true;
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, long j) {
        switch (this.infoQueue.readData(formatHolder, decoderInputBuffer, this.downstreamFormat, this.extrasHolder)) {
            case -5:
                this.downstreamFormat = formatHolder.format;
                return -5;
            case -4:
                if (decoderInputBuffer.timeUs < j) {
                    decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.isEncrypted()) {
                    readEncryptionData(decoderInputBuffer, this.extrasHolder);
                }
                decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
                readData(this.extrasHolder.offset, decoderInputBuffer.data, this.extrasHolder.size);
                dropDownstreamTo(this.extrasHolder.nextOffset);
                return -4;
            case -3:
                if (z) {
                    decoderInputBuffer.setFlags(4);
                    return -4;
                }
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, BufferExtrasHolder bufferExtrasHolder) {
        int i;
        long j;
        long j2 = bufferExtrasHolder.offset;
        this.scratch.reset(1);
        readData(j2, this.scratch.data, 1);
        long j3 = 1 + j2;
        byte b2 = this.scratch.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (decoderInputBuffer.cryptoInfo.iv == null) {
            decoderInputBuffer.cryptoInfo.iv = new byte[16];
        }
        readData(j3, decoderInputBuffer.cryptoInfo.iv, i2);
        long j4 = j3 + i2;
        if (z) {
            this.scratch.reset(2);
            readData(j4, this.scratch.data, 2);
            i = this.scratch.readUnsignedShort();
            j = j4 + 2;
        } else {
            i = 1;
            j = j4;
        }
        int[] iArr = decoderInputBuffer.cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = decoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.scratch.reset(i3);
            readData(j, this.scratch.data, i3);
            j += i3;
            this.scratch.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.scratch.readUnsignedShort();
                iArr2[i4] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = bufferExtrasHolder.size - ((int) (j - bufferExtrasHolder.offset));
        }
        decoderInputBuffer.cryptoInfo.set(i, iArr, iArr2, bufferExtrasHolder.encryptionKeyId, decoderInputBuffer.cryptoInfo.iv, 1);
        int i5 = (int) (j - bufferExtrasHolder.offset);
        bufferExtrasHolder.offset += i5;
        bufferExtrasHolder.size -= i5;
    }

    private void readData(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            dropDownstreamTo(j);
            int i2 = (int) (j - this.totalBytesDropped);
            int min = Math.min(i, this.allocationLength - i2);
            Allocation peek = this.dataQueue.peek();
            byteBuffer.put(peek.data, peek.translateOffset(i2), min);
            j += min;
            i -= min;
        }
    }

    private void readData(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            dropDownstreamTo(j);
            int i3 = (int) (j - this.totalBytesDropped);
            int min = Math.min(i - i2, this.allocationLength - i3);
            Allocation peek = this.dataQueue.peek();
            System.arraycopy(peek.data, peek.translateOffset(i3), bArr, i2, min);
            j += min;
            i2 += min;
        }
    }

    private void dropDownstreamTo(long j) {
        int i = ((int) (j - this.totalBytesDropped)) / this.allocationLength;
        for (int i2 = 0; i2 < i; i2++) {
            this.allocator.release(this.dataQueue.remove());
            this.totalBytesDropped += this.allocationLength;
        }
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public void formatWithOffset(Format format, long j) {
        this.sampleOffsetUs = j;
        format(format);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.infoQueue.format(adjustedSampleFormat);
        if (this.upstreamFormatChangeListener != null && format2) {
            this.upstreamFormatChangeListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        if (!startWriteOperation()) {
            int skip = extractorInput.skip(i);
            if (skip == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            return skip;
        }
        try {
            int read = extractorInput.read(this.lastAllocation.data, this.lastAllocation.translateOffset(this.lastAllocationOffset), prepareForAppend(i));
            if (read == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            this.lastAllocationOffset += read;
            this.totalBytesWritten += read;
            return read;
        } finally {
            endWriteOperation();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        if (!startWriteOperation()) {
            parsableByteArray.skipBytes(i);
            return;
        }
        while (i > 0) {
            int prepareForAppend = prepareForAppend(i);
            parsableByteArray.readBytes(this.lastAllocation.data, this.lastAllocation.translateOffset(this.lastAllocationOffset), prepareForAppend);
            this.lastAllocationOffset += prepareForAppend;
            this.totalBytesWritten += prepareForAppend;
            i -= prepareForAppend;
        }
        endWriteOperation();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        if (!startWriteOperation()) {
            this.infoQueue.commitSampleTimestamp(j);
            return;
        }
        try {
            if (this.pendingSplice) {
                if ((i & 1) != 0 && this.infoQueue.attemptSplice(j)) {
                    this.pendingSplice = false;
                } else {
                    return;
                }
            }
            if (this.needKeyframe) {
                if ((i & 1) != 0) {
                    this.needKeyframe = false;
                } else {
                    return;
                }
            }
            this.infoQueue.commitSample(j + this.sampleOffsetUs, i, (this.totalBytesWritten - i2) - i3, i2, bArr);
        } finally {
            endWriteOperation();
        }
    }

    private boolean startWriteOperation() {
        return this.state.compareAndSet(0, 1);
    }

    private void endWriteOperation() {
        if (!this.state.compareAndSet(1, 0)) {
            clearSampleData();
        }
    }

    private void clearSampleData() {
        this.infoQueue.clearSampleData();
        this.allocator.release((Allocation[]) this.dataQueue.toArray(new Allocation[this.dataQueue.size()]));
        this.dataQueue.clear();
        this.allocator.trim();
        this.totalBytesDropped = 0L;
        this.totalBytesWritten = 0L;
        this.lastAllocation = null;
        this.lastAllocationOffset = this.allocationLength;
        this.needKeyframe = true;
    }

    private int prepareForAppend(int i) {
        if (this.lastAllocationOffset == this.allocationLength) {
            this.lastAllocationOffset = 0;
            this.lastAllocation = this.allocator.allocate();
            this.dataQueue.add(this.lastAllocation);
        }
        return Math.min(i, this.allocationLength - this.lastAllocationOffset);
    }

    private static Format getAdjustedSampleFormat(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.subsampleOffsetUs != Long.MAX_VALUE) {
            return format.copyWithSubsampleOffsetUs(format.subsampleOffsetUs + j);
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class InfoQueue {
        private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
        private int absoluteReadIndex;
        private int queueSize;
        private int relativeReadIndex;
        private int relativeWriteIndex;
        private Format upstreamFormat;
        private int upstreamSourceId;
        private int capacity = 1000;
        private int[] sourceIds = new int[this.capacity];
        private long[] offsets = new long[this.capacity];
        private long[] timesUs = new long[this.capacity];
        private int[] flags = new int[this.capacity];
        private int[] sizes = new int[this.capacity];
        private byte[][] encryptionKeys = new byte[this.capacity];
        private Format[] formats = new Format[this.capacity];
        private long largestDequeuedTimestampUs = Long.MIN_VALUE;
        private long largestQueuedTimestampUs = Long.MIN_VALUE;
        private boolean upstreamFormatRequired = true;

        public void clearSampleData() {
            this.absoluteReadIndex = 0;
            this.relativeReadIndex = 0;
            this.relativeWriteIndex = 0;
            this.queueSize = 0;
        }

        public void resetLargestParsedTimestamps() {
            this.largestDequeuedTimestampUs = Long.MIN_VALUE;
            this.largestQueuedTimestampUs = Long.MIN_VALUE;
        }

        public int getWriteIndex() {
            return this.absoluteReadIndex + this.queueSize;
        }

        public long discardUpstreamSamples(int i) {
            int i2;
            int writeIndex = getWriteIndex() - i;
            Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.queueSize);
            if (writeIndex == 0) {
                if (this.absoluteReadIndex == 0) {
                    return 0L;
                }
                return this.sizes[i2] + this.offsets[(this.relativeWriteIndex == 0 ? this.capacity : this.relativeWriteIndex) - 1];
            }
            this.queueSize -= writeIndex;
            this.relativeWriteIndex = ((this.relativeWriteIndex + this.capacity) - writeIndex) % this.capacity;
            this.largestQueuedTimestampUs = Long.MIN_VALUE;
            for (int i3 = this.queueSize - 1; i3 >= 0; i3--) {
                int i4 = (this.relativeReadIndex + i3) % this.capacity;
                this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, this.timesUs[i4]);
                if ((this.flags[i4] & 1) != 0) {
                    break;
                }
            }
            return this.offsets[this.relativeWriteIndex];
        }

        public void sourceId(int i) {
            this.upstreamSourceId = i;
        }

        public int getReadIndex() {
            return this.absoluteReadIndex;
        }

        public int peekSourceId() {
            return this.queueSize == 0 ? this.upstreamSourceId : this.sourceIds[this.relativeReadIndex];
        }

        public synchronized boolean isEmpty() {
            return this.queueSize == 0;
        }

        public synchronized Format getUpstreamFormat() {
            return this.upstreamFormatRequired ? null : this.upstreamFormat;
        }

        public synchronized long getLargestQueuedTimestampUs() {
            return Math.max(this.largestDequeuedTimestampUs, this.largestQueuedTimestampUs);
        }

        public synchronized int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, Format format, BufferExtrasHolder bufferExtrasHolder) {
            long j;
            int i = -5;
            synchronized (this) {
                if (this.queueSize == 0) {
                    if (this.upstreamFormat != null && this.upstreamFormat != format) {
                        formatHolder.format = this.upstreamFormat;
                    } else {
                        i = -3;
                    }
                } else if (this.formats[this.relativeReadIndex] != format) {
                    formatHolder.format = this.formats[this.relativeReadIndex];
                } else {
                    decoderInputBuffer.timeUs = this.timesUs[this.relativeReadIndex];
                    decoderInputBuffer.setFlags(this.flags[this.relativeReadIndex]);
                    bufferExtrasHolder.size = this.sizes[this.relativeReadIndex];
                    bufferExtrasHolder.offset = this.offsets[this.relativeReadIndex];
                    bufferExtrasHolder.encryptionKeyId = this.encryptionKeys[this.relativeReadIndex];
                    this.largestDequeuedTimestampUs = Math.max(this.largestDequeuedTimestampUs, decoderInputBuffer.timeUs);
                    this.queueSize--;
                    this.relativeReadIndex++;
                    this.absoluteReadIndex++;
                    if (this.relativeReadIndex == this.capacity) {
                        this.relativeReadIndex = 0;
                    }
                    if (this.queueSize > 0) {
                        j = this.offsets[this.relativeReadIndex];
                    } else {
                        j = bufferExtrasHolder.offset + bufferExtrasHolder.size;
                    }
                    bufferExtrasHolder.nextOffset = j;
                    i = -4;
                }
            }
            return i;
        }

        public synchronized long skipToKeyframeBefore(long j) {
            long j2 = -1;
            synchronized (this) {
                if (this.queueSize != 0 && j >= this.timesUs[this.relativeReadIndex]) {
                    if (j <= this.timesUs[(this.relativeWriteIndex == 0 ? this.capacity : this.relativeWriteIndex) - 1]) {
                        int i = 0;
                        int i2 = this.relativeReadIndex;
                        int i3 = -1;
                        while (i2 != this.relativeWriteIndex && this.timesUs[i2] <= j) {
                            if ((this.flags[i2] & 1) != 0) {
                                i3 = i;
                            }
                            i2 = (i2 + 1) % this.capacity;
                            i++;
                        }
                        if (i3 != -1) {
                            this.queueSize -= i3;
                            this.relativeReadIndex = (this.relativeReadIndex + i3) % this.capacity;
                            this.absoluteReadIndex += i3;
                            j2 = this.offsets[this.relativeReadIndex];
                        }
                    }
                }
            }
            return j2;
        }

        public synchronized boolean format(Format format) {
            boolean z = false;
            synchronized (this) {
                if (format == null) {
                    this.upstreamFormatRequired = true;
                } else {
                    this.upstreamFormatRequired = false;
                    if (!Util.areEqual(format, this.upstreamFormat)) {
                        this.upstreamFormat = format;
                        z = true;
                    }
                }
            }
            return z;
        }

        public synchronized void commitSample(long j, int i, long j2, int i2, byte[] bArr) {
            Assertions.checkState(!this.upstreamFormatRequired);
            commitSampleTimestamp(j);
            this.timesUs[this.relativeWriteIndex] = j;
            this.offsets[this.relativeWriteIndex] = j2;
            this.sizes[this.relativeWriteIndex] = i2;
            this.flags[this.relativeWriteIndex] = i;
            this.encryptionKeys[this.relativeWriteIndex] = bArr;
            this.formats[this.relativeWriteIndex] = this.upstreamFormat;
            this.sourceIds[this.relativeWriteIndex] = this.upstreamSourceId;
            this.queueSize++;
            if (this.queueSize == this.capacity) {
                int i3 = this.capacity + 1000;
                int[] iArr = new int[i3];
                long[] jArr = new long[i3];
                long[] jArr2 = new long[i3];
                int[] iArr2 = new int[i3];
                int[] iArr3 = new int[i3];
                byte[][] bArr2 = new byte[i3];
                Format[] formatArr = new Format[i3];
                int i4 = this.capacity - this.relativeReadIndex;
                System.arraycopy(this.offsets, this.relativeReadIndex, jArr, 0, i4);
                System.arraycopy(this.timesUs, this.relativeReadIndex, jArr2, 0, i4);
                System.arraycopy(this.flags, this.relativeReadIndex, iArr2, 0, i4);
                System.arraycopy(this.sizes, this.relativeReadIndex, iArr3, 0, i4);
                System.arraycopy(this.encryptionKeys, this.relativeReadIndex, bArr2, 0, i4);
                System.arraycopy(this.formats, this.relativeReadIndex, formatArr, 0, i4);
                System.arraycopy(this.sourceIds, this.relativeReadIndex, iArr, 0, i4);
                int i5 = this.relativeReadIndex;
                System.arraycopy(this.offsets, 0, jArr, i4, i5);
                System.arraycopy(this.timesUs, 0, jArr2, i4, i5);
                System.arraycopy(this.flags, 0, iArr2, i4, i5);
                System.arraycopy(this.sizes, 0, iArr3, i4, i5);
                System.arraycopy(this.encryptionKeys, 0, bArr2, i4, i5);
                System.arraycopy(this.formats, 0, formatArr, i4, i5);
                System.arraycopy(this.sourceIds, 0, iArr, i4, i5);
                this.offsets = jArr;
                this.timesUs = jArr2;
                this.flags = iArr2;
                this.sizes = iArr3;
                this.encryptionKeys = bArr2;
                this.formats = formatArr;
                this.sourceIds = iArr;
                this.relativeReadIndex = 0;
                this.relativeWriteIndex = this.capacity;
                this.queueSize = this.capacity;
                this.capacity = i3;
            } else {
                this.relativeWriteIndex++;
                if (this.relativeWriteIndex == this.capacity) {
                    this.relativeWriteIndex = 0;
                }
            }
        }

        public synchronized void commitSampleTimestamp(long j) {
            this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
        }

        public synchronized boolean attemptSplice(long j) {
            boolean z;
            if (this.largestDequeuedTimestampUs >= j) {
                z = false;
            } else {
                int i = this.queueSize;
                while (i > 0 && this.timesUs[((this.relativeReadIndex + i) - 1) % this.capacity] >= j) {
                    i--;
                }
                discardUpstreamSamples(i + this.absoluteReadIndex);
                z = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BufferExtrasHolder {
        public byte[] encryptionKeyId;
        public long nextOffset;
        public long offset;
        public int size;

        private BufferExtrasHolder() {
        }
    }
}
