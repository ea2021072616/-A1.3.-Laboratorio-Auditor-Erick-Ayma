package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes.dex */
public class SearchView$SearchAutoComplete extends r {

    /* renamed from: k  reason: collision with root package name */
    public int f222k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f223l;

    /* renamed from: m  reason: collision with root package name */
    public final androidx.activity.j f224m;

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f224m = new androidx.activity.j(4, this);
        this.f222k = getThreshold();
    }

    private int getSearchViewTextMinWidthDp() {
        Configuration configuration = getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (i5 < 960 || i6 < 720 || configuration.orientation != 2) {
            if (i5 < 600) {
                return (i5 < 640 || i6 < 480) ? 160 : 192;
            }
            return 192;
        }
        return 256;
    }

    @Override // android.widget.AutoCompleteTextView
    public final boolean enoughToFilter() {
        return this.f222k <= 0 || super.enoughToFilter();
    }

    @Override // androidx.appcompat.widget.r, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.f223l) {
            androidx.activity.j jVar = this.f224m;
            removeCallbacks(jVar);
            post(jVar);
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        throw null;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
        if (i5 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    throw null;
                }
            }
        }
        return super.onKeyPreIme(i5, keyEvent);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (z4) {
            throw null;
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public final void performCompletion() {
    }

    @Override // android.widget.AutoCompleteTextView
    public final void replaceText(CharSequence charSequence) {
    }

    public void setImeVisibility(boolean z4) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        androidx.activity.j jVar = this.f224m;
        if (!z4) {
            this.f223l = false;
            removeCallbacks(jVar);
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else if (!inputMethodManager.isActive(this)) {
            this.f223l = true;
        } else {
            this.f223l = false;
            removeCallbacks(jVar);
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public void setSearchView(a3 a3Var) {
    }

    @Override // android.widget.AutoCompleteTextView
    public void setThreshold(int i5) {
        super.setThreshold(i5);
        this.f222k = i5;
    }
}
