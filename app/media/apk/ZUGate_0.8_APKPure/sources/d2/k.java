package d2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k implements d, e2.c, c {

    /* renamed from: g  reason: collision with root package name */
    public static final u1.b f2528g = new u1.b("proto");

    /* renamed from: b  reason: collision with root package name */
    public final n f2529b;

    /* renamed from: c  reason: collision with root package name */
    public final f2.a f2530c;

    /* renamed from: d  reason: collision with root package name */
    public final f2.a f2531d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2532e;

    /* renamed from: f  reason: collision with root package name */
    public final z3.a f2533f;

    public k(f2.a aVar, f2.a aVar2, a aVar3, n nVar, z3.a aVar4) {
        this.f2529b = nVar;
        this.f2530c = aVar;
        this.f2531d = aVar2;
        this.f2532e = aVar3;
        this.f2533f = aVar4;
    }

    public static Long G(SQLiteDatabase sQLiteDatabase, x1.i iVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.f5461a, String.valueOf(g2.a.a(iVar.f5463c))));
        byte[] bArr = iVar.f5462b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) L(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new h0.h(16));
    }

    public static String K(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f2513a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object L(Cursor cursor, i iVar) {
        try {
            return iVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    public final Object H(i iVar) {
        SQLiteDatabase j5 = j();
        j5.beginTransaction();
        try {
            Object a5 = iVar.a(j5);
            j5.setTransactionSuccessful();
            return a5;
        } finally {
            j5.endTransaction();
        }
    }

    public final ArrayList I(SQLiteDatabase sQLiteDatabase, x1.i iVar, int i5) {
        ArrayList arrayList = new ArrayList();
        Long G = G(sQLiteDatabase, iVar);
        if (G == null) {
            return arrayList;
        }
        L(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{G.toString()}, null, null, null, String.valueOf(i5)), new e1.h(this, arrayList, iVar, 4));
        return arrayList;
    }

    public final Object J(e2.b bVar) {
        SQLiteDatabase j5 = j();
        h0.h hVar = new h0.h(12);
        f2.b bVar2 = (f2.b) this.f2531d;
        long a5 = bVar2.a();
        while (true) {
            try {
                j5.beginTransaction();
            } catch (SQLiteDatabaseLockedException e5) {
                if (bVar2.a() >= this.f2532e.f2510c + a5) {
                    hVar.a(e5);
                    break;
                }
                SystemClock.sleep(50L);
            }
        }
        try {
            Object b5 = bVar.b();
            j5.setTransactionSuccessful();
            return b5;
        } finally {
            j5.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2529b.close();
    }

    public final SQLiteDatabase j() {
        Object a5;
        n nVar = this.f2529b;
        Objects.requireNonNull(nVar);
        h0.h hVar = new h0.h(10);
        f2.b bVar = (f2.b) this.f2531d;
        long a6 = bVar.a();
        while (true) {
            try {
                a5 = nVar.getWritableDatabase();
                break;
            } catch (SQLiteDatabaseLockedException e5) {
                if (bVar.a() >= this.f2532e.f2510c + a6) {
                    a5 = hVar.a(e5);
                    break;
                }
                SystemClock.sleep(50L);
            }
        }
        return (SQLiteDatabase) a5;
    }
}
