package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {
    private VideoController zzbeb;
    private String zzbrq;
    private List<NativeAd.Image> zzbrr;
    private String zzbrs;
    private String zzbru;
    private String zzbse;
    private NativeAd.Image zzdim;

    public final String getAdvertiser() {
        return this.zzbse;
    }

    public final String getBody() {
        return this.zzbrs;
    }

    public final String getCallToAction() {
        return this.zzbru;
    }

    public final String getHeadline() {
        return this.zzbrq;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbrr;
    }

    public final NativeAd.Image getLogo() {
        return this.zzdim;
    }

    public final VideoController getVideoController() {
        return this.zzbeb;
    }

    public final void setAdvertiser(String str) {
        this.zzbse = str;
    }

    public final void setBody(String str) {
        this.zzbrs = str;
    }

    public final void setCallToAction(String str) {
        this.zzbru = str;
    }

    public final void setHeadline(String str) {
        this.zzbrq = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbrr = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzdim = image;
    }

    public final void zza(VideoController videoController) {
        this.zzbeb = videoController;
    }
}
