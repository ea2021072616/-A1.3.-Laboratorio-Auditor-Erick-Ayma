package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.d0;
import h0.o0;
import h0.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class l extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    a mAdapter;
    private List<f> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private g mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<c> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private i mObserver;
    private int mOffscreenPageLimit;
    private g mOnPageChangeListener;
    private List<g> mOnPageChangeListeners;
    private int mPageMargin;
    private h mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final c mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final Comparator<c> COMPARATOR = new u.g(3);
    private static final Interpolator sInterpolator = new q0.c(2);
    private static final k sPositionComparator = new k();

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new c();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new androidx.activity.j(14, this);
        this.mScrollState = 0;
        initViewPager();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z4) {
        if (this.mScrollingCacheEnabled != z4) {
            this.mScrollingCacheEnabled = z4;
        }
    }

    public final void a(boolean z4) {
        boolean z5 = this.mScrollState == 2;
        if (z5) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        g(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i5 = 0; i5 < this.mItems.size(); i5++) {
            c cVar = this.mItems.get(i5);
            if (cVar.f1591c) {
                cVar.f1591c = false;
                z5 = true;
            }
        }
        if (z5) {
            if (!z4) {
                this.mEndScrollRunnable.run();
                return;
            }
            Runnable runnable = this.mEndScrollRunnable;
            WeakHashMap weakHashMap = z0.f3233a;
            postOnAnimation(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i5, int i6) {
        c infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f1590b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i5, i6);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i6 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public c addNewItem(int i5, int i6) {
        c cVar = new c();
        cVar.f1590b = i5;
        cVar.f1589a = this.mAdapter.instantiateItem((ViewGroup) this, i5);
        cVar.f1592d = this.mAdapter.getPageWidth(i5);
        if (i6 < 0 || i6 >= this.mItems.size()) {
            this.mItems.add(cVar);
        } else {
            this.mItems.add(i6, cVar);
        }
        return cVar;
    }

    public void addOnAdapterChangeListener(f fVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(fVar);
    }

    public void addOnPageChangeListener(g gVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(gVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        c infoForChild;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f1590b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        d dVar = (d) layoutParams;
        boolean z4 = dVar.f1594a | (view.getClass().getAnnotation(b.class) != null);
        dVar.f1594a = z4;
        if (!this.mInLayout) {
            super.addView(view, i5, layoutParams);
        } else if (z4) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            dVar.f1597d = true;
            addViewInLayout(view, i5, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto Lb
        L9:
            r0 = r3
            goto L66
        Lb:
            if (r0 == 0) goto L66
            android.view.ViewParent r4 = r0.getParent()
        L11:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1e
            if (r4 != r6) goto L19
            r4 = r1
            goto L1f
        L19:
            android.view.ViewParent r4 = r4.getParent()
            goto L11
        L1e:
            r4 = r2
        L1f:
            if (r4 != 0) goto L66
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L35:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L35
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L9
        L66:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lb7
            if (r3 == r0) goto Lb7
            if (r7 != r5) goto L97
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.d(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.d(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L91
            if (r1 < r2) goto L91
            boolean r0 = r6.pageLeft()
            goto L95
        L91:
            boolean r0 = r3.requestFocus()
        L95:
            r2 = r0
            goto Lca
        L97:
            if (r7 != r4) goto Lca
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.d(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.d(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lb2
            if (r1 > r2) goto Lb2
            boolean r0 = r6.pageRight()
            goto L95
        Lb2:
            boolean r0 = r3.requestFocus()
            goto L95
        Lb7:
            if (r7 == r5) goto Lc6
            if (r7 != r1) goto Lbc
            goto Lc6
        Lbc:
            if (r7 == r4) goto Lc1
            r0 = 2
            if (r7 != r0) goto Lca
        Lc1:
            boolean r2 = r6.pageRight()
            goto Lca
        Lc6:
            boolean r2 = r6.pageLeft()
        Lca:
            if (r2 == 0) goto Ld3
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.l.arrowScroll(int):boolean");
    }

    public final int b(float f5, int i5, int i6, int i7) {
        if (Math.abs(i7) <= this.mFlingDistance || Math.abs(i6) <= this.mMinimumVelocity) {
            i5 += (int) (f5 + (i5 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i6 <= 0) {
            i5++;
        }
        if (this.mItems.size() > 0) {
            ArrayList<c> arrayList = this.mItems;
            return Math.max(this.mItems.get(0).f1590b, Math.min(i5, arrayList.get(arrayList.size() - 1).f1590b));
        }
        return i5;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public final void c(int i5) {
        g gVar = this.mOnPageChangeListener;
        if (gVar != null) {
            gVar.onPageSelected(i5);
        }
        List<g> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                g gVar2 = this.mOnPageChangeListeners.get(i6);
                if (gVar2 != null) {
                    gVar2.onPageSelected(i5);
                }
            }
        }
        g gVar3 = this.mInternalPageChangeListener;
        if (gVar3 != null) {
            gVar3.onPageSelected(i5);
        }
    }

    public boolean canScroll(View view, boolean z4, int i5, int i6, int i7) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i9 = i6 + scrollX;
                if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && (i8 = i7 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom() && canScroll(childAt, true, i5, i9 - childAt.getLeft(), i8 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z4 && view.canScrollHorizontally(-i5);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i5) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i5 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i5 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<g> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!g(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = z0.f3233a;
        postInvalidateOnAnimation();
    }

    public final Rect d(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z4 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i5 = this.mCurItem;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < this.mItems.size()) {
            c cVar = this.mItems.get(i6);
            int itemPosition = this.mAdapter.getItemPosition(cVar.f1589a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i6);
                    i6--;
                    if (!z5) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z5 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, cVar.f1590b, cVar.f1589a);
                    int i7 = this.mCurItem;
                    if (i7 == cVar.f1590b) {
                        i5 = Math.max(0, Math.min(i7, count - 1));
                    }
                } else {
                    int i8 = cVar.f1590b;
                    if (i8 != itemPosition) {
                        if (i8 == this.mCurItem) {
                            i5 = itemPosition;
                        }
                        cVar.f1590b = itemPosition;
                    }
                }
                z4 = true;
            }
            i6++;
        }
        if (z5) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z4) {
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                d dVar = (d) getChildAt(i9).getLayoutParams();
                if (!dVar.f1594a) {
                    dVar.f1596c = 0.0f;
                }
            }
            setCurrentItemInternal(i5, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f1590b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f5) {
        return (float) Math.sin((f5 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z4 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z4 = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z4 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z4) {
            WeakHashMap weakHashMap = z0.f3233a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final c e() {
        int i5;
        int clientWidth = getClientWidth();
        float f5 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f6 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        int i6 = 0;
        boolean z4 = true;
        c cVar = null;
        int i7 = -1;
        float f7 = 0.0f;
        while (i6 < this.mItems.size()) {
            c cVar2 = this.mItems.get(i6);
            if (!z4 && cVar2.f1590b != (i5 = i7 + 1)) {
                cVar2 = this.mTempItem;
                cVar2.f1593e = f5 + f7 + f6;
                cVar2.f1590b = i5;
                cVar2.f1592d = this.mAdapter.getPageWidth(i5);
                i6--;
            }
            c cVar3 = cVar2;
            f5 = cVar3.f1593e;
            float f8 = cVar3.f1592d + f5 + f6;
            if (!z4 && scrollX < f5) {
                return cVar;
            }
            if (scrollX < f8 || i6 == this.mItems.size() - 1) {
                return cVar3;
            }
            int i8 = cVar3.f1590b;
            float f9 = cVar3.f1592d;
            i6++;
            z4 = false;
            i7 = i8;
            f7 = f9;
            cVar = cVar3;
        }
        return cVar;
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            c e5 = e();
            setCurrentItemInternal(b(((scrollX / clientWidth) - e5.f1593e) / e5.f1592d, e5.f1590b, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.mVelocityTracker = null;
        }
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
            } else if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public final void f(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i5);
            this.mActivePointerId = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public void fakeDragBy(float f5) {
        ArrayList<c> arrayList;
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f5;
        float scrollX = getScrollX() - f5;
        float clientWidth = getClientWidth();
        float f6 = this.mFirstOffset * clientWidth;
        float f7 = this.mLastOffset * clientWidth;
        c cVar = this.mItems.get(0);
        c cVar2 = this.mItems.get(arrayList.size() - 1);
        if (cVar.f1590b != 0) {
            f6 = cVar.f1593e * clientWidth;
        }
        if (cVar2.f1590b != this.mAdapter.getCount() - 1) {
            f7 = cVar2.f1593e * clientWidth;
        }
        if (scrollX < f6) {
            scrollX = f6;
        } else if (scrollX > f7) {
            scrollX = f7;
        }
        int i5 = (int) scrollX;
        this.mLastMotionX = (scrollX - i5) + this.mLastMotionX;
        scrollTo(i5, getScrollY());
        g(i5);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    public final boolean g(int i5) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        c e5 = e();
        int clientWidth = getClientWidth();
        int i6 = this.mPageMargin;
        int i7 = clientWidth + i6;
        float f5 = clientWidth;
        int i8 = e5.f1590b;
        float f6 = ((i5 / f5) - e5.f1593e) / (e5.f1592d + (i6 / f5));
        this.mCalledSuper = false;
        onPageScrolled(i8, f6, (int) (i7 * f6));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i5, int i6) {
        if (this.mDrawingOrder == 2) {
            i6 = (i5 - 1) - i6;
        }
        return ((d) this.mDrawingOrderedChildren.get(i6).getLayoutParams()).f1599f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public final boolean h(float f5) {
        boolean z4;
        boolean z5;
        float f6 = this.mLastMotionX - f5;
        this.mLastMotionX = f5;
        float scrollX = getScrollX() + f6;
        float clientWidth = getClientWidth();
        float f7 = this.mFirstOffset * clientWidth;
        float f8 = this.mLastOffset * clientWidth;
        boolean z6 = false;
        c cVar = this.mItems.get(0);
        ArrayList<c> arrayList = this.mItems;
        c cVar2 = arrayList.get(arrayList.size() - 1);
        if (cVar.f1590b != 0) {
            f7 = cVar.f1593e * clientWidth;
            z4 = false;
        } else {
            z4 = true;
        }
        if (cVar2.f1590b != this.mAdapter.getCount() - 1) {
            f8 = cVar2.f1593e * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (scrollX < f7) {
            if (z4) {
                this.mLeftEdge.onPull(Math.abs(f7 - scrollX) / clientWidth);
                z6 = true;
            }
            scrollX = f7;
        } else if (scrollX > f8) {
            if (z5) {
                this.mRightEdge.onPull(Math.abs(scrollX - f8) / clientWidth);
                z6 = true;
            }
            scrollX = f8;
        }
        int i5 = (int) scrollX;
        this.mLastMotionX = (scrollX - i5) + this.mLastMotionX;
        scrollTo(i5, getScrollY());
        g(i5);
        return z6;
    }

    public final void i(int i5, int i6, int i7, int i8) {
        if (i6 > 0 && !this.mItems.isEmpty()) {
            if (this.mScroller.isFinished()) {
                scrollTo((int) ((getScrollX() / (((i6 - getPaddingLeft()) - getPaddingRight()) + i8)) * (((i5 - getPaddingLeft()) - getPaddingRight()) + i7)), getScrollY());
                return;
            } else {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
        }
        c infoForPosition = infoForPosition(this.mCurItem);
        int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f1593e, this.mLastOffset) : 0.0f) * ((i5 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    public c infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public c infoForChild(View view) {
        for (int i5 = 0; i5 < this.mItems.size(); i5++) {
            c cVar = this.mItems.get(i5);
            if (this.mAdapter.isViewFromObject(view, cVar.f1589a)) {
                return cVar;
            }
        }
        return null;
    }

    public c infoForPosition(int i5) {
        for (int i6 = 0; i6 < this.mItems.size(); i6++) {
            c cVar = this.mItems.get(i6);
            if (cVar.f1590b == i5) {
                return cVar;
            }
        }
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f5);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f5);
        this.mCloseEnough = (int) (2.0f * f5);
        this.mDefaultGutterSize = (int) (f5 * 16.0f);
        z0.n(this, new e(this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        o0.u(this, new d0(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public final boolean j() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    public final void k(int i5, int i6, boolean z4, boolean z5) {
        int i7;
        c infoForPosition = infoForPosition(i5);
        if (infoForPosition != null) {
            i7 = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.f1593e, this.mLastOffset)) * getClientWidth());
        } else {
            i7 = 0;
        }
        if (z4) {
            smoothScrollTo(i7, 0, i6);
            if (z5) {
                c(i5);
                return;
            }
            return;
        }
        if (z5) {
            c(i5);
        }
        a(false);
        scrollTo(i7, 0);
        g(i7);
    }

    public final void l() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                this.mDrawingOrderedChildren.add(getChildAt(i5));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i5;
        float f5;
        float f6;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f7 = this.mPageMargin / width2;
        int i6 = 0;
        c cVar = this.mItems.get(0);
        float f8 = cVar.f1593e;
        int size = this.mItems.size();
        int i7 = cVar.f1590b;
        int i8 = this.mItems.get(size - 1).f1590b;
        while (i7 < i8) {
            while (true) {
                i5 = cVar.f1590b;
                if (i7 <= i5 || i6 >= size) {
                    break;
                }
                i6++;
                cVar = this.mItems.get(i6);
            }
            if (i7 == i5) {
                float f9 = cVar.f1593e;
                float f10 = cVar.f1592d;
                f5 = (f9 + f10) * width2;
                f8 = f9 + f10 + f7;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i7);
                f5 = (f8 + pageWidth) * width2;
                f8 = pageWidth + f7 + f8;
            }
            if (this.mPageMargin + f5 > scrollX) {
                f6 = f7;
                this.mMarginDrawable.setBounds(Math.round(f5), this.mTopPageBounds, Math.round(this.mPageMargin + f5), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f6 = f7;
            }
            if (f5 > scrollX + width) {
                return;
            }
            i7++;
            f7 = f6;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            j();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x5 = motionEvent.getX();
            this.mInitialMotionX = x5;
            this.mLastMotionX = x5;
            float y5 = motionEvent.getY();
            this.mInitialMotionY = y5;
            this.mLastMotionY = y5;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                a(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i5 = this.mActivePointerId;
            if (i5 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i5);
                float x6 = motionEvent.getX(findPointerIndex);
                float f5 = x6 - this.mLastMotionX;
                float abs = Math.abs(f5);
                float y6 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y6 - this.mInitialMotionY);
                int i6 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
                if (i6 != 0) {
                    float f6 = this.mLastMotionX;
                    if (!((f6 < ((float) this.mGutterSize) && i6 > 0) || (f6 > ((float) (getWidth() - this.mGutterSize)) && f5 < 0.0f)) && canScroll(this, false, (int) f5, (int) x6, (int) y6)) {
                        this.mLastMotionX = x6;
                        this.mLastMotionY = y6;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                float f7 = this.mTouchSlop;
                if (abs > f7 && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f8 = this.mInitialMotionX;
                    float f9 = this.mTouchSlop;
                    this.mLastMotionX = i6 > 0 ? f8 + f9 : f8 - f9;
                    this.mLastMotionY = y6;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > f7) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && h(x6)) {
                    WeakHashMap weakHashMap = z0.f3233a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            f(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.l.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        d dVar;
        d dVar2;
        int i7;
        setMeasuredDimension(View.getDefaultSize(0, i5), View.getDefaultSize(0, i6));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            boolean z4 = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && (dVar2 = (d) childAt.getLayoutParams()) != null && dVar2.f1594a) {
                int i10 = dVar2.f1595b;
                int i11 = i10 & 7;
                int i12 = i10 & 112;
                boolean z5 = i12 == 48 || i12 == 80;
                if (i11 != 3 && i11 != 5) {
                    z4 = false;
                }
                int i13 = Integer.MIN_VALUE;
                if (z5) {
                    i7 = Integer.MIN_VALUE;
                    i13 = 1073741824;
                } else {
                    i7 = z4 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i14 = ((ViewGroup.LayoutParams) dVar2).width;
                if (i14 != -2) {
                    if (i14 == -1) {
                        i14 = paddingLeft;
                    }
                    i13 = 1073741824;
                } else {
                    i14 = paddingLeft;
                }
                int i15 = ((ViewGroup.LayoutParams) dVar2).height;
                if (i15 == -2) {
                    i15 = measuredHeight;
                    i9 = i7;
                } else if (i15 == -1) {
                    i15 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, i13), View.MeasureSpec.makeMeasureSpec(i15, i9));
                if (z5) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z4) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i8++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8 && ((dVar = (d) childAt2.getLayoutParams()) == null || !dVar.f1594a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * dVar.f1596c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.d r9 = (androidx.viewpager.widget.d) r9
            boolean r10 = r9.f1594a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f1595b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            androidx.viewpager.widget.g r0 = r12.mOnPageChangeListener
            if (r0 == 0) goto L72
            r0.onPageScrolled(r13, r14, r15)
        L72:
            java.util.List<androidx.viewpager.widget.g> r0 = r12.mOnPageChangeListeners
            if (r0 == 0) goto L8d
            int r0 = r0.size()
            r3 = r1
        L7b:
            if (r3 >= r0) goto L8d
            java.util.List<androidx.viewpager.widget.g> r4 = r12.mOnPageChangeListeners
            java.lang.Object r4 = r4.get(r3)
            androidx.viewpager.widget.g r4 = (androidx.viewpager.widget.g) r4
            if (r4 == 0) goto L8a
            r4.onPageScrolled(r13, r14, r15)
        L8a:
            int r3 = r3 + 1
            goto L7b
        L8d:
            androidx.viewpager.widget.g r0 = r12.mInternalPageChangeListener
            if (r0 == 0) goto L94
            r0.onPageScrolled(r13, r14, r15)
        L94:
            androidx.viewpager.widget.h r13 = r12.mPageTransformer
            if (r13 == 0) goto Lc5
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        La0:
            if (r1 >= r14) goto Lc5
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.d r0 = (androidx.viewpager.widget.d) r0
            boolean r0 = r0.f1594a
            if (r0 == 0) goto Lb1
            goto Lc2
        Lb1:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.h r3 = r12.mPageTransformer
            r3.transformPage(r15, r0)
        Lc2:
            int r1 = r1 + 1
            goto La0
        Lc5:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.l.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        int i6;
        int i7;
        int i8;
        c infoForChild;
        int childCount = getChildCount();
        if ((i5 & 2) != 0) {
            i7 = childCount;
            i6 = 0;
            i8 = 1;
        } else {
            i6 = childCount - 1;
            i7 = -1;
            i8 = -1;
        }
        while (i6 != i7) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f1590b == this.mCurItem && childAt.requestFocus(i5, rect)) {
                return true;
            }
            i6 += i8;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.f4245b);
        a aVar = this.mAdapter;
        ClassLoader classLoader = jVar.f1604f;
        if (aVar != null) {
            aVar.restoreState(jVar.f1603e, classLoader);
            setCurrentItemInternal(jVar.f1602d, false, true);
            return;
        }
        this.mRestoredCurItem = jVar.f1602d;
        this.mRestoredAdapterState = jVar.f1603e;
        this.mRestoredClassLoader = classLoader;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.f1602d = this.mCurItem;
        a aVar = this.mAdapter;
        if (aVar != null) {
            jVar.f1603e = aVar.saveState();
        }
        return jVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 != i7) {
            int i9 = this.mPageMargin;
            i(i5, i7, i9, i9);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z4 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.mAdapter) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x5 = motionEvent.getX();
            this.mInitialMotionX = x5;
            this.mLastMotionX = x5;
            float y5 = motionEvent.getY();
            this.mInitialMotionY = y5;
            this.mLastMotionY = y5;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z4 = j();
                    } else {
                        float x6 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x6 - this.mLastMotionX);
                        float y6 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y6 - this.mLastMotionY);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.mIsBeingDragged = true;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            float f5 = this.mInitialMotionX;
                            this.mLastMotionX = x6 - f5 > 0.0f ? f5 + this.mTouchSlop : f5 - this.mTouchSlop;
                            this.mLastMotionY = y6;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z4 = false | h(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    f(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                k(this.mCurItem, 0, true, false);
                z4 = j();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            c e5 = e();
            float f6 = clientWidth;
            setCurrentItemInternal(b(((scrollX / f6) - e5.f1593e) / (e5.f1592d + (this.mPageMargin / f6)), e5.f1590b, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z4 = j();
        }
        if (z4) {
            WeakHashMap weakHashMap = z0.f3233a;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public boolean pageLeft() {
        int i5 = this.mCurItem;
        if (i5 > 0) {
            setCurrentItem(i5 - 1, true);
            return true;
        }
        return false;
    }

    public boolean pageRight() {
        a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(f fVar) {
        List<f> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(fVar);
        }
    }

    public void removeOnPageChangeListener(g gVar) {
        List<g> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                c cVar = this.mItems.get(i5);
                this.mAdapter.destroyItem((ViewGroup) this, cVar.f1590b, cVar.f1589a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            int i6 = 0;
            while (i6 < getChildCount()) {
                if (!((d) getChildAt(i6).getLayoutParams()).f1594a) {
                    removeViewAt(i6);
                    i6--;
                }
                i6++;
            }
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new i(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z4 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z4) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<f> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty() || this.mAdapterChangeListeners.size() <= 0) {
            return;
        }
        b0.n(this.mAdapterChangeListeners.get(0));
        throw null;
    }

    public void setCurrentItem(int i5) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i5, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int i5, boolean z4, boolean z5) {
        setCurrentItemInternal(i5, z4, z5, 0);
    }

    public g setInternalPageChangeListener(g gVar) {
        g gVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = gVar;
        return gVar2;
    }

    public void setOffscreenPageLimit(int i5) {
        if (i5 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i5 + " too small; defaulting to 1");
            i5 = 1;
        }
        if (i5 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i5;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(g gVar) {
        this.mOnPageChangeListener = gVar;
    }

    public void setPageMargin(int i5) {
        int i6 = this.mPageMargin;
        this.mPageMargin = i5;
        int width = getWidth();
        i(width, width, i5, i6);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z4, h hVar) {
        setPageTransformer(z4, hVar, 2);
    }

    public void setScrollState(int i5) {
        if (this.mScrollState == i5) {
            return;
        }
        this.mScrollState = i5;
        if (this.mPageTransformer != null) {
            boolean z4 = i5 != 0;
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).setLayerType(z4 ? this.mPageTransformerLayerType : 0, null);
            }
        }
        g gVar = this.mOnPageChangeListener;
        if (gVar != null) {
            gVar.onPageScrollStateChanged(i5);
        }
        List<g> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                g gVar2 = this.mOnPageChangeListeners.get(i7);
                if (gVar2 != null) {
                    gVar2.onPageScrollStateChanged(i5);
                }
            }
        }
        g gVar3 = this.mInternalPageChangeListener;
        if (gVar3 != null) {
            gVar3.onPageScrollStateChanged(i5);
        }
    }

    public void smoothScrollTo(int i5, int i6) {
        smoothScrollTo(i5, i6, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void populate(int r18) {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.l.populate(int):void");
    }

    public void setCurrentItemInternal(int i5, boolean z4, boolean z5, int i6) {
        a aVar = this.mAdapter;
        if (aVar != null && aVar.getCount() > 0) {
            if (!z5 && this.mCurItem == i5 && this.mItems.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i5 < 0) {
                i5 = 0;
            } else if (i5 >= this.mAdapter.getCount()) {
                i5 = this.mAdapter.getCount() - 1;
            }
            int i7 = this.mOffscreenPageLimit;
            int i8 = this.mCurItem;
            if (i5 > i8 + i7 || i5 < i8 - i7) {
                for (int i9 = 0; i9 < this.mItems.size(); i9++) {
                    this.mItems.get(i9).f1591c = true;
                }
            }
            boolean z6 = this.mCurItem != i5;
            if (this.mFirstLayout) {
                this.mCurItem = i5;
                if (z6) {
                    c(i5);
                }
                requestLayout();
                return;
            }
            populate(i5);
            k(i5, i6, z4, z6);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void setPageTransformer(boolean z4, h hVar, int i5) {
        boolean z5 = hVar != null;
        boolean z6 = z5 != (this.mPageTransformer != null);
        this.mPageTransformer = hVar;
        setChildrenDrawingOrderEnabled(z5);
        if (z5) {
            this.mDrawingOrder = z4 ? 2 : 1;
            this.mPageTransformerLayerType = i5;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z6) {
            populate();
        }
    }

    public void smoothScrollTo(int i5, int i6, int i7) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i8 = scrollX;
        int scrollY = getScrollY();
        int i9 = i5 - i8;
        int i10 = i6 - scrollY;
        if (i9 == 0 && i10 == 0) {
            a(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i11 = clientWidth / 2;
        float f5 = clientWidth;
        float f6 = i11;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i9) * 1.0f) / f5)) * f6) + f6;
        int abs2 = Math.abs(i7);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i9) / ((this.mAdapter.getPageWidth(this.mCurItem) * f5) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, (int) MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i8, scrollY, i9, i10, min);
        WeakHashMap weakHashMap = z0.f3233a;
        postInvalidateOnAnimation();
    }

    public void setCurrentItem(int i5, boolean z4) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i5, z4, false);
    }

    public void setPageMarginDrawable(int i5) {
        setPageMarginDrawable(x.a.b(getContext(), i5));
    }
}
