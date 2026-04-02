package rx.internal.b;

import rx.h;
/* compiled from: ProducerArbiter.java */
/* loaded from: classes2.dex */
public final class a implements h {
    static final h g = new h() { // from class: rx.internal.b.a.1
        @Override // rx.h
        public void request(long j) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    long f5472a;

    /* renamed from: b  reason: collision with root package name */
    h f5473b;

    /* renamed from: c  reason: collision with root package name */
    boolean f5474c;
    long d;
    long e;
    h f;

    @Override // rx.h
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0) {
            synchronized (this) {
                if (this.f5474c) {
                    this.d += j;
                } else {
                    this.f5474c = true;
                    try {
                        long j2 = this.f5472a + j;
                        if (j2 < 0) {
                            j2 = Long.MAX_VALUE;
                        }
                        this.f5472a = j2;
                        h hVar = this.f5473b;
                        if (hVar != null) {
                            hVar.request(j);
                        }
                        a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f5474c = false;
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.f5474c) {
                this.e += j;
                return;
            }
            this.f5474c = true;
            try {
                long j2 = this.f5472a;
                if (j2 != Long.MAX_VALUE) {
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.f5472a = j3;
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f5474c = false;
                    throw th;
                }
            }
        }
    }

    public void a(h hVar) {
        synchronized (this) {
            if (this.f5474c) {
                if (hVar == null) {
                    hVar = g;
                }
                this.f = hVar;
                return;
            }
            this.f5474c = true;
            try {
                this.f5473b = hVar;
                if (hVar != null) {
                    hVar.request(this.f5472a);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f5474c = false;
                    throw th;
                }
            }
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j = this.d;
                long j2 = this.e;
                h hVar = this.f;
                if (j == 0 && j2 == 0 && hVar == null) {
                    this.f5474c = false;
                    return;
                }
                this.d = 0L;
                this.e = 0L;
                this.f = null;
                long j3 = this.f5472a;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f5472a = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.f5472a = j3;
                    }
                }
                if (hVar != null) {
                    if (hVar == g) {
                        this.f5473b = null;
                    } else {
                        this.f5473b = hVar;
                        hVar.request(j3);
                    }
                } else {
                    h hVar2 = this.f5473b;
                    if (hVar2 != null && j != 0) {
                        hVar2.request(j);
                    }
                }
            }
        }
    }
}
