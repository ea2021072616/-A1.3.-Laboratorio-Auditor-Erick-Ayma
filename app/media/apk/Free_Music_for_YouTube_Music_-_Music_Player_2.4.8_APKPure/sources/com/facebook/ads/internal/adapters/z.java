package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
/* loaded from: classes.dex */
public class z extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private String f1234a;

    /* renamed from: b  reason: collision with root package name */
    private y f1235b;

    /* renamed from: c  reason: collision with root package name */
    private x f1236c;

    public z(String str, x xVar, y yVar) {
        this.f1236c = xVar;
        this.f1235b = yVar;
        this.f1234a = str;
    }

    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.facebook.ads.internal.j.REWARDED_VIDEO_COMPLETE.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARDED_VIDEO_ERROR.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARDED_VIDEO_AD_CLICK.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARDED_VIDEO_IMPRESSION.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARDED_VIDEO_CLOSED.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARD_SERVER_SUCCESS.a(this.f1234a));
        intentFilter.addAction(com.facebook.ads.internal.j.REWARD_SERVER_FAILED.a(this.f1234a));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (com.facebook.ads.internal.j.REWARDED_VIDEO_COMPLETE.a(this.f1234a).equals(action)) {
            this.f1235b.d(this.f1236c);
        } else if (com.facebook.ads.internal.j.REWARDED_VIDEO_ERROR.a(this.f1234a).equals(action)) {
            this.f1235b.a(this.f1236c, AdError.INTERNAL_ERROR);
        } else if (com.facebook.ads.internal.j.REWARDED_VIDEO_AD_CLICK.a(this.f1234a).equals(action)) {
            this.f1235b.b(this.f1236c);
        } else if (com.facebook.ads.internal.j.REWARDED_VIDEO_IMPRESSION.a(this.f1234a).equals(action)) {
            this.f1235b.c(this.f1236c);
        } else if (com.facebook.ads.internal.j.REWARDED_VIDEO_CLOSED.a(this.f1234a).equals(action)) {
            this.f1235b.a();
        } else if (com.facebook.ads.internal.j.REWARD_SERVER_FAILED.a(this.f1234a).equals(action)) {
            this.f1235b.e(this.f1236c);
        } else if (com.facebook.ads.internal.j.REWARD_SERVER_SUCCESS.a(this.f1234a).equals(action)) {
            this.f1235b.f(this.f1236c);
        }
    }
}
