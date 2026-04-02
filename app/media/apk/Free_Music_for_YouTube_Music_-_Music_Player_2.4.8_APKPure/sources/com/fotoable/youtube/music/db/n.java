package com.fotoable.youtube.music.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fotoable.youtube.music.db.greendao.gen.ArtistsCoverModelDao;
import com.fotoable.youtube.music.db.greendao.gen.DurationBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.FavBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalRecentlyModelDao;
import com.fotoable.youtube.music.db.greendao.gen.LocalSongBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.PlayListModelDao;
import com.fotoable.youtube.music.db.greendao.gen.PlayMusicModelDao;
import com.fotoable.youtube.music.db.greendao.gen.RadioBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.RecentlyWatchBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.SubBeanDao;
import com.fotoable.youtube.music.db.greendao.gen.YoutubeCommentLocalLikeModelDao;
import com.fotoable.youtube.music.db.greendao.gen.a;
import org.greenrobot.greendao.database.Database;
/* compiled from: MySQLiteOpenHelper.java */
/* loaded from: classes.dex */
public class n extends a.AbstractC0058a {
    public n(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory);
        Log.e("greenDAO", "Upgrading  version " + str + "   ");
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onUpgrade(Database database, int i, int i2) {
        Log.e("greenDAO", "Upgrading  version " + i + "   " + i2);
        m.a().a(database, FavBeanDao.class, RecentlyWatchBeanDao.class, SubBeanDao.class, PlayListModelDao.class, PlayMusicModelDao.class, DurationBeanDao.class, LocalSongBeanDao.class, RadioBeanDao.class, ArtistsCoverModelDao.class, LocalRecentlyModelDao.class, YoutubeCommentLocalLikeModelDao.class);
    }
}
