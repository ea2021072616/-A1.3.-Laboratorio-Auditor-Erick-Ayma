package y0;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f5653e = {Context.class, AttributeSet.class};

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f5654f = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f5655a;

    /* renamed from: c  reason: collision with root package name */
    public a0 f5657c;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f5656b = new Object[2];

    /* renamed from: d  reason: collision with root package name */
    public String[] f5658d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public w(Context context, a0 a0Var) {
        this.f5655a = context;
        this.f5657c = a0Var;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> cls;
        HashMap hashMap = f5654f;
        Constructor<?> constructor = (Constructor) hashMap.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f5655a.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        cls = null;
                        ClassNotFoundException e5 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e6) {
                                e5 = e6;
                            }
                        }
                        if (cls == null) {
                            if (e5 == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e5;
                        }
                        constructor = cls.getConstructor(f5653e);
                        constructor.setAccessible(true);
                        hashMap.put(str, constructor);
                    }
                    cls = Class.forName(str, false, classLoader);
                    constructor = cls.getConstructor(f5653e);
                    constructor.setAccessible(true);
                    hashMap.put(str, constructor);
                } catch (ClassNotFoundException e7) {
                    throw e7;
                }
            } catch (Exception e8) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e8);
                throw inflateException;
            }
        }
        Object[] objArr = this.f5656b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.f5658d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e5) {
            throw e5;
        } catch (ClassNotFoundException e6) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e6);
            throw inflateException;
        } catch (Exception e7) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e7);
            throw inflateException2;
        }
    }

    public final PreferenceGroup c(XmlResourceParser xmlResourceParser) {
        int next;
        PreferenceGroup preferenceGroup;
        synchronized (this.f5656b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
            this.f5656b[0] = this.f5655a;
            do {
                try {
                    try {
                        try {
                            next = xmlResourceParser.next();
                            if (next == 2) {
                                break;
                            }
                        } catch (InflateException e5) {
                            throw e5;
                        }
                    } catch (XmlPullParserException e6) {
                        InflateException inflateException = new InflateException(e6.getMessage());
                        inflateException.initCause(e6);
                        throw inflateException;
                    }
                } catch (IOException e7) {
                    InflateException inflateException2 = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e7.getMessage());
                    inflateException2.initCause(e7);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroup = (PreferenceGroup) b(xmlResourceParser.getName(), asAttributeSet);
            preferenceGroup.l(this.f5657c);
            d(xmlResourceParser, preferenceGroup, asAttributeSet);
        }
        return preferenceGroup;
    }

    public final void d(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) {
        long j5;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.f1189n = Intent.parseIntent(this.f5655a.getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e5) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e5);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.f5655a.getResources();
                    if (preference.f1190p == null) {
                        preference.f1190p = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, preference.f1190p);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 != 1 && (next2 != 3 || xmlResourceParser.getDepth() > depth2)) {
                            }
                        }
                    } catch (IOException e6) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e6);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference b5 = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.P.contains(b5)) {
                        if (b5.f1188m != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.J;
                                if (preferenceGroup3 == null) {
                                    break;
                                }
                                preferenceGroup2 = preferenceGroup3;
                            }
                            String str = b5.f1188m;
                            if (preferenceGroup2.A(str) != null) {
                                Log.e("PreferenceGroup", "Found duplicated key: \"" + str + "\". This can cause unintended behaviour, please use unique keys for every preference.");
                            }
                        }
                        int i5 = b5.f1183h;
                        if (i5 == Integer.MAX_VALUE) {
                            if (preferenceGroup.Q) {
                                int i6 = preferenceGroup.R;
                                preferenceGroup.R = i6 + 1;
                                if (i6 != i5) {
                                    b5.f1183h = i6;
                                    v vVar = b5.H;
                                    if (vVar != null) {
                                        Handler handler = vVar.f5652n;
                                        androidx.activity.j jVar = vVar.o;
                                        handler.removeCallbacks(jVar);
                                        handler.post(jVar);
                                    }
                                }
                            }
                            if (b5 instanceof PreferenceGroup) {
                                ((PreferenceGroup) b5).Q = preferenceGroup.Q;
                            }
                        }
                        int binarySearch = Collections.binarySearch(preferenceGroup.P, b5);
                        if (binarySearch < 0) {
                            binarySearch = (binarySearch * (-1)) - 1;
                        }
                        boolean y5 = preferenceGroup.y();
                        if (b5.f1197w == y5) {
                            b5.f1197w = !y5;
                            b5.j(b5.y());
                            b5.i();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.P.add(binarySearch, b5);
                        }
                        a0 a0Var = preferenceGroup.f1178c;
                        String str2 = b5.f1188m;
                        if (str2 == null || !preferenceGroup.O.containsKey(str2)) {
                            synchronized (a0Var) {
                                j5 = a0Var.f5585b;
                                a0Var.f5585b = 1 + j5;
                            }
                        } else {
                            j5 = ((Long) preferenceGroup.O.getOrDefault(str2, null)).longValue();
                            preferenceGroup.O.remove(str2);
                        }
                        b5.f1179d = j5;
                        b5.f1180e = true;
                        try {
                            b5.l(a0Var);
                            b5.f1180e = false;
                            if (b5.J != null) {
                                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                            }
                            b5.J = preferenceGroup;
                            if (preferenceGroup.S) {
                                b5.k();
                            }
                            v vVar2 = preferenceGroup.H;
                            if (vVar2 != null) {
                                Handler handler2 = vVar2.f5652n;
                                androidx.activity.j jVar2 = vVar2.o;
                                handler2.removeCallbacks(jVar2);
                                handler2.post(jVar2);
                            }
                        } catch (Throwable th) {
                            b5.f1180e = false;
                            throw th;
                        }
                    }
                    d(xmlResourceParser, b5, attributeSet);
                }
            }
        }
    }
}
