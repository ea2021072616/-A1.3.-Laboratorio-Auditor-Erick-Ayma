package com.fotoable.youtube.music;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.model.LocalMusicModel;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
import java.util.List;
/* compiled from: IPlayerService.java */
/* loaded from: classes.dex */
public interface c extends IInterface {
    List<PlayMusicModel> a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, long j) throws RemoteException;

    void a(int i, boolean z) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(PlayMusicModel playMusicModel) throws RemoteException;

    void a(LocalMusicModel localMusicModel) throws RemoteException;

    void a(RadioModel radioModel) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(List<PlayMusicModel> list) throws RemoteException;

    void a(List<PlayMusicModel> list, int i) throws RemoteException;

    void a(boolean z) throws RemoteException;

    List<PlayMusicModel> b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(PlayMusicModel playMusicModel) throws RemoteException;

    void b(LocalMusicModel localMusicModel) throws RemoteException;

    void b(List<LocalMusicModel> list) throws RemoteException;

    void b(List<LocalMusicModel> list, int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    List<LocalMusicModel> c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(boolean z) throws RemoteException;

    List<LocalMusicModel> d() throws RemoteException;

    void d(int i) throws RemoteException;

    void d(boolean z) throws RemoteException;

    RadioModel e() throws RemoteException;

    void e(int i) throws RemoteException;

    void e(boolean z) throws RemoteException;

    int f() throws RemoteException;

    void f(int i) throws RemoteException;

    void f(boolean z) throws RemoteException;

    PlayMusicModel g() throws RemoteException;

    LocalMusicModel h() throws RemoteException;

    RadioModel i() throws RemoteException;

    void j() throws RemoteException;

    void k() throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    void n() throws RemoteException;

    void o() throws RemoteException;

    /* compiled from: IPlayerService.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.fotoable.youtube.music.IPlayerService");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.fotoable.youtube.music.IPlayerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0056a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.createTypedArrayList(PlayMusicModel.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt() != 0 ? PlayMusicModel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.readInt() != 0 ? PlayMusicModel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.createTypedArrayList(PlayMusicModel.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    List<PlayMusicModel> a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    List<PlayMusicModel> b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(b2);
                    return true;
                case 7:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.createTypedArrayList(LocalMusicModel.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt() != 0 ? LocalMusicModel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.readInt() != 0 ? LocalMusicModel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.createTypedArrayList(LocalMusicModel.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    List<LocalMusicModel> c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(c2);
                    return true;
                case 14:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    List<LocalMusicModel> d = d();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(d);
                    return true;
                case 15:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt() != 0 ? RadioModel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    RadioModel e = e();
                    parcel2.writeNoException();
                    if (e != null) {
                        parcel2.writeInt(1);
                        e.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    int f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f);
                    return true;
                case 21:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    PlayMusicModel g = g();
                    parcel2.writeNoException();
                    if (g != null) {
                        parcel2.writeInt(1);
                        g.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 22:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    LocalMusicModel h = h();
                    parcel2.writeNoException();
                    if (h != null) {
                        parcel2.writeInt(1);
                        h.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 23:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    RadioModel i3 = i();
                    parcel2.writeNoException();
                    if (i3 != null) {
                        parcel2.writeInt(1);
                        i3.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 24:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    j();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    k();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    l();
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    m();
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    c(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    d(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    n();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    e(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    f(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    o();
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    a(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    d(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    e(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.fotoable.youtube.music.IPlayerService");
                    f(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.fotoable.youtube.music.IPlayerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IPlayerService.java */
        /* renamed from: com.fotoable.youtube.music.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0056a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2324a;

            C0056a(IBinder iBinder) {
                this.f2324a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2324a;
            }

            @Override // com.fotoable.youtube.music.c
            public void a(List<PlayMusicModel> list, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeTypedList(list);
                    obtain.writeInt(i);
                    this.f2324a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(PlayMusicModel playMusicModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    if (playMusicModel != null) {
                        obtain.writeInt(1);
                        playMusicModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2324a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(PlayMusicModel playMusicModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    if (playMusicModel != null) {
                        obtain.writeInt(1);
                        playMusicModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2324a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(List<PlayMusicModel> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeTypedList(list);
                    this.f2324a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public List<PlayMusicModel> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PlayMusicModel.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public List<PlayMusicModel> b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PlayMusicModel.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(List<LocalMusicModel> list, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeTypedList(list);
                    obtain.writeInt(i);
                    this.f2324a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(LocalMusicModel localMusicModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    if (localMusicModel != null) {
                        obtain.writeInt(1);
                        localMusicModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2324a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(LocalMusicModel localMusicModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    if (localMusicModel != null) {
                        obtain.writeInt(1);
                        localMusicModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2324a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(List<LocalMusicModel> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeTypedList(list);
                    this.f2324a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public List<LocalMusicModel> c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LocalMusicModel.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public List<LocalMusicModel> d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LocalMusicModel.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeLong(j);
                    this.f2324a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(RadioModel radioModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    if (radioModel != null) {
                        obtain.writeInt(1);
                        radioModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2324a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public RadioModel e() throws RemoteException {
                RadioModel radioModel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        radioModel = RadioModel.CREATOR.createFromParcel(obtain2);
                    } else {
                        radioModel = null;
                    }
                    return radioModel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public int f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public PlayMusicModel g() throws RemoteException {
                PlayMusicModel playMusicModel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        playMusicModel = PlayMusicModel.CREATOR.createFromParcel(obtain2);
                    } else {
                        playMusicModel = null;
                    }
                    return playMusicModel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public LocalMusicModel h() throws RemoteException {
                LocalMusicModel localMusicModel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        localMusicModel = LocalMusicModel.CREATOR.createFromParcel(obtain2);
                    } else {
                        localMusicModel = null;
                    }
                    return localMusicModel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public RadioModel i() throws RemoteException {
                RadioModel radioModel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        radioModel = RadioModel.CREATOR.createFromParcel(obtain2);
                    } else {
                        radioModel = null;
                    }
                    return radioModel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    this.f2324a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    this.f2324a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void a(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f2324a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void d(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void e(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.fotoable.youtube.music.c
            public void f(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.fotoable.youtube.music.IPlayerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2324a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
