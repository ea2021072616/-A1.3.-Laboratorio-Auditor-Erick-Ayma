package s;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f4787d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static final SparseIntArray f4788e;

    /* renamed from: f  reason: collision with root package name */
    public static final SparseIntArray f4789f;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f4790a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4791b = true;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f4792c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4788e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f4789f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] c(a aVar, String str) {
        int i5;
        HashMap hashMap;
        String[] split = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[split.length];
        int i6 = 0;
        int i7 = 0;
        while (i6 < split.length) {
            String trim = split[i6].trim();
            Object obj = null;
            try {
                i5 = p.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i5 = 0;
            }
            if (i5 == 0) {
                i5 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i5 == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                constraintLayout.getClass();
                if ((trim instanceof String) && (hashMap = constraintLayout.f681s) != null && hashMap.containsKey(trim)) {
                    obj = constraintLayout.f681s.get(trim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    i5 = ((Integer) obj).intValue();
                }
            }
            iArr[i7] = i5;
            i6++;
            i7++;
        }
        return i7 != split.length ? Arrays.copyOf(iArr, i7) : iArr;
    }

    public static i d(Context context, AttributeSet attributeSet, boolean z4) {
        String str;
        String[] strArr;
        String str2;
        h hVar;
        i iVar = new i();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z4 ? q.f4795c : q.f4793a);
        String[] strArr2 = p2.a.f4255j;
        int[] iArr = f4787d;
        SparseIntArray sparseIntArray = f4788e;
        l lVar = iVar.f4713b;
        m mVar = iVar.f4716e;
        k kVar = iVar.f4714c;
        j jVar = iVar.f4715d;
        String str3 = "unused attribute 0x";
        if (z4) {
            int indexCount = obtainStyledAttributes.getIndexCount();
            String str4 = "Unknown attribute 0x";
            h hVar2 = new h();
            kVar.getClass();
            jVar.getClass();
            lVar.getClass();
            mVar.getClass();
            int i5 = 0;
            while (i5 < indexCount) {
                int i6 = indexCount;
                int index = obtainStyledAttributes.getIndex(i5);
                int i7 = i5;
                switch (f4789f.get(index)) {
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        strArr = strArr2;
                        hVar2.b(2, obtainStyledAttributes.getDimensionPixelSize(index, jVar.I));
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        strArr = strArr2;
                        str2 = str4;
                        StringBuilder sb = new StringBuilder(str2);
                        hVar = hVar2;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        continue;
                        indexCount = i6;
                        hVar2 = hVar;
                        str4 = str2;
                        i5 = i7 + 1;
                        strArr2 = strArr;
                    case 5:
                        strArr = strArr2;
                        hVar2.c(5, obtainStyledAttributes.getString(index));
                        break;
                    case 6:
                        strArr = strArr2;
                        hVar2.b(6, obtainStyledAttributes.getDimensionPixelOffset(index, jVar.C));
                        break;
                    case 7:
                        strArr = strArr2;
                        hVar2.b(7, obtainStyledAttributes.getDimensionPixelOffset(index, jVar.D));
                        break;
                    case 8:
                        strArr = strArr2;
                        hVar2.b(8, obtainStyledAttributes.getDimensionPixelSize(index, jVar.J));
                        break;
                    case 11:
                        strArr = strArr2;
                        hVar2.b(11, obtainStyledAttributes.getDimensionPixelSize(index, jVar.P));
                        break;
                    case 12:
                        strArr = strArr2;
                        hVar2.b(12, obtainStyledAttributes.getDimensionPixelSize(index, jVar.Q));
                        break;
                    case 13:
                        strArr = strArr2;
                        hVar2.b(13, obtainStyledAttributes.getDimensionPixelSize(index, jVar.M));
                        break;
                    case 14:
                        strArr = strArr2;
                        hVar2.b(14, obtainStyledAttributes.getDimensionPixelSize(index, jVar.O));
                        break;
                    case 15:
                        strArr = strArr2;
                        hVar2.b(15, obtainStyledAttributes.getDimensionPixelSize(index, jVar.R));
                        break;
                    case 16:
                        strArr = strArr2;
                        hVar2.b(16, obtainStyledAttributes.getDimensionPixelSize(index, jVar.N));
                        break;
                    case 17:
                        strArr = strArr2;
                        hVar2.b(17, obtainStyledAttributes.getDimensionPixelOffset(index, jVar.f4725d));
                        break;
                    case 18:
                        strArr = strArr2;
                        hVar2.b(18, obtainStyledAttributes.getDimensionPixelOffset(index, jVar.f4727e));
                        break;
                    case 19:
                        strArr = strArr2;
                        hVar2.a(19, obtainStyledAttributes.getFloat(index, jVar.f4729f));
                        break;
                    case 20:
                        strArr = strArr2;
                        hVar2.a(20, obtainStyledAttributes.getFloat(index, jVar.f4755w));
                        break;
                    case 21:
                        strArr = strArr2;
                        hVar2.b(21, obtainStyledAttributes.getLayoutDimension(index, jVar.f4723c));
                        break;
                    case 22:
                        strArr = strArr2;
                        hVar2.b(22, iArr[obtainStyledAttributes.getInt(index, lVar.f4769a)]);
                        break;
                    case 23:
                        strArr = strArr2;
                        hVar2.b(23, obtainStyledAttributes.getLayoutDimension(index, jVar.f4721b));
                        break;
                    case 24:
                        strArr = strArr2;
                        hVar2.b(24, obtainStyledAttributes.getDimensionPixelSize(index, jVar.F));
                        break;
                    case 27:
                        strArr = strArr2;
                        hVar2.b(27, obtainStyledAttributes.getInt(index, jVar.E));
                        break;
                    case 28:
                        strArr = strArr2;
                        hVar2.b(28, obtainStyledAttributes.getDimensionPixelSize(index, jVar.G));
                        break;
                    case 31:
                        strArr = strArr2;
                        hVar2.b(31, obtainStyledAttributes.getDimensionPixelSize(index, jVar.K));
                        break;
                    case 34:
                        strArr = strArr2;
                        hVar2.b(34, obtainStyledAttributes.getDimensionPixelSize(index, jVar.H));
                        break;
                    case 37:
                        strArr = strArr2;
                        hVar2.a(37, obtainStyledAttributes.getFloat(index, jVar.f4756x));
                        break;
                    case 38:
                        strArr = strArr2;
                        int resourceId = obtainStyledAttributes.getResourceId(index, iVar.f4712a);
                        iVar.f4712a = resourceId;
                        hVar2.b(38, resourceId);
                        break;
                    case 39:
                        strArr = strArr2;
                        hVar2.a(39, obtainStyledAttributes.getFloat(index, jVar.U));
                        break;
                    case 40:
                        strArr = strArr2;
                        hVar2.a(40, obtainStyledAttributes.getFloat(index, jVar.T));
                        break;
                    case 41:
                        strArr = strArr2;
                        hVar2.b(41, obtainStyledAttributes.getInt(index, jVar.V));
                        break;
                    case 42:
                        strArr = strArr2;
                        hVar2.b(42, obtainStyledAttributes.getInt(index, jVar.W));
                        break;
                    case 43:
                        strArr = strArr2;
                        hVar2.a(43, obtainStyledAttributes.getFloat(index, lVar.f4771c));
                        break;
                    case 44:
                        strArr = strArr2;
                        hVar2.d(44, true);
                        hVar2.a(44, obtainStyledAttributes.getDimension(index, mVar.f4786m));
                        break;
                    case 45:
                        strArr = strArr2;
                        hVar2.a(45, obtainStyledAttributes.getFloat(index, mVar.f4775b));
                        break;
                    case 46:
                        strArr = strArr2;
                        hVar2.a(46, obtainStyledAttributes.getFloat(index, mVar.f4776c));
                        break;
                    case 47:
                        strArr = strArr2;
                        hVar2.a(47, obtainStyledAttributes.getFloat(index, mVar.f4777d));
                        break;
                    case 48:
                        strArr = strArr2;
                        hVar2.a(48, obtainStyledAttributes.getFloat(index, mVar.f4778e));
                        break;
                    case 49:
                        strArr = strArr2;
                        hVar2.a(49, obtainStyledAttributes.getDimension(index, mVar.f4779f));
                        break;
                    case 50:
                        strArr = strArr2;
                        hVar2.a(50, obtainStyledAttributes.getDimension(index, mVar.f4780g));
                        break;
                    case 51:
                        strArr = strArr2;
                        hVar2.a(51, obtainStyledAttributes.getDimension(index, mVar.f4782i));
                        break;
                    case 52:
                        strArr = strArr2;
                        hVar2.a(52, obtainStyledAttributes.getDimension(index, mVar.f4783j));
                        break;
                    case 53:
                        strArr = strArr2;
                        hVar2.a(53, obtainStyledAttributes.getDimension(index, mVar.f4784k));
                        break;
                    case 54:
                        strArr = strArr2;
                        hVar2.b(54, obtainStyledAttributes.getInt(index, jVar.X));
                        break;
                    case 55:
                        strArr = strArr2;
                        hVar2.b(55, obtainStyledAttributes.getInt(index, jVar.Y));
                        break;
                    case 56:
                        strArr = strArr2;
                        hVar2.b(56, obtainStyledAttributes.getDimensionPixelSize(index, jVar.Z));
                        break;
                    case 57:
                        strArr = strArr2;
                        hVar2.b(57, obtainStyledAttributes.getDimensionPixelSize(index, jVar.f4720a0));
                        break;
                    case 58:
                        strArr = strArr2;
                        hVar2.b(58, obtainStyledAttributes.getDimensionPixelSize(index, jVar.f4722b0));
                        break;
                    case 59:
                        strArr = strArr2;
                        hVar2.b(59, obtainStyledAttributes.getDimensionPixelSize(index, jVar.f4724c0));
                        break;
                    case 60:
                        strArr = strArr2;
                        hVar2.a(60, obtainStyledAttributes.getFloat(index, mVar.f4774a));
                        break;
                    case 62:
                        strArr = strArr2;
                        hVar2.b(62, obtainStyledAttributes.getDimensionPixelSize(index, jVar.A));
                        break;
                    case 63:
                        strArr = strArr2;
                        hVar2.a(63, obtainStyledAttributes.getFloat(index, jVar.B));
                        break;
                    case 64:
                        strArr = strArr2;
                        hVar2.b(64, f(obtainStyledAttributes, index, kVar.f4760a));
                        break;
                    case 65:
                        strArr = strArr2;
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            hVar2.c(65, strArr[obtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        } else {
                            hVar2.c(65, obtainStyledAttributes.getString(index));
                            break;
                        }
                    case 66:
                        strArr = strArr2;
                        hVar2.b(66, obtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        strArr = strArr2;
                        hVar2.a(67, obtainStyledAttributes.getFloat(index, kVar.f4764e));
                        break;
                    case 68:
                        strArr = strArr2;
                        hVar2.a(68, obtainStyledAttributes.getFloat(index, lVar.f4772d));
                        break;
                    case 69:
                        strArr = strArr2;
                        hVar2.a(69, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        strArr = strArr2;
                        hVar2.a(70, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        strArr = strArr2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        strArr = strArr2;
                        hVar2.b(72, obtainStyledAttributes.getInt(index, jVar.f4730f0));
                        break;
                    case 73:
                        strArr = strArr2;
                        hVar2.b(73, obtainStyledAttributes.getDimensionPixelSize(index, jVar.f4732g0));
                        break;
                    case 74:
                        strArr = strArr2;
                        hVar2.c(74, obtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        strArr = strArr2;
                        hVar2.d(75, obtainStyledAttributes.getBoolean(index, jVar.f4746n0));
                        break;
                    case 76:
                        strArr = strArr2;
                        hVar2.b(76, obtainStyledAttributes.getInt(index, kVar.f4762c));
                        break;
                    case 77:
                        strArr = strArr2;
                        hVar2.c(77, obtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        strArr = strArr2;
                        hVar2.b(78, obtainStyledAttributes.getInt(index, lVar.f4770b));
                        break;
                    case 79:
                        strArr = strArr2;
                        hVar2.a(79, obtainStyledAttributes.getFloat(index, kVar.f4763d));
                        break;
                    case 80:
                        strArr = strArr2;
                        hVar2.d(80, obtainStyledAttributes.getBoolean(index, jVar.f4742l0));
                        break;
                    case 81:
                        strArr = strArr2;
                        hVar2.d(81, obtainStyledAttributes.getBoolean(index, jVar.f4744m0));
                        break;
                    case 82:
                        strArr = strArr2;
                        hVar2.b(82, obtainStyledAttributes.getInteger(index, kVar.f4761b));
                        break;
                    case 83:
                        strArr = strArr2;
                        hVar2.b(83, f(obtainStyledAttributes, index, mVar.f4781h));
                        break;
                    case 84:
                        strArr = strArr2;
                        hVar2.b(84, obtainStyledAttributes.getInteger(index, kVar.f4766g));
                        break;
                    case 85:
                        strArr = strArr2;
                        hVar2.a(85, obtainStyledAttributes.getFloat(index, kVar.f4765f));
                        break;
                    case 86:
                        strArr = strArr2;
                        int i8 = obtainStyledAttributes.peekValue(index).type;
                        if (i8 != 1) {
                            if (i8 != 3) {
                                hVar2.b(88, obtainStyledAttributes.getInteger(index, kVar.f4768i));
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                kVar.f4767h = string;
                                hVar2.c(90, string);
                                if (kVar.f4767h.indexOf("/") <= 0) {
                                    hVar2.b(88, -1);
                                    break;
                                } else {
                                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                                    kVar.f4768i = resourceId2;
                                    hVar2.b(89, resourceId2);
                                    hVar2.b(88, -2);
                                    break;
                                }
                            }
                        } else {
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, -1);
                            kVar.f4768i = resourceId3;
                            hVar2.b(89, resourceId3);
                            if (kVar.f4768i != -1) {
                                hVar2.b(88, -2);
                                break;
                            }
                        }
                        break;
                    case 87:
                        strArr = strArr2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        strArr = strArr2;
                        hVar2.b(93, obtainStyledAttributes.getDimensionPixelSize(index, jVar.L));
                        break;
                    case 94:
                        strArr = strArr2;
                        hVar2.b(94, obtainStyledAttributes.getDimensionPixelSize(index, jVar.S));
                        break;
                    case 95:
                        strArr = strArr2;
                        g(hVar2, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        strArr = strArr2;
                        g(hVar2, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        strArr = strArr2;
                        hVar2.b(97, obtainStyledAttributes.getInt(index, jVar.f4747o0));
                        break;
                    case 98:
                        int i9 = r.a.f4465w;
                        strArr = strArr2;
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            iVar.f4712a = obtainStyledAttributes.getResourceId(index, iVar.f4712a);
                            break;
                        } else {
                            obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 99:
                        hVar2.d(99, obtainStyledAttributes.getBoolean(index, jVar.f4731g));
                        strArr = strArr2;
                        break;
                }
                str2 = str4;
                hVar = hVar2;
                indexCount = i6;
                hVar2 = hVar;
                str4 = str2;
                i5 = i7 + 1;
                strArr2 = strArr;
            }
        } else {
            int indexCount2 = obtainStyledAttributes.getIndexCount();
            int i10 = 0;
            while (i10 < indexCount2) {
                int index2 = obtainStyledAttributes.getIndex(i10);
                int i11 = indexCount2;
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        kVar.getClass();
                        jVar.getClass();
                        lVar.getClass();
                        mVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        str = str3;
                        jVar.f4748p = f(obtainStyledAttributes, index2, jVar.f4748p);
                        break;
                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                        str = str3;
                        jVar.I = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.I);
                        break;
                    case 3:
                        str = str3;
                        jVar.o = f(obtainStyledAttributes, index2, jVar.o);
                        break;
                    case 4:
                        str = str3;
                        jVar.f4745n = f(obtainStyledAttributes, index2, jVar.f4745n);
                        break;
                    case 5:
                        str = str3;
                        jVar.f4757y = obtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        str = str3;
                        jVar.C = obtainStyledAttributes.getDimensionPixelOffset(index2, jVar.C);
                        break;
                    case 7:
                        str = str3;
                        jVar.D = obtainStyledAttributes.getDimensionPixelOffset(index2, jVar.D);
                        break;
                    case 8:
                        str = str3;
                        jVar.J = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.J);
                        break;
                    case 9:
                        str = str3;
                        jVar.f4754v = f(obtainStyledAttributes, index2, jVar.f4754v);
                        break;
                    case 10:
                        str = str3;
                        jVar.f4753u = f(obtainStyledAttributes, index2, jVar.f4753u);
                        break;
                    case 11:
                        str = str3;
                        jVar.P = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.P);
                        break;
                    case 12:
                        str = str3;
                        jVar.Q = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.Q);
                        break;
                    case 13:
                        str = str3;
                        jVar.M = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.M);
                        break;
                    case 14:
                        str = str3;
                        jVar.O = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.O);
                        break;
                    case 15:
                        str = str3;
                        jVar.R = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.R);
                        break;
                    case 16:
                        str = str3;
                        jVar.N = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.N);
                        break;
                    case 17:
                        str = str3;
                        jVar.f4725d = obtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f4725d);
                        break;
                    case 18:
                        str = str3;
                        jVar.f4727e = obtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f4727e);
                        break;
                    case 19:
                        str = str3;
                        jVar.f4729f = obtainStyledAttributes.getFloat(index2, jVar.f4729f);
                        break;
                    case 20:
                        str = str3;
                        jVar.f4755w = obtainStyledAttributes.getFloat(index2, jVar.f4755w);
                        break;
                    case 21:
                        str = str3;
                        jVar.f4723c = obtainStyledAttributes.getLayoutDimension(index2, jVar.f4723c);
                        break;
                    case 22:
                        str = str3;
                        lVar.f4769a = iArr[obtainStyledAttributes.getInt(index2, lVar.f4769a)];
                        break;
                    case 23:
                        str = str3;
                        jVar.f4721b = obtainStyledAttributes.getLayoutDimension(index2, jVar.f4721b);
                        break;
                    case 24:
                        str = str3;
                        jVar.F = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.F);
                        break;
                    case 25:
                        str = str3;
                        jVar.f4733h = f(obtainStyledAttributes, index2, jVar.f4733h);
                        break;
                    case 26:
                        str = str3;
                        jVar.f4735i = f(obtainStyledAttributes, index2, jVar.f4735i);
                        break;
                    case 27:
                        str = str3;
                        jVar.E = obtainStyledAttributes.getInt(index2, jVar.E);
                        break;
                    case 28:
                        str = str3;
                        jVar.G = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.G);
                        break;
                    case 29:
                        str = str3;
                        jVar.f4737j = f(obtainStyledAttributes, index2, jVar.f4737j);
                        break;
                    case 30:
                        str = str3;
                        jVar.f4739k = f(obtainStyledAttributes, index2, jVar.f4739k);
                        break;
                    case 31:
                        str = str3;
                        jVar.K = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.K);
                        break;
                    case 32:
                        str = str3;
                        jVar.f4751s = f(obtainStyledAttributes, index2, jVar.f4751s);
                        break;
                    case 33:
                        str = str3;
                        jVar.f4752t = f(obtainStyledAttributes, index2, jVar.f4752t);
                        break;
                    case 34:
                        str = str3;
                        jVar.H = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.H);
                        break;
                    case 35:
                        str = str3;
                        jVar.f4743m = f(obtainStyledAttributes, index2, jVar.f4743m);
                        break;
                    case 36:
                        str = str3;
                        jVar.f4741l = f(obtainStyledAttributes, index2, jVar.f4741l);
                        break;
                    case 37:
                        str = str3;
                        jVar.f4756x = obtainStyledAttributes.getFloat(index2, jVar.f4756x);
                        break;
                    case 38:
                        str = str3;
                        iVar.f4712a = obtainStyledAttributes.getResourceId(index2, iVar.f4712a);
                        break;
                    case 39:
                        str = str3;
                        jVar.U = obtainStyledAttributes.getFloat(index2, jVar.U);
                        break;
                    case 40:
                        str = str3;
                        jVar.T = obtainStyledAttributes.getFloat(index2, jVar.T);
                        break;
                    case 41:
                        str = str3;
                        jVar.V = obtainStyledAttributes.getInt(index2, jVar.V);
                        break;
                    case 42:
                        str = str3;
                        jVar.W = obtainStyledAttributes.getInt(index2, jVar.W);
                        break;
                    case 43:
                        str = str3;
                        lVar.f4771c = obtainStyledAttributes.getFloat(index2, lVar.f4771c);
                        break;
                    case 44:
                        str = str3;
                        mVar.f4785l = true;
                        mVar.f4786m = obtainStyledAttributes.getDimension(index2, mVar.f4786m);
                        break;
                    case 45:
                        str = str3;
                        mVar.f4775b = obtainStyledAttributes.getFloat(index2, mVar.f4775b);
                        break;
                    case 46:
                        str = str3;
                        mVar.f4776c = obtainStyledAttributes.getFloat(index2, mVar.f4776c);
                        break;
                    case 47:
                        str = str3;
                        mVar.f4777d = obtainStyledAttributes.getFloat(index2, mVar.f4777d);
                        break;
                    case 48:
                        str = str3;
                        mVar.f4778e = obtainStyledAttributes.getFloat(index2, mVar.f4778e);
                        break;
                    case 49:
                        str = str3;
                        mVar.f4779f = obtainStyledAttributes.getDimension(index2, mVar.f4779f);
                        break;
                    case 50:
                        str = str3;
                        mVar.f4780g = obtainStyledAttributes.getDimension(index2, mVar.f4780g);
                        break;
                    case 51:
                        str = str3;
                        mVar.f4782i = obtainStyledAttributes.getDimension(index2, mVar.f4782i);
                        break;
                    case 52:
                        str = str3;
                        mVar.f4783j = obtainStyledAttributes.getDimension(index2, mVar.f4783j);
                        break;
                    case 53:
                        str = str3;
                        mVar.f4784k = obtainStyledAttributes.getDimension(index2, mVar.f4784k);
                        break;
                    case 54:
                        str = str3;
                        jVar.X = obtainStyledAttributes.getInt(index2, jVar.X);
                        break;
                    case 55:
                        str = str3;
                        jVar.Y = obtainStyledAttributes.getInt(index2, jVar.Y);
                        break;
                    case 56:
                        str = str3;
                        jVar.Z = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.Z);
                        break;
                    case 57:
                        str = str3;
                        jVar.f4720a0 = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4720a0);
                        break;
                    case 58:
                        str = str3;
                        jVar.f4722b0 = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4722b0);
                        break;
                    case 59:
                        str = str3;
                        jVar.f4724c0 = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4724c0);
                        break;
                    case 60:
                        str = str3;
                        mVar.f4774a = obtainStyledAttributes.getFloat(index2, mVar.f4774a);
                        break;
                    case 61:
                        str = str3;
                        jVar.f4758z = f(obtainStyledAttributes, index2, jVar.f4758z);
                        break;
                    case 62:
                        str = str3;
                        jVar.A = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.A);
                        break;
                    case 63:
                        str = str3;
                        jVar.B = obtainStyledAttributes.getFloat(index2, jVar.B);
                        break;
                    case 64:
                        str = str3;
                        kVar.f4760a = f(obtainStyledAttributes, index2, kVar.f4760a);
                        break;
                    case 65:
                        str = str3;
                        if (obtainStyledAttributes.peekValue(index2).type != 3) {
                            String str5 = strArr2[obtainStyledAttributes.getInteger(index2, 0)];
                            kVar.getClass();
                            break;
                        } else {
                            obtainStyledAttributes.getString(index2);
                            kVar.getClass();
                            break;
                        }
                    case 66:
                        str = str3;
                        obtainStyledAttributes.getInt(index2, 0);
                        kVar.getClass();
                        break;
                    case 67:
                        str = str3;
                        kVar.f4764e = obtainStyledAttributes.getFloat(index2, kVar.f4764e);
                        break;
                    case 68:
                        str = str3;
                        lVar.f4772d = obtainStyledAttributes.getFloat(index2, lVar.f4772d);
                        break;
                    case 69:
                        str = str3;
                        jVar.f4726d0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        str = str3;
                        jVar.f4728e0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        str = str3;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        str = str3;
                        jVar.f4730f0 = obtainStyledAttributes.getInt(index2, jVar.f4730f0);
                        break;
                    case 73:
                        str = str3;
                        jVar.f4732g0 = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.f4732g0);
                        break;
                    case 74:
                        str = str3;
                        jVar.f4738j0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        str = str3;
                        jVar.f4746n0 = obtainStyledAttributes.getBoolean(index2, jVar.f4746n0);
                        break;
                    case 76:
                        str = str3;
                        kVar.f4762c = obtainStyledAttributes.getInt(index2, kVar.f4762c);
                        break;
                    case 77:
                        str = str3;
                        jVar.f4740k0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        str = str3;
                        lVar.f4770b = obtainStyledAttributes.getInt(index2, lVar.f4770b);
                        break;
                    case 79:
                        str = str3;
                        kVar.f4763d = obtainStyledAttributes.getFloat(index2, kVar.f4763d);
                        break;
                    case 80:
                        str = str3;
                        jVar.f4742l0 = obtainStyledAttributes.getBoolean(index2, jVar.f4742l0);
                        break;
                    case 81:
                        str = str3;
                        jVar.f4744m0 = obtainStyledAttributes.getBoolean(index2, jVar.f4744m0);
                        break;
                    case 82:
                        str = str3;
                        kVar.f4761b = obtainStyledAttributes.getInteger(index2, kVar.f4761b);
                        break;
                    case 83:
                        str = str3;
                        mVar.f4781h = f(obtainStyledAttributes, index2, mVar.f4781h);
                        break;
                    case 84:
                        str = str3;
                        kVar.f4766g = obtainStyledAttributes.getInteger(index2, kVar.f4766g);
                        break;
                    case 85:
                        str = str3;
                        kVar.f4765f = obtainStyledAttributes.getFloat(index2, kVar.f4765f);
                        break;
                    case 86:
                        str = str3;
                        int i12 = obtainStyledAttributes.peekValue(index2).type;
                        if (i12 != 1) {
                            if (i12 == 3) {
                                String string2 = obtainStyledAttributes.getString(index2);
                                kVar.f4767h = string2;
                                if (string2.indexOf("/") > 0) {
                                    kVar.f4768i = obtainStyledAttributes.getResourceId(index2, -1);
                                }
                            } else {
                                obtainStyledAttributes.getInteger(index2, kVar.f4768i);
                            }
                            break;
                        } else {
                            kVar.f4768i = obtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        }
                    case 87:
                        StringBuilder sb2 = new StringBuilder(str3);
                        str = str3;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        str = str3;
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 91:
                        jVar.f4749q = f(obtainStyledAttributes, index2, jVar.f4749q);
                        str = str3;
                        break;
                    case 92:
                        jVar.f4750r = f(obtainStyledAttributes, index2, jVar.f4750r);
                        str = str3;
                        break;
                    case 93:
                        jVar.L = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.L);
                        str = str3;
                        break;
                    case 94:
                        jVar.S = obtainStyledAttributes.getDimensionPixelSize(index2, jVar.S);
                        str = str3;
                        break;
                    case 95:
                        g(jVar, obtainStyledAttributes, index2, 0);
                        str = str3;
                        break;
                    case 96:
                        g(jVar, obtainStyledAttributes, index2, 1);
                        str = str3;
                        break;
                    case 97:
                        jVar.f4747o0 = obtainStyledAttributes.getInt(index2, jVar.f4747o0);
                        str = str3;
                        break;
                }
                i10++;
                indexCount2 = i11;
                str3 = str;
            }
            if (jVar.f4738j0 != null) {
                jVar.f4736i0 = null;
            }
        }
        obtainStyledAttributes.recycle();
        return iVar;
    }

    public static int f(TypedArray typedArray, int i5, int i6) {
        int resourceId = typedArray.getResourceId(i5, i6);
        return resourceId == -1 ? typedArray.getInt(i5, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.n.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i5 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                i5 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                r2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(r2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(r2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i5 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.G = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.ViewGroup] */
    public final void a(ConstraintLayout constraintLayout) {
        ConstraintLayout constraintLayout2;
        int i5;
        View findViewById;
        HashMap hashMap;
        String str;
        int i6;
        String str2;
        n nVar = this;
        ConstraintLayout constraintLayout3 = constraintLayout;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap2 = nVar.f4792c;
        HashSet hashSet = new HashSet(hashMap2.keySet());
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout3.getChildAt(i7);
            int id = childAt.getId();
            if (!hashMap2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    str2 = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str2 = "UNKNOWN";
                }
                sb.append(str2);
                Log.w("ConstraintSet", sb.toString());
            } else if (nVar.f4791b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (hashMap2.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        i iVar = (i) hashMap2.get(Integer.valueOf(id));
                        if (iVar != null) {
                            if (childAt instanceof a) {
                                j jVar = iVar.f4715d;
                                jVar.f4734h0 = 1;
                                a aVar = (a) childAt;
                                aVar.setId(id);
                                aVar.setType(jVar.f4730f0);
                                aVar.setMargin(jVar.f4732g0);
                                aVar.setAllowsGoneWidget(jVar.f4746n0);
                                int[] iArr = jVar.f4736i0;
                                if (iArr != null) {
                                    aVar.setReferencedIds(iArr);
                                } else {
                                    String str3 = jVar.f4738j0;
                                    if (str3 != null) {
                                        int[] c5 = c(aVar, str3);
                                        jVar.f4736i0 = c5;
                                        aVar.setReferencedIds(c5);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            iVar.a(eVar);
                            HashMap hashMap3 = iVar.f4717f;
                            Class<?> cls = childAt.getClass();
                            for (String str4 : hashMap3.keySet()) {
                                b bVar = (b) hashMap3.get(str4);
                                if (bVar.f4637a) {
                                    hashMap = hashMap3;
                                    str = str4;
                                } else {
                                    hashMap = hashMap3;
                                    str = "set" + str4;
                                }
                                try {
                                } catch (IllegalAccessException e5) {
                                    e = e5;
                                    i6 = childCount;
                                } catch (NoSuchMethodException e6) {
                                    e = e6;
                                    i6 = childCount;
                                } catch (InvocationTargetException e7) {
                                    e = e7;
                                    i6 = childCount;
                                }
                                switch (n.h.b(bVar.f4638b)) {
                                    case 0:
                                        i6 = childCount;
                                        Class<?>[] clsArr = new Class[1];
                                        try {
                                            clsArr[0] = Integer.TYPE;
                                            cls.getMethod(str, clsArr).invoke(childAt, Integer.valueOf(bVar.f4639c));
                                        } catch (IllegalAccessException e8) {
                                            e = e8;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        } catch (NoSuchMethodException e9) {
                                            e = e9;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + str);
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        } catch (InvocationTargetException e10) {
                                            e = e10;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        }
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                    case 1:
                                        i6 = childCount;
                                        cls.getMethod(str, Float.TYPE).invoke(childAt, Float.valueOf(bVar.f4640d));
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                                        i6 = childCount;
                                        cls.getMethod(str, Integer.TYPE).invoke(childAt, Integer.valueOf(bVar.f4643g));
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case 3:
                                        i6 = childCount;
                                        Method method = cls.getMethod(str, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(bVar.f4643g);
                                        method.invoke(childAt, colorDrawable);
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case 4:
                                        i6 = childCount;
                                        cls.getMethod(str, CharSequence.class).invoke(childAt, bVar.f4641e);
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case 5:
                                        i6 = childCount;
                                        cls.getMethod(str, Boolean.TYPE).invoke(childAt, Boolean.valueOf(bVar.f4642f));
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case 6:
                                        i6 = childCount;
                                        cls.getMethod(str, Float.TYPE).invoke(childAt, Float.valueOf(bVar.f4640d));
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                        break;
                                    case 7:
                                        i6 = childCount;
                                        try {
                                            cls.getMethod(str, Integer.TYPE).invoke(childAt, Integer.valueOf(bVar.f4639c));
                                        } catch (IllegalAccessException e11) {
                                            e = e11;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        } catch (NoSuchMethodException e12) {
                                            e = e12;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + str);
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        } catch (InvocationTargetException e13) {
                                            e = e13;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                            hashMap3 = hashMap;
                                            childCount = i6;
                                        }
                                        hashMap3 = hashMap;
                                        childCount = i6;
                                    default:
                                        hashMap3 = hashMap;
                                        break;
                                }
                            }
                            i5 = childCount;
                            childAt.setLayoutParams(eVar);
                            l lVar = iVar.f4713b;
                            if (lVar.f4770b == 0) {
                                childAt.setVisibility(lVar.f4769a);
                            }
                            childAt.setAlpha(lVar.f4771c);
                            m mVar = iVar.f4716e;
                            childAt.setRotation(mVar.f4774a);
                            childAt.setRotationX(mVar.f4775b);
                            childAt.setRotationY(mVar.f4776c);
                            childAt.setScaleX(mVar.f4777d);
                            childAt.setScaleY(mVar.f4778e);
                            if (mVar.f4781h != -1) {
                                if (((View) childAt.getParent()).findViewById(mVar.f4781h) != null) {
                                    float bottom = (findViewById.getBottom() + findViewById.getTop()) / 2.0f;
                                    float right = (findViewById.getRight() + findViewById.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(mVar.f4779f)) {
                                    childAt.setPivotX(mVar.f4779f);
                                }
                                if (!Float.isNaN(mVar.f4780g)) {
                                    childAt.setPivotY(mVar.f4780g);
                                }
                            }
                            childAt.setTranslationX(mVar.f4782i);
                            childAt.setTranslationY(mVar.f4783j);
                            childAt.setTranslationZ(mVar.f4784k);
                            if (mVar.f4785l) {
                                childAt.setElevation(mVar.f4786m);
                            }
                        }
                    } else {
                        i5 = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                    i7++;
                    nVar = this;
                    constraintLayout3 = constraintLayout;
                    childCount = i5;
                }
            }
            i5 = childCount;
            i7++;
            nVar = this;
            constraintLayout3 = constraintLayout;
            childCount = i5;
        }
        int i8 = childCount;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            i iVar2 = (i) hashMap2.get(num);
            if (iVar2 != null) {
                j jVar2 = iVar2.f4715d;
                if (jVar2.f4734h0 == 1) {
                    a aVar2 = new a(constraintLayout.getContext());
                    aVar2.setId(num.intValue());
                    int[] iArr2 = jVar2.f4736i0;
                    if (iArr2 != null) {
                        aVar2.setReferencedIds(iArr2);
                    } else {
                        String str5 = jVar2.f4738j0;
                        if (str5 != null) {
                            int[] c6 = c(aVar2, str5);
                            jVar2.f4736i0 = c6;
                            aVar2.setReferencedIds(c6);
                        }
                    }
                    aVar2.setType(jVar2.f4730f0);
                    aVar2.setMargin(jVar2.f4732g0);
                    r rVar = ConstraintLayout.f669v;
                    e eVar2 = new e();
                    aVar2.i();
                    iVar2.a(eVar2);
                    constraintLayout2 = constraintLayout;
                    constraintLayout2.addView(aVar2, eVar2);
                } else {
                    constraintLayout2 = constraintLayout;
                }
                if (jVar2.f4719a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    r rVar2 = ConstraintLayout.f669v;
                    e eVar3 = new e();
                    iVar2.a(eVar3);
                    constraintLayout2.addView(guideline, eVar3);
                }
            }
        }
        for (int i9 = 0; i9 < i8; i9++) {
            View childAt2 = constraintLayout.getChildAt(i9);
            if (childAt2 instanceof c) {
                ((c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i5;
        int i6;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = nVar.f4792c;
        hashMap.clear();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout.getChildAt(i7);
            e eVar = (e) childAt.getLayoutParams();
            int id = childAt.getId();
            if (nVar.f4791b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new i());
            }
            i iVar = (i) hashMap.get(Integer.valueOf(id));
            if (iVar == null) {
                i5 = childCount;
            } else {
                HashMap hashMap2 = nVar.f4790a;
                HashMap hashMap3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap2.keySet()) {
                    b bVar = (b) hashMap2.get(str);
                    try {
                    } catch (IllegalAccessException e5) {
                        e = e5;
                        i6 = childCount;
                    } catch (NoSuchMethodException e6) {
                        e = e6;
                        i6 = childCount;
                    } catch (InvocationTargetException e7) {
                        e = e7;
                        i6 = childCount;
                    }
                    if (str.equals("BackgroundColor")) {
                        hashMap3.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        i6 = childCount;
                        try {
                            hashMap3.put(str, new b(bVar, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                        } catch (IllegalAccessException e8) {
                            e = e8;
                            e.printStackTrace();
                            childCount = i6;
                        } catch (NoSuchMethodException e9) {
                            e = e9;
                            e.printStackTrace();
                            childCount = i6;
                        } catch (InvocationTargetException e10) {
                            e = e10;
                            e.printStackTrace();
                            childCount = i6;
                        }
                        childCount = i6;
                    }
                }
                i5 = childCount;
                iVar.f4717f = hashMap3;
                iVar.f4712a = id;
                int i8 = eVar.f4660e;
                j jVar = iVar.f4715d;
                jVar.f4733h = i8;
                jVar.f4735i = eVar.f4662f;
                jVar.f4737j = eVar.f4664g;
                jVar.f4739k = eVar.f4666h;
                jVar.f4741l = eVar.f4668i;
                jVar.f4743m = eVar.f4670j;
                jVar.f4745n = eVar.f4672k;
                jVar.o = eVar.f4674l;
                jVar.f4748p = eVar.f4676m;
                jVar.f4749q = eVar.f4678n;
                jVar.f4750r = eVar.o;
                jVar.f4751s = eVar.f4685s;
                jVar.f4752t = eVar.f4686t;
                jVar.f4753u = eVar.f4687u;
                jVar.f4754v = eVar.f4688v;
                jVar.f4755w = eVar.E;
                jVar.f4756x = eVar.F;
                jVar.f4757y = eVar.G;
                jVar.f4758z = eVar.f4681p;
                jVar.A = eVar.f4683q;
                jVar.B = eVar.f4684r;
                jVar.C = eVar.T;
                jVar.D = eVar.U;
                jVar.E = eVar.V;
                jVar.f4729f = eVar.f4656c;
                jVar.f4725d = eVar.f4652a;
                jVar.f4727e = eVar.f4654b;
                jVar.f4721b = ((ViewGroup.MarginLayoutParams) eVar).width;
                jVar.f4723c = ((ViewGroup.MarginLayoutParams) eVar).height;
                jVar.F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                jVar.G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                jVar.H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                jVar.I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                jVar.L = eVar.D;
                jVar.T = eVar.I;
                jVar.U = eVar.H;
                jVar.W = eVar.K;
                jVar.V = eVar.J;
                jVar.f4742l0 = eVar.W;
                jVar.f4744m0 = eVar.X;
                jVar.X = eVar.L;
                jVar.Y = eVar.M;
                jVar.Z = eVar.P;
                jVar.f4720a0 = eVar.Q;
                jVar.f4722b0 = eVar.N;
                jVar.f4724c0 = eVar.O;
                jVar.f4726d0 = eVar.R;
                jVar.f4728e0 = eVar.S;
                jVar.f4740k0 = eVar.Y;
                jVar.N = eVar.f4690x;
                jVar.P = eVar.f4692z;
                jVar.M = eVar.f4689w;
                jVar.O = eVar.f4691y;
                jVar.R = eVar.A;
                jVar.Q = eVar.B;
                jVar.S = eVar.C;
                jVar.f4747o0 = eVar.Z;
                jVar.J = eVar.getMarginEnd();
                jVar.K = eVar.getMarginStart();
                int visibility = childAt.getVisibility();
                l lVar = iVar.f4713b;
                lVar.f4769a = visibility;
                lVar.f4771c = childAt.getAlpha();
                float rotation = childAt.getRotation();
                m mVar = iVar.f4716e;
                mVar.f4774a = rotation;
                mVar.f4775b = childAt.getRotationX();
                mVar.f4776c = childAt.getRotationY();
                mVar.f4777d = childAt.getScaleX();
                mVar.f4778e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    mVar.f4779f = pivotX;
                    mVar.f4780g = pivotY;
                }
                mVar.f4782i = childAt.getTranslationX();
                mVar.f4783j = childAt.getTranslationY();
                mVar.f4784k = childAt.getTranslationZ();
                if (mVar.f4785l) {
                    mVar.f4786m = childAt.getElevation();
                }
                if (childAt instanceof a) {
                    a aVar = (a) childAt;
                    jVar.f4746n0 = aVar.getAllowsGoneWidget();
                    jVar.f4736i0 = aVar.getReferencedIds();
                    jVar.f4730f0 = aVar.getType();
                    jVar.f4732g0 = aVar.getMargin();
                }
            }
            i7++;
            nVar = this;
            childCount = i5;
        }
    }

    public final void e(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    i d5 = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        d5.f4715d.f4719a = true;
                    }
                    this.f4792c.put(Integer.valueOf(d5.f4712a), d5);
                    continue;
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }
}
