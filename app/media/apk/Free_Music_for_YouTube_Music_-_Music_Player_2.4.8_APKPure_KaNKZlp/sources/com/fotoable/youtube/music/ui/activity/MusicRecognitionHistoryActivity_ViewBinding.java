package com.fotoable.youtube.music.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
/* loaded from: classes.dex */
public class MusicRecognitionHistoryActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MusicRecognitionHistoryActivity f3560a;

    /* renamed from: b  reason: collision with root package name */
    private View f3561b;

    @UiThread
    public MusicRecognitionHistoryActivity_ViewBinding(final MusicRecognitionHistoryActivity musicRecognitionHistoryActivity, View view) {
        this.f3560a = musicRecognitionHistoryActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.music_recognition_history_back_view, "field 'mHistoryBackView' and method 'onViewClicked'");
        musicRecognitionHistoryActivity.mHistoryBackView = (ImageView) Utils.castView(findRequiredView, R.id.music_recognition_history_back_view, "field 'mHistoryBackView'", ImageView.class);
        this.f3561b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.MusicRecognitionHistoryActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                musicRecognitionHistoryActivity.onViewClicked();
            }
        });
        musicRecognitionHistoryActivity.mHistoryList = (ListView) Utils.findRequiredViewAsType(view, R.id.music_recognition_history_list, "field 'mHistoryList'", ListView.class);
        musicRecognitionHistoryActivity.mNoResultView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_recognition_history_no_result_view, "field 'mNoResultView'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicRecognitionHistoryActivity musicRecognitionHistoryActivity = this.f3560a;
        if (musicRecognitionHistoryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3560a = null;
        musicRecognitionHistoryActivity.mHistoryBackView = null;
        musicRecognitionHistoryActivity.mHistoryList = null;
        musicRecognitionHistoryActivity.mNoResultView = null;
        this.f3561b.setOnClickListener(null);
        this.f3561b = null;
    }
}
