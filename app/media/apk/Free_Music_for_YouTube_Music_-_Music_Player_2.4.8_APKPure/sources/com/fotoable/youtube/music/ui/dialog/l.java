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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: GoToBrowserDialog.java */
/* loaded from: classes.dex */
public class l extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f4457a;

    /* renamed from: b  reason: collision with root package name */
    private int f4458b;

    /* renamed from: c  reason: collision with root package name */
    private int f4459c;
    private boolean d;
    private View e;

    public l(@NonNull a aVar) {
        super(aVar.f4460a);
        this.f4457a = aVar.f4460a;
        this.f4458b = aVar.f4461b;
        this.f4459c = aVar.f4462c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public l(@NonNull a aVar, @StyleRes int i) {
        super(aVar.f4460a, i);
        this.f4457a = aVar.f4460a;
        this.f4458b = aVar.f4461b;
        this.f4459c = aVar.f4462c;
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
        attributes.height = this.f4458b;
        attributes.width = this.f4459c;
        window.setAttributes(attributes);
    }

    /* compiled from: GoToBrowserDialog.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f4460a;

        /* renamed from: b  reason: collision with root package name */
        private int f4461b;

        /* renamed from: c  reason: collision with root package name */
        private int f4462c;
        private boolean d;
        private View e;
        private int f = -1;

        public a(Context context) {
            this.f4460a = context;
        }

        public a a(int i) {
            this.e = LayoutInflater.from(this.f4460a).inflate(i, (ViewGroup) null);
            return this;
        }

        public a b(int i) {
            this.f4461b = com.fotoable.youtube.music.util.w.a(this.f4460a, i);
            return this;
        }

        public a c(int i) {
            this.f4462c = com.fotoable.youtube.music.util.w.a(this.f4460a, i);
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

        public a a(int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            try {
                ((CheckBox) this.e.findViewById(i)).setOnCheckedChangeListener(onCheckedChangeListener);
            } catch (Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
            return this;
        }

        public CheckBox e(int i) {
            try {
                return (CheckBox) this.e.findViewById(i);
            } catch (Throwable th) {
                ThrowableExtension.printStackTrace(th);
                return null;
            }
        }

        public l a() {
            return this.f != -1 ? new l(this, this.f) : new l(this);
        }
    }
}
