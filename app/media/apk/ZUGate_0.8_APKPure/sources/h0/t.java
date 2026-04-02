package h0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f3205a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f3206b;

    /* renamed from: c  reason: collision with root package name */
    public final View f3207c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3208d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f3209e;

    public t(View view) {
        this.f3207c = view;
    }

    public final boolean a(float f5, float f6, boolean z4) {
        ViewParent f7;
        if (!this.f3208d || (f7 = f(0)) == null) {
            return false;
        }
        try {
            return h1.a(f7, this.f3207c, f5, f6, z4);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + f7 + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public final boolean b(float f5, float f6) {
        ViewParent f7;
        if (!this.f3208d || (f7 = f(0)) == null) {
            return false;
        }
        try {
            return h1.b(f7, this.f3207c, f5, f6);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + f7 + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public final boolean c(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        ViewParent f5;
        int i8;
        int i9;
        int[] iArr3;
        if (!this.f3208d || (f5 = f(i7)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        View view = this.f3207c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i9 = iArr2[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr == null) {
            if (this.f3209e == null) {
                this.f3209e = new int[2];
            }
            iArr3 = this.f3209e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        View view2 = this.f3207c;
        if (f5 instanceof u) {
            ((u) f5).c(view2, i5, i6, iArr3, i7);
        } else if (i7 == 0) {
            try {
                h1.c(f5, view2, i5, i6, iArr3);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + f5 + " does not implement interface method onNestedPreScroll", e5);
            }
        }
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i9;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final void d(int i5, int i6, int i7, int[] iArr) {
        e(0, i5, 0, i6, null, i7, iArr);
    }

    public final boolean e(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        ViewParent f5;
        int i10;
        int i11;
        int[] iArr3;
        if (!this.f3208d || (f5 = f(i9)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f3207c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i10 = iArr[0];
            i11 = iArr[1];
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (iArr2 == null) {
            if (this.f3209e == null) {
                this.f3209e = new int[2];
            }
            int[] iArr4 = this.f3209e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view2 = this.f3207c;
        if (f5 instanceof v) {
            ((v) f5).d(view2, i5, i6, i7, i8, i9, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i7;
            iArr3[1] = iArr3[1] + i8;
            if (f5 instanceof u) {
                ((u) f5).e(view2, i5, i6, i7, i8, i9);
            } else if (i9 == 0) {
                try {
                    h1.d(f5, view2, i5, i6, i7, i8);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + f5 + " does not implement interface method onNestedScroll", e5);
                }
            }
        }
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i10;
            iArr[1] = iArr[1] - i11;
        }
        return true;
    }

    public final ViewParent f(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                return null;
            }
            return this.f3206b;
        }
        return this.f3205a;
    }

    public final boolean g(int i5, int i6) {
        boolean f5;
        if (f(i6) != null) {
            return true;
        }
        if (this.f3208d) {
            View view = this.f3207c;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z4 = parent instanceof u;
                if (z4) {
                    f5 = ((u) parent).f(view2, view, i5, i6);
                } else {
                    if (i6 == 0) {
                        try {
                            f5 = h1.f(parent, view2, view, i5);
                        } catch (AbstractMethodError e5) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e5);
                        }
                    }
                    f5 = false;
                }
                if (f5) {
                    if (i6 == 0) {
                        this.f3205a = parent;
                    } else if (i6 == 1) {
                        this.f3206b = parent;
                    }
                    if (z4) {
                        ((u) parent).a(view2, view, i5, i6);
                    } else if (i6 == 0) {
                        try {
                            h1.e(parent, view2, view, i5);
                        } catch (AbstractMethodError e6) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e6);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
        }
        return false;
    }

    public final void h(int i5) {
        ViewParent f5 = f(i5);
        if (f5 != null) {
            boolean z4 = f5 instanceof u;
            View view = this.f3207c;
            if (z4) {
                ((u) f5).b(view, i5);
            } else if (i5 == 0) {
                try {
                    h1.g(f5, view);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + f5 + " does not implement interface method onStopNestedScroll", e5);
                }
            }
            if (i5 == 0) {
                this.f3205a = null;
            } else if (i5 != 1) {
            } else {
                this.f3206b = null;
            }
        }
    }
}
