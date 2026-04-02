package ru.zdevs.zugate;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.d;
import androidx.biometric.r;
import androidx.biometric.t;
import androidx.biometric.x;
import androidx.emoji2.text.y;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d0;
import androidx.fragment.app.w0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import com.google.android.material.snackbar.SnackbarContentLayout;
import d.j0;
import d.m;
import d.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import r3.n;
import r3.o;
import ru.zdevs.zugate.MainActivity;
import ru.zdevs.zugate.activity.BenchmarkActivity;
import ru.zdevs.zugate.activity.CreateEncFSActivity;
import ru.zdevs.zugate.activity.IntroActivity;
import ru.zdevs.zugate.activity.SettingsActivity;
import ru.zdevs.zugate.jni.MbedTLS;
import t4.g;
import t4.i;
import t4.j;
import t4.k;
import t4.p;
import v4.e;
import v4.f;
import v4.h;
import x4.a;
import x4.b;
import x4.l;
import y4.c;
@SuppressLint({"ShiftFlags"})
/* loaded from: classes.dex */
public class MainActivity extends q implements b, e, f, c {

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ int f4551q = 0;

    /* renamed from: g  reason: collision with root package name */
    public USBGateService f4552g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f4553h;

    /* renamed from: i  reason: collision with root package name */
    public final List f4554i = Collections.synchronizedList(new ArrayList(3));

    /* renamed from: j  reason: collision with root package name */
    public final x4.c f4555j = new x4.c();

    /* renamed from: k  reason: collision with root package name */
    public Uri f4556k = null;

    /* renamed from: l  reason: collision with root package name */
    public int f4557l = 100;

    /* renamed from: m  reason: collision with root package name */
    public Uri f4558m = null;

    /* renamed from: n  reason: collision with root package name */
    public y f4559n = null;
    public final j0 o = new j0(1, this);

    /* renamed from: p  reason: collision with root package name */
    public final g f4560p = new g(this);

