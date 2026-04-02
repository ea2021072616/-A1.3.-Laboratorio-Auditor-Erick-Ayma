package com.fotoable.youtube.music.ui.adapter;

import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.adapter.CategoryListManager;
import com.fotoable.youtube.music.ui.adapter.holder.DecadesHolder;
import com.fotoable.youtube.music.ui.adapter.holder.FeaturedBottomHolder;
import com.fotoable.youtube.music.ui.adapter.holder.GenresHolder;
import com.fotoable.youtube.music.ui.adapter.holder.MoodsHolder;
/* loaded from: classes.dex */
public class CategoryAdapterComponent extends CategoryListManager {
    @Override // com.fotoable.youtube.music.ui.adapter.CategoryListManager
    protected void registerHolderClass() {
        register(0, new CategoryListManager.HolderInfo(MoodsHolder.class, R.layout.view_holder_moods), 0);
        register(1, new CategoryListManager.HolderInfo(DecadesHolder.class, R.layout.view_holder_decades), 1);
        register(2, new CategoryListManager.HolderInfo(GenresHolder.class, R.layout.view_holder_genres), 2);
        register(3, new CategoryListManager.HolderInfo(FeaturedBottomHolder.class, R.layout.feature_list_bottom), 3);
    }
}
