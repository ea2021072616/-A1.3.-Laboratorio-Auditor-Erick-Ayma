package g1;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final l.b f2927a;

    /* renamed from: b  reason: collision with root package name */
    public final l.b f2928b;

    /* renamed from: c  reason: collision with root package name */
    public final l.b f2929c;

    public a(l.b bVar, l.b bVar2, l.b bVar3) {
        this.f2927a = bVar;
        this.f2928b = bVar2;
        this.f2929c = bVar3;
    }

    public abstract b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        l.b bVar = this.f2929c;
        Class cls2 = (Class) bVar.getOrDefault(name, null);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            bVar.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method c(String str) {
        l.b bVar = this.f2927a;
        Method method = (Method) bVar.getOrDefault(str, null);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            bVar.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        l.b bVar = this.f2928b;
        Method method = (Method) bVar.getOrDefault(name, null);
        if (method == null) {
            Class b5 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b5.getDeclaredMethod("write", cls, a.class);
            bVar.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract boolean e(int i5);

    public final int f(int i5, int i6) {
        return !e(i6) ? i5 : ((b) this).f2931e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i5) {
        if (e(i5)) {
            return ((b) this).f2931e.readParcelable(b.class.getClassLoader());
        }
        return parcelable;
    }

    public final c h() {
        String readString = ((b) this).f2931e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    public abstract void i(int i5);

    public final void j(c cVar) {
        if (cVar == null) {
            ((b) this).f2931e.writeString(null);
            return;
        }
        try {
            ((b) this).f2931e.writeString(b(cVar.getClass()).getName());
            b a5 = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, a5);
                int i5 = a5.f2935i;
                if (i5 >= 0) {
                    int i6 = a5.f2930d.get(i5);
                    Parcel parcel = a5.f2931e;
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i6);
                    parcel.writeInt(dataPosition - i6);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
            } catch (NoSuchMethodException e7) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
            } catch (InvocationTargetException e8) {
                if (!(e8.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
                }
                throw ((RuntimeException) e8.getCause());
            }
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e9);
        }
    }
}
