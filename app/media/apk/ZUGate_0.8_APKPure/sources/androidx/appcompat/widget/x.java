package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.github.appintro.R;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public Serializable f570a;

    /* renamed from: b  reason: collision with root package name */
    public Serializable f571b;

    /* renamed from: c  reason: collision with root package name */
    public Object f572c;

    /* renamed from: d  reason: collision with root package name */
    public Serializable f573d;

    /* renamed from: e  reason: collision with root package name */
    public Serializable f574e;

    /* renamed from: f  reason: collision with root package name */
    public Object f575f;

    public x(JSONObject jSONObject) {
        this.f570a = jSONObject.getString("productId");
        this.f571b = jSONObject.optString(AppIntroBaseFragmentKt.ARG_TITLE);
        this.f572c = jSONObject.optString("name");
        this.f573d = jSONObject.optString("description");
        this.f574e = jSONObject.optString("basePlanId");
        JSONObject optJSONObject = jSONObject.optJSONObject("pricingPhase");
        this.f575f = optJSONObject == null ? null : new h1.j(optJSONObject);
    }

    public static boolean b(int[] iArr, int i5) {
        for (int i6 : iArr) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList d(Context context, int i5) {
        int c5 = d3.c(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{d3.f311b, d3.f313d, d3.f312c, d3.f315f}, new int[]{d3.b(context, R.attr.colorButtonNormal), z.a.b(c5, i5), z.a.b(c5, i5), i5});
    }

    public static LayerDrawable f(v2 v2Var, Context context, int i5) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i5);
        Drawable e5 = v2Var.e(context, R.drawable.abc_star_black_48dp);
        Drawable e6 = v2Var.e(context, R.drawable.abc_star_half_black_48dp);
        if ((e5 instanceof BitmapDrawable) && e5.getIntrinsicWidth() == dimensionPixelSize && e5.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) e5;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            e5.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            e5.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((e6 instanceof BitmapDrawable) && e6.getIntrinsicWidth() == dimensionPixelSize && e6.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) e6;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            e6.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            e6.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        return layerDrawable;
    }

    public static void i(Drawable drawable, int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter g5;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = y.f596b;
        }
        PorterDuff.Mode mode2 = y.f596b;
        synchronized (y.class) {
            g5 = v2.g(i5, mode);
        }
        mutate.setColorFilter(g5);
    }

    public final void a(String str, String str2) {
        e().put(str, str2);
    }

    public final x1.h c() {
        String str = ((String) this.f570a) == null ? " transportName" : "";
        if (((x1.l) this.f572c) == null) {
            str = str.concat(" encodedPayload");
        }
        if (((Long) this.f573d) == null) {
            str = b0.h(str, " eventMillis");
        }
        if (((Long) this.f574e) == null) {
            str = b0.h(str, " uptimeMillis");
        }
        if (((Map) this.f575f) == null) {
            str = b0.h(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new x1.h((String) this.f570a, (Integer) this.f571b, (x1.l) this.f572c, ((Long) this.f573d).longValue(), ((Long) this.f574e).longValue(), (Map) this.f575f);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public final Map e() {
        Object obj = this.f575f;
        if (((Map) obj) != null) {
            return (Map) obj;
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    public final ColorStateList g(Context context, int i5) {
        if (i5 == R.drawable.abc_edit_text_material) {
            return p2.a.u(context, R.color.abc_tint_edittext);
        }
        if (i5 == R.drawable.abc_switch_track_mtrl_alpha) {
            return p2.a.u(context, R.color.abc_tint_switch_track);
        }
        if (i5 != R.drawable.abc_switch_thumb_material) {
            if (i5 == R.drawable.abc_btn_default_mtrl_shape) {
                return d(context, d3.c(context, R.attr.colorButtonNormal));
            }
            if (i5 == R.drawable.abc_btn_borderless_material) {
                return d(context, 0);
            }
            if (i5 == R.drawable.abc_btn_colored_material) {
                return d(context, d3.c(context, R.attr.colorAccent));
            }
            if (i5 == R.drawable.abc_spinner_mtrl_am_alpha || i5 == R.drawable.abc_spinner_textfield_background_material) {
                return p2.a.u(context, R.color.abc_tint_spinner);
            }
            if (b((int[]) this.f571b, i5)) {
                return d3.d(context, R.attr.colorControlNormal);
            }
            if (b((int[]) this.f574e, i5)) {
                return p2.a.u(context, R.color.abc_tint_default);
            }
            if (b((int[]) this.f575f, i5)) {
                return p2.a.u(context, R.color.abc_tint_btn_checkable);
            }
            if (i5 == R.drawable.abc_seekbar_thumb_material) {
                return p2.a.u(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList d5 = d3.d(context, R.attr.colorSwitchThumbNormal);
        if (d5 == null || !d5.isStateful()) {
            iArr[0] = d3.f311b;
            iArr2[0] = d3.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = d3.f314e;
            iArr2[1] = d3.c(context, R.attr.colorControlActivated);
            iArr[2] = d3.f315f;
            iArr2[2] = d3.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = d3.f311b;
            iArr[0] = iArr3;
            iArr2[0] = d5.getColorForState(iArr3, 0);
            iArr[1] = d3.f314e;
            iArr2[1] = d3.c(context, R.attr.colorControlActivated);
            iArr[2] = d3.f315f;
            iArr2[2] = d5.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final void h(x1.l lVar) {
        if (lVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        this.f572c = lVar;
    }

    public final void j(String str) {
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        this.f570a = str;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v6, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v8, types: [int[], java.io.Serializable] */
    public x(int i5) {
        if (i5 != 2) {
            this.f570a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            this.f571b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            this.f572c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            this.f573d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            this.f574e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            this.f575f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
        }
    }
}
