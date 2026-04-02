package com.facebook.ads.internal.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.facebook.ads.internal.e.f;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1292a = "SELECT tokens." + h.f1305a.f1287b + ", tokens." + h.f1306b.f1287b + ", events." + c.f1289a.f1287b + ", events." + c.f1291c.f1287b + ", events." + c.d.f1287b + ", events." + c.e.f1287b + ", events." + c.f.f1287b + ", events." + c.g.f1287b + ", events." + c.h.f1287b + " FROM events JOIN tokens ON events." + c.f1290b.f1287b + " = tokens." + h.f1305a.f1287b + " ORDER BY events." + c.e.f1287b + " ASC";

    /* renamed from: b  reason: collision with root package name */
    private final Context f1293b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1294c = new h(this);
    private final c d = new c(this);
    private SQLiteOpenHelper e;

    public d(Context context) {
        this.f1293b = context;
    }

    private synchronized SQLiteDatabase h() {
        if (this.e == null) {
            this.e = new e(this.f1293b, this);
        }
        return this.e.getWritableDatabase();
    }

    @WorkerThread
    public Cursor a(int i) {
        return a().rawQuery(f1292a + " LIMIT " + String.valueOf(i), null);
    }

    public SQLiteDatabase a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
        }
        return h();
    }

    public <T> AsyncTask a(final f<T> fVar, final a<T> aVar) {
        return com.facebook.ads.internal.util.g.a(new AsyncTask<Void, Void, T>() { // from class: com.facebook.ads.internal.e.d.1
            private f.a d;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public T doInBackground(Void... voidArr) {
                T t = null;
                try {
                    t = (T) fVar.b();
                    this.d = fVar.c();
                    return t;
                } catch (SQLiteException e) {
                    this.d = f.a.UNKNOWN;
                    return t;
                }
            }

            @Override // android.os.AsyncTask
            protected void onPostExecute(T t) {
                if (this.d == null) {
                    aVar.a(t);
                } else {
                    aVar.a(this.d.a(), this.d.b());
                }
                aVar.a();
            }
        }, new Void[0]);
    }

    public AsyncTask a(final com.facebook.ads.internal.g.d dVar, a<String> aVar) {
        return a(new i<String>() { // from class: com.facebook.ads.internal.e.d.2
            @Override // com.facebook.ads.internal.e.f
            /* renamed from: a */
            public String b() {
                try {
                    SQLiteDatabase a2 = d.this.a();
                    a2.beginTransaction();
                    String a3 = dVar.d() != null ? d.this.d.a(d.this.f1294c.a(dVar.d()), dVar.a().f1366c, dVar.b(), dVar.e(), dVar.f(), dVar.g(), dVar.h()) : null;
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    return a3;
                } catch (Exception e) {
                    a(f.a.DATABASE_INSERT);
                    return null;
                }
            }
        }, aVar);
    }

    @WorkerThread
    public boolean a(String str) {
        return this.d.a(str);
    }

    public void b() {
        for (g gVar : c()) {
            gVar.e();
        }
        if (this.e != null) {
            this.e.close();
            this.e = null;
        }
    }

    public g[] c() {
        return new g[]{this.f1294c, this.d};
    }

    public Cursor d() {
        return this.d.c();
    }

    @WorkerThread
    public Cursor e() {
        return this.d.d();
    }

    @WorkerThread
    public Cursor f() {
        return this.f1294c.c();
    }

    @WorkerThread
    public void g() {
        this.f1294c.d();
    }
}
