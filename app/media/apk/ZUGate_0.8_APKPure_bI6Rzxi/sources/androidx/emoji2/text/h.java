package androidx.emoji2.text;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import d.u0;
/* loaded from: classes.dex */
public final class h extends u0 {

    /* renamed from: i  reason: collision with root package name */
    public volatile w f763i;

    /* renamed from: j  reason: collision with root package name */
    public volatile g.f f764j;

    public h(m mVar) {
        super(22, mVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:7:0x0013, B:10:0x0018, B:12:0x001c, B:14:0x0029, B:18:0x003b, B:20:0x0043, B:22:0x0046, B:24:0x004a, B:26:0x0056, B:27:0x0059, B:30:0x0067, B:33:0x006e, B:35:0x0083, B:16:0x0031), top: B:48:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083 A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #0 {all -> 0x009a, blocks: (B:7:0x0013, B:10:0x0018, B:12:0x001c, B:14:0x0029, B:18:0x003b, B:20:0x0043, B:22:0x0046, B:24:0x004a, B:26:0x0056, B:27:0x0059, B:30:0x0067, B:33:0x006e, B:35:0x0083, B:16:0x0031), top: B:48:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence D(java.lang.CharSequence r10, int r11, int r12, boolean r13) {
        /*
            r9 = this;
            androidx.emoji2.text.w r0 = r9.f763i
            r0.getClass()
            boolean r7 = r10 instanceof androidx.emoji2.text.c0
            if (r7 == 0) goto Lf
            r1 = r10
            androidx.emoji2.text.c0 r1 = (androidx.emoji2.text.c0) r1
            r1.a()
        Lf:
            java.lang.Class<androidx.emoji2.text.e0> r1 = androidx.emoji2.text.e0.class
            if (r7 != 0) goto L31
            boolean r2 = r10 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L9a
            if (r2 == 0) goto L18
            goto L31
        L18:
            boolean r2 = r10 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L9a
            if (r2 == 0) goto L2f
            r2 = r10
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch: java.lang.Throwable -> L9a
            int r3 = r11 + (-1)
            int r4 = r12 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch: java.lang.Throwable -> L9a
            if (r2 > r12) goto L2f
            androidx.emoji2.text.g0 r2 = new androidx.emoji2.text.g0     // Catch: java.lang.Throwable -> L9a
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9a
            goto L39
        L2f:
            r2 = 0
            goto L39
        L31:
            androidx.emoji2.text.g0 r2 = new androidx.emoji2.text.g0     // Catch: java.lang.Throwable -> L9a
            r3 = r10
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> L9a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L9a
        L39:
            if (r2 == 0) goto L64
            java.lang.Object[] r1 = r2.getSpans(r11, r12, r1)     // Catch: java.lang.Throwable -> L9a
            androidx.emoji2.text.e0[] r1 = (androidx.emoji2.text.e0[]) r1     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L64
            int r3 = r1.length     // Catch: java.lang.Throwable -> L9a
            if (r3 <= 0) goto L64
            int r3 = r1.length     // Catch: java.lang.Throwable -> L9a
            r4 = 0
        L48:
            if (r4 >= r3) goto L64
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L9a
            int r6 = r2.getSpanStart(r5)     // Catch: java.lang.Throwable -> L9a
            int r8 = r2.getSpanEnd(r5)     // Catch: java.lang.Throwable -> L9a
            if (r6 == r12) goto L59
            r2.removeSpan(r5)     // Catch: java.lang.Throwable -> L9a
        L59:
            int r11 = java.lang.Math.min(r6, r11)     // Catch: java.lang.Throwable -> L9a
            int r12 = java.lang.Math.max(r8, r12)     // Catch: java.lang.Throwable -> L9a
            int r4 = r4 + 1
            goto L48
        L64:
            r3 = r12
            if (r11 == r3) goto L91
            int r12 = r10.length()     // Catch: java.lang.Throwable -> L9a
            if (r11 < r12) goto L6e
            goto L91
        L6e:
            r4 = 2147483647(0x7fffffff, float:NaN)
            androidx.emoji2.text.s r6 = new androidx.emoji2.text.s     // Catch: java.lang.Throwable -> L9a
            p3.e r12 = r0.f797a     // Catch: java.lang.Throwable -> L9a
            r6.<init>(r2, r12)     // Catch: java.lang.Throwable -> L9a
            r1 = r10
            r2 = r11
            r5 = r13
            java.lang.Object r11 = r0.c(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9a
            androidx.emoji2.text.g0 r11 = (androidx.emoji2.text.g0) r11     // Catch: java.lang.Throwable -> L9a
            if (r11 == 0) goto L8e
            android.text.Spannable r11 = r11.f762c     // Catch: java.lang.Throwable -> L9a
            if (r7 == 0) goto L8c
            androidx.emoji2.text.c0 r10 = (androidx.emoji2.text.c0) r10
            r10.b()
        L8c:
            r10 = r11
            goto L99
        L8e:
            if (r7 == 0) goto L99
            goto L93
        L91:
            if (r7 == 0) goto L99
        L93:
            r11 = r10
            androidx.emoji2.text.c0 r11 = (androidx.emoji2.text.c0) r11
            r11.b()
        L99:
            return r10
        L9a:
            r11 = move-exception
            if (r7 == 0) goto La2
            androidx.emoji2.text.c0 r10 = (androidx.emoji2.text.c0) r10
            r10.b()
        La2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.D(java.lang.CharSequence, int, int, boolean):java.lang.CharSequence");
    }

    public final void E(EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        r0.b bVar = (r0.b) this.f764j.f2877a;
        int a5 = bVar.a(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a5 != 0 ? bVar.f4467b.getInt(a5 + bVar.f4466a) : 0);
        Bundle bundle2 = editorInfo.extras;
        ((m) this.f2463h).getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}
