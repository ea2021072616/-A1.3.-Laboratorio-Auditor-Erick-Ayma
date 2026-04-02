package v4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i0;
import androidx.recyclerview.widget.i1;
import androidx.viewpager.widget.l;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Locale;
import ru.zdevs.zugate.MainActivity;
import ru.zdevs.zugate.jni.FS;
import ru.zdevs.zugate.widget.SwitchRW;
/* loaded from: classes.dex */
public final class h extends i0 implements View.OnClickListener, View.OnLongClickListener {
    public static final int[] o = {R.attr.colorDevice1, R.attr.colorDevice2, R.attr.colorDevice3, R.attr.colorDevice4, R.attr.colorDevice5, R.attr.colorDevice6, R.attr.colorDevice7, R.attr.colorDevice8, R.attr.colorDevice9, R.attr.colorDevice10, R.attr.colorDevice10};

    /* renamed from: p  reason: collision with root package name */
    public static boolean f5241p = false;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f5243k;

    /* renamed from: l  reason: collision with root package name */
    public e f5244l;

    /* renamed from: m  reason: collision with root package name */
    public f f5245m;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f5242j = new int[11];

    /* renamed from: n  reason: collision with root package name */
    public final String[] f5246n = new String[5];

    public h(Context context, ArrayList arrayList) {
        this.f5243k = arrayList;
        for (int i5 = 0; i5 < 11; i5++) {
            this.f5242j[i5] = e4.e.m(context, o[i5]);
        }
        String[] strArr = this.f5246n;
        strArr[0] = "";
        strArr[1] = context.getString(R.string.kb);
        this.f5246n[2] = context.getString(R.string.mb);
        this.f5246n[3] = context.getString(R.string.gb);
        this.f5246n[4] = context.getString(R.string.tb);
    }

    public static String h(t4.a aVar) {
        String str;
        int i5 = aVar.f5030d;
        if (i5 == 40) {
            str = "EncFS";
        } else if (i5 != 41) {
            switch (i5) {
                case 1:
                    str = "FAT";
                    break;
                case l.SCROLL_STATE_SETTLING /* 2 */:
                    str = "ExFAT";
                    break;
                case 3:
                    str = "NTFS";
                    break;
                case 4:
                    str = "EXTx";
                    break;
                case 5:
                    str = "ISO / UDF";
                    break;
                case 6:
                    str = "BitLocker";
                    break;
                case 7:
                    str = "LUKS 1";
                    break;
                case 8:
                    str = "LUKS 2";
                    break;
                default:
                    switch (i5) {
                        case 50:
                            str = "F2FS";
                            break;
                        case 51:
                            str = "FileVault";
                            break;
                        case 52:
                            str = "HFS";
                            break;
                        case 53:
                            str = "HFS+";
                            break;
                        case 54:
                            str = "HFSX";
                            break;
                        case 55:
                            str = "APFS";
                            break;
                        default:
                            str = "-";
                            break;
                    }
            }
        } else {
            str = "TrueCrypt";
        }
        if (i5 < 6 || aVar.f5031e == 0) {
            return str;
        }
        return str + " (" + FS.K(aVar.f5031e) + ")";
    }

    @Override // androidx.recyclerview.widget.i0
    public final int a() {
        return this.f5243k.size();
    }

    @Override // androidx.recyclerview.widget.i0
    public final int c(int i5) {
        return ((b) this.f5243k.get(i5)).f5221a.f5036j & 4080;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    @Override // androidx.recyclerview.widget.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.recyclerview.widget.i1 r18, int r19) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.h.d(androidx.recyclerview.widget.i1, int):void");
    }

    @Override // androidx.recyclerview.widget.i0
    public final i1 e(RecyclerView recyclerView, int i5) {
        LayoutInflater from = LayoutInflater.from(recyclerView.getContext());
        return i5 != 32 ? (i5 == 128 || i5 == 256) ? new d(from.inflate(R.layout.file_row, (ViewGroup) recyclerView, false)) : new c(from.inflate(R.layout.device_row, (ViewGroup) recyclerView, false)) : new g(from.inflate(R.layout.part_row, (ViewGroup) recyclerView, false));
    }

    public final String g(t4.a aVar) {
        long j5 = aVar.f5035i;
        int i5 = j5 > 1099511627776L ? 4 : j5 > 1073741824 ? 3 : j5 > 1048576 ? 2 : j5 > 1024 ? 1 : 0;
        if (i5 > 0) {
            return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j5) / ((float) (1 << (i5 * 10)))), this.f5246n[i5]);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5244l == null) {
            return;
        }
        b bVar = (b) this.f5243k.get(((Integer) view.getTag()).intValue());
        if (view instanceof SwitchRW) {
            bVar.f5223c = ((SwitchRW) view).isChecked();
            return;
        }
        Integer num = (Integer) view.getTag(R.id.buttonConnect);
        if (num == null) {
            return;
        }
        int i5 = (f5241p && bVar.f5223c) ? 0 : 1;
        if ((bVar.f5221a.f5036j & 4080) == 256) {
            i5 |= 1024;
        }
        ((MainActivity) this.f5244l).i(num.intValue(), bVar.f5221a, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e  */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onLongClick(android.view.View r13) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.h.onLongClick(android.view.View):boolean");
    }
}
