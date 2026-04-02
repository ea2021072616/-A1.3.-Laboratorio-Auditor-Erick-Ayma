package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import java.io.Serializable;
/* loaded from: classes.dex */
public class aa extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f1155a;

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.ads.internal.view.i f1156b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1157c = false;

    public aa(com.facebook.ads.internal.view.i iVar, Context context) {
        this.f1156b = iVar;
        this.f1155a = context;
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f1156b.getUniqueId());
        intentFilter.addAction("videoInterstitalEvent:" + this.f1156b.getUniqueId());
        LocalBroadcastManager.getInstance(this.f1155a).registerReceiver(this, intentFilter);
    }

    public void b() {
        try {
            LocalBroadcastManager.getInstance(this.f1155a).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length == 2 && split[1].equals(this.f1156b.getUniqueId())) {
            if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
                if (this.f1156b.getListener() != null) {
                    this.f1156b.getListener().g();
                    this.f1156b.getListener().a();
                }
            } else if (split[0].equals("videoInterstitalEvent")) {
                Serializable serializableExtra = intent.getSerializableExtra(NotificationCompat.CATEGORY_EVENT);
                if (serializableExtra instanceof com.facebook.ads.internal.view.d.a.p) {
                    if (this.f1156b.getListener() != null) {
                        this.f1156b.getListener().f();
                        this.f1156b.getListener().a();
                    }
                    if (this.f1157c) {
                        this.f1156b.a(1);
                    } else {
                        this.f1156b.a(((com.facebook.ads.internal.view.d.a.p) serializableExtra).b());
                    }
                    this.f1156b.setVisibility(0);
                    this.f1156b.d();
                } else if (serializableExtra instanceof com.facebook.ads.internal.view.d.a.f) {
                    if (this.f1156b.getListener() != null) {
                        this.f1156b.getListener().d();
                    }
                } else if (serializableExtra instanceof com.facebook.ads.internal.view.d.a.g) {
                    if (this.f1156b.getListener() != null) {
                        this.f1156b.getListener().e();
                    }
                } else if (serializableExtra instanceof com.facebook.ads.internal.view.d.a.b) {
                    if (this.f1156b.getListener() != null) {
                        this.f1156b.getListener().h();
                    }
                    this.f1157c = true;
                } else if (serializableExtra instanceof com.facebook.ads.internal.view.d.a.j) {
                    if (this.f1156b.getListener() != null) {
                        this.f1156b.getListener().c();
                    }
                    this.f1157c = false;
                } else if (!(serializableExtra instanceof com.facebook.ads.internal.view.d.a.h) || this.f1156b.getListener() == null) {
                } else {
                    this.f1156b.getListener().b();
                }
            }
        }
    }
}
