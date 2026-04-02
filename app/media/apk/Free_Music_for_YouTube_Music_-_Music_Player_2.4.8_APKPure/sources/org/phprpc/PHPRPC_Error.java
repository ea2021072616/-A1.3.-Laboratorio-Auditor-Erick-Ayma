package org.phprpc;
/* loaded from: classes2.dex */
public final class PHPRPC_Error extends Exception {
    private int __errno;
    private String __errstr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PHPRPC_Error(int i, String str) {
        this.__errno = i;
        this.__errstr = str;
    }

    public int getNumber() {
        return this.__errno;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.__errstr;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.__errno + ":" + this.__errstr;
    }
}
