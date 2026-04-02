package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final float f4693a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4694b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4695c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4696d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4697e;

    public f(Context context, XmlResourceParser xmlResourceParser) {
        this.f4693a = Float.NaN;
        this.f4694b = Float.NaN;
        this.f4695c = Float.NaN;
        this.f4696d = Float.NaN;
        this.f4697e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), q.f4802j);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f4697e);
                this.f4697e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f4696d = obtainStyledAttributes.getDimension(index, this.f4696d);
            } else if (index == 2) {
                this.f4694b = obtainStyledAttributes.getDimension(index, this.f4694b);
            } else if (index == 3) {
                this.f4695c = obtainStyledAttributes.getDimension(index, this.f4695c);
            } else if (index == 4) {
                this.f4693a = obtainStyledAttributes.getDimension(index, this.f4693a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }
}
