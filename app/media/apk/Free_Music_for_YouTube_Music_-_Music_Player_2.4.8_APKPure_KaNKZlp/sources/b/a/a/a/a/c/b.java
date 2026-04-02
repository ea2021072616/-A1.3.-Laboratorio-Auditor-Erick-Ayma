package b.a.a.a.a.c;

import java.util.Collection;
/* compiled from: Dependency.java */
/* loaded from: classes.dex */
public interface b<T> {
    void addDependency(T t);

    boolean areDependenciesMet();

    Collection<T> getDependencies();
}
