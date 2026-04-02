package s;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class c extends View {

    /* renamed from: g  reason: collision with root package name */
    public int[] f4644g;

    /* renamed from: h  reason: collision with root package name */
    public int f4645h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f4646i;

    /* renamed from: j  reason: collision with root package name */
    public p.k f4647j;

    /* renamed from: k  reason: collision with root package name */
    public String f4648k;

    /* renamed from: l  reason: collision with root package name */
    public String f4649l;

    /* renamed from: m  reason: collision with root package name */
    public final HashMap f4650m;

    public c(Context context) {
        super(context);
        this.f4644g = new int[32];
        this.f4650m = new HashMap();
        this.f4646i = context;
        g(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto La7
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto La7
        La:
            android.content.Context r0 = r5.f4646i
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L21
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L21:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L31
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L32
        L31:
            r1 = r2
        L32:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5b
            if (r1 == 0) goto L5b
            boolean r3 = r6 instanceof java.lang.String
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f681s
            if (r3 == 0) goto L4f
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f681s
            java.lang.Object r3 = r3.get(r6)
            goto L50
        L4f:
            r3 = r2
        L50:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5b
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5c
        L5b:
            r3 = 0
        L5c:
            if (r3 != 0) goto L64
            if (r1 == 0) goto L64
            int r3 = r5.f(r1, r6)
        L64:
            if (r3 != 0) goto L70
            java.lang.Class<s.p> r1 = s.p.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L70
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L70
        L70:
            if (r3 != 0) goto L80
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L80:
            if (r3 == 0) goto L8f
            java.util.HashMap r0 = r5.f4650m
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r6)
            r5.b(r3)
            goto La7
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not find id of \""
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = "\""
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ConstraintHelper"
            android.util.Log.w(r0, r6)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.c.a(java.lang.String):void");
    }

    public final void b(int i5) {
        if (i5 == getId()) {
            return;
        }
        int i6 = this.f4645h + 1;
        int[] iArr = this.f4644g;
        if (i6 > iArr.length) {
            this.f4644g = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4644g;
        int i7 = this.f4645h;
        iArr2[i7] = i5;
        this.f4645h = i7 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f4646i == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof e) && trim.equals(((e) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final void d(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i5 = 0; i5 < this.f4645h; i5++) {
            View view = (View) constraintLayout.f670g.get(this.f4644g[i5]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void e(ConstraintLayout constraintLayout) {
    }

    public final int f(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f4646i.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f4794b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == 35) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4648k = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f4649l = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4644g, this.f4645h);
    }

    public abstract void h(p.e eVar, boolean z4);

    public final void i() {
        if (this.f4647j == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof e) {
            ((e) layoutParams).f4682p0 = this.f4647j;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4648k;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4649l;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f4648k = str;
        if (str == null) {
            return;
        }
        int i5 = 0;
        this.f4645h = 0;
        while (true) {
            int indexOf = str.indexOf(44, i5);
            if (indexOf == -1) {
                a(str.substring(i5));
                return;
            } else {
                a(str.substring(i5, indexOf));
                i5 = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f4649l = str;
        if (str == null) {
            return;
        }
        int i5 = 0;
        this.f4645h = 0;
        while (true) {
            int indexOf = str.indexOf(44, i5);
            if (indexOf == -1) {
                c(str.substring(i5));
                return;
            } else {
                c(str.substring(i5, indexOf));
                i5 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4648k = null;
        this.f4645h = 0;
        for (int i5 : iArr) {
            b(i5);
        }
    }

    @Override // android.view.View
    public final void setTag(int i5, Object obj) {
        super.setTag(i5, obj);
        if (obj == null && this.f4648k == null) {
            b(i5);
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4644g = new int[32];
        this.f4650m = new HashMap();
        this.f4646i = context;
        g(attributeSet);
    }
}
