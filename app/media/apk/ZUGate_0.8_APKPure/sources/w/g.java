package w;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import ru.zdevs.zugate.jni.BlockDevice;
/* loaded from: classes.dex */
public final /* synthetic */ class g implements e2.b, d2.i, x4.g {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5248g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f5249h;

    public /* synthetic */ g(int i5, Object obj) {
        this.f5248g = i5;
        this.f5249h = obj;
    }

    @Override // d2.i
    public final Object a(Object obj) {
        int i5 = this.f5248g;
        Object obj2 = this.f5249h;
        switch (i5) {
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                v1.d dVar = (v1.d) obj2;
                v1.b bVar = (v1.b) obj;
                dVar.getClass();
                URL url = bVar.f5191a;
                String x5 = b4.j.x("CctTransportBackend");
                if (Log.isLoggable(x5, 4)) {
                    Log.i(x5, String.format("Making request to: %s", url));
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) bVar.f5191a.openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(dVar.f5203g);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.8"));
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                String str = bVar.f5193c;
                if (str != null) {
                    httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
                }
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        dVar.f5197a.d(bVar.f5192b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                        gZIPOutputStream.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        Integer valueOf = Integer.valueOf(responseCode);
                        String x6 = b4.j.x("CctTransportBackend");
                        if (Log.isLoggable(x6, 4)) {
                            Log.i(x6, String.format("Status Code: %d", valueOf));
                        }
                        b4.j.m("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                        b4.j.m("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                            return new v1.c(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                        }
                        if (responseCode != 200) {
                            return new v1.c(responseCode, null, 0L);
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                            v1.c cVar = new v1.c(responseCode, null, w1.n.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f5375a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return cVar;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (ConnectException e5) {
                    e = e5;
                    b4.j.n("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                    return new v1.c(500, null, 0L);
                } catch (UnknownHostException e6) {
                    e = e6;
                    b4.j.n("CctTransportBackend", "Couldn't open connection, returning with 500", e);
                    return new v1.c(500, null, 0L);
                } catch (IOException e7) {
                    e = e7;
                    b4.j.n("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                    return new v1.c(400, null, 0L);
                } catch (v3.b e8) {
                    e = e8;
                    b4.j.n("CctTransportBackend", "Couldn't encode request, returning with 400", e);
                    return new v1.c(400, null, 0L);
                }
            default:
                Map map = (Map) obj2;
                Cursor cursor = (Cursor) obj;
                u1.b bVar2 = d2.k.f2528g;
                while (cursor.moveToNext()) {
                    long j5 = cursor.getLong(0);
                    Set set = (Set) map.get(Long.valueOf(j5));
                    if (set == null) {
                        set = new HashSet();
                        map.put(Long.valueOf(j5), set);
                    }
                    set.add(new d2.j(cursor.getString(1), cursor.getString(2)));
                }
                return null;
        }
    }

    @Override // e2.b
    public final Object b() {
        int i5 = this.f5248g;
        Object obj = this.f5249h;
        switch (i5) {
            case 3:
                d2.k kVar = (d2.k) ((d2.d) obj);
                return Integer.valueOf(((Integer) kVar.H(new d2.e(kVar, ((f2.b) kVar.f2530c).a() - kVar.f2532e.f2511d))).intValue());
            case 4:
                d2.k kVar2 = (d2.k) ((c2.k) obj).f1751i;
                kVar2.getClass();
                kVar2.H(new d2.g(kVar2, 0));
                return null;
            case 5:
                d2.k kVar3 = (d2.k) ((d2.c) obj);
                kVar3.getClass();
                int i6 = a2.a.f3e;
                g.f fVar = new g.f(7);
                HashMap hashMap = new HashMap();
                SQLiteDatabase j5 = kVar3.j();
                j5.beginTransaction();
                try {
                    a2.a aVar = (a2.a) d2.k.L(j5.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new e1.h(kVar3, hashMap, fVar, 5));
                    j5.setTransactionSuccessful();
                    return aVar;
                } finally {
                    j5.endTransaction();
                }
            default:
                c2.m mVar = (c2.m) obj;
                d2.k kVar4 = (d2.k) mVar.f1761b;
                kVar4.getClass();
                for (x1.i iVar : (Iterable) kVar4.H(new h0.h(9))) {
                    ((c2.d) mVar.f1762c).a(iVar, 1, false);
                }
                return null;
        }
    }

    @Override // x4.g
    public final void d(String str) {
        int i5 = this.f5248g;
        Object obj = this.f5249h;
        switch (i5) {
            case 11:
                StringBuilder sb = (StringBuilder) obj;
                if (sb.length() != 0 || str.contains("fuse")) {
                    return;
                }
                String[] b02 = b4.j.b0(str, " ");
                if (b02.length > 2) {
                    sb.append(b02[1]);
                    sb.append("/0");
                    return;
                }
                return;
            default:
                AtomicReference atomicReference = (AtomicReference) obj;
                if (str.startsWith("No key available")) {
                    atomicReference.set(new BlockDevice.BlockException(-103, str));
                    return;
                } else if (str.endsWith("module is missing.")) {
                    atomicReference.set(new BlockDevice.BlockException(-110, str));
                    return;
                } else if (str.endsWith("(already mapped or mounted).")) {
                    atomicReference.set(new BlockDevice.BlockException(-113, str));
                    return;
                } else {
                    return;
                }
        }
    }
}
