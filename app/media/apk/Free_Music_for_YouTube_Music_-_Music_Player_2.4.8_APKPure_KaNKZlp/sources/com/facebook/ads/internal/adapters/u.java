package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u extends a {

    /* renamed from: c  reason: collision with root package name */
    private final v f1232c;
    private NativeAdView.Type d;
    private boolean e;
    private boolean f;
    private boolean g;
    private View h;
    private List<View> i;

    public u(Context context, b bVar, com.facebook.ads.internal.j.a aVar, v vVar) {
        super(context, bVar, aVar);
        this.f1232c = vVar;
    }

    private String b(View view) {
        try {
            return c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject c(View view) {
        boolean z = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt(TtmlNode.ATTR_TTS_ORIGIN, String.format("{x:%d, y:%d}", Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())));
        jSONObject.putOpt("clickable", Boolean.valueOf((this.i == null || !this.i.contains(view)) ? false : false));
        String str = "unknown";
        if (view instanceof Button) {
            str = "button";
        } else if (view instanceof TextView) {
            str = MimeTypes.BASE_TYPE_TEXT;
        } else if (view instanceof ImageView) {
            str = MessengerShareContentUtility.MEDIA_IMAGE;
        } else if (view instanceof MediaView) {
            str = "mediaview";
        } else if (view instanceof ViewGroup) {
            str = "viewgroup";
        }
        jSONObject.putOpt("type", str);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                jSONArray.put(c(viewGroup.getChildAt(i)));
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return "";
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, this.f1232c.h(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public void a(View view) {
        this.h = view;
    }

    public void a(NativeAdView.Type type) {
        this.d = type;
    }

    public void a(List<View> list) {
        this.i = list;
    }

    @Override // com.facebook.ads.internal.adapters.a
    protected void a(Map<String, String> map) {
        if (this.f1232c == null) {
            return;
        }
        if (this.f1152a != null) {
            map.put("mil", String.valueOf(this.f1152a.a()));
            map.put("eil", String.valueOf(this.f1152a.b()));
            map.put("eil_source", this.f1152a.c());
        }
        if (this.d != null) {
            map.put("nti", String.valueOf(this.d.getValue()));
        }
        if (this.e) {
            map.put("nhs", Boolean.TRUE.toString());
        }
        if (this.f) {
            map.put("nmv", Boolean.TRUE.toString());
        }
        if (this.g) {
            map.put("nmvap", Boolean.TRUE.toString());
        }
        if (this.h != null && this.f1232c.e()) {
            map.put("view", b(this.h));
        }
        if (this.h != null && this.f1232c.d()) {
            map.put("snapshot", d(this.h));
        }
        this.f1232c.a(map);
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void c(boolean z) {
        this.g = z;
    }
}
