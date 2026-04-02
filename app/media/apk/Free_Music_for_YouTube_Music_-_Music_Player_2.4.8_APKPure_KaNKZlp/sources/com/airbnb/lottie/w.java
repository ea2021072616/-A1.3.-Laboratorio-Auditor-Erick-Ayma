package com.airbnb.lottie;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompositionLoader.java */
/* loaded from: classes.dex */
public abstract class w<Params> extends AsyncTask<Params, Void, aw> implements q {
    @Override // com.airbnb.lottie.q
    public void a() {
        cancel(true);
    }
}
