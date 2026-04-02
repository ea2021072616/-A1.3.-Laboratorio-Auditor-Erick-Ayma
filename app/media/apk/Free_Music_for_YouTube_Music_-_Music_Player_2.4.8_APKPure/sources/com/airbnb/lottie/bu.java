package com.airbnb.lottie;

import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.ai;
import com.airbnb.lottie.ak;
import com.airbnb.lottie.bb;
import com.airbnb.lottie.bm;
import com.airbnb.lottie.bo;
import com.airbnb.lottie.bt;
import com.airbnb.lottie.bx;
import com.airbnb.lottie.by;
import com.airbnb.lottie.bz;
import com.airbnb.lottie.j;
import com.airbnb.lottie.s;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class bu {

    /* renamed from: a  reason: collision with root package name */
    private final String f481a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f482b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Object a(JSONObject jSONObject, aw awVar) {
        String optString = jSONObject.optString("ty");
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 3239:
                if (optString.equals("el")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3270:
                if (optString.equals("fl")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3295:
                if (optString.equals("gf")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3307:
                if (optString.equals("gr")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3308:
                if (optString.equals("gs")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3488:
                if (optString.equals("mm")) {
                    c2 = 11;
                    break;
                }
                break;
            case 3633:
                if (optString.equals("rc")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3669:
                if (optString.equals("sh")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3679:
                if (optString.equals("sr")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3681:
                if (optString.equals(UserDataStore.STATE)) {
                    c2 = 1;
                    break;
                }
                break;
            case 3705:
                if (optString.equals("tm")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 3710:
                if (optString.equals("tr")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return a.b(jSONObject, awVar);
            case 1:
                return by.a.a(jSONObject, awVar);
            case 2:
                return ak.a.a(jSONObject, awVar);
            case 3:
                return bt.a.a(jSONObject, awVar);
            case 4:
                return ai.a.a(jSONObject, awVar);
            case 5:
                return j.a.a(jSONObject, awVar);
            case 6:
                return bx.a.a(jSONObject, awVar);
            case 7:
                return s.a.a(jSONObject, awVar);
            case '\b':
                return bo.a.a(jSONObject, awVar);
            case '\t':
                return bz.a.a(jSONObject, awVar);
            case '\n':
                return bm.a.a(jSONObject, awVar);
            case 11:
                return bb.a.a(jSONObject);
            default:
                Log.w("LOTTIE", "Unknown shape type " + optString);
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(String str, List<Object> list) {
        this.f481a = str;
        this.f482b = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShapeGroup.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static bu b(JSONObject jSONObject, aw awVar) {
            JSONArray optJSONArray = jSONObject.optJSONArray("it");
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object a2 = bu.a(optJSONArray.optJSONObject(i), awVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return new bu(optString, arrayList);
        }
    }

    public String a() {
        return this.f481a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> b() {
        return this.f482b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f481a + "' Shapes: " + Arrays.toString(this.f482b.toArray()) + '}';
    }
}
