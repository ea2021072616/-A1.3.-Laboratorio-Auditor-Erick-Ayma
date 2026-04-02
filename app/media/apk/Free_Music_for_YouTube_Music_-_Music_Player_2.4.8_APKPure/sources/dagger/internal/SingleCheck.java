package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;
/* loaded from: classes2.dex */
public final class SingleCheck<T> implements Lazy<T>, Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object UNINITIALIZED;
    private volatile Factory<T> factory;
    private volatile Object instance = UNINITIALIZED;

    static {
        $assertionsDisabled = !SingleCheck.class.desiredAssertionStatus();
        UNINITIALIZED = new Object();
    }

    private SingleCheck(Factory<T> factory) {
        if (!$assertionsDisabled && factory == null) {
            throw new AssertionError();
        }
        this.factory = factory;
    }

    @Override // dagger.Lazy, javax.inject.Provider
    public T get() {
        Factory<T> factory = this.factory;
        if (this.instance == UNINITIALIZED) {
            this.instance = factory.get();
            this.factory = null;
        }
        return (T) this.instance;
    }

    public static <T> Provider<T> provider(Factory<T> factory) {
        return new SingleCheck((Factory) Preconditions.checkNotNull(factory));
    }
}
