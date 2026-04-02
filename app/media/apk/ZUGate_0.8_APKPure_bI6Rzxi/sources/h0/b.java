package h0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.github.appintro.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final View.AccessibilityDelegate f3104c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f3105a;

    /* renamed from: b  reason: collision with root package name */
    public final a f3106b;

    public b() {
        this(f3104c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f3105a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.recyclerview.widget.b0 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f3105a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new androidx.recyclerview.widget.b0(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f3105a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, i0.j jVar) {
        this.f3105a.onInitializeAccessibilityNodeInfo(view, jVar.f3375a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f3105a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f3105a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i5, Bundle bundle) {
        boolean z4;
        WeakReference weakReference;
        boolean z5;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= list.size()) {
                break;
            }
            i0.e eVar = (i0.e) list.get(i6);
            if (eVar.a() == i5) {
                i0.t tVar = eVar.f3373d;
                if (tVar != null) {
                    Class cls = eVar.f3372c;
                    if (cls != null) {
                        try {
                            androidx.appcompat.widget.b0.n(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                            throw null;
                        } catch (Exception e5) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e5);
                        }
                    }
                    z4 = tVar.c(view);
                }
            } else {
                i6++;
            }
        }
        z4 = false;
        if (!z4) {
            z4 = this.f3105a.performAccessibilityAction(view, i5, bundle);
        }
        if (z4 || i5 != R.id.accessibility_action_clickable_span || bundle == null) {
            return z4;
        }
        int i7 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i7)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
                for (int i8 = 0; clickableSpanArr != null && i8 < clickableSpanArr.length; i8++) {
                    if (clickableSpan.equals(clickableSpanArr[i8])) {
                        z5 = true;
                        break;
                    }
                }
            }
            z5 = false;
            if (z5) {
                clickableSpan.onClick(view);
                z6 = true;
            }
        }
        return z6;
    }

    public void h(View view, int i5) {
        this.f3105a.sendAccessibilityEvent(view, i5);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f3105a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f3105a = accessibilityDelegate;
        this.f3106b = new a(this);
    }
}
