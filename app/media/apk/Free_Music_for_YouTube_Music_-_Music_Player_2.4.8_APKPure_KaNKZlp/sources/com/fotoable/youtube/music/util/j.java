package com.fotoable.youtube.music.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fotoable.youtube.music.MusicApplication;
/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public class j {

    /* compiled from: NetworkUtils.java */
    /* loaded from: classes.dex */
    public enum a {
        NoInit,
        None,
        G2,
        G3,
        G4,
        Unknown,
        Wifi
    }

    public static synchronized a a() {
        a aVar;
        synchronized (j.class) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) MusicApplication.c().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    aVar = a.Wifi;
                } else if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            aVar = a.G2;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            aVar = a.G3;
                            break;
                        case 13:
                            aVar = a.G4;
                            break;
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                aVar = a.G3;
                                break;
                            } else {
                                aVar = a.Unknown;
                                break;
                            }
                            break;
                    }
                } else {
                    aVar = a.None;
                }
            } else {
                aVar = a.None;
            }
        }
        return aVar;
    }
}
