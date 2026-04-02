package com.fotoable.youtube.music.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
/* compiled from: ShareHelper.java */
/* loaded from: classes.dex */
public class f {
    public static void a(Context context, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str + " ");
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2 + " ");
        }
        stringBuffer.append(v.a(MusicApplication.c(), "music_share_url", "https://cdn-freemusic.fotoable.net/share/901.html?videoid=") + "" + str3);
        a(context, stringBuffer.toString(), false);
        com.fotoable.youtube.music.util.b.b("在线音乐-底部菜单-点击分享", "VideoId", str3 + "");
    }

    public static void a(Context context, String str, boolean z) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.putExtra("sms_body", str);
                intent.putExtra("Kdescription", str);
                intent.setType("text/plain");
                intent.addFlags(268435456);
                Intent createChooser = Intent.createChooser(intent, context.getString(R.string.select_app_share_title));
                if (createChooser == null) {
                    Toast.makeText(context, (int) R.string.don_not_share_tip_msdg, 0).show();
                } else {
                    createChooser.addFlags(268435456);
                    context.startActivity(createChooser);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
                Toast.makeText(context, (int) R.string.don_not_share_tip_msdg, 0).show();
            }
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("audio/*");
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
                intent.addFlags(268435456);
                Intent createChooser = Intent.createChooser(intent, context.getString(R.string.select_app_share_title));
                if (createChooser == null) {
                    Toast.makeText(context, (int) R.string.don_not_share_tip_msdg, 0).show();
                } else {
                    createChooser.addFlags(268435456);
                    context.startActivity(createChooser);
                }
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
                Toast.makeText(context, (int) R.string.don_not_share_tip_msdg, 0).show();
            }
        }
    }
}
