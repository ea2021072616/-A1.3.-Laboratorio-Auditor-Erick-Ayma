package b.a.a.a.a.c;
/* compiled from: Priority.java */
/* loaded from: classes.dex */
public enum e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Y> int a(i iVar, Y y) {
        e eVar;
        if (y instanceof i) {
            eVar = ((i) y).getPriority();
        } else {
            eVar = NORMAL;
        }
        return eVar.ordinal() - iVar.getPriority().ordinal();
    }
}
