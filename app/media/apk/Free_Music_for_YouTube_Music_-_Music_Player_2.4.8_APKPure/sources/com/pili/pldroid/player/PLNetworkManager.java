package com.pili.pldroid.player;

import android.content.Context;
import android.net.Uri;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public final class PLNetworkManager {

    /* renamed from: a  reason: collision with root package name */
    private com.pili.pldroid.player.network.a f5017a;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final PLNetworkManager f5018a = new PLNetworkManager();
    }

    private PLNetworkManager() {
        this.f5017a = new com.pili.pldroid.player.network.a();
    }

    public static PLNetworkManager getInstance() {
        return a.f5018a;
    }

    public void setDnsServer(String str) throws UnknownHostException {
        this.f5017a.a(str);
    }

    public void setDnsCacheUpdateInterval(int i) {
        this.f5017a.a(i);
    }

    public void startDnsCacheService(Context context) throws UnknownHostException {
        this.f5017a.a(context);
    }

    public void startDnsCacheService(Context context, String[] strArr) throws UnknownHostException {
        this.f5017a.a(context, strArr);
    }

    public void stopDnsCacheService(Context context) {
        this.f5017a.b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        return this.f5017a.b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri a(Uri uri) {
        return this.f5017a.a(uri);
    }
}
