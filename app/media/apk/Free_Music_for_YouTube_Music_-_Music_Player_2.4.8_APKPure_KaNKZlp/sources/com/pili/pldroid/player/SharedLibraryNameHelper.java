package com.pili.pldroid.player;

import android.util.Log;
/* loaded from: classes2.dex */
public class SharedLibraryNameHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f5019a;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final SharedLibraryNameHelper f5020a = new SharedLibraryNameHelper();
    }

    private SharedLibraryNameHelper() {
        this.f5019a = "pldroidplayer";
    }

    public static SharedLibraryNameHelper getInstance() {
        return a.f5020a;
    }

    public void renameSharedLibrary(String str) {
        Log.i("SharedLibraryNameHelper", "renameSharedLibrary newName:" + str);
        this.f5019a = str;
    }

    public String getSharedLibraryName() {
        return this.f5019a;
    }

    public void a() {
        if (this.f5019a.contains("/")) {
            System.load(this.f5019a);
        } else {
            System.loadLibrary(this.f5019a);
        }
    }
}
