package com.fotoable.youtube.music.locker;

import android.content.Context;
import android.view.WindowManager;
import com.fotoable.youtube.music.locker.view.LockerView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: MusicLockerManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f2752a = new a();

    /* renamed from: b  reason: collision with root package name */
    private LockerView f2753b;

    public static a a() {
        return f2752a;
    }

    private a() {
    }

    public void a(Context context) {
        try {
            if (this.f2753b != null && context != null) {
                ((WindowManager) context.getSystemService("window")).removeView(this.f2753b);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}
