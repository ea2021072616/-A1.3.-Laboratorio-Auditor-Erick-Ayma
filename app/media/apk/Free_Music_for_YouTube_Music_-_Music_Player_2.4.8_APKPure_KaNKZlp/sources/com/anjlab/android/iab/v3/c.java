package com.anjlab.android.iab.v3;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.common.zzo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: BillingProcessor.java */
/* loaded from: classes.dex */
public class c extends com.anjlab.android.iab.v3.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Date f596a = new Date(2012, 12, 5);

    /* renamed from: b  reason: collision with root package name */
    private static final Date f597b = new Date(2015, 7, 20);

    /* renamed from: c  reason: collision with root package name */
    private IInAppBillingService f598c;
    private String d;
    private String e;
    private com.anjlab.android.iab.v3.b f;
    private com.anjlab.android.iab.v3.b g;
    private b h;
    private String i;
    private ServiceConnection j;

    /* compiled from: BillingProcessor.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i, Throwable th);

        void a(String str, TransactionDetails transactionDetails);

        void b();
    }

    /* compiled from: BillingProcessor.java */
    /* loaded from: classes.dex */
    private class a extends AsyncTask<Void, Void, Boolean> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            if (c.this.h()) {
                return false;
            }
            c.this.e();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                c.this.i();
                if (c.this.h != null) {
                    c.this.h.a();
                }
            }
            if (c.this.h != null) {
                c.this.h.b();
            }
        }
    }

    public c(Context context, String str, b bVar) {
        this(context, str, null, bVar);
    }

    public c(Context context, String str, String str2, b bVar) {
        this(context, str, str2, bVar, true);
    }

    private c(Context context, String str, String str2, b bVar, boolean z) {
        super(context.getApplicationContext());
        this.j = new ServiceConnection() { // from class: com.anjlab.android.iab.v3.c.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                c.this.f598c = null;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.f598c = IInAppBillingService.a.a(iBinder);
                new a().execute(new Void[0]);
            }
        };
        this.e = str;
        this.h = bVar;
        this.d = a().getPackageName();
        this.f = new com.anjlab.android.iab.v3.b(a(), ".products.cache.v2_6");
        this.g = new com.anjlab.android.iab.v3.b(a(), ".subscriptions.cache.v2_6");
        this.i = str2;
        if (z) {
            g();
        }
    }

    private static Intent f() {
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(zzo.GOOGLE_PLAY_STORE_PACKAGE);
        return intent;
    }

    private void g() {
        try {
            a().bindService(f(), this.j, 1);
        } catch (Exception e) {
            Log.e("iabv3", "error in bindPlayServices", e);
            a(113, e);
        }
    }

    public static boolean a(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(f(), 0);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    public void c() {
        if (d() && this.j != null) {
            try {
                a().unbindService(this.j);
            } catch (Exception e) {
                Log.e("iabv3", "Error in release", e);
            }
            this.f598c = null;
        }
    }

    public boolean d() {
        return this.f598c != null;
    }

    public boolean a(String str) {
        return this.f.a(str);
    }

    public boolean b(String str) {
        return this.g.a(str);
    }

    private boolean a(String str, com.anjlab.android.iab.v3.b bVar) {
        if (d()) {
            try {
                Bundle a2 = this.f598c.a(3, this.d, str, (String) null);
                if (a2.getInt("RESPONSE_CODE") == 0) {
                    bVar.c();
                    ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    if (stringArrayList != null) {
                        int i = 0;
                        while (i < stringArrayList.size()) {
                            String str2 = stringArrayList.get(i);
                            if (!TextUtils.isEmpty(str2)) {
                                bVar.a(new JSONObject(str2).getString("productId"), str2, (stringArrayList2 == null || stringArrayList2.size() <= i) ? null : stringArrayList2.get(i));
                            }
                            i++;
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                a(100, e);
                Log.e("iabv3", "Error in loadPurchasesByType", e);
                return false;
            }
        }
        return false;
    }

    public boolean e() {
        return d() && a("inapp", this.f) && a("subs", this.g);
    }

    public boolean a(Activity activity, String str) {
        return a(activity, null, str, "subs", null);
    }

    private boolean a(Activity activity, List<String> list, String str, String str2, String str3) {
        return a(activity, list, str, str2, str3, null);
    }

    private boolean a(Activity activity, List<String> list, String str, String str2, String str3, Bundle bundle) {
        Bundle a2;
        if (!d() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String str4 = str2 + ":" + str;
            if (!str2.equals("subs")) {
                str4 = str4 + ":" + UUID.randomUUID().toString();
            }
            if (str3 != null) {
                str4 = str4 + ":" + str3;
            }
            e(str4);
            if (list != null && str2.equals("subs")) {
                if (bundle == null) {
                    a2 = this.f598c.a(5, this.d, list, str, str2, str4);
                } else {
                    Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                    if (!bundle2.containsKey("skusToReplace")) {
                        bundle2.putStringArrayList("skusToReplace", new ArrayList<>(list));
                    }
                    a2 = this.f598c.a(7, this.d, str, str2, str4, bundle2);
                }
            } else if (bundle == null) {
                a2 = this.f598c.a(3, this.d, str, str2, str4);
            } else {
                a2 = this.f598c.a(7, this.d, str, str2, str4, bundle);
            }
            if (a2 != null) {
                int i = a2.getInt("RESPONSE_CODE");
                if (i == 0) {
                    PendingIntent pendingIntent = (PendingIntent) a2.getParcelable("BUY_INTENT");
                    if (activity != null && pendingIntent != null) {
                        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 32459, new Intent(), 0, 0, 0);
                    } else {
                        a(103, (Throwable) null);
                    }
                } else if (i == 7) {
                    if (!a(str) && !b(str)) {
                        e();
                    }
                    TransactionDetails c2 = c(str);
                    if (!a(c2)) {
                        Log.i("iabv3", "Invalid or tampered merchant id!");
                        a(104, (Throwable) null);
                        return false;
                    } else if (this.h != null) {
                        if (c2 == null) {
                            c2 = d(str);
                        }
                        this.h.a(str, c2);
                    }
                } else {
                    a(101, (Throwable) null);
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("iabv3", "Error in purchase", e);
            a(110, e);
            return false;
        }
    }

    private boolean a(TransactionDetails transactionDetails) {
        if (this.i == null || transactionDetails.purchaseTime.before(f596a) || transactionDetails.purchaseTime.after(f597b)) {
            return true;
        }
        if (transactionDetails.orderId == null || transactionDetails.orderId.trim().length() == 0) {
            return false;
        }
        int indexOf = transactionDetails.orderId.indexOf(46);
        return indexOf > 0 && transactionDetails.orderId.substring(0, indexOf).compareTo(this.i) == 0;
    }

    private TransactionDetails b(String str, com.anjlab.android.iab.v3.b bVar) {
        PurchaseInfo b2 = bVar.b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.responseData)) {
            try {
                return new TransactionDetails(b2);
            } catch (JSONException e) {
                Log.e("iabv3", "Failed to load saved purchase details for " + str, e);
            }
        }
        return null;
    }

    public TransactionDetails c(String str) {
        return b(str, this.f);
    }

    public TransactionDetails d(String str) {
        return b(str, this.g);
    }

    private String a(JSONObject jSONObject) {
        String str = null;
        try {
            if (jSONObject.has("developerPayload")) {
                str = jSONObject.getString("developerPayload");
            }
        } catch (JSONException e) {
            Log.e("iabv3", "Failed to extract developer payload value!");
        }
        return str != null ? str : "";
    }

    private boolean c(String str, String str2) {
        return str.equals(str2);
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i != 32459) {
            return false;
        }
        if (intent == null) {
            Log.e("iabv3", "handleActivityResult: data is null!");
            return false;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        Log.d("iabv3", String.format("resultCode = %d, responseCode = %d", Integer.valueOf(i2), Integer.valueOf(intExtra)));
        String j = j();
        if (i2 == -1 && intExtra == 0 && !TextUtils.isEmpty(j)) {
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String string = jSONObject.getString("productId");
                String a2 = a(jSONObject);
                boolean startsWith = j.startsWith("subs");
                if (c(j, a2)) {
                    if (a(string, stringExtra, stringExtra2)) {
                        (startsWith ? this.g : this.f).a(string, stringExtra, stringExtra2);
                        if (this.h != null) {
                            this.h.a(string, new TransactionDetails(new PurchaseInfo(stringExtra, stringExtra2)));
                        }
                    } else {
                        Log.e("iabv3", "Public key signature doesn't match!");
                        a(102, (Throwable) null);
                    }
                } else {
                    Log.e("iabv3", String.format("Payload mismatch: %s != %s", j, a2));
                    a(105, (Throwable) null);
                }
            } catch (Exception e) {
                Log.e("iabv3", "Error in handleActivityResult", e);
                a(110, e);
            }
        } else {
            a(intExtra, (Throwable) null);
        }
        return true;
    }

    private boolean a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(this.e)) {
                if (!e.a(str, this.e, str2, str3)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return a(b() + ".products.restored.v2_6", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        a(b() + ".products.restored.v2_6", (Boolean) true);
    }

    private void e(String str) {
        a(b() + ".purchase.last.v2_6", str);
    }

    private String j() {
        return b(b() + ".purchase.last.v2_6", (String) null);
    }

    private void a(int i, Throwable th) {
        if (this.h != null) {
            this.h.a(i, th);
        }
    }
}
