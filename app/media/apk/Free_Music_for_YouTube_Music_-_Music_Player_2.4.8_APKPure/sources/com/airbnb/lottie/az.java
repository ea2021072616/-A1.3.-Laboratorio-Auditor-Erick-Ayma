package com.airbnb.lottie;

import com.airbnb.lottie.h;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mask.java */
/* loaded from: classes.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private final b f431a;

    /* renamed from: b  reason: collision with root package name */
    private final h f432b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Mask.java */
    /* loaded from: classes.dex */
    public enum b {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private az(b bVar, h hVar) {
        this.f431a = bVar;
        this.f432b = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Mask.java */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static az a(JSONObject jSONObject, aw awVar) {
            b bVar;
            String optString = jSONObject.optString("mode");
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 97:
                    if (optString.equals("a")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 105:
                    if (optString.equals("i")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 115:
                    if (optString.equals("s")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    bVar = b.MaskModeAdd;
                    break;
                case 1:
                    bVar = b.MaskModeSubtract;
                    break;
                case 2:
                    bVar = b.MaskModeIntersect;
                    break;
                default:
                    bVar = b.MaskModeUnknown;
                    break;
            }
            return new az(bVar, h.a.a(jSONObject.optJSONObject("pt"), awVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        return this.f431a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b() {
        return this.f432b;
    }
}
