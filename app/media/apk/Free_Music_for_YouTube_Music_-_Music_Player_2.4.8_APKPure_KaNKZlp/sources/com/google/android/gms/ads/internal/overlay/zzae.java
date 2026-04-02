package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
public final class zzae extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzchz;
    private final zzaj zzcia;

    public zzae(Context context, zzaf zzafVar, zzaj zzajVar) {
        super(context);
        this.zzcia = zzajVar;
        setOnClickListener(this);
        this.zzchz = new ImageButton(context);
        this.zzchz.setImageResource(17301527);
        this.zzchz.setBackgroundColor(0);
        this.zzchz.setOnClickListener(this);
        ImageButton imageButton = this.zzchz;
        zzjo.zzhu();
        int zzc = zzaje.zzc(context, zzafVar.paddingLeft);
        zzjo.zzhu();
        int zzc2 = zzaje.zzc(context, 0);
        zzjo.zzhu();
        int zzc3 = zzaje.zzc(context, zzafVar.paddingRight);
        zzjo.zzhu();
        imageButton.setPadding(zzc, zzc2, zzc3, zzaje.zzc(context, zzafVar.paddingBottom));
        this.zzchz.setContentDescription("Interstitial close button");
        zzjo.zzhu();
        zzaje.zzc(context, zzafVar.size);
        ImageButton imageButton2 = this.zzchz;
        zzjo.zzhu();
        int zzc4 = zzaje.zzc(context, zzafVar.size + zzafVar.paddingLeft + zzafVar.paddingRight);
        zzjo.zzhu();
        addView(imageButton2, new FrameLayout.LayoutParams(zzc4, zzaje.zzc(context, zzafVar.size + zzafVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zzcia != null) {
            this.zzcia.zzmm();
        }
    }

    public final void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzchz.setVisibility(0);
        } else if (z) {
            this.zzchz.setVisibility(4);
        } else {
            this.zzchz.setVisibility(8);
        }
    }
}
