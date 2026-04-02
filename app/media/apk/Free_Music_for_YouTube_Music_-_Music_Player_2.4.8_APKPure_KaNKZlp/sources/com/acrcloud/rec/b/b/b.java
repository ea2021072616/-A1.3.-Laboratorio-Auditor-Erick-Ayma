package com.acrcloud.rec.b.b;

import android.os.AsyncTask;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* compiled from: ACRCloudGetIPAddressAsyncTask.java */
/* loaded from: classes.dex */
public class b extends AsyncTask<String, Integer, String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            return InetAddress.getByName(strArr[0]).getHostAddress();
        } catch (UnknownHostException e) {
            ThrowableExtension.printStackTrace(e);
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPreExecute();
        h.b("ACRCloudAsynGetIPAddressTask", ">>>>>>>>>>>>>>>  " + str);
        com.acrcloud.rec.b.a.c.f332a = str;
    }
}
