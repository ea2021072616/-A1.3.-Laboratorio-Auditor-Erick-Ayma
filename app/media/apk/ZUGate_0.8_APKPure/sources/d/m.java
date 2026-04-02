package d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public final class m implements i0.t {

    /* renamed from: g  reason: collision with root package name */
    public int f2397g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f2398h;

    public /* synthetic */ m(int i5, Object obj) {
        this.f2398h = obj;
        this.f2397g = i5;
    }

    public final n a() {
        ListAdapter listAdapter;
        i iVar = (i) this.f2398h;
        n nVar = new n(iVar.f2339a, this.f2397g);
        View view = iVar.f2343e;
        l lVar = nVar.f2414l;
        if (view != null) {
            lVar.C = view;
        } else {
            CharSequence charSequence = iVar.f2342d;
            if (charSequence != null) {
                lVar.f2376e = charSequence;
                TextView textView = lVar.A;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = iVar.f2341c;
            if (drawable != null) {
                lVar.f2395y = drawable;
                lVar.f2394x = 0;
                ImageView imageView = lVar.f2396z;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    lVar.f2396z.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = iVar.f2344f;
        if (charSequence2 != null) {
            lVar.f2377f = charSequence2;
            TextView textView2 = lVar.B;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = iVar.f2345g;
        if (charSequence3 != null) {
            lVar.e(-1, charSequence3, iVar.f2346h);
        }
        CharSequence charSequence4 = iVar.f2347i;
        if (charSequence4 != null) {
            lVar.e(-2, charSequence4, iVar.f2348j);
        }
        CharSequence charSequence5 = iVar.f2349k;
        if (charSequence5 != null) {
            lVar.e(-3, charSequence5, iVar.f2350l);
        }
        if (iVar.f2353p != null || iVar.f2354q != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) iVar.f2340b.inflate(lVar.G, (ViewGroup) null);
            if (iVar.f2359v) {
                listAdapter = new f(iVar, iVar.f2339a, lVar.H, iVar.f2353p, alertController$RecycleListView);
            } else {
                int i5 = iVar.f2360w ? lVar.I : lVar.J;
                listAdapter = iVar.f2354q;
                if (listAdapter == null) {
                    listAdapter = new k(iVar.f2339a, i5, iVar.f2353p);
                }
            }
            lVar.D = listAdapter;
            lVar.E = iVar.f2361x;
            if (iVar.f2355r != null) {
                alertController$RecycleListView.setOnItemClickListener(new g(iVar, 0, lVar));
            } else if (iVar.f2362y != null) {
                alertController$RecycleListView.setOnItemClickListener(new h(iVar, alertController$RecycleListView, lVar));
            }
            if (iVar.f2360w) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (iVar.f2359v) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            lVar.f2378g = alertController$RecycleListView;
        }
        View view2 = iVar.f2357t;
        if (view2 != null) {
            lVar.f2379h = view2;
            lVar.f2380i = 0;
            lVar.f2381j = false;
        } else {
            int i6 = iVar.f2356s;
            if (i6 != 0) {
                lVar.f2379h = null;
                lVar.f2380i = i6;
                lVar.f2381j = false;
            }
        }
        nVar.setCancelable(iVar.f2351m);
        if (iVar.f2351m) {
            nVar.setCanceledOnTouchOutside(true);
        }
        nVar.setOnCancelListener(iVar.f2352n);
        iVar.getClass();
        nVar.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = iVar.o;
        if (onKeyListener != null) {
            nVar.setOnKeyListener(onKeyListener);
        }
        return nVar;
    }

    public final void b(int i5, DialogInterface.OnClickListener onClickListener) {
        i iVar = (i) this.f2398h;
        iVar.f2347i = iVar.f2339a.getText(i5);
        iVar.f2348j = onClickListener;
    }

    @Override // i0.t
    public final boolean c(View view) {
        ((BottomSheetBehavior) this.f2398h).H(this.f2397g);
        return true;
    }

    public final void d(int i5, DialogInterface.OnClickListener onClickListener) {
        i iVar = (i) this.f2398h;
        iVar.f2345g = iVar.f2339a.getText(i5);
        iVar.f2346h = onClickListener;
    }

    public final void e(int i5) {
        i iVar = (i) this.f2398h;
        iVar.f2342d = iVar.f2339a.getText(i5);
    }

    public final void f(View view) {
        i iVar = (i) this.f2398h;
        iVar.f2357t = view;
        iVar.f2356s = 0;
        iVar.getClass();
    }

    public m(Context context) {
        int g5 = n.g(context, 0);
        this.f2398h = new i(new ContextThemeWrapper(context, n.g(context, g5)));
        this.f2397g = g5;
    }

    public m(int i5, e0.g[] gVarArr) {
        this.f2397g = i5;
        this.f2398h = gVarArr;
    }
}
