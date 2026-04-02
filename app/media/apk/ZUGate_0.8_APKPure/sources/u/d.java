package u;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public a f5096a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5097b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5098c;

    /* renamed from: d  reason: collision with root package name */
    public int f5099d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5100e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5101f;

    /* renamed from: g  reason: collision with root package name */
    public int f5102g;

    /* renamed from: h  reason: collision with root package name */
    public int f5103h;

    /* renamed from: i  reason: collision with root package name */
    public int f5104i;

    /* renamed from: j  reason: collision with root package name */
    public int f5105j;

    /* renamed from: k  reason: collision with root package name */
    public View f5106k;

    /* renamed from: l  reason: collision with root package name */
    public View f5107l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5108m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5109n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public final Rect f5110p;

    public d() {
        super(-2, -2);
        this.f5097b = false;
        this.f5098c = 0;
        this.f5099d = 0;
        this.f5100e = -1;
        this.f5101f = -1;
        this.f5102g = 0;
        this.f5103h = 0;
        this.f5110p = new Rect();
    }

    public final boolean a(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                return false;
            }
            return this.o;
        }
        return this.f5109n;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar;
        this.f5097b = false;
        this.f5098c = 0;
        this.f5099d = 0;
        this.f5100e = -1;
        this.f5101f = -1;
        this.f5102g = 0;
        this.f5103h = 0;
        this.f5110p = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.a.f4978b);
        this.f5098c = obtainStyledAttributes.getInteger(0, 0);
        this.f5101f = obtainStyledAttributes.getResourceId(1, -1);
        this.f5099d = obtainStyledAttributes.getInteger(2, 0);
        this.f5100e = obtainStyledAttributes.getInteger(6, -1);
        this.f5102g = obtainStyledAttributes.getInt(5, 0);
        this.f5103h = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f5097b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f685z;
            if (TextUtils.isEmpty(string)) {
                aVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f685z;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.B;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.A);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    aVar = (a) constructor.newInstance(context, attributeSet);
                } catch (Exception e5) {
                    throw new RuntimeException("Could not inflate Behavior subclass " + string, e5);
                }
            }
            this.f5096a = aVar;
        }
        obtainStyledAttributes.recycle();
        a aVar2 = this.f5096a;
        if (aVar2 != null) {
            aVar2.g(this);
        }
    }

    public d(d dVar) {
        super((ViewGroup.MarginLayoutParams) dVar);
        this.f5097b = false;
        this.f5098c = 0;
        this.f5099d = 0;
        this.f5100e = -1;
        this.f5101f = -1;
        this.f5102g = 0;
        this.f5103h = 0;
        this.f5110p = new Rect();
    }

    public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f5097b = false;
        this.f5098c = 0;
        this.f5099d = 0;
        this.f5100e = -1;
        this.f5101f = -1;
        this.f5102g = 0;
        this.f5103h = 0;
        this.f5110p = new Rect();
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f5097b = false;
        this.f5098c = 0;
        this.f5099d = 0;
        this.f5100e = -1;
        this.f5101f = -1;
        this.f5102g = 0;
        this.f5103h = 0;
        this.f5110p = new Rect();
    }
}
