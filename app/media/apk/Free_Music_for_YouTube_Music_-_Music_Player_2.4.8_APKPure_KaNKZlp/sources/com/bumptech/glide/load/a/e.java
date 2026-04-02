package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
/* compiled from: FileDescriptorLocalUriFetcher.java */
/* loaded from: classes.dex */
public class e extends g<ParcelFileDescriptor> {
    public e(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.g
    /* renamed from: a */
    public ParcelFileDescriptor b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.g
    public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }
}
