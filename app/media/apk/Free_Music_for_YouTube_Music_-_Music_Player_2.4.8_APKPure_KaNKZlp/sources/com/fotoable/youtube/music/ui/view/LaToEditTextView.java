package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import com.fotoable.youtube.music.R;
import com.fotoable.youtube.music.util.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class LaToEditTextView extends AppCompatEditText {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TypeFace {
    }

    /* loaded from: classes.dex */
    public static class TypefaceValue {
        public static final int BOLD = 3;
        public static final int LIGHT = 1;
        public static final int MEDIUM = 2;
        public static final int REGULAR = 0;
    }

    public LaToEditTextView(Context context) {
        this(context, null);
    }

    public LaToEditTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaToEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Typeface typeface = null;
        if (!isInEditMode()) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LaToTextView);
                typeface = typefaceFromAttrs(context, obtainStyledAttributes);
                obtainStyledAttributes.recycle();
            }
            if (typeface == null) {
                typeface = f.a();
            }
            setTypeface(typeface);
        }
    }

    public static Typeface typefaceFromAttrs(@NonNull Context context, @NonNull TypedArray typedArray) {
        Typeface typeface = null;
        if (typedArray.hasValue(0)) {
            switch (typedArray.getInt(0, 0)) {
                case 1:
                    typeface = f.b();
                    break;
                case 2:
                default:
                    typeface = f.a();
                    break;
                case 3:
                    typeface = f.c();
                    break;
            }
        }
        if (typeface == null) {
            return f.a();
        }
        return typeface;
    }
}
