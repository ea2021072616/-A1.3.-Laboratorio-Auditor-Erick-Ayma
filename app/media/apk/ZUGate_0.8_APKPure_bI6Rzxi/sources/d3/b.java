package d3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o0;
import com.github.appintro.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class b extends o0 {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f2542a;

    /* renamed from: b  reason: collision with root package name */
    public List f2543b;

    public b() {
        Paint paint = new Paint();
        this.f2542a = paint;
        this.f2543b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.o0
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        int D;
        int i5;
        Paint paint = this.f2542a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (f fVar : this.f2543b) {
            fVar.getClass();
            ThreadLocal threadLocal = z.a.f5747a;
            float f5 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f5)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f5)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f5)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f5))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).G0()) {
                fVar.getClass();
                float b5 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2077q.b();
                fVar.getClass();
                c cVar = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2077q;
                int i6 = cVar.f2544b;
                CarouselLayoutManager carouselLayoutManager = cVar.f2545c;
                switch (i6) {
                    case 0:
                        D = carouselLayoutManager.o;
                        break;
                    default:
                        D = carouselLayoutManager.o - carouselLayoutManager.D();
                        break;
                }
                canvas.drawLine(0.0f, b5, 0.0f, D, paint);
            } else {
                float a5 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2077q.a();
                fVar.getClass();
                c cVar2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2077q;
                int i7 = cVar2.f2544b;
                CarouselLayoutManager carouselLayoutManager2 = cVar2.f2545c;
                switch (i7) {
                    case 0:
                        i5 = carouselLayoutManager2.f1509n - carouselLayoutManager2.F();
                        break;
                    default:
                        i5 = carouselLayoutManager2.f1509n;
                        break;
                }
                fVar.getClass();
                canvas.drawLine(a5, 0.0f, i5, 0.0f, paint);
            }
        }
    }
}
