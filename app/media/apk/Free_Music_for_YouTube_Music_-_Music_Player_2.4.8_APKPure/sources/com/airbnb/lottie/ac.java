package com.airbnb.lottie;

import android.content.res.Resources;
import com.airbnb.lottie.aw;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCompositionLoader.java */
/* loaded from: classes.dex */
public final class ac extends w<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f379a;

    /* renamed from: b  reason: collision with root package name */
    private final bf f380b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Resources resources, bf bfVar) {
        this.f379a = resources;
        this.f380b = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public aw doInBackground(InputStream... inputStreamArr) {
        return aw.a.a(this.f379a, inputStreamArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(aw awVar) {
        this.f380b.onCompositionLoaded(awVar);
    }
}
