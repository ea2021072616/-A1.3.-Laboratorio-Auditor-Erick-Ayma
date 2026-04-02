package com.github.appintro;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.TypefaceContainer;
import e4.e;
/* loaded from: classes.dex */
public abstract class AppIntroBaseFragment extends Fragment implements SlideSelectionListener, SlideBackgroundColorHolder {
    private int bgDrawable;
    private int defaultBackgroundColor;
    private int descColor;
    private TypefaceContainer descTypeface;
    private String description;
    private int drawable;
    private final String logTAG = LogHelper.makeLogTag(AppIntroBaseFragment.class);
    private String title;
    private int titleColor;
    private TypefaceContainer titleTypeface;

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public abstract int getLayoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.drawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE);
            this.description = bundle.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.titleTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, 0));
            this.descTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, 0));
            this.defaultBackgroundColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.bgDrawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            this.titleColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR);
            this.descColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments == null || arguments.size() == 0) {
            return;
        }
        this.drawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
        this.title = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE);
        this.description = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC);
        this.bgDrawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
        String string = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE);
        String string2 = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE);
        int i5 = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES);
        int i6 = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES);
        this.titleTypeface = new TypefaceContainer(string, i5);
        this.descTypeface = new TypefaceContainer(string2, i6);
        this.defaultBackgroundColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
        this.titleColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, 0);
        this.descColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e.f(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.description);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.main);
        e.e(textView, "titleText");
        textView.setText(this.title);
        e.e(textView2, "descriptionText");
        textView2.setText(this.description);
        int i5 = this.titleColor;
        if (i5 != 0) {
            textView.setTextColor(i5);
        }
        int i6 = this.descColor;
        if (i6 != 0) {
            textView2.setTextColor(i6);
        }
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            typefaceContainer.applyTo(textView);
        }
        TypefaceContainer typefaceContainer2 = this.descTypeface;
        if (typefaceContainer2 != null) {
            typefaceContainer2.applyTo(textView2);
        }
        imageView.setImageResource(this.drawable);
        int i7 = this.bgDrawable;
        if (i7 != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(i7);
            }
        } else if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(this.defaultBackgroundColor);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = getView();
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.image) : null;
        if (imageView instanceof Animatable) {
            ((Animatable) imageView).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.image) : null;
        if (imageView instanceof Animatable) {
            ((Animatable) imageView).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        e.f(bundle, "outState");
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.drawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.bgDrawable);
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE, this.title);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, this.description);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.defaultBackgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descColor);
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, typefaceContainer != null ? typefaceContainer.getTypeFaceUrl() : null);
            TypefaceContainer typefaceContainer2 = this.titleTypeface;
            bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, typefaceContainer2 != null ? typefaceContainer2.getTypeFaceResource() : 0);
        }
        TypefaceContainer typefaceContainer3 = this.descTypeface;
        if (typefaceContainer3 != null) {
            bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, typefaceContainer3 != null ? typefaceContainer3.getTypeFaceUrl() : null);
            TypefaceContainer typefaceContainer4 = this.descTypeface;
            bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, typefaceContainer4 != null ? typefaceContainer4.getTypeFaceResource() : 0);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        String str = this.logTAG;
        LogHelper.d(str, "Slide " + this.title + " has been deselected.");
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        String str = this.logTAG;
        LogHelper.d(str, "Slide " + this.title + " has been selected.");
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public void setBackgroundColor(int i5) {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.main)) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(i5);
    }
}
