package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f563a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f564b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f565c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f566d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f567e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f568f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f569g;

    public /* synthetic */ w(TextView textView, int i5) {
        this.f563a = i5;
        this.f569g = textView;
    }

    public final void a() {
        TextView textView = this.f569g;
        Drawable a5 = n0.c.a((CompoundButton) textView);
        if (a5 != null) {
            if (this.f566d || this.f567e) {
                Drawable mutate = a5.mutate();
                if (this.f566d) {
                    a0.a.h(mutate, this.f564b);
                }
                if (this.f567e) {
                    a0.a.i(mutate, this.f565c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(((CompoundButton) textView).getDrawableState());
                }
                ((CompoundButton) textView).setButtonDrawable(mutate);
            }
        }
    }

    public final void b() {
        TextView textView = this.f569g;
        Drawable checkMarkDrawable = ((CheckedTextView) textView).getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f566d || this.f567e) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f566d) {
                    a0.a.h(mutate, this.f564b);
                }
                if (this.f567e) {
                    a0.a.i(mutate, this.f565c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(((CheckedTextView) textView).getDrawableState());
                }
                ((CheckedTextView) textView).setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076 A[Catch: all -> 0x0097, TryCatch #1 {all -> 0x0097, blocks: (B:6:0x0032, B:8:0x0038, B:10:0x003e, B:14:0x0053, B:16:0x0059, B:18:0x005f, B:19:0x0070, B:21:0x0076, B:22:0x0080, B:24:0x0086), top: B:59:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #1 {all -> 0x0097, blocks: (B:6:0x0032, B:8:0x0038, B:10:0x003e, B:14:0x0053, B:16:0x0059, B:18:0x005f, B:19:0x0070, B:21:0x0076, B:22:0x0080, B:24:0x0086), top: B:59:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd A[Catch: all -> 0x011e, TryCatch #3 {all -> 0x011e, blocks: (B:31:0x00b9, B:33:0x00bf, B:35:0x00c5, B:39:0x00da, B:41:0x00e0, B:43:0x00e6, B:44:0x00f7, B:46:0x00fd, B:47:0x0107, B:49:0x010d), top: B:63:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d A[Catch: all -> 0x011e, TRY_LEAVE, TryCatch #3 {all -> 0x011e, blocks: (B:31:0x00b9, B:33:0x00bf, B:35:0x00c5, B:39:0x00da, B:41:0x00e0, B:43:0x00e6, B:44:0x00f7, B:46:0x00fd, B:47:0x0107, B:49:0x010d), top: B:63:0x00b9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.util.AttributeSet r17, int r18) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.c(android.util.AttributeSet, int):void");
    }
}
