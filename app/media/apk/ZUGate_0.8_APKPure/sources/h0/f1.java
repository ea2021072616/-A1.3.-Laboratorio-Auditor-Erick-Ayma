package h0;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class f1 implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3126b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3127c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3128d;

    public f1(ViewGroup viewGroup) {
        this.f3128d = viewGroup;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.f3126b;
        Object obj = this.f3128d;
        switch (i5) {
            case 0:
                return this.f3127c < ((ViewGroup) obj).getChildCount();
            default:
                return this.f3127c < ((Object[]) obj).length;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.f3126b;
        Object obj = this.f3128d;
        switch (i5) {
            case 0:
                int i6 = this.f3127c;
                this.f3127c = i6 + 1;
                View childAt = ((ViewGroup) obj).getChildAt(i6);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            default:
                try {
                    int i7 = this.f3127c;
                    this.f3127c = i7 + 1;
                    return ((Object[]) obj)[i7];
                } catch (ArrayIndexOutOfBoundsException e5) {
                    this.f3127c--;
                    throw new NoSuchElementException(e5.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3126b) {
            case 0:
                int i5 = this.f3127c - 1;
                this.f3127c = i5;
                ((ViewGroup) this.f3128d).removeViewAt(i5);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f1(Object[] objArr) {
        this.f3128d = objArr;
    }
}
