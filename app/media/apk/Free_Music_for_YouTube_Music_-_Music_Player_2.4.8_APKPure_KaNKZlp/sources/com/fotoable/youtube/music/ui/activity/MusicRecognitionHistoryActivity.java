package com.fotoable.youtube.music.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.ads.AdError;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.inject.Inject;
/* loaded from: classes.dex */
public class MusicRecognitionHistoryActivity extends BaseActivity {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.db.a f3553a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<PlayMusicModel> f3554b;

    /* renamed from: c  reason: collision with root package name */
    private Gson f3555c;
    private RecognitionHistoryAdapter d;
    @BindView(R.id.music_recognition_history_back_view)
    ImageView mHistoryBackView;
    @BindView(R.id.music_recognition_history_list)
    ListView mHistoryList;
    @BindView(R.id.music_recognition_history_no_result_view)
    LinearLayout mNoResultView;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_recognition_history;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        this.f3555c = new Gson();
        r();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    private void r() {
        this.f3554b = s();
        if (this.f3554b.size() == 0) {
            this.mNoResultView.setVisibility(0);
            return;
        }
        this.d = new RecognitionHistoryAdapter(this, this.f3554b, getSupportFragmentManager(), this.f3553a);
        this.mHistoryList.setAdapter((ListAdapter) this.d);
        final View inflate = LayoutInflater.from(this).inflate(R.layout.include_search_footer, (ViewGroup) null);
        this.mHistoryList.addFooterView(inflate);
        inflate.setVisibility(0);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionHistoryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MusicRecognitionHistoryActivity.this.d.clear();
                inflate.setVisibility(8);
            }
        });
        this.d.setOnItemClickListener(new RecognitionHistoryAdapter.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionHistoryActivity.2
            @Override // com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.OnItemClickListener
            public void onPlayNow(PlayMusicModel playMusicModel) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, MusicRecognitionHistoryActivity.this.f3554b, MusicRecognitionHistoryActivity.this.f3554b.indexOf(playMusicModel)));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.OnItemClickListener
            public void onPlayNext(PlayMusicModel playMusicModel) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2002, playMusicModel));
            }

            @Override // com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.OnItemClickListener
            public void onAddToPlayQueue(PlayMusicModel playMusicModel) {
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2003, playMusicModel));
            }
        });
    }

    private ArrayList<PlayMusicModel> s() {
        String a2 = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "RECOGNITION_HISTORY", "");
        if (TextUtils.isEmpty(a2)) {
            return new ArrayList<>();
        }
        return (ArrayList) this.f3555c.fromJson(a2, new TypeToken<ArrayList<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionHistoryActivity.3
        }.getType());
    }

    @OnClick({R.id.music_recognition_history_back_view})
    public void onViewClicked() {
        finish();
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                if (this.d != null) {
                    this.d.setIsPlayingID((String) aVar.f2727b);
                    return;
                }
                return;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
            default:
                return;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                if (this.d != null) {
                    this.d.setIsPlayingID("");
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.release();
        }
    }
}
