package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
/* loaded from: classes.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private final ParsableByteArray parsableByteArray;

    public Tx3gDecoder() {
        super("Tx3gDecoder");
        this.parsableByteArray = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i) {
        this.parsableByteArray.reset(bArr, i);
        int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return Tx3gSubtitle.EMPTY;
        }
        return new Tx3gSubtitle(new Cue(this.parsableByteArray.readString(readUnsignedShort)));
    }
}
