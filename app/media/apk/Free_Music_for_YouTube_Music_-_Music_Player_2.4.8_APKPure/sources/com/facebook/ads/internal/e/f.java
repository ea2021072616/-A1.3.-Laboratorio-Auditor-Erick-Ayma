package com.facebook.ads.internal.e;

import com.facebook.ads.AdError;
/* loaded from: classes.dex */
abstract class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private a f1301a;

    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN(9000, "An unknown error has occurred."),
        DATABASE_SELECT(AdError.MEDIATION_ERROR_CODE, "Failed to read from database."),
        DATABASE_INSERT(3002, "Failed to insert row into database."),
        DATABASE_UPDATE(3003, "Failed to update row in database."),
        DATABASE_DELETE(3004, "Failed to delete row from database.");
        
        private final int f;
        private final String g;

        a(int i, String str) {
            this.f = i;
            this.g = str;
        }

        public int a() {
            return this.f;
        }

        public String b() {
            return this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.f1301a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b();

    public a c() {
        return this.f1301a;
    }
}
