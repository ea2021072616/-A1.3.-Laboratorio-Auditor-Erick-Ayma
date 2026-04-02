package com.acrcloud.rec.b.b;

import android.os.AsyncTask;
import java.util.HashMap;
/* compiled from: ACRCloudLocalRecognizerInitAsyncTask.java */
/* loaded from: classes.dex */
public class g extends AsyncTask<String, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private com.acrcloud.rec.b.b f352a;

    public g(com.acrcloud.rec.b.b bVar) {
        this.f352a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(String... strArr) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("access_key", this.f352a.e);
            hashMap.put("dk", strArr[0]);
            hashMap.put("type", "offline");
            c.a("http://api.acrcloud.com/v1/devices/login", hashMap, 5000);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r1) {
        super.onPreExecute();
    }
}
