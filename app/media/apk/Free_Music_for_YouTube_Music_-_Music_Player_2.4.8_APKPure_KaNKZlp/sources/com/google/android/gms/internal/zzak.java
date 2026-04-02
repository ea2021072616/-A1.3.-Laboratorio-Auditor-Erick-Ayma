package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
/* loaded from: classes.dex */
public final class zzak implements zzan {
    private HttpClient zzca;

    public zzak(HttpClient httpClient) {
        this.zzca = httpClient;
    }

    private static void zza(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzp<?> zzpVar) throws zza {
        byte[] zzg = zzpVar.zzg();
        if (zzg != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzg));
        }
    }

    private static void zza(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // com.google.android.gms.internal.zzan
    public final HttpResponse zza(zzp<?> zzpVar, Map<String, String> map) throws IOException, zza {
        HttpGet zzalVar;
        switch (zzpVar.getMethod()) {
            case -1:
                zzalVar = new HttpGet(zzpVar.getUrl());
                break;
            case 0:
                zzalVar = new HttpGet(zzpVar.getUrl());
                break;
            case 1:
                zzalVar = new HttpPost(zzpVar.getUrl());
                zzalVar.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzalVar, zzpVar);
                break;
            case 2:
                zzalVar = new HttpPut(zzpVar.getUrl());
                zzalVar.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzalVar, zzpVar);
                break;
            case 3:
                zzalVar = new HttpDelete(zzpVar.getUrl());
                break;
            case 4:
                zzalVar = new HttpHead(zzpVar.getUrl());
                break;
            case 5:
                zzalVar = new HttpOptions(zzpVar.getUrl());
                break;
            case 6:
                zzalVar = new HttpTrace(zzpVar.getUrl());
                break;
            case 7:
                zzalVar = new zzal(zzpVar.getUrl());
                zzalVar.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzalVar, zzpVar);
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        zza((HttpUriRequest) zzalVar, map);
        zza((HttpUriRequest) zzalVar, zzpVar.getHeaders());
        HttpParams params = zzalVar.getParams();
        int zzi = zzpVar.zzi();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzi);
        return this.zzca.execute(zzalVar);
    }
}
