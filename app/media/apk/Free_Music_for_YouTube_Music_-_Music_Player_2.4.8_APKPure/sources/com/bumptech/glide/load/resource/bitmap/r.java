package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
/* compiled from: VideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class r implements com.bumptech.glide.load.resource.bitmap.a<ParcelFileDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f951a = new a();

    /* renamed from: b  reason: collision with root package name */
    private a f952b;

    /* renamed from: c  reason: collision with root package name */
    private int f953c;

    public r() {
        this(f951a, -1);
    }

    r(a aVar, int i) {
        this.f952b = aVar;
        this.f953c = i;
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.b.a.c cVar, int i, int i2, com.bumptech.glide.load.a aVar) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever a2 = this.f952b.a();
        a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
        if (this.f953c >= 0) {
            frameAtTime = a2.getFrameAtTime(this.f953c);
        } else {
            frameAtTime = a2.getFrameAtTime();
        }
        a2.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.a
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    /* compiled from: VideoBitmapDecoder.java */
    /* loaded from: classes.dex */
    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }
}
