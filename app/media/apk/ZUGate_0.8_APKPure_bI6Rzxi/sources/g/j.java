package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.widget.v1;
import androidx.appcompat.widget.z2;
import h.r;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class j extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f2911e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f2912f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f2913a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f2914b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2915c;

    /* renamed from: d  reason: collision with root package name */
    public Object f2916d;

    static {
        Class[] clsArr = {Context.class};
        f2911e = clsArr;
        f2912f = clsArr;
    }

    public j(Context context) {
        super(context);
        this.f2915c = context;
        Object[] objArr = {context};
        this.f2913a = objArr;
        this.f2914b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        int i5;
        ColorStateList colorStateList;
        i iVar = new i(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            i5 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z4 = false;
        boolean z5 = false;
        String str = null;
        while (!z4) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            Menu menu2 = iVar.f2886a;
            z4 = z4;
            z4 = z4;
            if (eventType != i5) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z5 && name2.equals(str)) {
                        z5 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        iVar.f2887b = 0;
                        iVar.f2888c = 0;
                        iVar.f2889d = 0;
                        iVar.f2890e = 0;
                        iVar.f2891f = true;
                        iVar.f2892g = true;
                        z4 = z4;
                    } else if (name2.equals("item")) {
                        z4 = z4;
                        if (!iVar.f2893h) {
                            r rVar = iVar.f2910z;
                            if (rVar == null || !rVar.f3067b.hasSubMenu()) {
                                iVar.f2893h = true;
                                iVar.b(menu2.add(iVar.f2887b, iVar.f2894i, iVar.f2895j, iVar.f2896k));
                                z4 = z4;
                            } else {
                                iVar.f2893h = true;
                                iVar.b(menu2.addSubMenu(iVar.f2887b, iVar.f2894i, iVar.f2895j, iVar.f2896k).getItem());
                                z4 = z4;
                            }
                        }
                    } else {
                        z4 = z4;
                        if (name2.equals("menu")) {
                            z4 = true;
                        }
                    }
                }
            } else if (!z5) {
                String name3 = xmlResourceParser.getName();
                boolean equals = name3.equals("group");
                j jVar = iVar.E;
                if (equals) {
                    TypedArray obtainStyledAttributes = jVar.f2915c.obtainStyledAttributes(attributeSet, c.a.f1698p);
                    iVar.f2887b = obtainStyledAttributes.getResourceId(1, 0);
                    iVar.f2888c = obtainStyledAttributes.getInt(3, 0);
                    iVar.f2889d = obtainStyledAttributes.getInt(4, 0);
                    iVar.f2890e = obtainStyledAttributes.getInt(5, 0);
                    iVar.f2891f = obtainStyledAttributes.getBoolean(2, true);
                    iVar.f2892g = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                    z4 = z4;
                } else if (name3.equals("item")) {
                    Context context = jVar.f2915c;
                    z2 z2Var = new z2(context, context.obtainStyledAttributes(attributeSet, c.a.f1699q));
                    iVar.f2894i = z2Var.i(2, 0);
                    iVar.f2895j = (z2Var.h(5, iVar.f2888c) & (-65536)) | (z2Var.h(6, iVar.f2889d) & 65535);
                    iVar.f2896k = z2Var.k(7);
                    iVar.f2897l = z2Var.k(8);
                    iVar.f2898m = z2Var.i(0, 0);
                    String j5 = z2Var.j(9);
                    iVar.f2899n = j5 == null ? (char) 0 : j5.charAt(0);
                    iVar.o = z2Var.h(16, 4096);
                    String j6 = z2Var.j(10);
                    iVar.f2900p = j6 == null ? (char) 0 : j6.charAt(0);
                    iVar.f2901q = z2Var.h(20, 4096);
                    if (z2Var.l(11)) {
                        iVar.f2902r = z2Var.a(11, false) ? 1 : 0;
                    } else {
                        iVar.f2902r = iVar.f2890e;
                    }
                    iVar.f2903s = z2Var.a(3, false);
                    iVar.f2904t = z2Var.a(4, iVar.f2891f);
                    iVar.f2905u = z2Var.a(1, iVar.f2892g);
                    iVar.f2906v = z2Var.h(21, -1);
                    iVar.f2909y = z2Var.j(12);
                    iVar.f2907w = z2Var.i(13, 0);
                    iVar.f2908x = z2Var.j(15);
                    String j7 = z2Var.j(14);
                    boolean z6 = j7 != null;
                    if (z6 && iVar.f2907w == 0 && iVar.f2908x == null) {
                        iVar.f2910z = (r) iVar.a(j7, f2912f, jVar.f2914b);
                    } else {
                        if (z6) {
                            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                        }
                        iVar.f2910z = null;
                    }
                    iVar.A = z2Var.k(17);
                    iVar.B = z2Var.k(22);
                    if (z2Var.l(19)) {
                        iVar.D = v1.c(z2Var.h(19, -1), iVar.D);
                        colorStateList = null;
                    } else {
                        colorStateList = null;
                        iVar.D = null;
                    }
                    if (z2Var.l(18)) {
                        iVar.C = z2Var.b(18);
                    } else {
                        iVar.C = colorStateList;
                    }
                    z2Var.n();
                    iVar.f2893h = false;
                } else if (name3.equals("menu")) {
                    iVar.f2893h = true;
                    SubMenu addSubMenu = menu2.addSubMenu(iVar.f2887b, iVar.f2894i, iVar.f2895j, iVar.f2896k);
                    iVar.b(addSubMenu.getItem());
                    b(xmlResourceParser, attributeSet, addSubMenu);
                } else {
                    str = name3;
                    z5 = true;
                }
            }
            eventType = xmlResourceParser.next();
            i5 = 2;
            z4 = z4;
            z5 = z5;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i5, Menu menu) {
        if (!(menu instanceof c0.a)) {
            super.inflate(i5, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z4 = false;
        try {
            try {
                xmlResourceParser = this.f2915c.getResources().getLayout(i5);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof h.o) {
                    h.o oVar = (h.o) menu;
                    if (!oVar.f3039v) {
                        oVar.w();
                        z4 = true;
                    }
                }
                b(xmlResourceParser, asAttributeSet, menu);
                if (z4) {
                    ((h.o) menu).v();
                }
                xmlResourceParser.close();
            } catch (IOException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            } catch (XmlPullParserException e6) {
                throw new InflateException("Error inflating menu XML", e6);
            }
        } catch (Throwable th) {
            if (z4) {
                ((h.o) menu).v();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
