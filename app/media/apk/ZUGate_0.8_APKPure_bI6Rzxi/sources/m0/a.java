package m0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.hardware.biometrics.BiometricPrompt;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.security.identity.IdentityCredential;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.s;
import androidx.biometric.a0;
import androidx.biometric.z;
import com.github.appintro.R;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p.e;
import p.i;
import p.k;
import q.n;
import y.d;
import y.f;
import y.g;
import y.h;
/* loaded from: classes.dex */
public abstract class a {
    public static int a(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean c(File file, Resources resources, int i5) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i5);
            try {
                boolean d5 = d(file, inputStream);
                b(inputStream);
                return d5;
            } catch (Throwable th) {
                th = th;
                b(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static boolean d(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
            fileOutputStream = fileOutputStream2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    b(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            b(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            b(fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static n e(e eVar, int i5, ArrayList arrayList, n nVar) {
        boolean z4;
        int i6;
        int i7 = i5 == 0 ? eVar.f4185n0 : eVar.f4186o0;
        if (i7 != -1 && (nVar == null || i7 != nVar.f4413b)) {
            int i8 = 0;
            while (true) {
                if (i8 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i8);
                if (nVar2.f4413b == i7) {
                    if (nVar != null) {
                        nVar.c(i5, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i8++;
                }
            }
        } else if (i7 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (eVar instanceof k) {
                k kVar = (k) eVar;
                int i9 = 0;
                while (true) {
                    if (i9 >= kVar.f4242r0) {
                        i6 = -1;
                        break;
                    }
                    e eVar2 = kVar.f4241q0[i9];
                    if ((i5 == 0 && (i6 = eVar2.f4185n0) != -1) || (i5 == 1 && (i6 = eVar2.f4186o0) != -1)) {
                        break;
                    }
                    i9++;
                }
                if (i6 != -1) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = (n) arrayList.get(i10);
                        if (nVar3.f4413b == i6) {
                            nVar = nVar3;
                            break;
                        }
                        i10++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n(i5);
            }
            arrayList.add(nVar);
        }
        ArrayList arrayList2 = nVar.f4412a;
        if (arrayList2.contains(eVar)) {
            z4 = false;
        } else {
            arrayList2.add(eVar);
            z4 = true;
        }
        if (z4) {
            if (eVar instanceof i) {
                i iVar = (i) eVar;
                iVar.f4238t0.c(iVar.f4239u0 == 0 ? 1 : 0, nVar, arrayList);
            }
            int i11 = nVar.f4413b;
            if (i5 == 0) {
                eVar.f4185n0 = i11;
                eVar.I.c(i5, nVar, arrayList);
                eVar.K.c(i5, nVar, arrayList);
            } else {
                eVar.f4186o0 = i11;
                eVar.J.c(i5, nVar, arrayList);
                eVar.M.c(i5, nVar, arrayList);
                eVar.L.c(i5, nVar, arrayList);
            }
            eVar.P.c(i5, nVar, arrayList);
        }
        return nVar;
    }

    public static int f(Context context, int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId != 0 ? i5 : i6;
    }

    public static String g(Context context, int i5) {
        if (context == null) {
            return "";
        }
        if (i5 != 1) {
            if (i5 != 7) {
                switch (i5) {
                    case 9:
                        break;
                    case 10:
                        return context.getString(R.string.fingerprint_error_user_canceled);
                    case 11:
                        return context.getString(R.string.fingerprint_error_no_fingerprints);
                    case 12:
                        return context.getString(R.string.fingerprint_error_hw_not_present);
                    default:
                        Log.e("BiometricUtils", "Unknown error code: " + i5);
                        return context.getString(R.string.default_error_msg);
                }
            }
            return context.getString(R.string.fingerprint_error_lockout);
        }
        return context.getString(R.string.fingerprint_error_hw_not_available);
    }

    public static y.c h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5) {
        y.c cVar;
        if (p(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i6 = typedValue.type;
            if (i6 >= 28 && i6 <= 31) {
                return new y.c(null, null, typedValue.data);
            }
            try {
                cVar = y.c.a(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            } catch (Exception e5) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e5);
                cVar = null;
            }
            if (cVar != null) {
                return cVar;
            }
        }
        return new y.c(null, null, 0);
    }

    public static float i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, float f5) {
        return !p(xmlPullParser, str) ? f5 : typedArray.getFloat(i5, f5);
    }

    public static int j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !p(xmlPullParser, str) ? i6 : typedArray.getInt(i5, i6);
    }

    public static Intent k(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String m5 = m(activity, activity.getComponentName());
            if (m5 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, m5);
            try {
                return m(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + m5 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static Intent l(Context context, ComponentName componentName) {
        String m5 = m(context, componentName);
        if (m5 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), m5);
        return m(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String m(Context context, ComponentName componentName) {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static String n(TypedArray typedArray, int i5, int i6) {
        String string = typedArray.getString(i5);
        return string == null ? typedArray.getString(i6) : string;
    }

    public static File o(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i5 = 0; i5 < 100; i5++) {
            File file = new File(cacheDir, str + i5);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static boolean p(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static boolean q(int i5) {
        return (i5 & 32768) != 0;
    }

    public static boolean r(int i5) {
        if (i5 == 15 || i5 == 255) {
            return true;
        }
        if (i5 == 32768) {
            return Build.VERSION.SDK_INT >= 30;
        } else if (i5 != 32783) {
            return i5 == 33023 || i5 == 0;
        } else {
            int i6 = Build.VERSION.SDK_INT;
            return i6 < 28 || i6 > 29;
        }
    }

    public static MappedByteBuffer s(Context context, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static TypedArray t(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static y.e u(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlResourceParser.require(2, null, "font-family");
            if (xmlResourceParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), v.a.f5177b);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(4);
                String string3 = obtainAttributes.getString(5);
                int resourceId = obtainAttributes.getResourceId(1, 0);
                int integer = obtainAttributes.getInteger(2, 1);
                int integer2 = obtainAttributes.getInteger(3, 500);
                String string4 = obtainAttributes.getString(6);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlResourceParser.next() != 3) {
                        x(xmlResourceParser);
                    }
                    return new h(new s(string, string2, string3, v(resourceId, resources)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlResourceParser.next() != 3) {
                    if (xmlResourceParser.getEventType() == 2) {
                        if (xmlResourceParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), v.a.f5178c);
                            int i5 = obtainAttributes2.getInt(obtainAttributes2.hasValue(8) ? 8 : 1, 400);
                            boolean z4 = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(6) ? 6 : 2, 0);
                            int i6 = obtainAttributes2.hasValue(9) ? 9 : 3;
                            String string5 = obtainAttributes2.getString(obtainAttributes2.hasValue(7) ? 7 : 4);
                            int i7 = obtainAttributes2.getInt(i6, 0);
                            int i8 = obtainAttributes2.hasValue(5) ? 5 : 0;
                            int resourceId2 = obtainAttributes2.getResourceId(i8, 0);
                            String string6 = obtainAttributes2.getString(i8);
                            obtainAttributes2.recycle();
                            while (xmlResourceParser.next() != 3) {
                                x(xmlResourceParser);
                            }
                            arrayList.add(new g(i5, i7, resourceId2, string6, string5, z4));
                        } else {
                            x(xmlResourceParser);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new f((g[]) arrayList.toArray(new g[0]));
                }
            } else {
                x(xmlResourceParser);
            }
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List v(int i5, Resources resources) {
        if (i5 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i5);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (d.a(obtainTypedArray, 0) == 1) {
                for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                    int resourceId = obtainTypedArray.getResourceId(i6, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i5);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void w(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }

    public static void x(XmlResourceParser xmlResourceParser) {
        int i5 = 1;
        while (i5 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i5++;
            } else if (next == 3) {
                i5--;
            }
        }
    }

    public static boolean y(int i5, int i6, int i7, int i8) {
        return (i7 == 1 || i7 == 2 || (i7 == 4 && i5 != 2)) || (i8 == 1 || i8 == 2 || (i8 == 4 && i6 != 2));
    }

    public static BiometricPrompt.CryptoObject z(g.f fVar) {
        IdentityCredential identityCredential;
        if (fVar == null) {
            return null;
        }
        Cipher cipher = (Cipher) fVar.f2878b;
        if (cipher != null) {
            return z.b(cipher);
        }
        Signature signature = (Signature) fVar.f2877a;
        if (signature != null) {
            return z.a(signature);
        }
        Mac mac = (Mac) fVar.f2879c;
        if (mac != null) {
            return z.c(mac);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredential = (IdentityCredential) fVar.f2880d) == null) {
            return null;
        }
        return a0.a(identityCredential);
    }
}
