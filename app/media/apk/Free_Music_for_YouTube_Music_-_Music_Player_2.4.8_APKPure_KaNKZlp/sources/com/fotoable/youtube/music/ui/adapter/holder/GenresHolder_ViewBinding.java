package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.LaToTextView;
/* loaded from: classes.dex */
public class GenresHolder_ViewBinding implements Unbinder {
    private GenresHolder target;

    @UiThread
    public GenresHolder_ViewBinding(GenresHolder genresHolder, View view) {
        this.target = genresHolder;
        genresHolder.genresTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.genres_title_tx, "field 'genresTitleTx'", LaToTextView.class);
        genresHolder.genresRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.genres_recycler_view, "field 'genresRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GenresHolder genresHolder = this.target;
        if (genresHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        genresHolder.genresTitleTx = null;
        genresHolder.genresRecyclerView = null;
    }
}
