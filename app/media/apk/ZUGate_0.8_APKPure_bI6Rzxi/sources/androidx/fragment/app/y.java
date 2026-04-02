package androidx.fragment.app;
/* loaded from: classes.dex */
public final class y extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(java.lang.String r3, android.os.Parcel r4) {
        /*
            r2 = this;
            int r0 = r4.dataPosition()
            int r4 = r4.dataSize()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r3 = " Parcel: pos="
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = " size="
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = r1.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.y.<init>(java.lang.String, android.os.Parcel):void");
    }

    public y(int i5) {
        super("Context cannot be null");
    }
}
