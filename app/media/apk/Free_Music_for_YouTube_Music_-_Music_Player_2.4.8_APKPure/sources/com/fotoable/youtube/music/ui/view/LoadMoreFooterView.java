package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class LoadMoreFooterView extends FrameLayout {
    private boolean isInit;
    private View mErrorView;
    private View mLoadingView;
    private OnRetryListener mOnRetryListener;
    private Status mStatus;
    private View mTheEndView;

    /* loaded from: classes.dex */
    public interface OnRetryListener {
        void onRetry(LoadMoreFooterView loadMoreFooterView);
    }

    /* loaded from: classes.dex */
    public enum Status {
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    public LoadMoreFooterView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public LoadMoreFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public LoadMoreFooterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        if (!this.isInit) {
            this.isInit = true;
            LayoutInflater.from(context).inflate(R.layout.load_more_footer_view, (ViewGroup) this, true);
            this.mLoadingView = findViewById(R.id.load_more_loading_view);
            this.mErrorView = findViewById(R.id.load_more_error_view);
            this.mTheEndView = findViewById(R.id.load_more_end_view);
            this.mErrorView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.view.LoadMoreFooterView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (LoadMoreFooterView.this.mOnRetryListener != null) {
                        LoadMoreFooterView.this.mOnRetryListener.onRetry(LoadMoreFooterView.this);
                    }
                }
            });
            setStatus(Status.LOADING);
        }
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.mOnRetryListener = onRetryListener;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public void setStatus(Status status) {
        this.mStatus = status;
        change();
    }

    public boolean canLoadMore() {
        return this.mStatus == Status.GONE || this.mStatus == Status.ERROR;
    }

    private void change() {
        switch (this.mStatus) {
            case GONE:
                this.mLoadingView.setVisibility(8);
                this.mErrorView.setVisibility(8);
                this.mTheEndView.setVisibility(8);
                return;
            case LOADING:
                this.mLoadingView.setVisibility(0);
                this.mErrorView.setVisibility(8);
                this.mTheEndView.setVisibility(8);
                return;
            case ERROR:
                this.mLoadingView.setVisibility(8);
                this.mErrorView.setVisibility(0);
                this.mTheEndView.setVisibility(8);
                return;
            case THE_END:
                this.mLoadingView.setVisibility(8);
                this.mErrorView.setVisibility(8);
                this.mTheEndView.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
