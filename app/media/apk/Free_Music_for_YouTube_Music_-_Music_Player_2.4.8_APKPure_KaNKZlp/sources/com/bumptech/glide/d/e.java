package com.bumptech.glide.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.d.c;
/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f647a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f648b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f649c;
    private boolean d;
    private final BroadcastReceiver e = new BroadcastReceiver() { // from class: com.bumptech.glide.d.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f649c;
            e.this.f649c = e.this.a(context);
            if (z != e.this.f649c) {
                e.this.f648b.a(e.this.f649c);
            }
        }
    };

    public e(Context context, c.a aVar) {
        this.f647a = context.getApplicationContext();
        this.f648b = aVar;
    }

    private void a() {
        if (!this.d) {
            this.f649c = a(this.f647a);
            this.f647a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        }
    }

    private void b() {
        if (this.d) {
            this.f647a.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.bumptech.glide.d.h
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.d.h
    public void onStop() {
        b();
    }

    @Override // com.bumptech.glide.d.h
    public void onDestroy() {
    }
}
