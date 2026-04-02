package y4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Iterator;
import ru.zdevs.zugate.MainActivity;
import t4.o;
/* loaded from: classes.dex */
public final class d implements Menu, View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public Context f5725g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f5726h = new ArrayList(3);

    /* renamed from: i  reason: collision with root package name */
    public a f5727i = null;

    /* renamed from: j  reason: collision with root package name */
    public c f5728j;

    /* renamed from: k  reason: collision with root package name */
    public Object f5729k;

    public d(MainActivity mainActivity) {
        this.f5725g = mainActivity;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        b bVar = new b(this, 0, charSequence);
        this.f5726h.add(bVar);
        return bVar;
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        return 0;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5) {
        return null;
    }

    @Override // android.view.Menu
    public final void clear() {
        this.f5726h.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        a aVar = this.f5727i;
        if (aVar != null) {
            aVar.dismiss();
            this.f5727i = null;
        }
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i5) {
        Iterator it = this.f5726h.iterator();
        while (it.hasNext()) {
            MenuItem menuItem = (MenuItem) it.next();
            if (menuItem.getItemId() == i5) {
                return menuItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i5) {
        if (i5 < 0 || i5 >= size()) {
            return null;
        }
        return (MenuItem) this.f5726h.get(i5);
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return true;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5;
        c cVar = this.f5728j;
        if (cVar != null) {
            Object obj = this.f5729k;
            MainActivity mainActivity = (MainActivity) cVar;
            int itemId = ((MenuItem) view.getTag()).getItemId();
            if (itemId == R.id.remove_device) {
                i5 = 100;
            } else if (itemId == R.id.technical_information) {
                i5 = 101;
            } else if (itemId == R.id.unmount) {
                i5 = 102;
            } else if (itemId == R.id.disconnect) {
                i5 = 103;
            } else if (itemId == R.id.connect_by_root) {
                i5 = 3;
            } else {
                if (itemId == R.id.mount_as_truecrypt) {
                    mainActivity.i(1, (t4.a) obj, 1536);
                }
                i5 = 0;
            }
            int i6 = i5;
            if (i6 != 0) {
                if (mainActivity.f4552g != null) {
                    new o(mainActivity.f4554i, mainActivity.f4552g, i6, (t4.a) obj, null, 0).b(mainActivity, mainActivity.f4555j);
                }
            } else if (itemId == R.id.remove_password) {
                b4.j.Q(((t4.a) obj).b());
            }
        }
        close();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i5, int i6) {
        return false;
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return false;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i5) {
    }

    @Override // android.view.Menu
    public final void removeItem(int i5) {
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i5, boolean z4, boolean z5) {
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i5, boolean z4) {
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i5, boolean z4) {
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5726h.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5) {
        return add(this.f5725g.getText(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        b bVar = new b(this, i6, charSequence);
        this.f5726h.add(bVar);
        return bVar;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, int i8) {
        return add(i5, i6, i7, this.f5725g.getText(i8));
    }
}
