package f0;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f2721e = new byte[1792];

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f2722a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2723b;

    /* renamed from: c  reason: collision with root package name */
    public int f2724c;

    /* renamed from: d  reason: collision with root package name */
    public char f2725d;

    static {
        for (int i5 = 0; i5 < 1792; i5++) {
            f2721e[i5] = Character.getDirectionality(i5);
        }
    }

    public a(CharSequence charSequence) {
        this.f2722a = charSequence;
        this.f2723b = charSequence.length();
    }

    public final byte a() {
        CharSequence charSequence = this.f2722a;
        char charAt = charSequence.charAt(this.f2724c - 1);
        this.f2725d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f2724c);
            this.f2724c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f2724c--;
        char c5 = this.f2725d;
        return c5 < 1792 ? f2721e[c5] : Character.getDirectionality(c5);
    }
}
