package com.fotoable.youtube.music.util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.fotoable.youtube.music.MusicApplication;
/* compiled from: InputMethodUtils.java */
/* loaded from: classes.dex */
public class g {
    public static void a(View view) {
        InputMethodManager inputMethodManager;
        if (MusicApplication.c() != null && view != null && (inputMethodManager = (InputMethodManager) MusicApplication.c().getSystemService("input_method")) != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    public static void b(View view) {
        InputMethodManager inputMethodManager;
        if (MusicApplication.c() != null && view != null && (inputMethodManager = (InputMethodManager) MusicApplication.c().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
