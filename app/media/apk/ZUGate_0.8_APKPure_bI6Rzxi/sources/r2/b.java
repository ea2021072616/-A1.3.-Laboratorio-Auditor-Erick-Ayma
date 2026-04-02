package r2;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f4489a = 0;

    static {
        b.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail > 0) {
            throw new BadParcelableException(b0.f("Parcel data not fully consumed, unread size: ", dataAvail));
        }
    }
}
