package com.yanzhenjie.album.task;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class MediaReader {
    private static final String[] IMAGES = {"_data", "_display_name", "title", "bucket_id", "bucket_display_name", "mime_type", "date_added", "date_modified", "latitude", "longitude", "_size"};
    private static final String[] VIDEOS = {"_data", "_display_name", "title", "bucket_id", "bucket_display_name", "mime_type", "date_added", "date_modified", "latitude", "longitude", "_size", "duration", "resolution"};
    private Context mContext;
    private Filter<Long> mDurationFilter;
    private boolean mFilterVisibility;
    private Filter<String> mMimeFilter;
    private Filter<Long> mSizeFilter;

    public MediaReader(Context context, Filter<Long> filter, Filter<String> filter2, Filter<Long> filter3, boolean z) {
        this.mContext = context;
        this.mSizeFilter = filter;
        this.mMimeFilter = filter2;
        this.mDurationFilter = filter3;
        this.mFilterVisibility = z;
    }

    @WorkerThread
    private void scanImageFile(Map<String, AlbumFolder> map, AlbumFolder albumFolder) {
        Cursor query = this.mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGES, null, null, "date_added");
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(IMAGES[0]));
                File file = new File(string);
                if (file.exists() && file.canRead()) {
                    String string2 = query.getString(query.getColumnIndex(IMAGES[1]));
                    String string3 = query.getString(query.getColumnIndex(IMAGES[2]));
                    int i = query.getInt(query.getColumnIndex(IMAGES[3]));
                    String string4 = query.getString(query.getColumnIndex(IMAGES[4]));
                    String string5 = query.getString(query.getColumnIndex(IMAGES[5]));
                    long j = query.getLong(query.getColumnIndex(IMAGES[6]));
                    long j2 = query.getLong(query.getColumnIndex(IMAGES[7]));
                    float f = query.getFloat(query.getColumnIndex(IMAGES[8]));
                    float f2 = query.getFloat(query.getColumnIndex(IMAGES[9]));
                    long j3 = query.getLong(query.getColumnIndex(IMAGES[10]));
                    AlbumFile albumFile = new AlbumFile();
                    albumFile.setMediaType(1);
                    albumFile.setPath(string);
                    albumFile.setName(string2);
                    albumFile.setTitle(string3);
                    albumFile.setBucketId(i);
                    albumFile.setBucketName(string4);
                    albumFile.setMimeType(string5);
                    albumFile.setAddDate(j);
                    albumFile.setModifyDate(j2);
                    albumFile.setLatitude(f);
                    albumFile.setLongitude(f2);
                    albumFile.setSize(j3);
                    if (this.mSizeFilter != null && this.mSizeFilter.filter(Long.valueOf(j3))) {
                        if (this.mFilterVisibility) {
                            albumFile.setEnable(false);
                        }
                    }
                    if (this.mMimeFilter != null && this.mMimeFilter.filter(string5)) {
                        if (this.mFilterVisibility) {
                            albumFile.setEnable(false);
                        }
                    }
                    albumFolder.addAlbumFile(albumFile);
                    AlbumFolder albumFolder2 = map.get(string4);
                    if (albumFolder2 != null) {
                        albumFolder2.addAlbumFile(albumFile);
                    } else {
                        AlbumFolder albumFolder3 = new AlbumFolder();
                        albumFolder3.setId(i);
                        albumFolder3.setName(string4);
                        albumFolder3.addAlbumFile(albumFile);
                        map.put(string4, albumFolder3);
                    }
                }
            }
            query.close();
        }
    }

    @WorkerThread
    private void scanVideoFile(Map<String, AlbumFolder> map, AlbumFolder albumFolder) {
        Cursor query = this.mContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, VIDEOS, null, null, "date_added");
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(VIDEOS[0]));
                File file = new File(string);
                if (file.exists() && file.canRead()) {
                    String string2 = query.getString(query.getColumnIndex(VIDEOS[1]));
                    String string3 = query.getString(query.getColumnIndex(VIDEOS[2]));
                    int i = query.getInt(query.getColumnIndex(VIDEOS[3]));
                    String string4 = query.getString(query.getColumnIndex(VIDEOS[4]));
                    String string5 = query.getString(query.getColumnIndex(VIDEOS[5]));
                    long j = query.getLong(query.getColumnIndex(VIDEOS[6]));
                    long j2 = query.getLong(query.getColumnIndex(VIDEOS[7]));
                    float f = query.getFloat(query.getColumnIndex(VIDEOS[8]));
                    float f2 = query.getFloat(query.getColumnIndex(VIDEOS[9]));
                    long j3 = query.getLong(query.getColumnIndex(VIDEOS[10]));
                    long j4 = query.getLong(query.getColumnIndex(VIDEOS[11]));
                    String string6 = query.getString(query.getColumnIndex(VIDEOS[12]));
                    AlbumFile albumFile = new AlbumFile();
                    albumFile.setMediaType(2);
                    albumFile.setPath(string);
                    albumFile.setName(string2);
                    albumFile.setTitle(string3);
                    albumFile.setBucketId(i);
                    albumFile.setBucketName(string4);
                    albumFile.setMimeType(string5);
                    albumFile.setAddDate(j);
                    albumFile.setModifyDate(j2);
                    albumFile.setLatitude(f);
                    albumFile.setLongitude(f2);
                    albumFile.setSize(j3);
                    albumFile.setDuration(j4);
                    int i2 = 0;
                    int i3 = 0;
                    if (!TextUtils.isEmpty(string6) && string6.contains("x")) {
                        String[] split = string6.split("x");
                        i2 = Integer.valueOf(split[0]).intValue();
                        i3 = Integer.valueOf(split[1]).intValue();
                    }
                    albumFile.setWidth(i2);
                    albumFile.setHeight(i3);
                    if (this.mSizeFilter != null && this.mSizeFilter.filter(Long.valueOf(j3))) {
                        if (this.mFilterVisibility) {
                            albumFile.setEnable(false);
                        }
                    }
                    if (this.mMimeFilter != null && this.mMimeFilter.filter(string5)) {
                        if (this.mFilterVisibility) {
                            albumFile.setEnable(false);
                        }
                    }
                    if (this.mDurationFilter != null && this.mDurationFilter.filter(Long.valueOf(j4))) {
                        if (this.mFilterVisibility) {
                            albumFile.setEnable(false);
                        }
                    }
                    albumFolder.addAlbumFile(albumFile);
                    AlbumFolder albumFolder2 = map.get(string4);
                    if (albumFolder2 != null) {
                        albumFolder2.addAlbumFile(albumFile);
                    } else {
                        AlbumFolder albumFolder3 = new AlbumFolder();
                        albumFolder3.setId(i);
                        albumFolder3.setName(string4);
                        albumFolder3.addAlbumFile(albumFile);
                        map.put(string4, albumFolder3);
                    }
                }
            }
            query.close();
        }
    }

    @WorkerThread
    public ArrayList<AlbumFolder> getAllImage() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.setChecked(true);
        albumFolder.setName(this.mContext.getString(R.string.album_all_images));
        scanImageFile(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.getAlbumFiles());
        arrayList.add(albumFolder);
        for (Map.Entry<String, AlbumFolder> entry : hashMap.entrySet()) {
            AlbumFolder value = entry.getValue();
            Collections.sort(value.getAlbumFiles());
            arrayList.add(value);
        }
        return arrayList;
    }

    @WorkerThread
    public ArrayList<AlbumFolder> getAllVideo() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.setChecked(true);
        albumFolder.setName(this.mContext.getString(R.string.album_all_videos));
        scanVideoFile(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.getAlbumFiles());
        arrayList.add(albumFolder);
        for (Map.Entry<String, AlbumFolder> entry : hashMap.entrySet()) {
            AlbumFolder value = entry.getValue();
            Collections.sort(value.getAlbumFiles());
            arrayList.add(value);
        }
        return arrayList;
    }

    @WorkerThread
    public ArrayList<AlbumFolder> getAllMedia() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.setChecked(true);
        albumFolder.setName(this.mContext.getString(R.string.album_all_images_videos));
        scanImageFile(hashMap, albumFolder);
        scanVideoFile(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.getAlbumFiles());
        arrayList.add(albumFolder);
        for (Map.Entry<String, AlbumFolder> entry : hashMap.entrySet()) {
            AlbumFolder value = entry.getValue();
            Collections.sort(value.getAlbumFiles());
            arrayList.add(value);
        }
        return arrayList;
    }
}
