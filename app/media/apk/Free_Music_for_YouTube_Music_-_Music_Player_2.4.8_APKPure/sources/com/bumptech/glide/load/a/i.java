package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class i extends g<InputStream> {
    public i(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.g
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.g
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
