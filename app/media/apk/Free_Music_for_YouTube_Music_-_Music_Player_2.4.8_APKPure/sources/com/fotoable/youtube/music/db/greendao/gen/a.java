package com.fotoable.youtube.music.db.greendao.gen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
/* compiled from: DaoMaster.java */
/* loaded from: classes.dex */
public class a extends AbstractDaoMaster {
    public static void a(Database database, boolean z) {
        LocalPlayListModelDao.a(database, z);
        ArtistsCoverModelDao.a(database, z);
        FavBeanDao.a(database, z);
        LocalRecentlyModelDao.a(database, z);
        RadioBeanDao.a(database, z);
        YoutubeCommentLocalLikeModelDao.a(database, z);
        LocalPlayListMusicModelDao.a(database, z);
        DurationBeanDao.a(database, z);
        PlayMusicModelDao.a(database, z);
        SubBeanDao.a(database, z);
        PlayListModelDao.a(database, z);
        RecentlyWatchBeanDao.a(database, z);
        LocalSongBeanDao.a(database, z);
    }

    public static void b(Database database, boolean z) {
        LocalPlayListModelDao.b(database, z);
        ArtistsCoverModelDao.b(database, z);
        FavBeanDao.b(database, z);
        LocalRecentlyModelDao.b(database, z);
        RadioBeanDao.b(database, z);
        YoutubeCommentLocalLikeModelDao.b(database, z);
        LocalPlayListMusicModelDao.b(database, z);
        DurationBeanDao.b(database, z);
        PlayMusicModelDao.b(database, z);
        SubBeanDao.b(database, z);
        PlayListModelDao.b(database, z);
        RecentlyWatchBeanDao.b(database, z);
        LocalSongBeanDao.b(database, z);
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public a(Database database) {
        super(database, 11);
        registerDaoClass(LocalPlayListModelDao.class);
        registerDaoClass(ArtistsCoverModelDao.class);
        registerDaoClass(FavBeanDao.class);
        registerDaoClass(LocalRecentlyModelDao.class);
        registerDaoClass(RadioBeanDao.class);
        registerDaoClass(YoutubeCommentLocalLikeModelDao.class);
        registerDaoClass(LocalPlayListMusicModelDao.class);
        registerDaoClass(DurationBeanDao.class);
        registerDaoClass(PlayMusicModelDao.class);
        registerDaoClass(SubBeanDao.class);
        registerDaoClass(PlayListModelDao.class);
        registerDaoClass(RecentlyWatchBeanDao.class);
        registerDaoClass(LocalSongBeanDao.class);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    /* renamed from: a */
    public b newSession() {
        return new b(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    /* renamed from: a */
    public b newSession(IdentityScopeType identityScopeType) {
        return new b(this.db, identityScopeType, this.daoConfigMap);
    }

    /* compiled from: DaoMaster.java */
    /* renamed from: com.fotoable.youtube.music.db.greendao.gen.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0058a extends DatabaseOpenHelper {
        public AbstractC0058a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 11);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 11");
            a.a(database, false);
        }
    }
}
