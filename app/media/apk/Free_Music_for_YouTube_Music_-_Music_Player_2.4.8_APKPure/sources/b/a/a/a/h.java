package b.a.a.a;

import b.a.a.a.a.b.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitializationTask.java */
/* loaded from: classes.dex */
public class h<Result> extends b.a.a.a.a.c.f<Void, Void, Result> {

    /* renamed from: a  reason: collision with root package name */
    final i<Result> f270a;

    public h(i<Result> iVar) {
        this.f270a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.a.c.a
    public void a() {
        super.a();
        t a2 = a("onPreExecute");
        try {
            try {
                try {
                    boolean onPreExecute = this.f270a.onPreExecute();
                    a2.b();
                    if (!onPreExecute) {
                        a(true);
                    }
                } catch (Exception e) {
                    c.h().e("Fabric", "Failure onPreExecute()", e);
                    a2.b();
                    a(true);
                }
            } catch (b.a.a.a.a.c.m e2) {
                throw e2;
            }
        } catch (Throwable th) {
            a2.b();
            a(true);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.a.a.c.a
    public Result a(Void... voidArr) {
        t a2 = a("doInBackground");
        Result result = null;
        if (!d()) {
            result = this.f270a.doInBackground();
        }
        a2.b();
        return result;
    }

    @Override // b.a.a.a.a.c.a
    protected void a(Result result) {
        this.f270a.onPostExecute(result);
        this.f270a.initializationCallback.a((f<Result>) result);
    }

    @Override // b.a.a.a.a.c.a
    protected void b(Result result) {
        this.f270a.onCancelled(result);
        this.f270a.initializationCallback.a(new g(this.f270a.getIdentifier() + " Initialization was cancelled"));
    }

    @Override // b.a.a.a.a.c.f, b.a.a.a.a.c.i
    public b.a.a.a.a.c.e getPriority() {
        return b.a.a.a.a.c.e.HIGH;
    }

    private t a(String str) {
        t tVar = new t(this.f270a.getIdentifier() + "." + str, "KitInitialization");
        tVar.a();
        return tVar;
    }
}
