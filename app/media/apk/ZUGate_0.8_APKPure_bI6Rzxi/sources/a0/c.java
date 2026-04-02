package a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import androidx.viewpager.widget.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public abstract class c {
    public static Uri a(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return e.d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon uri", e5);
            return null;
        } catch (NoSuchMethodException e6) {
            Log.e("IconCompat", "Unable to get icon uri", e6);
            return null;
        } catch (InvocationTargetException e7) {
            Log.e("IconCompat", "Unable to get icon uri", e7);
            return null;
        }
    }

    public static Drawable b(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    public static Icon c(IconCompat iconCompat, Context context) {
        Icon createWithBitmap;
        int i5 = iconCompat.f711a;
        String str = null;
        r1 = null;
        InputStream openInputStream = null;
        str = null;
        str = null;
        switch (i5) {
            case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                return (Icon) iconCompat.f712b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f712b);
                break;
            case l.SCROLL_STATE_SETTLING /* 2 */:
                if (i5 == -1) {
                    int i6 = Build.VERSION.SDK_INT;
                    Object obj = iconCompat.f712b;
                    if (i6 >= 28) {
                        str = e.b(obj);
                    } else {
                        try {
                            str = (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
                        } catch (IllegalAccessException e5) {
                            Log.e("IconCompat", "Unable to get icon package", e5);
                        } catch (NoSuchMethodException e6) {
                            Log.e("IconCompat", "Unable to get icon package", e6);
                        } catch (InvocationTargetException e7) {
                            Log.e("IconCompat", "Unable to get icon package", e7);
                        }
                    }
                } else if (i5 != 2) {
                    throw new IllegalStateException("called getResPackage() on " + iconCompat);
                } else {
                    String str2 = iconCompat.f720j;
                    str = (str2 == null || TextUtils.isEmpty(str2)) ? ((String) iconCompat.f712b).split(":", -1)[0] : iconCompat.f720j;
                }
                createWithBitmap = Icon.createWithResource(str, iconCompat.f715e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) iconCompat.f712b, iconCompat.f715e, iconCompat.f716f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) iconCompat.f712b);
                break;
            case 5:
                createWithBitmap = d.b((Bitmap) iconCompat.f712b);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithBitmap = f.a(iconCompat.c());
                    break;
                } else if (context == null) {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.c());
                } else {
                    Uri c5 = iconCompat.c();
                    String scheme = c5.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            openInputStream = context.getContentResolver().openInputStream(c5);
                        } catch (Exception e8) {
                            Log.w("IconCompat", "Unable to load image from URI: " + c5, e8);
                        }
                    } else {
                        try {
                            openInputStream = new FileInputStream(new File((String) iconCompat.f712b));
                        } catch (FileNotFoundException e9) {
                            Log.w("IconCompat", "Unable to load image from path: " + c5, e9);
                        }
                    }
                    if (openInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.c());
                    }
                    createWithBitmap = d.b(BitmapFactory.decodeStream(openInputStream));
                    break;
                }
                break;
        }
        ColorStateList colorStateList = iconCompat.f717g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f718h;
        if (mode != IconCompat.f710k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }
}
