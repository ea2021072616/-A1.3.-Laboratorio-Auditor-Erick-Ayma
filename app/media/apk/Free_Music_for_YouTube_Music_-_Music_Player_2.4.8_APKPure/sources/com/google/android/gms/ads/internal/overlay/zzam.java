package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzzt;
@zzzt
/* loaded from: classes.dex */
final class zzam implements SensorEventListener {
    private final SensorManager zzcif;
    private final Display zzcih;
    private float[] zzcik;
    private Handler zzcil;
    private zzao zzcim;
    private final float[] zzcii = new float[9];
    private final float[] zzcij = new float[9];
    private final Object zzcig = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(Context context) {
        this.zzcif = (SensorManager) context.getSystemService("sensor");
        this.zzcih = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zze(int i, int i2) {
        float f = this.zzcij[i];
        this.zzcij[i] = this.zzcij[i2];
        this.zzcij[i2] = f;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzcig) {
            if (this.zzcik == null) {
                this.zzcik = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzcii, fArr);
        switch (this.zzcih.getRotation()) {
            case 1:
                SensorManager.remapCoordinateSystem(this.zzcii, 2, TsExtractor.TS_STREAM_TYPE_AC3, this.zzcij);
                break;
            case 2:
                SensorManager.remapCoordinateSystem(this.zzcii, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, this.zzcij);
                break;
            case 3:
                SensorManager.remapCoordinateSystem(this.zzcii, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 1, this.zzcij);
                break;
            default:
                System.arraycopy(this.zzcii, 0, this.zzcij, 0, 9);
                break;
        }
        zze(1, 3);
        zze(2, 6);
        zze(5, 7);
        synchronized (this.zzcig) {
            System.arraycopy(this.zzcij, 0, this.zzcik, 0, 9);
        }
        if (this.zzcim != null) {
            this.zzcim.zzmr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void start() {
        if (this.zzcil != null) {
            return;
        }
        Sensor defaultSensor = this.zzcif.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzafx.e("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.zzcil = new Handler(handlerThread.getLooper());
        if (this.zzcif.registerListener(this, defaultSensor, 0, this.zzcil)) {
            return;
        }
        zzafx.e("SensorManager.registerListener failed.");
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzcil == null) {
            return;
        }
        this.zzcif.unregisterListener(this);
        this.zzcil.post(new zzan(this));
        this.zzcil = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzao zzaoVar) {
        this.zzcim = zzaoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        boolean z = false;
        synchronized (this.zzcig) {
            if (this.zzcik != null) {
                System.arraycopy(this.zzcik, 0, fArr, 0, this.zzcik.length);
                z = true;
            }
        }
        return z;
    }
}
