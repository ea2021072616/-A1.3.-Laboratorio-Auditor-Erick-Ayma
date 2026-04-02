package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.DataInputStream;
import java.io.IOException;
@zzzt
/* loaded from: classes.dex */
public final class zzaba extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Parcelable.Creator<zzaba> CREATOR = new zzabc();
    private ParcelFileDescriptor zzcqp;
    private Parcelable zzcqq;
    private boolean zzcqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaba(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzcqp = parcelFileDescriptor;
        this.zzcqq = null;
        this.zzcqr = true;
    }

    public zzaba(SafeParcelable safeParcelable) {
        this.zzcqp = null;
        this.zzcqq = safeParcelable;
        this.zzcqr = false;
    }

    private final <T> ParcelFileDescriptor zze(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new zzabb(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e) {
                e = e;
                zzafx.zzb("Error transporting the ad response", e);
                com.google.android.gms.ads.internal.zzbv.zzee().zza(e, "LargeParcelTeleporter.pipeData.2");
                com.google.android.gms.common.util.zzm.closeQuietly(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zzcqp == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzcqq.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzcqp = zze(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        int zze = com.google.android.gms.common.internal.safeparcel.zzd.zze(parcel);
        com.google.android.gms.common.internal.safeparcel.zzd.zza(parcel, 2, (Parcelable) this.zzcqp, i, false);
        com.google.android.gms.common.internal.safeparcel.zzd.zzai(parcel, zze);
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzcqr) {
            if (this.zzcqp == null) {
                zzafx.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzcqp));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    com.google.android.gms.common.util.zzm.closeQuietly(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.zzcqq = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzcqr = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e);
                }
            } catch (Throwable th2) {
                com.google.android.gms.common.util.zzm.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzcqq;
    }
}
