package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.RecentlyWatchBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class RecentlyWatchBeanDao extends AbstractDao<RecentlyWatchBean, String> {
    public static final String TABLENAME = "RECENTLY_WATCH_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2706a = new Property(0, String.class, "videoid", true, "VIDEOID");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2707b = new Property(1, String.class, "title", false, ShareConstants.TITLE);

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2708c = new Property(2, String.class, "desc", false, "DESC");
        public static final Property d = new Property(3, String.class, "imgUrl", false, "IMG_URL");
        public static final Property e = new Property(4, Integer.TYPE, "imgWidth", false, "IMG_WIDTH");
        public static final Property f = new Property(5, Integer.TYPE, "imgHeight", false, "IMG_HEIGHT");
        public static final Property g = new Property(6, String.class, "duration", false, "DURATION");
        public static final Property h = new Property(7, Integer.TYPE, "isFav", false, "IS_FAV");
        public static final Property i = new Property(8, String.class, "artists", false, "ARTISTS");
    }

    public RecentlyWatchBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"RECENTLY_WATCH_BEAN\" (\"VIDEOID\" TEXT PRIMARY KEY NOT NULL ,\"TITLE\" TEXT,\"DESC\" TEXT,\"IMG_URL\" TEXT,\"IMG_WIDTH\" INTEGER NOT NULL ,\"IMG_HEIGHT\" INTEGER NOT NULL ,\"DURATION\" TEXT,\"IS_FAV\" INTEGER NOT NULL ,\"ARTISTS\" TEXT);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"RECENTLY_WATCH_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, RecentlyWatchBean recentlyWatchBean) {
        databaseStatement.clearBindings();
        String videoid = recentlyWatchBean.getVideoid();
        if (videoid != null) {
            databaseStatement.bindString(1, videoid);
        }
        String title = recentlyWatchBean.getTitle();
        if (title != null) {
            databaseStatement.bindString(2, title);
        }
        String desc = recentlyWatchBean.getDesc();
        if (desc != null) {
            databaseStatement.bindString(3, desc);
        }
        String imgUrl = recentlyWatchBean.getImgUrl();
        if (imgUrl != null) {
            databaseStatement.bindString(4, imgUrl);
        }
        databaseStatement.bindLong(5, recentlyWatchBean.getImgWidth());
        databaseStatement.bindLong(6, recentlyWatchBean.getImgHeight());
        String duration = recentlyWatchBean.getDuration();
        if (duration != null) {
            databaseStatement.bindString(7, duration);
        }
        databaseStatement.bindLong(8, recentlyWatchBean.getIsFav());
        String artists = recentlyWatchBean.getArtists();
        if (artists != null) {
            databaseStatement.bindString(9, artists);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, RecentlyWatchBean recentlyWatchBean) {
        sQLiteStatement.clearBindings();
        String videoid = recentlyWatchBean.getVideoid();
        if (videoid != null) {
            sQLiteStatement.bindString(1, videoid);
        }
        String title = recentlyWatchBean.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(2, title);
        }
        String desc = recentlyWatchBean.getDesc();
        if (desc != null) {
            sQLiteStatement.bindString(3, desc);
        }
        String imgUrl = recentlyWatchBean.getImgUrl();
        if (imgUrl != null) {
            sQLiteStatement.bindString(4, imgUrl);
        }
        sQLiteStatement.bindLong(5, recentlyWatchBean.getImgWidth());
        sQLiteStatement.bindLong(6, recentlyWatchBean.getImgHeight());
        String duration = recentlyWatchBean.getDuration();
        if (duration != null) {
            sQLiteStatement.bindString(7, duration);
        }
        sQLiteStatement.bindLong(8, recentlyWatchBean.getIsFav());
        String artists = recentlyWatchBean.getArtists();
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
    public RecentlyWatchBean readEntity(Cursor cursor, int i) {
        return new RecentlyWatchBean(cursor.isNull(i + 0) ? null : cursor.getString(i + 0), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.getInt(i + 4), cursor.getInt(i + 5), cursor.isNull(i + 6) ? null : cursor.getString(i + 6), cursor.getInt(i + 7), cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, RecentlyWatchBean recentlyWatchBean, int i) {
        recentlyWatchBean.setVideoid(cursor.isNull(i + 0) ? null : cursor.getString(i + 0));
        recentlyWatchBean.setTitle(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        recentlyWatchBean.setDesc(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        recentlyWatchBean.setImgUrl(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        recentlyWatchBean.setImgWidth(cursor.getInt(i + 4));
        recentlyWatchBean.setImgHeight(cursor.getInt(i + 5));
        recentlyWatchBean.setDuration(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
        recentlyWatchBean.setIsFav(cursor.getInt(i + 7));
        recentlyWatchBean.setArtists(cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final String updateKeyAfterInsert(RecentlyWatchBean recentlyWatchBean, long j) {
        return recentlyWatchBean.getVideoid();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public String getKey(RecentlyWatchBean recentlyWatchBean) {
        if (recentlyWatchBean != null) {
            return recentlyWatchBean.getVideoid();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(RecentlyWatchBean recentlyWatchBean) {
        return recentlyWatchBean.getVideoid() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
