package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
/* loaded from: classes.dex */
public class ArtistsActivity extends BaseActivity {
    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_artists;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        com.fotoable.youtube.music.util.b.b("Artists-歌手库-展示");
        com.fotoable.youtube.music.util.b.a("Artists-歌手库-展示");
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.back_view})
    public void onViewClicked() {
        finish();
    }
}
