package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    private boolean f860a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f861b = new Handler(Looper.getMainLooper(), new a());

    public void a(k<?> kVar) {
        com.bumptech.glide.i.h.a();
        if (this.f860a) {
            this.f861b.obtainMessage(1, kVar).sendToTarget();
            return;
        }
        this.f860a = true;
        kVar.d();
        this.f860a = false;
    }

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    private static class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((k) message.obj).d();
                return true;
            }
            return false;
        }
    }
}
