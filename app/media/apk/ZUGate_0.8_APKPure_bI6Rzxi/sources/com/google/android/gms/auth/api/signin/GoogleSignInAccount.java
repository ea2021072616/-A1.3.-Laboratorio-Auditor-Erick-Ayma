package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b4.j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import m2.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new androidx.activity.result.a(22);

    /* renamed from: b  reason: collision with root package name */
    public final int f1808b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1809c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1810d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1811e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1812f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f1813g;

    /* renamed from: h  reason: collision with root package name */
    public String f1814h;

    /* renamed from: i  reason: collision with root package name */
    public final long f1815i;

    /* renamed from: j  reason: collision with root package name */
    public final String f1816j;

    /* renamed from: k  reason: collision with root package name */
    public final List f1817k;

    /* renamed from: l  reason: collision with root package name */
    public final String f1818l;

    /* renamed from: m  reason: collision with root package name */
    public final String f1819m;

    /* renamed from: n  reason: collision with root package name */
    public final HashSet f1820n = new HashSet();

    public GoogleSignInAccount(int i5, String str, String str2, String str3, String str4, Uri uri, String str5, long j5, String str6, ArrayList arrayList, String str7, String str8) {
        this.f1808b = i5;
        this.f1809c = str;
        this.f1810d = str2;
        this.f1811e = str3;
        this.f1812f = str4;
        this.f1813g = uri;
        this.f1814h = str5;
        this.f1815i = j5;
        this.f1816j = str6;
        this.f1817k = arrayList;
        this.f1818l = str7;
        this.f1819m = str8;
    }

    public static GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            hashSet.add(new Scope(1, jSONArray.getString(i5)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        long longValue = valueOf.longValue();
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.f1814h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            if (googleSignInAccount.f1816j.equals(this.f1816j)) {
                HashSet hashSet = new HashSet(googleSignInAccount.f1817k);
                hashSet.addAll(googleSignInAccount.f1820n);
                HashSet hashSet2 = new HashSet(this.f1817k);
                hashSet2.addAll(this.f1820n);
                if (hashSet.equals(hashSet2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        HashSet hashSet = new HashSet(this.f1817k);
        hashSet.addAll(this.f1820n);
        return ((this.f1816j.hashCode() + 527) * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int o02 = j.o0(parcel, 20293);
        j.h0(parcel, 1, this.f1808b);
        j.j0(parcel, 2, this.f1809c);
        j.j0(parcel, 3, this.f1810d);
        j.j0(parcel, 4, this.f1811e);
        j.j0(parcel, 5, this.f1812f);
        j.i0(parcel, 6, this.f1813g, i5);
        j.j0(parcel, 7, this.f1814h);
        parcel.writeInt(524296);
        parcel.writeLong(this.f1815i);
        j.j0(parcel, 9, this.f1816j);
        j.l0(parcel, 10, this.f1817k);
        j.j0(parcel, 11, this.f1818l);
        j.j0(parcel, 12, this.f1819m);
        j.t0(parcel, o02);
    }
}
