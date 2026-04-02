package com.fotoable.youtube.music.util.decode;
/* loaded from: classes.dex */
public class SkyVpnKeyStore {
    public static native String getSkyVpnKey();

    static {
        System.loadLibrary("native-lib");
    }
}
