package com.yanzhenjie.album.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.util.DisplayUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class PathPreviewAdapter extends BasicPreviewAdapter<String> {
    public PathPreviewAdapter(Context context, List<String> list) {
        super(context, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.album.ui.adapter.BasicPreviewAdapter
    public boolean loadPreview(ImageView imageView, String str, int i) {
        Album.getAlbumConfig().getAlbumLoader().loadImage(imageView, str, DisplayUtils.sScreenWidth, DisplayUtils.sScreenHeight);
        return true;
    }
}
