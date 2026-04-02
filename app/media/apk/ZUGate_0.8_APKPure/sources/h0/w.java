package h0;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public int f3219a;

    /* renamed from: b  reason: collision with root package name */
    public int f3220b;

    public w(JSONObject jSONObject) {
        this.f3219a = jSONObject.getInt("commitmentPaymentsCount");
        this.f3220b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
    }
}
