package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import java.util.Arrays;
import pub.devrel.easypermissions.b;
/* compiled from: RationaleDialogClickListener.java */
/* loaded from: classes2.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Object f5207a;

    /* renamed from: b  reason: collision with root package name */
    private d f5208b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f5209c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, d dVar, b.a aVar) {
        Object activity;
        if (fVar.getParentFragment() != null) {
            activity = fVar.getParentFragment();
        } else {
            activity = fVar.getActivity();
        }
        this.f5207a = activity;
        this.f5208b = dVar;
        this.f5209c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 11)
    public c(e eVar, d dVar, b.a aVar) {
        Object activity;
        if (Build.VERSION.SDK_INT >= 17) {
            if (eVar.getParentFragment() != null) {
                activity = eVar.getParentFragment();
            } else {
                activity = eVar.getActivity();
            }
            this.f5207a = activity;
        } else {
            this.f5207a = eVar.getActivity();
        }
        this.f5208b = dVar;
        this.f5209c = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (this.f5207a instanceof Fragment) {
                pub.devrel.easypermissions.a.f.a((Fragment) this.f5207a).a(this.f5208b.f5212c, this.f5208b.e);
                return;
            } else if (this.f5207a instanceof android.app.Fragment) {
                pub.devrel.easypermissions.a.f.a((android.app.Fragment) this.f5207a).a(this.f5208b.f5212c, this.f5208b.e);
                return;
            } else if (this.f5207a instanceof Activity) {
                pub.devrel.easypermissions.a.f.a((Activity) this.f5207a).a(this.f5208b.f5212c, this.f5208b.e);
                return;
            } else {
                throw new RuntimeException("Host must be an Activity or Fragment!");
            }
        }
        a();
    }

    private void a() {
        if (this.f5209c != null) {
            this.f5209c.b(this.f5208b.f5212c, Arrays.asList(this.f5208b.e));
        }
    }
}
