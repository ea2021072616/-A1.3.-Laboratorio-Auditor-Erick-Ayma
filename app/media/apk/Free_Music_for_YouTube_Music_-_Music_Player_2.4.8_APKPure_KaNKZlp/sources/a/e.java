package a;

import java.util.Locale;
/* compiled from: CancellationToken.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final g f13a;

    public boolean a() {
        return this.f13a.a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f13a.a()));
    }
}
