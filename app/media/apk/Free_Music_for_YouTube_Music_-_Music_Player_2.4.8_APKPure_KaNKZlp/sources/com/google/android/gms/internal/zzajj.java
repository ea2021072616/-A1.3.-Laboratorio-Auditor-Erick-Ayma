package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
@zzzt
/* loaded from: classes.dex */
public final class zzajj implements zzajh {
    @Nullable
    private final String zzbwh;

    public zzajj() {
        this(null);
    }

    public zzajj(@Nullable String str) {
        this.zzbwh = str;
    }

    @Override // com.google.android.gms.internal.zzajh
    @WorkerThread
    public final void zzcm(String str) {
        try {
            String valueOf = String.valueOf(str);
            zzaji.zzcb(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzjo.zzhu();
            zzaje.zza(true, httpURLConnection, this.zzbwh);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            String message = e.getMessage();
            zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length()).append("Error while pinging URL: ").append(str).append(". ").append(message).toString());
        } catch (IndexOutOfBoundsException e2) {
            String message2 = e2.getMessage();
            zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(message2).toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length()).append("Error while pinging URL: ").append(str).append(". ").append(message3).toString());
        }
    }
}
