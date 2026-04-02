package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.LocalSongBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class LocalSongBeanDao extends AbstractDao<LocalSongBean, Long> {
    public static final String TABLENAME = "LOCAL_SONG_BEAN";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2694a = new Property(0, Long.class, "songId", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2695b = new Property(1, Integer.TYPE, "albumId", false, "ALBUM_ID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2696c = new Property(2, Long.TYPE, "artistId", false, "ARTIST_ID");
        public static final Property d = new Property(3, Integer.TYPE, "duration", false, "DURATION");
        public static final Property e = new Property(4, String.class, "songName", false, "SONG_NAME");
        public static final Property f = new Property(5, String.class, "albumName", false, "ALBUM_NAME");
        public static final Property g = new Property(6, String.class, "artistName", false, "ARTIST_NAME");
        public static final Property h = new Property(7, String.class, "albumData", false, "ALBUM_DATA");
        public static final Property i = new Property(8, String.class, ShareConstants.WEB_DIALOG_PARAM_DATA, false, "DATA");
        public static final Property j = new Property(9, String.class, "folder", false, "FOLDER");
        public static final Property k = new Property(10, String.class, "lrc", false, "LRC");
        public static final Property l = new Property(11, Boolean.class, "islocal", false, "ISLOCAL");
        public static final Property m = new Property(12, String.class, "sort", false, "SORT");
        public static final Property n = new Property(13, Integer.TYPE, "size", false, "SIZE");
    }

    public LocalSongBeanDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"LOCAL_SONG_BEAN\" (\"_id\" INTEGER PRIMARY KEY ,\"ALBUM_ID\" INTEGER NOT NULL ,\"ARTIST_ID\" INTEGER NOT NULL ,\"DURATION\" INTEGER NOT NULL ,\"SONG_NAME\" TEXT,\"ALBUM_NAME\" TEXT,\"ARTIST_NAME\" TEXT,\"ALBUM_DATA\" TEXT,\"DATA\" TEXT,\"FOLDER\" TEXT,\"LRC\" TEXT,\"ISLOCAL\" INTEGER,\"SORT\" TEXT,\"SIZE\" INTEGER NOT NULL );");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"LOCAL_SONG_BEAN\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, LocalSongBean localSongBean) {
        databaseStatement.clearBindings();
        Long songId = localSongBean.getSongId();
        if (songId != null) {
            databaseStatement.bindLong(1, songId.longValue());
        }
        databaseStatement.bindLong(2, localSongBean.getAlbumId());
        databaseStatement.bindLong(3, localSongBean.getArtistId());
        databaseStatement.bindLong(4, localSongBean.getDuration());
        String songName = localSongBean.getSongName();
        if (songName != null) {
            databaseStatement.bindString(5, songName);
        }
        String albumName = localSongBean.getAlbumName();
        if (albumName != null) {
            databaseStatement.bindString(6, albumName);
        }
        String artistName = localSongBean.getArtistName();
        if (artistName != null) {
            databaseStatement.bindString(7, artistName);
        }
        String albumData = localSongBean.getAlbumData();
        if (albumData != null) {
            databaseStatement.bindString(8, albumData);
        }
        String data = localSongBean.getData();
        if (data != null) {
            databaseStatement.bindString(9, data);
        }
        String folder = localSongBean.getFolder();
        if (folder != null) {
            databaseStatement.bindString(10, folder);
        }
        String lrc = localSongBean.getLrc();
        if (lrc != null) {
            databaseStatement.bindString(11, lrc);
        }
        Boolean islocal = localSongBean.getIslocal();
        if (islocal != null) {
            databaseStatement.bindLong(12, islocal.booleanValue() ? 1L : 0L);
        }
        String sort = localSongBean.getSort();
        if (sort != null) {
            databaseStatement.bindString(13, sort);
        }
        databaseStatement.bindLong(14, localSongBean.getSize());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, LocalSongBean localSongBean) {
        sQLiteStatement.clearBindings();
        Long songId = localSongBean.getSongId();
        if (songId != null) {
            sQLiteStatement.bindLong(1, songId.longValue());
        }
        sQLiteStatement.bindLong(2, localSongBean.getAlbumId());
        sQLiteStatement.bindLong(3, localSongBean.getArtistId());
        sQLiteStatement.bindLong(4, localSongBean.getDuration());
        String songName = localSongBean.getSongName();
        if (songName != null) {
            sQLiteStatement.bindString(5, songName);
        }
        String albumName = localSongBean.getAlbumName();
        if (albumName != null) {
            sQLiteStatement.bindString(6, albumName);
        }
        String artistName = localSongBean.getArtistName();
        if (artistName != null) {
            sQLiteStatement.bindString(7, artistName);
        }
        String albumData = localSongBean.getAlbumData();
        if (albumData != null) {
            sQLiteStatement.bindString(8, albumData);
        }
        String data = localSongBean.getData();
        if (data != null) {
            sQLiteStatement.bindString(9, data);
        }
        String folder = localSongBean.getFolder();
        if (folder != null) {
            sQLiteStatement.bindString(10, folder);
        }
        String lrc = localSongBean.getLrc();
        if (lrc != null) {
            sQLiteStatement.bindString(11, lrc);
        }
        Boolean islocal = localSongBean.getIslocal();
        if (islocal != null) {
            sQLiteStatement.bindLong(12, islocal.booleanValue() ? 1L : 0L);
        }
        String sort = localSongBean.getSort();
        if (sort != null) {
            sQLiteStatement.bindString(13, sort);
        }
        sQLiteStatement.bindLong(14, localSongBean.getSize());
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
    public LocalSongBean readEntity(Cursor cursor, int i) {
        Boolean valueOf;
        Long valueOf2 = cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
        int i2 = cursor.getInt(i + 1);
        long j = cursor.getLong(i + 2);
        int i3 = cursor.getInt(i + 3);
        String string = cursor.isNull(i + 4) ? null : cursor.getString(i + 4);
        String string2 = cursor.isNull(i + 5) ? null : cursor.getString(i + 5);
        String string3 = cursor.isNull(i + 6) ? null : cursor.getString(i + 6);
        String string4 = cursor.isNull(i + 7) ? null : cursor.getString(i + 7);
        String string5 = cursor.isNull(i + 8) ? null : cursor.getString(i + 8);
        String string6 = cursor.isNull(i + 9) ? null : cursor.getString(i + 9);
        String string7 = cursor.isNull(i + 10) ? null : cursor.getString(i + 10);
        if (cursor.isNull(i + 11)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i + 11) != 0);
        }
        return new LocalSongBean(valueOf2, i2, j, i3, string, string2, string3, string4, string5, string6, string7, valueOf, cursor.isNull(i + 12) ? null : cursor.getString(i + 12), cursor.getInt(i + 13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, LocalSongBean localSongBean, int i) {
        Boolean valueOf;
        localSongBean.setSongId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        localSongBean.setAlbumId(cursor.getInt(i + 1));
        localSongBean.setArtistId(cursor.getLong(i + 2));
        localSongBean.setDuration(cursor.getInt(i + 3));
        localSongBean.setSongName(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        localSongBean.setAlbumName(cursor.isNull(i + 5) ? null : cursor.getString(i + 5));
        localSongBean.setArtistName(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
        localSongBean.setAlbumData(cursor.isNull(i + 7) ? null : cursor.getString(i + 7));
        localSongBean.setData(cursor.isNull(i + 8) ? null : cursor.getString(i + 8));
        localSongBean.setFolder(cursor.isNull(i + 9) ? null : cursor.getString(i + 9));
        localSongBean.setLrc(cursor.isNull(i + 10) ? null : cursor.getString(i + 10));
        if (cursor.isNull(i + 11)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i + 11) != 0);
        }
        localSongBean.setIslocal(valueOf);
        localSongBean.setSort(cursor.isNull(i + 12) ? null : cursor.getString(i + 12));
        localSongBean.setSize(cursor.getInt(i + 13));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(LocalSongBean localSongBean, long j) {
        localSongBean.setSongId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(LocalSongBean localSongBean) {
        if (localSongBean != null) {
            return localSongBean.getSongId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(LocalSongBean localSongBean) {
        return localSongBean.getSongId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
