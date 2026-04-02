package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
/* compiled from: FileDescriptorAssetPathFetcher.java */
/* loaded from: classes.dex */
public class d extends a<ParcelFileDescriptor> {
    public d(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.a
    /* renamed from: b */
    public ParcelFileDescriptor a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.a
    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
