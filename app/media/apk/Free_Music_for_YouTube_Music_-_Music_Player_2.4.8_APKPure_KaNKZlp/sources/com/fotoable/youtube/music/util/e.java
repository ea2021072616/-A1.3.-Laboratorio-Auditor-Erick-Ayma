package com.fotoable.youtube.music.util;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* compiled from: FileUtils.java */
/* loaded from: classes.dex */
public class e {
    public static String a(Context context, String str) {
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (open != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, AudienceNetworkActivity.WEBVIEW_ENCODING));
                StringBuilder sb = new StringBuilder("");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + "\n");
                    } else {
                        open.close();
                        return sb.toString();
                    }
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return "";
    }
}
