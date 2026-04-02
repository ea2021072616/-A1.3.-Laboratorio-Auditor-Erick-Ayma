package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
/* loaded from: classes.dex */
public final class zzr extends zzl {
    private Fragment zzgoy;

    private zzr(Fragment fragment) {
        this.zzgoy = fragment;
    }

    public static zzr zza(Fragment fragment) {
        if (fragment != null) {
            return new zzr(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final Bundle getArguments() {
        return this.zzgoy.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final int getId() {
        return this.zzgoy.getId();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean getRetainInstance() {
        return this.zzgoy.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final String getTag() {
        return this.zzgoy.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final int getTargetRequestCode() {
        return this.zzgoy.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean getUserVisibleHint() {
        return this.zzgoy.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper getView() {
        return zzn.zzw(this.zzgoy.getView());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isAdded() {
        return this.zzgoy.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isDetached() {
        return this.zzgoy.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isHidden() {
        return this.zzgoy.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isInLayout() {
        return this.zzgoy.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isRemoving() {
        return this.zzgoy.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isResumed() {
        return this.zzgoy.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isVisible() {
        return this.zzgoy.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setHasOptionsMenu(boolean z) {
        this.zzgoy.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setMenuVisibility(boolean z) {
        this.zzgoy.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setRetainInstance(boolean z) {
        this.zzgoy.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setUserVisibleHint(boolean z) {
        this.zzgoy.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void startActivity(Intent intent) {
        this.zzgoy.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void startActivityForResult(Intent intent, int i) {
        this.zzgoy.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzgoy.unregisterForContextMenu((View) zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper zzaob() {
        return zzn.zzw(this.zzgoy.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final zzk zzaoc() {
        return zza(this.zzgoy.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper zzaod() {
        return zzn.zzw(this.zzgoy.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final zzk zzaoe() {
        return zza(this.zzgoy.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zzgoy.registerForContextMenu((View) zzn.zzab(iObjectWrapper));
    }
}
