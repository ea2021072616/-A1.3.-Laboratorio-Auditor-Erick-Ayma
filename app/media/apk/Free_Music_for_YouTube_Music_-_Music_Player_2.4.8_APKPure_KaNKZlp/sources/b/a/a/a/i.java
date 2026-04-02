package b.a.a.a;

import android.content.Context;
import b.a.a.a.a.b.o;
import java.io.File;
import java.util.Collection;
/* compiled from: Kit.java */
/* loaded from: classes.dex */
public abstract class i<Result> implements Comparable<i> {
    Context context;
    c fabric;
    o idManager;
    f<Result> initializationCallback;
    h<Result> initializationTask = new h<>(this);
    final b.a.a.a.a.c.d dependsOnAnnotation = (b.a.a.a.a.c.d) getClass().getAnnotation(b.a.a.a.a.c.d.class);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result doInBackground();

    public abstract String getIdentifier();

    public abstract String getVersion();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void injectParameters(Context context, c cVar, f<Result> fVar, o oVar) {
        this.fabric = cVar;
        this.context = new d(context, getIdentifier(), getPath());
        this.initializationCallback = fVar;
        this.idManager = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initialize() {
        this.initializationTask.a(this.fabric.f(), (Object[]) new Void[]{null});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onPreExecute() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelled(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o getIdManager() {
        return this.idManager;
    }

    public Context getContext() {
        return this.context;
    }

    public c getFabric() {
        return this.fabric;
    }

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        if (containsAnnotatedDependency(iVar)) {
            return 1;
        }
        if (iVar.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (!hasAnnotatedDependency() || iVar.hasAnnotatedDependency()) {
            return (hasAnnotatedDependency() || !iVar.hasAnnotatedDependency()) ? 0 : -1;
        }
        return 1;
    }

    boolean containsAnnotatedDependency(i iVar) {
        if (hasAnnotatedDependency()) {
            for (Class<?> cls : this.dependsOnAnnotation.a()) {
                if (cls.isAssignableFrom(iVar.getClass())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<b.a.a.a.a.c.l> getDependencies() {
        return this.initializationTask.getDependencies();
    }
}
