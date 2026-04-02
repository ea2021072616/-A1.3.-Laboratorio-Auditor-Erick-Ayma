package com.fotoable.youtube.music.db.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes.dex */
public class PlayMusicModelDao extends AbstractDao<PlayMusicModel, Long> {
    public static final String TABLENAME = "PLAY_MUSIC_MODEL";

    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f2700a = new Property(0, Long.class, "id", true, "_id");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f2701b = new Property(1, String.class, "videoId", false, "VIDEO_ID");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f2702c = new Property(2, String.class, "coverImg", false, "COVER_IMG");
        public static final Property d = new Property(3, String.class, "title", false, ShareConstants.TITLE);
        public static final Property e = new Property(4, String.class, "description", false, ShareConstants.DESCRIPTION);
        public static final Property f = new Property(5, Boolean.TYPE, "isFav", false, "IS_FAV");
        public static final Property g = new Property(6, String.class, "duration", false, "DURATION");
        public static final Property h = new Property(7, String.class, "artists", false, "ARTISTS");
        public static final Property i = new Property(8, Long.class, "playlistId", false, "PLAYLIST_ID");
    }

    public PlayMusicModelDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void a(Database database, boolean z) {
        database.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "\"PLAY_MUSIC_MODEL\" (\"_id\" INTEGER PRIMARY KEY ,\"VIDEO_ID\" TEXT,\"COVER_IMG\" TEXT,\"TITLE\" TEXT,\"DESCRIPTION\" TEXT,\"IS_FAV\" INTEGER NOT NULL ,\"DURATION\" TEXT,\"ARTISTS\" TEXT,\"PLAYLIST_ID\" INTEGER);");
    }

    public static void b(Database database, boolean z) {
        database.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "\"PLAY_MUSIC_MODEL\"");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(DatabaseStatement databaseStatement, PlayMusicModel playMusicModel) {
        databaseStatement.clearBindings();
        Long id = playMusicModel.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String videoId = playMusicModel.getVideoId();
        if (videoId != null) {
            databaseStatement.bindString(2, videoId);
        }
        String coverImg = playMusicModel.getCoverImg();
        if (coverImg != null) {
            databaseStatement.bindString(3, coverImg);
        }
        String title = playMusicModel.getTitle();
        if (title != null) {
            databaseStatement.bindString(4, title);
        }
        String description = playMusicModel.getDescription();
        if (description != null) {
            databaseStatement.bindString(5, description);
        }
        databaseStatement.bindLong(6, playMusicModel.getIsFav() ? 1L : 0L);
        String duration = playMusicModel.getDuration();
        if (duration != null) {
            databaseStatement.bindString(7, duration);
        }
        String artists = playMusicModel.getArtists();
        if (artists != null) {
            databaseStatement.bindString(8, artists);
        }
        Long playlistId = playMusicModel.getPlaylistId();
        if (playlistId != null) {
            databaseStatement.bindLong(9, playlistId.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, PlayMusicModel playMusicModel) {
        sQLiteStatement.clearBindings();
        Long id = playMusicModel.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String videoId = playMusicModel.getVideoId();
        if (videoId != null) {
            sQLiteStatement.bindString(2, videoId);
        }
        String coverImg = playMusicModel.getCoverImg();
        if (coverImg != null) {
            sQLiteStatement.bindString(3, coverImg);
        }
        String title = playMusicModel.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(4, title);
        }
        String description = playMusicModel.getDescription();
        if (description != null) {
            sQLiteStatement.bindString(5, description);
        }
        sQLiteStatement.bindLong(6, playMusicModel.getIsFav() ? 1L : 0L);
        String duration = playMusicModel.getDuration();
        if (duration != null) {
            sQLiteStatement.bindString(7, duration);
        }
        String artists = playMusicModel.getArtists();
        if (artists != null) {
            sQLiteStatement.bindString(8, artists);
        }
        Long playlistId = playMusicModel.getPlaylistId();
        if (playlistId != null) {
            sQLiteStatement.bindLong(9, playlistId.longValue());
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
    public PlayMusicModel readEntity(Cursor cursor, int i) {
        return new PlayMusicModel(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)), cursor.isNull(i + 1) ? null : cursor.getString(i + 1), cursor.isNull(i + 2) ? null : cursor.getString(i + 2), cursor.isNull(i + 3) ? null : cursor.getString(i + 3), cursor.isNull(i + 4) ? null : cursor.getString(i + 4), cursor.getShort(i + 5) != 0, cursor.isNull(i + 6) ? null : cursor.getString(i + 6), cursor.isNull(i + 7) ? null : cursor.getString(i + 7), cursor.isNull(i + 8) ? null : Long.valueOf(cursor.getLong(i + 8)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public void readEntity(Cursor cursor, PlayMusicModel playMusicModel, int i) {
        playMusicModel.setId(cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0)));
        playMusicModel.setVideoId(cursor.isNull(i + 1) ? null : cursor.getString(i + 1));
        playMusicModel.setCoverImg(cursor.isNull(i + 2) ? null : cursor.getString(i + 2));
        playMusicModel.setTitle(cursor.isNull(i + 3) ? null : cursor.getString(i + 3));
        playMusicModel.setDescription(cursor.isNull(i + 4) ? null : cursor.getString(i + 4));
        playMusicModel.setIsFav(cursor.getShort(i + 5) != 0);
        playMusicModel.setDuration(cursor.isNull(i + 6) ? null : cursor.getString(i + 6));
        playMusicModel.setArtists(cursor.isNull(i + 7) ? null : cursor.getString(i + 7));
        playMusicModel.setPlaylistId(cursor.isNull(i + 8) ? null : Long.valueOf(cursor.getLong(i + 8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public final Long updateKeyAfterInsert(PlayMusicModel playMusicModel, long j) {
        playMusicModel.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: a */
    public Long getKey(PlayMusicModel playMusicModel) {
        if (playMusicModel != null) {
            return playMusicModel.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    /* renamed from: b */
    public boolean hasKey(PlayMusicModel playMusicModel) {
        return playMusicModel.getId() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }
}
