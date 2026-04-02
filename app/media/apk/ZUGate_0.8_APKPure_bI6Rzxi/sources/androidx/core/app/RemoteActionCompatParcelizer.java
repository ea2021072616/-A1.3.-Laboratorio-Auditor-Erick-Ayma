package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import g1.a;
import g1.b;
import g1.c;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.f704a;
        if (aVar.e(1)) {
            cVar = aVar.h();
        }
        remoteActionCompat.f704a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.f705b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f2931e);
        }
        remoteActionCompat.f705b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f706c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f2931e);
        }
        remoteActionCompat.f706c = charSequence2;
        remoteActionCompat.f707d = (PendingIntent) aVar.g(remoteActionCompat.f707d, 4);
        boolean z4 = remoteActionCompat.f708e;
        if (aVar.e(5)) {
            z4 = ((b) aVar).f2931e.readInt() != 0;
        }
        remoteActionCompat.f708e = z4;
        boolean z5 = remoteActionCompat.f709f;
        if (aVar.e(6)) {
            z5 = ((b) aVar).f2931e.readInt() != 0;
        }
        remoteActionCompat.f709f = z5;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f704a;
        aVar.i(1);
        aVar.j(iconCompat);
        CharSequence charSequence = remoteActionCompat.f705b;
        aVar.i(2);
        Parcel parcel = ((b) aVar).f2931e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f706c;
        aVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f707d;
        aVar.i(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z4 = remoteActionCompat.f708e;
        aVar.i(5);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = remoteActionCompat.f709f;
        aVar.i(6);
        parcel.writeInt(z5 ? 1 : 0);
    }
}
