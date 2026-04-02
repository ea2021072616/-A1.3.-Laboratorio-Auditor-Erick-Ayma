package a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* compiled from: AppLink.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Uri f3a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f4b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f5c;

    /* compiled from: AppLink.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8c;
        private final String d;

        public a(String str, String str2, Uri uri, String str3) {
            this.f7b = str;
            this.f8c = str2;
            this.f6a = uri;
            this.d = str3;
        }
    }

    public b(Uri uri, List<a> list, Uri uri2) {
        this.f3a = uri;
        this.f4b = list == null ? Collections.emptyList() : list;
        this.f5c = uri2;
    }
}
