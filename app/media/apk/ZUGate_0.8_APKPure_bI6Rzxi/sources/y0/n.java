package y0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class n implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final Preference f5627g;

    public n(Preference preference) {
        this.f5627g = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.f5627g;
        CharSequence g5 = preference.g();
        if (!preference.D || TextUtils.isEmpty(g5)) {
            return;
        }
        contextMenu.setHeaderTitle(g5);
        contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.f5627g;
        CharSequence g5 = preference.g();
        ((ClipboardManager) preference.f1177b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", g5));
        Context context = preference.f1177b;
        Toast.makeText(context, context.getString(R.string.preference_copied, g5), 0).show();
        return true;
    }
}
