package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class LocalPlayListMusicModelDao extends AbstractDao<LocalPlayListMusicModel, Long> {
    public static final String TABLENAME = "LOCAL_PLAY_LIST_MUSIC_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2688a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2689b = new Property(1, Long.class, "songId", false, "SONG_ID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2690c = new Property(2, Long.class, "playListId", false, "PLAY_LIST_ID");
        public static final Property d = new Property(3, Long.class, "createTime", false, "CREATE_TIME");
    }

    public LocalPlayListMusicModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"LOCAL_PLAY_LIST_MUSIC_MODEL\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SONG_ID\" INTEGER,\"PLAY_LIST_ID\" INTEGER,\"CREATE_TIME\" INTEGER);");
        database.execSQL("CREATE INDEX " + str + "IDX_LOCAL_PLAY_LIST_MUSIC_MODEL_PLAY_LIST_ID ON LOCAL_PLAY_LIST_MUSIC_MODEL (\"PLAY_LIST_ID\" ASC);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"LOCAL_PLAY_LIST_MUSIC_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, LocalPlayListMusicModel localPlayListMusicModel) {
        databaseStatement.clearBindings();
        Long id = localPlayListMusicModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        Long songId = localPlayListMusicModel.getSongId();
        if (songId != null) {
            databaseStatement.bindLong(2, songId.longValue());
        }
        Long playListId = localPlayListMusicModel.getPlayListId();
        if (playListId != null) {
            databaseStatement.bindLong(3, playListId.longValue());
        }
        Long createTime = localPlayListMusicModel.getCreateTime();
        if (createTime != null) {
            databaseStatement.bindLong(4, createTime.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, LocalPlayListMusicModel localPlayListMusicModel) {
        sQLiteStatement.clearBindings();
        Long id = localPlayListMusicModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        Long songId = localPlayListMusicModel.getSongId();
        if (songId != null) {
            sQLiteStatement.bindLong(2, songId.longValue());
        }
        Long playListId = localPlayListMusicModel.getPlayListId();
        if (playListId != null) {
            sQLiteStatement.bindLong(3, playListId.longValue());
        }
        Long createTime = localPlayListMusicModel.getCreateTime();
        if (createTime != null) {
            sQLiteStatement.bindLong(4, createTime.longValue());
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
    public LocalPlayListMusicModel readEntity(Cursor cursor, int i) {
        return new LocalPlayListMusicModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : Long.valueOf(cursor.getLong(i + 1)), cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)), cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, LocalPlayListMusicModel localPlayListMusicModel, int i) {
        localPlayListMusicModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        localPlayListMusicModel.setSongId(cursor.isNull(i + 1) ? null : Long.valueOf(cursor.getLong(i + 1)));
        localPlayListMusicModel.setPlayListId(cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)));
        localPlayListMusicModel.setCreateTime(cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(LocalPlayListMusicModel localPlayListMusicModel, long j) {
        localPlayListMusicModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(LocalPlayListMusicModel localPlayListMusicModel) {
        if (localPlayListMusicModel != null) {
            return localPlayListMusicModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(LocalPlayListMusicModel localPlayListMusicModel) {
        return localPlayListMusicModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
