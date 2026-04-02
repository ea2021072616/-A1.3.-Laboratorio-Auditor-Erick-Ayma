package com.yanzhenjie.album.task;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.Filter;
import java.io.File;
/* loaded from: classes2.dex */
public class PathConversion {
    private Filter<Long> mDurationFilter;
    private Filter<String> mMimeFilter;
    private Filter<Long> mSizeFilter;

    public PathConversion(Filter<Long> filter, Filter<String> filter2, Filter<Long> filter3) {
        this.mSizeFilter = filter;
        this.mMimeFilter = filter2;
        this.mDurationFilter = filter3;
    }

    @WorkerThread
    @NonNull
    public AlbumFile convert(String str) {
        int i;
        File file = new File(str);
        String name = file.getName();
        AlbumFile albumFile = new AlbumFile();
        albumFile.setPath(str);
        albumFile.setName(name);
        if (name.contains(".")) {
            name = name.split("\\.")[0];
        }
        albumFile.setTitle(name);
        albumFile.setBucketName(file.getParentFile().getName());
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        albumFile.setMimeType(mimeTypeFromExtension);
        long currentTimeMillis = System.currentTimeMillis();
        albumFile.setAddDate(currentTimeMillis);
        albumFile.setModifyDate(currentTimeMillis);
        albumFile.setSize(file.length());
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            i = 0;
        } else {
            i = mimeTypeFromExtension.contains("video") ? 2 : 0;
            if (mimeTypeFromExtension.contains(MessengerShareContentUtility.MEDIA_IMAGE)) {
                i = 1;
            }
        }
        albumFile.setMediaType(i);
        if (this.mSizeFilter != null && this.mSizeFilter.filter(Long.valueOf(file.length()))) {
            albumFile.setEnable(false);
        }
        if (this.mMimeFilter != null && this.mMimeFilter.filter(mimeTypeFromExtension)) {
            albumFile.setEnable(false);
        }
        if (i == 2) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                albumFile.setDuration(mediaPlayer.getDuration());
                albumFile.setWidth(mediaPlayer.getVideoWidth());
                albumFile.setHeight(mediaPlayer.getVideoHeight());
            } catch (Exception e) {
            } finally {
                mediaPlayer.release();
            }
            if (this.mDurationFilter != null && this.mDurationFilter.filter(Long.valueOf(albumFile.getDuration()))) {
                albumFile.setEnable(false);
            }
        }
        return albumFile;
    }
}
