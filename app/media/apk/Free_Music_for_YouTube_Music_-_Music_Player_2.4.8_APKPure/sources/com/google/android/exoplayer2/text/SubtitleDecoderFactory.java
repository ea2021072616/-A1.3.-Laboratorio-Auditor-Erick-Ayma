package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;
/* loaded from: classes.dex */
public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT = new SubtitleDecoderFactory() { // from class: com.google.android.exoplayer2.text.SubtitleDecoderFactory.1
        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public boolean supportsFormat(Format format) {
            return getDecoderClass(format.sampleMimeType) != null;
        }

        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public SubtitleDecoder createDecoder(Format format) {
            try {
                Class<?> decoderClass = getDecoderClass(format.sampleMimeType);
                if (decoderClass == null) {
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
                return (SubtitleDecoder) decoderClass.asSubclass(SubtitleDecoder.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error instantiating decoder", e);
            }
        }

        private Class<?> getDecoderClass(String str) {
            char c2 = 65535;
            try {
                switch (str.hashCode()) {
                    case -1004728940:
                        if (str.equals(MimeTypes.TEXT_VTT)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals(MimeTypes.APPLICATION_TX3G)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1490991545:
                        if (str.equals(MimeTypes.APPLICATION_MP4VTT)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals(MimeTypes.APPLICATION_CEA608)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals(MimeTypes.APPLICATION_SUBRIP)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals(MimeTypes.APPLICATION_TTML)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return Class.forName("com.google.android.exoplayer2.text.webvtt.WebvttDecoder");
                    case 1:
                        return Class.forName("com.google.android.exoplayer2.text.ttml.TtmlDecoder");
                    case 2:
                        return Class.forName("com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder");
                    case 3:
                        return Class.forName("com.google.android.exoplayer2.text.subrip.SubripDecoder");
                    case 4:
                        return Class.forName("com.google.android.exoplayer2.text.tx3g.Tx3gDecoder");
                    case 5:
                        return Class.forName("com.google.android.exoplayer2.text.cea.Cea608Decoder");
                    default:
                        return null;
                }
            } catch (ClassNotFoundException e) {
                return null;
            }
        }
    };

    SubtitleDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
