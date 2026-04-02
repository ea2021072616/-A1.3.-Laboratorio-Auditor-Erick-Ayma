package com.google.devtools.build.android.desugar.runtime;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class ThrowableExtension {
    private static final String ANDROID_OS_BUILD_VERSION = "android.os.Build$VERSION";
    static final AbstractDesugaringStrategy STRATEGY;
    public static final String SYSTEM_PROPERTY_TWR_DISABLE_MIMIC = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic";

    static {
        AbstractDesugaringStrategy nullDesugaringStrategy;
        try {
            Integer readApiLevelFromBuildVersion = readApiLevelFromBuildVersion();
            if (readApiLevelFromBuildVersion != null && readApiLevelFromBuildVersion.intValue() >= 19) {
                nullDesugaringStrategy = new ReuseDesugaringStrategy();
            } else if (useMimicStrategy()) {
                nullDesugaringStrategy = new NullDesugaringStrategy();
            } else {
                nullDesugaringStrategy = new NullDesugaringStrategy();
            }
        } catch (Throwable th) {
            System.err.println("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + NullDesugaringStrategy.class.getName() + "will be used. The error is: ");
            th.printStackTrace(System.err);
            nullDesugaringStrategy = new NullDesugaringStrategy();
        }
        STRATEGY = nullDesugaringStrategy;
    }

    public static AbstractDesugaringStrategy getStrategy() {
        return STRATEGY;
    }

    public static void addSuppressed(Throwable th, Throwable th2) {
        STRATEGY.addSuppressed(th, th2);
    }

    public static Throwable[] getSuppressed(Throwable th) {
        return STRATEGY.getSuppressed(th);
    }

    public static void printStackTrace(Throwable th) {
        STRATEGY.printStackTrace(th);
    }

    public static void printStackTrace(Throwable th, PrintWriter printWriter) {
        STRATEGY.printStackTrace(th, printWriter);
    }

    public static void printStackTrace(Throwable th, PrintStream printStream) {
        STRATEGY.printStackTrace(th, printStream);
    }

    private static boolean useMimicStrategy() {
        return !Boolean.getBoolean(SYSTEM_PROPERTY_TWR_DISABLE_MIMIC);
    }

    private static Integer readApiLevelFromBuildVersion() {
        try {
            return (Integer) Class.forName(ANDROID_OS_BUILD_VERSION).getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class AbstractDesugaringStrategy {
        protected static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];

        public abstract void addSuppressed(Throwable th, Throwable th2);

        public abstract Throwable[] getSuppressed(Throwable th);

        public abstract void printStackTrace(Throwable th);

        public abstract void printStackTrace(Throwable th, PrintStream printStream);

        public abstract void printStackTrace(Throwable th, PrintWriter printWriter);

        AbstractDesugaringStrategy() {
        }
    }

    /* loaded from: classes2.dex */
    static final class ReuseDesugaringStrategy extends AbstractDesugaringStrategy {
        ReuseDesugaringStrategy() {
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
            th.addSuppressed(th2);
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            return th.getSuppressed();
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* loaded from: classes2.dex */
    static final class MimicDesugaringStrategy extends AbstractDesugaringStrategy {
        static final String SUPPRESSED_PREFIX = "Suppressed: ";
        private final ConcurrentWeakIdentityHashMap map = new ConcurrentWeakIdentityHashMap();

        MimicDesugaringStrategy() {
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
            if (th2 == th) {
                throw new IllegalArgumentException("Self suppression is not allowed.", th2);
            }
            if (th2 == null) {
                throw new NullPointerException("The suppressed exception cannot be null.");
            }
            this.map.get(th, true).add(th2);
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            List<Throwable> list = this.map.get(th, false);
            return (list == null || list.isEmpty()) ? EMPTY_THROWABLE_ARRAY : (Throwable[]) list.toArray(EMPTY_THROWABLE_ARRAY);
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
            List<Throwable> list = this.map.get(th, false);
            if (list != null) {
                synchronized (list) {
                    for (Throwable th2 : list) {
                        System.err.print(SUPPRESSED_PREFIX);
                        th2.printStackTrace();
                    }
                }
            }
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
            List<Throwable> list = this.map.get(th, false);
            if (list != null) {
                synchronized (list) {
                    for (Throwable th2 : list) {
                        printStream.print(SUPPRESSED_PREFIX);
                        th2.printStackTrace(printStream);
                    }
                }
            }
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
            List<Throwable> list = this.map.get(th, false);
            if (list != null) {
                synchronized (list) {
                    for (Throwable th2 : list) {
                        printWriter.print(SUPPRESSED_PREFIX);
                        th2.printStackTrace(printWriter);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class ConcurrentWeakIdentityHashMap {
        private final ConcurrentHashMap<WeakKey, List<Throwable>> map = new ConcurrentHashMap<>(16, 0.75f, 10);
        private final ReferenceQueue<Throwable> referenceQueue = new ReferenceQueue<>();

        ConcurrentWeakIdentityHashMap() {
        }

        public List<Throwable> get(Throwable th, boolean z) {
            deleteEmptyKeys();
            List<Throwable> list = this.map.get(new WeakKey(th, null));
            if (z && list == null) {
                Vector vector = new Vector(2);
                List<Throwable> putIfAbsent = this.map.putIfAbsent(new WeakKey(th, this.referenceQueue), vector);
                return putIfAbsent == null ? vector : putIfAbsent;
            }
            return list;
        }

        int size() {
            return this.map.size();
        }

        void deleteEmptyKeys() {
            Reference<? extends Throwable> poll = this.referenceQueue.poll();
            while (poll != null) {
                this.map.remove(poll);
                poll = this.referenceQueue.poll();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class WeakKey extends WeakReference<Throwable> {
            private final int hash;

            public WeakKey(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
                super(th, referenceQueue);
                if (th == null) {
                    throw new NullPointerException("The referent cannot be null");
                }
                this.hash = System.identityHashCode(th);
            }

            public int hashCode() {
                return this.hash;
            }

            public boolean equals(Object obj) {
                if (obj == null || obj.getClass() != getClass()) {
                    return false;
                }
                if (this != obj) {
                    WeakKey weakKey = (WeakKey) obj;
                    return this.hash == weakKey.hash && get() == weakKey.get();
                }
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class NullDesugaringStrategy extends AbstractDesugaringStrategy {
        NullDesugaringStrategy() {
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            return EMPTY_THROWABLE_ARRAY;
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        @Override // com.google.devtools.build.android.desugar.runtime.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }
}
