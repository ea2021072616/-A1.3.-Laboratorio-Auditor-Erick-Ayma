package d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.widget.f2;
import androidx.core.widget.NestedScrollView;
import com.github.appintro.R;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n extends p0 implements DialogInterface {

    /* renamed from: l  reason: collision with root package name */
    public final l f2414l;

    public n(Context context, int i5) {
        super(context, g(context, i5));
        this.f2414l = new l(getContext(), this, getWindow());
    }

    public static int g(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final Button f(int i5) {
        l lVar = this.f2414l;
        if (i5 != -3) {
            if (i5 != -2) {
                if (i5 != -1) {
                    lVar.getClass();
                    return null;
                }
                return lVar.f2382k;
            }
            return lVar.o;
        }
        return lVar.f2389s;
    }

    @Override // d.p0, androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z4;
        View view;
        ListAdapter listAdapter;
        View findViewById;
        super.onCreate(bundle);
        l lVar = this.f2414l;
        lVar.f2373b.setContentView(lVar.F);
        Window window = lVar.f2374c;
        View findViewById2 = window.findViewById(R.id.parentPanel);
        View findViewById3 = findViewById2.findViewById(R.id.topPanel);
        View findViewById4 = findViewById2.findViewById(R.id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        View view2 = lVar.f2379h;
        Context context = lVar.f2372a;
        if (view2 == null) {
            view2 = lVar.f2380i != 0 ? LayoutInflater.from(context).inflate(lVar.f2380i, viewGroup, false) : null;
        }
        boolean z5 = view2 != null;
        if (!z5 || !l.a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z5) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (lVar.f2381j) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (lVar.f2378g != null) {
                ((LinearLayout.LayoutParams) ((f2) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(R.id.topPanel);
        View findViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup d5 = l.d(findViewById6, findViewById3);
        ViewGroup d6 = l.d(findViewById7, findViewById4);
        ViewGroup d7 = l.d(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        lVar.f2393w = nestedScrollView;
        nestedScrollView.setFocusable(false);
        lVar.f2393w.setNestedScrollingEnabled(false);
        TextView textView = (TextView) d6.findViewById(16908299);
        lVar.B = textView;
        if (textView != null) {
            CharSequence charSequence = lVar.f2377f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                lVar.f2393w.removeView(lVar.B);
                if (lVar.f2378g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) lVar.f2393w.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(lVar.f2393w);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(lVar.f2378g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    d6.setVisibility(8);
                }
            }
        }
        Button button = (Button) d7.findViewById(16908313);
        lVar.f2382k = button;
        d dVar = lVar.M;
        button.setOnClickListener(dVar);
        boolean isEmpty = TextUtils.isEmpty(lVar.f2383l);
        int i5 = lVar.f2375d;
        if (isEmpty && lVar.f2385n == null) {
            lVar.f2382k.setVisibility(8);
            z4 = false;
        } else {
            lVar.f2382k.setText(lVar.f2383l);
            Drawable drawable = lVar.f2385n;
            if (drawable != null) {
                drawable.setBounds(0, 0, i5, i5);
                lVar.f2382k.setCompoundDrawables(lVar.f2385n, null, null, null);
            }
            lVar.f2382k.setVisibility(0);
            z4 = true;
        }
        Button button2 = (Button) d7.findViewById(16908314);
        lVar.o = button2;
        button2.setOnClickListener(dVar);
        if (TextUtils.isEmpty(lVar.f2386p) && lVar.f2388r == null) {
            lVar.o.setVisibility(8);
        } else {
            lVar.o.setText(lVar.f2386p);
            Drawable drawable2 = lVar.f2388r;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i5, i5);
                lVar.o.setCompoundDrawables(lVar.f2388r, null, null, null);
            }
            lVar.o.setVisibility(0);
            z4 |= true;
        }
        Button button3 = (Button) d7.findViewById(16908315);
        lVar.f2389s = button3;
        button3.setOnClickListener(dVar);
        if (TextUtils.isEmpty(lVar.f2390t) && lVar.f2392v == null) {
            lVar.f2389s.setVisibility(8);
            view = null;
        } else {
            lVar.f2389s.setText(lVar.f2390t);
            Drawable drawable3 = lVar.f2392v;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, i5, i5);
                view = null;
                lVar.f2389s.setCompoundDrawables(lVar.f2392v, null, null, null);
            } else {
                view = null;
            }
            lVar.f2389s.setVisibility(0);
            z4 |= true;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z4) {
                l.b(lVar.f2382k);
            } else if (z4) {
                l.b(lVar.o);
            } else if (z4) {
                l.b(lVar.f2389s);
            }
        }
        if (!(z4)) {
            d7.setVisibility(8);
        }
        if (lVar.C != null) {
            d5.addView(lVar.C, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            lVar.f2396z = (ImageView) window.findViewById(16908294);
            if ((!TextUtils.isEmpty(lVar.f2376e)) && lVar.K) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                lVar.A = textView2;
                textView2.setText(lVar.f2376e);
                int i6 = lVar.f2394x;
                if (i6 != 0) {
                    lVar.f2396z.setImageResource(i6);
                } else {
                    Drawable drawable4 = lVar.f2395y;
                    if (drawable4 != null) {
                        lVar.f2396z.setImageDrawable(drawable4);
                    } else {
                        lVar.A.setPadding(lVar.f2396z.getPaddingLeft(), lVar.f2396z.getPaddingTop(), lVar.f2396z.getPaddingRight(), lVar.f2396z.getPaddingBottom());
                        lVar.f2396z.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                lVar.f2396z.setVisibility(8);
                d5.setVisibility(8);
            }
        }
        boolean z6 = viewGroup.getVisibility() != 8;
        int i7 = (d5 == null || d5.getVisibility() == 8) ? 0 : 1;
        boolean z7 = d7.getVisibility() != 8;
        if (!z7 && (findViewById = d6.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i7 != 0) {
            NestedScrollView nestedScrollView2 = lVar.f2393w;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = (lVar.f2377f == null && lVar.f2378g == null) ? view : d5.findViewById(R.id.titleDividerNoCustom);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = d6.findViewById(R.id.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = lVar.f2378g;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.getClass();
            if (!z7 || i7 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i7 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f127g, alertController$RecycleListView.getPaddingRight(), z7 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f128h);
            }
        }
        if (!z6) {
            View view3 = lVar.f2378g;
            if (view3 == null) {
                view3 = lVar.f2393w;
            }
            if (view3 != null) {
                int i8 = z7 ? 2 : 0;
                View findViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = h0.z0.f3233a;
                h0.p0.d(view3, i7 | i8, 3);
                if (findViewById11 != null) {
                    d6.removeView(findViewById11);
                }
                if (findViewById12 != null) {
                    d6.removeView(findViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = lVar.f2378g;
        if (alertController$RecycleListView2 == null || (listAdapter = lVar.D) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i9 = lVar.E;
        if (i9 > -1) {
            alertController$RecycleListView2.setItemChecked(i9, true);
            alertController$RecycleListView2.setSelection(i9);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2414l.f2393w;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2414l.f2393w;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i5, keyEvent);
    }

    @Override // d.p0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        l lVar = this.f2414l;
        lVar.f2376e = charSequence;
        TextView textView = lVar.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
