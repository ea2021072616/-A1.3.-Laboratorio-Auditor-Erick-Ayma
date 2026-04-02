package com.fotoable.youtube.music;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import b.a.a.a.c;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.flurry.android.FlurryAgent;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.c.a.d;
import com.fotoable.youtube.music.c.b.t;
import com.fotoable.youtube.music.locker.activity.LockerScreenActivity;
import com.fotoable.youtube.music.newplayer.e;
import com.fotoable.youtube.music.ui.activity.SplashActivity;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class MusicApplication extends Application {
    private static MusicApplication d;
    private com.fotoable.youtube.music.c.a.b e;
    private Class g;
    private UserInfoModel h;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2218c = MusicApplication.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f2217b = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f2219a = "com.fotoable.youtube.music";
    private boolean f = false;

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        h.a(f2218c, "onCreate开始：" + System.currentTimeMillis());
        d = this;
        this.f2219a = getPackageName();
        h.a(f2218c, "PACKAGE_NAME:" + this.f2219a + ",fabric:" + b.a.a.a.c.j());
        n();
        o();
        if (l()) {
            e.a().a(this);
            m();
            k();
            j();
            b();
            com.fotoable.youtube.music.util.b.b("Application启动次数");
        } else {
            h.a(f2218c, "Application启动多次");
        }
        h.a(f2218c, "onCreate结束：" + System.currentTimeMillis());
    }

    private void j() {
        if (TextUtils.isEmpty(v.a(this, "country_code", (String) null))) {
            v.b(this, "country_code", Locale.getDefault().getCountry());
            v.b((Context) c(), "country_code_is_local", true);
            h.a(f2218c, "使用本地国家码初始化");
        }
    }

    public boolean a() {
        return a.h();
    }

    private void k() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp((Application) this);
    }

    public void b() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.fotoable.youtube.music.MusicApplication.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                h.a(MusicApplication.f2218c, activity.getClass().getSimpleName() + "   onActivityCreated");
                if (!(activity instanceof LockerScreenActivity)) {
                    MusicApplication.this.g = activity.getClass();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                h.a(MusicApplication.f2218c, activity.getClass().getSimpleName() + "   onActivityStarted");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                h.a(MusicApplication.f2218c, activity.getClass().getSimpleName() + "   onActivityResumed");
                if (!(activity instanceof LockerScreenActivity)) {
                    MusicApplication.this.g = activity.getClass();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                h.a(MusicApplication.f2218c, activity.getClass().getSimpleName() + "   onActivityPaused");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                h.a(MusicApplication.f2218c, "onActivityStopped:" + activity.getClass().toString() + "");
                h.a(MusicApplication.f2218c, "isAppOnForeGround:" + MusicApplication.this.g());
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                h.a(MusicApplication.f2218c, "onActivityDestroyed:" + activity.getClass().toString() + "");
            }
        });
    }

    private boolean l() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && this.f2219a.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            return false;
        }
    }

    public static MusicApplication c() {
        return d;
    }

    public boolean d() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    private void m() {
        try {
            this.e = d.e().a(new t(this)).a(new com.fotoable.youtube.music.c.b.c(this)).a();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public com.fotoable.youtube.music.c.a.b e() {
        if (this.e == null) {
            m();
        }
        return this.e;
    }

    private void n() {
        try {
            b.a.a.a.c.a(new c.a(this).a(new Crashlytics(), new Answers()).a(true).a());
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void o() {
        try {
            new FlurryAgent.Builder().withLogEnabled(false).build(this, "BFG7HFX74D63HX6B2HPQ");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public Class f() {
        if (this.g == null || this.g.getCanonicalName().equals(SplashActivity.class.getCanonicalName())) {
            return null;
        }
        return this.g;
    }

    public boolean g() {
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public UserInfoModel h() {
        return this.h;
    }

    public void a(UserInfoModel userInfoModel) {
        this.h = userInfoModel;
    }
}
