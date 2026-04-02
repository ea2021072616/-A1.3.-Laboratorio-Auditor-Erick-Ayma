package androidx.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.view.View;
import androidx.recyclerview.widget.b0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.u0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f56b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f58d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f59e;

    public /* synthetic */ h(int i5, int i6, Object obj, Object obj2) {
        this.f56b = i6;
        this.f58d = obj;
        this.f59e = obj2;
        this.f57c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.c cVar;
        int i5 = this.f56b;
        int i6 = 0;
        Object obj = this.f58d;
        int i7 = this.f57c;
        Object obj2 = this.f59e;
        switch (i5) {
            case 0:
                i iVar = (i) obj;
                Object obj3 = ((b0) obj2).f1296g;
                String str = (String) iVar.f92a.get(Integer.valueOf(i7));
                if (str == null) {
                    return;
                }
                androidx.activity.result.f fVar = (androidx.activity.result.f) iVar.f96e.get(str);
                if (fVar == null || (cVar = fVar.f88a) == null) {
                    iVar.f98g.remove(str);
                    iVar.f97f.put(str, obj3);
                    return;
                } else if (iVar.f95d.remove(str)) {
                    cVar.a(obj3);
                    return;
                } else {
                    return;
                }
            case 1:
                ((i) obj).a(i7, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj2));
                return;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                String[] strArr = (String[]) obj2;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                while (i6 < length) {
                    iArr[i6] = packageManager.checkPermission(strArr[i6], packageName);
                    i6++;
                }
                ((w.e) activity).onRequestPermissionsResult(i7, strArr, iArr);
                return;
            case 3:
                y.n nVar = (y.n) ((u0) obj2).f2463h;
                if (nVar != null) {
                    nVar.onFontRetrievalFailed(i7);
                    return;
                }
                return;
            case 4:
                List list = (List) obj2;
                int size = list.size();
                if (i7 != 1) {
                    while (i6 < size) {
                        ((androidx.emoji2.text.k) list.get(i6)).a();
                        i6++;
                    }
                    return;
                }
                while (i6 < size) {
                    ((androidx.emoji2.text.k) list.get(i6)).b();
                    i6++;
                }
                return;
            default:
                ((BottomSheetBehavior) obj).K((View) obj2, i7, false);
                return;
        }
    }

    public /* synthetic */ h(i iVar, int i5, Object obj, int i6) {
        this.f56b = i6;
        this.f58d = iVar;
        this.f57c = i5;
        this.f59e = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(androidx.emoji2.text.k r3, int r4) {
        /*
            r2 = this;
            r0 = 4
            r2.f56b = r0
            r0 = 1
            androidx.emoji2.text.k[] r0 = new androidx.emoji2.text.k[r0]
            if (r3 == 0) goto L14
            r1 = 0
            r0[r1] = r3
            java.util.List r3 = java.util.Arrays.asList(r0)
            r0 = 0
            r2.<init>(r3, r4, r0)
            return
        L14:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "initCallback cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.h.<init>(androidx.emoji2.text.k, int):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(int i5, ArrayList arrayList) {
        this(arrayList, i5, null);
        this.f56b = 4;
    }

    public h(List list, int i5, Throwable th) {
        this.f56b = 4;
        if (list != null) {
            this.f59e = new ArrayList(list);
            this.f57c = i5;
            this.f58d = th;
            return;
        }
        throw new NullPointerException("initCallbacks cannot be null");
    }
}
