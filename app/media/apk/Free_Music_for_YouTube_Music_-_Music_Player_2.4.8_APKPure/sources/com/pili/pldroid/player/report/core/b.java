package com.pili.pldroid.player.report.core;

import android.content.Context;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: QosFileManager.java */
/* loaded from: classes2.dex */
public final class b {
    private Context e;

    /* renamed from: a  reason: collision with root package name */
    private long f5058a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f5059b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f5060c = 0;
    private long d = 0;
    private boolean f = false;
    private String g = null;

    private static String a(Context context, String str, long j) {
        Closeable closeable;
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream2;
        try {
            try {
                fileInputStream = context.openFileInput(str);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    bufferedReader.skip(j);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    if ("".equals(sb2)) {
                        a(fileInputStream);
                        a(bufferedReader);
                        return null;
                    }
                    a(fileInputStream);
                    a(bufferedReader);
                    return sb2;
                } catch (FileNotFoundException e) {
                    bufferedReader2 = bufferedReader;
                    fileInputStream2 = fileInputStream;
                    a(fileInputStream2);
                    a(bufferedReader2);
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    ThrowableExtension.printStackTrace(e);
                    a(fileInputStream);
                    a(bufferedReader);
                    return null;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    ThrowableExtension.printStackTrace(e);
                    a(fileInputStream);
                    a(bufferedReader);
                    return null;
                }
            } catch (FileNotFoundException e4) {
                bufferedReader2 = null;
                fileInputStream2 = fileInputStream;
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (OutOfMemoryError e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                closeable = null;
                th = th3;
                a(fileInputStream);
                a(closeable);
                throw th;
            }
        } catch (FileNotFoundException e7) {
            bufferedReader2 = null;
            fileInputStream2 = null;
        } catch (IOException e8) {
            e = e8;
            bufferedReader = null;
            fileInputStream = null;
        } catch (OutOfMemoryError e9) {
            e = e9;
            bufferedReader = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            closeable = null;
            fileInputStream = null;
            th = th4;
        }
    }

    private static boolean a(Context context, String str, String str2, int i) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Closeable closeable;
        OutOfMemoryError e;
        BufferedWriter bufferedWriter;
        IOException e2;
        FileOutputStream fileOutputStream2;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                fileOutputStream = context.openFileOutput(str, i);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                try {
                    bufferedWriter.write(str2);
                    bufferedWriter.close();
                    a(fileOutputStream);
                    a(bufferedWriter);
                    return true;
                } catch (FileNotFoundException e3) {
                    bufferedWriter2 = bufferedWriter;
                    fileOutputStream2 = fileOutputStream;
                    a(fileOutputStream2);
                    a(bufferedWriter2);
                    return false;
                } catch (IOException e4) {
                    e2 = e4;
                    ThrowableExtension.printStackTrace(e2);
                    a(fileOutputStream);
                    a(bufferedWriter);
                    return false;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    ThrowableExtension.printStackTrace(e);
                    a(fileOutputStream);
                    a(bufferedWriter);
                    return false;
                }
            } catch (FileNotFoundException e6) {
                fileOutputStream2 = fileOutputStream;
            } catch (IOException e7) {
                bufferedWriter = null;
                e2 = e7;
            } catch (OutOfMemoryError e8) {
                bufferedWriter = null;
                e = e8;
            } catch (Throwable th3) {
                closeable = null;
                th = th3;
                a(fileOutputStream);
                a(closeable);
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileOutputStream2 = null;
        } catch (IOException e10) {
            fileOutputStream = null;
            e2 = e10;
            bufferedWriter = null;
        } catch (OutOfMemoryError e11) {
            fileOutputStream = null;
            e = e11;
            bufferedWriter = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            closeable = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }

    public void a(Context context) {
        if (!this.f) {
            this.e = context.getApplicationContext();
            f();
            if (d()) {
                this.g = a(context, "pili_qos_cache", 0L);
            }
            this.f = true;
        }
    }

    public void a() {
        if (this.f) {
            if (this.g != null) {
                a(this.e, "pili_qos_cache", this.g, 0);
                this.g = null;
            }
            this.f = false;
        }
    }

    public void b() {
        this.g = null;
        if (d()) {
            this.e.deleteFile("pili_qos_cache");
        }
    }

    public String c() {
        if (this.f) {
            if (this.g != null) {
                return this.g;
            }
            if (this.f5058a == this.f5060c && this.f5059b == this.d) {
                return null;
            }
            synchronized (this) {
                boolean z = this.f5058a < this.f5060c;
                this.g = a(this.e, "pili_qos_log." + this.f5058a, this.f5059b);
                if (this.g == null) {
                    return null;
                }
                this.f5059b += this.g.length();
                if (this.f5058a < this.f5060c) {
                    this.f5058a++;
                    this.f5059b = 0L;
                }
                g();
                if (z) {
                    this.e.deleteFile("pili_qos_log." + (this.f5058a - 1));
                }
                return this.g;
            }
        }
        return null;
    }

    public boolean a(String str) {
        if (this.f && this.f5060c - this.f5058a <= 100) {
            synchronized (this) {
                if (a(this.e, "pili_qos_log." + this.f5060c, str, 32768)) {
                    this.d += str.length();
                    if (this.d >= 65536) {
                        this.f5060c++;
                        this.d = 0L;
                    }
                    g();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean d() {
        return new File(this.e.getFilesDir().getAbsolutePath() + "/pili_qos_cache").exists();
    }

    private void e() {
        String[] fileList;
        for (String str : this.e.fileList()) {
            if (str.startsWith("pili_qos_")) {
                this.e.deleteFile(str);
            }
        }
    }

    private boolean f() {
        boolean z = false;
        try {
            String a2 = a(this.e, "pili_qos_index.json", 0L);
            if (a2 == null) {
                e();
            } else {
                JSONObject jSONObject = new JSONObject(String.valueOf(a2));
                this.f5058a = jSONObject.getLong("read_file_index");
                this.f5059b = jSONObject.getLong("read_file_position");
                this.f5060c = jSONObject.getLong("write_file_index");
                this.d = jSONObject.getLong("write_file_position");
                z = true;
            }
        } catch (JSONException e) {
            ThrowableExtension.printStackTrace(e);
            e();
        }
        return z;
    }

    private boolean g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("read_file_index", this.f5058a);
            jSONObject.put("read_file_position", this.f5059b);
            jSONObject.put("write_file_index", this.f5060c);
            jSONObject.put("write_file_position", this.d);
            return a(this.e, "pili_qos_index.json", jSONObject.toString(), 0);
        } catch (JSONException e) {
            ThrowableExtension.printStackTrace(e);
            return false;
        }
    }
}
