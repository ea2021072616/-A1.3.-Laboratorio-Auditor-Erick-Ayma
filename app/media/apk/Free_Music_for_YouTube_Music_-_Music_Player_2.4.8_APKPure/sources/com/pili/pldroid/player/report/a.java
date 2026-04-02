package com.pili.pldroid.player.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: QosBroadcastManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f5038a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static a f5039b;
    private Context f;
    private Handler g;
    private HandlerThread h;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f5040c = new HashMap<>();
    private final HashMap<String, ArrayList<b>> d = new HashMap<>();
    private final ArrayList<C0098a> e = new ArrayList<>();
    private boolean i = false;
    private boolean j = false;

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (f5038a) {
            if (f5039b == null) {
                f5039b = new a();
            }
            aVar = f5039b;
        }
        return aVar;
    }

    public void a(Context context) {
        synchronized (this.f5040c) {
            if (context != null) {
                if (!this.j) {
                    this.j = true;
                    this.f = context.getApplicationContext();
                    this.h = new HandlerThread("QosBroadcastManager");
                    this.h.start();
                    this.g = new Handler(this.h.getLooper()) { // from class: com.pili.pldroid.player.report.a.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            switch (message.what) {
                                case 1:
                                    a.this.c();
                                    return;
                                default:
                                    super.handleMessage(message);
                                    return;
                            }
                        }
                    };
                }
            }
        }
    }

    public void b() {
        synchronized (this.f5040c) {
            if (this.j) {
                this.j = false;
                this.h.quit();
                this.h = null;
            }
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f == null) {
            Log.e("QosBroadcastManager", "Context is NULL");
        }
        synchronized (this.f5040c) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f5040c.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f5040c.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.d.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.d.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        int i;
        if (this.f == null) {
            throw new IllegalStateException("Context is NULL");
        }
        synchronized (this.f5040c) {
            ArrayList<IntentFilter> remove = this.f5040c.remove(broadcastReceiver);
            if (remove != null) {
                for (int i2 = 0; i2 < remove.size(); i2++) {
                    IntentFilter intentFilter = remove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList<b> arrayList = this.d.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (arrayList.get(i4).f5045b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i = i4 - 1;
                                } else {
                                    i = i4;
                                }
                                i4 = i + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.d.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.f5040c) {
            if (!this.i || this.f == null || !this.j) {
                return false;
            }
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("QosBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList2 = this.d.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("QosBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    b bVar = arrayList2.get(i);
                    if (z) {
                        Log.v("QosBroadcastManager", "Matching against filter " + bVar.f5044a);
                    }
                    if (bVar.f5046c) {
                        if (z) {
                            Log.v("QosBroadcastManager", "  Filter's target already added");
                            arrayList = arrayList3;
                        }
                        arrayList = arrayList3;
                    } else {
                        int match = bVar.f5044a.match(action, resolveTypeIfNeeded, scheme, data, categories, "QosBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("QosBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(bVar);
                            bVar.f5046c = true;
                        } else {
                            if (z) {
                                switch (match) {
                                    case -4:
                                        str = "category";
                                        break;
                                    case -3:
                                        str = NativeProtocol.WEB_DIALOG_ACTION;
                                        break;
                                    case -2:
                                        str = ShareConstants.WEB_DIALOG_PARAM_DATA;
                                        break;
                                    case -1:
                                        str = "type";
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("QosBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((b) arrayList3.get(i2)).f5046c = false;
                    }
                    this.e.add(new C0098a(intent, arrayList3));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        C0098a[] c0098aArr;
        while (true) {
            synchronized (this.f5040c) {
                int size = this.e.size();
                if (size <= 0) {
                    return;
                }
                c0098aArr = new C0098a[size];
                this.e.toArray(c0098aArr);
                this.e.clear();
            }
            for (C0098a c0098a : c0098aArr) {
                for (int i = 0; i < c0098a.f5043b.size(); i++) {
                    c0098a.f5043b.get(i).f5045b.onReceive(this.f, c0098a.f5042a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QosBroadcastManager.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f5044a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f5045b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5046c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f5044a = intentFilter;
            this.f5045b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f5045b);
            sb.append(" filter=");
            sb.append(this.f5044a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QosBroadcastManager.java */
    /* renamed from: com.pili.pldroid.player.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0098a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f5042a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<b> f5043b;

        C0098a(Intent intent, ArrayList<b> arrayList) {
            this.f5042a = intent;
            this.f5043b = arrayList;
        }
    }
}
