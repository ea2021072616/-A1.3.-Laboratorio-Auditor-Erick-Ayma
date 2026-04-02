package com.facebook.ads;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAdView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1085a;

    /* renamed from: b  reason: collision with root package name */
    private final NativeAdsManager f1086b;

    /* renamed from: c  reason: collision with root package name */
    private final AdViewProvider f1087c;
    private final NativeAdView.Type d;
    private final int e;
    private final b f;
    private final NativeAdViewAttributes g;

    /* loaded from: classes.dex */
    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i);

        void destroyView(NativeAd nativeAd, View view);
    }

    /* loaded from: classes.dex */
    private class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private List<NativeAd> f1089b = new ArrayList();

        public a() {
        }

        public void a() {
            this.f1089b.clear();
            int min = Math.min(NativeAdScrollView.this.e, NativeAdScrollView.this.f1086b.getUniqueNativeAdCount());
            for (int i = 0; i < min; i++) {
                NativeAd nextNativeAd = NativeAdScrollView.this.f1086b.nextNativeAd();
                nextNativeAd.a(true);
                this.f1089b.add(nextNativeAd);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < this.f1089b.size()) {
                if (NativeAdScrollView.this.d != null) {
                    this.f1089b.get(i).unregisterView();
                } else {
                    NativeAdScrollView.this.f1087c.destroyView(this.f1089b.get(i), (View) obj);
                }
            }
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.f1089b.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.f1089b.indexOf(obj);
            if (indexOf >= 0) {
                return indexOf;
            }
            return -2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View render = NativeAdScrollView.this.d != null ? NativeAdView.render(NativeAdScrollView.this.f1085a, this.f1089b.get(i), NativeAdScrollView.this.d, NativeAdScrollView.this.g) : NativeAdScrollView.this.f1087c.createView(this.f1089b.get(i), i);
            viewGroup.addView(render);
            return render;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ViewPager {
        public b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.view.ViewPager, android.view.View
        public void onMeasure(int i, int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i) {
        this(context, nativeAdsManager, adViewProvider, null, null, i);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        super(context);
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException("NativeAdsManager not loaded");
        }
        if (type == null && adViewProvider == null) {
            throw new IllegalArgumentException("Must provide a NativeAdView.Type or AdViewProvider");
        }
        this.f1085a = context;
        this.f1086b = nativeAdsManager;
        this.g = nativeAdViewAttributes;
        this.f1087c = adViewProvider;
        this.d = type;
        this.e = i;
        a aVar = new a();
        this.f = new b(context);
        this.f.setAdapter(aVar);
        setInset(20);
        aVar.a();
        addView(this.f);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type) {
        this(context, nativeAdsManager, null, type, new NativeAdViewAttributes(), 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, i);
    }

    public void setInset(int i) {
        if (i > 0) {
            DisplayMetrics displayMetrics = this.f1085a.getResources().getDisplayMetrics();
            int round = Math.round(i * displayMetrics.density);
            this.f.setPadding(round, 0, round, 0);
            this.f.setPageMargin(Math.round(displayMetrics.density * (i / 2)));
            this.f.setClipToPadding(false);
        }
    }
}
