package com.fotoable.youtube.music.helper.localmusic;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.LocalAlbumBean;
import com.fotoable.youtube.music.bean.LocalArtistsBean;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rx.f;
/* compiled from: LocalMusicScanManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2740a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static String[] f2741b = {"_id", "title", "album", "album_id", "artist", "artist_id", "duration", "_size", "_data", "date_added"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f2742c = {"_id", "album_art", "album", "numsongs", "artist"};
    private static String[] d = {"_id", "number_of_tracks", "artist", "artist_key"};

    public static rx.f<Integer> a(final int i) {
        return rx.f.a(new f.a(i) { // from class: com.fotoable.youtube.music.helper.localmusic.e

            /* renamed from: a  reason: collision with root package name */
            private final int f2743a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2743a = i;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                d.a(this.f2743a, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(int i, rx.l lVar) {
        int b2;
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        switch (i) {
            case 1:
                b2 = b(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
                break;
            default:
                b2 = 0;
                break;
        }
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(Integer.valueOf(b2));
            lVar.onCompleted();
        }
    }

    public static rx.f<List<LocalSongBean>> b(int i) {
        return a((String) null, i);
    }

    public static rx.f<List<LocalSongBean>> a(final String str, final String str2, int i) {
        return rx.f.a(new f.a(str, str2) { // from class: com.fotoable.youtube.music.helper.localmusic.f

            /* renamed from: a  reason: collision with root package name */
            private final String f2744a;

            /* renamed from: b  reason: collision with root package name */
            private final String f2745b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2744a = str;
                this.f2745b = str2;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                d.a(this.f2744a, this.f2745b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, String str2, rx.l lVar) {
        new ArrayList();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        sb.append(" and ").append("album").append(" = ").append("'").append(b(str)).append("'");
        sb.append(" and ").append("artist").append(" like ").append("'").append(b(str2)).append("%'");
        sb.append(" escape '/'");
        com.fotoable.youtube.music.util.h.a(f2740a, "sql:" + sb.toString());
        List<LocalSongBean> c2 = c(contentResolver.query(uri, f2741b, sb.toString(), null, "track, title_key"));
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(c2);
            lVar.onCompleted();
        }
    }

    public static rx.f<List<LocalSongBean>> a(final String str, final int i) {
        return rx.f.a(new f.a(i, str) { // from class: com.fotoable.youtube.music.helper.localmusic.g

            /* renamed from: a  reason: collision with root package name */
            private final int f2746a;

            /* renamed from: b  reason: collision with root package name */
            private final String f2747b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2746a = i;
                this.f2747b = str;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                d.a(this.f2746a, this.f2747b, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(int i, String str, rx.l lVar) {
        List<LocalSongBean> a2;
        ArrayList arrayList = new ArrayList();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        switch (i) {
            case 1:
                a2 = c(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
                break;
            case 2:
                sb.append(" and ").append("album_id").append(" = ").append(str);
                a2 = c(contentResolver.query(uri, f2741b, sb.toString(), null, "track, title_key"));
                break;
            case 3:
                sb.append(" and ").append("artist").append(" like ").append("'").append(b(str)).append("%'").append(" escape '/'");
                a2 = c(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
                break;
            case 4:
                sb.append(" and ").append("title").append(" like ").append("'%").append(b(str.replaceAll("'", "''"))).append("%'").append(" escape '/'");
                a2 = c(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
                break;
            case 5:
                sb.append(" and ").append("artist").append(" like ").append("'%").append(b(str.replaceAll("'", "''"))).append("%'").append(" escape '/'");
                a2 = a(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
                break;
            default:
                a2 = arrayList;
                break;
        }
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(a2);
            lVar.onCompleted();
        }
    }

    public static LocalSongBean a(long j) {
        Cursor query = MusicApplication.c().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, new StringBuilder("_id= ?").toString(), new String[]{j + ""}, "title_key");
        if (query == null) {
            return null;
        }
        query.moveToFirst();
        LocalSongBean localSongBean = new LocalSongBean();
        if (query.getCount() == 0) {
            if (query != null) {
                try {
                    query.close();
                    return null;
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    return null;
                }
            }
            return null;
        }
        query.getString(query.getColumnIndexOrThrow("is_music"));
        localSongBean.songId = Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id")));
        localSongBean.albumId = query.getInt(query.getColumnIndexOrThrow("album_id"));
        localSongBean.albumName = query.getString(query.getColumnIndexOrThrow("album"));
        localSongBean.albumData = b(localSongBean.albumId) + "";
        localSongBean.duration = query.getInt(query.getColumnIndexOrThrow("duration"));
        localSongBean.songName = query.getString(query.getColumnIndexOrThrow("title"));
        localSongBean.artistName = query.getString(query.getColumnIndexOrThrow("artist"));
        localSongBean.artistId = query.getLong(query.getColumnIndexOrThrow("artist_id"));
        String string = query.getString(query.getColumnIndexOrThrow("_data"));
        localSongBean.data = string;
        localSongBean.folder = string.substring(0, string.lastIndexOf(File.separator));
        localSongBean.size = query.getInt(query.getColumnIndexOrThrow("_size"));
        localSongBean.islocal = true;
        localSongBean.sort = com.fotoable.youtube.music.util.a.e.a(localSongBean.songName.charAt(0)).substring(0, 1).toUpperCase();
        return localSongBean;
    }

    public static List<LocalSongBean> a() {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        return c(contentResolver.query(uri, f2741b, sb.toString(), null, "date_added DESC"));
    }

    private static List<LocalSongBean> a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    LocalSongBean localSongBean = new LocalSongBean();
                    localSongBean.setSongId(Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("_id"))));
                    localSongBean.setAlbumId(cursor.getInt(cursor.getColumnIndexOrThrow("album_id")));
                    localSongBean.setAlbumName(cursor.getString(cursor.getColumnIndexOrThrow("album")));
                    localSongBean.setAlbumData(b(localSongBean.albumId) + "");
                    localSongBean.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow("duration")));
                    localSongBean.setSongName(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                    localSongBean.setArtistName(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
                    localSongBean.setArtistId(cursor.getLong(cursor.getColumnIndexOrThrow("artist_id")));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    localSongBean.setData(string);
                    localSongBean.setFolder(string.substring(0, string.lastIndexOf(File.separator)));
                    localSongBean.setSize(cursor.getInt(cursor.getColumnIndexOrThrow("_size")));
                    localSongBean.setIslocal(true);
                    localSongBean.setSort(com.fotoable.youtube.music.util.a.e.a(localSongBean.songName.charAt(0)).substring(0, 1).toUpperCase());
                    arrayList.add(localSongBean);
                } catch (IllegalArgumentException e) {
                    ThrowableExtension.printStackTrace(e);
                    return null;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            com.fotoable.youtube.music.util.h.a(f2740a, arrayList.size() + "");
            return arrayList;
        }
        return arrayList;
    }

    private static int b(Cursor cursor) {
        int i = 0;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                i++;
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    private static List<LocalSongBean> c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    LocalSongBean localSongBean = new LocalSongBean();
                    localSongBean.setSongId(Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("_id"))));
                    localSongBean.setAlbumId(cursor.getInt(cursor.getColumnIndexOrThrow("album_id")));
                    localSongBean.setAlbumName(cursor.getString(cursor.getColumnIndexOrThrow("album")));
                    localSongBean.setAlbumData(b(localSongBean.albumId) + "");
                    localSongBean.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow("duration")));
                    localSongBean.setSongName(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                    localSongBean.setArtistName(cursor.getString(cursor.getColumnIndexOrThrow("artist")));
                    localSongBean.setArtistId(cursor.getLong(cursor.getColumnIndexOrThrow("artist_id")));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    localSongBean.setData(string);
                    if (!TextUtils.isEmpty(string)) {
                        int lastIndexOf = string.lastIndexOf(File.separator);
                        if (lastIndexOf == -1) {
                            lastIndexOf = string.length();
                        }
                        localSongBean.setFolder(string.substring(0, lastIndexOf));
                    }
                    localSongBean.setSize(cursor.getInt(cursor.getColumnIndexOrThrow("_size")));
                    localSongBean.setIslocal(true);
                    localSongBean.setSort(com.fotoable.youtube.music.util.a.e.a(localSongBean.songName.charAt(0)).substring(0, 1).toUpperCase());
                    arrayList.add(localSongBean);
                } catch (IllegalArgumentException e) {
                    ThrowableExtension.printStackTrace(e);
                } catch (OutOfMemoryError e2) {
                    ThrowableExtension.printStackTrace(e2);
                    com.fotoable.youtube.music.util.b.b("Dev_本地内存溢出", "操作", "歌曲列表");
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    public static List<LocalSongBean> a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder("_id in (");
        String replace = new Gson().toJson(list).replace("[", "").replace("]", "");
        sb.append(replace);
        sb.append(")");
        com.fotoable.youtube.music.util.h.a("local manager", "songIdStr:" + replace);
        Cursor query = contentResolver.query(uri, null, sb.toString(), null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            LocalSongBean localSongBean = new LocalSongBean();
            String string = query.getString(query.getColumnIndexOrThrow("is_music"));
            if (string == null || !string.equals("")) {
                localSongBean.songId = Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id")));
                localSongBean.albumId = query.getInt(query.getColumnIndexOrThrow("album_id"));
                localSongBean.albumName = query.getString(query.getColumnIndexOrThrow("album"));
                localSongBean.albumData = b(localSongBean.albumId) + "";
                localSongBean.duration = query.getInt(query.getColumnIndexOrThrow("duration"));
                localSongBean.songName = query.getString(query.getColumnIndexOrThrow("title"));
                localSongBean.artistName = query.getString(query.getColumnIndexOrThrow("artist"));
                localSongBean.artistId = query.getLong(query.getColumnIndexOrThrow("artist_id"));
                String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                localSongBean.data = string2;
                localSongBean.folder = string2.substring(0, string2.lastIndexOf(File.separator));
                localSongBean.size = query.getInt(query.getColumnIndexOrThrow("_size"));
                localSongBean.islocal = true;
                localSongBean.sort = com.fotoable.youtube.music.util.a.e.a(localSongBean.songName.charAt(0)).substring(0, 1).toUpperCase();
                arrayList.add(localSongBean);
            }
            query.moveToNext();
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public static rx.f<List<LocalSongBean>> a(final String str) {
        return rx.f.a(new f.a(str) { // from class: com.fotoable.youtube.music.helper.localmusic.h

            /* renamed from: a  reason: collision with root package name */
            private final String f2748a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2748a = str;
            }

            @Override // rx.c.b
            public void call(Object obj) {
                d.a(this.f2748a, (rx.l) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(String str, rx.l lVar) {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        sb.append(" and ").append("artist").append(" like ").append("'%").append(b(str.replaceAll("'", "''"))).append("%'").append(" escape '/'");
        List<LocalSongBean> a2 = a(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(a2);
            lVar.onCompleted();
        }
    }

    public static String b(String str) {
        return str.replace("/", "//").replaceAll("'", "''").replace("%", "/%").replace("&", "/&").replace(b.a.a.a.a.d.b.ROLL_OVER_FILE_NAME_SEPARATOR, "/_");
    }

    private static Uri b(long j) {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), j);
    }

    public static rx.f<List<LocalArtistsBean>> b() {
        return rx.f.a(i.f2749a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(rx.l lVar) {
        Uri uri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
        List<LocalArtistsBean> d2 = d(MusicApplication.c().getContentResolver().query(uri, d, "_id in (select distinct artist_id from audio_meta where (1=1 ) and _size > 1048576 and duration > " + DefaultLoadControl.DEFAULT_MAX_BUFFER_MS + ")", null, "artist_key"));
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(d2);
            lVar.onCompleted();
        }
    }

    private static List<LocalArtistsBean> d(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    LocalArtistsBean localArtistsBean = new LocalArtistsBean();
                    localArtistsBean.setArtist_name(cursor.getString(cursor.getColumnIndex("artist")).split("/", 2)[0]);
                    localArtistsBean.setNumber_of_tracks(c(localArtistsBean.getArtist_name()));
                    localArtistsBean.setArtist_id(cursor.getLong(cursor.getColumnIndex("_id")));
                    localArtistsBean.setArtist_sort(com.fotoable.youtube.music.util.a.e.a(localArtistsBean.artist_name.charAt(0)).substring(0, 1).toUpperCase());
                    arrayList.add(localArtistsBean);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                } catch (OutOfMemoryError e2) {
                    ThrowableExtension.printStackTrace(e2);
                    com.fotoable.youtube.music.util.b.b("Dev_本地内存溢出", "操作", "歌手列表");
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    private static int c(String str) {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = MusicApplication.c().getContentResolver();
        StringBuilder sb = new StringBuilder(" 1=1 and title != ''");
        sb.append(" and ").append("_size").append(" > ").append(1048576);
        sb.append(" and ").append("duration").append(" > ").append(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        sb.append(" and ").append("artist").append(" like ").append("'").append(b(str)).append("%'").append(" escape '/'");
        return b(contentResolver.query(uri, f2741b, sb.toString(), null, "title_key"));
    }

    public static void a(Long l) {
        try {
            MusicApplication.c().getContentResolver().delete(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, l.longValue()), null, null);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static rx.f<List<LocalAlbumBean>> c() {
        return rx.f.a(j.f2750a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(rx.l lVar) {
        Uri uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        List<LocalAlbumBean> e = e(MusicApplication.c().getContentResolver().query(uri, f2742c, "_id in (select distinct album_id from audio_meta where (1=1 ) and _size > 1048576 and duration > " + DefaultLoadControl.DEFAULT_MAX_BUFFER_MS + ")", null, "album_key"));
        if (lVar != null && !lVar.isUnsubscribed()) {
            lVar.onNext(e);
            lVar.onCompleted();
        }
    }

    private static List<LocalAlbumBean> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    LocalAlbumBean localAlbumBean = new LocalAlbumBean();
                    localAlbumBean.setAlbum_name(cursor.getString(cursor.getColumnIndex("album")));
                    localAlbumBean.setAlbum_id(cursor.getInt(cursor.getColumnIndex("_id")));
                    localAlbumBean.setNumber_of_songs(cursor.getInt(cursor.getColumnIndex("numsongs")));
                    localAlbumBean.setAlbum_art(b(localAlbumBean.album_id) + "");
                    localAlbumBean.setAlbum_artist(cursor.getString(cursor.getColumnIndex("artist")).split("/", 2)[0]);
                    localAlbumBean.setAlbum_sort(com.fotoable.youtube.music.util.a.e.a(localAlbumBean.album_name.charAt(0)).substring(0, 1).toUpperCase());
                    arrayList.add(localAlbumBean);
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                } catch (OutOfMemoryError e2) {
                    ThrowableExtension.printStackTrace(e2);
                    com.fotoable.youtube.music.util.b.b("Dev_本地内存溢出", "操作", "专辑列表");
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }
}
