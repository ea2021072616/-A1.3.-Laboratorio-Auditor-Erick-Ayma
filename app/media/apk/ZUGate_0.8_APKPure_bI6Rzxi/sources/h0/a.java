package h0;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.github.appintro.R;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class a extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final b f3090a;

    public a(b bVar) {
        this.f3090a = bVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f3090a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        androidx.recyclerview.widget.b0 b5 = this.f3090a.b(view);
        if (b5 != null) {
            return (AccessibilityNodeProvider) b5.f1296g;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f3090a.c(view, accessibilityEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        i0.j jVar = new i0.j(accessibilityNodeInfo);
        WeakHashMap weakHashMap = z0.f3233a;
        Boolean bool = (Boolean) new j0(R.id.tag_screen_reader_focusable, 0).b(view);
        boolean z4 = true;
        boolean z5 = (bool == null || !bool.booleanValue()) ? 0 : 1;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z5);
        } else {
            Bundle extras = accessibilityNodeInfo.getExtras();
            if (extras != null) {
                extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", z5 | (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-2)));
            }
        }
        Boolean bool2 = (Boolean) new j0(R.id.tag_accessibility_heading, 3).b(view);
        z4 = (bool2 == null || !bool2.booleanValue()) ? false : false;
        if (i5 >= 28) {
            accessibilityNodeInfo.setHeading(z4);
        } else {
            Bundle extras2 = accessibilityNodeInfo.getExtras();
            if (extras2 != null) {
                extras2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (z4 ? 2 : 0) | (extras2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-3)));
            }
        }
        CharSequence e5 = z0.e(view);
        if (i5 >= 28) {
            accessibilityNodeInfo.setPaneTitle(e5);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", e5);
        }
        CharSequence charSequence = (CharSequence) new j0(R.id.tag_state_description, 64, 30, 2).b(view);
        if (i5 >= 30) {
            i0.f.c(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.f3090a.d(view, jVar);
        accessibilityNodeInfo.getText();
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            jVar.b((i0.e) list.get(i6));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f3090a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f3090a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
        return this.f3090a.g(view, i5, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i5) {
        this.f3090a.h(view, i5);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f3090a.i(view, accessibilityEvent);
    }
}
