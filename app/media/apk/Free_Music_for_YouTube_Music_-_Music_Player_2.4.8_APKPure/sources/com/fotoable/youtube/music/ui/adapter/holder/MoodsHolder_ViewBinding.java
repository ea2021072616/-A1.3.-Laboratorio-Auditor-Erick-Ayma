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
public class MoodsHolder_ViewBinding implements Unbinder {
    private MoodsHolder target;

    @UiThread
    public MoodsHolder_ViewBinding(MoodsHolder moodsHolder, View view) {
        this.target = moodsHolder;
        moodsHolder.moodsTitleTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.moods_title_tx, "field 'moodsTitleTx'", LaToTextView.class);
        moodsHolder.moodsRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.moods_recycler_view, "field 'moodsRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MoodsHolder moodsHolder = this.target;
        if (moodsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        moodsHolder.moodsTitleTx = null;
        moodsHolder.moodsRecyclerView = null;
    }
}
