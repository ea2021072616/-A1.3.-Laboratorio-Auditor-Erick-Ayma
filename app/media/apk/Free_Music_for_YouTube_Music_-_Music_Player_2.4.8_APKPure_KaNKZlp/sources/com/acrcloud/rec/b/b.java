package com.acrcloud.rec.b;

import android.content.Context;
/* compiled from: ACRCloudConfig.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EnumC0014b f335a = EnumC0014b.REC_MODE_REMOTE;

    /* renamed from: b  reason: collision with root package name */
    public int f336b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public String f337c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public a g = a.PROTOCOL_HTTP;
    public d h = null;
    public e i = null;
    public Context j = null;

    /* compiled from: ACRCloudConfig.java */
    /* loaded from: classes.dex */
    public enum a {
        PROTOCOL_HTTP,
        PROTOCOL_HTTPS
    }

    /* compiled from: ACRCloudConfig.java */
    /* renamed from: com.acrcloud.rec.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0014b {
        REC_MODE_REMOTE,
        REC_MODE_LOCAL,
        REC_MODE_BOTH
    }

    /* compiled from: ACRCloudConfig.java */
    /* loaded from: classes.dex */
    public enum c {
        RESULT_TYPE_NONE,
        RESULT_TYPE_AUDIO,
        RESULT_TYPE_LIVE,
        RESULT_TYPE_AUDIO_LIVE
    }
}
