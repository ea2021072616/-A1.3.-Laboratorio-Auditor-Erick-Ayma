package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import h0.b1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class o implements c0.a {
    public static final int[] E = {1, 4, 5, 3, 2, 0};
    public q B;
    public boolean D;

    /* renamed from: g  reason: collision with root package name */
    public final Context f3025g;

    /* renamed from: h  reason: collision with root package name */
    public final Resources f3026h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3027i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3028j;

    /* renamed from: k  reason: collision with root package name */
    public m f3029k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f3030l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f3031m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3032n;
    public final ArrayList o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f3033p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3034q;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f3036s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f3037t;

    /* renamed from: u  reason: collision with root package name */
    public View f3038u;

    /* renamed from: r  reason: collision with root package name */
    public int f3035r = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3039v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3040w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3041x = false;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3042y = false;

    /* renamed from: z  reason: collision with root package name */
    public final ArrayList f3043z = new ArrayList();
    public final CopyOnWriteArrayList A = new CopyOnWriteArrayList();
    public boolean C = false;

    public o(Context context) {
        boolean z4;
        boolean z5 = false;
        this.f3025g = context;
        Resources resources = context.getResources();
        this.f3026h = resources;
        this.f3030l = new ArrayList();
        this.f3031m = new ArrayList();
        this.f3032n = true;
        this.o = new ArrayList();
        this.f3033p = new ArrayList();
        this.f3034q = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            if (Build.VERSION.SDK_INT >= 28) {
                z4 = b1.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z4 = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z4) {
                z5 = true;
            }
        }
        this.f3028j = z5;
    }

    public final q a(int i5, int i6, int i7, CharSequence charSequence) {
        int i8;
        int i9 = ((-65536) & i7) >> 16;
        if (i9 < 0 || i9 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i10 = (E[i9] << 16) | (65535 & i7);
        q qVar = new q(this, i5, i6, i7, i10, charSequence, this.f3035r);
        ArrayList arrayList = this.f3030l;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                i8 = 0;
                break;
            } else if (((q) arrayList.get(size)).f3050j <= i10) {
                i8 = size + 1;
                break;
            }
        }
        arrayList.add(i8, qVar);
        p(true);
        return qVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f3025g.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i8 & 1) == 0) {
            removeGroup(i5);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i11 < 0 ? intent : intentArr[i11]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            q a5 = a(i5, i6, i7, resolveInfo.loadLabel(packageManager));
            a5.setIcon(resolveInfo.loadIcon(packageManager));
            a5.f3053m = intent2;
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = a5;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(a0 a0Var, Context context) {
        this.A.add(new WeakReference(a0Var));
        a0Var.d(context, this);
        this.f3034q = true;
    }

    public final void c(boolean z4) {
        if (this.f3042y) {
            return;
        }
        this.f3042y = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.A;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a0 a0Var = (a0) weakReference.get();
            if (a0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                a0Var.b(this, z4);
            }
        }
        this.f3042y = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        q qVar = this.B;
        if (qVar != null) {
            d(qVar);
        }
        this.f3030l.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f3037t = null;
        this.f3036s = null;
        this.f3038u = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.A;
        boolean z4 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.B == qVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                a0 a0Var = (a0) weakReference.get();
                if (a0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z4 = a0Var.i(qVar);
                    if (z4) {
                        break;
                    }
                }
            }
            v();
            if (z4) {
                this.B = null;
            }
        }
        return z4;
    }

    public boolean e(o oVar, MenuItem menuItem) {
        m mVar = this.f3029k;
        return mVar != null && mVar.d(oVar, menuItem);
    }

    public boolean f(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.A;
        boolean z4 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a0 a0Var = (a0) weakReference.get();
            if (a0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z4 = a0Var.g(qVar);
                if (z4) {
                    break;
                }
            }
        }
        v();
        if (z4) {
            this.B = qVar;
        }
        return z4;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i5) {
        MenuItem findItem;
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) this.f3030l.get(i6);
            if (qVar.f3047g == i5) {
                return qVar;
            }
            if (qVar.hasSubMenu() && (findItem = qVar.f3060u.findItem(i5)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final q g(int i5, KeyEvent keyEvent) {
        ArrayList arrayList = this.f3043z;
        arrayList.clear();
        h(arrayList, i5, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (q) arrayList.get(0);
        }
        boolean n5 = n();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            char c5 = n5 ? qVar.f3055p : qVar.f3054n;
            char[] cArr = keyData.meta;
            if ((c5 == cArr[0] && (metaState & 2) == 0) || ((c5 == cArr[2] && (metaState & 2) != 0) || (n5 && c5 == '\b' && i5 == 67))) {
                return qVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i5) {
        return (MenuItem) this.f3030l.get(i5);
    }

    public final void h(ArrayList arrayList, int i5, KeyEvent keyEvent) {
        int i6;
        boolean n5 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i5 == 67) {
            ArrayList arrayList2 = this.f3030l;
            int size = arrayList2.size();
            for (i6 = 0; i6 < size; i6 = i6 + 1) {
                q qVar = (q) arrayList2.get(i6);
                if (qVar.hasSubMenu()) {
                    qVar.f3060u.h(arrayList, i5, keyEvent);
                }
                char c5 = n5 ? qVar.f3055p : qVar.f3054n;
                if (((modifiers & 69647) == ((n5 ? qVar.f3056q : qVar.o) & 69647)) && c5 != 0) {
                    char[] cArr = keyData.meta;
                    if (c5 != cArr[0] && c5 != cArr[2]) {
                        if (n5 && c5 == '\b') {
                            i6 = i5 != 67 ? i6 + 1 : 0;
                        }
                    }
                    if (qVar.isEnabled()) {
                        arrayList.add(qVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.D) {
            return true;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (((q) this.f3030l.get(i5)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList l5 = l();
        if (this.f3034q) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.A;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                a0 a0Var = (a0) weakReference.get();
                if (a0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z4 |= a0Var.e();
                }
            }
            ArrayList arrayList = this.o;
            ArrayList arrayList2 = this.f3033p;
            if (z4) {
                arrayList.clear();
                arrayList2.clear();
                int size = l5.size();
                for (int i5 = 0; i5 < size; i5++) {
                    q qVar = (q) l5.get(i5);
                    if (qVar.f()) {
                        arrayList.add(qVar);
                    } else {
                        arrayList2.add(qVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f3034q = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return g(i5, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public o k() {
        return this;
    }

    public final ArrayList l() {
        boolean z4 = this.f3032n;
        ArrayList arrayList = this.f3031m;
        if (z4) {
            arrayList.clear();
            ArrayList arrayList2 = this.f3030l;
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                q qVar = (q) arrayList2.get(i5);
                if (qVar.isVisible()) {
                    arrayList.add(qVar);
                }
            }
            this.f3032n = false;
            this.f3034q = true;
            return arrayList;
        }
        return arrayList;
    }

    public boolean m() {
        return this.C;
    }

    public boolean n() {
        return this.f3027i;
    }

    public boolean o() {
        return this.f3028j;
    }

    public final void p(boolean z4) {
        if (this.f3039v) {
            this.f3040w = true;
            if (z4) {
                this.f3041x = true;
                return;
            }
            return;
        }
        if (z4) {
            this.f3032n = true;
            this.f3034q = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.A;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a0 a0Var = (a0) weakReference.get();
            if (a0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                a0Var.h();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i5, int i6) {
        return q(findItem(i5), null, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        q g5 = g(i5, keyEvent);
        boolean q5 = g5 != null ? q(g5, null, i6) : false;
        if ((i6 & 2) != 0) {
            c(true);
        }
        return q5;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, h.a0 r8, int r9) {
        /*
            r6 = this;
            h.q r7 = (h.q) r7
            r0 = 0
            if (r7 == 0) goto Ld7
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld7
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f3061v
            r2 = 1
            if (r1 == 0) goto L19
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L19
            goto L40
        L19:
            h.o r1 = r7.f3059t
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L22
            goto L40
        L22:
            android.content.Intent r3 = r7.f3053m
            if (r3 == 0) goto L34
            android.content.Context r1 = r1.f3025g     // Catch: android.content.ActivityNotFoundException -> L2c
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2c
            goto L40
        L2c:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L34:
            h.r r1 = r7.G
            if (r1 == 0) goto L42
            android.view.ActionProvider r1 = r1.f3067b
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L42
        L40:
            r1 = r2
            goto L43
        L42:
            r1 = r0
        L43:
            h.r r3 = r7.G
            if (r3 == 0) goto L51
            android.view.ActionProvider r4 = r3.f3067b
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L51
            r4 = r2
            goto L52
        L51:
            r4 = r0
        L52:
            boolean r5 = r7.e()
            if (r5 == 0) goto L64
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld6
            r6.c(r2)
            goto Ld6
        L64:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L75
            if (r4 == 0) goto L6d
            goto L75
        L6d:
            r7 = r9 & 1
            if (r7 != 0) goto Ld6
            r6.c(r2)
            goto Ld6
        L75:
            r9 = r9 & 4
            if (r9 != 0) goto L7c
            r6.c(r0)
        L7c:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L90
            h.g0 r9 = new h.g0
            android.content.Context r5 = r6.f3025g
            r9.<init>(r5, r6, r7)
            r7.f3060u = r9
            java.lang.CharSequence r5 = r7.f3051k
            r9.setHeaderTitle(r5)
        L90:
            h.g0 r7 = r7.f3060u
            if (r4 == 0) goto L9e
            h.v r9 = r3.f3068c
            r9.getClass()
            android.view.ActionProvider r9 = r3.f3067b
            r9.onPrepareSubMenu(r7)
        L9e:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.A
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto La7
            goto Ld0
        La7:
            if (r8 == 0) goto Lad
            boolean r0 = r8.k(r7)
        Lad:
            java.util.Iterator r8 = r9.iterator()
        Lb1:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Ld0
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            h.a0 r4 = (h.a0) r4
            if (r4 != 0) goto Lc9
            r9.remove(r3)
            goto Lb1
        Lc9:
            if (r0 != 0) goto Lb1
            boolean r0 = r4.k(r7)
            goto Lb1
        Ld0:
            r1 = r1 | r0
            if (r1 != 0) goto Ld6
            r6.c(r2)
        Ld6:
            return r1
        Ld7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.o.q(android.view.MenuItem, h.a0, int):boolean");
    }

    public final void r(a0 a0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.A;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            a0 a0Var2 = (a0) weakReference.get();
            if (a0Var2 == null || a0Var2 == a0Var) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i5) {
        ArrayList arrayList;
        int size = size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            arrayList = this.f3030l;
            if (i7 >= size) {
                i7 = -1;
                break;
            } else if (((q) arrayList.get(i7)).f3048h == i5) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 >= 0) {
            int size2 = arrayList.size() - i7;
            while (true) {
                int i8 = i6 + 1;
                if (i6 >= size2 || ((q) arrayList.get(i7)).f3048h != i5) {
                    break;
                }
                if (i7 >= 0 && i7 < arrayList.size()) {
                    arrayList.remove(i7);
                }
                i6 = i8;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i5) {
        ArrayList arrayList;
        int size = size();
        int i6 = 0;
        while (true) {
            arrayList = this.f3030l;
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((q) arrayList.get(i6)).f3047g == i5) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 < 0 || i6 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i6);
        p(true);
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((g0) item.getSubMenu()).s(bundle);
            }
        }
        int i6 = bundle.getInt("android:menu:expandedactionview");
        if (i6 <= 0 || (findItem = findItem(i6)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i5, boolean z4, boolean z5) {
        ArrayList arrayList = this.f3030l;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f3048h == i5) {
                qVar.D = (qVar.D & (-5)) | (z5 ? 4 : 0);
                qVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.C = z4;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i5, boolean z4) {
        ArrayList arrayList = this.f3030l;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f3048h == i5) {
                qVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i5, boolean z4) {
        ArrayList arrayList = this.f3030l;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f3048h == i5) {
                int i7 = qVar.D;
                int i8 = (i7 & (-9)) | (z4 ? 0 : 8);
                qVar.D = i8;
                if (i7 != i8) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f3027i = z4;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f3030l.size();
    }

    public final void t(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((g0) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        if (view != null) {
            this.f3038u = view;
            this.f3036s = null;
            this.f3037t = null;
        } else {
            if (i5 > 0) {
                this.f3036s = this.f3026h.getText(i5);
            } else if (charSequence != null) {
                this.f3036s = charSequence;
            }
            if (i6 > 0) {
                this.f3037t = x.a.b(this.f3025g, i6);
            } else if (drawable != null) {
                this.f3037t = drawable;
            }
            this.f3038u = null;
        }
        p(false);
    }

    public final void v() {
        this.f3039v = false;
        if (this.f3040w) {
            this.f3040w = false;
            p(this.f3041x);
        }
    }

    public final void w() {
        if (this.f3039v) {
            return;
        }
        this.f3039v = true;
        this.f3040w = false;
        this.f3041x = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5) {
        return a(0, 0, 0, this.f3026h.getString(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, this.f3026h.getString(i5));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return a(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        q a5 = a(i5, i6, i7, charSequence);
        g0 g0Var = new g0(this.f3025g, this, a5);
        a5.f3060u = g0Var;
        g0Var.setHeaderTitle(a5.f3051k);
        return g0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, int i8) {
        return a(i5, i6, i7, this.f3026h.getString(i8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, this.f3026h.getString(i8));
    }
}
