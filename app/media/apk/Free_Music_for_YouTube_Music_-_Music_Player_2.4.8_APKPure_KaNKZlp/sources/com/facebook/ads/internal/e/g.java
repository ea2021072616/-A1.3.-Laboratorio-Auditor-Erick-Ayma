package com.facebook.ads.internal.e;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public abstract class g {
    protected final d j;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(d dVar) {
        this.j = dVar;
    }

    public static String a(String str, b[] bVarArr) {
        StringBuilder sb = new StringBuilder("SELECT ");
        for (int i = 0; i < bVarArr.length - 1; i++) {
            sb.append(bVarArr[i].f1287b);
            sb.append(", ");
        }
        sb.append(bVarArr[bVarArr.length - 1].f1287b);
        sb.append(" FROM ");
        sb.append(str);
        return sb.toString();
    }

    public static String a(String str, b[] bVarArr, b bVar) {
        return a(str, bVarArr) + " WHERE " + bVar.f1287b + " = ?";
    }

    private String c() {
        b[] b2;
        if (b().length < 1) {
            return null;
        }
        String str = "";
        for (int i = 0; i < b2.length - 1; i++) {
            str = str + b2[i].a() + ", ";
        }
        return str + b2[b2.length - 1].a();
    }

    public abstract String a();

    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + a() + " (" + c() + ")");
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + a());
    }

    public abstract b[] b();

    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SQLiteDatabase f() {
        return this.j.a();
    }
}
