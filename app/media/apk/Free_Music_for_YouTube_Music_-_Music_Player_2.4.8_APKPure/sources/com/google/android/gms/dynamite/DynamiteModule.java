package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class DynamiteModule {
    private static Boolean zzgoz;
    private static zzk zzgpa;
    private static zzm zzgpb;
    private static String zzgpc;
    private static final ThreadLocal<zza> zzgpd = new ThreadLocal<>();
    private static final zzi zzgpe = new com.google.android.gms.dynamite.zza();
    public static final zzd zzgpf = new com.google.android.gms.dynamite.zzb();
    private static zzd zzgpg = new com.google.android.gms.dynamite.zzc();
    public static final zzd zzgph = new com.google.android.gms.dynamite.zzd();
    public static final zzd zzgpi = new zze();
    public static final zzd zzgpj = new zzf();
    public static final zzd zzgpk = new zzg();
    private final Context zzgpl;

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza {
        public Cursor zzgpm;

        private zza() {
        }

        /* synthetic */ zza(com.google.android.gms.dynamite.zza zzaVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zzb implements zzi {
        private final int zzgpn;
        private final int zzgpo = 0;

        public zzb(int i, int i2) {
            this.zzgpn = i;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzae(Context context, String str) {
            return this.zzgpn;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzb(Context context, String str, boolean z) {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        /* synthetic */ zzc(String str, com.google.android.gms.dynamite.zza zzaVar) {
            this(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, com.google.android.gms.dynamite.zza zzaVar) {
            this(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface zzd {
        zzj zza(Context context, String str, zzi zziVar) throws zzc;
    }

    private DynamiteModule(Context context) {
        this.zzgpl = (Context) zzbp.zzu(context);
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzmVar) {
        try {
            return (Context) com.google.android.gms.dynamic.zzn.zzab(zzmVar.zza(com.google.android.gms.dynamic.zzn.zzw(context), str, i, com.google.android.gms.dynamic.zzn.zzw(cursor)));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(valueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    public static DynamiteModule zza(Context context, zzd zzdVar, String str) throws zzc {
        zza zzaVar = zzgpd.get();
        zza zzaVar2 = new zza(null);
        zzgpd.set(zzaVar2);
        try {
            zzj zza2 = zzdVar.zza(context, str, zzgpe);
            Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.zzgpp).append(" and remote module ").append(str).append(":").append(zza2.zzgpq).toString());
            if (zza2.zzgpr == 0 || ((zza2.zzgpr == -1 && zza2.zzgpp == 0) || (zza2.zzgpr == 1 && zza2.zzgpq == 0))) {
                throw new zzc(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.zzgpp).append(" and remote version is ").append(zza2.zzgpq).append(".").toString(), (com.google.android.gms.dynamite.zza) null);
            } else if (zza2.zzgpr == -1) {
                DynamiteModule zzag = zzag(context, str);
                if (zzaVar2.zzgpm != null) {
                    zzaVar2.zzgpm.close();
                }
                zzgpd.set(zzaVar);
                return zzag;
            } else if (zza2.zzgpr != 1) {
                throw new zzc(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.zzgpr).toString(), (com.google.android.gms.dynamite.zza) null);
            } else {
                try {
                    DynamiteModule zza3 = zza(context, str, zza2.zzgpq);
                    if (zzaVar2.zzgpm != null) {
                        zzaVar2.zzgpm.close();
                    }
                    zzgpd.set(zzaVar);
                    return zza3;
                } catch (zzc e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza2.zzgpp == 0 || zzdVar.zza(context, str, new zzb(zza2.zzgpp, 0)).zzgpr != -1) {
                        throw new zzc("Remote load failed. No local fallback found.", e, null);
                    }
                    DynamiteModule zzag2 = zzag(context, str);
                    if (zzaVar2.zzgpm != null) {
                        zzaVar2.zzgpm.close();
                    }
                    zzgpd.set(zzaVar);
                    return zzag2;
                }
            }
        } catch (Throwable th) {
            if (zzaVar2.zzgpm != null) {
                zzaVar2.zzgpm.close();
            }
            zzgpd.set(zzaVar);
            throw th;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) throws zzc {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzgoz;
        }
        if (bool == null) {
            throw new zzc("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zza) null);
        }
        return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.dynamite.zzm] */
    private static void zza(ClassLoader classLoader) throws zzc {
        zzn zznVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zznVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zznVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            zzgpb = zznVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new zzc("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static int zzae(Context context, String str) {
        int i;
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf("com.google.android.gms.dynamite.descriptors.").length() + 1 + String.valueOf(str).length() + String.valueOf("ModuleDescriptor").length()).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".").append("ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                i = declaredField2.getInt(null);
            } else {
                String valueOf = String.valueOf(declaredField.get(null));
                Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
                i = 0;
            }
            return i;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzaf(Context context, String str) {
        return zzb(context, str, false);
    }

    private static DynamiteModule zzag(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static int zzb(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        synchronized (DynamiteModule.class) {
            Boolean bool = zzgoz;
            if (bool == null) {
                try {
                    loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                    declaredField = loadClass.getDeclaredField("sClassLoader");
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                    String valueOf = String.valueOf(e);
                    Log.w("DynamiteModule", new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to load module via V2: ").append(valueOf).toString());
                    bool = Boolean.FALSE;
                }
                synchronized (loadClass) {
                    ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                    if (classLoader != null) {
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                zza(classLoader);
                            } catch (zzc e2) {
                            }
                            bool = Boolean.TRUE;
                        }
                    } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                        bool = Boolean.FALSE;
                    } else {
                        try {
                            int zzd2 = zzd(context, str, z);
                            if (zzgpc == null || zzgpc.isEmpty()) {
                                return zzd2;
                            }
                            zzh zzhVar = new zzh(zzgpc, ClassLoader.getSystemClassLoader());
                            zza(zzhVar);
                            declaredField.set(null, zzhVar);
                            zzgoz = Boolean.TRUE;
                            return zzd2;
                        } catch (zzc e3) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        }
                    }
                    zzgoz = bool;
                }
            }
            if (bool.booleanValue()) {
                try {
                    return zzd(context, str, z);
                } catch (zzc e4) {
                    String valueOf2 = String.valueOf(e4.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                    return 0;
                }
            }
            return zzc(context, str, z);
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzk zzcw = zzcw(context);
        if (zzcw == null) {
            throw new zzc("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zza) null);
        }
        try {
            IObjectWrapper zza2 = zzcw.zza(com.google.android.gms.dynamic.zzn.zzw(context), str, i);
            if (com.google.android.gms.dynamic.zzn.zzab(zza2) == null) {
                throw new zzc("Failed to load remote module.", (com.google.android.gms.dynamite.zza) null);
            }
            return new DynamiteModule((Context) com.google.android.gms.dynamic.zzn.zzab(zza2));
        } catch (RemoteException e) {
            throw new zzc("Failed to load remote module.", e, null);
        }
    }

    private static int zzc(Context context, String str, boolean z) {
        zzk zzcw = zzcw(context);
        if (zzcw == null) {
            return 0;
        }
        try {
            return zzcw.zza(com.google.android.gms.dynamic.zzn.zzw(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws zzc {
        zzm zzmVar;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            zzmVar = zzgpb;
        }
        if (zzmVar == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zza) null);
        }
        zza zzaVar = zzgpd.get();
        if (zzaVar == null || zzaVar.zzgpm == null) {
            throw new zzc("No result cursor", (com.google.android.gms.dynamite.zza) null);
        }
        Context zza2 = zza(context.getApplicationContext(), str, i, zzaVar.zzgpm, zzmVar);
        if (zza2 == null) {
            throw new zzc("Failed to get module context", (com.google.android.gms.dynamite.zza) null);
        }
        return new DynamiteModule(zza2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.dynamite.zzk] */
    private static zzk zzcw(Context context) {
        zzl zzlVar;
        synchronized (DynamiteModule.class) {
            if (zzgpa != null) {
                return zzgpa;
            } else if (com.google.android.gms.common.zze.zzaew().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzlVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzlVar = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (zzlVar != null) {
                        zzgpa = zzlVar;
                        return zzlVar;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            }
        }
    }

    private static int zzd(Context context, String str, boolean z) throws zzc {
        String str2;
        Cursor cursor = null;
        try {
            str2 = z ? "api_force_staging" : "api";
        } catch (Throwable th) {
            th = th;
        }
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(new StringBuilder(String.valueOf("content://com.google.android.gms.chimera/").length() + 1 + String.valueOf(str2).length() + String.valueOf(str).length()).append("content://com.google.android.gms.chimera/").append(str2).append("/").append(str).toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                zzgpc = query.getString(2);
                            }
                            zza zzaVar = zzgpd.get();
                            if (zzaVar != null && zzaVar.zzgpm == null) {
                                zzaVar.zzgpm = query;
                                query = null;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        return i;
                    }
                } catch (Exception e) {
                    e = e;
                    if (e instanceof zzc) {
                        throw e;
                    }
                    throw new zzc("V2 version check failed", e, null);
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new zzc("Failed to connect to dynamite module ContentResolver.", (com.google.android.gms.dynamite.zza) null);
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final Context zzaof() {
        return this.zzgpl;
    }

    public final IBinder zzgv(String str) throws zzc {
        try {
            return (IBinder) this.zzgpl.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
