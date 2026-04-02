package com.google.android.exoplayer2.extractor.ogg;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
final class OpusReader extends StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int OPUS_CODE = Util.getIntegerCodeForString("Opus");
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < OPUS_SIGNATURE.length) {
            return false;
        }
        byte[] bArr = new byte[OPUS_SIGNATURE.length];
        parsableByteArray.readBytes(bArr, 0, OPUS_SIGNATURE.length);
        return Arrays.equals(bArr, OPUS_SIGNATURE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.headerRead = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.data));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        if (!this.headerRead) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
            int i = copyOf[9] & Constants.UNKNOWN;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            putNativeOrderLong(arrayList, ((copyOf[11] & Constants.UNKNOWN) << 8) | (copyOf[10] & Constants.UNKNOWN));
            putNativeOrderLong(arrayList, DEFAULT_SEEK_PRE_ROLL_SAMPLES);
            setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_OPUS, null, -1, -1, i, SAMPLE_RATE, arrayList, null, 0, "und");
            this.headerRead = true;
            return true;
        }
        boolean z = parsableByteArray.readInt() == OPUS_CODE;
        parsableByteArray.setPosition(0);
        return z;
    }

    private void putNativeOrderLong(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i * C.NANOS_PER_SECOND) / 48000).array());
    }

    private long getPacketDurationUs(byte[] bArr) {
        int i;
        int i2;
        int i3 = bArr[0] & Constants.UNKNOWN;
        switch (i3 & 3) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i4 = i3 >> 3;
        int i5 = i4 & 3;
        if (i4 >= 16) {
            i2 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i5;
        } else if (i4 >= 12) {
            i2 = 10000 << (i5 & 1);
        } else if (i5 == 3) {
            i2 = 60000;
        } else {
            i2 = 10000 << i5;
        }
        return i2 * i;
    }
}
