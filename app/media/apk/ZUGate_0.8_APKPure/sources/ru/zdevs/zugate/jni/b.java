package ru.zdevs.zugate.jni;

import android.os.Build;
import b4.j;
import java.util.concurrent.atomic.AtomicReference;
import ru.zdevs.zugate.jni.BlockDevice;
import w.g;
import x4.h;
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: b  reason: collision with root package name */
    public final int f4619b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4620c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4621d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4622e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4623f;

    /* renamed from: g  reason: collision with root package name */
    public String f4624g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f4625h;

    /* renamed from: i  reason: collision with root package name */
    public final String f4626i;

    /* renamed from: j  reason: collision with root package name */
    public final String f4627j;

    public b(long j5, int i5, boolean z4, String str, String str2, long j6, int i6) {
        this.f4621d = j5;
        this.f4622e = i5;
        this.f4623f = z4;
        this.f4626i = str;
        this.f4627j = str2;
        this.f4620c = j6;
        this.f4619b = i6;
    }

    @Override // ru.zdevs.zugate.jni.d
    public final boolean A(int i5, String str, String str2, String str3, StringBuilder sb) {
        if (this.f4623f) {
            return true;
        }
        h G = w4.c.G(false);
        if (G == null) {
            return false;
        }
        try {
            StringBuilder sb2 = new StringBuilder("echo \"");
            sb2.append(str);
            sb2.append("\" | ");
            sb2.append(w4.c.f5418d);
            sb2.append("/libcryptsetup.so open --type ");
            if (i5 == 1) {
                sb2.append("luks1");
            } else if (i5 == 2) {
                sb2.append("luks2");
            } else if (i5 == 3) {
                sb2.append("bitlk");
            } else if (i5 != 4) {
                return false;
            } else {
                sb2.append("tcrypt");
            }
            sb2.append(" ");
            sb2.append(this.f4626i);
            sb2.append(" ");
            sb2.append(G());
            AtomicReference atomicReference = new AtomicReference();
            int G2 = G.G(sb2.toString(), sb, new g(12, atomicReference));
            BlockDevice.BlockException blockException = (BlockDevice.BlockException) atomicReference.get();
            if (blockException == null) {
                if (G2 == 0) {
                    this.f4623f = true;
                }
                return this.f4623f;
            }
            throw blockException;
        } finally {
            G.close();
        }
    }

    @Override // ru.zdevs.zugate.jni.d
    public final boolean E() {
        return false;
    }

    public final String G() {
        StringBuilder sb = new StringBuilder("zug-");
        String str = this.f4626i;
        sb.append(str.substring(str.lastIndexOf(47) + 1));
        return sb.toString();
    }

    public final boolean H(String str, StringBuilder sb) {
        int i5;
        String trim;
        int indexOf;
        if (this.f4624g != null) {
            return true;
        }
        h G = w4.c.G(true);
        if (G == null) {
            return false;
        }
        try {
            this.f4625h = w4.c.f5419e + "/Mounts/" + str;
            if (G.G("mkdir -p \"" + this.f4625h + "\"", null, new h0.h(19)) != 0) {
                sb.append("Failed to create mount point: ");
                sb.append(this.f4625h);
                sb.append("\n");
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            if (G.G("ls -ld " + w4.c.f5419e + "/DCIM", sb2, null) == 0) {
                String trim2 = sb2.toString().trim();
                String[] b02 = j.b0(trim2, " ");
                if (b02.length == 8) {
                    G.G("chown " + b02[2] + ":" + b02[3] + " \"" + w4.c.f5419e + "/Mounts\"", null, null);
                    G.G("chown " + b02[2] + ":" + b02[3] + " \"" + this.f4625h + "\"", null, null);
                } else {
                    sb.append("Incorrect ls return: '");
                    sb.append(trim2);
                    sb.append("'\n");
                }
            } else {
                sb.append((CharSequence) sb2);
            }
            this.f4624g = this.f4623f ? j() : this.f4626i;
            StringBuilder sb3 = new StringBuilder();
            G.G(w4.c.f5418d + "/libdtool.so type " + this.f4624g, sb3, null);
            try {
                i5 = Integer.parseInt(sb3.toString().trim());
            } catch (Exception unused) {
                i5 = 100;
            }
            sb3.setLength(0);
            sb3.append("mount");
            if (i5 == 1) {
                sb3.append(" -t vfat");
            } else if (i5 == 2) {
                sb3.append(" -t exfat");
            } else if (i5 == 3) {
                sb3.append(" -t ntfs");
            } else if (i5 == 4) {
                sb3.append(" -t ext4");
            } else if (i5 == 5) {
                sb3.append(" -t udf");
            } else if (i5 != 50) {
                switch (i5) {
                    case 52:
                        sb3.append(" -t hfs");
                        break;
                    case 53:
                        sb3.append(" -t hfsp");
                        break;
                    case 54:
                        sb3.append(" -t hfsx");
                        break;
                    case 55:
                        sb3.append(" -t apfs");
                        break;
                    default:
                        sb.append("Unknown file system\n");
                        break;
                }
            } else {
                sb3.append(" -t f2fs");
            }
            sb3.append(" -o nosuid,nodev,noexec,noatime");
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                sb3.append(",context=\\\"u:object_r:sdcardfs:s0");
                if (Build.VERSION.SDK_INT >= 30) {
                    StringBuilder sb4 = new StringBuilder();
                    if (G.G("ls -Z1d \"" + w4.c.f5419e + "/DCIM\"", sb4, null) == 0 && (indexOf = (trim = sb4.toString().trim()).indexOf(32)) > 0) {
                        String[] b03 = j.b0(trim.substring(0, indexOf), ":");
                        if (b03.length == 5) {
                            sb3.append(':');
                            sb3.append(b03[4]);
                        }
                    }
                }
                sb3.append("\\\",uid=0,gid=9997,fmask=0117,dmask=0006");
            }
            if ((this.f4619b & 1) != 0) {
                sb3.append(",ro");
            }
            sb3.append(" \"");
            sb3.append(this.f4624g);
            sb3.append("\" \"");
            sb3.append(this.f4625h);
            sb3.append("\"");
            if (G.G(sb3.toString(), sb, new h0.h(20)) == 0) {
                G.close();
                return true;
            }
            if (this.f4625h != null) {
                G.G("rmdir \"" + this.f4625h + "\"", null, new h0.h(21));
                this.f4625h = null;
            }
            int G2 = G.G(w4.c.f5418d + "/libdtool.so busy " + this.f4624g, null, null);
            this.f4624g = null;
            if (G2 == 0) {
                G.close();
                return false;
            }
            throw new BlockDevice.BlockException(-113, "");
        } finally {
            G.close();
        }
    }

    public final void I() {
        h G;
        if ((this.f4624g != null || this.f4623f) && (G = w4.c.G(true)) != null) {
            try {
                if (this.f4624g != null) {
                    if (G.G("umount \"" + this.f4624g + "\"", null, new h0.h(22)) == 0) {
                        this.f4624g = null;
                        if (this.f4625h != null) {
                            G.G("rmdir \"" + this.f4625h + "\"", null, new h0.h(23));
                            this.f4625h = null;
                        }
                    }
                }
                if (this.f4623f) {
                    if (G.G(w4.c.f5418d + "/libcryptsetup.so close " + G(), null, new h0.h(24)) == 0) {
                        this.f4623f = false;
                    }
                }
            } finally {
                G.close();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        I();
    }

    public final String j() {
        return "/dev/mapper/" + G();
    }

    @Override // ru.zdevs.zugate.jni.d
    public final int q() {
        return this.f4622e;
    }

    @Override // ru.zdevs.zugate.jni.d
    public final String z(int i5) {
        return null;
    }
}
