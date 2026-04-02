package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;
/* loaded from: classes2.dex */
public final class DoubleCheck<T> implements Lazy<T>, Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object UNINITIALIZED;
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    static {
        $assertionsDisabled = !DoubleCheck.class.desiredAssertionStatus();
        UNINITIALIZED = new Object();
    }

    private DoubleCheck(Provider<T> provider) {
        if (!$assertionsDisabled && provider == null) {
            throw new AssertionError();
        }
        this.provider = provider;
    }

    @Override // dagger.Lazy, javax.inject.Provider
    public T get() {
        T t = (T) this.instance;
        if (t == UNINITIALIZED) {
            synchronized (this) {
                t = this.instance;
                if (t == UNINITIALIZED) {
                    t = this.provider.get();
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }

    public static <T> Provider<T> provider(Provider<T> provider) {
        Preconditions.checkNotNull(provider);
        return provider instanceof DoubleCheck ? provider : new DoubleCheck(provider);
    }

    public static <T> Lazy<T> lazy(Provider<T> provider) {
        return provider instanceof Lazy ? (Lazy) provider : new DoubleCheck((Provider) Preconditions.checkNotNull(provider));
    }
}
