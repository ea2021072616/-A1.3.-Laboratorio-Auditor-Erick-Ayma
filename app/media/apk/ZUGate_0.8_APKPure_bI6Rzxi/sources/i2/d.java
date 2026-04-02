package i2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.d0;
import androidx.fragment.app.w0;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayList;
import java.util.Iterator;
import w.a0;
import w.b0;
import w.q;
import w.r;
import w.s;
import w.t;
import w.u;
import w.v;
import w.w;
import w.x;
import w.y;
import w.z;
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f3390b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final d f3391c = new d();

    public static AlertDialog e(Context context, int i5, l2.p pVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i5 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(l2.m.b(context, i5));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = context.getResources();
        String string = i5 != 1 ? i5 != 2 ? i5 != 3 ? resources.getString(17039370) : resources.getString(R.string.common_google_play_services_enable_button) : resources.getString(R.string.common_google_play_services_update_button) : resources.getString(R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, pVar);
        }
        String c5 = l2.m.c(context, i5);
        if (c5 != null) {
            builder.setTitle(c5);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i5)), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof d0) {
                w0 supportFragmentManager = ((d0) activity).getSupportFragmentManager();
                i iVar = new i();
                if (alertDialog == null) {
                    throw new NullPointerException("Cannot display null dialog");
                }
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                iVar.f3398w = alertDialog;
                if (onCancelListener != null) {
                    iVar.f3399x = onCancelListener;
                }
                iVar.j(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        if (alertDialog == null) {
            throw new NullPointerException("Cannot display null dialog");
        }
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        bVar.f3384g = alertDialog;
        if (onCancelListener != null) {
            bVar.f3385h = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    @Override // i2.e
    public final Intent a(int i5, Context context, String str) {
        return super.a(i5, context, str);
    }

    @Override // i2.e
    public final int b(Context context, int i5) {
        return super.b(context, i5);
    }

    public final int c(Context context) {
        return super.b(context, e.f3392a);
    }

    public final void d(Activity activity, int i5, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog e5 = e(activity, i5, new l2.n(activity, super.a(i5, activity, "d")), onCancelListener);
        if (e5 == null) {
            return;
        }
        f(activity, e5, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(Context context, int i5, PendingIntent pendingIntent) {
        NotificationManager notificationManager;
        int i6;
        Bundle bundle;
        NotificationManager notificationManager2;
        int i7;
        int i8;
        ArrayList arrayList;
        int i9;
        Context context2 = null;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i5), null), new IllegalArgumentException());
        if (i5 == 18) {
            new j(this, context).sendEmptyMessageDelayed(1, 120000L);
        } else if (pendingIntent == null) {
            if (i5 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String e5 = i5 == 6 ? l2.m.e(context, "common_google_play_services_resolution_required_title") : l2.m.c(context, i5);
            if (e5 == null) {
                e5 = context.getResources().getString(R.string.common_google_play_services_notification_ticker);
            }
            String d5 = (i5 == 6 || i5 == 19) ? l2.m.d(context, "common_google_play_services_resolution_required_text", l2.m.a(context)) : l2.m.b(context, i5);
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            i0.j(systemService);
            NotificationManager notificationManager3 = (NotificationManager) systemService;
            s sVar = new s(context);
            sVar.f5286k = true;
            sVar.o.flags |= 16;
            sVar.f5280e = s.a(e5);
            r rVar = new r();
            rVar.f5275b = s.a(d5);
            sVar.b(rVar);
            PackageManager packageManager = context.getPackageManager();
            if (b4.j.f1678r == null) {
                b4.j.f1678r = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            }
            if (b4.j.f1678r.booleanValue()) {
                sVar.o.icon = context.getApplicationInfo().icon;
                sVar.f5283h = 2;
                if (b4.j.C(context)) {
                    sVar.f5277b.add(new q(resources.getString(R.string.common_open_on_phone), pendingIntent));
                } else {
                    sVar.f5282g = pendingIntent;
                }
            } else {
                sVar.o.icon = 17301642;
                sVar.o.tickerText = s.a(resources.getString(R.string.common_google_play_services_notification_ticker));
                sVar.o.when = System.currentTimeMillis();
                sVar.f5282g = pendingIntent;
                sVar.f5281f = s.a(d5);
            }
            synchronized (f3390b) {
            }
            NotificationChannel notificationChannel = notificationManager3.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager3.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager3.createNotificationChannel(notificationChannel);
            }
            sVar.f5288m = "com.google.android.gms.availability";
            new ArrayList();
            Bundle bundle2 = new Bundle();
            Notification.Builder a5 = y.a(sVar.f5276a, sVar.f5288m);
            Notification notification = sVar.o;
            a5.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(sVar.f5280e).setContentText(sVar.f5281f).setContentInfo(null).setContentIntent(sVar.f5282g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
            w.b(a5, null);
            a5.setSubText(null).setUsesChronometer(false).setPriority(sVar.f5283h);
            Iterator it = sVar.f5277b.iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                if (qVar.f5269b == null && (i9 = qVar.f5272e) != 0) {
                    qVar.f5269b = IconCompat.a(i9);
                }
                IconCompat iconCompat = qVar.f5269b;
                Notification.Action.Builder a6 = w.a(iconCompat != null ? a0.c.c(iconCompat, context2) : context2, qVar.f5273f, qVar.f5274g);
                Bundle bundle3 = qVar.f5268a;
                Bundle bundle4 = bundle3 != null ? new Bundle(bundle3) : new Bundle();
                boolean z4 = qVar.f5270c;
                bundle4.putBoolean("android.support.allowGeneratedReplies", z4);
                int i10 = Build.VERSION.SDK_INT;
                x.a(a6, z4);
                bundle4.putInt("android.support.action.semanticAction", 0);
                if (i10 >= 28) {
                    z.b(a6, 0);
                }
                if (i10 >= 29) {
                    a0.c(a6, false);
                }
                if (i10 >= 31) {
                    b0.a(a6, false);
                }
                bundle4.putBoolean("android.support.action.showsUserInterface", qVar.f5271d);
                u.b(a6, bundle4);
                u.a(a5, u.d(a6));
                context2 = null;
            }
            Bundle bundle5 = sVar.f5287l;
            if (bundle5 != null) {
                bundle2.putAll(bundle5);
            }
            int i11 = Build.VERSION.SDK_INT;
            a5.setShowWhen(sVar.f5284i);
            u.i(a5, sVar.f5286k);
            u.g(a5, null);
            u.j(a5, null);
            u.h(a5, false);
            v.b(a5, null);
            v.c(a5, 0);
            v.f(a5, 0);
            v.d(a5, null);
            v.e(a5, notification.sound, notification.audioAttributes);
            ArrayList arrayList2 = sVar.f5278c;
            ArrayList<String> arrayList3 = sVar.f5290p;
            if (i11 < 28) {
                if (arrayList2 == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(arrayList2.size());
                    Iterator it2 = arrayList2.iterator();
                    if (it2.hasNext()) {
                        androidx.appcompat.widget.b0.n(it2.next());
                        throw null;
                    }
                }
                if (arrayList != null) {
                    if (arrayList3 != null) {
                        l.c cVar = new l.c(arrayList3.size() + arrayList.size());
                        cVar.addAll(arrayList);
                        cVar.addAll(arrayList3);
                        arrayList = new ArrayList(cVar);
                    }
                    arrayList3 = arrayList;
                }
            }
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                for (String str : arrayList3) {
                    v.a(a5, str);
                }
            }
            ArrayList arrayList4 = sVar.f5279d;
            if (arrayList4.size() > 0) {
                if (sVar.f5287l == null) {
                    sVar.f5287l = new Bundle();
                }
                Bundle bundle6 = sVar.f5287l.getBundle("android.car.EXTENSIONS");
                if (bundle6 == null) {
                    bundle6 = new Bundle();
                }
                Bundle bundle7 = new Bundle(bundle6);
                Bundle bundle8 = new Bundle();
                int i12 = 0;
                while (i12 < arrayList4.size()) {
                    String num = Integer.toString(i12);
                    q qVar2 = (q) arrayList4.get(i12);
                    Bundle bundle9 = new Bundle();
                    ArrayList arrayList5 = arrayList4;
                    if (qVar2.f5269b == null && (i8 = qVar2.f5272e) != 0) {
                        qVar2.f5269b = IconCompat.a(i8);
                    }
                    IconCompat iconCompat2 = qVar2.f5269b;
                    if (iconCompat2 != null) {
                        i7 = iconCompat2.b();
                        notificationManager2 = notificationManager3;
                    } else {
                        notificationManager2 = notificationManager3;
                        i7 = 0;
                    }
                    bundle9.putInt("icon", i7);
                    bundle9.putCharSequence(AppIntroBaseFragmentKt.ARG_TITLE, qVar2.f5273f);
                    bundle9.putParcelable("actionIntent", qVar2.f5274g);
                    Bundle bundle10 = qVar2.f5268a;
                    Bundle bundle11 = bundle10 != null ? new Bundle(bundle10) : new Bundle();
                    bundle11.putBoolean("android.support.allowGeneratedReplies", qVar2.f5270c);
                    bundle9.putBundle("extras", bundle11);
                    bundle9.putParcelableArray("remoteInputs", null);
                    bundle9.putBoolean("showsUserInterface", qVar2.f5271d);
                    bundle9.putInt("semanticAction", 0);
                    bundle8.putBundle(num, bundle9);
                    i12++;
                    arrayList4 = arrayList5;
                    notificationManager3 = notificationManager2;
                }
                notificationManager = notificationManager3;
                bundle6.putBundle("invisible_actions", bundle8);
                bundle7.putBundle("invisible_actions", bundle8);
                if (sVar.f5287l == null) {
                    sVar.f5287l = new Bundle();
                }
                sVar.f5287l.putBundle("android.car.EXTENSIONS", bundle6);
                bundle2.putBundle("android.car.EXTENSIONS", bundle7);
            } else {
                notificationManager = notificationManager3;
            }
            int i13 = Build.VERSION.SDK_INT;
            a5.setExtras(sVar.f5287l);
            x.e(a5, null);
            y.b(a5, 0);
            y.e(a5, null);
            y.f(a5, null);
            y.g(a5, 0L);
            y.d(a5, 0);
            if (!TextUtils.isEmpty(sVar.f5288m)) {
                a5.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
            if (i13 >= 28) {
                Iterator it3 = arrayList2.iterator();
                if (it3.hasNext()) {
                    androidx.appcompat.widget.b0.n(it3.next());
                    throw null;
                }
            }
            if (i13 >= 29) {
                a0.a(a5, sVar.f5289n);
                a0.b(a5, null);
            }
            t tVar = sVar.f5285j;
            if (tVar != null) {
                new Notification.BigTextStyle(a5).setBigContentTitle(null).bigText(((r) tVar).f5275b);
            }
            Notification build = a5.build();
            if (tVar != null) {
                sVar.f5285j.getClass();
            }
            if (tVar != null && (bundle = build.extras) != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
            }
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                g.f3394a.set(false);
                i6 = 10436;
            } else {
                i6 = 39789;
            }
            notificationManager.notify(i6, build);
        }
    }

    public final void h(Activity activity, k2.f fVar, int i5, k2.i iVar) {
        AlertDialog e5 = e(activity, i5, new l2.o(super.a(i5, activity, "d"), fVar), iVar);
        if (e5 == null) {
            return;
        }
        f(activity, e5, "GooglePlayServicesErrorDialog", iVar);
    }
}
