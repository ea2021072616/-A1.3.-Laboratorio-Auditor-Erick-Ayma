package d2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final /* synthetic */ class e implements i {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2516g = 1;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f2517h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f2518i;

    public /* synthetic */ e(long j5, x1.i iVar) {
        this.f2517h = j5;
        this.f2518i = iVar;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        int i5 = this.f2516g;
        long j5 = this.f2517h;
        Object obj2 = this.f2518i;
        switch (i5) {
            case 0:
                k kVar = (k) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                kVar.getClass();
                String[] strArr = {String.valueOf(j5)};
                k.L(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new g(kVar, 1));
                return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
            default:
                x1.i iVar = (x1.i) obj2;
                SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j5));
                String str = iVar.f5461a;
                u1.c cVar = iVar.f5463c;
                if (sQLiteDatabase2.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(g2.a.a(cVar))}) < 1) {
                    contentValues.put("backend_name", iVar.f5461a);
                    contentValues.put("priority", Integer.valueOf(g2.a.a(cVar)));
                    sQLiteDatabase2.insert("transport_contexts", null, contentValues);
                }
                return null;
        }
    }

    public /* synthetic */ e(k kVar, long j5) {
        this.f2518i = kVar;
        this.f2517h = j5;
    }
}
