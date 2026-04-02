package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4637a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4638b;

    /* renamed from: c  reason: collision with root package name */
    public int f4639c;

    /* renamed from: d  reason: collision with root package name */
    public float f4640d;

    /* renamed from: e  reason: collision with root package name */
    public String f4641e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4642f;

    /* renamed from: g  reason: collision with root package name */
    public int f4643g;

    public b(String str, int i5, Object obj, boolean z4) {
        this.f4637a = false;
        this.f4638b = i5;
        this.f4637a = z4;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), q.f4796d);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        int i5 = 0;
        boolean z4 = false;
        Object obj = null;
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = obtainStyledAttributes.getIndex(i6);
            int i7 = 1;
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 10) {
                str = obtainStyledAttributes.getString(index);
                z4 = true;
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                i5 = 6;
            } else {
                int i8 = 3;
                if (index == 3) {
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else {
                    i8 = 4;
                    if (index == 2) {
                        obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                        } else {
                            i8 = 5;
                            if (index == 5) {
                                obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                                i5 = 2;
                            } else {
                                if (index == 6) {
                                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                                } else if (index == 9) {
                                    obj = obtainStyledAttributes.getString(index);
                                } else {
                                    i7 = 8;
                                    if (index == 8) {
                                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                                        if (resourceId == -1) {
                                            resourceId = obtainStyledAttributes.getInt(index, -1);
                                        }
                                        obj = Integer.valueOf(resourceId);
                                    }
                                }
                                i5 = i7;
                            }
                        }
                        i5 = 7;
                    }
                }
                i5 = i8;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new b(str, i5, obj, z4));
        }
        obtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (n.h.b(this.f4638b)) {
            case 0:
            case 7:
                this.f4639c = ((Integer) obj).intValue();
                return;
            case 1:
                this.f4640d = ((Float) obj).floatValue();
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
            case 3:
                this.f4643g = ((Integer) obj).intValue();
                return;
            case 4:
                this.f4641e = (String) obj;
                return;
            case 5:
                this.f4642f = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.f4640d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public b(b bVar, Object obj) {
        this.f4637a = false;
        bVar.getClass();
        this.f4638b = bVar.f4638b;
        b(obj);
    }
}
