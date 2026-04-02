package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.activity.SearchActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import java.util.List;
/* loaded from: classes.dex */
public class SuggestAdapter extends android.widget.BaseAdapter {
    private List<String> data;
    private Context mContext;
    private LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.mSuggestTx = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.adapter_suggest_tx, "field 'mSuggestTx'", LaToTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.mSuggestTx = null;
        }
    }

    public SuggestAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.data = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.data.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.view_holder_suggest, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mSuggestTx.setText(this.data.get(i));
        setClickEvent(view, this.data.get(i));
        return view;
    }

    private void setClickEvent(View view, final String str) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.SuggestAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((SearchActivity) SuggestAdapter.this.mContext).b(str);
            }
        });
    }

    public void refresh(List<String> list) {
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    /* loaded from: classes.dex */
    static class ViewHolder {
        @BindView(R.id.adapter_suggest_tx)
        LaToTextView mSuggestTx;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
