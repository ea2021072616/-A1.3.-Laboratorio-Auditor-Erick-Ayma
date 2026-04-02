package com.fotoable.youtube.music.quicktools.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.fotoable.youtube.music.base.BaseService;
import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
import com.fotoable.youtube.music.quicktools.a.a;
import com.fotoable.youtube.music.quicktools.views.QuickToolsView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class QuickToolsService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3125a = QuickToolsService.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private QuickToolsView f3126b;

    public static void a(Context context) {
        try {
            context.stopService(new Intent(context, QuickToolsService.class));
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent(context, QuickToolsService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Exception e) {
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseService
    protected void d() {
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            a(intent);
        }
        return super.onStartCommand(intent, 1, i2);
    }

    private void a(Intent intent) {
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -57421692:
                        if (action.equals("action_syn_music_data")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1017136299:
                        if (action.equals("action_check_show_quick")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1243058864:
                        if (action.equals("action_key_back")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1680567252:
                        if (action.equals("action_show_quick")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (!a.a(this)) {
                            if (com.fotoable.youtube.music.a.o()) {
                                if (this.f3126b == null) {
                                    this.f3126b = new QuickToolsView(this);
                                }
                                if (!this.f3126b.c()) {
                                    this.f3126b.a();
                                    return;
                                }
                                return;
                            }
                            a(this);
                            return;
                        }
                        return;
                    case 1:
                        if (!a.a(this)) {
                            if (this.f3126b == null) {
                                this.f3126b = new QuickToolsView(this);
                            }
                            if (!this.f3126b.c()) {
                                this.f3126b.a();
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        PlayerInfo playerInfo = (PlayerInfo) intent.getParcelableExtra("music");
                        if (this.f3126b != null) {
                            this.f3126b.a(playerInfo);
                            return;
                        }
                        return;
                    case 3:
                        if (this.f3126b != null) {
                            this.f3126b.d();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseService, android.app.Service
    public void onDestroy() {
        if (this.f3126b != null) {
            this.f3126b.b();
        }
        super.onDestroy();
    }
}
