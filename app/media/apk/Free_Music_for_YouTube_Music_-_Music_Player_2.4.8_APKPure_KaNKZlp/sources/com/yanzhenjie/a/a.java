package com.yanzhenjie.a;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.util.LinkedList;
/* compiled from: MediaScanner.java */
/* loaded from: classes2.dex */
public class a implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    private MediaScannerConnection f5123a;

    /* renamed from: b  reason: collision with root package name */
    private b f5124b;
    private String[] d;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<String[]> f5125c = new LinkedList<>();
    private int e = 0;

    public a(Context context) {
        this.f5123a = new MediaScannerConnection(context.getApplicationContext(), this);
    }

    public boolean a() {
        return this.f5123a.isConnected();
    }

    public void a(String str) {
        a(new String[]{str});
    }

    public void a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f5125c.add(strArr);
            b();
        }
    }

    private void b() {
        if (!a() && this.f5125c.size() > 0) {
            this.d = this.f5125c.remove(0);
            this.f5123a.connect();
        }
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        String[] strArr;
        for (String str : this.d) {
            this.f5123a.scanFile(str, MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (this.f5124b != null) {
            this.f5124b.a(str, uri);
        }
        this.e++;
        if (this.e == this.d.length) {
            this.f5123a.disconnect();
            if (this.f5124b != null) {
                this.f5124b.a(this.d);
            }
            this.e = 0;
            this.d = null;
            b();
        }
    }
}
