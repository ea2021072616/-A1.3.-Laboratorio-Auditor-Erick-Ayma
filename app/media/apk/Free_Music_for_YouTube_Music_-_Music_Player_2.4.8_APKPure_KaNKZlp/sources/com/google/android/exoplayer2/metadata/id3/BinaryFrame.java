package com.google.android.exoplayer2.metadata.id3;
/* loaded from: classes.dex */
public final class BinaryFrame extends Id3Frame {
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }
}
