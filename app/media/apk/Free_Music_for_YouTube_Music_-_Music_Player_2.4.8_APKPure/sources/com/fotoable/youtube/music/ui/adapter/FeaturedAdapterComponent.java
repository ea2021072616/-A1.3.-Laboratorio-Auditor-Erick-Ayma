package com.fotoable.youtube.music.ui.adapter;

import com.fotoable.free.music.R;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.ui.adapter.FeatureListManager;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedBottomHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedPlayListHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FreshSongsHolder;
import com.fotoable.youtube.music.ui.adapter.holder.HitSinglesHolder;
/* loaded from: classes.dex */
public class FeaturedAdapterComponent extends FeatureListManager {
    @Override // com.fotoable.youtube.music.ui.adapter.FeatureListManager
    protected void registerHolderClass() {
        int i;
        if (a.a()) {
            i = 1;
            register(2, new FeatureListManager.HolderInfo(FeaturedPlayListHolder.class, R.layout.view_holder_feature_playlist), 0);
        } else {
            i = 0;
        }
        int i2 = i + 1;
        register(0, new FeatureListManager.HolderInfo(HitSinglesHolder.class, R.layout.view_holder_hit_singles), i);
        register(3, new FeatureListManager.HolderInfo(FreshSongsHolder.class, R.layout.view_holder_hit_singles), i2);
        register(5, new FeatureListManager.HolderInfo(FeaturedBottomHolder.class, R.layout.feature_list_bottom), i2 + 1);
    }
}
