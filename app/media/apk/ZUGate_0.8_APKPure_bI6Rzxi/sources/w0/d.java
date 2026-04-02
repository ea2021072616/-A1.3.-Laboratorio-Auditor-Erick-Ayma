package w0;

import h1.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                if (optJSONObject != null) {
                    arrayList.add(new j(optJSONObject));
                }
            }
        }
    }
}
