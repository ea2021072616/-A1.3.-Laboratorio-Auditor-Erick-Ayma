package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
@zzzt
/* loaded from: classes.dex */
public final class zzvv extends zzvn {
    private final NativeAppInstallAdMapper zzccz;

    public zzvv(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzccz = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getBody() {
        return this.zzccz.getBody();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getCallToAction() {
        return this.zzccz.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final Bundle getExtras() {
        return this.zzccz.getExtras();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getHeadline() {
        return this.zzccz.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final List getImages() {
        List<NativeAd.Image> images = this.zzccz.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zznv(image.getDrawable(), image.getUri(), image.getScale()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideClickHandling() {
        return this.zzccz.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideImpressionRecording() {
        return this.zzccz.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getPrice() {
        return this.zzccz.getPrice();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final double getStarRating() {
        return this.zzccz.getStarRating();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getStore() {
        return this.zzccz.getStore();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzky getVideoController() {
        if (this.zzccz.getVideoController() != null) {
            return this.zzccz.getVideoController().zzbc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void recordImpression() {
        this.zzccz.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzpc zzji() {
        NativeAd.Image icon = this.zzccz.getIcon();
        if (icon != null) {
            return new zznv(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzoy zzjn() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzccz.handleClick((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzly() {
        View adChoicesContent = this.zzccz.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return com.google.android.gms.dynamic.zzn.zzw(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzlz() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzccz.trackView((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzccz.untrackView((View) com.google.android.gms.dynamic.zzn.zzab(iObjectWrapper));
    }
}
