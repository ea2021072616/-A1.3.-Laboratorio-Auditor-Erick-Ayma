package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.f0;
import com.github.appintro.R;
import h0.z0;
import j3.a;
import y0.b0;
/* loaded from: classes.dex */
public class CheckableImageButton extends f0 implements Checkable {

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f2167m = {16842912};

    /* renamed from: j  reason: collision with root package name */
    public boolean f2168j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2169k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2170l;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.imageButtonStyle);
        this.f2169k = true;
        this.f2170l = true;
        z0.n(this, new b0(3, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2168j;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        return this.f2168j ? View.mergeDrawableStates(super.onCreateDrawableState(i5 + 1), f2167m) : super.onCreateDrawableState(i5);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f4245b);
        setChecked(aVar.f3451d);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f3451d = this.f2168j;
        return aVar;
    }

    public void setCheckable(boolean z4) {
        if (this.f2169k != z4) {
            this.f2169k = z4;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (!this.f2169k || this.f2168j == z4) {
            return;
        }
        this.f2168j = z4;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z4) {
        this.f2170l = z4;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        if (this.f2170l) {
            super.setPressed(z4);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2168j);
    }
}
