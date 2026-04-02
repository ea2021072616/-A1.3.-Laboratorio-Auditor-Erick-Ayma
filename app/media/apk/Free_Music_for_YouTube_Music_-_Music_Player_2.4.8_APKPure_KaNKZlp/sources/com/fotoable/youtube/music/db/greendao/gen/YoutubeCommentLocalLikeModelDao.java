package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.YoutubeCommentLocalLikeModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class YoutubeCommentLocalLikeModelDao extends AbstractDao<YoutubeCommentLocalLikeModel, Long> {
    public static final String TABLENAME = "YOUTUBE_COMMENT_LOCAL_LIKE_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2712a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2713b = new Property(1, String.class, "cid", false, "CID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2714c = new Property(2, String.class, "uid", false, "UID");
        public static final Property d = new Property(3, Long.class, "modifyTime", false, "MODIFY_TIME");
    }

    public YoutubeCommentLocalLikeModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"YOUTUBE_COMMENT_LOCAL_LIKE_MODEL\" (\"_id\" INTEGER PRIMARY KEY ,\"CID\" TEXT,\"UID\" TEXT,\"MODIFY_TIME\" INTEGER);");
        database.execSQL("CREATE INDEX " + str + "IDX_YOUTUBE_COMMENT_LOCAL_LIKE_MODEL_CID ON YOUTUBE_COMMENT_LOCAL_LIKE_MODEL (\"CID\" ASC);");
        database.execSQL("CREATE INDEX " + str + "IDX_YOUTUBE_COMMENT_LOCAL_LIKE_MODEL_UID ON YOUTUBE_COMMENT_LOCAL_LIKE_MODEL (\"UID\" ASC);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"YOUTUBE_COMMENT_LOCAL_LIKE_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel) {
        databaseStatement.clearBindings();
        Long id = youtubeCommentLocalLikeModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String cid = youtubeCommentLocalLikeModel.getCid();
        if (cid != null) {
            databaseStatement.bindString(2, cid);
        }
        String uid = youtubeCommentLocalLikeModel.getUid();
        if (uid != null) {
            databaseStatement.bindString(3, uid);
        }
        Long modifyTime = youtubeCommentLocalLikeModel.getModifyTime();
        if (modifyTime != null) {
            databaseStatement.bindLong(4, modifyTime.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel) {
        sQLiteStatement.clearBindings();
        Long id = youtubeCommentLocalLikeModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String cid = youtubeCommentLocalLikeModel.getCid();
        if (cid != null) {
            sQLiteStatement.bindString(2, cid);
        }
        String uid = youtubeCommentLocalLikeModel.getUid();
        if (uid != null) {
            sQLiteStatement.bindString(3, uid);
        }
        Long modifyTime = youtubeCommentLocalLikeModel.getModifyTime();
        if (modifyTime != null) {
            sQLiteStatement.bindLong(4, modifyTime.longValue());
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
    public YoutubeCommentLocalLikeModel readEntity(Cursor cursor, int i) {
        return new YoutubeCommentLocalLikeModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel, int i) {
        youtubeCommentLocalLikeModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        youtubeCommentLocalLikeModel.setCid(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        youtubeCommentLocalLikeModel.setUid(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        youtubeCommentLocalLikeModel.setModifyTime(cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel, long j) {
        youtubeCommentLocalLikeModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel) {
        if (youtubeCommentLocalLikeModel != null) {
            return youtubeCommentLocalLikeModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(YoutubeCommentLocalLikeModel youtubeCommentLocalLikeModel) {
        return youtubeCommentLocalLikeModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
