package m0;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import d.u0;
import h0.d;
import h0.e;
import h0.z0;
import w.g;
/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f3925a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(InputConnection inputConnection, g gVar) {
        super(inputConnection, false);
        this.f3925a = gVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i5, Bundle bundle) {
        Bundle bundle2;
        u0 u0Var = inputContentInfo == null ? null : new u0(19, new u0(inputContentInfo));
        View view = (View) this.f3925a.f5249h;
        boolean z4 = false;
        if ((i5 & 1) != 0) {
            try {
                u0Var.e();
                Parcelable parcelable = (Parcelable) ((c) u0Var.f2463h).t();
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e5) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e5);
            }
        } else {
            bundle2 = bundle;
        }
        ClipData clipData = new ClipData(u0Var.r(), new ClipData.Item(u0Var.u()));
        d cVar = Build.VERSION.SDK_INT >= 31 ? new h0.c(clipData, 2) : new e(clipData, 2);
        cVar.c(u0Var.i());
        cVar.b(bundle2);
        if (z0.j(view, cVar.a()) == null) {
            z4 = true;
        }
        if (z4) {
            return true;
        }
        return super.commitContent(inputContentInfo, i5, bundle);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        return super.performPrivateCommand(str, bundle);
    }
}
