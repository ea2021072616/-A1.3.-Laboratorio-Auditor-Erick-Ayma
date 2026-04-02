package s0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.m;
/* loaded from: classes.dex */
public final class k implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    public final TransformationMethod f4826a;

    public k(TransformationMethod transformationMethod) {
        this.f4826a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f4826a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || m.a().b() != 1) {
            return charSequence;
        }
        m a5 = m.a();
        a5.getClass();
        return a5.f(0, charSequence.length(), charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z4, int i5, Rect rect) {
        TransformationMethod transformationMethod = this.f4826a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z4, i5, rect);
        }
    }
}
