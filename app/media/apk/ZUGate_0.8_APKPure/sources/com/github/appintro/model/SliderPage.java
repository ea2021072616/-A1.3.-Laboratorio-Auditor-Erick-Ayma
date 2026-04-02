package com.github.appintro.model;

import android.os.Bundle;
import com.github.appintro.AppIntroBaseFragmentKt;
import e4.e;
import j4.d;
/* loaded from: classes.dex */
public final class SliderPage {
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

    public SliderPage() {
        this(null, null, 0, 0, 0, 0, 0, 0, null, null, 0, 2047, null);
    }

    public final CharSequence component1() {
        return this.title;
    }

    public final String component10() {
        return this.descriptionTypeface;
    }

    public final int component11() {
        return this.backgroundDrawable;
    }

    public final CharSequence component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageDrawable;
    }

    public final int component4() {
        return this.backgroundColor;
    }

    public final int component5() {
        return this.titleColor;
    }

    public final int component6() {
        return this.descriptionColor;
    }

    public final int component7() {
        return this.titleTypefaceFontRes;
    }

    public final int component8() {
        return this.descriptionTypefaceFontRes;
    }

    public final String component9() {
        return this.titleTypeface;
    }

    public final SliderPage copy(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, String str, String str2, int i11) {
        return new SliderPage(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, str, str2, i11);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SliderPage) {
                SliderPage sliderPage = (SliderPage) obj;
                return e.a(this.title, sliderPage.title) && e.a(this.description, sliderPage.description) && this.imageDrawable == sliderPage.imageDrawable && this.backgroundColor == sliderPage.backgroundColor && this.titleColor == sliderPage.titleColor && this.descriptionColor == sliderPage.descriptionColor && this.titleTypefaceFontRes == sliderPage.titleTypefaceFontRes && this.descriptionTypefaceFontRes == sliderPage.descriptionTypefaceFontRes && e.a(this.titleTypeface, sliderPage.titleTypeface) && e.a(this.descriptionTypeface, sliderPage.descriptionTypeface) && this.backgroundDrawable == sliderPage.backgroundDrawable;
            }
            return false;
        }
        return true;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    public final String getDescriptionString() {
        CharSequence charSequence = this.description;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final String getDescriptionTypeface() {
        return this.descriptionTypeface;
    }

    public final int getDescriptionTypefaceFontRes() {
        return this.descriptionTypefaceFontRes;
    }

    public final int getImageDrawable() {
        return this.imageDrawable;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final String getTitleString() {
        CharSequence charSequence = this.title;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final String getTitleTypeface() {
        return this.titleTypeface;
    }

    public final int getTitleTypefaceFontRes() {
        return this.titleTypefaceFontRes;
    }

    public int hashCode() {
        CharSequence charSequence = this.title;
        int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.description;
        int hashCode2 = (((((((((((((hashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.imageDrawable) * 31) + this.backgroundColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.titleTypefaceFontRes) * 31) + this.descriptionTypefaceFontRes) * 31;
        String str = this.titleTypeface;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.descriptionTypeface;
        return ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.backgroundDrawable;
    }

    public final void setBackgroundColor(int i5) {
        this.backgroundColor = i5;
    }

    public final void setBackgroundDrawable(int i5) {
        this.backgroundDrawable = i5;
    }

    public final void setDescription(CharSequence charSequence) {
        this.description = charSequence;
    }

    public final void setDescriptionColor(int i5) {
        this.descriptionColor = i5;
    }

    public final void setDescriptionTypeface(String str) {
        this.descriptionTypeface = str;
    }

    public final void setDescriptionTypefaceFontRes(int i5) {
        this.descriptionTypefaceFontRes = i5;
    }

    public final void setImageDrawable(int i5) {
        this.imageDrawable = i5;
    }

    public final void setTitle(CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleColor(int i5) {
        this.titleColor = i5;
    }

    public final void setTitleTypeface(String str) {
        this.titleTypeface = str;
    }

    public final void setTitleTypefaceFontRes(int i5) {
        this.titleTypefaceFontRes = i5;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE, getTitleString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, this.titleTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, this.titleTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, getDescriptionString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, this.descriptionTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, this.descriptionTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descriptionColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.imageDrawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.backgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.backgroundDrawable);
        return bundle;
    }

    public String toString() {
        return "SliderPage(title=" + this.title + ", description=" + this.description + ", imageDrawable=" + this.imageDrawable + ", backgroundColor=" + this.backgroundColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", titleTypefaceFontRes=" + this.titleTypefaceFontRes + ", descriptionTypefaceFontRes=" + this.descriptionTypefaceFontRes + ", titleTypeface=" + this.titleTypeface + ", descriptionTypeface=" + this.descriptionTypeface + ", backgroundDrawable=" + this.backgroundDrawable + ")";
    }

    public SliderPage(CharSequence charSequence) {
        this(charSequence, null, 0, 0, 0, 0, 0, 0, null, null, 0, 2046, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2) {
        this(charSequence, charSequence2, 0, 0, 0, 0, 0, 0, null, null, 0, 2044, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5) {
        this(charSequence, charSequence2, i5, 0, 0, 0, 0, 0, null, null, 0, 2040, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6) {
        this(charSequence, charSequence2, i5, i6, 0, 0, 0, 0, null, null, 0, 2032, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7) {
        this(charSequence, charSequence2, i5, i6, i7, 0, 0, 0, null, null, 0, 2016, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8) {
        this(charSequence, charSequence2, i5, i6, i7, i8, 0, 0, null, null, 0, 1984, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9) {
        this(charSequence, charSequence2, i5, i6, i7, i8, i9, 0, null, null, 0, 1920, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10) {
        this(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, null, null, 0, 1792, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, String str) {
        this(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, str, null, 0, 1536, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, String str, String str2) {
        this(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, str, str2, 0, 1024, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, String str, String str2, int i11) {
        this.title = charSequence;
        this.description = charSequence2;
        this.imageDrawable = i5;
        this.backgroundColor = i6;
        this.titleColor = i7;
        this.descriptionColor = i8;
        this.titleTypefaceFontRes = i9;
        this.descriptionTypefaceFontRes = i10;
        this.titleTypeface = str;
        this.descriptionTypeface = str2;
        this.backgroundDrawable = i11;
    }

    public /* synthetic */ SliderPage(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, String str, String str2, int i11, int i12, d dVar) {
        this((i12 & 1) != 0 ? null : charSequence, (i12 & 2) != 0 ? null : charSequence2, (i12 & 4) != 0 ? 0 : i5, (i12 & 8) != 0 ? 0 : i6, (i12 & 16) != 0 ? 0 : i7, (i12 & 32) != 0 ? 0 : i8, (i12 & 64) != 0 ? 0 : i9, (i12 & 128) != 0 ? 0 : i10, (i12 & 256) != 0 ? null : str, (i12 & 512) == 0 ? str2 : null, (i12 & 1024) == 0 ? i11 : 0);
    }
}
