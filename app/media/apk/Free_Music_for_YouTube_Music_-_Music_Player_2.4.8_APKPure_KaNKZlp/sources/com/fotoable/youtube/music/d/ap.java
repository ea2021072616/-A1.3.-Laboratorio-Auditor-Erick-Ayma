package com.fotoable.youtube.music.d;

import android.text.TextUtils;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.SearchResultBean;
import com.fotoable.youtube.music.bean.SnippetBean;
import com.fotoable.youtube.music.bean.VideoInfoBean;
import com.fotoable.youtube.music.d.a.o;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/* compiled from: RecognitionPresenter.java */
/* loaded from: classes.dex */
public class ap extends aq<o.a> {

    /* renamed from: a  reason: collision with root package name */
    private com.fotoable.youtube.music.b.e f2505a;

    /* renamed from: b  reason: collision with root package name */
    private o.a f2506b;
    private Gson d = new Gson();

    public ap(com.fotoable.youtube.music.b.e eVar, o.a aVar) {
        this.f2505a = eVar;
        this.f2506b = aVar;
    }

    public void a(String str) {
        a(this.f2505a.b(str).a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<VideoInfoBean>() { // from class: com.fotoable.youtube.music.d.ap.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                com.fotoable.youtube.music.util.b.b("dev_youtube_api_error", "errorName", th.getMessage());
                com.fotoable.youtube.music.util.b.a(th);
                ap.this.f2506b.h_();
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(VideoInfoBean videoInfoBean) {
                if (videoInfoBean == null || videoInfoBean.getItems() == null || videoInfoBean.getItems().size() <= 0) {
                    ap.this.f2506b.h_();
                    return;
                }
                ap.this.f2506b.a(ap.this.a(videoInfoBean.getItems().get(0).getSnippet(), videoInfoBean.getItems().get(0).getId()));
            }
        }));
    }

    public void b(String str) {
        a(this.f2505a.a(str, "").a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<SearchResultBean>() { // from class: com.fotoable.youtube.music.d.ap.2
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
                com.fotoable.youtube.music.util.b.b("dev_youtube_api_error", "errorName", th.getMessage());
                com.fotoable.youtube.music.util.b.a(th);
                ap.this.f2506b.h_();
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(SearchResultBean searchResultBean) {
                if (searchResultBean == null || searchResultBean.getItems() == null || searchResultBean.getItems().size() <= 0) {
                    ap.this.f2506b.h_();
                    return;
                }
                ap.this.f2506b.a(ap.this.a(searchResultBean.getItems().get(0).getSnippet(), searchResultBean.getItems().get(0).getId().getVideoId()));
            }
        }));
    }

    public void a(PlayMusicModel playMusicModel) {
        List<PlayMusicModel> b2 = b();
        if (b2.size() == 0) {
            b2.add(0, playMusicModel);
        } else {
            for (int i = 0; i < b2.size(); i++) {
                if (b2.get(i).getVideoId().equals(playMusicModel.getVideoId())) {
                    return;
                }
            }
            b2.add(0, playMusicModel);
            if (b2.size() >= 10) {
                b2.remove(b2.size() - 1);
            }
        }
        com.fotoable.youtube.music.util.v.b(MusicApplication.c(), "RECOGNITION_HISTORY", this.d.toJson(b2));
    }

    private List<PlayMusicModel> b() {
        String a2 = com.fotoable.youtube.music.util.v.a(MusicApplication.c(), "RECOGNITION_HISTORY", "");
        if (TextUtils.isEmpty(a2)) {
            return new ArrayList();
        }
        return (List) this.d.fromJson(a2, new TypeToken<List<PlayMusicModel>>() { // from class: com.fotoable.youtube.music.d.ap.3
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayMusicModel a(SnippetBean snippetBean, String str) {
        if (snippetBean == null) {
            return null;
        }
        PlayMusicModel playMusicModel = new PlayMusicModel();
        if (snippetBean.getThumbnails() != null && snippetBean.getThumbnails().getHigh() != null) {
            playMusicModel.setCoverImg(snippetBean.getThumbnails().getHigh().getUrl());
        }
        playMusicModel.setVideoId(str);
        playMusicModel.setTitle(snippetBean.getTitle());
        playMusicModel.setDescription(snippetBean.getDescription());
        playMusicModel.setDuration(snippetBean.getDuration());
        com.fotoable.youtube.music.util.h.a(snippetBean.getDescription());
        a(playMusicModel);
        return playMusicModel;
    }

    public void a(rx.m mVar) {
        if (this.f2510c == null) {
            this.f2510c = new rx.g.b();
        }
        this.f2510c.a(mVar);
    }

    @Override // com.fotoable.youtube.music.d.aq
    public void b_() {
        if (this.f2510c != null) {
            this.f2510c.unsubscribe();
            this.f2510c = null;
        }
    }
}
