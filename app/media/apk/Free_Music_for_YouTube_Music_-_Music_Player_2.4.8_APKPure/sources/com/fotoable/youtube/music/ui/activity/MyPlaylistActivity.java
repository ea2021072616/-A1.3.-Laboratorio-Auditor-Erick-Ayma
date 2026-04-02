package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.ui.adapter.MyPlayListAdapter;
import com.fotoable.youtube.music.ui.dialog.PlayListEditDialog;
import java.util.List;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MyPlaylistActivity extends BaseActivity {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3575a;

    /* renamed from: b  reason: collision with root package name */
    private MyPlayListAdapter f3576b;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_top)
    ImageView imgTop;
    @BindView(R.id.my_playlist_listView)
    ListView mListView;
    @BindView(R.id.rel_toolbar)
    RelativeLayout relToolbar;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_my_playlist;
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

    private void r() {
        a(this.f3575a.h().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<PlayListModel>>() { // from class: com.fotoable.youtube.music.ui.activity.MyPlaylistActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<PlayListModel> list) {
                if (list != null) {
                    MyPlaylistActivity.this.f3576b = new MyPlayListAdapter(MyPlaylistActivity.this, list, MyPlaylistActivity.this.f3575a);
                    MyPlaylistActivity.this.mListView.setAdapter((ListAdapter) MyPlaylistActivity.this.f3576b);
                }
            }
        }));
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case 1039:
                PlayListModel b2 = this.f3575a.b((Long) aVar.f2727b);
                if (b2 != null) {
                    this.f3576b.add(b2);
                    return;
                }
                return;
            case 1040:
                String str = aVar.f2728c;
                this.f3576b.updateName((Long) aVar.f2727b, str);
                return;
            case 1041:
                this.f3576b.updateCount((Long) aVar.f2727b);
                return;
            case 1042:
                this.f3576b.delete((Long) aVar.f2727b);
                return;
            default:
                return;
        }
    }

    @OnClick({R.id.img_back, R.id.img_add_playlist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back /* 2131820756 */:
                finish();
                return;
            case R.id.img_add_playlist /* 2131820836 */:
                PlayListEditDialog.a(getSupportFragmentManager(), null);
                return;
            default:
                return;
        }
    }
}
