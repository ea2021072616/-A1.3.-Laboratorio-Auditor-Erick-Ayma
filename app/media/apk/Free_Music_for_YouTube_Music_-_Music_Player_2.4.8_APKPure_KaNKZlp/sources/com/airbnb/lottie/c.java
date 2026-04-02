package com.airbnb.lottie;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatableGradientColorValue.java */
/* loaded from: classes.dex */
public class c extends m<ag, ag> {
    private c(List<at<ag>> list, ag agVar) {
        super(list, agVar);
    }

    @Override // com.airbnb.lottie.k
    /* renamed from: a */
    public au<ag> b() {
        return !e() ? new cd(this.f536b) : new ah(this.f535a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatableGradientColorValue.java */
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static c a(JSONObject jSONObject, aw awVar) {
            l.a a2 = l.a(jSONObject, 1.0f, awVar, new b(jSONObject.optInt(TtmlNode.TAG_P))).a();
            return new c(a2.f533a, (ag) a2.f534b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatableGradientColorValue.java */
    /* loaded from: classes.dex */
    public static class b implements k.a<ag> {

        /* renamed from: a  reason: collision with root package name */
        private final int f505a;

        private b(int i) {
            this.f505a = i;
        }

        @Override // com.airbnb.lottie.k.a
        /* renamed from: a */
        public ag b(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            float[] fArr = new float[this.f505a];
            int[] iArr = new int[this.f505a];
            ag agVar = new ag(fArr, iArr);
            if (jSONArray.length() != this.f505a * 4) {
                Log.w("LOTTIE", "Unexpected gradient length: " + jSONArray.length() + ". Expected " + (this.f505a * 4) + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f505a * 4; i3++) {
                int i4 = i3 / 4;
                double optDouble = jSONArray.optDouble(i3);
                switch (i3 % 4) {
                    case 0:
                        fArr[i4] = (float) optDouble;
                        break;
                    case 1:
                        i2 = (int) (optDouble * 255.0d);
                        break;
                    case 2:
                        i = (int) (optDouble * 255.0d);
                        break;
                    case 3:
                        iArr[i4] = Color.argb(255, i2, i, (int) (optDouble * 255.0d));
                        break;
                }
            }
            a(agVar, jSONArray);
            return agVar;
        }

        private void a(ag agVar, JSONArray jSONArray) {
            int i = this.f505a * 4;
            if (jSONArray.length() > i) {
                int length = (jSONArray.length() - i) / 2;
                double[] dArr = new double[length];
                double[] dArr2 = new double[length];
                int i2 = 0;
                for (int i3 = i; i3 < jSONArray.length(); i3++) {
                    if (i3 % 2 == 0) {
                        dArr[i2] = jSONArray.optDouble(i3);
                    } else {
                        dArr2[i2] = jSONArray.optDouble(i3);
                        i2++;
                    }
                }
                for (int i4 = 0; i4 < agVar.c(); i4++) {
                    int i5 = agVar.b()[i4];
                    agVar.b()[i4] = Color.argb(a(agVar.a()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
                }
            }
        }

        @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
        private int a(double d, double[] dArr, double[] dArr2) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 < dArr.length) {
                    double d2 = dArr[i2 - 1];
                    double d3 = dArr[i2];
                    if (dArr[i2] < d) {
                        i = i2 + 1;
                    } else {
                        return (int) (bd.a(dArr2[i2 - 1], dArr2[i2], (d - d2) / (d3 - d2)) * 255.0d);
                    }
                } else {
                    return (int) (dArr2[dArr2.length - 1] * 255.0d);
                }
            }
        }
    }
}
