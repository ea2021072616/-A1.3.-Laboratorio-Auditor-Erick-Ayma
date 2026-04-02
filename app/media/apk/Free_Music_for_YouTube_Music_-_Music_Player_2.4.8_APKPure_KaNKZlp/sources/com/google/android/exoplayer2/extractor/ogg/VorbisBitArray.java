package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes.dex */
final class VorbisBitArray {
    private int bitOffset;
    private int byteOffset;
    public final byte[] data;
    private int limit;

    public VorbisBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public VorbisBitArray(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i * 8;
    }

    public void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public boolean readBit() {
        return readBits(1) == 1;
    }

    public int readBits(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Assertions.checkState(getPosition() + i <= this.limit);
        if (i == 0) {
            return 0;
        }
        if (this.bitOffset != 0) {
            i2 = Math.min(i, 8 - this.bitOffset);
            i3 = (255 >>> (8 - i2)) & (this.data[this.byteOffset] >>> this.bitOffset);
            this.bitOffset += i2;
            if (this.bitOffset == 8) {
                this.byteOffset++;
                this.bitOffset = 0;
            }
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i - i2 > 7) {
            int i7 = (i - i2) / 8;
            int i8 = i3;
            int i9 = 0;
            while (i9 < i7) {
                long j = i8;
                byte[] bArr = this.data;
                this.byteOffset = this.byteOffset + 1;
                i2 += 8;
                i9++;
                i8 = (int) (j | ((bArr[i6] & 255) << i2));
            }
            int i10 = i2;
            i5 = i8;
            i4 = i10;
        } else {
            i4 = i2;
            i5 = i3;
        }
        if (i > i4) {
            int i11 = i - i4;
            i5 |= ((255 >>> (8 - i11)) & this.data[this.byteOffset]) << i4;
            this.bitOffset += i11;
        }
        return i5;
    }

    public void skipBits(int i) {
        Assertions.checkState(getPosition() + i <= this.limit);
        this.byteOffset += i / 8;
        this.bitOffset += i % 8;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public void setPosition(int i) {
        Assertions.checkArgument(i < this.limit && i >= 0);
        this.byteOffset = i / 8;
        this.bitOffset = i - (this.byteOffset * 8);
    }

    public int bitsLeft() {
        return this.limit - getPosition();
    }

    public int limit() {
        return this.limit;
    }
}
