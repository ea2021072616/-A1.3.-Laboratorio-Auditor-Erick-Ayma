package com.github.appintro;
/* loaded from: classes.dex */
public interface AppIntroViewPagerListener {
    boolean onCanRequestNextPage();

    void onIllegallyRequestedNextPage();

    void onUserRequestedPermissionsDialog();
}
