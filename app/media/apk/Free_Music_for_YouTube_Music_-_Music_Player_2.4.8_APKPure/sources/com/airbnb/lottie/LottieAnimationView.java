package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.aw;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f366a = LottieAnimationView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, aw> f367b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, WeakReference<aw>> f368c = new HashMap();
    private final bf d;
    private final ax e;
    private a f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    @Nullable
    private q k;
    @Nullable
    private aw l;

    /* loaded from: classes.dex */
    public enum a {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.d = new bf() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                LottieAnimationView.this.setComposition(awVar);
                LottieAnimationView.this.k = null;
            }
        };
        this.e = new ax();
        this.h = false;
        this.i = false;
        this.j = false;
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new bf() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                LottieAnimationView.this.setComposition(awVar);
                LottieAnimationView.this.k = null;
            }
        };
        this.e = new ax();
        this.h = false;
        this.i = false;
        this.j = false;
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new bf() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                LottieAnimationView.this.setComposition(awVar);
                LottieAnimationView.this.k = null;
            }
        };
        this.e = new ax();
        this.h = false;
        this.i = false;
        this.j = false;
        a(attributeSet);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        String string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
        if (!isInEditMode() && string != null) {
            setAnimation(string);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.e.g();
            this.i = true;
        }
        this.e.b(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        this.f = a.values()[obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_cacheStrategy, a.None.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            a(new ca(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0)));
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 17 && Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
            this.e.d();
        }
        h();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        a();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.e) {
            a();
        }
        super.setImageDrawable(drawable);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.e.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.e) {
            super.invalidateDrawable(this.e);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.g;
        savedState.progress = this.e.i();
        savedState.isAnimating = this.e.f();
        savedState.isLooping = this.e.e();
        savedState.imageAssetsFolder = this.e.b();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.animationName;
        if (!TextUtils.isEmpty(this.g)) {
            setAnimation(this.g);
        }
        setProgress(savedState.progress);
        b(savedState.isLooping);
        if (savedState.isAnimating) {
            c();
        }
        this.e.a(savedState.imageAssetsFolder);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.h) {
            c();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (b()) {
            d();
            this.h = true;
        }
        a();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void a() {
        if (this.e != null) {
            this.e.c();
        }
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public void setAnimation(String str) {
        a(str, this.f);
    }

    public void a(final String str, final a aVar) {
        this.g = str;
        if (f368c.containsKey(str)) {
            WeakReference<aw> weakReference = f368c.get(str);
            if (weakReference.get() != null) {
                setComposition(weakReference.get());
                return;
            }
        } else if (f367b.containsKey(str)) {
            setComposition(f367b.get(str));
            return;
        }
        this.g = str;
        this.e.l();
        g();
        this.k = aw.a.a(getContext(), str, new bf() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                if (aVar == a.Strong) {
                    LottieAnimationView.f367b.put(str, awVar);
                } else if (aVar == a.Weak) {
                    LottieAnimationView.f368c.put(str, new WeakReference(awVar));
                }
                LottieAnimationView.this.setComposition(awVar);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        g();
        this.k = aw.a.a(getResources(), jSONObject, this.d);
    }

    private void g() {
        if (this.k != null) {
            this.k.a();
            this.k = null;
        }
    }

    public void setComposition(@NonNull aw awVar) {
        this.e.setCallback(this);
        if (this.e.a(awVar)) {
            int a2 = ch.a(getContext());
            int b2 = ch.b(getContext());
            int width = awVar.a().width();
            int height = awVar.a().height();
            if (width > a2 || height > b2) {
                setScale(Math.min(a2 / width, b2 / height));
                Log.w("LOTTIE", String.format("Composition larger than the screen %dx%d vs %dx%d. Scaling down.", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(a2), Integer.valueOf(b2)));
            }
            setImageDrawable(null);
            setImageDrawable(this.e);
            this.l = awVar;
            requestLayout();
        }
    }

    public void setImageAssetsFolder(String str) {
        this.e.a(str);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.e.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.e.b(animatorListener);
    }

    public void b(boolean z) {
        this.e.b(z);
    }

    public boolean b() {
        return this.e.f();
    }

    public void c() {
        this.e.g();
        h();
    }

    public void setSpeed(float f) {
        this.e.a(f);
    }

    public void setImageAssetDelegate(ao aoVar) {
        this.e.a(aoVar);
    }

    public void setScale(float f) {
        this.e.c(f);
        if (getDrawable() == this.e) {
            setImageDrawable(null);
            setImageDrawable(this.e);
        }
    }

    public float getScale() {
        return this.e.j();
    }

    public void d() {
        this.e.l();
        h();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.e.b(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.e.i();
    }

    public long getDuration() {
        if (this.l != null) {
            return this.l.b();
        }
        return 0L;
    }

    private void h() {
        setLayerType(this.j && this.e.f() ? 2 : 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        String imageAssetsFolder;
        boolean isAnimating;
        boolean isLooping;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.isLooping = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeInt(this.isLooping ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
        }
    }
}
