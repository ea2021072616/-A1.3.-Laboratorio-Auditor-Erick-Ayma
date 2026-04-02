package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.DurationBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class DurationBeanDao extends AbstractDao<DurationBean, String> {
    public static final String TABLENAME = "DURATION_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2680a = new Property(0, String.class, "videoId", true, "VIDEO_ID");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2681b = new Property(1, String.class, "duration", false, "DURATION");
    }

    public DurationBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"DURATION_BEAN\" (\"VIDEO_ID\" TEXT PRIMARY KEY NOT NULL ,\"DURATION\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"DURATION_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, DurationBean durationBean) {
        databaseStatement.clearBindings();
        String videoId = durationBean.getVideoId();
        if (videoId != null) {
            databaseStatement.bindString(1, videoId);
        }
        String duration = durationBean.getDuration();
        if (duration != null) {
            databaseStatement.bindString(2, duration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, DurationBean durationBean) {
        sQLiteStatement.clearBindings();
        String videoId = durationBean.getVideoId();
        if (videoId != null) {
            sQLiteStatement.bindString(1, videoId);
        }
        String duration = durationBean.getDuration();
        if (duration != null) {
            sQLiteStatement.bindString(2, duration);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String readKey(Cursor cursor, int i) {
        if (cursor.isNull(i + 0)) {
            return null;
        }
        return cursor.getString(i + 0);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public DurationBean readEntity(Cursor cursor, int i) {
        return new DurationBean(cursor.isNull(i + 0) ? null : cursor.getString(i + 0), cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, DurationBean durationBean, int i) {
        durationBean.setVideoId(cursor.isNull(i + 0) ? null : cursor.getString(i + 0));
        durationBean.setDuration(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final String updateKeyAfterInsert(DurationBean durationBean, long j) {
        return durationBean.getVideoId();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String getKey(DurationBean durationBean) {
        if (durationBean != null) {
            return durationBean.getVideoId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(DurationBean durationBean) {
        return durationBean.getVideoId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
