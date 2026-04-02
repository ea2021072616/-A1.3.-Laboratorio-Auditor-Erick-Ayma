package z;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import d.u0;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class k extends u0 {
    public k() {
        super(12);
    }

    public static Font D(FontFamily fontFamily, int i5) {
        FontStyle fontStyle = new FontStyle((i5 & 1) != 0 ? 700 : 400, (i5 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int E = E(fontStyle, font.getStyle());
        for (int i6 = 1; i6 < fontFamily.getSize(); i6++) {
            Font font2 = fontFamily.getFont(i6);
            int E2 = E(fontStyle, font2.getStyle());
            if (E2 < E) {
                font = font2;
                E = E2;
            }
        }
        return font;
    }

    public static int E(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // d.u0
    public final e0.g A(int i5, e0.g[] gVarArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // d.u0
    public final Typeface v(Context context, y.f fVar, Resources resources, int i5) {
        y.g[] gVarArr;
        try {
            FontFamily.Builder builder = null;
            for (y.g gVar : fVar.f5546a) {
                try {
                    Font build = new Font.Builder(resources, gVar.f5552f).setWeight(gVar.f5548b).setSlant(gVar.f5549c ? 1 : 0).setTtcIndex(gVar.f5551e).setFontVariationSettings(gVar.f5550d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(D(build2, i5).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // d.u0
    public final Typeface w(Context context, e0.g[] gVarArr, int i5) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (e0.g gVar : gVarArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(gVar.f2577a, "r", null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(gVar.f2579c).setSlant(gVar.f2580d ? 1 : 0).setTtcIndex(gVar.f2578b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(D(build2, i5).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // d.u0
    public final Typeface x(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // d.u0
    public final Typeface y(Context context, Resources resources, int i5, String str, int i6) {
        try {
            Font build = new Font.Builder(resources, i5).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
