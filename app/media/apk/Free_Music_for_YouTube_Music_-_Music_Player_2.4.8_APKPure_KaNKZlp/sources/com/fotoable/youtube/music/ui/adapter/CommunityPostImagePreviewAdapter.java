package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.yanzhenjie.album.ui.adapter.BasicPreviewAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class CommunityPostImagePreviewAdapter extends BasicPreviewAdapter<String> {
    public CommunityPostImagePreviewAdapter(Context context, List<String> list) {
        super(context, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.album.ui.adapter.BasicPreviewAdapter
    public boolean loadPreview(ImageView imageView, String str, int i) {
        return false;
    }
}
