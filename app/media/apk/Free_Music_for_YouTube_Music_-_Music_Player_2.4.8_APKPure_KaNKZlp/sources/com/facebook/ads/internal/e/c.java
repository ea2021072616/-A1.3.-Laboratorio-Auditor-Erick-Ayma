package com.facebook.ads.internal.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.WorkerThread;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final b f1289a = new b(0, "event_id", "TEXT PRIMARY KEY");

    /* renamed from: b  reason: collision with root package name */
    public static final b f1290b = new b(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");

    /* renamed from: c  reason: collision with root package name */
    public static final b f1291c = new b(2, "priority", "INTEGER");
    public static final b d = new b(3, "type", "TEXT");
    public static final b e = new b(4, "time", "REAL");
    public static final b f = new b(5, "session_time", "REAL");
    public static final b g = new b(6, "session_id", "TEXT");
    public static final b h = new b(7, ShareConstants.WEB_DIALOG_PARAM_DATA, "TEXT");
    public static final b[] i = {f1289a, f1290b, f1291c, d, e, f, g, h};
    private static final String k = a("events", i);

    public c(d dVar) {
        super(dVar);
    }

    @Override // com.facebook.ads.internal.e.g
    public String a() {
        return "events";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public String a(String str, int i2, String str2, double d2, double d3, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(f1289a.f1287b, uuid);
        contentValues.put(f1290b.f1287b, str);
        contentValues.put(f1291c.f1287b, Integer.valueOf(i2));
        contentValues.put(d.f1287b, str2);
        contentValues.put(e.f1287b, Double.valueOf(d2));
        contentValues.put(f.f1287b, Double.valueOf(d3));
        contentValues.put(g.f1287b, str3);
        contentValues.put(h.f1287b, map != null ? new JSONObject(map).toString() : null);
        f().insertOrThrow("events", null, contentValues);
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return f().delete("events", new StringBuilder().append(f1289a.f1287b).append(" = ?").toString(), new String[]{str}) > 0;
    }

    @Override // com.facebook.ads.internal.e.g
    public b[] b() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public Cursor c() {
        return f().rawQuery("SELECT count(*) FROM events", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public Cursor d() {
        return f().rawQuery(k, null);
    }
}
