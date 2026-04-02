package h1;

import android.os.Parcel;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import h0.z0;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3270a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3271b;

    /* renamed from: c  reason: collision with root package name */
    public int f3272c;

    /* renamed from: d  reason: collision with root package name */
    public Object f3273d;

    /* renamed from: e  reason: collision with root package name */
    public Object f3274e;

    public /* synthetic */ e(int i5) {
        this.f3270a = 1;
        this.f3271b = true;
        this.f3272c = 0;
    }

    public final void a(int i5) {
        switch (this.f3270a) {
            case 3:
                WeakReference weakReference = ((BottomSheetBehavior) this.f3274e).U;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f3272c = i5;
                if (this.f3271b) {
                    return;
                }
                WeakHashMap weakHashMap = z0.f3233a;
                ((View) ((BottomSheetBehavior) this.f3274e).U.get()).postOnAnimation((Runnable) this.f3273d);
                this.f3271b = true;
                return;
            default:
                WeakReference weakReference2 = ((SideSheetBehavior) this.f3274e).f2186p;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                this.f3272c = i5;
                if (this.f3271b) {
                    return;
                }
                WeakHashMap weakHashMap2 = z0.f3233a;
                ((View) ((SideSheetBehavior) this.f3274e).f2186p.get()).postOnAnimation((Runnable) this.f3273d);
                this.f3271b = true;
                return;
        }
    }

    public final void b(l2.f fVar, v2.c cVar) {
        n2.b bVar = (n2.b) ((e) this.f3274e).f3273d;
        bVar.getClass();
        n2.a aVar = (n2.a) ((n2.e) fVar).l();
        l2.k kVar = (l2.k) bVar.f4085g;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(aVar.f4488b);
        int i5 = r2.b.f4489a;
        if (kVar == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            kVar.writeToParcel(obtain, 0);
        }
        try {
            aVar.f4487a.transact(1, obtain, null, 1);
            obtain.recycle();
            v2.g gVar = cVar.f5205a;
            synchronized (gVar.f5210a) {
                gVar.a();
                gVar.f5212c = true;
                gVar.f5213d = null;
            }
            gVar.f5211b.a(gVar);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    public e(e eVar, i2.c[] cVarArr, boolean z4, int i5) {
        this.f3270a = 2;
        this.f3274e = eVar;
        this.f3273d = cVarArr;
        this.f3271b = cVarArr != null && z4;
        this.f3272c = i5;
    }

    public e(SideSheetBehavior sideSheetBehavior) {
        this.f3270a = 4;
        this.f3274e = sideSheetBehavior;
        this.f3273d = new androidx.activity.d(10, this);
    }

    public e(BottomSheetBehavior bottomSheetBehavior) {
        this.f3270a = 3;
        this.f3274e = bottomSheetBehavior;
        this.f3273d = new androidx.activity.j(17, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(BottomSheetBehavior bottomSheetBehavior, int i5) {
        this(bottomSheetBehavior);
        this.f3270a = 3;
    }
}
