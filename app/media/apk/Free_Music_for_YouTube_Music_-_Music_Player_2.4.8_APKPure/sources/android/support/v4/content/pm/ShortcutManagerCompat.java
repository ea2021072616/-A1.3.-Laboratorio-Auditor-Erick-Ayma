package android.support.v4.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
/* loaded from: classes.dex */
public class ShortcutManagerCompat {
    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";

    private ShortcutManagerCompat() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isRequestPinShortcutSupported(@android.support.annotation.NonNull android.content.Context r4) {
        /*
            r1 = 0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 < r2) goto L14
            java.lang.Class<android.content.pm.ShortcutManager> r0 = android.content.pm.ShortcutManager.class
            java.lang.Object r0 = r4.getSystemService(r0)
            android.content.pm.ShortcutManager r0 = (android.content.pm.ShortcutManager) r0
            boolean r0 = r0.isRequestPinShortcutSupported()
        L13:
            return r0
        L14:
            java.lang.String r0 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            int r0 = android.support.v4.content.ContextCompat.checkSelfPermission(r4, r0)
            if (r0 == 0) goto L1e
            r0 = r1
            goto L13
        L1e:
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "com.android.launcher.action.INSTALL_SHORTCUT"
            r2.<init>(r3)
            java.util.List r0 = r0.queryBroadcastReceivers(r2, r1)
            java.util.Iterator r2 = r0.iterator()
        L31:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r2.next()
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            java.lang.String r0 = r0.permission
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L4f
            java.lang.String r3 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L31
        L4f:
            r0 = 1
            goto L13
        L51:
            r0 = r1
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.pm.ShortcutManagerCompat.isRequestPinShortcutSupported(android.content.Context):boolean");
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable final IntentSender intentSender) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent addToIntent = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast(addToIntent);
            return true;
        }
        context.sendOrderedBroadcast(addToIntent, null, new BroadcastReceiver() { // from class: android.support.v4.content.pm.ShortcutManagerCompat.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    intentSender.sendIntent(context2, 0, null, null, null);
                } catch (IntentSender.SendIntentException e) {
                }
            }
        }, null, -1, null, null);
        return true;
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent = null;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        }
        if (intent == null) {
            intent = new Intent();
        }
        return shortcutInfoCompat.addToIntent(intent);
    }
}
