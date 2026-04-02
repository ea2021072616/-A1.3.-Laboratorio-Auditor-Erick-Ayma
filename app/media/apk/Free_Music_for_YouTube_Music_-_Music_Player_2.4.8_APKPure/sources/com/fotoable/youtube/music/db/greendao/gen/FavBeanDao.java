package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.FavBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class FavBeanDao extends AbstractDao<FavBean, String> {
    public static final String TABLENAME = "FAV_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2682a = new Property(0, String.class, "videoid", true, "VIDEOID");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2683b = new Property(1, String.class, "title", false, ShareConstants.TITLE);

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2684c = new Property(2, String.class, "imgUrl", false, "IMG_URL");
        public static final Property d = new Property(3, String.class, "desc", false, "DESC");
        public static final Property e = new Property(4, Integer.TYPE, "imgWidth", false, "IMG_WIDTH");
        public static final Property f = new Property(5, Integer.TYPE, "imgHeight", false, "IMG_HEIGHT");
        public static final Property g = new Property(6, String.class, "duration", false, "DURATION");
        public static final Property h = new Property(7, Integer.TYPE, "isFav", false, "IS_FAV");
        public static final Property i = new Property(8, String.class, "artists", false, "ARTISTS");
    }

    public FavBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"FAV_BEAN\" (\"VIDEOID\" TEXT PRIMARY KEY NOT NULL ,\"TITLE\" TEXT,\"IMG_URL\" TEXT,\"DESC\" TEXT,\"IMG_WIDTH\" INTEGER NOT NULL ,\"IMG_HEIGHT\" INTEGER NOT NULL ,\"DURATION\" TEXT,\"IS_FAV\" INTEGER NOT NULL ,\"ARTISTS\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"FAV_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, FavBean favBean) {
        databaseStatement.clearBindings();
        String videoid = favBean.getVideoid();
        if (videoid != null) {
            databaseStatement.bindString(1, videoid);
        }
        String title = favBean.getTitle();
        if (title != null) {
            databaseStatement.bindString(2, title);
        }
        String imgUrl = favBean.getImgUrl();
        if (imgUrl != null) {
            databaseStatement.bindString(3, imgUrl);
        }
        String desc = favBean.getDesc();
        if (desc != null) {
            databaseStatement.bindString(4, desc);
        }
        databaseStatement.bindLong(5, favBean.getImgWidth());
        databaseStatement.bindLong(6, favBean.getImgHeight());
        String duration = favBean.getDuration();
        if (duration != null) {
            databaseStatement.bindString(7, duration);
        }
        databaseStatement.bindLong(8, favBean.getIsFav());
        String artists = favBean.getArtists();
        if (artists != null) {
            databaseStatement.bindString(9, artists);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, FavBean favBean) {
        sQLiteStatement.clearBindings();
        String videoid = favBean.getVideoid();
        if (videoid != null) {
            sQLiteStatement.bindString(1, videoid);
        }
        String title = favBean.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(2, title);
        }
        String imgUrl = favBean.getImgUrl();
        if (imgUrl != null) {
            sQLiteStatement.bindString(3, imgUrl);
        }
        String desc = favBean.getDesc();
        if (desc != null) {
            sQLiteStatement.bindString(4, desc);
        }
        sQLiteStatement.bindLong(5, favBean.getImgWidth());
        sQLiteStatement.bindLong(6, favBean.getImgHeight());
        String duration = favBean.getDuration();
        if (duration != null) {
            sQLiteStatement.bindString(7, duration);
        }
        sQLiteStatement.bindLong(8, favBean.getIsFav());
        String artists = favBean.getArtists();
        if (artists != null) {
            sQLiteStatement.bindString(9, artists);
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
    public FavBean readEntity(Cursor cursor, int i) {
        return new FavBean(cursor.isNull(i + 0) ? null : cursor.getString(i + 0), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.getInt(i + 4), cursor.getInt(i + 5), cursor.isNull(i + 6) ? null : cursor.getString(i + 6), cursor.getInt(i + 7), cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, FavBean favBean, int i) {
        favBean.setVideoid(cursor.isNull(i + 0) ? null : cursor.getString(i + 0));
        favBean.setTitle(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        favBean.setImgUrl(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        favBean.setDesc(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        favBean.setImgWidth(cursor.getInt(i + 4));
        favBean.setImgHeight(cursor.getInt(i + 5));
        favBean.setDuration(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
        favBean.setIsFav(cursor.getInt(i + 7));
        favBean.setArtists(cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final String updateKeyAfterInsert(FavBean favBean, long j) {
        return favBean.getVideoid();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String getKey(FavBean favBean) {
        if (favBean != null) {
            return favBean.getVideoid();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(FavBean favBean) {
        return favBean.getVideoid() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
