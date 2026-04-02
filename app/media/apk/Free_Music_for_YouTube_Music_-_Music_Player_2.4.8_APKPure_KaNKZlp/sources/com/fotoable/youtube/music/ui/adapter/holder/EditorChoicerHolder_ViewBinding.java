package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class EditorChoicerHolder_ViewBinding implements Unbinder {
    private EditorChoicerHolder target;

    @UiThread
    public EditorChoicerHolder_ViewBinding(EditorChoicerHolder editorChoicerHolder, View view) {
        this.target = editorChoicerHolder;
        editorChoicerHolder.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycle_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditorChoicerHolder editorChoicerHolder = this.target;
        if (editorChoicerHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        editorChoicerHolder.recyclerView = null;
    }
}
