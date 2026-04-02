package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
/* loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public HeaderBehavior() {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        break;
                    }
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.support.design.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            r7 = 1
            r8 = -1
            r5 = 0
            int r0 = r9.mTouchSlop
            if (r0 >= 0) goto L15
            android.content.Context r0 = r10.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r9.mTouchSlop = r0
        L15:
            int r0 = r12.getActionMasked()
            switch(r0) {
                case 0: goto L27;
                case 1: goto L82;
                case 2: goto L49;
                case 3: goto La5;
                default: goto L1c;
            }
        L1c:
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto L25
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.addMovement(r12)
        L25:
            r5 = r7
        L26:
            return r5
        L27:
            float r0 = r12.getX()
            int r0 = (int) r0
            float r1 = r12.getY()
            int r1 = (int) r1
            boolean r0 = r10.isPointInChildBounds(r11, r0, r1)
            if (r0 == 0) goto L26
            boolean r0 = r9.canDragView(r11)
            if (r0 == 0) goto L26
            r9.mLastMotionY = r1
            int r0 = r12.getPointerId(r5)
            r9.mActivePointerId = r0
            r9.ensureVelocityTracker()
            goto L1c
        L49:
            int r0 = r9.mActivePointerId
            int r0 = r12.findPointerIndex(r0)
            if (r0 == r8) goto L26
            float r0 = r12.getY(r0)
            int r0 = (int) r0
            int r1 = r9.mLastMotionY
            int r3 = r1 - r0
            boolean r1 = r9.mIsBeingDragged
            if (r1 != 0) goto L6d
            int r1 = java.lang.Math.abs(r3)
            int r2 = r9.mTouchSlop
            if (r1 <= r2) goto L6d
            r9.mIsBeingDragged = r7
            if (r3 <= 0) goto L7e
            int r1 = r9.mTouchSlop
            int r3 = r3 - r1
        L6d:
            boolean r1 = r9.mIsBeingDragged
            if (r1 == 0) goto L1c
            r9.mLastMotionY = r0
            int r4 = r9.getMaxDragOffset(r11)
            r0 = r9
            r1 = r10
            r2 = r11
            r0.scroll(r1, r2, r3, r4, r5)
            goto L1c
        L7e:
            int r1 = r9.mTouchSlop
            int r3 = r3 + r1
            goto L6d
        L82:
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto La5
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            int r1 = r9.mActivePointerId
            float r6 = r0.getYVelocity(r1)
            int r0 = r9.getScrollRangeForDragFling(r11)
            int r4 = -r0
            r1 = r9
            r2 = r10
            r3 = r11
            r1.fling(r2, r3, r4, r5, r6)
        La5:
            r9.mIsBeingDragged = r5
            r9.mActivePointerId = r8
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto L1c
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.recycle()
            r0 = 0
            r9.mVelocityTracker = r0
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.HeaderBehavior.onTouchEvent(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.mFlingRunnable != null) {
            v.removeCallbacks(this.mFlingRunnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (this.mScroller.computeScrollOffset()) {
            this.mFlingRunnable = new FlingRunnable(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.mFlingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v);
        return false;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean canDragView(V v) {
        return false;
    }

    int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FlingRunnable implements Runnable {
        private final V mLayout;
        private final CoordinatorLayout mParent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.mParent = coordinatorLayout;
            this.mLayout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout != null && HeaderBehavior.this.mScroller != null) {
                if (HeaderBehavior.this.mScroller.computeScrollOffset()) {
                    HeaderBehavior.this.setHeaderTopBottomOffset(this.mParent, this.mLayout, HeaderBehavior.this.mScroller.getCurrY());
                    ViewCompat.postOnAnimation(this.mLayout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
            }
        }
    }
}
