package d;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s3;
import androidx.appcompat.widget.v2;
import com.github.appintro.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class q extends androidx.fragment.app.d0 implements r, w.i0 {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private y mDelegate;
    private Resources mResources;

    public q() {
        getSavedStateRegistry().c(DELEGATE_TAG, new o(this));
        addOnContextAvailableListener(new p(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        getDelegate().a(view, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01e5  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attachBaseContext(final android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.q.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        b supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // w.o, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        b supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i5) {
        n0 n0Var = (n0) getDelegate();
        n0Var.y();
        return (T) n0Var.f2433r.findViewById(i5);
    }

    public final void g() {
        b4.j.S(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        e4.e.f(decorView, "<this>");
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        b4.j.T(getWindow().getDecorView(), this);
        p2.a.S(getWindow().getDecorView(), this);
    }

    public y getDelegate() {
        if (this.mDelegate == null) {
            w wVar = y.f2482g;
            this.mDelegate = new n0(this, null, this, this);
        }
        return this.mDelegate;
    }

    public c getDrawerToggleDelegate() {
        n0 n0Var = (n0) getDelegate();
        n0Var.getClass();
        return new a0(n0Var, 3);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        n0 n0Var = (n0) getDelegate();
        if (n0Var.f2437v == null) {
            n0Var.D();
            b bVar = n0Var.f2436u;
            n0Var.f2437v = new g.j(bVar != null ? bVar.e() : n0Var.f2432q);
        }
        return n0Var.f2437v;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i5 = s3.f528a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public b getSupportActionBar() {
        n0 n0Var = (n0) getDelegate();
        n0Var.D();
        return n0Var.f2436u;
    }

    @Override // w.i0
    public Intent getSupportParentActivityIntent() {
        return m0.a.k(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().e();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n0 n0Var = (n0) getDelegate();
        if (n0Var.L && n0Var.F) {
            n0Var.D();
            b bVar = n0Var.f2436u;
            if (bVar != null) {
                bVar.g();
            }
        }
        androidx.appcompat.widget.y a5 = androidx.appcompat.widget.y.a();
        Context context = n0Var.f2432q;
        synchronized (a5) {
            v2 v2Var = a5.f598a;
            synchronized (v2Var) {
                l.d dVar = (l.d) v2Var.f556b.get(context);
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
        n0Var.X = new Configuration(n0Var.f2432q.getResources().getConfiguration());
        n0Var.p(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(w.j0 j0Var) {
        j0Var.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = m0.a.k(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            Context context = j0Var.f5265c;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(context.getPackageManager());
            }
            ArrayList arrayList = j0Var.f5264b;
            int size = arrayList.size();
            try {
                for (Intent l5 = m0.a.l(context, component); l5 != null; l5 = m0.a.l(context, l5.getComponent())) {
                    arrayList.add(size, l5);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e5);
            }
        }
    }

    @Override // androidx.fragment.app.d0, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().h();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        return super.onKeyDown(i5, keyEvent);
    }

    public void onLocalesChanged(d0.g gVar) {
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        b supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i5, Menu menu) {
        return super.onMenuOpened(i5, menu);
    }

    public void onNightModeChanged(int i5) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((n0) getDelegate()).y();
    }

    @Override // androidx.fragment.app.d0, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        n0 n0Var = (n0) getDelegate();
        n0Var.D();
        b bVar = n0Var.f2436u;
        if (bVar != null) {
            bVar.n(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(w.j0 j0Var) {
    }

    @Override // androidx.fragment.app.d0, android.app.Activity
    public void onStart() {
        super.onStart();
        ((n0) getDelegate()).p(true, false);
    }

    @Override // androidx.fragment.app.d0, android.app.Activity
    public void onStop() {
        super.onStop();
        n0 n0Var = (n0) getDelegate();
        n0Var.D();
        b bVar = n0Var.f2436u;
        if (bVar != null) {
            bVar.n(false);
        }
    }

    @Override // d.r
    public void onSupportActionModeFinished(g.b bVar) {
    }

    @Override // d.r
    public void onSupportActionModeStarted(g.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent != null) {
            if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
                supportNavigateUpTo(supportParentActivityIntent);
                return true;
            }
            w.j0 j0Var = new w.j0(this);
            onCreateSupportNavigateUpTaskStack(j0Var);
            onPrepareSupportNavigateUpTaskStack(j0Var);
            ArrayList arrayList = j0Var.f5264b;
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            j0Var.f5265c.startActivities(intentArr, null);
            try {
                finishAffinity();
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i5) {
        super.onTitleChanged(charSequence, i5);
        getDelegate().n(charSequence);
    }

    @Override // d.r
    public g.b onWindowStartingSupportActionMode(g.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        b supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i5) {
        g();
        getDelegate().k(i5);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        n0 n0Var = (n0) getDelegate();
        if (n0Var.f2431p instanceof Activity) {
            n0Var.D();
            b bVar = n0Var.f2436u;
            if (bVar instanceof c1) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            n0Var.f2437v = null;
            if (bVar != null) {
                bVar.h();
            }
            n0Var.f2436u = null;
            if (toolbar != null) {
                Object obj = n0Var.f2431p;
                x0 x0Var = new x0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : n0Var.f2438w, n0Var.f2434s);
                n0Var.f2436u = x0Var;
                n0Var.f2434s.f2334h = x0Var.f2476c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                n0Var.f2434s.f2334h = null;
            }
            n0Var.e();
        }
    }

    @Deprecated
    public void setSupportProgress(int i5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z4) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        super.setTheme(i5);
        ((n0) getDelegate()).Z = i5;
    }

    public g.b startSupportActionMode(g.a aVar) {
        return getDelegate().o(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().e();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i5) {
        return getDelegate().j(i5);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        g();
        getDelegate().l(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        getDelegate().m(view, layoutParams);
    }
}
