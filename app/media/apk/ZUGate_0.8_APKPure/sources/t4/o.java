package t4;

import java.util.List;
import ru.zdevs.zugate.USBGateService;
/* loaded from: classes.dex */
public final class o extends x4.l {

    /* renamed from: f  reason: collision with root package name */
    public final USBGateService f5073f;

    /* renamed from: g  reason: collision with root package name */
    public final a f5074g;

    /* renamed from: h  reason: collision with root package name */
    public final y4.j f5075h;

    /* renamed from: i  reason: collision with root package name */
    public final i f5076i;

    /* renamed from: j  reason: collision with root package name */
    public d.n f5077j;

    public o(List list, USBGateService uSBGateService, int i5, a aVar, y4.j jVar, int i6) {
        super(list);
        this.f5073f = uSBGateService;
        this.f5074g = aVar;
        this.f5075h = jVar;
        this.f5076i = new i(i5, aVar, i6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[Catch: all -> 0x008f, TRY_ENTER, TryCatch #1 {Exception -> 0x020b, blocks: (B:2:0x0000, B:7:0x0014, B:54:0x0118, B:56:0x011e, B:57:0x0121, B:74:0x01c3, B:79:0x01f6, B:83:0x0205, B:82:0x0201, B:75:0x01d3, B:76:0x01e3, B:58:0x0125, B:59:0x0136, B:60:0x0141, B:61:0x014c, B:62:0x0157, B:63:0x0162, B:64:0x0173, B:65:0x0184, B:66:0x018e, B:67:0x0198, B:68:0x01a2, B:69:0x01ac, B:9:0x0019, B:11:0x0033, B:12:0x0043, B:16:0x0056, B:17:0x0058, B:29:0x008b, B:22:0x0070, B:23:0x0077, B:27:0x0087, B:34:0x0092, B:36:0x00a2, B:37:0x00aa, B:39:0x00be, B:41:0x00d5, B:43:0x00d9, B:44:0x00e4, B:46:0x00e8, B:47:0x00f5, B:51:0x00fe, B:53:0x010a, B:24:0x0078, B:25:0x0084), top: B:91:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e A[Catch: Exception -> 0x020b, TryCatch #1 {Exception -> 0x020b, blocks: (B:2:0x0000, B:7:0x0014, B:54:0x0118, B:56:0x011e, B:57:0x0121, B:74:0x01c3, B:79:0x01f6, B:83:0x0205, B:82:0x0201, B:75:0x01d3, B:76:0x01e3, B:58:0x0125, B:59:0x0136, B:60:0x0141, B:61:0x014c, B:62:0x0157, B:63:0x0162, B:64:0x0173, B:65:0x0184, B:66:0x018e, B:67:0x0198, B:68:0x01a2, B:69:0x01ac, B:9:0x0019, B:11:0x0033, B:12:0x0043, B:16:0x0056, B:17:0x0058, B:29:0x008b, B:22:0x0070, B:23:0x0077, B:27:0x0087, B:34:0x0092, B:36:0x00a2, B:37:0x00aa, B:39:0x00be, B:41:0x00d5, B:43:0x00d9, B:44:0x00e4, B:46:0x00e8, B:47:0x00f5, B:51:0x00fe, B:53:0x010a, B:24:0x0078, B:25:0x0084), top: B:91:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f6 A[Catch: Exception -> 0x020b, TryCatch #1 {Exception -> 0x020b, blocks: (B:2:0x0000, B:7:0x0014, B:54:0x0118, B:56:0x011e, B:57:0x0121, B:74:0x01c3, B:79:0x01f6, B:83:0x0205, B:82:0x0201, B:75:0x01d3, B:76:0x01e3, B:58:0x0125, B:59:0x0136, B:60:0x0141, B:61:0x014c, B:62:0x0157, B:63:0x0162, B:64:0x0173, B:65:0x0184, B:66:0x018e, B:67:0x0198, B:68:0x01a2, B:69:0x01ac, B:9:0x0019, B:11:0x0033, B:12:0x0043, B:16:0x0056, B:17:0x0058, B:29:0x008b, B:22:0x0070, B:23:0x0077, B:27:0x0087, B:34:0x0092, B:36:0x00a2, B:37:0x00aa, B:39:0x00be, B:41:0x00d5, B:43:0x00d9, B:44:0x00e4, B:46:0x00e8, B:47:0x00f5, B:51:0x00fe, B:53:0x010a, B:24:0x0078, B:25:0x0084), top: B:91:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020f  */
    @Override // x4.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x4.a a() {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.o.a():x4.a");
    }

    @Override // x4.l
    public final int c() {
        return 1;
    }

    @Override // x4.l
    public final void e() {
        d.n nVar = this.f5077j;
        if (nVar != null) {
            nVar.dismiss();
            this.f5077j = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // x4.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.content.Context r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            t4.i r0 = r4.f5076i
            int r0 = r0.f5058a
            r1 = 1
            if (r0 == 0) goto L27
            if (r0 == r1) goto L23
            r2 = 3
            if (r0 == r2) goto L27
            r2 = 101(0x65, float:1.42E-43)
            if (r0 == r2) goto L1f
            r2 = 102(0x66, float:1.43E-43)
            if (r0 == r2) goto L1b
            r0 = 2131886196(0x7f120074, float:1.9406964E38)
            goto L2a
        L1b:
            r0 = 2131886397(0x7f12013d, float:1.9407372E38)
            goto L2a
        L1f:
            r0 = 2131886224(0x7f120090, float:1.940702E38)
            goto L2a
        L23:
            r0 = 2131886289(0x7f1200d1, float:1.9407153E38)
            goto L2a
        L27:
            r0 = 2131886182(0x7f120066, float:1.9406936E38)
        L2a:
            d.m r2 = new d.m
            r2.<init>(r5)
            r2.e(r0)
            java.lang.Object r5 = r2.f2398h
            r0 = r5
            d.i r0 = (d.i) r0
            r3 = 0
            r0.f2357t = r3
            r3 = 2131492921(0x7f0c0039, float:1.8609308E38)
            r0.f2356s = r3
            d.i r5 = (d.i) r5
            r0 = 0
            r5.f2351m = r0
            d.n r5 = r2.a()
            r4.f5077j = r5
            r5.show()
            d.n r5 = r4.f5077j
            r0 = 2131296677(0x7f0901a5, float:1.8211277E38)
            android.view.View r5 = r5.findViewById(r0)
            android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
            if (r5 == 0) goto L5d
            r5.setIndeterminate(r1)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.o.f(android.content.Context):void");
    }
}
