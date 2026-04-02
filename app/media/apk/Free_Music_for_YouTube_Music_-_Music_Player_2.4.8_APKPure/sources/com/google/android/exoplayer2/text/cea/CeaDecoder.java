package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.TreeSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class CeaDecoder implements SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final LinkedList<SubtitleInputBuffer> availableInputBuffers = new LinkedList<>();
    private final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
    private SubtitleInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private final TreeSet<SubtitleInputBuffer> queuedInputBuffers;

    protected abstract Subtitle createSubtitle();

    protected abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    protected abstract boolean isNewSubtitleDataAvailable();

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.availableInputBuffers.add(new SubtitleInputBuffer());
        }
        this.availableOutputBuffers = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(this));
        }
        this.queuedInputBuffers = new TreeSet<>();
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.playbackPositionUs = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        this.dequeuedInputBuffer = this.availableInputBuffers.pollFirst();
        return this.dequeuedInputBuffer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer != null);
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        this.queuedInputBuffers.add(subtitleInputBuffer);
        this.dequeuedInputBuffer = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && this.queuedInputBuffers.first().timeUs <= this.playbackPositionUs) {
            SubtitleInputBuffer pollFirst = this.queuedInputBuffers.pollFirst();
            if (pollFirst.isEndOfStream()) {
                SubtitleOutputBuffer pollFirst2 = this.availableOutputBuffers.pollFirst();
                pollFirst2.addFlag(4);
                releaseInputBuffer(pollFirst);
                return pollFirst2;
            }
            decode(pollFirst);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                if (!pollFirst.isDecodeOnly()) {
                    SubtitleOutputBuffer pollFirst3 = this.availableOutputBuffers.pollFirst();
                    pollFirst3.setContent(pollFirst.timeUs, createSubtitle, 0L);
                    releaseInputBuffer(pollFirst);
                    return pollFirst3;
                }
            }
            releaseInputBuffer(pollFirst);
        }
        return null;
    }

    private void releaseInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        subtitleInputBuffer.clear();
        this.availableInputBuffers.add(subtitleInputBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.playbackPositionUs = 0L;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer(this.queuedInputBuffers.pollFirst());
        }
        if (this.dequeuedInputBuffer != null) {
            releaseInputBuffer(this.dequeuedInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }
}
