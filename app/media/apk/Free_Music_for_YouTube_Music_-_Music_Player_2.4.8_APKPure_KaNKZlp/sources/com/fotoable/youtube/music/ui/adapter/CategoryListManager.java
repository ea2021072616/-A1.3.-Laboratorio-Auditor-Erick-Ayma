package com.fotoable.youtube.music.ui.adapter;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.youtube.music.ui.adapter.holder.AbsHomeItemHolder;
/* loaded from: classes.dex */
public abstract class CategoryListManager {
    protected static final int RESIDUAL_POSITION = -20;
    public static final int TYPE_BOTTOM = 3;
    public static final int TYPE_DECADES = 1;
    public static final int TYPE_GENRES = 2;
    public static final int TYPE_MOOD = 0;
    private String countryCode;
    private SparseArray<HolderInfo> typeMap = new SparseArray<>();
    private SparseArray<Integer> positionMap = new SparseArray<>();
    private SparseArray<Integer> typePositionMaps = new SparseArray<>();

    protected abstract void registerHolderClass();

    public CategoryListManager() {
        registerHolderClass();
    }

    private void clear() {
        this.typeMap.clear();
        this.positionMap.clear();
        this.typePositionMaps.clear();
    }

    public boolean isContainHolder(int i) {
        return this.positionMap.indexOfValue(Integer.valueOf(i)) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void register(int i, HolderInfo holderInfo, int i2) {
        this.typeMap.put(i, holderInfo);
        this.positionMap.put(i2, Integer.valueOf(i));
        this.typePositionMaps.put(i, Integer.valueOf(i2));
    }

    public int getViewTypeByPosition(int i) {
        int intValue = this.positionMap.get(i).intValue();
        return intValue >= 0 ? intValue : RESIDUAL_POSITION;
    }

    public int getItemCount() {
        return this.positionMap.size();
    }

    public int getItemPosition(int i) {
        return this.typePositionMaps.get(i).intValue();
    }

    public AbsHomeItemHolder factoryHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        try {
            return this.typeMap.get(i).aClass.getConstructor(View.class).newInstance(layoutInflater.inflate(this.typeMap.get(i).layoutId, viewGroup, false));
        } catch (Exception e) {
            return null;
        }
    }

    public void destory() {
        this.typeMap.clear();
        this.positionMap.clear();
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
