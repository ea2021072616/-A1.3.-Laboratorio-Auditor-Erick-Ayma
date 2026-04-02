package androidx.core.graphics.drawable;

import a0.c;
import a0.e;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.viewpager.widget.l;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f710k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f711a;

    /* renamed from: b  reason: collision with root package name */
    public Object f712b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f713c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f714d;

    /* renamed from: e  reason: collision with root package name */
    public int f715e;

    /* renamed from: f  reason: collision with root package name */
    public int f716f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f717g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f718h;

    /* renamed from: i  reason: collision with root package name */
    public String f719i;

    /* renamed from: j  reason: collision with root package name */
    public String f720j;

    public IconCompat() {
        this.f711a = -1;
        this.f713c = null;
        this.f714d = null;
        this.f715e = 0;
        this.f716f = 0;
        this.f717g = null;
        this.f718h = f710k;
        this.f719i = null;
    }

    public static IconCompat a(int i5) {
        if (i5 != 0) {
            IconCompat iconCompat = new IconCompat(0);
            iconCompat.f715e = i5;
            iconCompat.f712b = "";
            iconCompat.f720j = "";
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int b() {
        int i5 = this.f711a;
        if (i5 != -1) {
            if (i5 == 2) {
                return this.f715e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i6 = Build.VERSION.SDK_INT;
        Object obj = this.f712b;
        if (i6 >= 28) {
            return e.a(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon resource", e5);
            return 0;
        } catch (NoSuchMethodException e6) {
            Log.e("IconCompat", "Unable to get icon resource", e6);
            return 0;
        } catch (InvocationTargetException e7) {
            Log.e("IconCompat", "Unable to get icon resource", e7);
            return 0;
        }
    }

    public final Uri c() {
        int i5 = this.f711a;
        if (i5 == -1) {
            return c.a(this.f712b);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.f712b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f711a == -1) {
            return String.valueOf(this.f712b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f711a) {
            case 1:
                str = "BITMAP";
                break;
            case l.SCROLL_STATE_SETTLING /* 2 */:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f711a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f712b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f712b).getHeight());
                break;
            case l.SCROLL_STATE_SETTLING /* 2 */:
                sb.append(" pkg=");
                sb.append(this.f720j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f715e);
                if (this.f716f != 0) {
                    sb.append(" off=");
                    sb.append(this.f716f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f712b);
                break;
        }
        if (this.f717g != null) {
            sb.append(" tint=");
            sb.append(this.f717g);
        }
        if (this.f718h != f710k) {
            sb.append(" mode=");
            sb.append(this.f718h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i5) {
        this.f713c = null;
        this.f714d = null;
        this.f715e = 0;
        this.f716f = 0;
        this.f717g = null;
        this.f718h = f710k;
        this.f719i = null;
        this.f711a = 2;
    }
}
