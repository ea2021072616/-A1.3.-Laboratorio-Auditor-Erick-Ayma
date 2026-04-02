package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class h0 extends ImageView {

    /* renamed from: g  reason: collision with root package name */
    public final s f368g;

    /* renamed from: h  reason: collision with root package name */
    public final g0 f369h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f370i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        e3.a(context);
        this.f370i = false;
        d3.a(this, getContext());
        s sVar = new s(this);
        this.f368g = sVar;
        sVar.e(attributeSet, i5);
        g0 g0Var = new g0(this);
        this.f369h = g0Var;
        g0Var.b(attributeSet, i5);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f368g;
        if (sVar != null) {
            sVar.a();
        }
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            g0Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f368g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f368g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        f3 f3Var;
        g0 g0Var = this.f369h;
        if (g0Var == null || (f3Var = g0Var.f351b) == null) {
            return null;
        }
        return (ColorStateList) f3Var.f348c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        f3 f3Var;
        g0 g0Var = this.f369h;
        if (g0Var == null || (f3Var = g0Var.f351b) == null) {
            return null;
        }
        return (PorterDuff.Mode) f3Var.f349d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return ((this.f369h.f350a.getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f368g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f368g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            g0Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        g0 g0Var = this.f369h;
        if (g0Var != null && drawable != null && !this.f370i) {
            g0Var.f352c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (g0Var != null) {
            g0Var.a();
            if (this.f370i) {
                return;
            }
            ImageView imageView = g0Var.f350a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(g0Var.f352c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i5) {
        super.setImageLevel(i5);
        this.f370i = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            g0Var.c(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            g0Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f368g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f368g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            if (g0Var.f351b == null) {
                g0Var.f351b = new f3(0);
            }
            f3 f3Var = g0Var.f351b;
            f3Var.f348c = colorStateList;
            f3Var.f347b = true;
            g0Var.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        g0 g0Var = this.f369h;
        if (g0Var != null) {
            if (g0Var.f351b == null) {
                g0Var.f351b = new f3(0);
            }
            f3 f3Var = g0Var.f351b;
            f3Var.f349d = mode;
            f3Var.f346a = true;
            g0Var.a();
        }
    }
}
