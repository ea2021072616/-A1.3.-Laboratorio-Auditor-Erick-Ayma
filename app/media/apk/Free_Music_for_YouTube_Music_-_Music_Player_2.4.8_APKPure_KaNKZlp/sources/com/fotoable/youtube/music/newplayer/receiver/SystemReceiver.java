package com.fotoable.youtube.music.newplayer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.fotoable.youtube.music.locker.activity.LockerScreenActivity;
import com.fotoable.youtube.music.newplayer.b.b;
import com.fotoable.youtube.music.newplayer.b.d;
import com.fotoable.youtube.music.newplayer.f;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import com.fotoable.youtube.music.receiver.PhoneReceiver;
import com.fotoable.youtube.music.util.h;
/* loaded from: classes.dex */
public class SystemReceiver extends BroadcastReceiver {
    private static final String d = SystemReceiver.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    final String f3078a = "reason";

    /* renamed from: b  reason: collision with root package name */
    final String f3079b = "homekey";

    /* renamed from: c  reason: collision with root package name */
    final String f3080c = "recentapps";
    private int e = 0;
    private Handler f = new Handler();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            h.a(d, intent.getAction());
            String action = intent.getAction();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1538406691:
                    if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -403228793:
                    if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 823795052:
                    if (action.equals("android.intent.action.USER_PRESENT")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    h.a(d, "屏幕关闭ACTION_SCREEN_OFF");
                    f.a().b(context);
                    b(context);
                    c(context);
                    h.a(d, "enableCharingLocker:" + com.fotoable.youtube.music.a.i() + ", chargingStatus:" + this.e + " ," + f.a().A() + " ,:::" + this.e);
                    return;
                case 1:
                    h.a(d, "屏幕打开ACTION_SCREEN_ON");
                    b(context);
                    if (!PhoneReceiver.f3155a && this.e == 1 && com.fotoable.youtube.music.a.i() && !f.a().B()) {
                        d(context);
                        return;
                    }
                    return;
                case 2:
                    h.a(d, "屏幕解锁USER_PRESENT");
                    f.a().v();
                    return;
                case 3:
                    String stringExtra = intent.getStringExtra("reason");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (TextUtils.equals(stringExtra, "homekey")) {
                            f.a().y();
                            return;
                        } else if (TextUtils.equals(stringExtra, "recentapps")) {
                            f.a().y();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 4:
                    switch (intent.getIntExtra("status", 1)) {
                        case 2:
                            if (this.e == 0) {
                                this.e = 1;
                                if (!PhoneReceiver.f3155a && com.fotoable.youtube.music.a.i() && !f.a().B()) {
                                    d(context);
                                    return;
                                } else {
                                    c(context);
                                    return;
                                }
                            }
                            return;
                        case 3:
                            this.e = 0;
                            return;
                        case 4:
                            this.e = 0;
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    private void b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            switch (registerReceiver.getIntExtra("status", -1)) {
                case 2:
                    if (this.e == 0) {
                        this.e = 1;
                        return;
                    }
                    return;
                case 3:
                    this.e = 0;
                    return;
                case 4:
                    this.e = 0;
                    return;
                case 5:
                    this.e = 1;
                    return;
                default:
                    return;
            }
        }
    }

    private void c(Context context) {
        if (com.fotoable.youtube.music.a.n() && f.a().B()) {
            if (com.fotoable.youtube.music.newplayer.d.a.a().c()) {
                LocalMusicModel e = b.a().e();
                if (e != null && !LockerScreenActivity.f2756a) {
                    Intent intent = new Intent(context, LockerScreenActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("LocalMusicModel", e);
                    intent.putExtra("type", "player");
                    context.startActivity(intent);
                }
            } else if (com.fotoable.youtube.music.newplayer.d.b.a().c()) {
                RadioModel c2 = d.a().c();
                if (c2 != null && !LockerScreenActivity.f2756a) {
                    Intent intent2 = new Intent(context, LockerScreenActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("RadioModel", c2);
                    intent2.putExtra("type", "player");
                    context.startActivity(intent2);
                }
            } else if (!f.a().B() && !PhoneReceiver.f3155a && this.e == 1 && com.fotoable.youtube.music.a.i() && !f.a().B()) {
                d(context);
            }
        } else if (!f.a().B() && !PhoneReceiver.f3155a && this.e == 1 && com.fotoable.youtube.music.a.i() && !f.a().B()) {
            d(context);
        }
    }

    private void d(final Context context) {
        if (!LockerScreenActivity.f2756a) {
            this.f.postDelayed(new Runnable(this, context) { // from class: com.fotoable.youtube.music.newplayer.receiver.a

                /* renamed from: a  reason: collision with root package name */
                private final SystemReceiver f3081a;

                /* renamed from: b  reason: collision with root package name */
                private final Context f3082b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f3081a = this;
                    this.f3082b = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f3081a.a(this.f3082b);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context) {
        if (context != null && !PhoneReceiver.f3155a && this.e == 1 && com.fotoable.youtube.music.a.i()) {
            LockerScreenActivity.a(context);
        }
    }
}
