package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import e4.e;
/* loaded from: classes.dex */
public abstract class AppIntro2 extends AppIntroBase {
    private Drawable backgroundDrawable;
    private ConstraintLayout backgroundFrame;
    private Integer backgroundResource;
    private View bottomBar;
    private final int layoutId = R.layout.appintro_intro_layout2;
    private ImageButton skipImageButton;

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final Integer getBackgroundResource() {
        return this.backgroundResource;
    }

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.background);
        e.e(findViewById, "findViewById(R.id.background)");
        this.backgroundFrame = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.bottom);
        e.e(findViewById2, "findViewById(R.id.bottom)");
        this.bottomBar = findViewById2;
        View findViewById3 = findViewById(R.id.skip);
        e.e(findViewById3, "findViewById(R.id.skip)");
        this.skipImageButton = (ImageButton) findViewById3;
        if (isRtl$appintro_release()) {
            ImageButton imageButton = this.skipImageButton;
            if (imageButton != null) {
                imageButton.setScaleX(-1.0f);
            } else {
                e.a0("skipImageButton");
                throw null;
            }
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
        if (drawable != null) {
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout != null) {
                constraintLayout.setBackground(drawable);
            } else {
                e.a0("backgroundFrame");
                throw null;
            }
        }
    }

    public final void setBackgroundResource(Integer num) {
        this.backgroundResource = num;
        if (num == null || num == null) {
            return;
        }
        int intValue = num.intValue();
        ConstraintLayout constraintLayout = this.backgroundFrame;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundResource(intValue);
        } else {
            e.a0("backgroundFrame");
            throw null;
        }
    }

    public final void setBarColor(int i5) {
        View view = this.bottomBar;
        if (view != null) {
            view.setBackgroundColor(i5);
        } else {
            e.a0("bottomBar");
            throw null;
        }
    }

    public final void setImageSkipButton(Drawable drawable) {
        e.f(drawable, "imageSkipButton");
        ImageButton imageButton = this.skipImageButton;
        if (imageButton != null) {
            imageButton.setImageDrawable(drawable);
        } else {
            e.a0("skipImageButton");
            throw null;
        }
    }

    public final void setNextArrowColor(int i5) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i5);
    }

    public final void setSkipArrowColor(int i5) {
        ((ImageButton) findViewById(R.id.skip)).setColorFilter(i5);
    }
}
