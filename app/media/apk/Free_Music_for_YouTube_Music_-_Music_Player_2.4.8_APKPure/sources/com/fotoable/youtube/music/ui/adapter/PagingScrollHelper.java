package com.fotoable.youtube.music.ui.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class PagingScrollHelper {
    onPageChangeListener mOnPageChangeListener;
    RecyclerView mRecyclerView = null;
    private MyOnScrollListener mOnScrollListener = new MyOnScrollListener();
    private MyOnFlingListener mOnFlingListener = new MyOnFlingListener();
    private int offsetY = 0;
    private int offsetX = 0;
    int startY = 0;
    int startX = 0;
    ORIENTATION mOrientation = ORIENTATION.HORIZONTAL;
    ValueAnimator mAnimator = null;
    private MyOnTouchListener mOnTouchListener = new MyOnTouchListener();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ORIENTATION {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    /* loaded from: classes.dex */
    public interface onPageChangeListener {
        void onPageChange(int i);
    }

    public void setUpRecycleView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("recycleView must be not null");
        }
        this.mRecyclerView = recyclerView;
        recyclerView.setOnFlingListener(this.mOnFlingListener);
        recyclerView.setOnScrollListener(this.mOnScrollListener);
        recyclerView.setOnTouchListener(this.mOnTouchListener);
        updateLayoutManger();
    }

    public void updateLayoutManger() {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                this.mOrientation = ORIENTATION.VERTICAL;
            } else if (layoutManager.canScrollHorizontally()) {
                this.mOrientation = ORIENTATION.HORIZONTAL;
            } else {
                this.mOrientation = ORIENTATION.NULL;
            }
            if (this.mAnimator != null) {
                this.mAnimator.cancel();
            }
            this.startX = 0;
            this.startY = 0;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }

    /* loaded from: classes.dex */
    public class MyOnFlingListener extends RecyclerView.OnFlingListener {
        public MyOnFlingListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            int i3;
            int width;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return false;
            }
            int startPageIndex = PagingScrollHelper.this.getStartPageIndex();
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                i3 = PagingScrollHelper.this.offsetY;
                if (i2 < 0) {
                    startPageIndex--;
                } else if (i2 > 0) {
                    startPageIndex++;
                }
                width = startPageIndex * PagingScrollHelper.this.mRecyclerView.getHeight();
            } else {
                i3 = PagingScrollHelper.this.offsetX;
                if (i < 0) {
                    startPageIndex--;
                } else if (i > 0) {
                    startPageIndex++;
                }
                width = startPageIndex * PagingScrollHelper.this.mRecyclerView.getWidth();
            }
            if (width < 0) {
                width = 0;
            }
            if (PagingScrollHelper.this.mAnimator == null) {
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                new ValueAnimator();
                pagingScrollHelper.mAnimator = ValueAnimator.ofInt(i3, width);
                PagingScrollHelper.this.mAnimator.setDuration(300L);
                PagingScrollHelper.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.ui.adapter.PagingScrollHelper.MyOnFlingListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(0, intValue - PagingScrollHelper.this.offsetY);
                            return;
                        }
                        PagingScrollHelper.this.mRecyclerView.scrollBy(intValue - PagingScrollHelper.this.offsetX, 0);
                    }
                });
                PagingScrollHelper.this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.fotoable.youtube.music.ui.adapter.PagingScrollHelper.MyOnFlingListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (PagingScrollHelper.this.mOnPageChangeListener != null) {
                            PagingScrollHelper.this.mOnPageChangeListener.onPageChange(PagingScrollHelper.this.getPageIndex());
                        }
                    }
                });
            } else {
                PagingScrollHelper.this.mAnimator.cancel();
                PagingScrollHelper.this.mAnimator.setIntValues(i3, width);
            }
            PagingScrollHelper.this.mAnimator.start();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class MyOnScrollListener extends RecyclerView.OnScrollListener {
        public MyOnScrollListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2 = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            int i3 = 0;
            if (i == 0 && PagingScrollHelper.this.mOrientation != ORIENTATION.NULL) {
                if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                    if (!(Math.abs(PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY) > recyclerView.getHeight() / 2)) {
                        i2 = 0;
                    } else if (PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY >= 0) {
                        i2 = 1000;
                    }
                    int i4 = i2;
                    i2 = 0;
                    i3 = i4;
                } else {
                    if (!(Math.abs(PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX) > recyclerView.getWidth() / 2)) {
                        i2 = 0;
                    } else if (PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX >= 0) {
                        i2 = 1000;
                    }
                }
                PagingScrollHelper.this.mOnFlingListener.onFling(i2, i3);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            PagingScrollHelper.this.offsetY += i2;
            PagingScrollHelper.this.offsetX += i;
        }
    }

    /* loaded from: classes.dex */
    public class MyOnTouchListener implements View.OnTouchListener {
        public MyOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                PagingScrollHelper.this.startY = PagingScrollHelper.this.offsetY;
                PagingScrollHelper.this.startX = PagingScrollHelper.this.offsetX;
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndex() {
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.offsetY / this.mRecyclerView.getHeight();
        }
        return this.offsetX / this.mRecyclerView.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartPageIndex() {
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.startY / this.mRecyclerView.getHeight();
        }
        return this.startX / this.mRecyclerView.getWidth();
    }

    public void setOnPageChangeListener(onPageChangeListener onpagechangelistener) {
        this.mOnPageChangeListener = onpagechangelistener;
    }
}
