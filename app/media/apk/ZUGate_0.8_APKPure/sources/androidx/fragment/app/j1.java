package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f930a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f931b;

    public j1(View view, ArrayList arrayList) {
        this.f930a = view;
        this.f931b = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f930a.setVisibility(8);
        ArrayList arrayList = this.f931b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((View) arrayList.get(i5)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        transition.removeListener(this);
        transition.addListener(this);
    }
}
