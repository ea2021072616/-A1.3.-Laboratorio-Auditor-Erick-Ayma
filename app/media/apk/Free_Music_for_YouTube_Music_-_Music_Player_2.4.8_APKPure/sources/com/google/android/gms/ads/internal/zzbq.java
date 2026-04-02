package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzmu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbq extends WebViewClient {
    private /* synthetic */ zzbp zzaru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(zzbp zzbpVar) {
        this.zzaru = zzbpVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzju zzjuVar;
        zzju zzjuVar2;
        zzjuVar = this.zzaru.zzaoq;
        if (zzjuVar != null) {
            try {
                zzjuVar2 = this.zzaru.zzaoq;
                zzjuVar2.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzafx.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzju zzjuVar;
        zzju zzjuVar2;
        String zzv;
        zzju zzjuVar3;
        zzju zzjuVar4;
        zzju zzjuVar5;
        zzju zzjuVar6;
        zzju zzjuVar7;
        zzju zzjuVar8;
        if (str.startsWith(this.zzaru.zzdr())) {
            return false;
        }
        if (str.startsWith((String) zzbv.zzen().zzd(zzmu.zzbnu))) {
            zzjuVar7 = this.zzaru.zzaoq;
            if (zzjuVar7 != null) {
                try {
                    zzjuVar8 = this.zzaru.zzaoq;
                    zzjuVar8.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzafx.zzc("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
            this.zzaru.zzi(0);
            return true;
        }
        if (str.startsWith((String) zzbv.zzen().zzd(zzmu.zzbnv))) {
            zzjuVar5 = this.zzaru.zzaoq;
            if (zzjuVar5 != null) {
                try {
                    zzjuVar6 = this.zzaru.zzaoq;
                    zzjuVar6.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzafx.zzc("Could not call AdListener.onAdFailedToLoad().", e2);
                }
            }
            this.zzaru.zzi(0);
            return true;
        }
        if (str.startsWith((String) zzbv.zzen().zzd(zzmu.zzbnw))) {
            zzjuVar3 = this.zzaru.zzaoq;
            if (zzjuVar3 != null) {
                try {
                    zzjuVar4 = this.zzaru.zzaoq;
                    zzjuVar4.onAdLoaded();
                } catch (RemoteException e3) {
                    zzafx.zzc("Could not call AdListener.onAdLoaded().", e3);
                }
            }
            this.zzaru.zzi(this.zzaru.zzu(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzjuVar = this.zzaru.zzaoq;
            if (zzjuVar != null) {
                try {
                    zzjuVar2 = this.zzaru.zzaoq;
                    zzjuVar2.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzafx.zzc("Could not call AdListener.onAdLeftApplication().", e4);
                }
            }
            zzv = this.zzaru.zzv(str);
            this.zzaru.zzw(zzv);
            return true;
        }
    }
}
