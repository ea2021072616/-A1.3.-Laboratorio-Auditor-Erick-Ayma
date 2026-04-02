package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fotoable.youtube.music.bean.ArtistsCoverModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class ArtistsCoverModelDao extends AbstractDao<ArtistsCoverModel, Long> {
    public static final String TABLENAME = "ARTISTS_COVER_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2677a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2678b = new Property(1, String.class, "artistsName", false, "ARTISTS_NAME");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2679c = new Property(2, String.class, "coverImg", false, "COVER_IMG");
        public static final Property d = new Property(3, Long.class, "modifyTime", false, "MODIFY_TIME");
    }

    public ArtistsCoverModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"ARTISTS_COVER_MODEL\" (\"_id\" INTEGER PRIMARY KEY ,\"ARTISTS_NAME\" TEXT,\"COVER_IMG\" TEXT,\"MODIFY_TIME\" INTEGER);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"ARTISTS_COVER_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, ArtistsCoverModel artistsCoverModel) {
        databaseStatement.clearBindings();
        Long id = artistsCoverModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String artistsName = artistsCoverModel.getArtistsName();
        if (artistsName != null) {
            databaseStatement.bindString(2, artistsName);
        }
        String coverImg = artistsCoverModel.getCoverImg();
        if (coverImg != null) {
            databaseStatement.bindString(3, coverImg);
        }
        Long modifyTime = artistsCoverModel.getModifyTime();
        if (modifyTime != null) {
            databaseStatement.bindLong(4, modifyTime.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, ArtistsCoverModel artistsCoverModel) {
        sQLiteStatement.clearBindings();
        Long id = artistsCoverModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String artistsName = artistsCoverModel.getArtistsName();
        if (artistsName != null) {
            sQLiteStatement.bindString(2, artistsName);
        }
        String coverImg = artistsCoverModel.getCoverImg();
        if (coverImg != null) {
            sQLiteStatement.bindString(3, coverImg);
        }
        Long modifyTime = artistsCoverModel.getModifyTime();
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
    public ArtistsCoverModel readEntity(Cursor cursor, int i) {
        return new ArtistsCoverModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, ArtistsCoverModel artistsCoverModel, int i) {
        artistsCoverModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        artistsCoverModel.setArtistsName(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        artistsCoverModel.setCoverImg(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        artistsCoverModel.setModifyTime(cursor.isNull(i + 3) ? null : Long.valueOf(cursor.getLong(i + 3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(ArtistsCoverModel artistsCoverModel, long j) {
        artistsCoverModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(ArtistsCoverModel artistsCoverModel) {
        if (artistsCoverModel != null) {
            return artistsCoverModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(ArtistsCoverModel artistsCoverModel) {
        return artistsCoverModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
