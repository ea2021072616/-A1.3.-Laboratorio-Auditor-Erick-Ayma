package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class LocalPlayListModelDao extends AbstractDao<LocalPlayListModel, Long> {
    public static final String TABLENAME = "LOCAL_PLAY_LIST_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2685a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2686b = new Property(1, String.class, "name", false, "NAME");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2687c = new Property(2, Long.class, "createTime", false, "CREATE_TIME");
        public static final Property d = new Property(3, Long.class, "modifyTime", false, "MODIFY_TIME");
    }

    public LocalPlayListModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LOCAL_PLAY_LIST_MODEL\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"NAME\" TEXT,\"CREATE_TIME\" INTEGER,\"MODIFY_TIME\" INTEGER);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"LOCAL_PLAY_LIST_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, LocalPlayListModel localPlayListModel) {
        databaseStatement.clearBindings();
        Long id = localPlayListModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String name = localPlayListModel.getName();
        if (name != null) {
            databaseStatement.bindString(2, name);
        }
        Long createTime = localPlayListModel.getCreateTime();
        if (createTime != null) {
            databaseStatement.bindLong(3, createTime.longValue());
        }
        Long modifyTime = localPlayListModel.getModifyTime();
        if (modifyTime != null) {
            databaseStatement.bindLong(4, modifyTime.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, LocalPlayListModel localPlayListModel) {
        sQLiteStatement.clearBindings();
        Long id = localPlayListModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String name = localPlayListModel.getName();
        if (name != null) {
            sQLiteStatement.bindString(2, name);
        }
        Long createTime = localPlayListModel.getCreateTime();
        if (createTime != null) {
            sQLiteStatement.bindLong(3, createTime.longValue());
        }
        Long modifyTime = localPlayListModel.getModifyTime();
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
    public LocalPlayListModel readEntity(Cursor cursor, int i) {
        return new LocalPlayListModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)), cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, LocalPlayListModel localPlayListModel, int i) {
        localPlayListModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        localPlayListModel.setName(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        localPlayListModel.setCreateTime(cursor.isNull(i + 2) ? null : Long.valueOf(cursor.getLong(i + 2)));
        localPlayListModel.setModifyTime(cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(LocalPlayListModel localPlayListModel, long j) {
        localPlayListModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(LocalPlayListModel localPlayListModel) {
        if (localPlayListModel != null) {
            return localPlayListModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(LocalPlayListModel localPlayListModel) {
        return localPlayListModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
