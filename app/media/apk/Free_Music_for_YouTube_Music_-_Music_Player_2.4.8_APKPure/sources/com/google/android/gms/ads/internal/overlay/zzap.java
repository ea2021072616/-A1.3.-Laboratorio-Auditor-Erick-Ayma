package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzzt;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
@zzzt
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzap extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzao {
    private static final float[] zzcin = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int zzakv;
    private int zzakw;
    private final float[] zzcik;
    private final zzam zzcio;
    private final float[] zzcip;
    private final float[] zzciq;
    private final float[] zzcir;
    private final float[] zzcis;
    private final float[] zzcit;
    private final float[] zzciu;
    private float zzciv;
    private float zzciw;
    private float zzcix;
    private SurfaceTexture zzciy;
    private SurfaceTexture zzciz;
    private int zzcja;
    private int zzcjb;
    private int zzcjc;
    private FloatBuffer zzcjd;
    private final CountDownLatch zzcje;
    private final Object zzcjf;
    private EGL10 zzcjg;
    private EGLDisplay zzcjh;
    private EGLContext zzcji;
    private EGLSurface zzcjj;
    private volatile boolean zzcjk;
    private volatile boolean zzcjl;

    public zzap(Context context) {
        super("SphericalVideoProcessor");
        this.zzcjd = ByteBuffer.allocateDirect(zzcin.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzcjd.put(zzcin).position(0);
        this.zzcik = new float[9];
        this.zzcip = new float[9];
        this.zzciq = new float[9];
        this.zzcir = new float[9];
        this.zzcis = new float[9];
        this.zzcit = new float[9];
        this.zzciu = new float[9];
        this.zzciv = Float.NaN;
        this.zzcio = new zzam(context);
        this.zzcio.zza(this);
        this.zzcje = new CountDownLatch(1);
        this.zzcjf = new Object();
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos(f);
        fArr[5] = (float) (-Math.sin(f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(f);
        fArr[8] = (float) Math.cos(f);
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f) {
        fArr[0] = (float) Math.cos(f);
        fArr[1] = (float) (-Math.sin(f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(f);
        fArr[4] = (float) Math.cos(f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zzbr(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private static int zzc(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzbr("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzbr("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzbr("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzbr("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", new StringBuilder(37).append("Could not compile shader ").append(i).append(":").toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzbr("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private final void zznk() {
        while (this.zzcjc > 0) {
            this.zzciy.updateTexImage();
            this.zzcjc--;
        }
        if (this.zzcio.zza(this.zzcik)) {
            if (Float.isNaN(this.zzciv)) {
                float[] fArr = this.zzcik;
                float[] fArr2 = {0.0f, 1.0f, 0.0f};
                float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[8] * fArr2[2]) + (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])};
                this.zzciv = -(((float) Math.atan2(fArr3[1], fArr3[0])) - 1.5707964f);
            }
            zzb(this.zzcit, this.zzciv + this.zzciw);
        } else {
            zza(this.zzcik, -1.5707964f);
            zzb(this.zzcit, this.zzciw);
        }
        zza(this.zzcip, 1.5707964f);
        zza(this.zzciq, this.zzcit, this.zzcip);
        zza(this.zzcir, this.zzcik, this.zzciq);
        zza(this.zzcis, this.zzcix);
        zza(this.zzciu, this.zzcis, this.zzcir);
        GLES20.glUniformMatrix3fv(this.zzcjb, 1, false, this.zzciu, 0);
        GLES20.glDrawArrays(5, 0, 4);
        zzbr("drawArrays");
        GLES20.glFinish();
        this.zzcjg.eglSwapBuffers(this.zzcjh, this.zzcjj);
    }

    private final boolean zznl() {
        boolean z = false;
        if (this.zzcjj != null && this.zzcjj != EGL10.EGL_NO_SURFACE) {
            z = this.zzcjg.eglMakeCurrent(this.zzcjh, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false | this.zzcjg.eglDestroySurface(this.zzcjh, this.zzcjj);
            this.zzcjj = null;
        }
        if (this.zzcji != null) {
            z |= this.zzcjg.eglDestroyContext(this.zzcjh, this.zzcji);
            this.zzcji = null;
        }
        if (this.zzcjh != null) {
            boolean eglTerminate = z | this.zzcjg.eglTerminate(this.zzcjh);
            this.zzcjh = null;
            return eglTerminate;
        }
        return z;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzcjc++;
        synchronized (this.zzcjf) {
            this.zzcjf.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.graphics.SurfaceTexture, android.graphics.SurfaceTexture$OnFrameAvailableListener] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        int glCreateProgram;
        if (this.zzciz == null) {
            zzafx.e("SphericalVideoProcessor started with no output texture.");
            this.zzcje.countDown();
            return;
        }
        this.zzcjg = (EGL10) EGLContext.getEGL();
        this.zzcjh = this.zzcjg.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.zzcjh == EGL10.EGL_NO_DISPLAY) {
            z = false;
        } else {
            if (this.zzcjg.eglInitialize(this.zzcjh, new int[2])) {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGLConfig eGLConfig = (!this.zzcjg.eglChooseConfig(this.zzcjh, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
                if (eGLConfig == null) {
                    z = false;
                } else {
                    this.zzcji = this.zzcjg.eglCreateContext(this.zzcjh, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    if (this.zzcji == null || this.zzcji == EGL10.EGL_NO_CONTEXT) {
                        z = false;
                    } else {
                        this.zzcjj = this.zzcjg.eglCreateWindowSurface(this.zzcjh, eGLConfig, this.zzciz, null);
                        z = (this.zzcjj == null || this.zzcjj == EGL10.EGL_NO_SURFACE) ? false : this.zzcjg.eglMakeCurrent(this.zzcjh, this.zzcjj, this.zzcjj, this.zzcji);
                    }
                }
            } else {
                z = false;
            }
        }
        zzmk<String> zzmkVar = zzmu.zzbkp;
        int zzc = zzc(35633, !((String) zzbv.zzen().zzd(zzmkVar)).equals(zzmkVar.zzik()) ? (String) zzbv.zzen().zzd(zzmkVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (zzc == 0) {
            glCreateProgram = 0;
        } else {
            zzmk<String> zzmkVar2 = zzmu.zzbkq;
            int zzc2 = zzc(35632, !((String) zzbv.zzen().zzd(zzmkVar2)).equals(zzmkVar2.zzik()) ? (String) zzbv.zzen().zzd(zzmkVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (zzc2 == 0) {
                glCreateProgram = 0;
            } else {
                glCreateProgram = GLES20.glCreateProgram();
                zzbr("createProgram");
                if (glCreateProgram != 0) {
                    GLES20.glAttachShader(glCreateProgram, zzc);
                    zzbr("attachShader");
                    GLES20.glAttachShader(glCreateProgram, zzc2);
                    zzbr("attachShader");
                    GLES20.glLinkProgram(glCreateProgram);
                    zzbr("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                    zzbr("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                        GLES20.glDeleteProgram(glCreateProgram);
                        zzbr("deleteProgram");
                        glCreateProgram = 0;
                    } else {
                        GLES20.glValidateProgram(glCreateProgram);
                        zzbr("validateProgram");
                    }
                }
            }
        }
        this.zzcja = glCreateProgram;
        GLES20.glUseProgram(this.zzcja);
        zzbr("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.zzcja, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.zzcjd);
        zzbr("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        zzbr("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        zzbr("genTextures");
        int i = iArr3[0];
        GLES20.glBindTexture(36197, i);
        zzbr("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        zzbr("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        zzbr("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzbr("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzbr("texParameteri");
        this.zzcjb = GLES20.glGetUniformLocation(this.zzcja, "uVMat");
        GLES20.glUniformMatrix3fv(this.zzcjb, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        boolean z2 = this.zzcja != 0;
        if (!z || !z2) {
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.zzcjg.eglGetError()));
            String concat = valueOf.length() != 0 ? "EGL initialization failed: ".concat(valueOf) : new String("EGL initialization failed: ");
            zzafx.e(concat);
            zzbv.zzee().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
            zznl();
            this.zzcje.countDown();
            return;
        }
        this.zzciy = new SurfaceTexture(i);
        this.zzciy.setOnFrameAvailableListener(this);
        this.zzcje.countDown();
        this.zzcio.start();
        try {
            this.zzcjk = true;
            while (!this.zzcjl) {
                zznk();
                if (this.zzcjk) {
                    GLES20.glViewport(0, 0, this.zzakv, this.zzakw);
                    zzbr("viewport");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.zzcja, "uFOVx");
                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzcja, "uFOVy");
                    if (this.zzakv > this.zzakw) {
                        GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
                        GLES20.glUniform1f(glGetUniformLocation2, (this.zzakw * 0.87266463f) / this.zzakv);
                    } else {
                        GLES20.glUniform1f(glGetUniformLocation, (this.zzakv * 0.87266463f) / this.zzakw);
                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                    }
                    this.zzcjk = false;
                }
                try {
                    synchronized (this.zzcjf) {
                        if (!this.zzcjl && !this.zzcjk && this.zzcjc == 0) {
                            this.zzcjf.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            zzafx.zzcs("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            zzafx.zzb("SphericalVideoProcessor died.", th);
            zzbv.zzee().zza(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.zzcio.stop();
            this.zzciy.setOnFrameAvailableListener(null);
            this.zzciy = null;
            zznl();
        }
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzakv = i;
        this.zzakw = i2;
        this.zzciz = surfaceTexture;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        if (this.zzakv > this.zzakw) {
            f3 = (1.7453293f * f) / this.zzakv;
            f4 = (1.7453293f * f2) / this.zzakv;
        } else {
            f3 = (1.7453293f * f) / this.zzakw;
            f4 = (1.7453293f * f2) / this.zzakw;
        }
        this.zzciw -= f3;
        this.zzcix -= f4;
        if (this.zzcix < -1.5707964f) {
            this.zzcix = -1.5707964f;
        }
        if (this.zzcix > 1.5707964f) {
            this.zzcix = 1.5707964f;
        }
    }

    public final void zzf(int i, int i2) {
        synchronized (this.zzcjf) {
            this.zzakv = i;
            this.zzakw = i2;
            this.zzcjk = true;
            this.zzcjf.notifyAll();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzao
    public final void zzmr() {
        synchronized (this.zzcjf) {
            this.zzcjf.notifyAll();
        }
    }

    public final void zzni() {
        synchronized (this.zzcjf) {
            this.zzcjl = true;
            this.zzciz = null;
            this.zzcjf.notifyAll();
        }
    }

    public final SurfaceTexture zznj() {
        if (this.zzciz == null) {
            return null;
        }
        try {
            this.zzcje.await();
        } catch (InterruptedException e) {
        }
        return this.zzciy;
    }
}
