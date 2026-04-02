package com.pili.pldroid.player.report.core;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.graphics.drawable.PathInterpolatorCompat;
import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* compiled from: QosReporter.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5071a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f5072b = 120000;

    /* renamed from: c  reason: collision with root package name */
    private static int f5073c = 60000;
    private static int d = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
    private Handler f;
    private HandlerThread g;
    private b h;
    private boolean e = false;
    private Object i = new Object();
    private Handler.Callback j = new Handler.Callback() { // from class: com.pili.pldroid.player.report.core.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e.this.c((String) message.obj);
                    break;
                case 1:
                    e.this.a(true);
                    break;
                case 2:
                    e.this.d();
                    break;
                case 4:
                    e.this.d((String) message.obj);
                    break;
                case 6:
                    e.this.b(true);
                    break;
            }
            return true;
        }
    };

    public static int a() {
        return d;
    }

    public void a(Context context) {
        if (this.g == null) {
            this.h = new b();
            this.h.a(context.getApplicationContext());
            this.g = new HandlerThread("QosReporter");
            this.g.start();
            this.f = new Handler(this.g.getLooper(), this.j);
            this.f.sendEmptyMessageDelayed(1, f5072b);
        }
    }

    public void b() {
        if (this.g != null) {
            this.f.removeCallbacksAndMessages(null);
            this.f.sendEmptyMessageDelayed(2, 10L);
        }
    }

    private void a(int i, String str) {
        synchronized (this.i) {
            if (this.g != null && this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(i, str));
            }
        }
    }

    public void a(String str) {
        a(4, str);
    }

    public void b(String str) {
        a(0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!this.h.a(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (c.a().a(str) && !this.e && this.f != null) {
            this.e = true;
            this.f.sendEmptyMessageDelayed(6, f5073c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        String c2 = this.h.c();
        if (c2 != null && a("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5", c2)) {
            this.h.b();
        }
        if (z && this.f != null) {
            this.f.sendEmptyMessageDelayed(1, f5072b);
        }
    }

    private void c() {
        Intent intent = new Intent("pldroid-player-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 162);
        com.pili.pldroid.player.report.a.a().a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        String c2 = c.a().c();
        if (c2 != null && a("http://play-pili-qos-report.qiniuapi.com/raw/log/play-v5", c2)) {
            c.a().b();
        }
        if (z && this.f != null) {
            c();
            this.f.sendEmptyMessageDelayed(6, f5073c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.g != null) {
            this.f.removeCallbacksAndMessages(null);
            synchronized (this.i) {
                this.f = null;
            }
            a(false);
            if (this.e) {
                b(false);
            }
            this.g.quit();
            this.g = null;
            this.h.a();
        }
    }

    private void a(String str, int i, int i2) {
        if (i >= 10000 && i2 >= 10000) {
            if (str.equals("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5")) {
                if (i != f5072b) {
                    f5072b = i;
                }
            } else if (str.equals("http://play-pili-qos-report.qiniuapi.com/raw/log/play-v5") && i != f5073c) {
                f5073c = i;
                d = i2;
            }
        }
    }

    private boolean a(String str, String str2) {
        int contentLength;
        if (f5071a) {
            Log.d("QosReporter", "url: \n" + str + "\ncontent: \n" + str2);
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
            httpURLConnection.setReadTimeout(10000);
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", f5071a ? "application/octet-stream" : "application/x-gzip");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                try {
                    byte[] bytes = str2.getBytes();
                    if (bytes == null) {
                        return false;
                    }
                    if (f5071a) {
                        httpURLConnection.getOutputStream().write(bytes);
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
                    }
                    httpURLConnection.getOutputStream().flush();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (f5071a) {
                            Log.d("QosReporter", "response code = " + responseCode);
                        }
                        if (responseCode == 200 && (contentLength = httpURLConnection.getContentLength()) != 0) {
                            if (contentLength < 0) {
                                contentLength = 16384;
                            }
                            try {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                byte[] bArr = new byte[contentLength];
                                try {
                                    try {
                                        int read = inputStream.read(bArr);
                                        try {
                                            inputStream.close();
                                            if (read <= 0) {
                                                return false;
                                            }
                                            String trim = new String(bArr).trim();
                                            if (f5071a) {
                                                Log.d("QosReporter", trim);
                                            }
                                            try {
                                                JSONObject jSONObject = new JSONObject(trim);
                                                a(str, jSONObject.optInt("reportInterval") * 1000, jSONObject.optInt("sampleInterval") * 1000);
                                            } catch (Exception e) {
                                                ThrowableExtension.printStackTrace(e);
                                            }
                                            return true;
                                        } catch (IOException e2) {
                                            if (f5071a) {
                                                ThrowableExtension.printStackTrace(e2);
                                            }
                                            return false;
                                        }
                                    } catch (IOException e3) {
                                        if (f5071a) {
                                            ThrowableExtension.printStackTrace(e3);
                                        }
                                        try {
                                            inputStream.close();
                                            return false;
                                        } catch (IOException e4) {
                                            if (f5071a) {
                                                ThrowableExtension.printStackTrace(e4);
                                            }
                                            return false;
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        inputStream.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        if (f5071a) {
                                            ThrowableExtension.printStackTrace(e5);
                                        }
                                        return false;
                                    }
                                }
                            } catch (IOException e6) {
                                if (f5071a) {
                                    ThrowableExtension.printStackTrace(e6);
                                }
                                return false;
                            } catch (Exception e7) {
                                if (f5071a) {
                                    ThrowableExtension.printStackTrace(e7);
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (IOException e8) {
                        if (f5071a) {
                            ThrowableExtension.printStackTrace(e8);
                        }
                        return false;
                    }
                } catch (IOException e9) {
                    if (f5071a) {
                        ThrowableExtension.printStackTrace(e9);
                    }
                    return false;
                } catch (Exception e10) {
                    return false;
                }
            } catch (ProtocolException e11) {
                if (f5071a) {
                    ThrowableExtension.printStackTrace(e11);
                }
                return false;
            }
        } catch (IOException e12) {
            if (f5071a) {
                ThrowableExtension.printStackTrace(e12);
            }
            return false;
        } catch (Exception e13) {
            if (f5071a) {
                ThrowableExtension.printStackTrace(e13);
            }
            return false;
        }
    }
}
