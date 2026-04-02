package dagger.internal;

import android.support.v7.widget.ActivityChooserView;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
/* loaded from: classes2.dex */
final class Collections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private Collections() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet<>(calculateInitialCapacity(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(calculateInitialCapacity(i));
    }

    private static int calculateInitialCapacity(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
