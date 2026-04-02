package android.support.v4.os;

import android.os.Build;
import android.support.annotation.GuardedBy;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.Size;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.widget.ActivityChooserView;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
@RequiresApi(14)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
final class LocaleListHelper {
    private static final int NUM_PSEUDO_LOCALES = 2;
    private static final String STRING_AR_XB = "ar-XB";
    private static final String STRING_EN_XA = "en-XA";
    private final Locale[] mList;
    @NonNull
    private final String mStringRepresentation;
    private static final Locale[] sEmptyList = new Locale[0];
    private static final LocaleListHelper sEmptyLocaleList = new LocaleListHelper(new Locale[0]);
    private static final Locale LOCALE_EN_XA = new Locale("en", "XA");
    private static final Locale LOCALE_AR_XB = new Locale("ar", "XB");
    private static final Locale EN_LATN = LocaleHelper.forLanguageTag("en-Latn");
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static LocaleListHelper sLastExplicitlySetLocaleList = null;
    @GuardedBy("sLock")
    private static LocaleListHelper sDefaultLocaleList = null;
    @GuardedBy("sLock")
    private static LocaleListHelper sDefaultAdjustedLocaleList = null;
    @GuardedBy("sLock")
    private static Locale sLastDefaultLocale = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Locale get(int i) {
        if (i < 0 || i >= this.mList.length) {
            return null;
        }
        return this.mList[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmpty() {
        return this.mList.length == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int size() {
        return this.mList.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @IntRange(from = -1)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int indexOf(Locale locale) {
        for (int i = 0; i < this.mList.length; i++) {
            if (this.mList[i].equals(locale)) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LocaleListHelper) {
            Locale[] localeArr = ((LocaleListHelper) obj).mList;
            if (this.mList.length == localeArr.length) {
                for (int i = 0; i < this.mList.length; i++) {
                    if (!this.mList[i].equals(localeArr[i])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.mList.length; i2++) {
            i = (i * 31) + this.mList[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.mList.length; i++) {
            sb.append(this.mList[i]);
            if (i < this.mList.length - 1) {
                sb.append(',');
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LocaleListHelper(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < localeArr.length) {
                Locale locale = localeArr[i2];
                if (locale == null) {
                    throw new NullPointerException("list[" + i2 + "] is null");
                }
                if (hashSet.contains(locale)) {
                    throw new IllegalArgumentException("list[" + i2 + "] is a repetition");
                }
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i2] = locale2;
                sb.append(LocaleHelper.toLanguageTag(locale2));
                if (i2 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
                i = i2 + 1;
            } else {
                this.mList = localeArr2;
                this.mStringRepresentation = sb.toString();
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    LocaleListHelper(@NonNull Locale locale, LocaleListHelper localeListHelper) {
        int i;
        if (locale == null) {
            throw new NullPointerException("topLocale is null");
        }
        int length = localeListHelper == null ? 0 : localeListHelper.mList.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i = -1;
                break;
            } else if (locale.equals(localeListHelper.mList[i2])) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        int i3 = length + (i == -1 ? 1 : 0);
        Locale[] localeArr = new Locale[i3];
        localeArr[0] = (Locale) locale.clone();
        if (i == -1) {
            for (int i4 = 0; i4 < length; i4++) {
                localeArr[i4 + 1] = (Locale) localeListHelper.mList[i4].clone();
            }
        } else {
            for (int i5 = 0; i5 < i; i5++) {
                localeArr[i5 + 1] = (Locale) localeListHelper.mList[i5].clone();
            }
            for (int i6 = i + 1; i6 < length; i6++) {
                localeArr[i6] = (Locale) localeListHelper.mList[i6].clone();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < i3; i7++) {
            sb.append(LocaleHelper.toLanguageTag(localeArr[i7]));
            if (i7 < i3 - 1) {
                sb.append(',');
            }
        }
        this.mList = localeArr;
        this.mStringRepresentation = sb.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static LocaleListHelper getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static LocaleListHelper forLanguageTags(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",");
        Locale[] localeArr = new Locale[split.length];
        for (int i = 0; i < localeArr.length; i++) {
            localeArr[i] = LocaleHelper.forLanguageTag(split[i]);
        }
        return new LocaleListHelper(localeArr);
    }

    private static String getLikelyScript(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            String script = locale.getScript();
            if (script.isEmpty()) {
                return "";
            }
            return script;
        }
        return "";
    }

    private static boolean isPseudoLocale(String str) {
        return STRING_EN_XA.equals(str) || STRING_AR_XB.equals(str);
    }

    private static boolean isPseudoLocale(Locale locale) {
        return LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
    }

    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private static int matchScore(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        String likelyScript = getLikelyScript(locale);
        if (likelyScript.isEmpty()) {
            String country = locale.getCountry();
            return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
        }
        return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
    }

    private int findFirstMatchIndex(Locale locale) {
        for (int i = 0; i < this.mList.length; i++) {
            if (matchScore(locale, this.mList[i]) > 0) {
                return i;
            }
        }
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r0 < Integer.MAX_VALUE) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int computeFirstMatchIndex(java.util.Collection<java.lang.String> r6, boolean r7) {
        /*
            r5 = this;
            r1 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            java.util.Locale[] r0 = r5.mList
            int r0 = r0.length
            r2 = 1
            if (r0 != r2) goto Lc
            r2 = r3
        Lb:
            return r2
        Lc:
            java.util.Locale[] r0 = r5.mList
            int r0 = r0.length
            if (r0 != 0) goto L13
            r2 = -1
            goto Lb
        L13:
            if (r7 == 0) goto L48
            java.util.Locale r0 = android.support.v4.os.LocaleListHelper.EN_LATN
            int r0 = r5.findFirstMatchIndex(r0)
            if (r0 != 0) goto L1f
            r2 = r3
            goto Lb
        L1f:
            if (r0 >= r1) goto L48
        L21:
            java.util.Iterator r4 = r6.iterator()
            r2 = r0
        L26:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L42
            java.lang.Object r0 = r4.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.Locale r0 = android.support.v4.os.LocaleHelper.forLanguageTag(r0)
            int r0 = r5.findFirstMatchIndex(r0)
            if (r0 != 0) goto L3e
            r2 = r3
            goto Lb
        L3e:
            if (r0 >= r2) goto L46
        L40:
            r2 = r0
            goto L26
        L42:
            if (r2 != r1) goto Lb
            r2 = r3
            goto Lb
        L46:
            r0 = r2
            goto L40
        L48:
            r0 = r1
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.LocaleListHelper.computeFirstMatchIndex(java.util.Collection, boolean):int");
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z);
        if (computeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[computeFirstMatchIndex];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Locale getFirstMatch(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndex(String[] strArr) {
        return computeFirstMatchIndex(Arrays.asList(strArr), false);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Locale getFirstMatchWithEnglishSupported(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndexWithEnglishSupported(Collection<String> collection) {
        return computeFirstMatchIndex(collection, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getFirstMatchIndexWithEnglishSupported(String[] strArr) {
        return getFirstMatchIndexWithEnglishSupported(Arrays.asList(strArr));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static boolean isPseudoLocalesOnly(@Nullable String[] strArr) {
        if (strArr == null) {
            return true;
        }
        if (strArr.length > 3) {
            return false;
        }
        for (String str : strArr) {
            if (!str.isEmpty() && !isPseudoLocale(str)) {
                return false;
            }
        }
        return true;
    }

    @Size(min = 1)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static LocaleListHelper getDefault() {
        LocaleListHelper localeListHelper;
        Locale locale = Locale.getDefault();
        synchronized (sLock) {
            if (!locale.equals(sLastDefaultLocale)) {
                sLastDefaultLocale = locale;
                if (sDefaultLocaleList != null && locale.equals(sDefaultLocaleList.get(0))) {
                    localeListHelper = sDefaultLocaleList;
                } else {
                    sDefaultLocaleList = new LocaleListHelper(locale, sLastExplicitlySetLocaleList);
                    sDefaultAdjustedLocaleList = sDefaultLocaleList;
                }
            }
            localeListHelper = sDefaultLocaleList;
        }
        return localeListHelper;
    }

    @Size(min = 1)
    @NonNull
    static LocaleListHelper getAdjustedDefault() {
        LocaleListHelper localeListHelper;
        getDefault();
        synchronized (sLock) {
            localeListHelper = sDefaultAdjustedLocaleList;
        }
        return localeListHelper;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void setDefault(@Size(min = 1) @NonNull LocaleListHelper localeListHelper) {
        setDefault(localeListHelper, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void setDefault(@Size(min = 1) @NonNull LocaleListHelper localeListHelper, int i) {
        if (localeListHelper == null) {
            throw new NullPointerException("locales is null");
        }
        if (localeListHelper.isEmpty()) {
            throw new IllegalArgumentException("locales is empty");
        }
        synchronized (sLock) {
            sLastDefaultLocale = localeListHelper.get(i);
            Locale.setDefault(sLastDefaultLocale);
            sLastExplicitlySetLocaleList = localeListHelper;
            sDefaultLocaleList = localeListHelper;
            if (i == 0) {
                sDefaultAdjustedLocaleList = sDefaultLocaleList;
            } else {
                sDefaultAdjustedLocaleList = new LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
            }
        }
    }
}
