package d2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final /* synthetic */ class h implements i {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2524g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f2525h;

    public /* synthetic */ h(long j5, int i5) {
        this.f2524g = i5;
        this.f2525h = j5;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        int i5 = this.f2524g;
        long j5 = this.f2525h;
        switch (i5) {
            case 0:
                return (a2.g) k.L(((SQLiteDatabase) obj).rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new h(j5, 1));
            default:
                Cursor cursor = (Cursor) obj;
                cursor.moveToNext();
                return new a2.g(cursor.getLong(0), j5);
        }
    }
}
