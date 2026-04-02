package com.fotoable.youtube.music.newplayer.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class FloatBottomCloseView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f3010a;

    public FloatBottomCloseView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_float_window_bottom_close, this);
        this.f3010a = findViewById(R.id.maxView);
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
    }

    public void a(boolean z) {
        if (z) {
            this.f3010a.setBackgroundResource(R.color.alpha_000_99);
        } else {
            this.f3010a.setBackgroundResource(R.color.alpha_000_66);
        }
    }
}
