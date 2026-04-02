package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.zzbp;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zznu extends RelativeLayout {
    private static final float[] zzbrm = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzbrn;

    public zznu(Context context, zznt zzntVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        zzbp.zzu(zzntVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzbrm, null, null));
        shapeDrawable.getPaint().setColor(zzntVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzbv.zzec().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzntVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzntVar.getText());
            textView.setTextColor(zzntVar.getTextColor());
            textView.setTextSize(zzntVar.getTextSize());
            zzjo.zzhu();
            int zzc = zzaje.zzc(context, 4);
            zzjo.zzhu();
            textView.setPadding(zzc, 0, zzaje.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zznv> zzjd = zzntVar.zzjd();
        if (zzjd != null && zzjd.size() > 1) {
            this.zzbrn = new AnimationDrawable();
            for (zznv zznvVar : zzjd) {
                try {
                    this.zzbrn.addFrame((Drawable) com.google.android.gms.dynamic.zzn.zzab(zznvVar.zzjh()), zzntVar.zzje());
                } catch (Exception e) {
                    zzafx.zzb("Error while getting drawable.", e);
                }
            }
            com.google.android.gms.ads.internal.zzbv.zzec().setBackground(imageView, this.zzbrn);
        } else if (zzjd.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) com.google.android.gms.dynamic.zzn.zzab(zzjd.get(0).zzjh()));
            } catch (Exception e2) {
                zzafx.zzb("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        if (this.zzbrn != null) {
            this.zzbrn.start();
        }
        super.onAttachedToWindow();
    }
}
