package com.google.android.gms.internal.play_billing;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum EF0 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: c  reason: collision with root package name */
    public static final h0 f1877c;

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f1878d;

    /* renamed from: e  reason: collision with root package name */
    public static final h0[] f1879e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ h0[] f1880f;

    /* renamed from: b  reason: collision with root package name */
    public final int f1881b;
    /* JADX INFO: Fake field, exist only in values array */
    h0 EF0;

    static {
        v0 v0Var = v0.DOUBLE;
        h0 h0Var = new h0("DOUBLE", 0, 0, 1, v0Var);
        v0 v0Var2 = v0.FLOAT;
        h0 h0Var2 = new h0("FLOAT", 1, 1, 1, v0Var2);
        v0 v0Var3 = v0.LONG;
        h0 h0Var3 = new h0("INT64", 2, 2, 1, v0Var3);
        h0 h0Var4 = new h0("UINT64", 3, 3, 1, v0Var3);
        v0 v0Var4 = v0.INT;
        h0 h0Var5 = new h0("INT32", 4, 4, 1, v0Var4);
        h0 h0Var6 = new h0("FIXED64", 5, 5, 1, v0Var3);
        h0 h0Var7 = new h0("FIXED32", 6, 6, 1, v0Var4);
        v0 v0Var5 = v0.BOOLEAN;
        h0 h0Var8 = new h0("BOOL", 7, 7, 1, v0Var5);
        v0 v0Var6 = v0.STRING;
        h0 h0Var9 = new h0("STRING", 8, 8, 1, v0Var6);
        v0 v0Var7 = v0.MESSAGE;
        h0 h0Var10 = new h0("MESSAGE", 9, 9, 1, v0Var7);
        v0 v0Var8 = v0.BYTE_STRING;
        h0 h0Var11 = new h0("BYTES", 10, 10, 1, v0Var8);
        h0 h0Var12 = new h0("UINT32", 11, 11, 1, v0Var4);
        v0 v0Var9 = v0.ENUM;
        h0 h0Var13 = new h0("ENUM", 12, 12, 1, v0Var9);
        h0 h0Var14 = new h0("SFIXED32", 13, 13, 1, v0Var4);
        h0 h0Var15 = new h0("SFIXED64", 14, 14, 1, v0Var3);
        h0 h0Var16 = new h0("SINT32", 15, 15, 1, v0Var4);
        h0 h0Var17 = new h0("SINT64", 16, 16, 1, v0Var3);
        h0 h0Var18 = new h0("GROUP", 17, 17, 1, v0Var7);
        h0 h0Var19 = new h0("DOUBLE_LIST", 18, 18, 2, v0Var);
        h0 h0Var20 = new h0("FLOAT_LIST", 19, 19, 2, v0Var2);
        h0 h0Var21 = new h0("INT64_LIST", 20, 20, 2, v0Var3);
        h0 h0Var22 = new h0("UINT64_LIST", 21, 21, 2, v0Var3);
        h0 h0Var23 = new h0("INT32_LIST", 22, 22, 2, v0Var4);
        h0 h0Var24 = new h0("FIXED64_LIST", 23, 23, 2, v0Var3);
        h0 h0Var25 = new h0("FIXED32_LIST", 24, 24, 2, v0Var4);
        h0 h0Var26 = new h0("BOOL_LIST", 25, 25, 2, v0Var5);
        h0 h0Var27 = new h0("STRING_LIST", 26, 26, 2, v0Var6);
        h0 h0Var28 = new h0("MESSAGE_LIST", 27, 27, 2, v0Var7);
        h0 h0Var29 = new h0("BYTES_LIST", 28, 28, 2, v0Var8);
        h0 h0Var30 = new h0("UINT32_LIST", 29, 29, 2, v0Var4);
        h0 h0Var31 = new h0("ENUM_LIST", 30, 30, 2, v0Var9);
        h0 h0Var32 = new h0("SFIXED32_LIST", 31, 31, 2, v0Var4);
        h0 h0Var33 = new h0("SFIXED64_LIST", 32, 32, 2, v0Var3);
        h0 h0Var34 = new h0("SINT32_LIST", 33, 33, 2, v0Var4);
        h0 h0Var35 = new h0("SINT64_LIST", 34, 34, 2, v0Var3);
        h0 h0Var36 = new h0("DOUBLE_LIST_PACKED", 35, 35, 3, v0Var);
        f1877c = h0Var36;
        h0 h0Var37 = new h0("FLOAT_LIST_PACKED", 36, 36, 3, v0Var2);
        h0 h0Var38 = new h0("INT64_LIST_PACKED", 37, 37, 3, v0Var3);
        h0 h0Var39 = new h0("UINT64_LIST_PACKED", 38, 38, 3, v0Var3);
        h0 h0Var40 = new h0("INT32_LIST_PACKED", 39, 39, 3, v0Var4);
        h0 h0Var41 = new h0("FIXED64_LIST_PACKED", 40, 40, 3, v0Var3);
        h0 h0Var42 = new h0("FIXED32_LIST_PACKED", 41, 41, 3, v0Var4);
        h0 h0Var43 = new h0("BOOL_LIST_PACKED", 42, 42, 3, v0Var5);
        h0 h0Var44 = new h0("UINT32_LIST_PACKED", 43, 43, 3, v0Var4);
        h0 h0Var45 = new h0("ENUM_LIST_PACKED", 44, 44, 3, v0Var9);
        h0 h0Var46 = new h0("SFIXED32_LIST_PACKED", 45, 45, 3, v0Var4);
        h0 h0Var47 = new h0("SFIXED64_LIST_PACKED", 46, 46, 3, v0Var3);
        h0 h0Var48 = new h0("SINT32_LIST_PACKED", 47, 47, 3, v0Var4);
        h0 h0Var49 = new h0("SINT64_LIST_PACKED", 48, 48, 3, v0Var3);
        f1878d = h0Var49;
        f1880f = new h0[]{h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8, h0Var9, h0Var10, h0Var11, h0Var12, h0Var13, h0Var14, h0Var15, h0Var16, h0Var17, h0Var18, h0Var19, h0Var20, h0Var21, h0Var22, h0Var23, h0Var24, h0Var25, h0Var26, h0Var27, h0Var28, h0Var29, h0Var30, h0Var31, h0Var32, h0Var33, h0Var34, h0Var35, h0Var36, h0Var37, h0Var38, h0Var39, h0Var40, h0Var41, h0Var42, h0Var43, h0Var44, h0Var45, h0Var46, h0Var47, h0Var48, h0Var49, new h0("GROUP_LIST", 49, 49, 2, v0Var7), new h0("MAP", 50, 50, 4, v0.VOID)};
        h0[] values = values();
        f1879e = new h0[values.length];
        for (h0 h0Var50 : values) {
            f1879e[h0Var50.f1881b] = h0Var50;
        }
    }

    public h0(String str, int i5, int i6, int i7, v0 v0Var) {
        this.f1881b = i6;
        int i8 = i7 - 1;
        if (i8 == 1) {
            v0Var.getClass();
        } else if (i8 == 3) {
            v0Var.getClass();
        }
        if (i7 == 1) {
            v0 v0Var2 = v0.VOID;
            v0Var.ordinal();
        }
    }

    public static h0[] values() {
        return (h0[]) f1880f.clone();
    }

    public final int a() {
        return this.f1881b;
    }
}
