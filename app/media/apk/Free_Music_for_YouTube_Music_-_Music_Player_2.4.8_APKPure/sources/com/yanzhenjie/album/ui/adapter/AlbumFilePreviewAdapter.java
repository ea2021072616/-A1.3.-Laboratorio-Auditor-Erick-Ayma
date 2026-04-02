package com.yanzhenjie.album.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.util.DisplayUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumFilePreviewAdapter extends BasicPreviewAdapter<AlbumFile> {
    public AlbumFilePreviewAdapter(Context context, List<AlbumFile> list) {
        super(context, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.album.ui.adapter.BasicPreviewAdapter
    public boolean loadPreview(ImageView imageView, AlbumFile albumFile, int i) {
        Album.getAlbumConfig().getAlbumLoader().loadAlbumFile(imageView, albumFile, DisplayUtils.sScreenWidth, DisplayUtils.sScreenHeight);
        return true;
    }
}