    @Override // x4.b
    public final void a(a aVar) {
        ArrayList arrayList;
        int a5 = aVar.a();
        if (a5 == 0) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
            boolean z4 = recyclerView.getAdapter() instanceof h;
            ArrayList arrayList2 = ((j) aVar).f5063a;
            if (z4) {
                h hVar = (h) recyclerView.getAdapter();
                hVar.getClass();
                Iterator it = arrayList2.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    arrayList = hVar.f5243k;
                    if (!hasNext) {
                        break;
                    }
                    v4.b bVar = (v4.b) it.next();
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            v4.b bVar2 = (v4.b) it2.next();
                            if (bVar.f5221a.f5032f == bVar2.f5221a.f5032f) {
                                bVar.f5223c = bVar2.f5223c;
                                break;
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                hVar.f1372g.b();
            } else {
                h hVar2 = new h(this, arrayList2);
                hVar2.f5244l = this;
                hVar2.f5245m = this;
                recyclerView.setAdapter(hVar2);
                recyclerView.i(new v4.a(this));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
                linearLayoutManager.c1(1);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            int i5 = arrayList2.isEmpty() ? 0 : 8;
            findViewById(R.id.text).setVisibility(i5);
            findViewById(R.id.icon).setVisibility(i5);
        } else if (a5 != 1) {
            if (a5 == 2) {
                j();
            } else if (a5 == 3) {
                ((t4.h) aVar).f5057a.dismiss();
            } else if (a5 != 4) {
            } else {
                k kVar = (k) aVar;
                o f5 = o.f(findViewById(R.id.list), kVar.f5065b);
                if (kVar.f5066c != null) {
                    n nVar = new n(this, 1, kVar);
                    CharSequence text = f5.f4527h.getText(R.string.more);
                    Button actionView = ((SnackbarContentLayout) f5.f4528i.getChildAt(0)).getActionView();
                    if (TextUtils.isEmpty(text)) {
                        actionView.setVisibility(8);
                        actionView.setOnClickListener(null);
                        f5.B = false;
                    } else {
                        f5.B = true;
                        actionView.setVisibility(0);
                        actionView.setText(text);
                        actionView.setOnClickListener(new n(f5, 0, nVar));
                    }
                }
                f5.g();
            }
        } else {
            i iVar = (i) aVar;
            int i6 = iVar.f5060c;
            t4.a aVar2 = iVar.f5059b;
            if (i6 == -103) {
                h(aVar2, iVar.f5061d);
            } else if (i6 == 0) {
                if (iVar.f5058a != 101) {
                    j();
                    return;
                }
                String str = iVar.f5062e;
                m mVar = new m(this);
                mVar.e(R.string.technical_information);
                View inflate = getLayoutInflater().inflate(R.layout.dlg_disk_info, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.text);
                textView.setText(str);
                mVar.f(inflate);
                mVar.d(R.string.ok, null);
                t4.b bVar3 = new t4.b(0);
                d.i iVar2 = (d.i) mVar.f2398h;
                iVar2.f2349k = iVar2.f2339a.getText(R.string.copy);
                iVar2.f2350l = bVar3;
                d.n a6 = mVar.a();
                a6.setOnShowListener(new t4.c(this, aVar2, textView, 0));
                a6.show();
            }
        }
    }

    public final void h(t4.a aVar, int i5) {
        m mVar = new m(this);
        mVar.e(R.string.enter_password);
        View inflate = getLayoutInflater().inflate(R.layout.dlg_get_password, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.text);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.protect);
        final CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.savePassword);
        final Spinner spinner = (Spinner) inflate.findViewById(R.id.cipher);
        final Spinner spinner2 = (Spinner) inflate.findViewById(R.id.hash);
        if ((i5 & 1024) == 0) {
            inflate.findViewById(R.id.cipherText).setVisibility(8);
            inflate.findViewById(R.id.hashText).setVisibility(8);
            spinner.setVisibility(8);
            spinner2.setVisibility(8);
        }
        editText.setInputType(129);
        editText.setTag(aVar);
        editText.setTag(R.id.switchRW, Integer.valueOf(i5));
        if (new r(new i2.h(this, 2)).a() == 0) {
            checkBox.setVisibility(0);
            checkBox.setEnabled(false);
            checkBox2.setOnCheckedChangeListener(new f3.a(checkBox, 1));
        }
        mVar.f(inflate);
        mVar.d(R.string.ok, new DialogInterface.OnClickListener() { // from class: t4.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                int i7 = MainActivity.f4551q;
                MainActivity mainActivity = MainActivity.this;
                mainActivity.getClass();
                EditText editText2 = editText;
                int intValue = ((Integer) editText2.getTag(R.id.switchRW)).intValue();
                int i8 = 2;
                if (checkBox2.isChecked()) {
                    intValue |= 256;
                    CheckBox checkBox3 = checkBox;
                    if (checkBox3.getVisibility() == 0 && checkBox3.isChecked()) {
                        i8 = 1;
                    }
                }
                int i9 = intValue;
                int i10 = i8;
                String obj = editText2.getText().toString();
                int selectedItemPosition = spinner.getSelectedItemPosition();
                int selectedItemPosition2 = spinner2.getSelectedItemPosition();
                String u3 = b4.j.u(mainActivity);
                d.e eVar = new d.e("zugPwd0", u3);
                y4.j jVar = new y4.j(i10, eVar.g((obj.length() % 10) + obj), 0, 1, u3, selectedItemPosition, selectedItemPosition2);
                new o(mainActivity.f4554i, mainActivity.f4552g, 1, (a) editText2.getTag(), jVar, i9).b(mainActivity, mainActivity.f4555j);
            }
        });
        mVar.b(R.string.cancel, null);
        mVar.a().show();
    }

    public final void i(int i5, t4.a aVar, int i6) {
        y4.j jVar;
        y4.j v5;
        String str = null;
        if (i5 == 1) {
            int i7 = aVar.f5030d;
            if (i7 == 6 || i7 == 7 || i7 == 8 || i7 == 40 || i7 == 41 || i7 == 51) {
                if ((i6 & 512) == 0) {
                    try {
                        v5 = b4.j.v(aVar.b());
                    } catch (UnsupportedOperationException unused) {
                        j();
                        return;
                    }
                } else {
                    v5 = null;
                }
                if (v5 == null || v5.f5740b != 1) {
                    if (v5 == null || v5.f5740b != 2) {
                        h(aVar, i6);
                        return;
                    }
                    jVar = v5;
                    new t4.o(this.f4554i, this.f4552g, i5, aVar, jVar, i6).b(this, this.f4555j);
                    return;
                }
                String string = getString(R.string.biometric_verification);
                String string2 = getString(R.string.mount_device_biometric_credential);
                String string3 = getString(R.string.use_password);
                if (TextUtils.isEmpty(string)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                }
                if (!m0.a.r(0)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + String.valueOf(0));
                } else if (TextUtils.isEmpty(string3)) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty.");
                } else {
                    TextUtils.isEmpty(string3);
                    t tVar = new t(string, string2, null, string3, true, false, 0);
                    t4.f fVar = new t4.f(i6, aVar, this, v5);
                    w0 supportFragmentManager = getSupportFragmentManager();
                    ((x) new d.e(this).j(x.class)).f646d = fVar;
                    if (supportFragmentManager == null) {
                        Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
                        return;
                    } else if (supportFragmentManager.M()) {
                        Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
                        return;
                    } else {
                        androidx.biometric.o oVar = (androidx.biometric.o) supportFragmentManager.C("androidx.biometric.BiometricFragment");
                        if (oVar == null) {
                            oVar = new androidx.biometric.o();
                            androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(supportFragmentManager);
                            aVar2.c(0, oVar, "androidx.biometric.BiometricFragment", 1);
                            aVar2.f(true);
                            supportFragmentManager.x(true);
                            supportFragmentManager.D();
                        }
                        d0 a5 = oVar.a();
                        if (a5 == null) {
                            Log.e("BiometricFragment", "Not launching prompt. Client activity was null.");
                            return;
                        }
                        x xVar = oVar.f630h;
                        xVar.f647e = tVar;
                        int i8 = Build.VERSION.SDK_INT;
                        xVar.f648f = null;
                        if (oVar.j()) {
                            oVar.f630h.f652j = oVar.getString(R.string.confirm_device_credential_password);
                        } else {
                            oVar.f630h.f652j = null;
                        }
                        if (oVar.j() && new r(new i2.h(a5, 2)).a() != 0) {
                            oVar.f630h.f655m = true;
                            oVar.l();
                            return;
                        } else if (oVar.f630h.o) {
                            oVar.f629g.postDelayed(new androidx.biometric.n(oVar), 600L);
                            return;
                        } else {
                            oVar.q();
                            return;
                        }
                    }
                }
            }
        }
        if (i5 != 2) {
            jVar = null;
            new t4.o(this.f4554i, this.f4552g, i5, aVar, jVar, i6).b(this, this.f4555j);
            return;
        }
        USBGateService uSBGateService = this.f4552g;
        if (uSBGateService == null) {
            return;
        }
        t4.r i9 = uSBGateService.i(aVar.f5032f, aVar.f5034h);
        Intent h5 = i9 == null ? null : USBGateService.h(i9);
        if (h5 != null) {
            try {
                startActivity(h5);
            } catch (Throwable th) {
                str = e4.e.Z(th, h5);
            }
        } else {
            str = "Bad mount";
        }
        if (str != null) {
            o.f(findViewById(R.id.list), str).g();
        }
    }

    public final void j() {
        int i5 = 0;
        List list = this.f4554i;
        l[] lVarArr = (l[]) list.toArray(new l[0]);
        int length = lVarArr.length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            l lVar = lVarArr[i5];
            if (lVar == null || lVar.c() != 0) {
                i5++;
            } else {
                lVar.f5535d.set(true);
                x4.k kVar = lVar.f5533b;
                if (kVar != null) {
                    kVar.cancel(true);
                }
                List list2 = lVar.f5534c;
                if (list2 != null) {
                    list2.remove(lVar);
                }
            }
        }
        new p(list, this.f4552g).b(null, this.f4555j);
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        List list = this.f4554i;
        x4.c cVar = this.f4555j;
        if (i5 == 1203 || i5 == 801) {
            if (intent == null || intent.getData() == null) {
                return;
            }
            this.f4557l = i5 == 801 ? 41 : 100;
            if (this.f4552g == null) {
                this.f4556k = intent.getData();
            } else {
                new t4.n(list, this.f4552g, intent.getData(), this.f4557l).b(null, cVar);
            }
        } else if (i5 == 409) {
            if (intent == null || intent.getData() == null) {
                return;
            }
            if (this.f4552g == null) {
                this.f4558m = intent.getData();
            } else {
                new t4.m(list, this.f4552g, intent.getData()).b(null, cVar);
            }
        } else if (i5 != 1410) {
            for (Fragment fragment : getSupportFragmentManager().f1027c.f()) {
                fragment.onActivityResult(i5, i6, intent);
            }
        } else {
            t4.l lVar = new t4.l(0);
            if (!cVar.f5512a) {
                cVar.b(lVar);
                cVar.f5512a = cVar.f5514c.isEmpty();
            }
            if (cVar.f5512a) {
                cVar.f5513b.offer(lVar);
            }
        }
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i5;
        boolean equals;
        Resources resources;
        String str;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("LOCALE");
            int i6 = 0;
            while (true) {
                if (i6 >= 2) {
                    equals = "en".equals(stringExtra);
                    break;
                } else if (e4.e.f2713h[i6].equals(stringExtra)) {
                    equals = true;
                    break;
                } else {
                    i6++;
                }
            }
            if (equals && stringExtra != null && !stringExtra.isEmpty() && (resources = getResources()) != null) {
                int lastIndexOf = stringExtra.lastIndexOf(95);
                if (lastIndexOf >= 0) {
                    str = stringExtra.substring(lastIndexOf + 1);
                    stringExtra = stringExtra.substring(0, lastIndexOf);
                } else {
                    str = "";
                }
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(new Locale(stringExtra, str));
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        if (b4.j.r(this, "intro", true)) {
            startActivity(new Intent(new Intent(this, IntroActivity.class)));
            b4.j.U(this, "intro", false);
            ZApp zApp = ZApp.f4571h;
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("iv", d.e.h(12)).commit();
        }
        String s5 = b4.j.s(this);
        if (s5 == null || "1".equals(s5)) {
            y4.i iVar = new y4.i(this, false, new c2.i(this, 2, s5));
            iVar.f5734a.c(new n2.b(iVar));
        }
        if (b4.j.r(this, "use_hw", true) && ("1".equals(s5) || "2".equals(s5))) {
            int a5 = MbedTLS.a();
            ZApp zApp2 = ZApp.f4571h;
            i5 = PreferenceManager.getDefaultSharedPreferences(this).getInt("hw_config", a5);
        } else {
            i5 = 0;
        }
        MbedTLS.b(i5);
        h.f5241p = b4.j.r(this, "allow_write", false);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.hasExtra("UPDATE_LIST")) {
            return;
        }
        j();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        String str = null;
        if (itemId == R.id.add_image || itemId == R.id.add_tc_image) {
            Intent u3 = i0.u(this, "android.intent.action.OPEN_DOCUMENT");
            u3.addCategory("android.intent.category.OPENABLE");
            u3.setType("*/*");
            try {
                startActivityForResult(u3, itemId == R.id.add_image ? 1203 : 801);
            } catch (Throwable th) {
                str = e4.e.Z(th, u3);
            }
            if (str != null) {
                o.f(findViewById(R.id.list), str).g();
            }
            return true;
        } else if (itemId == R.id.add_encfs) {
            Intent u5 = i0.u(this, "android.intent.action.OPEN_DOCUMENT_TREE");
            u5.putExtra("android.intent.extra.LOCAL_ONLY", true);
            try {
                startActivityForResult(u5, 409);
            } catch (Throwable th2) {
                str = e4.e.Z(th2, u5);
            }
            if (str != null) {
                o.f(findViewById(R.id.list), str).g();
            }
            return true;
        } else if (itemId != R.id.create_encfs) {
            if (itemId == R.id.settings) {
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            } else if (itemId == R.id.benchmark) {
                startActivity(new Intent(this, BenchmarkActivity.class));
                return true;
            } else {
                return false;
            }
        } else {
            if (getResources().getBoolean(R.bool.is_tablet)) {
                new u4.j().j(getSupportFragmentManager(), "EncFS");
            } else {
                Intent intent = new Intent(this, CreateEncFSActivity.class);
                try {
                    startActivityForResult(intent, 1410);
                } catch (Throwable th3) {
                    str = e4.e.Z(th3, intent);
                }
                if (str != null) {
                    o.f(findViewById(R.id.list), str).g();
                }
            }
            return true;
        }
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (this.f4552g == null) {
            try {
                Intent intent = new Intent(this, USBGateService.class);
                startService(intent);
                bindService(intent, this.f4560p, 72);
            } catch (IllegalStateException | SecurityException unused) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.f4553h = handler;
                handler.postDelayed(new d(14, this), 500L);
            }
        }
        IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        int i5 = Build.VERSION.SDK_INT;
        j0 j0Var = this.o;
        if (i5 < 33) {
            registerReceiver(j0Var, intentFilter);
        } else {
            registerReceiver(j0Var, intentFilter, 2);
        }
        this.f4555j.a(this);
        this.f4559n = new y(this, new Handler(), 1);
        try {
            getContentResolver().registerContentObserver(DocumentsContract.buildRootsUri("ru.zdevs.zugate.usbgate"), false, this.f4559n);
        } catch (SecurityException unused2) {
            this.f4559n = null;
        }
        if (Build.VERSION.SDK_INT < 33 || checkSelfPermission("android.permission.POST_NOTIFICATIONS") != -1) {
            return;
        }
        requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 0);
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStop() {
        super.onStop();
        boolean z4 = x4.j.f5527a;
        if (z4 && z4) {
            ZApp.f4571h.unregisterReceiver(x4.j.f5529c);
            Object obj = x4.j.f5528b;
            synchronized (obj) {
                obj.notifyAll();
            }
            x4.j.f5527a = false;
        }
        x4.c cVar = this.f4555j;
        cVar.f5514c.remove(this);
        cVar.f5512a = cVar.f5514c.isEmpty();
        unregisterReceiver(this.o);
        Handler handler = this.f4553h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4553h = null;
        }
        if (this.f4552g != null) {
            unbindService(this.f4560p);
            this.f4552g = null;
        }
        if (this.f4559n != null) {
            getContentResolver().unregisterContentObserver(this.f4559n);
            this.f4559n = null;
        }
    }
}
