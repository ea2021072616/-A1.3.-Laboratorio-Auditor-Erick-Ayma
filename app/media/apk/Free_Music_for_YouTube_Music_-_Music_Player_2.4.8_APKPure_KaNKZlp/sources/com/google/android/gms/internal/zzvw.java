package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzvw extends zzvq {
    private final NativeContentAdMapper zzcda;

    public zzvw(NativeContentAdMapper nativeContentAdMapper) {
        this.zzcda = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getAdvertiser() {
        return this.zzcda.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getBody() {
        return this.zzcda.getBody();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getCallToAction() {
        return this.zzcda.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final Bundle getExtras() {
        return this.zzcda.getExtras();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final String getHeadline() {
        return this.zzcda.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final List getImages() {
        List<NativeAd.Image> images = this.zzcda.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zznv(image.getDrawable(), image.getUri(), image.getScale()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final boolean getOverrideClickHandling() {
        return this.zzcda.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final boolean getOverrideImpressionRecording() {
        return this.zzcda.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzky getVideoController() {
        if (this.zzcda.getVideoController() != null) {
            return this.zzcda.getVideoController().zzbc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void recordImpression() {
        this.zzcda.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzoy zzjn() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final zzpc zzjo() {
        NativeAd.Image logo = this.zzcda.getLogo();
        if (logo != null) {
            return new zznv(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzcda.handleClick((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvp
    public final IObjectWrapper zzly() {
        View adChoicesContent = this.zzcda.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return com.google.android.gms.dynamic.zzn.zzw(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.zzvp
    public final IObjectWrapper zzlz() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzcda.trackView((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvp
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzcda.untrackView((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }
}
