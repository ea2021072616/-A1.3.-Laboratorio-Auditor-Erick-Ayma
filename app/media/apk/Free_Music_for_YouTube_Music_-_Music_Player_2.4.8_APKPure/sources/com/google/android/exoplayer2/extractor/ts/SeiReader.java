package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
/* loaded from: classes.dex */
final class SeiReader {
    private final TrackOutput output;

    public SeiReader(TrackOutput trackOutput) {
        this.output = trackOutput;
        trackOutput.format(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, null, -1, 0, null, null));
    }

    public void consume(long j, ParsableByteArray parsableByteArray) {
        int readUnsignedByte;
        int i;
        while (parsableByteArray.bytesLeft() > 1) {
            int i2 = 0;
            do {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
                i2 += readUnsignedByte;
            } while (readUnsignedByte == 255);
            int i3 = 0;
            while (true) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                i = i3 + readUnsignedByte2;
                if (readUnsignedByte2 != 255) {
                    break;
                }
                i3 = i;
            }
            if (Cea608Decoder.isSeiMessageCea608(i2, i, parsableByteArray)) {
                parsableByteArray.skipBytes(8);
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 31;
                parsableByteArray.skipBytes(1);
                int i4 = 0;
                for (int i5 = 0; i5 < readUnsignedByte3; i5++) {
                    if ((parsableByteArray.peekUnsignedByte() & 7) != 4) {
                        parsableByteArray.skipBytes(3);
                    } else {
                        i4 += 3;
                        this.output.sampleData(parsableByteArray, 3);
                    }
                }
                this.output.sampleMetadata(j, 1, i4, 0, null);
                parsableByteArray.skipBytes(i - ((readUnsignedByte3 * 3) + 10));
            } else {
                parsableByteArray.skipBytes(i);
            }
        }
    }
}
