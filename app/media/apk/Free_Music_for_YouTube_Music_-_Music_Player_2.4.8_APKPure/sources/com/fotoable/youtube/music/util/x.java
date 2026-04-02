package com.fotoable.youtube.music.util;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.ui.widget.MusicWidgetSmall;
import java.util.ArrayList;
/* compiled from: WidgetUtil.java */
/* loaded from: classes.dex */
public class x {
    public static boolean a() {
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.add(MusicWidgetSmall.class);
        try {
            for (Class cls : arrayList) {
                if (a(cls)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean a(Class<? extends AppWidgetProvider> cls) {
        return AppWidgetManager.getInstance(MusicApplication.c()).getAppWidgetIds(new ComponentName(MusicApplication.c(), cls)).length > 0;
    }

    public static void a(boolean z) {
        v.b(MusicApplication.c(), "app_widget_enable", z);
    }
}
