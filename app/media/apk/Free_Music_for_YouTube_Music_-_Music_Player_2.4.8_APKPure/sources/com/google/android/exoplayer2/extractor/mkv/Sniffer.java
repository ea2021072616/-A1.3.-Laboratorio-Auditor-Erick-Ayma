package com.google.android.exoplayer2.extractor.mkv;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long length = extractorInput.getLength();
        int i = (int) ((length == -1 || length > 1024) ? 1024L : length);
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i2 = this.peekLength + 1;
            this.peekLength = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.data[0] & Constants.UNKNOWN);
        }
        long readUint = readUint(extractorInput);
        long j = this.peekLength;
        if (readUint != Long.MIN_VALUE) {
            if (length == -1 || j + readUint < length) {
                while (this.peekLength < j + readUint) {
                    if (readUint(extractorInput) == Long.MIN_VALUE) {
                        return false;
                    }
                    long readUint2 = readUint(extractorInput);
                    if (readUint2 < 0 || readUint2 > 2147483647L) {
                        return false;
                    }
                    if (readUint2 != 0) {
                        extractorInput.advancePeekPosition((int) readUint2);
                        this.peekLength = (int) (readUint2 + this.peekLength);
                    }
                }
                return ((long) this.peekLength) == readUint + j;
            }
            return false;
        }
        return false;
    }

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.scratch.data, 0, 1);
        int i = this.scratch.data[0] & Constants.UNKNOWN;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((i & i2) == 0) {
            i3++;
            i2 >>= 1;
        }
        int i4 = (i2 ^ (-1)) & i;
        extractorInput.peekFully(this.scratch.data, 1, i3);
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 << 8) + (this.scratch.data[i5 + 1] & Constants.UNKNOWN);
        }
        this.peekLength += i3 + 1;
        return i4;
    }
}
