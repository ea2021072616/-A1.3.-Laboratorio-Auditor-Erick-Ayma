package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f437l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    public static final ConcurrentHashMap f438m = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f439a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f440b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f441c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f442d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f443e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f444f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f445g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f446h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f447i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f448j;

    /* renamed from: k  reason: collision with root package name */
    public final k1 f449k;

    public o1(TextView textView) {
        this.f447i = textView;
        this.f448j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f449k = new m1();
        } else {
            this.f449k = new k1();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f438m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e5);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, new Object[0]);
        } catch (Exception e5) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e5);
            return obj2;
        }
    }

    public final void a() {
        if (i() && this.f439a != 0) {
            if (this.f440b) {
                if (this.f447i.getMeasuredHeight() <= 0 || this.f447i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f449k.b(this.f447i) ? 1048576 : (this.f447i.getMeasuredWidth() - this.f447i.getTotalPaddingLeft()) - this.f447i.getTotalPaddingRight();
                int height = (this.f447i.getHeight() - this.f447i.getCompoundPaddingBottom()) - this.f447i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f437l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float c5 = c(rectF);
                    if (c5 != this.f447i.getTextSize()) {
                        f(0, c5);
                    }
                }
            }
            this.f440b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f444f.length;
        if (length != 0) {
            int i5 = length - 1;
            int i6 = 1;
            int i7 = 0;
            while (i6 <= i5) {
                int i8 = (i6 + i5) / 2;
                int i9 = this.f444f[i8];
                TextView textView = this.f447i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    text = transformation;
                }
                int maxLines = textView.getMaxLines();
                TextPaint textPaint = this.f446h;
                if (textPaint == null) {
                    this.f446h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f446h.set(textView.getPaint());
                this.f446h.setTextSize(i9);
                StaticLayout a5 = j1.a(text, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines, this.f447i, this.f446h, this.f449k);
                if ((maxLines == -1 || (a5.getLineCount() <= maxLines && a5.getLineEnd(a5.getLineCount() - 1) == text.length())) && ((float) a5.getHeight()) <= rectF.bottom) {
                    int i10 = i8 + 1;
                    i7 = i6;
                    i6 = i10;
                } else {
                    i7 = i8 - 1;
                    i5 = i7;
                }
            }
            return this.f444f[i7];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final void f(int i5, float f5) {
        Context context = this.f448j;
        float applyDimension = TypedValue.applyDimension(i5, f5, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f447i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f440b = false;
                try {
                    Method d5 = d("nullLayouts");
                    if (d5 != null) {
                        d5.invoke(textView, new Object[0]);
                    }
                } catch (Exception e5) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e5);
                }
                if (isInLayout) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (i() && this.f439a == 1) {
            if (!this.f445g || this.f444f.length == 0) {
                int floor = ((int) Math.floor((this.f443e - this.f442d) / this.f441c)) + 1;
                int[] iArr = new int[floor];
                for (int i5 = 0; i5 < floor; i5++) {
                    iArr[i5] = Math.round((i5 * this.f441c) + this.f442d);
                }
                this.f444f = b(iArr);
            }
            this.f440b = true;
        } else {
            this.f440b = false;
        }
        return this.f440b;
    }

    public final boolean h() {
        int[] iArr = this.f444f;
        int length = iArr.length;
        boolean z4 = length > 0;
        this.f445g = z4;
        if (z4) {
            this.f439a = 1;
            this.f442d = iArr[0];
            this.f443e = iArr[length - 1];
            this.f441c = -1.0f;
        }
        return z4;
    }

    public final boolean i() {
        return !(this.f447i instanceof a0);
    }

    public final void j(float f5, float f6, float f7) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        } else if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        } else if (f7 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        } else {
            this.f439a = 1;
            this.f442d = f5;
            this.f443e = f6;
            this.f441c = f7;
            this.f445g = false;
        }
    }
}
