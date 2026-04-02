package com.fotoable.youtube.music.a;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
/* compiled from: EventLogUtil.java */
/* loaded from: classes.dex */
public class c {
    public static void a(String str) {
        try {
            Answers.getInstance().logCustom(new CustomEvent(str));
        } catch (IllegalArgumentException e) {
            Answers.getInstance().logCustom(new CustomEvent("统计的事件超过了100characters"));
        }
    }
}
