package h0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;
/* loaded from: classes.dex */
public final class e implements d, f {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f3114g = 0;

    /* renamed from: h  reason: collision with root package name */
    public final ClipData f3115h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3116i;

    /* renamed from: j  reason: collision with root package name */
    public int f3117j;

    /* renamed from: k  reason: collision with root package name */
    public Uri f3118k;

    /* renamed from: l  reason: collision with root package name */
    public Bundle f3119l;

    public e(e eVar) {
        ClipData clipData = eVar.f3115h;
        clipData.getClass();
        this.f3115h = clipData;
        int i5 = eVar.f3116i;
        if (i5 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 5));
        }
        if (i5 <= 5) {
            this.f3116i = i5;
            int i6 = eVar.f3117j;
            if ((i6 & 1) == i6) {
                this.f3117j = i6;
                this.f3118k = eVar.f3118k;
                this.f3119l = eVar.f3119l;
                return;
            }
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i6) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 5));
    }

    @Override // h0.d
    public final g a() {
        return new g(new e(this));
    }

    @Override // h0.d
    public final void b(Bundle bundle) {
        this.f3119l = bundle;
    }

    @Override // h0.d
    public final void c(Uri uri) {
        this.f3118k = uri;
    }

    @Override // h0.d
    public final void d(int i5) {
        this.f3117j = i5;
    }

    @Override // h0.f
    public final ClipData f() {
        return this.f3115h;
    }

    @Override // h0.f
    public final int j() {
        return this.f3117j;
    }

    @Override // h0.f
    public final ContentInfo m() {
        return null;
    }

    @Override // h0.f
    public final int q() {
        return this.f3116i;
    }

    public final String toString() {
        String str;
        switch (this.f3114g) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f3115h.getDescription());
                sb.append(", source=");
                int i5 = this.f3116i;
                sb.append(i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? String.valueOf(i5) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i6 = this.f3117j;
                sb.append((i6 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i6));
                if (this.f3118k == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + this.f3118k.toString().length() + ")";
                }
                sb.append(str);
                return androidx.appcompat.widget.b0.i(sb, this.f3119l != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public e(ClipData clipData, int i5) {
        this.f3115h = clipData;
        this.f3116i = i5;
    }
}
