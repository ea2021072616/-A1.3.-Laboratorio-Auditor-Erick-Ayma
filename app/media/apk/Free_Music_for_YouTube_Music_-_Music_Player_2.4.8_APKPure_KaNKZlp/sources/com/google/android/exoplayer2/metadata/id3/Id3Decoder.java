package com.google.android.exoplayer2.metadata.id3;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public final class Id3Decoder implements MetadataDecoder<List<Id3Frame>> {
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public boolean canDecode(String str) {
        return str.equals(MimeTypes.APPLICATION_ID3);
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public List<Id3Frame> decode(byte[] bArr, int i) throws MetadataDecoderException {
        Id3Frame decodeBinaryFrame;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        int decodeId3Header = decodeId3Header(parsableByteArray);
        while (decodeId3Header > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
            int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            if (readSynchSafeInt <= 1) {
                break;
            }
            parsableByteArray.skipBytes(2);
            if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && readUnsignedByte4 == 88) {
                try {
                    decodeBinaryFrame = decodeTxxxFrame(parsableByteArray, readSynchSafeInt);
                    continue;
                } catch (UnsupportedEncodingException e) {
                    throw new MetadataDecoderException("Unsupported encoding", e);
                }
            } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                decodeBinaryFrame = decodePrivFrame(parsableByteArray, readSynchSafeInt);
                continue;
            } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && readUnsignedByte4 == 66) {
                decodeBinaryFrame = decodeGeobFrame(parsableByteArray, readSynchSafeInt);
                continue;
            } else if (readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67) {
                decodeBinaryFrame = decodeApicFrame(parsableByteArray, readSynchSafeInt);
                continue;
            } else if (readUnsignedByte == 84) {
                decodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, readSynchSafeInt, String.format(Locale.US, "%c%c%c%c", Integer.valueOf(readUnsignedByte), Integer.valueOf(readUnsignedByte2), Integer.valueOf(readUnsignedByte3), Integer.valueOf(readUnsignedByte4)));
                continue;
            } else {
                decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, readSynchSafeInt, String.format(Locale.US, "%c%c%c%c", Integer.valueOf(readUnsignedByte), Integer.valueOf(readUnsignedByte2), Integer.valueOf(readUnsignedByte3), Integer.valueOf(readUnsignedByte4)));
                continue;
            }
            arrayList.add(decodeBinaryFrame);
            decodeId3Header -= readSynchSafeInt + 10;
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 != 0 && i2 != 3) {
            while (indexOfZeroByte < bArr.length - 1) {
                if (indexOfZeroByte % 2 != 0 || bArr[indexOfZeroByte + 1] != 0) {
                    indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
                } else {
                    return indexOfZeroByte;
                }
            }
            return bArr.length;
        }
        return indexOfZeroByte;
    }

    private static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] != 0) {
                i++;
            } else {
                return i;
            }
        }
        return bArr.length;
    }

    private static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int decodeId3Header(ParsableByteArray parsableByteArray) throws MetadataDecoderException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte != 73 || readUnsignedByte2 != 68 || readUnsignedByte3 != 51) {
            throw new MetadataDecoderException(String.format(Locale.US, "Unexpected ID3 file identifier, expected \"ID3\", actual \"%c%c%c\".", Integer.valueOf(readUnsignedByte), Integer.valueOf(readUnsignedByte2), Integer.valueOf(readUnsignedByte3)));
        }
        parsableByteArray.skipBytes(2);
        int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if ((readUnsignedByte4 & 2) != 0) {
            int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
            if (readSynchSafeInt2 > 4) {
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
            }
            readSynchSafeInt -= readSynchSafeInt2;
        }
        if ((readUnsignedByte4 & 8) != 0) {
            return readSynchSafeInt - 10;
        }
        return readSynchSafeInt;
    }

    private static TxxxFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TxxxFrame(str, new String(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte) - delimiterLength, charsetName));
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), Arrays.copyOfRange(bArr, indexOfZeroByte + 1, bArr.length));
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i2 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i2, readUnsignedByte);
        String str2 = new String(bArr, i2, indexOfEos - i2, charsetName);
        int delimiterLength = delimiterLength(readUnsignedByte) + indexOfEos;
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, str2, new String(bArr, delimiterLength, indexOfEos2 - delimiterLength, charsetName), Arrays.copyOfRange(bArr, delimiterLength(readUnsignedByte) + indexOfEos2, bArr.length));
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i2 = bArr[indexOfZeroByte + 1] & Constants.UNKNOWN;
        int i3 = indexOfZeroByte + 2;
        int indexOfEos = indexOfEos(bArr, i3, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i3, indexOfEos - i3, charsetName), i2, Arrays.copyOfRange(bArr, delimiterLength(readUnsignedByte) + indexOfEos, bArr.length));
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        parsableByteArray.readBytes(bArr, 0, i - 1);
        return new TextInformationFrame(str, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static String getCharsetName(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return C.UTF8_NAME;
            default:
                return "ISO-8859-1";
        }
    }
}
