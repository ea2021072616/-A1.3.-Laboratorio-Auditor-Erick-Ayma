package com.github.appintro.model;

import com.github.appintro.AppIntroBaseFragmentKt;
import e4.e;
/* loaded from: classes.dex */
public final class SliderPagerBuilder {
    private int backgroundColor;
    private int backgroundDrawable;
    private CharSequence description;
    private int descriptionColor;
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;
    private CharSequence title;
    private int titleColor;
    private String titleTypeface;
    private int titleTypefaceFontRes;

    public final SliderPagerBuilder backgroundColor(int i5) {
        this.backgroundColor = i5;
        return this;
    }

    public final SliderPagerBuilder backgroundDrawable(int i5) {
        this.backgroundDrawable = i5;
        return this;
    }

    public final SliderPage build() {
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.description;
        int i5 = this.imageDrawable;
        int i6 = this.backgroundColor;
        int i7 = this.titleColor;
        int i8 = this.descriptionColor;
        int i9 = this.titleTypefaceFontRes;
        String str = this.descriptionTypeface;
        return new SliderPage(charSequence, charSequence2, i5, i6, i7, i8, i9, this.descriptionTypefaceFontRes, this.titleTypeface, str, this.backgroundDrawable);
    }

    public final SliderPagerBuilder description(CharSequence charSequence) {
        e.f(charSequence, "description");
        this.description = charSequence;
        return this;
    }

    public final SliderPagerBuilder descriptionColor(int i5) {
        this.descriptionColor = i5;
        return this;
    }

    public final SliderPagerBuilder descriptionTypeface(String str) {
        e.f(str, "descriptionTypeface");
        this.descriptionTypeface = str;
        return this;
    }

    public final SliderPagerBuilder descriptionTypefaceFontRes(int i5) {
        this.descriptionTypefaceFontRes = i5;
        return this;
    }

    public final SliderPagerBuilder imageDrawable(int i5) {
        this.imageDrawable = i5;
        return this;
    }

    public final SliderPagerBuilder title(CharSequence charSequence) {
        e.f(charSequence, AppIntroBaseFragmentKt.ARG_TITLE);
        this.title = charSequence;
        return this;
    }

    public final SliderPagerBuilder titleColor(int i5) {
        this.titleColor = i5;
        return this;
    }

    public final SliderPagerBuilder titleTypeface(String str) {
        e.f(str, "titleTypeface");
        this.titleTypeface = str;
        return this;
    }

    public final SliderPagerBuilder titleTypefaceFontRes(int i5) {
        this.titleTypefaceFontRes = i5;
        return this;
    }
}
