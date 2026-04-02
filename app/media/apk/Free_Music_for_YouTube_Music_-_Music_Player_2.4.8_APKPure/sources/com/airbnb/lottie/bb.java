package com.airbnb.lottie;

import org.json.JSONObject;
/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private final String f439a;

    /* renamed from: b  reason: collision with root package name */
    private final b f440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MergePaths.java */
    /* loaded from: classes.dex */
    public enum b {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    private bb(String str, b bVar) {
        this.f439a = str;
        this.f440b = bVar;
    }

    /* compiled from: MergePaths.java */
    /* loaded from: classes.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static bb a(JSONObject jSONObject) {
            return new bb(jSONObject.optString("nm"), b.b(jSONObject.optInt("mm", 1)));
        }
    }

    public String a() {
        return this.f439a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f440b;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f440b + '}';
    }
}
