package com.aspsine.irecyclerview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class IRecyclerView extends RecyclerView {
    private static final boolean DEBUG = false;
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_REFRESHING = 3;
    private static final int STATUS_RELEASE_TO_REFRESH = 2;
    private static final int STATUS_SWIPING_TO_REFRESH = 1;
    private static final String TAG = IRecyclerView.class.getSimpleName();
    private int mActivePointerId;
    private Animator.AnimatorListener mAnimationListener;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private LinearLayout mFooterViewContainer;
    private LinearLayout mHeaderViewContainer;
    private boolean mIsAutoRefreshing;
    private int mLastTouchX;
    private int mLastTouchY;
    private boolean mLoadMoreEnabled;
    private FrameLayout mLoadMoreFooterContainer;
    private View mLoadMoreFooterView;
    private OnLoadMoreListener mOnLoadMoreListener;
    private OnLoadMoreScrollListener mOnLoadMoreScrollListener;
    private OnRefreshListener mOnRefreshListener;
    private boolean mRefreshEnabled;
    private int mRefreshFinalMoveOffset;
    private RefreshHeaderLayout mRefreshHeaderContainer;
    private View mRefreshHeaderView;
    private RefreshTrigger mRefreshTrigger;
    private ValueAnimator mScrollAnimator;
    private int mStatus;

    public IRecyclerView(Context context) {
        this(context, null);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.aspsine.irecyclerview.IRecyclerView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                IRecyclerView.this.setRefreshHeaderContainerHeight(intValue);
                switch (IRecyclerView.this.mStatus) {
                    case 1:
                        IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
                        return;
                    case 2:
                        IRecyclerView.this.mRefreshTrigger.onMove(false, true, intValue);
                        return;
                    case 3:
                        IRecyclerView.this.mRefreshTrigger.onMove(true, true, intValue);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mAnimationListener = new SimpleAnimatorListener() { // from class: com.aspsine.irecyclerview.IRecyclerView.2
            @Override // com.aspsine.irecyclerview.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int unused = IRecyclerView.this.mStatus;
                switch (IRecyclerView.this.mStatus) {
                    case 1:
                        if (IRecyclerView.this.mIsAutoRefreshing) {
                            IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                            IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                            IRecyclerView.this.setStatus(3);
                            if (IRecyclerView.this.mOnRefreshListener != null) {
                                IRecyclerView.this.mOnRefreshListener.onRefresh();
                                IRecyclerView.this.mRefreshTrigger.onRefresh();
                                return;
                            }
                            return;
                        }
                        IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                        IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                        IRecyclerView.this.setStatus(0);
                        return;
                    case 2:
                        IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = IRecyclerView.this.mRefreshHeaderView.getMeasuredHeight();
                        IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                        IRecyclerView.this.setStatus(3);
                        if (IRecyclerView.this.mOnRefreshListener != null) {
                            IRecyclerView.this.mOnRefreshListener.onRefresh();
                            IRecyclerView.this.mRefreshTrigger.onRefresh();
                            return;
                        }
                        return;
                    case 3:
                        IRecyclerView.this.mIsAutoRefreshing = false;
                        IRecyclerView.this.mRefreshHeaderContainer.getLayoutParams().height = 0;
                        IRecyclerView.this.mRefreshHeaderContainer.requestLayout();
                        IRecyclerView.this.setStatus(0);
                        IRecyclerView.this.mRefreshTrigger.onReset();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mRefreshTrigger = new RefreshTrigger() { // from class: com.aspsine.irecyclerview.IRecyclerView.3
            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onStart(boolean z, int i2, int i3) {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onStart(z, i2, i3);
                }
            }

            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onMove(boolean z, boolean z2, int i2) {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onMove(z, z2, i2);
                }
            }

            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onRefresh() {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRefresh();
                }
            }

            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onRelease() {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onRelease();
                }
            }

            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onComplete() {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onComplete();
                }
            }

            @Override // com.aspsine.irecyclerview.RefreshTrigger
            public void onReset() {
                if (IRecyclerView.this.mRefreshHeaderView != null && (IRecyclerView.this.mRefreshHeaderView instanceof RefreshTrigger)) {
                    ((RefreshTrigger) IRecyclerView.this.mRefreshHeaderView).onReset();
                }
            }
        };
        this.mOnLoadMoreScrollListener = new OnLoadMoreScrollListener() { // from class: com.aspsine.irecyclerview.IRecyclerView.4
            @Override // com.aspsine.irecyclerview.OnLoadMoreScrollListener
            public void onLoadMore(RecyclerView recyclerView) {
                if (IRecyclerView.this.mOnLoadMoreListener != null && IRecyclerView.this.mStatus == 0) {
                    IRecyclerView.this.mOnLoadMoreListener.onLoadMore();
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IRecyclerView, i, 0);
        try {
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_refreshEnabled, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.IRecyclerView_loadMoreEnabled, false);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_refreshHeaderLayout, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.IRecyclerView_loadMoreFooterLayout, -1);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.IRecyclerView_refreshFinalMoveOffset, -1);
            obtainStyledAttributes.recycle();
            setRefreshEnabled(z);
            setLoadMoreEnabled(z2);
            if (resourceId != -1) {
                setRefreshHeaderView(resourceId);
            }
            if (resourceId2 != -1) {
                setLoadMoreFooterView(resourceId2);
            }
            if (dimensionPixelOffset != -1) {
                setRefreshFinalMoveOffset(dimensionPixelOffset);
            }
            setStatus(0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mRefreshHeaderView != null && this.mRefreshHeaderView.getMeasuredHeight() > this.mRefreshFinalMoveOffset) {
            this.mRefreshFinalMoveOffset = 0;
        }
    }

    public void setRefreshEnabled(boolean z) {
        this.mRefreshEnabled = z;
    }

    public void setLoadMoreEnabled(boolean z) {
        this.mLoadMoreEnabled = z;
        if (this.mLoadMoreEnabled) {
            removeOnScrollListener(this.mOnLoadMoreScrollListener);
            addOnScrollListener(this.mOnLoadMoreScrollListener);
            return;
        }
        removeOnScrollListener(this.mOnLoadMoreScrollListener);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public void setRefreshing(boolean z) {
        if (this.mStatus == 0 && z) {
            this.mIsAutoRefreshing = true;
            setStatus(1);
            startScrollDefaultStatusToRefreshingStatus();
        } else if (this.mStatus == 3 && !z) {
            this.mIsAutoRefreshing = false;
            startScrollRefreshingStatusToDefaultStatus();
        } else {
            this.mIsAutoRefreshing = false;
            Log.w(TAG, "isRefresh = " + z + " current status = " + this.mStatus);
        }
    }

    public void setRefreshFinalMoveOffset(int i) {
        this.mRefreshFinalMoveOffset = i;
    }

    public void setRefreshHeaderView(View view) {
        if (!(view instanceof RefreshTrigger)) {
            throw new ClassCastException("Refresh header view must be an implement of RefreshTrigger");
        }
        if (this.mRefreshHeaderView != null) {
            removeRefreshHeaderView();
        }
        if (this.mRefreshHeaderView != view) {
            this.mRefreshHeaderView = view;
            ensureRefreshHeaderContainer();
            this.mRefreshHeaderContainer.addView(view);
        }
    }

    public void setRefreshHeaderView(@LayoutRes int i) {
        ensureRefreshHeaderContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mRefreshHeaderContainer, false);
        if (inflate != null) {
            setRefreshHeaderView(inflate);
        }
    }

    public void setLoadMoreFooterView(View view) {
        if (this.mLoadMoreFooterView != null) {
            removeLoadMoreFooterView();
        }
        if (this.mLoadMoreFooterView != view) {
            this.mLoadMoreFooterView = view;
            ensureLoadMoreFooterContainer();
            this.mLoadMoreFooterContainer.addView(view);
        }
    }

    public void setLoadMoreFooterView(@LayoutRes int i) {
        ensureLoadMoreFooterContainer();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mLoadMoreFooterContainer, false);
        if (inflate != null) {
            setLoadMoreFooterView(inflate);
        }
    }

    public View getRefreshHeaderView() {
        return this.mRefreshHeaderView;
    }

    public View getLoadMoreFooterView() {
        return this.mLoadMoreFooterView;
    }

    public LinearLayout getHeaderContainer() {
        ensureHeaderViewContainer();
        return this.mHeaderViewContainer;
    }

    public LinearLayout getFooterContainer() {
        ensureFooterViewContainer();
        return this.mFooterViewContainer;
    }

    public void addHeaderView(View view) {
        ensureHeaderViewContainer();
        this.mHeaderViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(1);
        }
    }

    public void addFooterView(View view) {
        ensureFooterViewContainer();
        this.mFooterViewContainer.addView(view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(adapter.getItemCount() - 2);
        }
    }

    public RecyclerView.Adapter getIAdapter() {
        return ((WrapperAdapter) getAdapter()).getAdapter();
    }

    public void setIAdapter(RecyclerView.Adapter adapter) {
        ensureRefreshHeaderContainer();
        ensureHeaderViewContainer();
        ensureFooterViewContainer();
        ensureLoadMoreFooterContainer();
        setAdapter(new WrapperAdapter(adapter, this.mRefreshHeaderContainer, this.mHeaderViewContainer, this.mFooterViewContainer, this.mLoadMoreFooterContainer));
    }

    private void ensureRefreshHeaderContainer() {
        if (this.mRefreshHeaderContainer == null) {
            this.mRefreshHeaderContainer = new RefreshHeaderLayout(getContext());
            this.mRefreshHeaderContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        }
    }

    private void ensureLoadMoreFooterContainer() {
        if (this.mLoadMoreFooterContainer == null) {
            this.mLoadMoreFooterContainer = new FrameLayout(getContext());
            this.mLoadMoreFooterContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureHeaderViewContainer() {
        if (this.mHeaderViewContainer == null) {
            this.mHeaderViewContainer = new LinearLayout(getContext());
            this.mHeaderViewContainer.setOrientation(1);
            this.mHeaderViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void ensureFooterViewContainer() {
        if (this.mFooterViewContainer == null) {
            this.mFooterViewContainer = new LinearLayout(getContext());
            this.mFooterViewContainer.setOrientation(1);
            this.mFooterViewContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
    }

    private void removeRefreshHeaderView() {
        if (this.mRefreshHeaderContainer != null) {
            this.mRefreshHeaderContainer.removeView(this.mRefreshHeaderView);
        }
    }

    private void removeLoadMoreFooterView() {
        if (this.mLoadMoreFooterContainer != null) {
            this.mLoadMoreFooterContainer.removeView(this.mLoadMoreFooterView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                break;
            case 5:
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
        if (r8.mStatus == 0) goto L3;
     */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            r7 = 2
            r0 = 0
            r1 = 1
            int r2 = android.support.v4.view.MotionEventCompat.getActionMasked(r9)
            switch(r2) {
                case 0: goto Lf;
                case 1: goto Le1;
                case 2: goto L26;
                case 3: goto Le6;
                case 4: goto La;
                case 5: goto Lc4;
                case 6: goto Ldc;
                default: goto La;
            }
        La:
            boolean r0 = super.onTouchEvent(r9)
        Le:
            return r0
        Lf:
            int r1 = android.support.v4.view.MotionEventCompat.getActionIndex(r9)
            int r0 = android.support.v4.view.MotionEventCompat.getPointerId(r9, r0)
            r8.mActivePointerId = r0
            int r0 = r8.getMotionEventX(r9, r1)
            r8.mLastTouchX = r0
            int r0 = r8.getMotionEventY(r9, r1)
            r8.mLastTouchY = r0
            goto La
        L26:
            int r2 = r8.mActivePointerId
            int r2 = android.support.v4.view.MotionEventCompat.findPointerIndex(r9, r2)
            if (r2 >= 0) goto L4d
            java.lang.String r1 = com.aspsine.irecyclerview.IRecyclerView.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error processing scroll; pointer index for id "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = " not found. Did any MotionEvents get skipped?"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            goto Le
        L4d:
            int r3 = r8.getMotionEventX(r9, r2)
            int r2 = r8.getMotionEventY(r9, r2)
            int r4 = r8.mLastTouchX
            int r4 = r3 - r4
            int r4 = r8.mLastTouchY
            int r4 = r2 - r4
            r8.mLastTouchX = r3
            r8.mLastTouchY = r2
            boolean r2 = r8.isEnabled()
            if (r2 == 0) goto Lad
            boolean r2 = r8.mRefreshEnabled
            if (r2 == 0) goto Lad
            android.view.View r2 = r8.mRefreshHeaderView
            if (r2 == 0) goto Lad
            boolean r2 = r8.isFingerDragging()
            if (r2 == 0) goto Lad
            boolean r2 = r8.canTriggerRefresh()
            if (r2 == 0) goto Lad
            r2 = r1
        L7c:
            if (r2 == 0) goto La
            com.aspsine.irecyclerview.RefreshHeaderLayout r2 = r8.mRefreshHeaderContainer
            int r2 = r2.getMeasuredHeight()
            android.view.View r3 = r8.mRefreshHeaderView
            int r3 = r3.getMeasuredHeight()
            if (r4 <= 0) goto Laf
            int r5 = r8.mStatus
            if (r5 != 0) goto Laf
            r8.setStatus(r1)
            com.aspsine.irecyclerview.RefreshTrigger r5 = r8.mRefreshTrigger
            int r6 = r8.mRefreshFinalMoveOffset
            r5.onStart(r0, r3, r6)
        L9a:
            int r0 = r8.mStatus
            if (r0 == r1) goto La2
            int r0 = r8.mStatus
            if (r0 != r7) goto La
        La2:
            if (r2 < r3) goto Lc0
            r8.setStatus(r7)
        La7:
            r8.fingerMove(r4)
            r0 = r1
            goto Le
        Lad:
            r2 = r0
            goto L7c
        Laf:
            if (r4 >= 0) goto L9a
            int r5 = r8.mStatus
            if (r5 != r1) goto Lba
            if (r2 > 0) goto Lba
            r8.setStatus(r0)
        Lba:
            int r0 = r8.mStatus
            if (r0 != 0) goto L9a
            goto La
        Lc0:
            r8.setStatus(r1)
            goto La7
        Lc4:
            int r0 = android.support.v4.view.MotionEventCompat.getActionIndex(r9)
            int r1 = android.support.v4.view.MotionEventCompat.getPointerId(r9, r0)
            r8.mActivePointerId = r1
            int r1 = r8.getMotionEventX(r9, r0)
            r8.mLastTouchX = r1
            int r0 = r8.getMotionEventY(r9, r0)
            r8.mLastTouchY = r0
            goto La
        Ldc:
            r8.onPointerUp(r9)
            goto La
        Le1:
            r8.onFingerUpStartAnimating()
            goto La
        Le6:
            r8.onFingerUpStartAnimating()
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aspsine.irecyclerview.IRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isFingerDragging() {
        return getScrollState() == 1;
    }

    public boolean canTriggerRefresh() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return getChildLayoutPosition(childAt) == 0 && childAt.getTop() == this.mRefreshHeaderContainer.getTop();
    }

    private int getMotionEventX(MotionEvent motionEvent, int i) {
        return (int) (MotionEventCompat.getX(motionEvent, i) + 0.5f);
    }

    private int getMotionEventY(MotionEvent motionEvent, int i) {
        return (int) (MotionEventCompat.getY(motionEvent, i) + 0.5f);
    }

    private void onFingerUpStartAnimating() {
        if (this.mStatus == 2) {
            startScrollReleaseStatusToRefreshingStatus();
        } else if (this.mStatus == 1) {
            startScrollSwipingToRefreshStatusToDefaultStatus();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            this.mLastTouchX = getMotionEventX(motionEvent, i);
            this.mLastTouchY = getMotionEventY(motionEvent, i);
        }
    }

    private void fingerMove(int i) {
        int i2 = (int) ((i * 0.5f) + 0.5f);
        int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight();
        int i3 = this.mRefreshFinalMoveOffset;
        int i4 = measuredHeight + i2;
        if (i3 > 0 && i4 > i3) {
            i2 = i3 - measuredHeight;
        }
        if (i4 < 0) {
            i2 = -measuredHeight;
        }
        move(i2);
    }

    private void move(int i) {
        if (i != 0) {
            int measuredHeight = this.mRefreshHeaderContainer.getMeasuredHeight() + i;
            setRefreshHeaderContainerHeight(measuredHeight);
            this.mRefreshTrigger.onMove(false, false, measuredHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshHeaderContainerHeight(int i) {
        this.mRefreshHeaderContainer.getLayoutParams().height = i;
        this.mRefreshHeaderContainer.requestLayout();
    }

    private void startScrollDefaultStatusToRefreshingStatus() {
        this.mRefreshTrigger.onStart(true, this.mRefreshHeaderView.getMeasuredHeight(), this.mRefreshFinalMoveOffset);
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(400, new AccelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollSwipingToRefreshStatusToDefaultStatus() {
        startScrollAnimation(IjkMediaCodecInfo.RANK_SECURE, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollReleaseStatusToRefreshingStatus() {
        this.mRefreshTrigger.onRelease();
        int measuredHeight = this.mRefreshHeaderView.getMeasuredHeight();
        startScrollAnimation(IjkMediaCodecInfo.RANK_SECURE, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), measuredHeight);
    }

    private void startScrollRefreshingStatusToDefaultStatus() {
        this.mRefreshTrigger.onComplete();
        startScrollAnimation(400, new DecelerateInterpolator(), this.mRefreshHeaderContainer.getMeasuredHeight(), 0);
    }

    private void startScrollAnimation(int i, Interpolator interpolator, int i2, int i3) {
        if (this.mScrollAnimator == null) {
            this.mScrollAnimator = new ValueAnimator();
        }
        this.mScrollAnimator.removeAllUpdateListeners();
        this.mScrollAnimator.removeAllListeners();
        this.mScrollAnimator.cancel();
        this.mScrollAnimator.setIntValues(i2, i3);
        this.mScrollAnimator.setDuration(i);
        this.mScrollAnimator.setInterpolator(interpolator);
        this.mScrollAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mScrollAnimator.addListener(this.mAnimationListener);
        this.mScrollAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.mStatus = i;
    }

    private void printStatusLog() {
        Log.i(TAG, getStatusLog(this.mStatus));
    }

    private String getStatusLog(int i) {
        switch (i) {
            case 0:
                return "status_default";
            case 1:
                return "status_swiping_to_refresh";
            case 2:
                return "status_release_to_refresh";
            case 3:
                return "status_refreshing";
            default:
                return "status_illegal!";
        }
    }
}
