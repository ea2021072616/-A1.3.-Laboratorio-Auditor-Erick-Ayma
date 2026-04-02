package com.flurry.sdk;

import com.flurry.sdk.kz;
import com.flurry.sdk.lb;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class la {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f2127a = 50;
    private static final String d = la.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    String f2128b;

    /* renamed from: c  reason: collision with root package name */
    LinkedHashMap<String, List<String>> f2129c;

    public la(String str) {
        this.f2128b = str + "Main";
        b(this.f2128b);
    }

    private void b(String str) {
        this.f2129c = new LinkedHashMap<>();
        ArrayList<String> arrayList = new ArrayList();
        if (c(str)) {
            List<String> d2 = d(str);
            if (d2 != null && d2.size() > 0) {
                arrayList.addAll(d2);
                for (String str2 : arrayList) {
                    e(str2);
                }
            }
            f(str);
        } else {
            List<lb> list = (List) new kf(jy.a().f2022a.getFileStreamPath(g(this.f2128b)), str, 1, new lj<List<lb>>() { // from class: com.flurry.sdk.la.1
                @Override // com.flurry.sdk.lj
                public final lg<List<lb>> a(int i) {
                    return new lf(new lb.a());
                }
            }).a();
            if (list == null) {
                km.c(d, "New main file also not found. returning..");
                return;
            }
            for (lb lbVar : list) {
                arrayList.add(lbVar.f2137a);
            }
        }
        for (String str3 : arrayList) {
            this.f2129c.put(str3, h(str3));
        }
    }

    private synchronized boolean c(String str) {
        File fileStreamPath;
        fileStreamPath = jy.a().f2022a.getFileStreamPath(".FlurrySenderIndex.info." + str);
        km.a(5, d, "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        return fileStreamPath.exists();
    }

    private synchronized List<String> d(String str) {
        ArrayList arrayList;
        DataInputStream dataInputStream;
        Throwable th;
        int readUnsignedShort;
        ArrayList arrayList2 = null;
        synchronized (this) {
            ly.b();
            km.a(5, d, "Reading Index File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(".FlurrySenderIndex.info." + str));
            File fileStreamPath = jy.a().f2022a.getFileStreamPath(".FlurrySenderIndex.info." + str);
            if (fileStreamPath.exists()) {
                km.a(5, d, "Reading Index File for " + str + " Found file.");
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        readUnsignedShort = dataInputStream.readUnsignedShort();
                    } catch (Throwable th2) {
                        arrayList = null;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    dataInputStream = null;
                    arrayList = null;
                    th = th3;
                }
                if (readUnsignedShort == 0) {
                    ly.a((Closeable) dataInputStream);
                } else {
                    arrayList = new ArrayList(readUnsignedShort);
                    for (int i = 0; i < readUnsignedShort; i++) {
                        try {
                            int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                            km.a(4, d, "read iter " + i + " dataLength = " + readUnsignedShort2);
                            byte[] bArr = new byte[readUnsignedShort2];
                            dataInputStream.readFully(bArr);
                            arrayList.add(new String(bArr));
                        } catch (Throwable th4) {
                            th = th4;
                            km.a(6, d, "Error when loading persistent file", th);
                            ly.a((Closeable) dataInputStream);
                            arrayList2 = arrayList;
                            return arrayList2;
                        }
                    }
                    dataInputStream.readUnsignedShort();
                    ly.a((Closeable) dataInputStream);
                }
            } else {
                km.a(5, d, "Agent cache file doesn't exist.");
                arrayList = null;
            }
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    private void e(String str) {
        List<String> d2 = d(str);
        if (d2 == null) {
            km.c(d, "No old file to replace");
            return;
        }
        for (String str2 : d2) {
            byte[] i = i(str2);
            if (i == null) {
                km.a(6, d, "File does not exist");
            } else {
                a(str2, i);
                ly.b();
                km.a(5, d, "Deleting  block File for " + str2 + " file name:" + jy.a().f2022a.getFileStreamPath(".flurrydatasenderblock." + str2));
                File fileStreamPath = jy.a().f2022a.getFileStreamPath(".flurrydatasenderblock." + str2);
                if (fileStreamPath.exists()) {
                    km.a(5, d, "Found file for " + str2 + ". Deleted - " + fileStreamPath.delete());
                }
            }
        }
        a(str, d2, ".YFlurrySenderIndex.info.");
        f(str);
    }

    private static void f(String str) {
        ly.b();
        km.a(5, d, "Deleting Index File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(".FlurrySenderIndex.info." + str));
        File fileStreamPath = jy.a().f2022a.getFileStreamPath(".FlurrySenderIndex.info." + str);
        if (fileStreamPath.exists()) {
            km.a(5, d, "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    private static String g(String str) {
        return ".YFlurrySenderIndex.info." + str;
    }

    private synchronized List<String> h(String str) {
        ArrayList arrayList;
        ly.b();
        km.a(5, d, "Reading Index File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(g(str)));
        arrayList = new ArrayList();
        for (lb lbVar : (List) new kf(jy.a().f2022a.getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new lj<List<lb>>() { // from class: com.flurry.sdk.la.2
            @Override // com.flurry.sdk.lj
            public final lg<List<lb>> a(int i) {
                return new lf(new lb.a());
            }
        }).a()) {
            arrayList.add(lbVar.f2137a);
        }
        return arrayList;
    }

    private static byte[] i(String str) {
        DataInputStream dataInputStream;
        byte[] bArr = null;
        ly.b();
        km.a(5, d, "Reading block File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(".flurrydatasenderblock." + str));
        File fileStreamPath = jy.a().f2022a.getFileStreamPath(".flurrydatasenderblock." + str);
        if (fileStreamPath.exists()) {
            km.a(5, d, "Reading Index File for " + str + " Found file.");
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort != 0) {
                        bArr = new byte[readUnsignedShort];
                        dataInputStream.readFully(bArr);
                        dataInputStream.readUnsignedShort();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        km.a(6, d, "Error when loading persistent file", th);
                        return bArr;
                    } finally {
                        ly.a((Closeable) dataInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
            }
        } else {
            km.a(4, d, "Agent cache file doesn't exist.");
        }
        return bArr;
    }

    private synchronized void a(String str, byte[] bArr) {
        ly.b();
        km.a(5, d, "Saving Block File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(kz.a(str)));
        new kf(jy.a().f2022a.getFileStreamPath(kz.a(str)), ".yflurrydatasenderblock.", 1, new lj<kz>() { // from class: com.flurry.sdk.la.3
            @Override // com.flurry.sdk.lj
            public final lg<kz> a(int i) {
                return new kz.a();
            }
        }).a(new kz(bArr));
    }

    private synchronized void a(String str, List<String> list, String str2) {
        ly.b();
        km.a(5, d, "Saving Index File for " + str + " file name:" + jy.a().f2022a.getFileStreamPath(g(str)));
        kf kfVar = new kf(jy.a().f2022a.getFileStreamPath(g(str)), str2, 1, new lj<List<lb>>() { // from class: com.flurry.sdk.la.4
            @Override // com.flurry.sdk.lj
            public final lg<List<lb>> a(int i) {
                return new lf(new lb.a());
            }
        });
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            arrayList.add(new lb(str3));
        }
        kfVar.a(arrayList);
    }

    public final synchronized void a(kz kzVar, String str) {
        LinkedList linkedList;
        boolean z = false;
        synchronized (this) {
            km.a(4, d, "addBlockInfo" + str);
            String str2 = kzVar.f2123a;
            List<String> list = this.f2129c.get(str);
            if (list == null) {
                km.a(4, d, "New Data Key");
                linkedList = new LinkedList();
                z = true;
            } else {
                linkedList = list;
            }
            linkedList.add(str2);
            if (linkedList.size() > f2127a.intValue()) {
                j(linkedList.get(0));
                linkedList.remove(0);
            }
            this.f2129c.put(str, linkedList);
            a(str, linkedList, ".YFlurrySenderIndex.info.");
            if (z) {
                a();
            }
        }
    }

    private boolean j(String str) {
        return new kf(jy.a().f2022a.getFileStreamPath(kz.a(str)), ".yflurrydatasenderblock.", 1, new lj<kz>() { // from class: com.flurry.sdk.la.5
            @Override // com.flurry.sdk.lj
            public final lg<kz> a(int i) {
                return new kz.a();
            }
        }).b();
    }

    private synchronized void a() {
        LinkedList linkedList = new LinkedList(this.f2129c.keySet());
        new kf(jy.a().f2022a.getFileStreamPath(g(this.f2128b)), ".YFlurrySenderIndex.info.", 1, new lj<List<lb>>() { // from class: com.flurry.sdk.la.6
            @Override // com.flurry.sdk.lj
            public final lg<List<lb>> a(int i) {
                return new lf(new lb.a());
            }
        }).b();
        if (!linkedList.isEmpty()) {
            a(this.f2128b, linkedList, this.f2128b);
        }
    }

    public final boolean a(String str, String str2) {
        List<String> list = this.f2129c.get(str2);
        boolean z = false;
        if (list != null) {
            j(str);
            z = list.remove(str);
        }
        if (list != null && !list.isEmpty()) {
            this.f2129c.put(str2, list);
            a(str2, list, ".YFlurrySenderIndex.info.");
        } else {
            k(str2);
        }
        return z;
    }

    private synchronized boolean k(String str) {
        boolean b2;
        ly.b();
        kf kfVar = new kf(jy.a().f2022a.getFileStreamPath(g(str)), ".YFlurrySenderIndex.info.", 1, new lj<List<lb>>() { // from class: com.flurry.sdk.la.7
            @Override // com.flurry.sdk.lj
            public final lg<List<lb>> a(int i) {
                return new lf(new lb.a());
            }
        });
        List<String> a2 = a(str);
        if (a2 != null) {
            km.a(4, d, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a2.size());
            for (String str2 : a2) {
                j(str2);
                km.a(4, d, "discardOutdatedBlocksForDataKey: removed block = " + str2);
            }
        }
        this.f2129c.remove(str);
        b2 = kfVar.b();
        a();
        return b2;
    }

    public final List<String> a(String str) {
        return this.f2129c.get(str);
    }
}
