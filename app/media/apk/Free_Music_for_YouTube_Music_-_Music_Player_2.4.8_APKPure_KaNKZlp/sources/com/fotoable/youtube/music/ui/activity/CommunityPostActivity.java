package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.bean.CommentCounter;
import com.fotoable.youtube.music.bean.CommentCounterDataModel;
import com.fotoable.youtube.music.bean.MyHttpResponse;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.bean.PostImageBean;
import com.fotoable.youtube.music.bean.PostUserInfoBean;
import com.fotoable.youtube.music.bean.PostUserInfoDataBean;
import com.fotoable.youtube.music.ui.adapter.CommunityPostCreateImageAdapter;
import com.fotoable.youtube.music.ui.adapter.GridSpacingItemDecoration;
import com.fotoable.youtube.music.ui.dialog.g;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.yanzhenjie.album.AlbumFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
/* loaded from: classes.dex */
public class CommunityPostActivity extends BaseActivity {

    /* renamed from: c  reason: collision with root package name */
    private static final String f3210c = CommunityPostActivity.class.getSimpleName();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3211a;

    /* renamed from: b  reason: collision with root package name */
    com.fotoable.youtube.music.ui.dialog.n f3212b;
    private List<String> d;
    private CommunityPostCreateImageAdapter e;
    @BindView(R.id.et_post_content)
    EditText etPostContent;
    private String f = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    private boolean g = false;
    private PlayMusicModel h;
    @BindView(R.id.iv_post_video_cover)
    ImageView ivPostVideoCover;
    @BindView(R.id.ll_post_video)
    RelativeLayout llPostVideo;
    @BindView(R.id.rl_post_type_panel)
    RelativeLayout rl_post_type_panel;
    @BindView(R.id.rv_post_image)
    RecyclerView rvPostImage;
    @BindView(R.id.tv_post_type)
    LaToTextView tvPostType;
    @BindView(R.id.tv_post_video_artists)
    LaToTextView tvPostVideoArtists;
    @BindView(R.id.tv_post_video_time)
    LaToTextView tvPostVideoTime;
    @BindView(R.id.tv_post_video_title)
    LaToTextView tvPostVideoTitle;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_community_post;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("music")) {
                this.h = (PlayMusicModel) intent.getParcelableExtra("music");
                a(this.h);
            } else {
                try {
                    String a2 = com.fotoable.youtube.music.util.v.a(this, com.fotoable.youtube.music.b.u, (String) null);
                    if (!TextUtils.isEmpty(a2)) {
                        this.h = (PlayMusicModel) new Gson().fromJson(a2, (Class<Object>) PlayMusicModel.class);
                        a(this.h);
                    }
                } catch (JsonSyntaxException e) {
                    ThrowableExtension.printStackTrace(e);
                }
            }
            if (intent.hasExtra("postType")) {
                this.f = intent.getStringExtra("postType");
                u();
            } else {
                this.f = com.fotoable.youtube.music.util.v.a(this, com.fotoable.youtube.music.b.r, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                u();
            }
        }
        v();
        com.fotoable.youtube.music.util.b.b("发帖界面-展示次数");
    }

    private void u() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            this.tvPostType.setText(R.string.music_resources);
            return;
        }
        String str = this.f;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.tvPostType.setText(R.string.music_resources);
                return;
            case 1:
                this.tvPostType.setText(R.string.lyrics);
                return;
            case 2:
                this.tvPostType.setText(R.string.share_your_music);
                return;
            case 3:
                this.tvPostType.setText(R.string.wallpapers);
                return;
            case 4:
                this.tvPostType.setText(R.string.feedback);
                return;
            default:
                this.f = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                this.tvPostType.setText(R.string.music_resources);
                return;
        }
    }

    private void v() {
        ArrayList<AlbumFile> arrayList;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(4, (int) (getResources().getDisplayMetrics().density * 8.0f), false);
        this.d = new ArrayList();
        this.e = new CommunityPostCreateImageAdapter(this, this.d);
        try {
            String a2 = com.fotoable.youtube.music.util.v.a(this, com.fotoable.youtube.music.b.t, (String) null);
            if (!TextUtils.isEmpty(a2) && (arrayList = (ArrayList) new Gson().fromJson(a2, new TypeToken<ArrayList<AlbumFile>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity.1
            }.getType())) != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    this.d.add(arrayList.get(i).getPath());
                }
                this.e.setmAlbumFiles(arrayList);
            }
        } catch (JsonSyntaxException e) {
            ThrowableExtension.printStackTrace(e);
        }
        this.d.add("+");
        this.rvPostImage.setLayoutManager(gridLayoutManager);
        this.rvPostImage.addItemDecoration(gridSpacingItemDecoration);
        this.rvPostImage.setAdapter(this.e);
        String a3 = com.fotoable.youtube.music.util.v.a(this, com.fotoable.youtube.music.b.s, (String) null);
        if (!TextUtils.isEmpty(a3)) {
            this.etPostContent.setText(a3);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.back_view, R.id.tv_post_send, R.id.rl_post_type_panel, R.id.ll_post_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.tv_post_send /* 2131820767 */:
                w();
                return;
            case R.id.rl_post_type_panel /* 2131820768 */:
                com.fotoable.youtube.music.ui.dialog.g.b(getApplicationContext(), this.tvPostType, new g.a() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity.2
                    @Override // com.fotoable.youtube.music.ui.dialog.g.a
                    public void a(String str, int i) {
                        CommunityPostActivity.this.f = str;
                        CommunityPostActivity.this.tvPostType.setText(i);
                    }
                });
                return;
            case R.id.ll_post_video /* 2131820774 */:
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("isSelectedMusic", true);
                startActivityForResult(intent, 1001);
                return;
            default:
                return;
        }
    }

    private void w() {
        if (this.g) {
            this.f3212b = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.sending, e.f3995a);
            return;
        }
        final String trim = this.etPostContent.getText().toString().trim();
        if (TextUtils.isEmpty(trim) && ((this.d == null || this.d.size() <= 1) && this.h == null)) {
            Toast.makeText(this, (int) R.string.commit_empty_content_warn, 0).show();
            return;
        }
        this.f3212b = com.fotoable.youtube.music.ui.dialog.n.a(getSupportFragmentManager(), (int) R.string.sending, f.f3996a);
        this.g = true;
        a(rx.f.a(this.d).c(new rx.c.e(this) { // from class: com.fotoable.youtube.music.ui.activity.g

            /* renamed from: a  reason: collision with root package name */
            private final CommunityPostActivity f3997a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f3997a = this;
            }

            @Override // rx.c.e
            public Object a(Object obj) {
                return this.f3997a.a((List) obj);
            }
        }).b(new rx.c.e<List<File>, rx.f<MyHttpResponse<PostBean>>>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity.4
            @Override // rx.c.e
            public rx.f<MyHttpResponse<PostBean>> a(List<File> list) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5 = null;
                if (CommunityPostActivity.this.h != null) {
                    str4 = CommunityPostActivity.this.h.getVideoId();
                    str3 = CommunityPostActivity.this.h.getTitle();
                    str2 = CommunityPostActivity.this.h.getArtists();
                    str = CommunityPostActivity.this.h.getDuration();
                    str5 = CommunityPostActivity.this.h.getCoverImg();
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                ArrayList arrayList = new ArrayList();
                for (File file : list) {
                    com.fotoable.youtube.music.util.h.a(CommunityPostActivity.f3210c, "上传的图片:" + file.getAbsolutePath());
                    arrayList.add(MultipartBody.Part.createFormData("images[]", file.getName(), RequestBody.create(MediaType.parse("image/png"), file)));
                }
                return CommunityPostActivity.this.f3211a.a(CommunityPostActivity.this.f, trim, str4, str3, str2, str5, str, Locale.getDefault().getLanguage(), arrayList);
            }
        }).a(com.fotoable.youtube.music.util.s.a()).a(com.fotoable.youtube.music.util.s.b()).b(new rx.l<PostBean>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostActivity.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                CommunityPostActivity.this.g = false;
                Toast.makeText(CommunityPostActivity.this, (int) R.string.wearing_network_connect_error, 0).show();
                if (CommunityPostActivity.this.f3212b != null) {
                    CommunityPostActivity.this.f3212b.dismiss();
                }
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(PostBean postBean) {
                int i = 0;
                CommunityPostActivity.this.g = false;
                com.fotoable.youtube.music.util.h.a(CommunityPostActivity.f3210c, "发布成功：" + postBean.toString());
                Toast.makeText(CommunityPostActivity.this, (int) R.string.send_post_success, 0).show();
                PostBean postBean2 = new PostBean();
                postBean2.setBigId(postBean.getBigId());
                postBean2.setBody(trim);
                postBean2.setCategoryId(Integer.valueOf(CommunityPostActivity.this.f).intValue());
                if (CommunityPostActivity.this.h != null) {
                    postBean2.setVideoId(CommunityPostActivity.this.h.getVideoId());
                    postBean2.setVideoArtists(CommunityPostActivity.this.h.getArtists());
                    postBean2.setVideoDuration(CommunityPostActivity.this.h.getDuration());
                    postBean2.setVideoTitle(CommunityPostActivity.this.h.getTitle());
                    postBean2.setVideoImgUrl(CommunityPostActivity.this.h.getCoverImg());
                }
                postBean2.setCreatedAt(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int i2 = i;
                    if (CommunityPostActivity.this.d == null || i2 >= CommunityPostActivity.this.d.size()) {
                        break;
                    }
                    if (!TextUtils.equals((CharSequence) CommunityPostActivity.this.d.get(i2), "+")) {
                        PostImageBean postImageBean = new PostImageBean();
                        postImageBean.setImgUrl((String) CommunityPostActivity.this.d.get(i2));
                        postImageBean.setThumbUrl((String) CommunityPostActivity.this.d.get(i2));
                        arrayList.add(postImageBean);
                    }
                    i = i2 + 1;
                }
                postBean2.setImgUrl(arrayList);
                PostUserInfoBean postUserInfoBean = new PostUserInfoBean();
                PostUserInfoDataBean postUserInfoDataBean = new PostUserInfoDataBean();
                postUserInfoBean.setData(postUserInfoDataBean);
                if (MusicApplication.c().h() != null) {
                    postUserInfoDataBean.setAvatar(MusicApplication.c().h().getAvatar());
                    postUserInfoDataBean.setName(MusicApplication.c().h().getName());
                    postUserInfoDataBean.setUid(MusicApplication.c().h().getUid());
                }
                postBean2.setUserInfo(postUserInfoBean);
                CommentCounter commentCounter = new CommentCounter();
                CommentCounterDataModel commentCounterDataModel = new CommentCounterDataModel();
                commentCounter.setData(commentCounterDataModel);
                commentCounterDataModel.setComments_like_count(0L);
                commentCounterDataModel.setCommentsCount(0L);
                postBean2.setCounter(commentCounter);
                if (CommunityPostActivity.this.f3212b != null) {
                    CommunityPostActivity.this.f3212b.dismiss();
                }
                CommunityPostActivity.this.f = null;
                CommunityPostActivity.this.etPostContent.setText("");
                CommunityPostActivity.this.d = null;
                CommunityPostActivity.this.h = null;
                com.fotoable.youtube.music.util.v.b(CommunityPostActivity.this, com.fotoable.youtube.music.b.r, (String) null);
                com.fotoable.youtube.music.util.v.b(CommunityPostActivity.this, com.fotoable.youtube.music.b.s, (String) null);
                com.fotoable.youtube.music.util.v.b(CommunityPostActivity.this, com.fotoable.youtube.music.b.t, (String) null);
                com.fotoable.youtube.music.util.v.b(CommunityPostActivity.this, com.fotoable.youtube.music.b.u, (String) null);
                Intent intent = new Intent();
                intent.putExtra("model", postBean2);
                CommunityPostActivity.this.setResult(-1, intent);
                CommunityPostActivity.this.finish();
            }
        }));
        com.fotoable.youtube.music.util.b.b("发帖界面-发帖次数");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ List a(List list) {
        ArrayList arrayList = new ArrayList();
        com.fotoable.youtube.music.util.h.a(f3210c, "开始压缩图片");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.size()) {
                if (!TextUtils.equals(this.d.get(i2), "+")) {
                    try {
                        arrayList.add(com.fotoable.youtube.music.util.w.a(BitmapFactory.decodeFile(this.d.get(i2)), this.d.get(i2)));
                    } catch (Exception e) {
                        ThrowableExtension.printStackTrace(e);
                    }
                }
                i = i2 + 1;
            } else {
                com.fotoable.youtube.music.util.h.a(f3210c, "结束压缩图片");
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            com.fotoable.youtube.music.util.h.a(f3210c, "model:" + intent.hasExtra("model"));
            if (intent.hasExtra("model")) {
                a((PlayMusicModel) intent.getParcelableExtra("model"));
            }
        }
    }

    private void a(PlayMusicModel playMusicModel) {
        this.h = playMusicModel;
        if (playMusicModel != null) {
            com.bumptech.glide.i.a((FragmentActivity) this).a(playMusicModel.getCoverImg()).d((int) R.mipmap.pic_recently).c((int) R.mipmap.pic_recently).b(com.bumptech.glide.load.b.b.ALL).a(this.ivPostVideoCover);
            this.tvPostVideoTitle.setText(playMusicModel.getTitle() + "");
            if (TextUtils.isEmpty(playMusicModel.getArtists())) {
                this.tvPostVideoArtists.setVisibility(8);
                this.tvPostVideoTitle.setMaxLines(2);
                return;
            }
            this.tvPostVideoArtists.setVisibility(0);
            this.tvPostVideoArtists.setText(playMusicModel.getArtists() + "");
            this.tvPostVideoTitle.setMaxLines(1);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void c() {
        com.fotoable.youtube.music.newplayer.e.a().a(this, 2404);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fotoable.youtube.music.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.r, this.f);
            String trim = this.etPostContent.getText().toString().trim();
            com.fotoable.youtube.music.util.h.a(f3210c, "文本内容：" + trim);
            com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.s, trim);
            if (this.d != null && this.d.size() > 1) {
                if (this.e != null && this.e.getAlbumFiles() != null) {
                    String json = new Gson().toJson(this.e.getAlbumFiles());
                    com.fotoable.youtube.music.util.h.a(f3210c, "图片：" + json);
                    com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.t, json);
                }
            } else {
                com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.t, (String) null);
            }
            if (this.h != null) {
                String json2 = new Gson().toJson(this.h);
                com.fotoable.youtube.music.util.h.a(f3210c, "音乐：" + json2);
                com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.u, json2);
                return;
            }
            com.fotoable.youtube.music.util.v.b(this, com.fotoable.youtube.music.b.u, (String) null);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}
