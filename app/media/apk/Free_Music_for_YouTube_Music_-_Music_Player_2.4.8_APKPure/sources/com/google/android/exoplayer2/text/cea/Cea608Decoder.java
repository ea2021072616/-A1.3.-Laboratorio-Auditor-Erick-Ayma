package com.google.android.exoplayer2.text.cea;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import com.flyco.tablayout.BuildConfig;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public final class Cea608Decoder extends CeaDecoder {
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_VALID_FLAG = 4;
    private static final int COUNTRY_CODE = 181;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_MISC_CHAN_1 = 20;
    private static final byte CTRL_MISC_CHAN_2 = 28;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE = 49;
    private static final int USER_DATA_TYPE_CODE = 3;
    private static final int USER_ID = 1195456820;
    private int captionMode;
    private int captionRowCount;
    private String captionString;
    private String lastCaptionString;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, IjkMediaMeta.FF_PROFILE_H264_HIGH_422, 231, 247, 209, 241, 9632};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, BuildConfig.VERSION_CODE, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final StringBuilder captionStringBuilder = new StringBuilder();

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public Cea608Decoder() {
        setCaptionMode(0);
        this.captionRowCount = 4;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        setCaptionMode(0);
        this.captionRowCount = 4;
        this.captionStringBuilder.setLength(0);
        this.captionString = null;
        this.lastCaptionString = null;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected boolean isNewSubtitleDataAvailable() {
        return !TextUtils.equals(this.captionString, this.lastCaptionString);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected Subtitle createSubtitle() {
        this.lastCaptionString = this.captionString;
        return new CeaSubtitle(new Cue(this.captionString));
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected void decode(SubtitleInputBuffer subtitleInputBuffer) {
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.ccData.bytesLeft() > 0) {
            byte readUnsignedByte = (byte) (this.ccData.readUnsignedByte() & 7);
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.ccData.readUnsignedByte() & 127);
            if (readUnsignedByte == 4 && (readUnsignedByte2 != 0 || readUnsignedByte3 != 0)) {
                if ((readUnsignedByte2 == 17 || readUnsignedByte2 == 25) && (readUnsignedByte3 & 112) == 48) {
                    this.captionStringBuilder.append(getSpecialChar(readUnsignedByte3));
                    z2 = true;
                } else {
                    if ((readUnsignedByte3 & 96) == 32) {
                        if (readUnsignedByte2 == 18 || readUnsignedByte2 == 26) {
                            backspace();
                            this.captionStringBuilder.append(getExtendedEsFrChar(readUnsignedByte3));
                            z2 = true;
                        } else if (readUnsignedByte2 == 19 || readUnsignedByte2 == 27) {
                            backspace();
                            this.captionStringBuilder.append(getExtendedPtDeChar(readUnsignedByte3));
                            z2 = true;
                        }
                    }
                    if (readUnsignedByte2 < 32) {
                        z = handleCtrl(readUnsignedByte2, readUnsignedByte3);
                        z2 = true;
                    } else {
                        this.captionStringBuilder.append(getChar(readUnsignedByte2));
                        if (readUnsignedByte3 >= 32) {
                            this.captionStringBuilder.append(getChar(readUnsignedByte3));
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.repeatableControlSet = false;
            }
            if (this.captionMode == 1 || this.captionMode == 3) {
                this.captionString = getDisplayCaption();
            }
        }
    }

    private boolean handleCtrl(byte b2, byte b3) {
        boolean isRepeatable = isRepeatable(b2);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b2 && this.repeatableControlCc2 == b3) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b2;
            this.repeatableControlCc2 = b3;
        }
        if (isMiscCode(b2, b3)) {
            handleMiscCode(b3);
        } else if (isPreambleAddressCode(b2, b3)) {
            maybeAppendNewline();
        }
        return isRepeatable;
    }

    private void handleMiscCode(byte b2) {
        switch (b2) {
            case 32:
                setCaptionMode(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.captionMode != 0) {
                    switch (b2) {
                        case 33:
                            if (this.captionStringBuilder.length() > 0) {
                                this.captionStringBuilder.setLength(this.captionStringBuilder.length() - 1);
                                return;
                            }
                            return;
                        case 44:
                            this.captionString = null;
                            if (this.captionMode == 1 || this.captionMode == 3) {
                                this.captionStringBuilder.setLength(0);
                                return;
                            }
                            return;
                        case 45:
                            maybeAppendNewline();
                            return;
                        case 46:
                            this.captionStringBuilder.setLength(0);
                            return;
                        case 47:
                            this.captionString = getDisplayCaption();
                            this.captionStringBuilder.setLength(0);
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.captionRowCount = 2;
                setCaptionMode(1);
                return;
            case 38:
                this.captionRowCount = 3;
                setCaptionMode(1);
                return;
            case 39:
                this.captionRowCount = 4;
                setCaptionMode(1);
                return;
            case 41:
                setCaptionMode(3);
                return;
        }
    }

    private void backspace() {
        if (this.captionStringBuilder.length() > 0) {
            this.captionStringBuilder.setLength(this.captionStringBuilder.length() - 1);
        }
    }

    private void maybeAppendNewline() {
        int length = this.captionStringBuilder.length();
        if (length > 0 && this.captionStringBuilder.charAt(length - 1) != '\n') {
            this.captionStringBuilder.append('\n');
        }
    }

    private String getDisplayCaption() {
        int length = this.captionStringBuilder.length();
        if (length == 0) {
            return null;
        }
        boolean z = this.captionStringBuilder.charAt(length + (-1)) == '\n';
        if (length == 1 && z) {
            return null;
        }
        if (z) {
            length--;
        }
        if (this.captionMode != 1) {
            return this.captionStringBuilder.substring(0, length);
        }
        int i = length;
        for (int i2 = 0; i2 < this.captionRowCount && i != -1; i2++) {
            i = this.captionStringBuilder.lastIndexOf("\n", i - 1);
        }
        int i3 = i != -1 ? i + 1 : 0;
        this.captionStringBuilder.delete(0, i3);
        return this.captionStringBuilder.substring(0, length - i3);
    }

    private void setCaptionMode(int i) {
        if (this.captionMode != i) {
            this.captionMode = i;
            this.captionStringBuilder.setLength(0);
            if (i == 1 || i == 0) {
                this.captionString = null;
            }
        }
    }

    private static char getChar(byte b2) {
        return (char) BASIC_CHARACTER_SET[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static char getSpecialChar(byte b2) {
        return (char) SPECIAL_CHARACTER_SET[b2 & 15];
    }

    private static char getExtendedEsFrChar(byte b2) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b2 & 31];
    }

    private static char getExtendedPtDeChar(byte b2) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b2 & 31];
    }

    private static boolean isMiscCode(byte b2, byte b3) {
        return (b2 == 20 || b2 == 28) && b3 >= 32 && b3 <= 47;
    }

    private static boolean isPreambleAddressCode(byte b2, byte b3) {
        return b2 >= 16 && b2 <= 31 && b3 >= 64 && b3 <= Byte.MAX_VALUE;
    }

    private static boolean isRepeatable(byte b2) {
        return b2 >= 16 && b2 <= 31;
    }

    public static boolean isSeiMessageCea608(int i, int i2, ParsableByteArray parsableByteArray) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int position = parsableByteArray.getPosition();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readInt = parsableByteArray.readInt();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(position);
        return readUnsignedByte == COUNTRY_CODE && readUnsignedShort == 49 && readInt == USER_ID && readUnsignedByte2 == 3;
    }
}
