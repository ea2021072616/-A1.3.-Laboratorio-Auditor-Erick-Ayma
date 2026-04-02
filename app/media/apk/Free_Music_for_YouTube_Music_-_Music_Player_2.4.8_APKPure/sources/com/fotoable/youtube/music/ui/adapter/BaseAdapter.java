package com.fotoable.youtube.music.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
/* loaded from: classes.dex */
public abstract class BaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    public abstract void onDestroy();
}
