package com.facebook.ads.internal.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.UUID;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final b f1305a = new b(0, "token_id", "TEXT PRIMARY KEY");

    /* renamed from: b  reason: collision with root package name */
    public static final b f1306b = new b(1, "token", "TEXT");

    /* renamed from: c  reason: collision with root package name */
    public static final b[] f1307c = {f1305a, f1306b};
    private static final String d = h.class.getSimpleName();
    private static final String e = a("tokens", f1307c);
    private static final String f = a("tokens", f1307c, f1306b);
    private static final String g = "DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens." + f1305a.f1287b + " = events." + c.f1290b.f1287b + ")";

    public h(d dVar) {
        super(dVar);
    }

    @Override // com.facebook.ads.internal.e.g
    public String a() {
        return "tokens";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public String a(String str) {
        Cursor cursor;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid token.");
        }
        try {
            cursor = f().rawQuery(f, new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            String string = cursor.moveToNext() ? cursor.getString(f1305a.f1286a) : null;
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                ContentValues contentValues = new ContentValues(2);
                contentValues.put(f1305a.f1287b, string);
                contentValues.put(f1306b.f1287b, str);
                f().insertOrThrow("tokens", null, contentValues);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.internal.e.g
    public b[] b() {
        return f1307c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public Cursor c() {
        return f().rawQuery(e, null);
    }

    @WorkerThread
    public void d() {
        try {
            f().execSQL(g);
        } catch (SQLException e2) {
        }
    }
}
