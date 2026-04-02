package y0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e extends Preference {
    public final long O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, ArrayList arrayList, long j5) {
        super(context, null);
        String str = null;
        this.F = R.layout.expand_button;
        Context context2 = this.f1177b;
        Drawable x5 = p2.a.x(context2, R.drawable.ic_arrow_down_24dp);
        if (this.f1187l != x5) {
            this.f1187l = x5;
            this.f1186k = 0;
            i();
        }
        this.f1186k = R.drawable.ic_arrow_down_24dp;
        String string = context2.getString(R.string.expand_button_title);
        if (!TextUtils.equals(string, this.f1184i)) {
            this.f1184i = string;
            i();
        }
        if (999 != this.f1183h) {
            this.f1183h = 999;
            v vVar = this.H;
            if (vVar != null) {
                Handler handler = vVar.f5652n;
                androidx.activity.j jVar = vVar.o;
                handler.removeCallbacks(jVar);
                handler.post(jVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence charSequence = preference.f1184i;
            boolean z4 = preference instanceof PreferenceGroup;
            if (z4 && !TextUtils.isEmpty(charSequence)) {
                arrayList2.add((PreferenceGroup) preference);
            }
            if (arrayList2.contains(preference.J)) {
                if (z4) {
                    arrayList2.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequence)) {
                if (str == null) {
                    str = charSequence;
                } else {
                    str = this.f1177b.getString(R.string.summary_collapsed_preference_list, str, charSequence);
                }
            }
        }
        x(str);
        this.O = j5 + 1000000;
    }

    @Override // androidx.preference.Preference
    public final long d() {
        return this.O;
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        d0Var.f5603x = false;
    }
}
