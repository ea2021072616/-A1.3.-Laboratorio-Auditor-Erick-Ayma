package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayListModel;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.ui.adapter.PlayListSelectAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AddPlayListDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4026b = AddPlayListDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4027a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4028c;
    private PlayMusicModel d;
    private List<PlayListModel> e;
    private rx.g.b f;
    private com.fotoable.youtube.music.db.a g;
    private AdapterView.OnItemClickListener h = new AdapterView.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.AddPlayListDialog.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                PlayListEditDialog.a(AddPlayListDialog.this.getFragmentManager(), AddPlayListDialog.this.d);
                com.fotoable.youtube.music.util.b.b("在线音乐-点击创建歌单");
            }
            if (i == 1) {
                AddPlayListDialog.this.c();
                AddPlayListDialog.this.dismiss();
            }
            if (AddPlayListDialog.this.d != null && i > 1) {
                AddPlayListDialog.this.d.setId(null);
                AddPlayListDialog.this.d.setPlaylistId(((PlayListModel) AddPlayListDialog.this.e.get(i - 2)).getId());
                AddPlayListDialog.this.g.a(AddPlayListDialog.this.d);
                Toast.makeText(MusicApplication.c(), (int) R.string.added, 0).show();
                AddPlayListDialog.this.dismiss();
                com.fotoable.youtube.music.util.b.b("在线音乐-添加音乐到歌单");
            }
        }
    };
    @BindView(R.id.dialog_play_list)
    ListView mPlayList;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_add_to_playlist, viewGroup, false);
        this.f4027a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4027a.unbind();
        b();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setCancelable(true);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mPlayList.setOnItemClickListener(this.h);
        a();
    }

    private void a() {
        this.g = MusicApplication.c().e().d();
        a(this.g.h().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<PlayListModel>>() { // from class: com.fotoable.youtube.music.ui.dialog.AddPlayListDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<PlayListModel> list) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                AddPlayListDialog.this.e = list;
                AddPlayListDialog.this.mPlayList.setAdapter((ListAdapter) new PlayListSelectAdapter(AddPlayListDialog.this.getActivity(), list, AddPlayListDialog.this.d));
            }
        }));
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.dialog.AddPlayListDialog.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 1039:
                        Toast.makeText(AddPlayListDialog.this.getActivity(), (int) R.string.added, 0).show();
                        AddPlayListDialog.this.dismiss();
                        return;
                    default:
                        return;
                }
            }
        }));
    }

    public static AddPlayListDialog a(FragmentManager fragmentManager, PlayMusicModel playMusicModel) {
        AddPlayListDialog addPlayListDialog;
        Exception e;
        try {
            addPlayListDialog = new AddPlayListDialog();
            try {
                addPlayListDialog.f4028c = fragmentManager;
                addPlayListDialog.d = playMusicModel;
                fragmentManager.beginTransaction().add(addPlayListDialog, "AddPlayListDialog").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                ThrowableExtension.printStackTrace(e);
                return addPlayListDialog;
            }
        } catch (Exception e3) {
            addPlayListDialog = null;
            e = e3;
        }
        return addPlayListDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4028c != null) {
                this.f4028c.beginTransaction().remove(this).commitAllowingStateLoss();
            }
            super.dismiss();
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private void a(rx.m mVar) {
        if (this.f == null) {
            this.f = new rx.g.b();
        }
        this.f.a(mVar);
    }

    private void b() {
        if (this.f != null) {
            this.f.unsubscribe();
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null && !TextUtils.isEmpty(this.d.getVideoId())) {
            final FavBean favBean = new FavBean();
            favBean.setVideoid(this.d.getVideoId());
            favBean.setTitle(this.d.getTitle());
            favBean.setDesc(this.d.getDescription());
            favBean.setImgUrl(this.d.getCoverImg());
            favBean.setIsFav(1);
            favBean.setDuration(this.d.getDuration());
            favBean.setArtists(this.d.getArtists());
            a(this.g.a(favBean).a(com.fotoable.youtube.music.util.s.a()).b(new rx.c.b<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.AddPlayListDialog.3
                @Override // rx.c.b
                /* renamed from: a */
                public void call(Boolean bool) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) PointerIconCompat.TYPE_HELP, favBean));
                    Toast.makeText(AddPlayListDialog.this.getActivity(), (int) R.string.added, 0).show();
                    AddPlayListDialog.this.dismiss();
                }
            }));
        }
    }

    @OnClick({R.id.dialog_play_list_root})
    public void onViewClicked() {
        dismiss();
    }
}
