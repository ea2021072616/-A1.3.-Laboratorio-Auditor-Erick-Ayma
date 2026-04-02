package ru.zdevs.zugate.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.d0;
import androidx.fragment.app.w0;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import d.b;
import d.j;
import d.n;
import d.q;
import ru.zdevs.zugate.MainActivityUSB;
import ru.zdevs.zugate.USBGateProvider;
import ru.zdevs.zugate.ZApp;
import ru.zdevs.zugate.activity.SettingsActivity;
import ru.zdevs.zugate.activity.WebViewActivity;
import ru.zdevs.zugate.jni.MbedTLS;
import u4.l;
import v4.h;
import y0.a0;
import y0.m;
import y0.s;
import y0.w;
import y4.i;
/* loaded from: classes.dex */
public class SettingsActivity extends q implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public i f4588g;

    /* loaded from: classes.dex */
    public static class a extends s {

        /* renamed from: p  reason: collision with root package name */
        public static final /* synthetic */ int f4589p = 0;
        public int o = 0;

        @Override // y0.s
        public final void h(String str) {
            boolean z4;
            a0 a0Var = this.f5637h;
            if (a0Var == null) {
                throw new RuntimeException("This should be called after super.onCreate.");
            }
            Context requireContext = requireContext();
            a0Var.f5588e = true;
            w wVar = new w(requireContext, a0Var);
            XmlResourceParser xml = requireContext.getResources().getXml(R.xml.preferences);
            try {
                PreferenceGroup c5 = wVar.c(xml);
                xml.close();
                PreferenceScreen preferenceScreen = (PreferenceScreen) c5;
                preferenceScreen.l(a0Var);
                SharedPreferences.Editor editor = a0Var.f5587d;
                if (editor != null) {
                    editor.apply();
                }
                a0Var.f5588e = false;
                PreferenceScreen preferenceScreen2 = preferenceScreen;
                if (str != null) {
                    Preference A = preferenceScreen.A(str);
                    boolean z5 = A instanceof PreferenceScreen;
                    preferenceScreen2 = A;
                    if (!z5) {
                        throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
                    }
                }
                PreferenceScreen preferenceScreen3 = preferenceScreen2;
                a0 a0Var2 = this.f5637h;
                PreferenceScreen preferenceScreen4 = a0Var2.f5590g;
                if (preferenceScreen3 != preferenceScreen4) {
                    if (preferenceScreen4 != null) {
                        preferenceScreen4.o();
                    }
                    a0Var2.f5590g = preferenceScreen3;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4 && preferenceScreen3 != null) {
                    this.f5639j = true;
                    if (this.f5640k) {
                        j jVar = this.f5642m;
                        if (!jVar.hasMessages(1)) {
                            jVar.obtainMessage(1).sendToTarget();
                        }
                    }
                }
                g("oss").f1182g = new m(this) { // from class: u4.k

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ SettingsActivity.a f5169h;

                    {
                        this.f5169h = this;
                    }

                    @Override // y0.m
                    public final void c(Preference preference) {
                        int i5 = r2;
                        SettingsActivity.a aVar = this.f5169h;
                        switch (i5) {
                            case 0:
                                int i6 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                Intent intent = new Intent(aVar.getContext(), WebViewActivity.class);
                                intent.putExtra(AppIntroBaseFragmentKt.ARG_TITLE, aVar.getString(R.string.oss));
                                intent.putExtra("url", "file:///android_asset/oss.html");
                                intent.putExtra("nwrap", true);
                                aVar.startActivity(intent);
                                return;
                            case 1:
                                int i7 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                aVar.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://zdevs.ru/zugate/user_guide.html")));
                                return;
                            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                int i8 = SettingsActivity.a.f4589p;
                                d0 a5 = aVar.a();
                                if (a5 instanceof SettingsActivity) {
                                    ((SettingsActivity) a5).f4588g = new y4.i(a5, true, new ru.zdevs.zugate.activity.a(aVar));
                                    y4.i iVar = ((SettingsActivity) a5).f4588g;
                                    Activity activity = iVar.f5735b;
                                    View inflate = LayoutInflater.from(activity).inflate(R.layout.dlg_progress, (ViewGroup) null);
                                    ((TextView) inflate.findViewById(R.id.text)).setText(R.string.send_request_to_server);
                                    ((ProgressBar) inflate.findViewById(R.id.progress_horizontal)).setIndeterminate(true);
                                    d.m mVar = new d.m(activity);
                                    mVar.e(R.string.app_name);
                                    mVar.f(inflate);
                                    ((d.i) mVar.f2398h).f2352n = new y4.f(iVar);
                                    n a6 = mVar.a();
                                    a6.show();
                                    iVar.f5734a.c(new androidx.appcompat.widget.d0(iVar, a6, 27));
                                    return;
                                }
                                return;
                            default:
                                int i9 = aVar.o + 1;
                                aVar.o = i9;
                                if (i9 > 12) {
                                    SettingsActivity.h(aVar, false);
                                    return;
                                }
                                return;
                        }
                    }
                };
                g("user_guide").f1182g = new m(this) { // from class: u4.k

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ SettingsActivity.a f5169h;

                    {
                        this.f5169h = this;
                    }

                    @Override // y0.m
                    public final void c(Preference preference) {
                        int i5 = r2;
                        SettingsActivity.a aVar = this.f5169h;
                        switch (i5) {
                            case 0:
                                int i6 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                Intent intent = new Intent(aVar.getContext(), WebViewActivity.class);
                                intent.putExtra(AppIntroBaseFragmentKt.ARG_TITLE, aVar.getString(R.string.oss));
                                intent.putExtra("url", "file:///android_asset/oss.html");
                                intent.putExtra("nwrap", true);
                                aVar.startActivity(intent);
                                return;
                            case 1:
                                int i7 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                aVar.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://zdevs.ru/zugate/user_guide.html")));
                                return;
                            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                int i8 = SettingsActivity.a.f4589p;
                                d0 a5 = aVar.a();
                                if (a5 instanceof SettingsActivity) {
                                    ((SettingsActivity) a5).f4588g = new y4.i(a5, true, new ru.zdevs.zugate.activity.a(aVar));
                                    y4.i iVar = ((SettingsActivity) a5).f4588g;
                                    Activity activity = iVar.f5735b;
                                    View inflate = LayoutInflater.from(activity).inflate(R.layout.dlg_progress, (ViewGroup) null);
                                    ((TextView) inflate.findViewById(R.id.text)).setText(R.string.send_request_to_server);
                                    ((ProgressBar) inflate.findViewById(R.id.progress_horizontal)).setIndeterminate(true);
                                    d.m mVar = new d.m(activity);
                                    mVar.e(R.string.app_name);
                                    mVar.f(inflate);
                                    ((d.i) mVar.f2398h).f2352n = new y4.f(iVar);
                                    n a6 = mVar.a();
                                    a6.show();
                                    iVar.f5734a.c(new androidx.appcompat.widget.d0(iVar, a6, 27));
                                    return;
                                }
                                return;
                            default:
                                int i9 = aVar.o + 1;
                                aVar.o = i9;
                                if (i9 > 12) {
                                    SettingsActivity.h(aVar, false);
                                    return;
                                }
                                return;
                        }
                    }
                };
                g("donate").f1182g = new m(this) { // from class: u4.k

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ SettingsActivity.a f5169h;

                    {
                        this.f5169h = this;
                    }

                    @Override // y0.m
                    public final void c(Preference preference) {
                        int i5 = r2;
                        SettingsActivity.a aVar = this.f5169h;
                        switch (i5) {
                            case 0:
                                int i6 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                Intent intent = new Intent(aVar.getContext(), WebViewActivity.class);
                                intent.putExtra(AppIntroBaseFragmentKt.ARG_TITLE, aVar.getString(R.string.oss));
                                intent.putExtra("url", "file:///android_asset/oss.html");
                                intent.putExtra("nwrap", true);
                                aVar.startActivity(intent);
                                return;
                            case 1:
                                int i7 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                aVar.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://zdevs.ru/zugate/user_guide.html")));
                                return;
                            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                int i8 = SettingsActivity.a.f4589p;
                                d0 a5 = aVar.a();
                                if (a5 instanceof SettingsActivity) {
                                    ((SettingsActivity) a5).f4588g = new y4.i(a5, true, new ru.zdevs.zugate.activity.a(aVar));
                                    y4.i iVar = ((SettingsActivity) a5).f4588g;
                                    Activity activity = iVar.f5735b;
                                    View inflate = LayoutInflater.from(activity).inflate(R.layout.dlg_progress, (ViewGroup) null);
                                    ((TextView) inflate.findViewById(R.id.text)).setText(R.string.send_request_to_server);
                                    ((ProgressBar) inflate.findViewById(R.id.progress_horizontal)).setIndeterminate(true);
                                    d.m mVar = new d.m(activity);
                                    mVar.e(R.string.app_name);
                                    mVar.f(inflate);
                                    ((d.i) mVar.f2398h).f2352n = new y4.f(iVar);
                                    n a6 = mVar.a();
                                    a6.show();
                                    iVar.f5734a.c(new androidx.appcompat.widget.d0(iVar, a6, 27));
                                    return;
                                }
                                return;
                            default:
                                int i9 = aVar.o + 1;
                                aVar.o = i9;
                                if (i9 > 12) {
                                    SettingsActivity.h(aVar, false);
                                    return;
                                }
                                return;
                        }
                    }
                };
                Preference g5 = g("app_name");
                String str2 = getString(R.string.app_name) + " 0.8";
                if (!TextUtils.equals(str2, g5.f1184i)) {
                    g5.f1184i = str2;
                    g5.i();
                }
                g5.f1182g = new m(this) { // from class: u4.k

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ SettingsActivity.a f5169h;

                    {
                        this.f5169h = this;
                    }

                    @Override // y0.m
                    public final void c(Preference preference) {
                        int i5 = r2;
                        SettingsActivity.a aVar = this.f5169h;
                        switch (i5) {
                            case 0:
                                int i6 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                Intent intent = new Intent(aVar.getContext(), WebViewActivity.class);
                                intent.putExtra(AppIntroBaseFragmentKt.ARG_TITLE, aVar.getString(R.string.oss));
                                intent.putExtra("url", "file:///android_asset/oss.html");
                                intent.putExtra("nwrap", true);
                                aVar.startActivity(intent);
                                return;
                            case 1:
                                int i7 = SettingsActivity.a.f4589p;
                                aVar.getClass();
                                aVar.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://zdevs.ru/zugate/user_guide.html")));
                                return;
                            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                int i8 = SettingsActivity.a.f4589p;
                                d0 a5 = aVar.a();
                                if (a5 instanceof SettingsActivity) {
                                    ((SettingsActivity) a5).f4588g = new y4.i(a5, true, new ru.zdevs.zugate.activity.a(aVar));
                                    y4.i iVar = ((SettingsActivity) a5).f4588g;
                                    Activity activity = iVar.f5735b;
                                    View inflate = LayoutInflater.from(activity).inflate(R.layout.dlg_progress, (ViewGroup) null);
                                    ((TextView) inflate.findViewById(R.id.text)).setText(R.string.send_request_to_server);
                                    ((ProgressBar) inflate.findViewById(R.id.progress_horizontal)).setIndeterminate(true);
                                    d.m mVar = new d.m(activity);
                                    mVar.e(R.string.app_name);
                                    mVar.f(inflate);
                                    ((d.i) mVar.f2398h).f2352n = new y4.f(iVar);
                                    n a6 = mVar.a();
                                    a6.show();
                                    iVar.f5734a.c(new androidx.appcompat.widget.d0(iVar, a6, 27));
                                    return;
                                }
                                return;
                            default:
                                int i9 = aVar.o + 1;
                                aVar.o = i9;
                                if (i9 > 12) {
                                    SettingsActivity.h(aVar, false);
                                    return;
                                }
                                return;
                        }
                    }
                };
                String s5 = b4.j.s(getContext());
                boolean z6 = MbedTLS.a() != 0;
                if (!z6 || (!"1".equals(s5) && !"2".equals(s5))) {
                    Preference g6 = g("hw_use");
                    if (g6.f1191q) {
                        g6.f1191q = false;
                        g6.j(g6.y());
                        g6.i();
                    }
                    if (z6) {
                        g6.x(getString(R.string.donate_only));
                    }
                }
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) g("allow_write");
                switchPreferenceCompat.f1181f = new l(this, switchPreferenceCompat, 0);
                SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) g("allow_root");
                switchPreferenceCompat2.f1181f = new l(this, switchPreferenceCompat2, 1);
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
        }
    }

    public static void h(a aVar, boolean z4) {
        Context context = aVar.getContext();
        b4.j.V(context, z4 ? "1" : "2");
        if (MbedTLS.a() != 0) {
            b4.j.U(context, "hw_use", true);
        }
        Preference g5 = aVar.g("hw_use");
        if (!g5.f1191q) {
            g5.f1191q = true;
            g5.j(g5.y());
            g5.i();
        }
        g5.x(null);
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        i iVar = this.f4588g;
        if (iVar != null) {
            iVar.getClass();
        }
        super.onActivityResult(i6, i6, intent);
    }

    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.settings_activity);
        if (bundle == null) {
            w0 supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(supportFragmentManager);
            aVar.c(R.id.settings, new a(), null, 2);
            aVar.f(false);
        }
        b supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.m(true);
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return false;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("usb_startup".equals(str)) {
            boolean z4 = sharedPreferences.getBoolean(str, true);
            ZApp zApp = ZApp.f4571h;
            PackageManager packageManager = zApp.getPackageManager();
            if (packageManager == null) {
                return;
            }
            packageManager.setComponentEnabledSetting(new ComponentName(zApp, MainActivityUSB.class), z4 ? 1 : 2, 1);
        } else if ("group_storage".equals(str)) {
            String[] strArr = USBGateProvider.f4561i;
            ContentResolver a5 = ZApp.a();
            if (a5 != null) {
                a5.notifyChange(DocumentsContract.buildRootsUri("ru.zdevs.zugate.usbgate"), (ContentObserver) null, 16);
            }
        } else {
            if ("allow_write".equals(str)) {
                h.f5241p = sharedPreferences.getBoolean(str, false);
            } else if ("hw_config".equals(str)) {
                MbedTLS.b(sharedPreferences.getInt("hw_config", MbedTLS.a()));
            } else if ("hw_use".equals(str)) {
                MbedTLS.b(sharedPreferences.getBoolean("use_hw", true) ? sharedPreferences.getInt("hw_config", MbedTLS.a()) : 0);
            }
        }
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStart() {
        super.onStart();
        getSharedPreferences(a0.a(this), 0).registerOnSharedPreferenceChangeListener(this);
    }

    @Override // d.q, androidx.fragment.app.d0, android.app.Activity
    public final void onStop() {
        super.onStop();
        getSharedPreferences(a0.a(this), 0).unregisterOnSharedPreferenceChangeListener(this);
    }
}
