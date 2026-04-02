package ru.zdevs.zugate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w0;
import com.github.appintro.R;
import d.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u4.j;
import x4.b;
import x4.c;
/* loaded from: classes.dex */
public class CreateEncFSActivity extends q implements b {

    /* renamed from: g  reason: collision with root package name */
    public final List f4586g = Collections.synchronizedList(new ArrayList(1));

    /* renamed from: h  reason: collision with root package name */
    public final c f4587h = new c();

    @Override // x4.b
    public final void a(x4.a aVar) {
        if (aVar.a() == 2) {
            setResult(-1);
            finish();
        }
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        for (Fragment fragment : getSupportFragmentManager().f1027c.f()) {
            fragment.onActivityResult(i5, i6, intent);
        }
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_encfs);
        d.b supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.m(true);
        }
        w0 supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(supportFragmentManager);
        aVar.c(R.id.main_frame, new j(), null, 1);
        aVar.f(false);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return false;
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f4587h.a(this);
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStop() {
        super.onStop();
        c cVar = this.f4587h;
        cVar.f5514c.remove(this);
        cVar.f5512a = cVar.f5514c.isEmpty();
    }
}
