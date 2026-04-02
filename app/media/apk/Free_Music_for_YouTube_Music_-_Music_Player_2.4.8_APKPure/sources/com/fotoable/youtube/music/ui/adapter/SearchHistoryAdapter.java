package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.activity.SearchActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchHistoryAdapter extends android.widget.BaseAdapter {
    private List<String> allData = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.mKeywordTx = (TextView) Utils.findRequiredViewAsType(view, R.id.adapter_search_history_keyword_tx, "field 'mKeywordTx'", TextView.class);
            viewHolder.mDeleteImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.adapter_search_history_delete_img, "field 'mDeleteImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.mKeywordTx = null;
            viewHolder.mDeleteImg = null;
        }
    }

    public SearchHistoryAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.allData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.view_holder_search_history, (ViewGroup) null);
            ViewHolder viewHolder2 = new ViewHolder(view);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mKeywordTx.setText(this.allData.get(i));
        setDeleteHistoryListener(viewHolder.mDeleteImg, this.allData.get(i));
        setSearchListener(viewHolder.mKeywordTx, this.allData.get(i));
        return view;
    }

    private void setDeleteHistoryListener(View view, final String str) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SearchHistoryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SearchHistoryAdapter.this.allData.remove(str);
                SearchHistoryAdapter.this.notifyDataSetChanged();
                ((SearchActivity) SearchHistoryAdapter.this.mContext).a(str);
            }
        });
    }

    private void setSearchListener(View view, final String str) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SearchHistoryAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((SearchActivity) SearchHistoryAdapter.this.mContext).b(str);
            }
        });
    }

    public void LoadMore(List<String> list) {
        this.allData.addAll(list);
        notifyDataSetChanged();
    }

    public void refresh(List<String> list) {
        this.allData.clear();
        this.allData.addAll(list);
        notifyDataSetChanged();
    }

    public void clearAll() {
        this.allData.clear();
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    static class ViewHolder {
        @BindView(R.id.adapter_search_history_delete_img)
        ImageView mDeleteImg;
        @BindView(R.id.adapter_search_history_keyword_tx)
        TextView mKeywordTx;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
