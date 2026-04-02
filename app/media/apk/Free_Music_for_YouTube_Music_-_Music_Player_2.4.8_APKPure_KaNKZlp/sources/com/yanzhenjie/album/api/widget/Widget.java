package com.yanzhenjie.album.api.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.util.AlbumUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class Widget implements Parcelable {
    public static final Parcelable.Creator<Widget> CREATOR = new Parcelable.Creator<Widget>() { // from class: com.yanzhenjie.album.api.widget.Widget.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Widget createFromParcel(Parcel parcel) {
            return new Widget(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Widget[] newArray(int i) {
            return new Widget[i];
        }
    };
    public static final int STYLE_DARK = 2;
    public static final int STYLE_LIGHT = 1;
    private ColorStateList mBucketItemCheckSelector;
    private ButtonStyle mButtonStyle;
    private Context mContext;
    private ColorStateList mMediaItemCheckSelector;
    @ColorInt
    private int mNavigationBarColor;
    @ColorInt
    private int mStatusBarColor;
    private int mStyle;
    private String mTitle;
    @ColorInt
    private int mToolBarColor;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface UIStyle {
    }

    public static Builder newDarkBuilder(Context context) {
        return new Builder(context, 2);
    }

    public static Builder newLightBuilder(Context context) {
        return new Builder(context, 1);
    }

    private Widget(Builder builder) {
        int i;
        int i2;
        int i3;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        this.mContext = builder.mContext;
        this.mStyle = builder.mStyle;
        if (builder.mStatusBarColor == 0) {
            i = ContextCompat.getColor(this.mContext, R.color.album_ColorPrimaryDark);
        } else {
            i = builder.mStatusBarColor;
        }
        this.mStatusBarColor = i;
        if (builder.mToolBarColor == 0) {
            i2 = ContextCompat.getColor(this.mContext, R.color.album_ColorPrimary);
        } else {
            i2 = builder.mToolBarColor;
        }
        this.mToolBarColor = i2;
        if (builder.mNavigationBarColor == 0) {
            i3 = ContextCompat.getColor(this.mContext, R.color.album_ColorPrimaryBlack);
        } else {
            i3 = builder.mNavigationBarColor;
        }
        this.mNavigationBarColor = i3;
        this.mTitle = TextUtils.isEmpty(builder.mTitle) ? this.mContext.getString(R.string.album_title) : builder.mTitle;
        if (builder.mMediaItemCheckSelector == null) {
            colorStateList = AlbumUtils.getColorStateList(ContextCompat.getColor(this.mContext, R.color.album_WhiteGray), ContextCompat.getColor(this.mContext, R.color.album_ColorPrimary));
        } else {
            colorStateList = builder.mMediaItemCheckSelector;
        }
        this.mMediaItemCheckSelector = colorStateList;
        if (builder.mBucketItemCheckSelector == null) {
            colorStateList2 = AlbumUtils.getColorStateList(ContextCompat.getColor(this.mContext, R.color.album_WhiteGray), ContextCompat.getColor(this.mContext, R.color.album_ColorPrimary));
        } else {
            colorStateList2 = builder.mBucketItemCheckSelector;
        }
        this.mBucketItemCheckSelector = colorStateList2;
        this.mButtonStyle = builder.mButtonStyle == null ? ButtonStyle.newDarkBuilder(this.mContext).build() : builder.mButtonStyle;
    }

    public int getStyle() {
        return this.mStyle;
    }

    @ColorInt
    public int getStatusBarColor() {
        return this.mStatusBarColor;
    }

    @ColorInt
    public int getToolBarColor() {
        return this.mToolBarColor;
    }

    @ColorInt
    public int getNavigationBarColor() {
        return this.mNavigationBarColor;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public ColorStateList getMediaItemCheckSelector() {
        return this.mMediaItemCheckSelector;
    }

    public ColorStateList getBucketItemCheckSelector() {
        return this.mBucketItemCheckSelector;
    }

    public ButtonStyle getButtonStyle() {
        return this.mButtonStyle;
    }

    protected Widget(Parcel parcel) {
        this.mStyle = parcel.readInt();
        this.mStatusBarColor = parcel.readInt();
        this.mToolBarColor = parcel.readInt();
        this.mNavigationBarColor = parcel.readInt();
        this.mTitle = parcel.readString();
        this.mMediaItemCheckSelector = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        this.mBucketItemCheckSelector = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        this.mButtonStyle = (ButtonStyle) parcel.readParcelable(ButtonStyle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStyle);
        parcel.writeInt(this.mStatusBarColor);
        parcel.writeInt(this.mToolBarColor);
        parcel.writeInt(this.mNavigationBarColor);
        parcel.writeString(this.mTitle);
        parcel.writeParcelable(this.mMediaItemCheckSelector, i);
        parcel.writeParcelable(this.mBucketItemCheckSelector, i);
        parcel.writeParcelable(this.mButtonStyle, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private ColorStateList mBucketItemCheckSelector;
        private ButtonStyle mButtonStyle;
        private Context mContext;
        private ColorStateList mMediaItemCheckSelector;
        @ColorInt
        private int mNavigationBarColor;
        @ColorInt
        private int mStatusBarColor;
        private int mStyle;
        private String mTitle;
        @ColorInt
        private int mToolBarColor;

        private Builder(Context context, int i) {
            this.mContext = context;
            this.mStyle = i;
        }

        public Builder statusBarColor(@ColorInt int i) {
            this.mStatusBarColor = i;
            return this;
        }

        public Builder toolBarColor(@ColorInt int i) {
            this.mToolBarColor = i;
            return this;
        }

        public Builder navigationBarColor(@ColorInt int i) {
            this.mNavigationBarColor = i;
            return this;
        }

        public Builder title(@StringRes int i) {
            return title(this.mContext.getString(i));
        }

        public Builder title(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder mediaItemCheckSelector(@ColorInt int i, @ColorInt int i2) {
            this.mMediaItemCheckSelector = AlbumUtils.getColorStateList(i, i2);
            return this;
        }

        public Builder bucketItemCheckSelector(@ColorInt int i, @ColorInt int i2) {
            this.mBucketItemCheckSelector = AlbumUtils.getColorStateList(i, i2);
            return this;
        }

        public Builder buttonStyle(@NonNull ButtonStyle buttonStyle) {
            this.mButtonStyle = buttonStyle;
            return this;
        }

        public Widget build() {
            return new Widget(this);
        }
    }

    /* loaded from: classes.dex */
    public static class ButtonStyle implements Parcelable {
        public static final Parcelable.Creator<ButtonStyle> CREATOR = new Parcelable.Creator<ButtonStyle>() { // from class: com.yanzhenjie.album.api.widget.Widget.ButtonStyle.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ButtonStyle createFromParcel(Parcel parcel) {
                return new ButtonStyle(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ButtonStyle[] newArray(int i) {
                return new ButtonStyle[i];
            }
        };
        private ColorStateList mButtonSelector;
        private int mButtonStyle;
        private Context mContext;

        public static Builder newDarkBuilder(@NonNull Context context) {
            return new Builder(context, 2);
        }

        public static Builder newLightBuilder(@NonNull Context context) {
            return new Builder(context, 1);
        }

        private ButtonStyle(Builder builder) {
            ColorStateList colorStateList;
            this.mContext = builder.mContext;
            this.mButtonStyle = builder.mButtonStyle;
            if (builder.mButtonSelector == null) {
                colorStateList = AlbumUtils.getColorStateList(ContextCompat.getColor(this.mContext, R.color.album_ColorPrimary), ContextCompat.getColor(this.mContext, R.color.album_ColorPrimaryDark));
            } else {
                colorStateList = builder.mButtonSelector;
            }
            this.mButtonSelector = colorStateList;
        }

        public int getButtonStyle() {
            return this.mButtonStyle;
        }

        public ColorStateList getButtonSelector() {
            return this.mButtonSelector;
        }

        protected ButtonStyle(Parcel parcel) {
            this.mButtonStyle = parcel.readInt();
            this.mButtonSelector = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mButtonStyle);
            parcel.writeParcelable(this.mButtonSelector, i);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* loaded from: classes.dex */
        public static class Builder {
            private ColorStateList mButtonSelector;
            private int mButtonStyle;
            private Context mContext;

            private Builder(@NonNull Context context, int i) {
                this.mContext = context;
                this.mButtonStyle = i;
            }

            public Builder setButtonSelector(@ColorInt int i, @ColorInt int i2) {
                this.mButtonSelector = AlbumUtils.getColorStateList(i, i2);
                return this;
            }

            public ButtonStyle build() {
                return new ButtonStyle(this);
            }
        }
    }

    public static Widget getDefaultWidget(Context context) {
        return newDarkBuilder(context).statusBarColor(ContextCompat.getColor(context, R.color.album_ColorPrimaryDark)).toolBarColor(ContextCompat.getColor(context, R.color.album_ColorPrimary)).navigationBarColor(ContextCompat.getColor(context, R.color.album_ColorPrimaryBlack)).title(R.string.album_title).mediaItemCheckSelector(ContextCompat.getColor(context, R.color.album_WhiteGray), ContextCompat.getColor(context, R.color.album_ColorPrimary)).bucketItemCheckSelector(ContextCompat.getColor(context, R.color.album_WhiteGray), ContextCompat.getColor(context, R.color.album_ColorPrimary)).buttonStyle(ButtonStyle.newDarkBuilder(context).setButtonSelector(ContextCompat.getColor(context, R.color.album_ColorPrimary), ContextCompat.getColor(context, R.color.album_ColorPrimaryDark)).build()).build();
    }
}
