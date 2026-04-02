package com.fotoable.youtube.music.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
/* compiled from: CustomDialog.java */
/* loaded from: classes.dex */
public class h extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f4448a;

    /* renamed from: b  reason: collision with root package name */
    private int f4449b;

    /* renamed from: c  reason: collision with root package name */
    private int f4450c;
    private boolean d;
    private View e;

    public h(@NonNull a aVar) {
        super(aVar.f4451a);
        this.f4448a = aVar.f4451a;
        this.f4449b = aVar.f4452b;
        this.f4450c = aVar.f4453c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public h(@NonNull a aVar, @StyleRes int i) {
        super(aVar.f4451a, i);
        this.f4448a = aVar.f4451a;
        this.f4449b = aVar.f4452b;
        this.f4450c = aVar.f4453c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.e);
        setCanceledOnTouchOutside(this.d);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.height = this.f4449b;
        attributes.width = this.f4450c;
        window.setAttributes(attributes);
    }

    /* compiled from: CustomDialog.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f4451a;

        /* renamed from: b  reason: collision with root package name */
        private int f4452b;

        /* renamed from: c  reason: collision with root package name */
        private int f4453c;
        private boolean d;
        private View e;
        private int f = -1;

        public a(Context context) {
            this.f4451a = context;
        }

        public a a(int i) {
            this.e = LayoutInflater.from(this.f4451a).inflate(i, (ViewGroup) null);
            return this;
        }

        public a b(int i) {
            this.f4452b = com.fotoable.youtube.music.util.w.a(this.f4451a, i);
            return this;
        }

        public a c(int i) {
            this.f4453c = com.fotoable.youtube.music.util.w.a(this.f4451a, i);
            return this;
        }

        public a d(int i) {
            this.f = i;
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public a a(int i, View.OnClickListener onClickListener) {
            this.e.findViewById(i).setOnClickListener(onClickListener);
            return this;
        }

        public h a() {
            return this.f != -1 ? new h(this, this.f) : new h(this);
        }
    }
}
