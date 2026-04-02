package com.pili.pldroid.player.network;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.pili.pldroid.player.common.Util;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.http.DnspodFree;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
/* compiled from: DNSCacheManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private DnsManager f5023a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5024b;
    private Handler f;
    private HandlerThread g;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5025c = new Object();
    private HashMap<String, C0097a> d = new HashMap<>();
    private int e = DefaultOggSeeker.MATCH_BYTE_RANGE;
    private BroadcastReceiver h = new BroadcastReceiver() { // from class: com.pili.pldroid.player.network.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.this.b();
                a.this.f.sendEmptyMessage(1);
            }
        }
    };
    private Handler.Callback i = new Handler.Callback() { // from class: com.pili.pldroid.player.network.a.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            a.this.a();
            if (message.what == 0) {
                a.this.f.sendEmptyMessageDelayed(0, a.this.e);
                return true;
            }
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DNSCacheManager.java */
    /* renamed from: com.pili.pldroid.player.network.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0097a {

        /* renamed from: a  reason: collision with root package name */
        public String[] f5028a;

        /* renamed from: b  reason: collision with root package name */
        public int f5029b;

        public C0097a(String[] strArr, int i) {
            this.f5028a = strArr;
            this.f5029b = i;
        }
    }

    public void a(String str) throws UnknownHostException {
        if (this.f5023a == null) {
            this.f5023a = d(str);
        }
    }

    public void a(int i) {
        if (this.e <= 0) {
            throw new IllegalArgumentException("cache update interval must greater than 0 !");
        }
        this.e = i;
    }

    public void a(Context context) throws UnknownHostException {
        if (this.g == null) {
            this.f5024b = context.getApplicationContext();
            if (this.f5023a == null) {
                this.f5023a = d("119.29.29.29");
            }
            this.g = new HandlerThread("DNSCacheManager");
            this.g.start();
            this.f = new Handler(this.g.getLooper(), this.i);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.getApplicationContext().registerReceiver(this.h, intentFilter);
            this.f.sendEmptyMessage(0);
            Log.d("DNSCacheManager", "startCacheService !");
        }
    }

    public void a(Context context, String[] strArr) throws UnknownHostException {
        if (this.g == null) {
            for (String str : strArr) {
                this.d.put(str, null);
            }
            a(context);
        }
    }

    public void b(Context context) {
        if (this.g != null) {
            context.getApplicationContext().unregisterReceiver(this.h);
            this.g.interrupt();
            this.g.quit();
            this.g = null;
            synchronized (this.f5025c) {
                this.d.clear();
            }
            Log.d("DNSCacheManager", "stopCacheService !");
        }
    }

    public String b(String str) {
        return (str == null || this.g == null) ? str : a(Uri.parse(str)).toString();
    }

    public Uri a(Uri uri) {
        String uri2;
        String str;
        if (uri != null && this.g != null) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (host != null && scheme != null && !uri.toString().contains(".m3u8") && !DnsManager.validIP(host) && (scheme.equalsIgnoreCase("rtmp") || scheme.equalsIgnoreCase("http"))) {
                synchronized (this.f5025c) {
                    if (!this.d.containsKey(host)) {
                        this.d.put(host, null);
                        this.f.sendEmptyMessage(2);
                    } else {
                        C0097a c0097a = this.d.get(host);
                        if (c0097a != null && c0097a.f5028a.length > 0) {
                            c0097a.f5029b = (c0097a.f5029b + 1) % c0097a.f5028a.length;
                            if (uri.toString().contains("?")) {
                                str = uri2.replaceFirst(host, c0097a.f5028a[c0097a.f5029b]) + "&domain=" + host;
                            } else {
                                str = uri2.replaceFirst(host, c0097a.f5028a[c0097a.f5029b]) + "?domain=" + host;
                            }
                            uri = Uri.parse(str);
                        }
                    }
                }
            }
        }
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Object[] array;
        if (this.f5023a != null && !this.d.isEmpty() && Util.isNetworkConnected(this.f5024b) && !c(this.f5024b)) {
            synchronized (this.f5025c) {
                array = this.d.keySet().toArray();
            }
            for (Object obj : array) {
                String str = (String) obj;
                String[] c2 = c(str);
                if (c2 != null && c2.length > 0) {
                    synchronized (this.f5025c) {
                        this.d.put(str, new C0097a(c2, 0));
                    }
                }
            }
        }
    }

    private String[] c(String str) {
        try {
            return this.f5023a.query(str);
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this.f5025c) {
            Object[] array = this.d.keySet().toArray();
            this.d.clear();
            for (Object obj : array) {
                this.d.put((String) obj, null);
            }
        }
    }

    private static DnsManager d(String str) throws UnknownHostException {
        IResolver dnspodFree = new DnspodFree();
        IResolver defaultResolver = AndroidDnsServer.defaultResolver();
        return new DnsManager(NetworkInfo.normal, new IResolver[]{new Resolver(InetAddress.getByName(str)), defaultResolver, dnspodFree});
    }

    public static boolean c(Context context) {
        String packageName;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (packageName = context.getPackageName()) != null && (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (packageName.equals(runningAppProcessInfo.processName)) {
                    if (runningAppProcessInfo.importance != 100) {
                        Log.i(context.getPackageName(), "Background" + runningAppProcessInfo.processName);
                        return true;
                    }
                    Log.i(context.getPackageName(), "Foreground" + runningAppProcessInfo.processName);
                    return false;
                }
            }
            return false;
        }
        return true;
    }
}
