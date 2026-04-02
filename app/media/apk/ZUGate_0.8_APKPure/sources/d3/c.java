package d3;

import com.google.android.material.carousel.CarouselLayoutManager;
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f2545c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i5, CarouselLayoutManager carouselLayoutManager, int i6) {
        super(i5);
        this.f2544b = i6;
        this.f2545c = carouselLayoutManager;
    }

    public final int a() {
        switch (this.f2544b) {
            case 0:
                return this.f2545c.E();
            default:
                return 0;
        }
    }

    public final int b() {
        switch (this.f2544b) {
            case 0:
                return 0;
            default:
                return this.f2545c.G();
        }
    }
}
