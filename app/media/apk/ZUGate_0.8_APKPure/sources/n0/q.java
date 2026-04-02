package n0;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class q implements ActionMode.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final ActionMode.Callback f4072a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f4073b;

    /* renamed from: c  reason: collision with root package name */
    public Class f4074c;

    /* renamed from: d  reason: collision with root package name */
    public Method f4075d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4076e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4077f = false;

    public q(ActionMode.Callback callback, TextView textView) {
        this.f4072a = callback;
        this.f4073b = textView;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f4072a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f4072a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f4072a.onDestroyActionMode(actionMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009f A[SYNTHETIC] */
    @Override // android.view.ActionMode.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onPrepareActionMode(android.view.ActionMode r14, android.view.Menu r15) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.q.onPrepareActionMode(android.view.ActionMode, android.view.Menu):boolean");
    }
}
