package androidx.activity.result;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.z2;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.h2;
import h0.x;
import java.util.ArrayList;
import s.n;
import s.q;
/* loaded from: classes.dex */
public final class j implements x {

    /* renamed from: g  reason: collision with root package name */
    public int f99g;

    /* renamed from: h  reason: collision with root package name */
    public int f100h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f101i;

    /* renamed from: j  reason: collision with root package name */
    public Object f102j;

    public j(Context context, XmlResourceParser xmlResourceParser) {
        this.f101i = new ArrayList();
        this.f100h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), q.f4800h);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == 0) {
                this.f99g = obtainStyledAttributes.getResourceId(index, this.f99g);
            } else if (index == 1) {
                this.f100h = obtainStyledAttributes.getResourceId(index, this.f100h);
                String resourceTypeName = context.getResources().getResourceTypeName(this.f100h);
                context.getResources().getResourceName(this.f100h);
                if ("layout".equals(resourceTypeName)) {
                    n nVar = new n();
                    this.f102j = nVar;
                    nVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f100h, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // h0.x
    public final h2 a(View view, h2 h2Var) {
        int i5 = h2Var.a(7).f5750b;
        int i6 = this.f99g;
        Object obj = this.f101i;
        if (i6 >= 0) {
            View view2 = (View) obj;
            view2.getLayoutParams().height = this.f99g + i5;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        View view3 = (View) obj;
        view3.setPadding(view3.getPaddingLeft(), this.f100h + i5, view3.getPaddingRight(), view3.getPaddingBottom());
        return h2Var;
    }

    public j(com.google.android.material.datepicker.n nVar, int i5, View view, int i6) {
        this.f102j = nVar;
        this.f99g = i5;
        this.f101i = view;
        this.f100h = i6;
    }

    public j(s3.n nVar, z2 z2Var) {
        this.f101i = new SparseArray();
        this.f102j = nVar;
        this.f99g = z2Var.i(28, 0);
        this.f100h = z2Var.i(52, 0);
    }
}
