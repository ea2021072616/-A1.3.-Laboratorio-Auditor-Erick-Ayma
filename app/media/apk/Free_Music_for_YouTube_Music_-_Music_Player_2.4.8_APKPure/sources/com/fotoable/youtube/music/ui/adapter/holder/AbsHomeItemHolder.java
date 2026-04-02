package com.fotoable.youtube.music.ui.adapter.holder;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class AbsHomeItemHolder extends RecyclerView.ViewHolder {
    private ViewGroup container;
    private boolean isAttached;
    private boolean isVisible;
    private Unbinder unbinder;

    public AbsHomeItemHolder(View view) {
        super(view);
        this.isVisible = true;
        this.isAttached = false;
        this.unbinder = ButterKnife.bind(this, view);
        this.container = (ViewGroup) view;
    }

    public void hindViews() {
        try {
            this.isVisible = false;
            this.container.setVisibility(8);
            if (this.container.getChildCount() > 0) {
                for (int i = 0; i < this.container.getChildCount(); i++) {
                    this.container.getChildAt(i).setVisibility(8);
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void invisibleViews() {
        try {
            this.isVisible = false;
            this.container.setVisibility(4);
            if (this.container.getChildCount() > 0) {
                for (int i = 0; i < this.container.getChildCount(); i++) {
                    this.container.getChildAt(i).setVisibility(4);
                }
            }
        } catch (Exception e) {
        }
    }

    public void showViews() {
        try {
            this.isVisible = true;
            this.container.setVisibility(0);
            if (this.container.getChildCount() > 0) {
                for (int i = 0; i < this.container.getChildCount(); i++) {
                    this.container.getChildAt(i).setVisibility(0);
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public boolean isAttached() {
        return this.isAttached;
    }

    public void setAttached(boolean z) {
        this.isAttached = z;
        if (z) {
            onAttached();
        } else {
            onDeatched();
        }
    }

    protected void onDeatched() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttached() {
    }

    @CallSuper
    public void onDestory() {
        this.unbinder.unbind();
    }
}
