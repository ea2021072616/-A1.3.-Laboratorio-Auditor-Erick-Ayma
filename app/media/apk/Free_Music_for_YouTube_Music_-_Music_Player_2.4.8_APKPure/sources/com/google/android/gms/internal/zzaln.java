package com.google.android.gms.internal;

import android.webkit.ConsoleMessage;
/* loaded from: classes.dex */
final /* synthetic */ class zzaln {
    static final /* synthetic */ int[] zzdij = new int[ConsoleMessage.MessageLevel.values().length];

    static {
        try {
            zzdij[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzdij[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzdij[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzdij[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzdij[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
