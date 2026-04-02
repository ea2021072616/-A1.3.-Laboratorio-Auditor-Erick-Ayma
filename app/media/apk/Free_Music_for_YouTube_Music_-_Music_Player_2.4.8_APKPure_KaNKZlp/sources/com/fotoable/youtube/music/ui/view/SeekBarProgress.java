package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
/* loaded from: classes.dex */
public class SeekBarProgress extends SeekBar {
    private boolean isDrag;

    public SeekBarProgress(Context context) {
        super(context);
        this.isDrag = true;
    }

    public SeekBarProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDrag = true;
    }

    public SeekBarProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDrag = true;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isDrag) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setDrag(boolean z) {
        this.isDrag = z;
    }
}
