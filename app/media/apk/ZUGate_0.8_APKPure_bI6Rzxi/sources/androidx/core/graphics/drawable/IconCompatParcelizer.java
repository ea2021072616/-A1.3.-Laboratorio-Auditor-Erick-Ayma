package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.l;
import g1.a;
import g1.b;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f711a = aVar.f(iconCompat.f711a, 1);
        byte[] bArr = iconCompat.f713c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f2931e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f713c = bArr;
        iconCompat.f714d = aVar.g(iconCompat.f714d, 3);
        iconCompat.f715e = aVar.f(iconCompat.f715e, 4);
        iconCompat.f716f = aVar.f(iconCompat.f716f, 5);
        iconCompat.f717g = (ColorStateList) aVar.g(iconCompat.f717g, 6);
        String str = iconCompat.f719i;
        if (aVar.e(7)) {
            str = ((b) aVar).f2931e.readString();
        }
        iconCompat.f719i = str;
        String str2 = iconCompat.f720j;
        if (aVar.e(8)) {
            str2 = ((b) aVar).f2931e.readString();
        }
        iconCompat.f720j = str2;
        iconCompat.f718h = PorterDuff.Mode.valueOf(iconCompat.f719i);
        switch (iconCompat.f711a) {
            case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                Parcelable parcelable = iconCompat.f714d;
                if (parcelable != null) {
                    iconCompat.f712b = parcelable;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f714d;
                if (parcelable2 == null) {
                    byte[] bArr3 = iconCompat.f713c;
                    iconCompat.f712b = bArr3;
                    iconCompat.f711a = 3;
                    iconCompat.f715e = 0;
                    iconCompat.f716f = bArr3.length;
                    break;
                } else {
                    iconCompat.f712b = parcelable2;
                    break;
                }
            case l.SCROLL_STATE_SETTLING /* 2 */:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f713c, Charset.forName("UTF-16"));
                iconCompat.f712b = str3;
                if (iconCompat.f711a == 2 && iconCompat.f720j == null) {
                    iconCompat.f720j = str3.split(":", -1)[0];
                    break;
                }
                break;
            case 3:
                iconCompat.f712b = iconCompat.f713c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f719i = iconCompat.f718h.name();
        switch (iconCompat.f711a) {
            case androidx.viewpager.widget.a.POSITION_UNCHANGED /* -1 */:
                iconCompat.f714d = (Parcelable) iconCompat.f712b;
                break;
            case 1:
            case 5:
                iconCompat.f714d = (Parcelable) iconCompat.f712b;
                break;
            case l.SCROLL_STATE_SETTLING /* 2 */:
                iconCompat.f713c = ((String) iconCompat.f712b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f713c = (byte[]) iconCompat.f712b;
                break;
            case 4:
            case 6:
                iconCompat.f713c = iconCompat.f712b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i5 = iconCompat.f711a;
        if (-1 != i5) {
            aVar.i(1);
            ((b) aVar).f2931e.writeInt(i5);
        }
        byte[] bArr = iconCompat.f713c;
        if (bArr != null) {
            aVar.i(2);
            int length = bArr.length;
            Parcel parcel = ((b) aVar).f2931e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f714d;
        if (parcelable != null) {
            aVar.i(3);
            ((b) aVar).f2931e.writeParcelable(parcelable, 0);
        }
        int i6 = iconCompat.f715e;
        if (i6 != 0) {
            aVar.i(4);
            ((b) aVar).f2931e.writeInt(i6);
        }
        int i7 = iconCompat.f716f;
        if (i7 != 0) {
            aVar.i(5);
            ((b) aVar).f2931e.writeInt(i7);
        }
        ColorStateList colorStateList = iconCompat.f717g;
        if (colorStateList != null) {
            aVar.i(6);
            ((b) aVar).f2931e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f719i;
        if (str != null) {
            aVar.i(7);
            ((b) aVar).f2931e.writeString(str);
        }
        String str2 = iconCompat.f720j;
        if (str2 != null) {
            aVar.i(8);
            ((b) aVar).f2931e.writeString(str2);
        }
    }
}
