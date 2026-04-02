package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class TagAdapter<T> {
    private HashSet<Integer> mCheckedPosList = new HashSet<>();
    private OnDataChangedListener mOnDataChangedListener;
    private List<T> mTagDatas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OnDataChangedListener {
        void onChanged();
    }

    public abstract View getView(FlowLayout flowLayout, int i, T t);

    public TagAdapter(List<T> list) {
        this.mTagDatas = list;
    }

    public TagAdapter(T[] tArr) {
        this.mTagDatas = new ArrayList(Arrays.asList(tArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.mOnDataChangedListener = onDataChangedListener;
    }

    public void setSelectedList(int... iArr) {
        for (int i : iArr) {
            this.mCheckedPosList.add(Integer.valueOf(i));
        }
        notifyDataChanged();
    }

    public void setSelectedList(Set<Integer> set) {
        this.mCheckedPosList.clear();
        if (set != null) {
            this.mCheckedPosList.addAll(set);
        }
        notifyDataChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<Integer> getPreCheckedList() {
        return this.mCheckedPosList;
    }

    public int getCount() {
        if (this.mTagDatas == null) {
            return 0;
        }
        return this.mTagDatas.size();
    }

    public void notifyDataChanged() {
        this.mOnDataChangedListener.onChanged();
    }

    public T getItem(int i) {
        return this.mTagDatas.get(i);
    }

    public boolean setSelected(int i, T t) {
        return false;
    }
}
