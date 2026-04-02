package com.yanzhenjie.album.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import b.a.a.a.a.d.b;
import com.facebook.appevents.AppEventsConstants;
import com.yanzhenjie.album.provider.CameraFileProvider;
import com.yanzhenjie.album.widget.divider.Api20ItemDivider;
import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import com.yanzhenjie.album.widget.divider.Divider;
import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes.dex */
public class AlbumUtils {
    public static File getAlbumRootPath(Context context) {
        return sdCardIsAvailable() ? Environment.getExternalStorageDirectory() : context.getFilesDir();
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().canWrite();
        }
        return false;
    }

    public static void imageCapture(@NonNull Activity activity, int i, File file) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", getUri(activity, file));
        activity.startActivityForResult(intent, i);
    }

    public static void videoCapture(@NonNull Activity activity, int i, File file, @IntRange(from = 0, to = 1) int i2, @IntRange(from = 1, to = Long.MAX_VALUE) long j, @IntRange(from = 1, to = Long.MAX_VALUE) long j2) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", getUri(activity, file));
        intent.putExtra("android.intent.extra.videoQuality", i2);
        intent.putExtra("android.intent.extra.durationLimit", j);
        intent.putExtra("android.intent.extra.sizeLimit", j2);
        activity.startActivityForResult(intent, i);
    }

    @NonNull
    public static Context applyLanguageForContext(@NonNull Context context, @NonNull Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    @NonNull
    public static String randomJPGPath() {
        return randomJPGPath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    @NonNull
    public static String randomJPGPath(File file) {
        return randomMediaPath(file, ".jpg");
    }

    @NonNull
    public static String randomMP4Path() {
        return randomMP4Path(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    @NonNull
    public static String randomMP4Path(File file) {
        return randomMediaPath(file, ".mp4");
    }

    @NonNull
    private static String randomMediaPath(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, getNowDateTime("yyyyMMdd_HHmmssSSS") + b.ROLL_OVER_FILE_NAME_SEPARATOR + getMD5ForString(UUID.randomUUID().toString()) + str).getAbsolutePath();
    }

    @NonNull
    public static Uri getUri(@NonNull Context context, @NonNull File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return CameraFileProvider.getUriForFile(context, CameraFileProvider.getFileProviderName(context), file);
    }

    @NonNull
    public static String getNowDateTime(@NonNull String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    public static void setDrawableTint(@NonNull Drawable drawable, @ColorInt int i) {
        DrawableCompat.setTint(DrawableCompat.wrap(drawable.mutate()), i);
    }

    @NonNull
    public static Drawable getTintDrawable(@NonNull Drawable drawable, @ColorInt int i) {
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrap, i);
        return wrap;
    }

    public static ColorStateList getColorStateList(@ColorInt int i, @ColorInt int i2) {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[]{16842919}, new int[]{16842913}, new int[0], new int[0], new int[0]}, new int[]{i2, i2, i2, i, i, i});
    }

    @NonNull
    public static SpannableString getColorText(@NonNull CharSequence charSequence, int i, int i2, @ColorInt int i3) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    @NonNull
    public static Divider getDivider(@ColorInt int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            int dip2px = DisplayUtils.dip2px(6.0f);
            return new Api21ItemDivider(i, dip2px, dip2px);
        }
        int dip2px2 = DisplayUtils.dip2px(2.0f);
        return new Api20ItemDivider(i, dip2px2, dip2px2);
    }

    @NonNull
    public static String convertDuration(@IntRange(from = 1, to = Long.MAX_VALUE) long j) {
        String str;
        String str2;
        String str3;
        String str4;
        long j2 = j / 1000;
        int i = (int) (j2 / 3600);
        int i2 = (int) ((j2 - (i * 3600)) / 60);
        int i3 = (int) ((j2 - (i * 3600)) - (i2 * 60));
        if (i <= 0) {
            str = "";
        } else {
            if (i >= 10) {
                str4 = Integer.toString(i);
            } else {
                str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO + i;
            }
            str = str4 + ":";
        }
        if (i2 > 0) {
            if (i2 >= 10) {
                str2 = Integer.toString(i2);
            } else {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + i2;
            }
        } else {
            str2 = "00";
        }
        String str5 = str2 + ":";
        if (i3 > 0) {
            if (i3 >= 10) {
                str3 = Integer.toString(i3);
            } else {
                str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO + i3;
            }
        } else {
            str3 = "00";
        }
        return str + str5 + str3;
    }

    public static String getMD5ForString(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString();
                }
                int i3 = digest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return Integer.toString(str.hashCode());
        }
    }

    @ColorInt
    public static int getAlphaColor(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        return Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
    }
}
