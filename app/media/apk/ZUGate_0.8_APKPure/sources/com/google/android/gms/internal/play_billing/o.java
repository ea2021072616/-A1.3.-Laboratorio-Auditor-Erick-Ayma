package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public final class o extends h {

    /* renamed from: h  reason: collision with root package name */
    public static final o f1933h = new o(0, null, new Object[0]);

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f1934e;

    /* renamed from: f  reason: collision with root package name */
    public final transient Object[] f1935f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f1936g;

    public o(int i5, Object obj, Object[] objArr) {
        this.f1934e = obj;
        this.f1935f = objArr;
        this.f1936g = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, int[]] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public static o a(int i5, Object[] objArr, y.c cVar) {
        int i6;
        short[] sArr;
        int i7 = i5;
        Object[] objArr2 = objArr;
        if (i7 == 0) {
            return f1933h;
        }
        Object obj = null;
        if (i7 == 1) {
            Objects.requireNonNull(objArr2[0]);
            Objects.requireNonNull(objArr2[1]);
            return new o(1, null, objArr2);
        }
        b4.j.s0(i7, objArr2.length >> 1);
        int max = Math.max(i7, 2);
        if (max < 751619276) {
            i6 = Integer.highestOneBit(max - 1);
            do {
                i6 += i6;
            } while (i6 * 0.7d < max);
        } else {
            i6 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i7 == 1) {
            Objects.requireNonNull(objArr2[0]);
            Objects.requireNonNull(objArr2[1]);
            i7 = 1;
        } else {
            int i8 = i6 - 1;
            char c5 = 65535;
            if (i6 <= 128) {
                byte[] bArr = new byte[i6];
                Arrays.fill(bArr, (byte) -1);
                int i9 = 0;
                for (int i10 = 0; i10 < i7; i10++) {
                    int i11 = i9 + i9;
                    int i12 = i10 + i10;
                    Object obj2 = objArr2[i12];
                    Objects.requireNonNull(obj2);
                    Object obj3 = objArr2[i12 ^ 1];
                    Objects.requireNonNull(obj3);
                    int V = i0.V(obj2.hashCode());
                    while (true) {
                        int i13 = V & i8;
                        int i14 = bArr[i13] & 255;
                        if (i14 == 255) {
                            bArr[i13] = (byte) i11;
                            if (i9 < i10) {
                                objArr2[i11] = obj2;
                                objArr2[i11 ^ 1] = obj3;
                            }
                            i9++;
                        } else if (obj2.equals(objArr2[i14])) {
                            int i15 = i14 ^ 1;
                            Object obj4 = objArr2[i15];
                            Objects.requireNonNull(obj4);
                            obj = new g(obj2, obj3, obj4);
                            objArr2[i15] = obj3;
                            break;
                        } else {
                            V = i13 + 1;
                        }
                    }
                }
                obj = i9 == i7 ? bArr : new Object[]{bArr, Integer.valueOf(i9), obj};
            } else if (i6 <= 32768) {
                sArr = new short[i6];
                Arrays.fill(sArr, (short) -1);
                int i16 = 0;
                for (int i17 = 0; i17 < i7; i17++) {
                    int i18 = i16 + i16;
                    int i19 = i17 + i17;
                    Object obj5 = objArr2[i19];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArr2[i19 ^ 1];
                    Objects.requireNonNull(obj6);
                    int V2 = i0.V(obj5.hashCode());
                    while (true) {
                        int i20 = V2 & i8;
                        char c6 = (char) sArr[i20];
                        if (c6 == 65535) {
                            sArr[i20] = (short) i18;
                            if (i16 < i17) {
                                objArr2[i18] = obj5;
                                objArr2[i18 ^ 1] = obj6;
                            }
                            i16++;
                        } else if (obj5.equals(objArr2[c6])) {
                            int i21 = c6 ^ 1;
                            Object obj7 = objArr2[i21];
                            Objects.requireNonNull(obj7);
                            g gVar = new g(obj5, obj6, obj7);
                            objArr2[i21] = obj6;
                            obj = gVar;
                            break;
                        } else {
                            V2 = i20 + 1;
                        }
                    }
                }
                if (i16 != i7) {
                    obj = new Object[]{sArr, Integer.valueOf(i16), obj};
                }
                obj = sArr;
            } else {
                sArr = new int[i6];
                Arrays.fill((int[]) sArr, -1);
                int i22 = 0;
                int i23 = 0;
                while (i22 < i7) {
                    int i24 = i23 + i23;
                    int i25 = i22 + i22;
                    Object obj8 = objArr2[i25];
                    Objects.requireNonNull(obj8);
                    Object obj9 = objArr2[i25 ^ 1];
                    Objects.requireNonNull(obj9);
                    int V3 = i0.V(obj8.hashCode());
                    while (true) {
                        int i26 = V3 & i8;
                        ?? r15 = sArr[i26];
                        if (r15 == c5) {
                            sArr[i26] = i24;
                            if (i23 < i22) {
                                objArr2[i24] = obj8;
                                objArr2[i24 ^ 1] = obj9;
                            }
                            i23++;
                        } else if (obj8.equals(objArr2[r15])) {
                            int i27 = r15 ^ 1;
                            Object obj10 = objArr2[i27];
                            Objects.requireNonNull(obj10);
                            g gVar2 = new g(obj8, obj9, obj10);
                            objArr2[i27] = obj9;
                            obj = gVar2;
                            break;
                        } else {
                            V3 = i26 + 1;
                            c5 = 65535;
                        }
                    }
                    i22++;
                    c5 = 65535;
                }
                if (i23 != i7) {
                    obj = new Object[]{sArr, Integer.valueOf(i23), obj};
                }
                obj = sArr;
            }
        }
        if (obj instanceof Object[]) {
            Object[] objArr3 = (Object[]) obj;
            g gVar3 = (g) objArr3[2];
            if (cVar == null) {
                throw gVar3.a();
            }
            cVar.f5545c = gVar3;
            Object obj11 = objArr3[0];
            int intValue = ((Integer) objArr3[1]).intValue();
            objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
            obj = obj11;
            i7 = intValue;
        }
        return new o(i7, obj, objArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.play_billing.h, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            r1 = 1
            int r2 = r9.f1936g
            java.lang.Object[] r3 = r9.f1935f
            if (r2 != r1) goto L20
            r2 = 0
            r2 = r3[r2]
            java.util.Objects.requireNonNull(r2)
            boolean r10 = r2.equals(r10)
            if (r10 == 0) goto L3
            r10 = r3[r1]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r2 = r9.f1934e
            if (r2 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r2 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r2
            byte[] r4 = (byte[]) r4
            int r2 = r4.length
            int r6 = r2 + (-1)
            int r2 = r10.hashCode()
            int r2 = com.google.android.gms.internal.play_billing.i0.V(r2)
        L38:
            r2 = r2 & r6
            r5 = r4[r2]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r3[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r3[r10]
            goto L9c
        L4e:
            int r2 = r2 + 1
            goto L38
        L51:
            boolean r4 = r2 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r2
            short[] r4 = (short[]) r4
            int r2 = r4.length
            int r6 = r2 + (-1)
            int r2 = r10.hashCode()
            int r2 = com.google.android.gms.internal.play_billing.i0.V(r2)
        L63:
            r2 = r2 & r6
            short r5 = r4[r2]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r3[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r3[r10]
            goto L9c
        L7a:
            int r2 = r2 + 1
            goto L63
        L7d:
            int[] r2 = (int[]) r2
            int r4 = r2.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.i0.V(r6)
        L89:
            r6 = r6 & r4
            r7 = r2[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r3[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r3[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.o.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f1936g;
    }
}
