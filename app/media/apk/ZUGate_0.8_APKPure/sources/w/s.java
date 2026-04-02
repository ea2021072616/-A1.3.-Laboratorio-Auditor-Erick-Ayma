package w;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5276a;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f5280e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f5281f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f5282g;

    /* renamed from: h  reason: collision with root package name */
    public int f5283h;

    /* renamed from: j  reason: collision with root package name */
    public t f5285j;

    /* renamed from: l  reason: collision with root package name */
    public Bundle f5287l;

    /* renamed from: m  reason: collision with root package name */
    public String f5288m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f5289n;
    public final Notification o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f5290p;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f5277b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f5278c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f5279d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5284i = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5286k = false;

    public s(Context context) {
        Notification notification = new Notification();
        this.o = notification;
        this.f5276a = context;
        this.f5288m = null;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f5283h = 0;
        this.f5290p = new ArrayList();
        this.f5289n = true;
    }

    public static CharSequence a(String str) {
        return (str != null && str.length() > 5120) ? str.subSequence(0, 5120) : str;
    }

    public final void b(r rVar) {
        if (this.f5285j != rVar) {
            this.f5285j = rVar;
            if (rVar.f5291a != this) {
                rVar.f5291a = this;
                b(rVar);
            }
        }
    }
}
