package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class JoinOurCommunityActivity extends BaseActivity {
    @BindView(R.id.title_panel)
    LinearLayout title_panel;
    @BindView(R.id.top_panel)
    RelativeLayout top_panel;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_join_our_community;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.top_panel.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = getResources().getDisplayMetrics().widthPixels;
            layoutParams.height = (int) (layoutParams.width * 0.51111114f);
            this.top_panel.setLayoutParams(layoutParams);
            this.title_panel.setPadding(0, 0, 0, (int) (layoutParams.height * 0.14507772f));
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    @OnClick({R.id.back_view, R.id.bt_join_us})
    public void onClick(View view) {
        boolean z;
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.bt_join_us /* 2131820791 */:
                try {
                    if (getPackageManager().getLaunchIntentForPackage("com.facebook.katana") != null) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("fb://group/225134928002507")));
                        z = true;
                        com.fotoable.youtube.music.util.b.b("Settings-Community-JoinUs");
                    } else {
                        z = false;
                    }
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    z = false;
                }
                if (!z) {
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/groups/225134928002507/")));
                        return;
                    } catch (Exception e2) {
                        ThrowableExtension.printStackTrace(e2);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
