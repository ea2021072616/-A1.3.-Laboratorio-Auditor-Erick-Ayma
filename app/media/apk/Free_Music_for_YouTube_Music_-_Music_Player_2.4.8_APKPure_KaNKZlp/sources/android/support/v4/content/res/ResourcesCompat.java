package android.support.v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Preconditions;
import android.util.TypedValue;
/* loaded from: classes.dex */
public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            return resources.getDrawableForDensity(i, i2);
        }
        return resources.getDrawable(i);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColorStateList(i, theme) : resources.getColorStateList(i);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false);
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void callbackFailAsync(final int i, @Nullable Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }
    }

    public static void getFont(@NonNull Context context, @FontRes int i, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, null, true);
    }

    private static Typeface loadFont(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z);
        if (loadFont == null && fontCallback == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return loadFont;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface loadFont(@android.support.annotation.NonNull android.content.Context r9, android.content.res.Resources r10, android.util.TypedValue r11, int r12, int r13, @android.support.annotation.Nullable android.support.v4.content.res.ResourcesCompat.FontCallback r14, @android.support.annotation.Nullable android.os.Handler r15, boolean r16) {
        /*
            java.lang.CharSequence r0 = r11.string
            if (r0 != 0) goto L39
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Resource \""
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r10.getResourceName(r12)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "\" ("
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r12)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ") is not a Font: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L39:
            java.lang.CharSequence r0 = r11.string
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L4f
            if (r14 == 0) goto L4d
            r0 = -3
            r14.callbackFailAsync(r0, r15)
        L4d:
            r0 = 0
        L4e:
            return r0
        L4f:
            android.graphics.Typeface r0 = android.support.v4.graphics.TypefaceCompat.findFromCache(r10, r12, r13)
            if (r0 == 0) goto L5b
            if (r14 == 0) goto L4e
            r14.callbackSuccessAsync(r0, r15)
            goto L4e
        L5b:
            java.lang.String r0 = r8.toLowerCase()     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            if (r0 == 0) goto L8d
            android.content.res.XmlResourceParser r0 = r10.getXml(r12)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            android.support.v4.content.res.FontResourcesParserCompat$FamilyResourceEntry r1 = android.support.v4.content.res.FontResourcesParserCompat.parse(r0, r10)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            if (r1 != 0) goto L80
            java.lang.String r0 = "ResourcesCompat"
            java.lang.String r1 = "Failed to find font-family tag"
            android.util.Log.e(r0, r1)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            if (r14 == 0) goto L7e
            r0 = -3
            r14.callbackFailAsync(r0, r15)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
        L7e:
            r0 = 0
            goto L4e
        L80:
            r0 = r9
            r2 = r10
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            android.graphics.Typeface r0 = android.support.v4.graphics.TypefaceCompat.createFromResourcesFamilyXml(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            goto L4e
        L8d:
            android.graphics.Typeface r0 = android.support.v4.graphics.TypefaceCompat.createFromResourcesFontFile(r9, r10, r12, r8, r13)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            if (r14 == 0) goto L4e
            if (r0 == 0) goto Lba
            r14.callbackSuccessAsync(r0, r15)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            goto L4e
        L99:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse xml resource "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
        Lb2:
            if (r14 == 0) goto Lb8
            r0 = -3
            r14.callbackFailAsync(r0, r15)
        Lb8:
            r0 = 0
            goto L4e
        Lba:
            r1 = -3
            r14.callbackFailAsync(r1, r15)     // Catch: org.xmlpull.v1.XmlPullParserException -> L99 java.io.IOException -> Lbf
            goto L4e
        Lbf:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to read xml resource "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean):android.graphics.Typeface");
    }

    private ResourcesCompat() {
    }
}
