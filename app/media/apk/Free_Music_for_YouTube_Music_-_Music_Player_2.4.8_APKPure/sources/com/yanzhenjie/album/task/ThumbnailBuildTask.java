package com.yanzhenjie.album.task;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.loading.dialog.LoadingDialog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ThumbnailBuildTask extends AsyncTask<Void, Void, ArrayList<AlbumFile>> {
    private ArrayList<AlbumFile> mAlbumFiles;
    private Callback mCallback;
    private Dialog mDialog;
    private ThumbnailBuilder mThumbnailBuilder;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onThumbnailCallback(ArrayList<AlbumFile> arrayList);
    }

    public ThumbnailBuildTask(Context context, ArrayList<AlbumFile> arrayList, Callback callback) {
        this.mAlbumFiles = arrayList;
        this.mCallback = callback;
        this.mDialog = new LoadingDialog(context);
        this.mThumbnailBuilder = new ThumbnailBuilder(context);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.mDialog.isShowing()) {
            this.mDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public ArrayList<AlbumFile> doInBackground(Void... voidArr) {
        Iterator<AlbumFile> it = this.mAlbumFiles.iterator();
        while (it.hasNext()) {
            AlbumFile next = it.next();
            int mediaType = next.getMediaType();
            String str = null;
            if (mediaType == 1) {
                str = this.mThumbnailBuilder.createThumbnailForImage(next.getPath());
            } else if (mediaType == 2) {
                str = this.mThumbnailBuilder.createThumbnailForVideo(next.getPath());
            }
            next.setThumbPath(str);
        }
        return this.mAlbumFiles;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ArrayList<AlbumFile> arrayList) {
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mCallback.onThumbnailCallback(arrayList);
    }
}
