package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: t  reason: collision with root package name */
    public static final List f1375t = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    public final View f1376a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference f1377b;

    /* renamed from: j  reason: collision with root package name */
    public int f1385j;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f1392r;

    /* renamed from: s  reason: collision with root package name */
    public i0 f1393s;

    /* renamed from: c  reason: collision with root package name */
    public int f1378c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1379d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f1380e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f1381f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f1382g = -1;

    /* renamed from: h  reason: collision with root package name */
    public i1 f1383h = null;

    /* renamed from: i  reason: collision with root package name */
    public i1 f1384i = null;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f1386k = null;

    /* renamed from: l  reason: collision with root package name */
    public List f1387l = null;

    /* renamed from: m  reason: collision with root package name */
    public int f1388m = 0;

    /* renamed from: n  reason: collision with root package name */
    public y0 f1389n = null;
    public boolean o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f1390p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f1391q = -1;

    public i1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f1376a = view;
    }

    public final void a(Object obj) {
        if (obj == null) {
            b(1024);
        } else if ((1024 & this.f1385j) == 0) {
            if (this.f1386k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1386k = arrayList;
                this.f1387l = Collections.unmodifiableList(arrayList);
            }
            this.f1386k.add(obj);
        }
    }

    public final void b(int i5) {
        this.f1385j = i5 | this.f1385j;
    }

    public final int c() {
        int i5 = this.f1382g;
        return i5 == -1 ? this.f1378c : i5;
    }

    public final List d() {
        ArrayList arrayList;
        return ((this.f1385j & 1024) != 0 || (arrayList = this.f1386k) == null || arrayList.size() == 0) ? f1375t : this.f1387l;
    }

    public final boolean e() {
        View view = this.f1376a;
        return (view.getParent() == null || view.getParent() == this.f1392r) ? false : true;
    }

    public final boolean f() {
        return (this.f1385j & 1) != 0;
    }

    public final boolean g() {
        return (this.f1385j & 4) != 0;
    }

    public final boolean h() {
        if ((this.f1385j & 16) == 0) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            if (!this.f1376a.hasTransientState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        return (this.f1385j & 8) != 0;
    }

    public final boolean j() {
        return this.f1389n != null;
    }

    public final boolean k() {
        return (this.f1385j & 256) != 0;
    }

    public final void l(int i5, boolean z4) {
        if (this.f1379d == -1) {
            this.f1379d = this.f1378c;
        }
        if (this.f1382g == -1) {
            this.f1382g = this.f1378c;
        }
        if (z4) {
            this.f1382g += i5;
        }
        this.f1378c += i5;
        View view = this.f1376a;
        if (view.getLayoutParams() != null) {
            ((s0) view.getLayoutParams()).f1522c = true;
        }
    }

    public final void m() {
        if (RecyclerView.F0 && k()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.f1385j = 0;
        this.f1378c = -1;
        this.f1379d = -1;
        this.f1380e = -1L;
        this.f1382g = -1;
        this.f1388m = 0;
        this.f1383h = null;
        this.f1384i = null;
        ArrayList arrayList = this.f1386k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f1385j &= -1025;
        this.f1390p = 0;
        this.f1391q = -1;
        RecyclerView.l(this);
    }

    public final void n(boolean z4) {
        int i5 = this.f1388m;
        int i6 = z4 ? i5 - 1 : i5 + 1;
        this.f1388m = i6;
        if (i6 < 0) {
            this.f1388m = 0;
            if (RecyclerView.F0) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z4 && i6 == 1) {
            this.f1385j |= 16;
        } else if (z4 && i6 == 0) {
            this.f1385j &= -17;
        }
        if (RecyclerView.G0) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z4 + ":" + this);
        }
    }

    public final boolean o() {
        return (this.f1385j & 128) != 0;
    }

    public final boolean p() {
        return (this.f1385j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1378c + " id=" + this.f1380e + ", oldPos=" + this.f1379d + ", pLpos:" + this.f1382g);
        if (j()) {
            sb.append(" scrap ");
            sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (g()) {
            sb.append(" invalid");
        }
        if (!f()) {
            sb.append(" unbound");
        }
        boolean z4 = true;
        if ((this.f1385j & 2) != 0) {
            sb.append(" update");
        }
        if (i()) {
            sb.append(" removed");
        }
        if (o()) {
            sb.append(" ignored");
        }
        if (k()) {
            sb.append(" tmpDetached");
        }
        if (!h()) {
            sb.append(" not recyclable(" + this.f1388m + ")");
        }
        if ((this.f1385j & 512) == 0 && !g()) {
            z4 = false;
        }
        if (z4) {
            sb.append(" undefined adapter position");
        }
        if (this.f1376a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}
