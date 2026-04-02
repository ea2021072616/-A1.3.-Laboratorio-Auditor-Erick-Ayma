package c2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final /* synthetic */ class j implements e2.b, d2.i {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f1740g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f1741h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1742i;

    public /* synthetic */ j(long j5, Object obj, Object obj2) {
        this.f1741h = obj;
        this.f1742i = obj2;
        this.f1740g = j5;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        String str = (String) this.f1741h;
        a2.c cVar = (a2.c) this.f1742i;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        u1.b bVar = d2.k.f2528g;
        boolean booleanValue = ((Boolean) d2.k.L(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(cVar.f17b)}), new h0.h(14))).booleanValue();
        long j5 = this.f1740g;
        int i5 = cVar.f17b;
        if (booleanValue) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j5 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i5)});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i5));
            contentValues.put("events_dropped_count", Long.valueOf(j5));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    @Override // e2.b
    public final Object b() {
        k kVar = (k) this.f1741h;
        long a5 = ((f2.b) kVar.f1749g).a() + this.f1740g;
        d2.k kVar2 = (d2.k) kVar.f1745c;
        kVar2.getClass();
        kVar2.H(new d2.e(a5, (x1.i) this.f1742i));
        return null;
    }
}
