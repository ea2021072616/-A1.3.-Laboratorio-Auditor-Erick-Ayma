package y;

import android.content.res.ColorStateList;
import android.graphics.Shader;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f5543a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5544b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5545c;

    public c() {
        this.f5544b = new Object[8];
        this.f5543a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x017e, code lost:
        if (r8.size() <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0180, code lost:
        r0 = new androidx.appcompat.widget.d0(r8, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0186, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0187, code lost:
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x018a, code lost:
        if (r19 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x018c, code lost:
        r0 = new androidx.appcompat.widget.d0(r5, r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0192, code lost:
        r0 = new androidx.appcompat.widget.d0(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
        if (r11 == 1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019b, code lost:
        if (r11 == 2) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x019d, code lost:
        r16 = (int[]) r0.f306h;
        r17 = (float[]) r0.f307i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ab, code lost:
        if (r7 == 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ad, code lost:
        if (r7 == 2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01af, code lost:
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b2, code lost:
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b5, code lost:
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b7, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r25, r15, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01c4, code lost:
        r3 = new android.graphics.SweepGradient(r7, r9, (int[]) r0.f306h, (float[]) r0.f307i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01dd, code lost:
        if (r8 <= 0.0f) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01df, code lost:
        r1 = (int[]) r0.f306h;
        r21 = (float[]) r0.f307i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01ec, code lost:
        if (r7 == 1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ef, code lost:
        if (r7 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f1, code lost:
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01f4, code lost:
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f7, code lost:
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f9, code lost:
        r3 = new android.graphics.RadialGradient(r7, r9, r8, r1, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x020f, code lost:
        return new y.c(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0217, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y.c a(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.a(android.content.res.Resources, int, android.content.res.Resources$Theme):y.c");
    }

    public final boolean b() {
        if (((Shader) this.f5544b) == null) {
            Object obj = this.f5545c;
            if (((ColorStateList) obj) != null && ((ColorStateList) obj).isStateful()) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(int[] iArr) {
        if (b()) {
            ColorStateList colorStateList = (ColorStateList) this.f5545c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f5543a) {
                this.f5543a = colorForState;
                return true;
            }
        }
        return false;
    }

    public c(Shader shader, ColorStateList colorStateList, int i5) {
        this.f5544b = shader;
        this.f5545c = colorStateList;
        this.f5543a = i5;
    }
}
