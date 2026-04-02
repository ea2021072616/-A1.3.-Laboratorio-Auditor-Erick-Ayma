package com.yanzhenjie.album;

import android.content.Context;
import com.yanzhenjie.album.task.DefaultAlbumLoader;
import java.util.Locale;
/* loaded from: classes.dex */
public class AlbumConfig {
    private AlbumLoader mLoader;
    private Locale mLocale;

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    private AlbumConfig(Builder builder) {
        AlbumLoader albumLoader;
        Locale locale;
        if (builder.mLoader == null) {
            albumLoader = DefaultAlbumLoader.getInstance();
        } else {
            albumLoader = builder.mLoader;
        }
        this.mLoader = albumLoader;
        if (builder.mLocale == null) {
            locale = Locale.getDefault();
        } else {
            locale = builder.mLocale;
        }
        this.mLocale = locale;
    }

    public AlbumLoader getAlbumLoader() {
        return this.mLoader;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private AlbumLoader mLoader;
        private Locale mLocale;

        private Builder(Context context) {
        }

        public Builder setAlbumLoader(AlbumLoader albumLoader) {
            this.mLoader = albumLoader;
            return this;
        }

        public Builder setLocale(Locale locale) {
            this.mLocale = locale;
            return this;
        }

        public AlbumConfig build() {
            return new AlbumConfig(this);
        }
    }
}
