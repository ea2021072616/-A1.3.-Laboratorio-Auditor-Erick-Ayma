package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class b0 implements TextWatcher, SpanWatcher {

    /* renamed from: g  reason: collision with root package name */
    public final Object f745g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f746h = new AtomicInteger(0);

    public b0(Object obj) {
        this.f745g = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f745g).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        ((TextWatcher) this.f745g).beforeTextChanged(charSequence, i5, i6, i7);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i5, int i6) {
        if (this.f746h.get() <= 0 || !(obj instanceof e0)) {
            ((SpanWatcher) this.f745g).onSpanAdded(spannable, obj, i5, i6);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        if (this.f746h.get() <= 0 || !(obj instanceof e0)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (i5 > i6) {
                    i5 = 0;
                }
                if (i7 > i8) {
                    i9 = i5;
                    i10 = 0;
                    ((SpanWatcher) this.f745g).onSpanChanged(spannable, obj, i9, i6, i10, i8);
                }
            }
            i9 = i5;
            i10 = i7;
            ((SpanWatcher) this.f745g).onSpanChanged(spannable, obj, i9, i6, i10, i8);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i5, int i6) {
        if (this.f746h.get() <= 0 || !(obj instanceof e0)) {
            ((SpanWatcher) this.f745g).onSpanRemoved(spannable, obj, i5, i6);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        ((TextWatcher) this.f745g).onTextChanged(charSequence, i5, i6, i7);
    }
}
