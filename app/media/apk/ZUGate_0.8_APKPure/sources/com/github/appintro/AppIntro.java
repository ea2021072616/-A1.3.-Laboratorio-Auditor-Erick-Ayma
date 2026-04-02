package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.appintro.internal.TypefaceContainer;
import e4.e;
/* loaded from: classes.dex */
public abstract class AppIntro extends AppIntroBase {
    private final int layoutId = R.layout.appintro_intro_layout;

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    public final void setBackArrowColor(int i5) {
        ((ImageButton) findViewById(R.id.back)).setColorFilter(i5);
    }

    public final void setBarColor(int i5) {
        findViewById(R.id.bottom).setBackgroundColor(i5);
    }

    public final void setColorDoneText(int i5) {
        ((TextView) findViewById(R.id.done)).setTextColor(i5);
    }

    public final void setColorSkipButton(int i5) {
        ((TextView) findViewById(R.id.skip)).setTextColor(i5);
    }

    public final void setDoneText(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.done);
        e.e(textView, "doneText");
        textView.setText(charSequence);
    }

    public final void setDoneTextAppearance(int i5) {
        ((TextView) findViewById(R.id.done)).setTextAppearance(i5);
    }

    public final void setDoneTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setImageNextButton(Drawable drawable) {
        e.f(drawable, "imageNextButton");
        ((ImageView) findViewById(R.id.next)).setImageDrawable(drawable);
    }

    public final void setNextArrowColor(int i5) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i5);
    }

    public final void setSeparatorColor(int i5) {
        findViewById(R.id.bottom_separator).setBackgroundColor(i5);
    }

    public final void setSkipText(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.skip);
        e.e(textView, "skipText");
        textView.setText(charSequence);
    }

    public final void setSkipTextAppearance(int i5) {
        ((TextView) findViewById(R.id.skip)).setTextAppearance(i5);
    }

    public final void setSkipTextTypeface(int i5) {
        new TypefaceContainer(null, i5).applyTo((TextView) findViewById(R.id.skip));
    }

    public final void showSeparator(boolean z4) {
        View findViewById = findViewById(R.id.bottom_separator);
        if (z4) {
            e.e(findViewById, "bottomSeparator");
            findViewById.setVisibility(0);
            return;
        }
        e.e(findViewById, "bottomSeparator");
        findViewById.setVisibility(4);
    }

    public final void setDoneText(int i5) {
        ((TextView) findViewById(R.id.done)).setText(i5);
    }

    public final void setDoneTextTypeface(int i5) {
        new TypefaceContainer(null, i5).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setSkipText(int i5) {
        ((TextView) findViewById(R.id.skip)).setText(i5);
    }

    public final void setSkipTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.skip));
    }
}
