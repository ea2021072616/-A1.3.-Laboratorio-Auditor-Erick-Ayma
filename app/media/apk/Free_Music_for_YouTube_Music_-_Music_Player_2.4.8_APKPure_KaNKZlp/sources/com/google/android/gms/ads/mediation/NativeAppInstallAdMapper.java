package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* loaded from: classes.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private VideoController zzbeb;
    private String zzbrq;
    private List<NativeAd.Image> zzbrr;
    private String zzbrs;
    private String zzbru;
    private double zzbrv;
    private String zzbrw;
    private String zzbrx;
    private NativeAd.Image zzdil;

    public final String getBody() {
        return this.zzbrs;
    }

    public final String getCallToAction() {
        return this.zzbru;
    }

    public final String getHeadline() {
        return this.zzbrq;
    }

    public final NativeAd.Image getIcon() {
        return this.zzdil;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbrr;
    }

    public final String getPrice() {
        return this.zzbrx;
    }

    public final double getStarRating() {
        return this.zzbrv;
    }

    public final String getStore() {
        return this.zzbrw;
    }

    public final VideoController getVideoController() {
        return this.zzbeb;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzdil = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbrr = list;
    }

    public final void setPrice(String str) {
        this.zzbrx = str;
    }

    public final void setStarRating(double d) {
        this.zzbrv = d;
    }

    public final void setStore(String str) {
        this.zzbrw = str;
    }

    public final void zza(VideoController videoController) {
        this.zzbeb = videoController;
    }
}
