package com.yanzhenjie.album.task;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.loading.dialog.LoadingDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MediaReadTask extends AsyncTask<ArrayList<AlbumFile>, Void, ArrayList<AlbumFolder>> {
    private Callback mCallback;
    private List<AlbumFile> mCheckedFiles;
    private Context mContext;
    private Filter<Long> mDurationFilter;
    private boolean mFilterVisibility;
    private int mFunction;
    private Filter<String> mMimeFilter;
    private Filter<Long> mSizeFilter;
    private Dialog mWaitDialog;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onScanCallback(ArrayList<AlbumFolder> arrayList);
    }

    public MediaReadTask(Context context, int i, Callback callback, List<AlbumFile> list, Filter<Long> filter, Filter<String> filter2, Filter<Long> filter3, boolean z) {
        this.mContext = context;
        this.mFunction = i;
        this.mCallback = callback;
        this.mCheckedFiles = list;
        this.mSizeFilter = filter;
        this.mMimeFilter = filter2;
        this.mDurationFilter = filter3;
        this.mFilterVisibility = z;
        this.mWaitDialog = new LoadingDialog(context);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.mWaitDialog.isShowing()) {
            this.mWaitDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ArrayList<AlbumFolder> arrayList) {
        if (this.mWaitDialog.isShowing()) {
            this.mWaitDialog.dismiss();
        }
        this.mCallback.onScanCallback(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @SafeVarargs
    public final ArrayList<AlbumFolder> doInBackground(ArrayList<AlbumFile>... arrayListArr) {
        ArrayList<AlbumFolder> allVideo;
        MediaReader mediaReader = new MediaReader(this.mContext, this.mSizeFilter, this.mMimeFilter, this.mDurationFilter, this.mFilterVisibility);
        switch (this.mFunction) {
            case 0:
                allVideo = mediaReader.getAllImage();
                break;
            case 1:
                allVideo = mediaReader.getAllVideo();
                break;
            default:
                allVideo = mediaReader.getAllMedia();
                break;
        }
        ArrayList<AlbumFile> arrayList = arrayListArr[0];
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<AlbumFile> albumFiles = allVideo.get(0).getAlbumFiles();
            Iterator<AlbumFile> it = arrayList.iterator();
            while (it.hasNext()) {
                AlbumFile next = it.next();
                for (int i = 0; i < albumFiles.size(); i++) {
                    AlbumFile albumFile = albumFiles.get(i);
                    if (next.equals(albumFile)) {
                        albumFile.setChecked(true);
                        this.mCheckedFiles.add(albumFile);
                    }
                }
            }
        }
        return allVideo;
    }
}
