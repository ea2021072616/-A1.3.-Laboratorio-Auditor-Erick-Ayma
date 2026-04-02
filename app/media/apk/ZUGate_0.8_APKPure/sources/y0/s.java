package y0;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.github.appintro.R;
/* loaded from: classes.dex */
public abstract class s extends Fragment implements z, x, y, b {

    /* renamed from: h  reason: collision with root package name */
    public a0 f5637h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f5638i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5639j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5640k;

    /* renamed from: g  reason: collision with root package name */
    public final r f5636g = new r(this);

    /* renamed from: l  reason: collision with root package name */
    public int f5641l = R.layout.preference_list_fragment;

    /* renamed from: m  reason: collision with root package name */
    public final d.j f5642m = new d.j(this, Looper.getMainLooper());

    /* renamed from: n  reason: collision with root package name */
    public final androidx.activity.j f5643n = new androidx.activity.j(11, this);

    public final Preference g(String str) {
        PreferenceScreen preferenceScreen;
        a0 a0Var = this.f5637h;
        if (a0Var == null || (preferenceScreen = a0Var.f5590g) == null) {
            return null;
        }
        return preferenceScreen.A(str);
    }

    public abstract void h(String str);

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i5 = typedValue.resourceId;
        if (i5 == 0) {
            i5 = R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i5, false);
        a0 a0Var = new a0(requireContext());
        this.f5637h = a0Var;
        a0Var.f5593j = this;
        h(getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        TypedArray obtainStyledAttributes = requireContext().obtainStyledAttributes(null, e0.f5612h, R.attr.preferenceFragmentCompatStyle, 0);
        this.f5641l = obtainStyledAttributes.getResourceId(0, this.f5641l);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z4 = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(requireContext());
        View inflate = cloneInContext.inflate(this.f5641l, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            if (!requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup2.findViewById(R.id.recycler_view)) == null) {
                recyclerView = (RecyclerView) cloneInContext.inflate(R.layout.preference_recyclerview, viewGroup2, false);
                requireContext();
                recyclerView.setLayoutManager(new LinearLayoutManager(1));
                recyclerView.setAccessibilityDelegateCompat(new c0(recyclerView));
            }
            this.f5638i = recyclerView;
            r rVar = this.f5636g;
            recyclerView.i(rVar);
            if (drawable != null) {
                rVar.getClass();
                rVar.f5633b = drawable.getIntrinsicHeight();
            } else {
                rVar.f5633b = 0;
            }
            rVar.f5632a = drawable;
            s sVar = rVar.f5635d;
            RecyclerView recyclerView2 = sVar.f5638i;
            if (recyclerView2.f1249v.size() != 0) {
                r0 r0Var = recyclerView2.f1245t;
                if (r0Var != null) {
                    r0Var.c("Cannot invalidate item decorations during a scroll or layout");
                }
                recyclerView2.Q();
                recyclerView2.requestLayout();
            }
            if (dimensionPixelSize != -1) {
                rVar.f5633b = dimensionPixelSize;
                RecyclerView recyclerView3 = sVar.f5638i;
                if (recyclerView3.f1249v.size() != 0) {
                    r0 r0Var2 = recyclerView3.f1245t;
                    if (r0Var2 != null) {
                        r0Var2.c("Cannot invalidate item decorations during a scroll or layout");
                    }
                    recyclerView3.Q();
                    recyclerView3.requestLayout();
                }
            }
            rVar.f5634c = z4;
            if (this.f5638i.getParent() == null) {
                viewGroup2.addView(this.f5638i);
            }
            this.f5642m.post(this.f5643n);
            return inflate;
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        androidx.activity.j jVar = this.f5643n;
        d.j jVar2 = this.f5642m;
        jVar2.removeCallbacks(jVar);
        jVar2.removeMessages(1);
        if (this.f5639j) {
            this.f5638i.setAdapter(null);
            PreferenceScreen preferenceScreen = this.f5637h.f5590g;
            if (preferenceScreen != null) {
                preferenceScreen.o();
            }
        }
        this.f5638i = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = this.f5637h.f5590g;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        a0 a0Var = this.f5637h;
        a0Var.f5591h = this;
        a0Var.f5592i = this;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        a0 a0Var = this.f5637h;
        a0Var.f5591h = null;
        a0Var.f5592i = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        PreferenceScreen preferenceScreen;
        Bundle bundle2;
        PreferenceScreen preferenceScreen2;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreen2 = this.f5637h.f5590g) != null) {
            preferenceScreen2.b(bundle2);
        }
        if (this.f5639j && (preferenceScreen = this.f5637h.f5590g) != null) {
            this.f5638i.setAdapter(new v(preferenceScreen));
            preferenceScreen.k();
        }
        this.f5640k = true;
    }
}
