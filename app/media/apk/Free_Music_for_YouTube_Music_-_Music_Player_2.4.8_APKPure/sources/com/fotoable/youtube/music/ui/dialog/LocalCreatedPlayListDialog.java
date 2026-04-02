package com.fotoable.youtube.music.ui.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
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
import com.fotoable.youtube.music.bean.LocalPlayListModel;
import com.fotoable.youtube.music.bean.LocalPlayListMusicModel;
import com.fotoable.youtube.music.bean.LocalSongBean;
import com.fotoable.youtube.music.ui.adapter.LocalPlayListSelectAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LocalCreatedPlayListDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4123b = LocalCreatedPlayListDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Unbinder f4124a;

    /* renamed from: c  reason: collision with root package name */
    private FragmentManager f4125c;
    private LocalSongBean d;
    private List<LocalPlayListModel> e;
    private rx.g.b f;
    private com.fotoable.youtube.music.db.a g;
    private AdapterView.OnItemClickListener h = new AdapterView.OnItemClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.LocalCreatedPlayListDialog.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                LocalPlayListEditDialog.a(LocalCreatedPlayListDialog.this.getFragmentManager(), LocalCreatedPlayListDialog.this.d);
            }
            if (i == 1) {
                LocalCreatedPlayListDialog.this.c();
                LocalCreatedPlayListDialog.this.dismiss();
            }
            if (LocalCreatedPlayListDialog.this.d != null && i > 1) {
                LocalPlayListMusicModel localPlayListMusicModel = new LocalPlayListMusicModel();
                localPlayListMusicModel.setSongId(LocalCreatedPlayListDialog.this.d.getSongId());
                localPlayListMusicModel.setPlayListId(((LocalPlayListModel) LocalCreatedPlayListDialog.this.e.get(i - 2)).getId());
                localPlayListMusicModel.setCreateTime(Long.valueOf(System.currentTimeMillis()));
                LocalCreatedPlayListDialog.this.g.a(localPlayListMusicModel);
                Toast.makeText(MusicApplication.c(), (int) R.string.added, 0).show();
                LocalCreatedPlayListDialog.this.dismiss();
                com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
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
        this.f4124a = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4124a.unbind();
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
        a(this.g.q().a(com.fotoable.youtube.music.util.s.a()).a(new rx.g<List<LocalPlayListModel>>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalCreatedPlayListDialog.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(List<LocalPlayListModel> list) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                LocalCreatedPlayListDialog.this.e = list;
                LocalCreatedPlayListDialog.this.mPlayList.setAdapter((ListAdapter) new LocalPlayListSelectAdapter(LocalCreatedPlayListDialog.this.getContext(), list, LocalCreatedPlayListDialog.this.d));
            }
        }));
        a(com.fotoable.youtube.music.e.b.a().a(com.fotoable.youtube.music.e.a.class, new rx.c.b<com.fotoable.youtube.music.e.a>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalCreatedPlayListDialog.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(com.fotoable.youtube.music.e.a aVar) {
                switch (aVar.f2726a) {
                    case 2015:
                        LocalCreatedPlayListDialog.this.dismiss();
                        return;
                    default:
                        return;
                }
            }
        }));
    }

    public static LocalCreatedPlayListDialog a(FragmentManager fragmentManager, LocalSongBean localSongBean) {
        LocalCreatedPlayListDialog localCreatedPlayListDialog;
        Exception e;
        try {
            localCreatedPlayListDialog = new LocalCreatedPlayListDialog();
            try {
                localCreatedPlayListDialog.f4125c = fragmentManager;
                localCreatedPlayListDialog.d = localSongBean;
                fragmentManager.beginTransaction().add(localCreatedPlayListDialog, "LocalCreatedPlayListDialog").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                ThrowableExtension.printStackTrace(e);
                return localCreatedPlayListDialog;
            }
        } catch (Exception e3) {
            localCreatedPlayListDialog = null;
            e = e3;
        }
        return localCreatedPlayListDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            if (this.f4125c != null) {
                this.f4125c.beginTransaction().remove(this).commitAllowingStateLoss();
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
        if (this.d != null) {
            a(this.g.a(this.d).a(com.fotoable.youtube.music.util.s.a()).b(new rx.l<Boolean>() { // from class: com.fotoable.youtube.music.ui.dialog.LocalCreatedPlayListDialog.3
                @Override // rx.g
                public void onCompleted() {
                }

                @Override // rx.g
                public void onError(Throwable th) {
                    ThrowableExtension.printStackTrace(th);
                }

                @Override // rx.g
                /* renamed from: a */
                public void onNext(Boolean bool) {
                    com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a(2015));
                    Toast.makeText(MusicApplication.c(), (int) R.string.added, 0).show();
                }
            }));
        }
    }

    @OnClick({R.id.dialog_play_list_root})
    public void onViewClicked() {
        dismiss();
    }
}
