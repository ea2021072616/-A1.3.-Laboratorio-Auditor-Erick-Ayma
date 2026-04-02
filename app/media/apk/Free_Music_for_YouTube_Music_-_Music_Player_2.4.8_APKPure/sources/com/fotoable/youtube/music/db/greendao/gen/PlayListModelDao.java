package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.places.model.PlaceFields;
import com.fotoable.youtube.music.bean.PlayListModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class PlayListModelDao extends AbstractDao<PlayListModel, Long> {
    public static final String TABLENAME = "PLAY_LIST_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2697a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2698b = new Property(1, String.class, "name", false, "NAME");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2699c = new Property(2, String.class, "date", false, "DATE");
        public static final Property d = new Property(3, String.class, "desc", false, "DESC");
        public static final Property e = new Property(4, String.class, PlaceFields.COVER, false, "COVER");
        public static final Property f = new Property(5, String.class, "tag", false, "TAG");
    }

    public PlayListModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PLAY_LIST_MODEL\" (\"_id\" INTEGER PRIMARY KEY ,\"NAME\" TEXT,\"DATE\" TEXT,\"DESC\" TEXT,\"COVER\" TEXT,\"TAG\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"PLAY_LIST_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, PlayListModel playListModel) {
        databaseStatement.clearBindings();
        Long id = playListModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String name = playListModel.getName();
        if (name != null) {
            databaseStatement.bindString(2, name);
        }
        String date = playListModel.getDate();
        if (date != null) {
            databaseStatement.bindString(3, date);
        }
        String desc = playListModel.getDesc();
        if (desc != null) {
            databaseStatement.bindString(4, desc);
        }
        String cover = playListModel.getCover();
        if (cover != null) {
            databaseStatement.bindString(5, cover);
        }
        String tag = playListModel.getTag();
        if (tag != null) {
            databaseStatement.bindString(6, tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, PlayListModel playListModel) {
        sQLiteStatement.clearBindings();
        Long id = playListModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String name = playListModel.getName();
        if (name != null) {
            sQLiteStatement.bindString(2, name);
        }
        String date = playListModel.getDate();
        if (date != null) {
            sQLiteStatement.bindString(3, date);
        }
        String desc = playListModel.getDesc();
        if (desc != null) {
            sQLiteStatement.bindString(4, desc);
        }
        String cover = playListModel.getCover();
        if (cover != null) {
            sQLiteStatement.bindString(5, cover);
        }
        String tag = playListModel.getTag();
        if (tag != null) {
            sQLiteStatement.bindString(6, tag);
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
    public PlayListModel readEntity(Cursor cursor, int i) {
        return new PlayListModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.isNull(i + 4) ? null : cursor.getString(i + 4), cursor.isNull(i + 5) ? null : cursor.getString(i + 5));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, PlayListModel playListModel, int i) {
        playListModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        playListModel.setName(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        playListModel.setDate(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        playListModel.setDesc(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        playListModel.setCover(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        playListModel.setTag(cursor.isNull(i + 5) ? null : cursor.getString(i + 5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(PlayListModel playListModel, long j) {
        playListModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(PlayListModel playListModel) {
        if (playListModel != null) {
            return playListModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(PlayListModel playListModel) {
        return playListModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
