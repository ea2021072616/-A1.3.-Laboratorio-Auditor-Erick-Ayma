package d2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final /* synthetic */ class g implements i {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2522g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k f2523h;

    public /* synthetic */ g(k kVar, int i5) {
        this.f2522g = i5;
        this.f2523h = kVar;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        int i5 = this.f2522g;
        k kVar = this.f2523h;
        switch (i5) {
            case 0:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                kVar.getClass();
                sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
                sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + ((f2.b) kVar.f2530c).a()).execute();
                return null;
            case 1:
                Cursor cursor = (Cursor) obj;
                kVar.getClass();
                while (cursor.moveToNext()) {
                    kVar.H(new c2.j(cursor.getInt(0), cursor.getString(1), a2.c.f10d));
                }
                return null;
            default:
                Cursor cursor2 = (Cursor) obj;
                kVar.getClass();
                while (cursor2.moveToNext()) {
                    kVar.H(new c2.j(cursor2.getInt(0), cursor2.getString(1), a2.c.f13g));
                }
                return null;
        }
    }
}
