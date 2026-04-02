package y0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceScreen;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5584a;

    /* renamed from: b  reason: collision with root package name */
    public long f5585b = 0;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f5586c = null;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f5587d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5588e;

    /* renamed from: f  reason: collision with root package name */
    public String f5589f;

    /* renamed from: g  reason: collision with root package name */
    public PreferenceScreen f5590g;

    /* renamed from: h  reason: collision with root package name */
    public z f5591h;

    /* renamed from: i  reason: collision with root package name */
    public x f5592i;

    /* renamed from: j  reason: collision with root package name */
    public y f5593j;

    public a0(Context context) {
        this.f5584a = context;
        this.f5589f = a(context);
    }

    public static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor b() {
        if (this.f5588e) {
            if (this.f5587d == null) {
                this.f5587d = c().edit();
            }
            return this.f5587d;
        }
        return c().edit();
    }

    public final SharedPreferences c() {
        if (this.f5586c == null) {
            this.f5586c = this.f5584a.getSharedPreferences(this.f5589f, 0);
        }
        return this.f5586c;
    }
}
