package g;

import android.content.Context;
import android.graphics.Typeface;
import android.security.identity.IdentityCredential;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.emoji2.text.a0;
import h.d0;
import h.v;
import java.security.Signature;
import java.util.ArrayList;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public Object f2877a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2878b;

    /* renamed from: c  reason: collision with root package name */
    public Object f2879c;

    /* renamed from: d  reason: collision with root package name */
    public Object f2880d;

    public f(int i5) {
        if (i5 == 3) {
            this.f2877a = new n.e(10, 1);
            this.f2880d = new l.j();
            this.f2879c = new ArrayList();
            this.f2878b = new HashSet();
        } else if (i5 == 6) {
            this.f2877a = new l.b();
            this.f2878b = new SparseArray();
            this.f2879c = new l.d();
            this.f2880d = new l.b();
        } else if (i5 != 7) {
            this.f2877a = new n.e(256, 0);
            this.f2878b = new n.e(256, 0);
            this.f2879c = new n.e(256, 0);
            this.f2880d = new n.i[32];
        } else {
            this.f2877a = null;
            this.f2878b = new ArrayList();
            this.f2879c = null;
            this.f2880d = "";
        }
    }

    @Override // g.a
    public final boolean a(b bVar, h.o oVar) {
        return ((ActionMode.Callback) this.f2877a).onPrepareActionMode(f(bVar), g(oVar));
    }

    @Override // g.a
    public final void b(b bVar) {
        ((ActionMode.Callback) this.f2877a).onDestroyActionMode(f(bVar));
    }

    @Override // g.a
    public final boolean c(b bVar, h.o oVar) {
        return ((ActionMode.Callback) this.f2877a).onCreateActionMode(f(bVar), g(oVar));
    }

    @Override // g.a
    public final boolean d(b bVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f2877a).onActionItemClicked(f(bVar), new v((Context) this.f2878b, (c0.b) menuItem));
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((l.j) this.f2880d).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                e(arrayList2.get(i5), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public final g f(b bVar) {
        int size = ((ArrayList) this.f2879c).size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = (g) ((ArrayList) this.f2879c).get(i5);
            if (gVar != null && gVar.f2882b == bVar) {
                return gVar;
            }
        }
        g gVar2 = new g((Context) this.f2878b, bVar);
        ((ArrayList) this.f2879c).add(gVar2);
        return gVar2;
    }

    public final Menu g(h.o oVar) {
        Menu menu = (Menu) ((l.j) this.f2880d).getOrDefault(oVar, null);
        if (menu == null) {
            d0 d0Var = new d0((Context) this.f2878b, oVar);
            ((l.j) this.f2880d).put(oVar, d0Var);
            return d0Var;
        }
        return menu;
    }

    public f(Typeface typeface, r0.b bVar) {
        int i5;
        int i6;
        this.f2880d = typeface;
        this.f2877a = bVar;
        this.f2879c = new a0(1024);
        r0.b bVar2 = (r0.b) this.f2877a;
        int a5 = bVar2.a(6);
        if (a5 != 0) {
            int i7 = a5 + bVar2.f4466a;
            i5 = bVar2.f4467b.getInt(bVar2.f4467b.getInt(i7) + i7);
        } else {
            i5 = 0;
        }
        this.f2878b = new char[i5 * 2];
        r0.b bVar3 = (r0.b) this.f2877a;
        int a6 = bVar3.a(6);
        if (a6 != 0) {
            int i8 = a6 + bVar3.f4466a;
            i6 = bVar3.f4467b.getInt(bVar3.f4467b.getInt(i8) + i8);
        } else {
            i6 = 0;
        }
        for (int i9 = 0; i9 < i6; i9++) {
            androidx.emoji2.text.d0 d0Var = new androidx.emoji2.text.d0(this, i9);
            r0.a c5 = d0Var.c();
            int a7 = c5.a(4);
            Character.toChars(a7 != 0 ? c5.f4467b.getInt(a7 + c5.f4466a) : 0, (char[]) this.f2878b, i9 * 2);
            p2.a.h("invalid metadata codepoint length", d0Var.b() > 0);
            ((a0) this.f2879c).a(d0Var, 0, d0Var.b() - 1);
        }
    }

    public f(Context context, ActionMode.Callback callback) {
        this.f2878b = context;
        this.f2877a = callback;
        this.f2879c = new ArrayList();
        this.f2880d = new l.j();
    }

    public f(Signature signature) {
        this.f2877a = signature;
        this.f2878b = null;
        this.f2879c = null;
        this.f2880d = null;
    }

    public f(Cipher cipher) {
        this.f2877a = null;
        this.f2878b = cipher;
        this.f2879c = null;
        this.f2880d = null;
    }

    public f(Mac mac) {
        this.f2877a = null;
        this.f2878b = null;
        this.f2879c = mac;
        this.f2880d = null;
    }

    public f(IdentityCredential identityCredential) {
        this.f2877a = null;
        this.f2878b = null;
        this.f2879c = null;
        this.f2880d = identityCredential;
    }
}
