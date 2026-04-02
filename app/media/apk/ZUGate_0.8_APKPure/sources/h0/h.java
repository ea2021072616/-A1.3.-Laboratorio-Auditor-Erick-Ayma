package h0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final /* synthetic */ class h implements e1.q, d2.i, s3.z, x4.g {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f3137g;

    public /* synthetic */ h(int i5) {
        this.f3137g = i5;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        switch (this.f3137g) {
            case 9:
                u1.b bVar = d2.k.f2528g;
                return (List) d2.k.L(((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new h(13));
            case 10:
                u1.b bVar2 = d2.k.f2528g;
                throw new e2.a("Timed out while trying to open db.", (Throwable) obj);
            case 11:
                Cursor cursor = (Cursor) obj;
                u1.b bVar3 = d2.k.f2528g;
                if (cursor.moveToNext()) {
                    return Long.valueOf(cursor.getLong(0));
                }
                return 0L;
            case 12:
                u1.b bVar4 = d2.k.f2528g;
                throw new e2.a("Timed out while trying to acquire the lock.", (Throwable) obj);
            case 13:
                Cursor cursor2 = (Cursor) obj;
                u1.b bVar5 = d2.k.f2528g;
                ArrayList arrayList = new ArrayList();
                while (cursor2.moveToNext()) {
                    d.e a5 = x1.i.a();
                    a5.o(cursor2.getString(1));
                    a5.p(g2.a.b(cursor2.getInt(2)));
                    String string = cursor2.getString(3);
                    a5.f2322i = string == null ? null : Base64.decode(string, 0);
                    arrayList.add(a5.b());
                }
                return arrayList;
            case 14:
                u1.b bVar6 = d2.k.f2528g;
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            case 15:
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            case 16:
                Cursor cursor3 = (Cursor) obj;
                u1.b bVar7 = d2.k.f2528g;
                if (cursor3.moveToNext()) {
                    return Long.valueOf(cursor3.getLong(0));
                }
                return null;
            default:
                Cursor cursor4 = (Cursor) obj;
                u1.b bVar8 = d2.k.f2528g;
                ArrayList arrayList2 = new ArrayList();
                int i5 = 0;
                while (cursor4.moveToNext()) {
                    byte[] blob = cursor4.getBlob(0);
                    arrayList2.add(blob);
                    i5 += blob.length;
                }
                byte[] bArr = new byte[i5];
                int i6 = 0;
                for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                    byte[] bArr2 = (byte[]) arrayList2.get(i7);
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    i6 += bArr2.length;
                }
                return bArr;
        }
    }

    @Override // x4.g
    public final void d(String str) {
    }
}
