package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
/* loaded from: classes2.dex */
public final class MapFactory<K, V> implements Factory<Map<K, V>> {
    private final Map<K, Provider<V>> contributingMap;

    private MapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = java.util.Collections.unmodifiableMap(map);
    }

    public static <K, V> MapFactory<K, V> create(Provider<Map<K, Provider<V>>> provider) {
        return new MapFactory<>(provider.get());
    }

    @Override // javax.inject.Provider
    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = Collections.newLinkedHashMapWithExpectedSize(this.contributingMap.size());
        for (Map.Entry<K, Provider<V>> entry : this.contributingMap.entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), entry.getValue().get());
        }
        return java.util.Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
