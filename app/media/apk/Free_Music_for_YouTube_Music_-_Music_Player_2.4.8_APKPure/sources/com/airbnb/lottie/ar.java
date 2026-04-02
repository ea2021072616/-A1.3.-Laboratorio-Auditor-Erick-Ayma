package com.airbnb.lottie;

import android.content.res.Resources;
import com.airbnb.lottie.aw;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonCompositionLoader.java */
/* loaded from: classes.dex */
public final class ar extends w<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f404a;

    /* renamed from: b  reason: collision with root package name */
    private final bf f405b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Resources resources, bf bfVar) {
        this.f404a = resources;
        this.f405b = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public aw doInBackground(JSONObject... jSONObjectArr) {
        return aw.a.a(this.f404a, jSONObjectArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(aw awVar) {
        this.f405b.onCompositionLoaded(awVar);
    }
}
