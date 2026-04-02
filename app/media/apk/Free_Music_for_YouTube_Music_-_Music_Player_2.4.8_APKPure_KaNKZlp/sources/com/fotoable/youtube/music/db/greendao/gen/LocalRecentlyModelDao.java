package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.LocalRecentlyModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class LocalRecentlyModelDao extends AbstractDao<LocalRecentlyModel, Long> {
    public static final String TABLENAME = "LOCAL_RECENTLY_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2691a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2692b = new Property(1, Long.class, "songId", false, "SONG_ID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2693c = new Property(2, Long.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property d = new Property(3, Integer.class, "playedCount", false, "PLAYED_COUNT");
    }

    public LocalRecentlyModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"LOCAL_RECENTLY_MODEL\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SONG_ID\" INTEGER,\"MODIFY_TIME\" INTEGER,\"PLAYED_COUNT\" INTEGER);");
        database.execSQL("CREATE INDEX " + str + "IDX_LOCAL_RECENTLY_MODEL_SONG_ID ON LOCAL_RECENTLY_MODEL (\"SONG_ID\" ASC);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"LOCAL_RECENTLY_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, LocalRecentlyModel localRecentlyModel) {
        databaseStatement.clearBindings();
        Long id = localRecentlyModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        Long songId = localRecentlyModel.getSongId();
        if (songId != null) {
            databaseStatement.bindLong(2, songId.longValue());
        }
        Long modifyTime = localRecentlyModel.getModifyTime();
        if (modifyTime != null) {
            databaseStatement.bindLong(3, modifyTime.longValue());
        }
        Integer playedCount = localRecentlyModel.getPlayedCount();
        if (playedCount != null) {
            databaseStatement.bindLong(4, playedCount.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, LocalRecentlyModel localRecentlyModel) {
        sQLiteStatement.clearBindings();
        Long id = localRecentlyModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        Long songId = localRecentlyModel.getSongId();
        if (songId != null) {
            sQLiteStatement.bindLong(2, songId.longValue());
        }
        Long modifyTime = localRecentlyModel.getModifyTime();
        if (modifyTime != null) {
            sQLiteStatement.bindLong(3, modifyTime.longValue());
        }
        Integer playedCount = localRecentlyModel.getPlayedCount();
        if (playedCount != null) {
            sQLiteStatement.bindLong(4, playedCount.intValue());
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long readKey(Cursor cursor, int i) {
        if (cursor.isNull(i + 0)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i + 0));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public LocalRecentlyModel readEntity(Cursor cursor, int i) {
        return new LocalRecentlyModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : Long.valueOf(cursor.getLong(i + 1)), cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)), cursor.isNull(i + 3) ? null : Integer.valueOf(cursor.getInt(i + 3)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, LocalRecentlyModel localRecentlyModel, int i) {
        localRecentlyModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        localRecentlyModel.setSongId(cursor.isNull(i + 1) ? null : Long.valueOf(cursor.getLong(i + 1)));
        localRecentlyModel.setModifyTime(cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)));
        localRecentlyModel.setPlayedCount(cursor.isNull(i + 3) ? null : Integer.valueOf(cursor.getInt(i + 3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(LocalRecentlyModel localRecentlyModel, long j) {
        localRecentlyModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(LocalRecentlyModel localRecentlyModel) {
        if (localRecentlyModel != null) {
            return localRecentlyModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(LocalRecentlyModel localRecentlyModel) {
        return localRecentlyModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
