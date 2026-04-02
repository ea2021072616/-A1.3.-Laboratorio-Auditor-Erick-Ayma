package com.fotoable.youtube.music.locker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class EmptyView extends RelativeLayout {
    public EmptyView(Context context) {
        super(context);
        inflate(context, R.layout.view_empty, this);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
