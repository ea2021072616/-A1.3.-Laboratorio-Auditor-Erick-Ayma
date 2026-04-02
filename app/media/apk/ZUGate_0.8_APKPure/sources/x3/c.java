package x3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import v3.f;
import v3.g;
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f5497a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        f5497a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override // v3.a
    public final void a(Object obj, Object obj2) {
        ((g) obj2).a(f5497a.format((Date) obj));
    }
}
