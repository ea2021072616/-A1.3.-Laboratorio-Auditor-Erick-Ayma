package com.fotoable.youtube.music.ui.adapter;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder;
/* loaded from: classes.dex */
public abstract class FeatureListManager {
    protected static final int RESIDUAL_POSITION = -20;
    public static final int TYPE_BOTTOM = 5;
    public static final int TYPE_EDITOR_CHOICE = 1;
    public static final int TYPE_FEATURED_PLAYLIST = 2;
    public static final int TYPE_FRESH_SONGS = 3;
    public static final int TYPE_HIT_SINGLES = 0;
    public static final int TYPE_HOT_CHARTS = 4;
    private String countryCode;
    private SparseArray<HolderInfo> typeMaps = new SparseArray<>();
    private SparseArray<Integer> postionMaps = new SparseArray<>();
    private SparseArray<Integer> typePositionMaps = new SparseArray<>();

    protected abstract void registerHolderClass();

    public FeatureListManager() {
        registerHolderClass();
    }

    public boolean isContainHolder(int i) {
        return this.postionMaps.indexOfValue(Integer.valueOf(i)) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void register(int i, HolderInfo holderInfo, int i2) {
        this.typeMaps.put(i, holderInfo);
        this.postionMaps.put(i2, Integer.valueOf(i));
        this.typePositionMaps.put(i, Integer.valueOf(i2));
    }

    public int getViewTypeByPosition(int i) {
        int intValue = this.postionMaps.get(i).intValue();
        return intValue >= 0 ? intValue : RESIDUAL_POSITION;
    }

    public int getItemCount() {
        return this.postionMaps.size();
    }

    public int getItemPosition(int i) {
        return this.typePositionMaps.get(i).intValue();
    }

    public AbsHomeItemHolder facotryHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        try {
            return this.typeMaps.get(i).aClass.getConstructor(View.class).newInstance(layoutInflater.inflate(this.typeMaps.get(i).layoutId, viewGroup, false));
        } catch (Exception e) {
            return null;
        }
    }

    public void destory() {
        this.typeMaps.clear();
        this.postionMaps.clear();
        this.typePositionMaps.clear();
    }

    /* loaded from: classes.dex */
    protected static class HolderInfo {
        Class<? extends AbsHomeItemHolder> aClass;
        @LayoutRes
        int layoutId;

        public HolderInfo(Class<? extends AbsHomeItemHolder> cls, @LayoutRes int i) {
            this.aClass = cls;
            this.layoutId = i;
        }
    }
}
