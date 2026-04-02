package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* loaded from: classes.dex */
public class d0 extends d implements Menu {

    /* renamed from: j  reason: collision with root package name */
    public final c0.a f2963j;

    public d0(Context context, c0.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f2963j = aVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return m(((o) this.f2963j).a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = ((o) this.f2963j).addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr[i9] = m(menuItemArr2[i9]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return ((o) this.f2963j).addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        l.j jVar = (l.j) this.f2961h;
        if (jVar != null) {
            jVar.clear();
        }
        l.j jVar2 = (l.j) this.f2962i;
        if (jVar2 != null) {
            jVar2.clear();
        }
        ((o) this.f2963j).clear();
    }

    @Override // android.view.Menu
    public final void close() {
        ((o) this.f2963j).c(true);
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i5) {
        return m(((o) this.f2963j).findItem(i5));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i5) {
        return m(((o) this.f2963j).getItem(i5));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return ((o) this.f2963j).hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return ((o) this.f2963j).isShortcutKey(i5, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i5, int i6) {
        return ((o) this.f2963j).performIdentifierAction(i5, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return ((o) this.f2963j).performShortcut(i5, keyEvent, i6);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i5) {
        if (((l.j) this.f2961h) != null) {
            int i6 = 0;
            while (true) {
                l.j jVar = (l.j) this.f2961h;
                if (i6 >= jVar.f3705d) {
                    break;
                }
                if (((c0.b) jVar.h(i6)).getGroupId() == i5) {
                    ((l.j) this.f2961h).i(i6);
                    i6--;
                }
                i6++;
            }
        }
        ((o) this.f2963j).removeGroup(i5);
    }

    @Override // android.view.Menu
    public final void removeItem(int i5) {
        if (((l.j) this.f2961h) != null) {
            int i6 = 0;
            while (true) {
                l.j jVar = (l.j) this.f2961h;
                if (i6 >= jVar.f3705d) {
                    break;
                } else if (((c0.b) jVar.h(i6)).getItemId() == i5) {
                    ((l.j) this.f2961h).i(i6);
                    break;
                } else {
                    i6++;
                }
            }
        }
        ((o) this.f2963j).removeItem(i5);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i5, boolean z4, boolean z5) {
        ((o) this.f2963j).setGroupCheckable(i5, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i5, boolean z4) {
        ((o) this.f2963j).setGroupEnabled(i5, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i5, boolean z4) {
        ((o) this.f2963j).setGroupVisible(i5, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f2963j.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return ((o) this.f2963j).size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5) {
        return ((o) this.f2963j).addSubMenu(i5);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5) {
        return m(((o) this.f2963j).add(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return ((o) this.f2963j).addSubMenu(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return m(((o) this.f2963j).a(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return ((o) this.f2963j).addSubMenu(i5, i6, i7, i8);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, int i8) {
        return m(((o) this.f2963j).add(i5, i6, i7, i8));
    }
}
