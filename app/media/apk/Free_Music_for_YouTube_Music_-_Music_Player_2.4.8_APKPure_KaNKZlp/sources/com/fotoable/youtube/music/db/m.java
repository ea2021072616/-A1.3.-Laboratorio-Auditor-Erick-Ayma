package com.fotoable.youtube.music.db;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;
/* compiled from: MigrationHelper.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f2725a;

    public static m a() {
        if (f2725a == null) {
            f2725a = new m();
        }
        return f2725a;
    }

    public void a(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        b(database, clsArr);
        com.fotoable.youtube.music.db.greendao.gen.a.b(database, true);
        com.fotoable.youtube.music.db.greendao.gen.a.a(database, false);
        c(database, clsArr);
    }

    private void b(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = "";
            String str2 = daoConfig.tablename;
            if (b(database, str2)) {
                String concat = daoConfig.tablename.concat("_TEMP");
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                sb.append("CREATE TABLE ").append(concat).append(" (");
                for (int i = 0; i < daoConfig.properties.length; i++) {
                    String str3 = daoConfig.properties[i].columnName;
                    if (a(database, str2).contains(str3)) {
                        arrayList.add(str3);
                        String str4 = null;
                        try {
                            str4 = a(daoConfig.properties[i].type);
                        } catch (Exception e) {
                            Crashlytics.logException(e);
                        }
                        sb.append(str).append(str3).append(" ").append(str4);
                        if (daoConfig.properties[i].primaryKey) {
                            sb.append(" PRIMARY KEY");
                        }
                        str = ",";
                    }
                }
                sb.append(");");
                database.execSQL(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("INSERT INTO ").append(concat).append(" (");
                sb2.append(TextUtils.join(",", arrayList));
                sb2.append(") SELECT ");
                sb2.append(TextUtils.join(",", arrayList));
                sb2.append(" FROM ").append(str2).append(";");
                database.execSQL(sb2.toString());
            }
        }
    }

    private void c(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String concat = daoConfig.tablename.concat("_TEMP");
            if (b(database, concat)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < daoConfig.properties.length; i++) {
                    String str2 = daoConfig.properties[i].columnName;
                    if (a(database, concat).contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO ").append(str).append(" (");
                sb.append(TextUtils.join(",", arrayList));
                sb.append(") SELECT ");
                sb.append(TextUtils.join(",", arrayList));
                sb.append(" FROM ").append(concat).append(";");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DROP TABLE ").append(concat);
                database.execSQL(sb.toString());
                database.execSQL(sb2.toString());
            }
        }
    }

    private String a(Class<?> cls) throws Exception {
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Long.class) || cls.equals(Integer.class) || cls.equals(Integer.TYPE) || cls.equals(Long.TYPE)) {
            return "INTEGER";
        }
        if (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) {
            return "BOOLEAN";
        }
        Exception exc = new Exception("MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS".concat(" - Class: ").concat(cls.toString()));
        Crashlytics.logException(exc);
        Log.e("Exception", "getTypeByClass:   " + cls.toString());
        throw exc;
    }

    private static List<String> a(Database database, String str) {
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = database.rawQuery("SELECT * FROM " + str + " limit 1", null);
                if (cursor != null) {
                    arrayList = new ArrayList(Arrays.asList(cursor.getColumnNames()));
                }
            } catch (Exception e) {
                Log.v(str, e.getMessage(), e);
                ThrowableExtension.printStackTrace(e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static boolean b(Database database, String str) {
        int i;
        if (database == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = database.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
                if (cursor != null) {
                    cursor.close();
                    i = 0;
                } else {
                    i = 0;
                }
            }
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                    return false;
                }
                return false;
            }
            i = cursor.getInt(0);
            if (cursor != null) {
                cursor.close();
            }
            return i > 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
