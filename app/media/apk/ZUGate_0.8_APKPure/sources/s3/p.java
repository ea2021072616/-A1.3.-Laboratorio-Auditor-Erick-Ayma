package s3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.i1;
/* loaded from: classes.dex */
public final class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4919a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f4920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4921c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f4922d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f4923e;

    public p(r rVar, int i5, TextView textView, int i6, TextView textView2) {
        this.f4923e = rVar;
        this.f4919a = i5;
        this.f4920b = textView;
        this.f4921c = i6;
        this.f4922d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        i1 i1Var;
        int i5 = this.f4919a;
        r rVar = this.f4923e;
        rVar.f4938n = i5;
        rVar.f4936l = null;
        TextView textView = this.f4920b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f4921c == 1 && (i1Var = rVar.f4941r) != null) {
                i1Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f4922d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f4922d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
