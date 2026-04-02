package com.anjlab.android.iab.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* compiled from: BillingBase.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f592a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context a() {
        return this.f592a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return a().getPackageName() + "_preferences";
    }

    private SharedPreferences c() {
        return PreferenceManager.getDefaultSharedPreferences(a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, String str2) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            SharedPreferences.Editor edit = c2.edit();
            edit.putString(str, str2);
            edit.commit();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str, String str2) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            return c2.getString(str, str2);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, Boolean bool) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            SharedPreferences.Editor edit = c2.edit();
            edit.putBoolean(str, bool.booleanValue());
            edit.commit();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, boolean z) {
        SharedPreferences c2 = c();
        if (c2 != null) {
            return c2.getBoolean(str, z);
        }
        return z;
    }
}
