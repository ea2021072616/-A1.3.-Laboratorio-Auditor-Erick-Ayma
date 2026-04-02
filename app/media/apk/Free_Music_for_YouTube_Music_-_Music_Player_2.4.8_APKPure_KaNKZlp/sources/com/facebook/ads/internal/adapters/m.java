package com.facebook.ads.internal.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m extends x {

    /* renamed from: b  reason: collision with root package name */
    private y f1211b;

    /* renamed from: c  reason: collision with root package name */
    private Context f1212c;
    private String e;
    private String f;
    private String g;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private z p;
    private com.facebook.ads.internal.c.b q;
    private boolean d = false;
    private String h = UUID.randomUUID().toString();

    private void c() {
        LocalBroadcastManager.getInstance(this.f1212c).registerReceiver(this.p, this.p.a());
    }

    private void d() {
        if (this.p != null) {
            try {
                LocalBroadcastManager.getInstance(this.f1212c).unregisterReceiver(this.p);
            } catch (Exception e) {
            }
        }
    }

    private String e() {
        if (this.f1233a != null) {
            String urlPrefix = AdSettings.getUrlPrefix();
            Uri parse = Uri.parse((urlPrefix == null || urlPrefix.isEmpty()) ? "https://www.facebook.com/audience_network/server_side_reward" : String.format("https://www.%s.facebook.com/audience_network/server_side_reward", urlPrefix));
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(parse.getScheme());
            builder.authority(parse.getAuthority());
            builder.path(parse.getPath());
            builder.query(parse.getQuery());
            builder.fragment(parse.getFragment());
            builder.appendQueryParameter("puid", this.f1233a.getUserID());
            builder.appendQueryParameter("pc", this.f1233a.getCurrency());
            builder.appendQueryParameter("ptid", this.h);
            builder.appendQueryParameter("appid", this.m);
            return builder.build().toString();
        }
        return null;
    }

    private String f() {
        return this.n;
    }

    public String a() {
        String c2 = this.q != null ? this.q.c(this.i) : "";
        return TextUtils.isEmpty(c2) ? this.i : c2;
    }

    @Override // com.facebook.ads.internal.adapters.x
    public void a(Context context, y yVar, Map<String, Object> map) {
        this.f1211b = yVar;
        this.f1212c = context;
        this.d = false;
        JSONObject jSONObject = (JSONObject) map.get(ShareConstants.WEB_DIALOG_PARAM_DATA);
        this.i = jSONObject.optString("video_url");
        if (this.i == null || this.i.isEmpty()) {
            this.f1211b.a(this, AdError.INTERNAL_ERROR);
            return;
        }
        this.j = jSONObject.optString("video_report_url");
        this.o = jSONObject.optString(UserDataStore.CITY);
        this.k = jSONObject.optString("end_card_markup");
        this.l = jSONObject.optString("activation_command");
        this.n = jSONObject.optString("context_switch", "endvideo");
        this.g = jSONObject.optString("title");
        this.f = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
        if (jSONObject.has("icon") && !jSONObject.isNull("icon")) {
            try {
                this.e = jSONObject.getJSONObject("icon").getString("url");
            } catch (JSONException e) {
                Log.w(m.class.toString(), "Failed to get adIconURL", e);
            }
        }
        String str = (String) map.get("placement_id");
        if (str != null) {
            this.m = str.split(b.a.a.a.a.d.b.ROLL_OVER_FILE_NAME_SEPARATOR)[0];
        } else {
            this.m = "";
        }
        this.p = new z(this.h, this, yVar);
        c();
        this.q = new com.facebook.ads.internal.c.b(context);
        this.q.b(this.i);
        this.q.a(new com.facebook.ads.internal.c.a() { // from class: com.facebook.ads.internal.adapters.m.1
            @Override // com.facebook.ads.internal.c.a
            public void a() {
                m.this.d = true;
                m.this.f1211b.a(m.this);
            }
        });
    }

    @Override // com.facebook.ads.internal.adapters.x
    public boolean b() {
        if (this.d) {
            Intent intent = new Intent(this.f1212c, AudienceNetworkActivity.class);
            intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, AudienceNetworkActivity.Type.REWARDED_VIDEO);
            intent.putExtra(AudienceNetworkActivity.VIDEO_URL, a());
            intent.putExtra(AudienceNetworkActivity.VIDEO_REPORT_URL, this.j);
            if (!com.facebook.ads.internal.h.i(this.f1212c)) {
                intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, 6);
            }
            intent.putExtra(AudienceNetworkActivity.END_CARD_ACTIVATION_COMMAND, this.l);
            intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.h);
            intent.putExtra(AudienceNetworkActivity.END_CARD_MARKUP, com.facebook.ads.internal.util.g.a(this.k));
            intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, this.o);
            intent.putExtra(AudienceNetworkActivity.REWARD_SERVER_URL, e());
            intent.putExtra(AudienceNetworkActivity.CONTEXT_SWITCH_BEHAVIOR, f());
            intent.putExtra(AudienceNetworkActivity.AD_TITLE, this.g);
            intent.putExtra(AudienceNetworkActivity.AD_SUBTITLE, this.f);
            intent.putExtra(AudienceNetworkActivity.AD_ICON_URL, this.e);
            if (!(this.f1212c instanceof Activity)) {
                intent.setFlags(intent.getFlags() | 268435456);
            }
            this.f1212c.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.internal.adapters.AdAdapter
    public void onDestroy() {
        d();
    }
}
