package com.facebook.ads.internal.i.a;

import android.os.AsyncTask;
/* loaded from: classes.dex */
public class h extends AsyncTask<l, Void, n> implements c {

    /* renamed from: a  reason: collision with root package name */
    private a f1385a;

    /* renamed from: b  reason: collision with root package name */
    private b f1386b;

    /* renamed from: c  reason: collision with root package name */
    private Exception f1387c;

    public h(a aVar, b bVar) {
        this.f1385a = aVar;
        this.f1386b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public n doInBackground(l... lVarArr) {
        if (lVarArr != null) {
            try {
                if (lVarArr.length > 0) {
                    return this.f1385a.a(lVarArr[0]);
                }
            } catch (Exception e) {
                this.f1387c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    @Override // com.facebook.ads.internal.i.a.c
    public void a(l lVar) {
        super.execute(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(n nVar) {
        this.f1386b.a(nVar);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f1386b.a(this.f1387c);
    }
}
