package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class LetterSpacingTextView extends LaToTextView {
    private float letterSpacing;
    private CharSequence originalText;

    public LetterSpacingTextView(Context context) {
        super(context);
        this.letterSpacing = 0.0f;
        this.originalText = "";
    }

    public LetterSpacingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.letterSpacing = 0.0f;
        this.originalText = "";
    }

    public LetterSpacingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.letterSpacing = 0.0f;
        this.originalText = "";
    }

    @Override // android.widget.TextView
    public float getLetterSpacing() {
        return this.letterSpacing;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f) {
        this.letterSpacing = f;
        applyLetterSpacing();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.originalText = charSequence;
        applyLetterSpacing();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.originalText;
    }

    private void applyLetterSpacing() {
        StringBuilder sb = new StringBuilder();
        if (this.originalText != null) {
            for (int i = 0; i < this.originalText.length(); i++) {
                sb.append(this.originalText.charAt(i));
                if (i + 1 < this.originalText.length()) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.letterSpacing + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    /* loaded from: classes.dex */
    public class LetterSpacing {
        public static final float NORMAL = 0.0f;

        public LetterSpacing() {
        }
    }
}
