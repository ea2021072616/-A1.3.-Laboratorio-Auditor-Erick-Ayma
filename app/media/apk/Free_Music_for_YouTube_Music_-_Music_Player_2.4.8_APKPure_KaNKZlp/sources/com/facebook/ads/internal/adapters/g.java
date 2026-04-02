package com.facebook.ads.internal.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.NativeAd;
import java.util.List;
/* loaded from: classes.dex */
public class g extends RecyclerView.Adapter<com.facebook.ads.internal.view.g> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1177a = Color.argb(51, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private final List<NativeAd> f1178b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1179c;
    private final int d;

    public g(com.facebook.ads.internal.view.hscroll.b bVar, List<NativeAd> list) {
        float f = bVar.getContext().getResources().getDisplayMetrics().density;
        this.f1178b = list;
        this.f1179c = Math.round(f * 1.0f);
        this.d = bVar.getChildSpacing();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public com.facebook.ads.internal.view.g onCreateViewHolder(ViewGroup viewGroup, int i) {
        com.facebook.ads.internal.view.q qVar = new com.facebook.ads.internal.view.q(viewGroup.getContext());
        qVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new com.facebook.ads.internal.view.g(qVar);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(final com.facebook.ads.internal.view.g gVar, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.d * 2 : this.d, 0, i >= this.f1178b.size() + (-1) ? this.d * 2 : this.d, 0);
        gVar.f1736a.setBackgroundColor(0);
        gVar.f1736a.setImageDrawable(null);
        gVar.f1736a.setLayoutParams(marginLayoutParams);
        gVar.f1736a.setPadding(this.f1179c, this.f1179c, this.f1179c, this.f1179c);
        NativeAd nativeAd = this.f1178b.get(i);
        nativeAd.registerViewForInteraction(gVar.f1736a);
        NativeAd.Image adCoverImage = nativeAd.getAdCoverImage();
        if (adCoverImage != null) {
            com.facebook.ads.internal.util.p pVar = new com.facebook.ads.internal.util.p(gVar.f1736a);
            pVar.a(new com.facebook.ads.internal.util.q() { // from class: com.facebook.ads.internal.adapters.g.1
                @Override // com.facebook.ads.internal.util.q
                public void a() {
                    gVar.f1736a.setBackgroundColor(g.f1177a);
                }
            });
            pVar.a(adCoverImage.getUrl());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1178b.size();
    }
}
