package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentManager;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.bean.FavBean;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.db.a;
import com.fotoable.youtube.music.helper.d;
import com.fotoable.youtube.music.ui.dialog.MusicMenuDialog;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.fotoable.youtube.music.util.m;
import com.fotoable.youtube.music.util.s;
import com.fotoable.youtube.music.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.g.b;
import rx.l;
/* loaded from: classes.dex */
public class RecognitionHistoryAdapter extends android.widget.BaseAdapter {
    private FragmentManager fragmentManager;
    private a greenDaoHelper;
    private ArrayList<PlayMusicModel> list;
    private b mCompositeSubscription;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener onItemClickListener;
    private String isPlayingID = "";
    private HashMap<String, String> map = new HashMap<>();

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onAddToPlayQueue(PlayMusicModel playMusicModel);

        void onPlayNext(PlayMusicModel playMusicModel);

        void onPlayNow(PlayMusicModel playMusicModel);
    }

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.ivIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
            viewHolder.textTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.text_time, "field 'textTime'", LaToTextView.class);
            viewHolder.txtTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_title, "field 'txtTitle'", TextView.class);
            viewHolder.txtContent = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_content, "field 'txtContent'", TextView.class);
            viewHolder.linDesc = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_desc, "field 'linDesc'", LinearLayout.class);
            viewHolder.btnMenu = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_menu, "field 'btnMenu'", ImageView.class);
            viewHolder.rlDetails = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_details, "field 'rlDetails'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.ivIcon = null;
            viewHolder.textTime = null;
            viewHolder.txtTitle = null;
            viewHolder.txtContent = null;
            viewHolder.linDesc = null;
            viewHolder.btnMenu = null;
            viewHolder.rlDetails = null;
        }
    }

    public RecognitionHistoryAdapter(Context context, ArrayList<PlayMusicModel> arrayList, FragmentManager fragmentManager, a aVar) {
        this.mContext = context;
        this.list = arrayList;
        this.fragmentManager = fragmentManager;
        this.greenDaoHelper = aVar;
        this.mInflater = LayoutInflater.from(context);
        m.a().a(getIds(arrayList), this.map, new m.a() { // from class: com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.1
            @Override // com.fotoable.youtube.music.util.m.a
            public void onDuration(HashMap<String, String> hashMap) {
                RecognitionHistoryAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void setIsPlayingID(String str) {
        this.isPlayingID = str;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.view_playlist_details_item, viewGroup, false);
            ViewHolder viewHolder2 = new ViewHolder(view);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final PlayMusicModel playMusicModel = this.list.get(i);
        if (!TextUtils.isEmpty(this.map.get(playMusicModel.getVideoId()))) {
            playMusicModel.setDuration(this.map.get(playMusicModel.getVideoId()));
            viewHolder.textTime.setText(this.map.get(playMusicModel.getVideoId()));
            viewHolder.textTime.setVisibility(0);
        } else {
            viewHolder.textTime.setVisibility(8);
        }
        if (playMusicModel.getVideoId().equalsIgnoreCase(this.isPlayingID)) {
            viewHolder.txtTitle.setTextColor(SupportMenu.CATEGORY_MASK);
            viewHolder.txtContent.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            viewHolder.txtTitle.setTextColor(this.mContext.getResources().getColor(R.color.favorite_title));
            viewHolder.txtContent.setTextColor(this.mContext.getResources().getColor(R.color.favorite_desc));
        }
        viewHolder.txtTitle.setText(playMusicModel.getTitle());
        viewHolder.txtContent.setVisibility(8);
        d.a(this.mContext, playMusicModel.getCoverImg(), viewHolder.ivIcon);
        viewHolder.rlDetails.setOnClickListener(new View.OnClickListener(this, playMusicModel) { // from class: com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter$$Lambda$0
            private final RecognitionHistoryAdapter arg$1;
            private final PlayMusicModel arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = playMusicModel;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                this.arg$1.lambda$getView$0$RecognitionHistoryAdapter(this.arg$2, view2);
            }
        });
        viewHolder.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new MusicMenuDialog.b(RecognitionHistoryAdapter.this.fragmentManager).a(playMusicModel).a(RecognitionHistoryAdapter.this.list).b(i).a(true).a().e();
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$getView$0$RecognitionHistoryAdapter(PlayMusicModel playMusicModel, View view) {
        if (this.onItemClickListener != null) {
            this.onItemClickListener.onPlayNow(playMusicModel);
        }
    }

    private List<String> getIds(List<PlayMusicModel> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(list.get(i2).getVideoId());
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void queryFav(final PlayMusicModel playMusicModel, final CheckBox checkBox) {
        addSubscribe(this.greenDaoHelper.d(playMusicModel.getVideoId()).a(s.a()).b(new l<List<FavBean>>() { // from class: com.fotoable.youtube.music.ui.adapter.RecognitionHistoryAdapter.3
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
            }

            @Override // rx.g
            public void onNext(List<FavBean> list) {
                if (list != null && list.size() > 0) {
                    playMusicModel.setFav(true);
                    checkBox.setChecked(true);
                    return;
                }
                checkBox.setChecked(false);
                playMusicModel.setFav(false);
            }
        }));
    }

    public void release() {
        unSubscribe();
    }

    public void clear() {
        this.list.clear();
        notifyDataSetChanged();
        v.b(this.mContext, "RECOGNITION_HISTORY", "");
    }

    private void addSubscribe(rx.m mVar) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new b();
        }
        this.mCompositeSubscription.a(mVar);
    }

    private void unSubscribe() {
        if (this.mCompositeSubscription != null && !this.mCompositeSubscription.isUnsubscribed()) {
            this.mCompositeSubscription.unsubscribe();
            this.mCompositeSubscription = null;
        }
    }

    /* loaded from: classes.dex */
    static class ViewHolder {
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.lin_desc)
        LinearLayout linDesc;
        @BindView(R.id.rl_details)
        RelativeLayout rlDetails;
        @BindView(R.id.text_time)
        LaToTextView textTime;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_title)
        TextView txtTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
