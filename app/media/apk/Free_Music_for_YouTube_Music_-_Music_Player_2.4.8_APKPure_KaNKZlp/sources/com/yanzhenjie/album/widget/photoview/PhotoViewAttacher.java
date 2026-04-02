package com.yanzhenjie.album.widget.photoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.yanzhenjie.album.widget.photoview.gestures.OnGestureListener;
import com.yanzhenjie.album.widget.photoview.gestures.VersionedGestureDetector;
import com.yanzhenjie.album.widget.photoview.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class PhotoViewAttacher implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener {
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    static int SINGLE_TOUCH = 1;
    int ZOOM_DURATION;
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix;
    private float mBaseRotation;
    private boolean mBlockParentIntercept;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private WeakReference<ImageView> mImageView;
    private Interpolator mInterpolator;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private com.yanzhenjie.album.widget.photoview.gestures.GestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    private OnSingleFlingListener mSingleFlingListener;
    private final Matrix mSuppMatrix;
    private OnViewTapListener mViewTapListener;
    private boolean mZoomEnabled;

    /* loaded from: classes2.dex */
    public interface OnMatrixChangedListener {
        void onMatrixChanged(RectF rectF);
    }

    /* loaded from: classes2.dex */
    public interface OnPhotoTapListener {
        void onOutsidePhotoTap();

        void onPhotoTap(View view, float f, float f2);
    }

    /* loaded from: classes2.dex */
    public interface OnScaleChangeListener {
        void onScaleChange(float f, float f2, float f3);
    }

    /* loaded from: classes2.dex */
    public interface OnSingleFlingListener {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    /* loaded from: classes2.dex */
    public interface OnViewTapListener {
        void onViewTap(View view, float f, float f2);
    }

    private static void checkZoomLevels(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    private static boolean hasDrawable(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
            case 1:
                throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yanzhenjie.album.widget.photoview.PhotoViewAttacher$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static void setImageViewScaleTypeMatrix(ImageView imageView) {
        if (imageView != null && !(imageView instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this(imageView, true);
    }

    public PhotoViewAttacher(ImageView imageView, boolean z) {
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.ZOOM_DURATION = 200;
        this.mMinScale = 1.0f;
        this.mMidScale = 1.75f;
        this.mMaxScale = 3.0f;
        this.mAllowParentInterceptOnEdge = true;
        this.mBlockParentIntercept = false;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mScrollEdge = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mImageView = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        setImageViewScaleTypeMatrix(imageView);
        if (!imageView.isInEditMode()) {
            this.mScaleDragDetector = VersionedGestureDetector.newInstance(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.yanzhenjie.album.widget.photoview.PhotoViewAttacher.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.mLongClickListener != null) {
                        PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.getImageView());
                    }
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (PhotoViewAttacher.this.mSingleFlingListener == null || PhotoViewAttacher.this.getScale() > 1.0f || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.SINGLE_TOUCH || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.SINGLE_TOUCH) {
                        return false;
                    }
                    return PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f, f2);
                }
            });
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
            this.mBaseRotation = 0.0f;
            setZoomable(z);
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mScaleChangeListener = onScaleChangeListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public boolean canZoom() {
        return this.mZoomEnabled;
    }

    public void cleanup() {
        if (this.mImageView != null) {
            ImageView imageView = this.mImageView.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                cancelFling();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.mMatrixChangeListener = null;
            this.mPhotoTapListener = null;
            this.mViewTapListener = null;
            this.mImageView = null;
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        ImageView imageView = getImageView();
        if (imageView == null || imageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
        return true;
    }

    public void setBaseRotation(float f) {
        this.mBaseRotation = f % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setRotationTo(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setRotationBy(float f) {
        this.mSuppMatrix.postRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public ImageView getImageView() {
        ImageView imageView = null;
        if (this.mImageView != null) {
            imageView = this.mImageView.get();
        }
        if (imageView == null) {
            cleanup();
        }
        return imageView;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public float getMinimumScale() {
        return this.mMinScale;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public float getMediumScale() {
        return this.mMidScale;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public float getMaximumScale() {
        return this.mMaxScale;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.yanzhenjie.album.widget.photoview.gestures.OnGestureListener
    public void onDrag(float f, float f2) {
        if (!this.mScaleDragDetector.isScaling()) {
            ImageView imageView = getImageView();
            this.mSuppMatrix.postTranslate(f, f2);
            checkAndDisplayMatrix();
            ViewParent parent = imageView.getParent();
            if (this.mAllowParentInterceptOnEdge && !this.mScaleDragDetector.isScaling() && !this.mBlockParentIntercept) {
                if ((this.mScrollEdge == 2 || ((this.mScrollEdge == 0 && f >= 1.0f) || (this.mScrollEdge == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.gestures.OnGestureListener
    public void onFling(float f, float f2, float f3, float f4) {
        ImageView imageView = getImageView();
        this.mCurrentFlingRunnable = new FlingRunnable(imageView.getContext());
        this.mCurrentFlingRunnable.fling(getImageViewWidth(imageView), getImageViewHeight(imageView), (int) f3, (int) f4);
        imageView.post(this.mCurrentFlingRunnable);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (this.mZoomEnabled) {
                int top = imageView.getTop();
                int right = imageView.getRight();
                int bottom = imageView.getBottom();
                int left = imageView.getLeft();
                if (top != this.mIvTop || bottom != this.mIvBottom || left != this.mIvLeft || right != this.mIvRight) {
                    updateBaseMatrix(imageView.getDrawable());
                    this.mIvTop = top;
                    this.mIvRight = right;
                    this.mIvBottom = bottom;
                    this.mIvLeft = left;
                    return;
                }
                return;
            }
            updateBaseMatrix(imageView.getDrawable());
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.gestures.OnGestureListener
    public void onScale(float f, float f2, float f3) {
        if (getScale() < this.mMaxScale || f < 1.0f) {
            if (getScale() > this.mMinScale || f > 1.0f) {
                if (this.mScaleChangeListener != null) {
                    this.mScaleChangeListener.onScaleChange(f, f2, f3);
                }
                this.mSuppMatrix.postScale(f, f, f2, f3);
                checkAndDisplayMatrix();
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.mZoomEnabled && hasDrawable((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    cancelFling();
                    z = false;
                    break;
                case 1:
                case 3:
                    if (getScale() < this.mMinScale && (displayRect = getDisplayRect()) != null) {
                        view.post(new AnimatedZoomRunnable(getScale(), this.mMinScale, displayRect.centerX(), displayRect.centerY()));
                        z = true;
                        break;
                    }
                    break;
                case 2:
                default:
                    z = false;
                    break;
            }
            if (this.mScaleDragDetector != null) {
                boolean isScaling = this.mScaleDragDetector.isScaling();
                boolean isDragging = this.mScaleDragDetector.isDragging();
                z = this.mScaleDragDetector.onTouchEvent(motionEvent);
                boolean z3 = (isScaling || this.mScaleDragDetector.isScaling()) ? false : true;
                boolean z4 = (isDragging || this.mScaleDragDetector.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.mBlockParentIntercept = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setMinimumScale(float f) {
        checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setMediumScale(float f) {
        checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setMaximumScale(float f) {
        checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setScaleLevels(float f, float f2, float f3) {
        checkZoomLevels(f, f2, f3);
        this.mMinScale = f;
        this.mMidScale = f2;
        this.mMaxScale = f3;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mPhotoTapListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public OnViewTapListener getOnViewTapListener() {
        return this.mViewTapListener;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setScale(float f) {
        setScale(f, false);
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setScale(float f, boolean z) {
        ImageView imageView = getImageView();
        if (imageView != null) {
            setScale(f, imageView.getRight() / 2, imageView.getBottom() / 2, z);
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setScale(float f, float f2, float f3, boolean z) {
        ImageView imageView = getImageView();
        if (imageView != null && f >= this.mMinScale && f <= this.mMaxScale) {
            if (z) {
                imageView.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
                return;
            }
            this.mSuppMatrix.setScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (isSupportedScaleType(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            update();
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        update();
    }

    public void update() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (this.mZoomEnabled) {
                setImageViewScaleTypeMatrix(imageView);
                updateBaseMatrix(imageView.getDrawable());
                return;
            }
            resetMatrix();
        }
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    private void cancelFling() {
        if (this.mCurrentFlingRunnable != null) {
            this.mCurrentFlingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    private void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private void checkImageViewScaleType() {
        ImageView imageView = getImageView();
        if (imageView != null && !(imageView instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
        }
    }

    private boolean checkMatrixBounds() {
        RectF displayRect;
        float f;
        float f2 = 0.0f;
        ImageView imageView = getImageView();
        if (imageView != null && (displayRect = getDisplayRect(getDrawMatrix())) != null) {
            float height = displayRect.height();
            float width = displayRect.width();
            int imageViewHeight = getImageViewHeight(imageView);
            if (height <= imageViewHeight) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f = -displayRect.top;
                        break;
                    case 3:
                        f = (imageViewHeight - height) - displayRect.top;
                        break;
                    default:
                        f = ((imageViewHeight - height) / 2.0f) - displayRect.top;
                        break;
                }
            } else if (displayRect.top > 0.0f) {
                f = -displayRect.top;
            } else {
                f = displayRect.bottom < ((float) imageViewHeight) ? imageViewHeight - displayRect.bottom : 0.0f;
            }
            int imageViewWidth = getImageViewWidth(imageView);
            if (width <= imageViewWidth) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f2 = -displayRect.left;
                        break;
                    case 3:
                        f2 = (imageViewWidth - width) - displayRect.left;
                        break;
                    default:
                        f2 = ((imageViewWidth - width) / 2.0f) - displayRect.left;
                        break;
                }
                this.mScrollEdge = 2;
            } else if (displayRect.left > 0.0f) {
                this.mScrollEdge = 0;
                f2 = -displayRect.left;
            } else if (displayRect.right < imageViewWidth) {
                f2 = imageViewWidth - displayRect.right;
                this.mScrollEdge = 1;
            } else {
                this.mScrollEdge = -1;
            }
            this.mSuppMatrix.postTranslate(f2, f);
            return true;
        }
        return false;
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable;
        ImageView imageView = getImageView();
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public Bitmap getVisibleRectangleBitmap() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawingCache();
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.ZOOM_DURATION = i;
    }

    @Override // com.yanzhenjie.album.widget.photoview.IPhotoView
    public IPhotoView getIPhotoViewImplementation() {
        return this;
    }

    private float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        ImageView imageView = getImageView();
        if (imageView != null) {
            checkImageViewScaleType();
            imageView.setImageMatrix(matrix);
            if (this.mMatrixChangeListener != null && (displayRect = getDisplayRect(matrix)) != null) {
                this.mMatrixChangeListener.onMatrixChanged(displayRect);
            }
        }
    }

    private void updateBaseMatrix(Drawable drawable) {
        ImageView imageView = getImageView();
        if (imageView != null && drawable != null) {
            float imageViewWidth = getImageViewWidth(imageView);
            float imageViewHeight = getImageViewHeight(imageView);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mBaseMatrix.reset();
            float f = imageViewWidth / intrinsicWidth;
            float f2 = imageViewHeight / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.mBaseMatrix.postTranslate((imageViewWidth - intrinsicWidth) / 2.0f, (imageViewHeight - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f, f2);
                this.mBaseMatrix.postScale(max, max);
                this.mBaseMatrix.postTranslate((imageViewWidth - (intrinsicWidth * max)) / 2.0f, (imageViewHeight - (max * intrinsicHeight)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f, f2));
                this.mBaseMatrix.postScale(min, min);
                this.mBaseMatrix.postTranslate((imageViewWidth - (intrinsicWidth * min)) / 2.0f, (imageViewHeight - (min * intrinsicHeight)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
                if (((int) this.mBaseRotation) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, intrinsicHeight, intrinsicWidth);
                }
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            resetMatrix();
        }
    }

    private int getImageViewWidth(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int getImageViewHeight(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = PhotoViewAttacher.this.getImageView();
            if (imageView != null) {
                float interpolate = interpolate();
                PhotoViewAttacher.this.onScale((this.mZoomStart + ((this.mZoomEnd - this.mZoomStart) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
                if (interpolate < 1.0f) {
                    Compat.postOnAnimation(imageView, this);
                }
            }
        }

        private float interpolate() {
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / PhotoViewAttacher.this.ZOOM_DURATION));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerProxy.getScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                if (i < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - i);
                    i6 = 0;
                } else {
                    i5 = round;
                    i6 = round;
                }
                int round2 = Math.round(-displayRect.top);
                if (i2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - i2);
                    i8 = 0;
                } else {
                    i7 = round2;
                    i8 = round2;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            if (!this.mScroller.isFinished() && (imageView = PhotoViewAttacher.this.getImageView()) != null && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.setImageViewMatrix(PhotoViewAttacher.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(imageView, this);
            }
        }
    }
}
