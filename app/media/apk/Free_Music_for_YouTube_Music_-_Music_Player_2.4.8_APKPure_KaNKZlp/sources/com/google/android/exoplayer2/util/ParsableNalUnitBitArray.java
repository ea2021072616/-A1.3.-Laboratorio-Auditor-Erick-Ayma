package com.google.android.exoplayer2.util;

import com.flurry.android.Constants;
/* loaded from: classes.dex */
public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i, int i2) {
        reset(bArr, i, i2);
    }

    public void reset(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.byteOffset = i;
        this.byteLimit = i2;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public void skipBits(int i) {
        int i2 = this.byteOffset;
        this.byteOffset += i / 8;
        this.bitOffset += i % 8;
        if (this.bitOffset > 7) {
            this.byteOffset++;
            this.bitOffset -= 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.byteOffset) {
                if (shouldSkipByte(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                assertValidOffset();
                return;
            }
        }
    }

    public boolean canReadBits(int i) {
        int i2 = this.byteOffset;
        int i3 = (i / 8) + this.byteOffset;
        int i4 = this.bitOffset + (i % 8);
        if (i4 > 7) {
            i3++;
            i4 -= 8;
        }
        int i5 = i2 + 1;
        int i6 = i3;
        int i7 = i5;
        while (i7 <= i6 && i6 < this.byteLimit) {
            if (shouldSkipByte(i7)) {
                i6++;
                i7 += 2;
            }
            i7++;
        }
        return i6 < this.byteLimit || (i6 == this.byteLimit && i4 == 0);
    }

    public boolean readBit() {
        return readBits(1) == 1;
    }

    public int readBits(int i) {
        int i2;
        int i3 = 0;
        if (i != 0) {
            int i4 = i / 8;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = shouldSkipByte(this.byteOffset + 1) ? this.byteOffset + 2 : this.byteOffset + 1;
                if (this.bitOffset != 0) {
                    i2 = ((this.data[this.byteOffset] & Constants.UNKNOWN) << this.bitOffset) | ((this.data[i7] & Constants.UNKNOWN) >>> (8 - this.bitOffset));
                } else {
                    i2 = this.data[this.byteOffset];
                }
                i -= 8;
                i5 |= (i2 & 255) << i;
                this.byteOffset = i7;
            }
            if (i > 0) {
                int i8 = this.bitOffset + i;
                byte b2 = (byte) (255 >> (8 - i));
                int i9 = shouldSkipByte(this.byteOffset + 1) ? this.byteOffset + 2 : this.byteOffset + 1;
                if (i8 > 8) {
                    i3 = ((((this.data[this.byteOffset] & Constants.UNKNOWN) << (i8 - 8)) | ((this.data[i9] & Constants.UNKNOWN) >> (16 - i8))) & b2) | i5;
                    this.byteOffset = i9;
                } else {
                    i3 = (((this.data[this.byteOffset] & Constants.UNKNOWN) >> (8 - i8)) & b2) | i5;
                    if (i8 == 8) {
                        this.byteOffset = i9;
                    }
                }
                this.bitOffset = i8 % 8;
            } else {
                i3 = i5;
            }
            assertValidOffset();
        }
        return i3;
    }

    public boolean canReadExpGolombCodedNum() {
        int i = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i3++;
        }
        boolean z = this.byteOffset == this.byteLimit;
        this.byteOffset = i;
        this.bitOffset = i2;
        return !z && canReadBits((i3 * 2) + 1);
    }

    public int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public int readSignedExpGolombCodedInt() {
        int readExpGolombCodeNum = readExpGolombCodeNum();
        return (readExpGolombCodeNum % 2 == 0 ? -1 : 1) * ((readExpGolombCodeNum + 1) / 2);
    }

    private int readExpGolombCodeNum() {
        int i = 0;
        while (!readBit()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? readBits(i) : 0);
    }

    private boolean shouldSkipByte(int i) {
        return 2 <= i && i < this.byteLimit && this.data[i] == 3 && this.data[i + (-2)] == 0 && this.data[i + (-1)] == 0;
    }

    private void assertValidOffset() {
        Assertions.checkState(this.byteOffset >= 0 && this.bitOffset >= 0 && this.bitOffset < 8 && (this.byteOffset < this.byteLimit || (this.byteOffset == this.byteLimit && this.bitOffset == 0)));
    }
}
