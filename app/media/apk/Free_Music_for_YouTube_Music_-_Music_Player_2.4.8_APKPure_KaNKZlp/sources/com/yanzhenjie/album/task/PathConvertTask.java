package com.yanzhenjie.album.task;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.loading.dialog.LoadingDialog;
/* loaded from: classes2.dex */
public class PathConvertTask extends AsyncTask<String, Void, AlbumFile> {
    private Callback mCallback;
    private PathConversion mConversion;
    private Dialog mDialog;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onConvertCallback(AlbumFile albumFile);
    }

    public PathConvertTask(Context context, Callback callback, Filter<Long> filter, Filter<String> filter2, Filter<Long> filter3) {
        this.mDialog = new LoadingDialog(context);
        this.mCallback = callback;
        this.mConversion = new PathConversion(filter, filter2, filter3);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.mDialog.isShowing()) {
            this.mDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public AlbumFile doInBackground(String... strArr) {
        return this.mConversion.convert(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(AlbumFile albumFile) {
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mCallback.onConvertCallback(albumFile);
    }
}
