package dagger.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
/* loaded from: classes2.dex */
public final class SetFactory<T> implements Factory<Set<T>> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String ARGUMENTS_MUST_BE_NON_NULL = "SetFactory.create() requires its arguments to be non-null";
    private static final Factory<Set<Object>> EMPTY_FACTORY;
    private final List<Provider<Set<T>>> contributingProviders;

    static {
        $assertionsDisabled = !SetFactory.class.desiredAssertionStatus();
        EMPTY_FACTORY = new Factory<Set<Object>>() { // from class: dagger.internal.SetFactory.1
            @Override // javax.inject.Provider
            public Set<Object> get() {
                return java.util.Collections.emptySet();
            }
        };
    }

    public static <T> Factory<Set<T>> create() {
        return (Factory<Set<T>>) EMPTY_FACTORY;
    }

    public static <T> Factory<Set<T>> create(Factory<Set<T>> factory) {
        if ($assertionsDisabled || factory != null) {
            return factory;
        }
        throw new AssertionError(ARGUMENTS_MUST_BE_NON_NULL);
    }

    public static <T> Factory<Set<T>> create(Provider<Set<T>>... providerArr) {
        if ($assertionsDisabled || providerArr != null) {
            List asList = Arrays.asList(providerArr);
            if ($assertionsDisabled || !asList.contains(null)) {
                if ($assertionsDisabled || !hasDuplicates(asList)) {
                    return new SetFactory(asList);
                }
                throw new AssertionError("Codegen error?  Duplicates in the provider list");
            }
            throw new AssertionError("Codegen error?  Null within provider list.");
        }
        throw new AssertionError(ARGUMENTS_MUST_BE_NON_NULL);
    }

    private static boolean hasDuplicates(List<? extends Object> list) {
        return list.size() != new HashSet(list).size();
    }

    private SetFactory(List<Provider<Set<T>>> list) {
        this.contributingProviders = list;
    }

    @Override // javax.inject.Provider
    public Set<T> get() {
        ArrayList arrayList = new ArrayList(this.contributingProviders.size());
        int size = this.contributingProviders.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Provider<Set<T>> provider = this.contributingProviders.get(i);
            Set<T> set = provider.get();
            if (set == null) {
                String valueOf = String.valueOf(provider);
                throw new NullPointerException(new StringBuilder(String.valueOf(valueOf).length() + 14).append(valueOf).append(" returned null").toString());
            }
            arrayList.add(set);
            i++;
            i2 += set.size();
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = Collections.newLinkedHashSetWithExpectedSize(i2);
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            for (Object obj : (Set) arrayList.get(i3)) {
                if (obj == null) {
                    throw new NullPointerException("a null element was provided");
                }
                newLinkedHashSetWithExpectedSize.add(obj);
            }
        }
        return java.util.Collections.unmodifiableSet(newLinkedHashSetWithExpectedSize);
    }
}
