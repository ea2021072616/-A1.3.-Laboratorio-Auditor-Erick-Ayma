package com.google.android.gms.internal;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zznbs uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public class zzefz {
    public static final zzefz zznbk = new zzefz("DOUBLE", 0, zzege.DOUBLE, 1);
    public static final zzefz zznbl = new zzefz("FLOAT", 1, zzege.FLOAT, 5);
    public static final zzefz zznbm = new zzefz("INT64", 2, zzege.LONG, 0);
    public static final zzefz zznbn = new zzefz("UINT64", 3, zzege.LONG, 0);
    public static final zzefz zznbo = new zzefz("INT32", 4, zzege.INT, 0);
    public static final zzefz zznbp = new zzefz("FIXED64", 5, zzege.LONG, 1);
    public static final zzefz zznbq = new zzefz("FIXED32", 6, zzege.INT, 5);
    public static final zzefz zznbr = new zzefz("BOOL", 7, zzege.BOOLEAN, 0);
    public static final zzefz zznbs;
    public static final zzefz zznbt;
    public static final zzefz zznbu;
    public static final zzefz zznbv;
    public static final zzefz zznbw;
    public static final zzefz zznbx;
    public static final zzefz zznby;
    public static final zzefz zznbz;
    public static final zzefz zznca;
    public static final zzefz zzncb;
    private static final /* synthetic */ zzefz[] zznce;
    private final zzege zzncc;
    private final int zzncd;

    static {
        final zzege zzegeVar = zzege.STRING;
        zznbs = new zzefz("STRING", 8, zzegeVar, 2) { // from class: com.google.android.gms.internal.zzega
        };
        final zzege zzegeVar2 = zzege.MESSAGE;
        zznbt = new zzefz("GROUP", 9, zzegeVar2, 3) { // from class: com.google.android.gms.internal.zzegb
        };
        final zzege zzegeVar3 = zzege.MESSAGE;
        zznbu = new zzefz("MESSAGE", 10, zzegeVar3, 2) { // from class: com.google.android.gms.internal.zzegc
        };
        final zzege zzegeVar4 = zzege.BYTE_STRING;
        zznbv = new zzefz("BYTES", 11, zzegeVar4, 2) { // from class: com.google.android.gms.internal.zzegd
        };
        zznbw = new zzefz("UINT32", 12, zzege.INT, 0);
        zznbx = new zzefz("ENUM", 13, zzege.ENUM, 0);
        zznby = new zzefz("SFIXED32", 14, zzege.INT, 5);
        zznbz = new zzefz("SFIXED64", 15, zzege.LONG, 1);
        zznca = new zzefz("SINT32", 16, zzege.INT, 0);
        zzncb = new zzefz("SINT64", 17, zzege.LONG, 0);
        zznce = new zzefz[]{zznbk, zznbl, zznbm, zznbn, zznbo, zznbp, zznbq, zznbr, zznbs, zznbt, zznbu, zznbv, zznbw, zznbx, zznby, zznbz, zznca, zzncb};
    }

    private zzefz(String str, int i, zzege zzegeVar, int i2) {
        this.zzncc = zzegeVar;
        this.zzncd = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzefz(String str, int i, zzege zzegeVar, int i2, zzefy zzefyVar) {
        this(str, i, zzegeVar, i2);
    }

    public static zzefz[] values() {
        return (zzefz[]) zznce.clone();
    }

    public final zzege zzcdq() {
        return this.zzncc;
    }
}
