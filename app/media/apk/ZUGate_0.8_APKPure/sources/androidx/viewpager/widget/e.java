package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
/* loaded from: classes.dex */
public final class e extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f1600d;

    public e(l lVar) {
        this.f1600d = lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.getCount() > 1) goto L5;
     */
    @Override // h0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            super.c(r3, r4)
            java.lang.Class<androidx.viewpager.widget.l> r3 = androidx.viewpager.widget.l.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            androidx.viewpager.widget.l r3 = r2.f1600d
            androidx.viewpager.widget.a r0 = r3.mAdapter
            if (r0 == 0) goto L1a
            int r0 = r0.getCount()
            r1 = 1
            if (r0 <= r1) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            r4.setScrollable(r1)
            int r0 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 != r1) goto L3b
            androidx.viewpager.widget.a r0 = r3.mAdapter
            if (r0 == 0) goto L3b
            int r0 = r0.getCount()
            r4.setItemCount(r0)
            int r0 = r3.mCurItem
            r4.setFromIndex(r0)
            int r3 = r3.mCurItem
            r4.setToIndex(r3)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.e.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        jVar.h(l.class.getName());
        l lVar = this.f1600d;
        a aVar = lVar.mAdapter;
        accessibilityNodeInfo.setScrollable(aVar != null && aVar.getCount() > 1);
        if (lVar.canScrollHorizontally(1)) {
            jVar.a(4096);
        }
        if (lVar.canScrollHorizontally(-1)) {
            jVar.a(8192);
        }
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        if (super.g(view, i5, bundle)) {
            return true;
        }
        l lVar = this.f1600d;
        if (i5 == 4096) {
            if (lVar.canScrollHorizontally(1)) {
                lVar.setCurrentItem(lVar.mCurItem + 1);
                return true;
            }
            return false;
        } else if (i5 == 8192 && lVar.canScrollHorizontally(-1)) {
            lVar.setCurrentItem(lVar.mCurItem - 1);
            return true;
        } else {
            return false;
        }
    }
}
