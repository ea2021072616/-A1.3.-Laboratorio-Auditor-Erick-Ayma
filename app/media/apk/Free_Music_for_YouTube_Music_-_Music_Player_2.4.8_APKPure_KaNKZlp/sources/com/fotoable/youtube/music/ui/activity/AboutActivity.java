package com.fotoable.youtube.music.ui.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity {
    @BindView(R.id.app_version_tx)
    LaToTextView appVersionTx;
    @BindView(R.id.back_view)
    ImageView backView;
    @BindView(R.id.icon_join_our_community)
    ImageView iconJoinOurCommunity;
    @BindView(R.id.icon_policy)
    ImageView iconPolicy;
    @BindView(R.id.rl_join_our_community)
    RelativeLayout rlJoinOurCommunity;
    @BindView(R.id.rl_privacy_policy)
    RelativeLayout rlPrivacyPolicy;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_about;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        r();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.back_view, R.id.rl_join_our_community, R.id.rl_privacy_policy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.rl_join_our_community /* 2131820739 */:
                startActivity(new Intent(this, JoinOurCommunityActivity.class));
                com.fotoable.youtube.music.util.b.b("关于-社区界面展示次数");
                return;
            case R.id.rl_privacy_policy /* 2131820741 */:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://cdn-freemusic.fotoable.net/privacy.html")));
                    return;
                } catch (ActivityNotFoundException e) {
                    ThrowableExtension.printStackTrace(e);
                    return;
                }
            default:
                return;
        }
    }

    private void r() {
        try {
            this.appVersionTx.setText("V " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (Exception e) {
        }
    }
}
