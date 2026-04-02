package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class zzj extends zzl {
    private Fragment zzgov;

    private zzj(Fragment fragment) {
        this.zzgov = fragment;
    }

    public static zzj zza(Fragment fragment) {
        if (fragment != null) {
            return new zzj(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final Bundle getArguments() {
        return this.zzgov.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final int getId() {
        return this.zzgov.getId();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean getRetainInstance() {
        return this.zzgov.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final String getTag() {
        return this.zzgov.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final int getTargetRequestCode() {
        return this.zzgov.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean getUserVisibleHint() {
        return this.zzgov.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper getView() {
        return zzn.zzw(this.zzgov.getView());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isAdded() {
        return this.zzgov.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isDetached() {
        return this.zzgov.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isHidden() {
        return this.zzgov.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isInLayout() {
        return this.zzgov.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isRemoving() {
        return this.zzgov.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isResumed() {
        return this.zzgov.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final boolean isVisible() {
        return this.zzgov.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setHasOptionsMenu(boolean z) {
        this.zzgov.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setMenuVisibility(boolean z) {
        this.zzgov.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setRetainInstance(boolean z) {
        this.zzgov.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void setUserVisibleHint(boolean z) {
        this.zzgov.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void startActivity(Intent intent) {
        this.zzgov.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void startActivityForResult(Intent intent, int i) {
        this.zzgov.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzgov.unregisterForContextMenu((View) zzn.zzab(iObjectWrapper));
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper zzaob() {
        return zzn.zzw(this.zzgov.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final zzk zzaoc() {
        return zza(this.zzgov.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final IObjectWrapper zzaod() {
        return zzn.zzw(this.zzgov.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final zzk zzaoe() {
        return zza(this.zzgov.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.zzk
    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zzgov.registerForContextMenu((View) zzn.zzab(iObjectWrapper));
    }
}
