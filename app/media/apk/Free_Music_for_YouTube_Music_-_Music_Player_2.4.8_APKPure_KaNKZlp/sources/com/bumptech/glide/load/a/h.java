package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class h extends a<InputStream> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.a
    /* renamed from: b */
    public InputStream a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.a
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
