package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.SubBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class SubBeanDao extends AbstractDao<SubBean, String> {
    public static final String TABLENAME = "SUB_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2709a = new Property(0, Long.TYPE, "id", false, "ID");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2710b = new Property(1, String.class, "playlistid", true, "PLAYLISTID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2711c = new Property(2, String.class, "title", false, ShareConstants.TITLE);
        public static final Property d = new Property(3, String.class, "imgUrl", false, "IMG_URL");
        public static final Property e = new Property(4, String.class, "desc", false, "DESC");
        public static final Property f = new Property(5, Integer.TYPE, "imgWidth", false, "IMG_WIDTH");
        public static final Property g = new Property(6, Integer.TYPE, "imgHeight", false, "IMG_HEIGHT");
        public static final Property h = new Property(7, Integer.TYPE, "musicCount", false, "MUSIC_COUNT");
        public static final Property i = new Property(8, Long.TYPE, "updateTime", false, "UPDATE_TIME");
        public static final Property j = new Property(9, String.class, "artists", false, "ARTISTS");
        public static final Property k = new Property(10, String.class, "type", false, "TYPE");
    }

    public SubBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"SUB_BEAN\" (\"ID\" INTEGER NOT NULL ,\"PLAYLISTID\" TEXT PRIMARY KEY NOT NULL ,\"TITLE\" TEXT,\"IMG_URL\" TEXT,\"DESC\" TEXT,\"IMG_WIDTH\" INTEGER NOT NULL ,\"IMG_HEIGHT\" INTEGER NOT NULL ,\"MUSIC_COUNT\" INTEGER NOT NULL ,\"UPDATE_TIME\" INTEGER NOT NULL ,\"ARTISTS\" TEXT,\"TYPE\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"SUB_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, SubBean subBean) {
        databaseStatement.clearBindings();
        databaseStatement.bindLong(1, subBean.getId());
        String playlistid = subBean.getPlaylistid();
        if (playlistid != null) {
            databaseStatement.bindString(2, playlistid);
        }
        String title = subBean.getTitle();
        if (title != null) {
            databaseStatement.bindString(3, title);
        }
        String imgUrl = subBean.getImgUrl();
        if (imgUrl != null) {
            databaseStatement.bindString(4, imgUrl);
        }
        String desc = subBean.getDesc();
        if (desc != null) {
            databaseStatement.bindString(5, desc);
        }
        databaseStatement.bindLong(6, subBean.getImgWidth());
        databaseStatement.bindLong(7, subBean.getImgHeight());
        databaseStatement.bindLong(8, subBean.getMusicCount());
        databaseStatement.bindLong(9, subBean.getUpdateTime());
        String artists = subBean.getArtists();
        if (artists != null) {
            databaseStatement.bindString(10, artists);
        }
        String type = subBean.getType();
        if (type != null) {
            databaseStatement.bindString(11, type);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, SubBean subBean) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, subBean.getId());
        String playlistid = subBean.getPlaylistid();
        if (playlistid != null) {
            sQLiteStatement.bindString(2, playlistid);
        }
        String title = subBean.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(3, title);
        }
        String imgUrl = subBean.getImgUrl();
        if (imgUrl != null) {
            sQLiteStatement.bindString(4, imgUrl);
        }
        String desc = subBean.getDesc();
        if (desc != null) {
            sQLiteStatement.bindString(5, desc);
        }
        sQLiteStatement.bindLong(6, subBean.getImgWidth());
        sQLiteStatement.bindLong(7, subBean.getImgHeight());
        sQLiteStatement.bindLong(8, subBean.getMusicCount());
        sQLiteStatement.bindLong(9, subBean.getUpdateTime());
        String artists = subBean.getArtists();
        if (artists != null) {
            sQLiteStatement.bindString(10, artists);
        }
        String type = subBean.getType();
        if (type != null) {
            sQLiteStatement.bindString(11, type);
        }
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String readKey(Cursor cursor, int i) {
        if (cursor.isNull(i + 1)) {
            return null;
        }
        return cursor.getString(i + 1);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public SubBean readEntity(Cursor cursor, int i) {
        return new SubBean(cursor.getLong(i + 0), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.isNull(i + 4) ? null : cursor.getString(i + 4), cursor.getInt(i + 5), cursor.getInt(i + 6), cursor.getInt(i + 7), cursor.getLong(i + 8), cursor.isNull(i + 9) ? null : cursor.getString(i + 9), cursor.isNull(i + 10) ? null : cursor.getString(i + 10));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, SubBean subBean, int i) {
        subBean.setId(cursor.getLong(i + 0));
        subBean.setPlaylistid(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        subBean.setTitle(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        subBean.setImgUrl(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        subBean.setDesc(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        subBean.setImgWidth(cursor.getInt(i + 5));
        subBean.setImgHeight(cursor.getInt(i + 6));
        subBean.setMusicCount(cursor.getInt(i + 7));
        subBean.setUpdateTime(cursor.getLong(i + 8));
        subBean.setArtists(cursor.isNull(i + 9) ? null : cursor.getString(i + 9));
        subBean.setType(cursor.isNull(i + 10) ? null : cursor.getString(i + 10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final String updateKeyAfterInsert(SubBean subBean, long j) {
        return subBean.getPlaylistid();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String getKey(SubBean subBean) {
        if (subBean != null) {
            return subBean.getPlaylistid();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(SubBean subBean) {
        return subBean.getPlaylistid() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
