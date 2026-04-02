package com.facebook.ads.internal.util;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.ads.internal.view.a.d f1542a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1543b = true;

    public l(com.facebook.ads.internal.view.a.d dVar) {
        this.f1542a = dVar;
    }

    private static long a(String str, String str2) {
        String substring = str.substring(str2.length());
        if (TextUtils.isEmpty(substring)) {
            return -1L;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(substring));
            if (valueOf.longValue() >= 0) {
                return valueOf.longValue();
            }
            return -1L;
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public void a() {
        if (this.f1543b) {
            if (this.f1542a.canGoBack() || this.f1542a.canGoForward()) {
                this.f1543b = false;
            } else {
                this.f1542a.b("void((function() {try {  if (!window.performance || !window.performance.timing || !document ||       !document.body || document.body.scrollHeight <= 0 ||       !document.body.children || document.body.children.length < 1) {    return;  }  var nvtiming__an_t = window.performance.timing;  if (nvtiming__an_t.responseEnd > 0) {    console.log('ANNavResponseEnd:'+nvtiming__an_t.responseEnd);  }  if (nvtiming__an_t.domContentLoadedEventStart > 0) {    console.log('ANNavDomContentLoaded:' + nvtiming__an_t.domContentLoadedEventStart);  }  if (nvtiming__an_t.loadEventEnd > 0) {    console.log('ANNavLoadEventEnd:' + nvtiming__an_t.loadEventEnd);  }} catch(err) {  console.log('an_navigation_timing_error:' + err.message);}})());");
            }
        }
    }

    public void a(String str) {
        if (this.f1543b) {
            if (str.startsWith("ANNavResponseEnd:")) {
                this.f1542a.a(a(str, "ANNavResponseEnd:"));
            } else if (str.startsWith("ANNavDomContentLoaded:")) {
                this.f1542a.b(a(str, "ANNavDomContentLoaded:"));
            } else if (str.startsWith("ANNavLoadEventEnd:")) {
                this.f1542a.c(a(str, "ANNavLoadEventEnd:"));
            }
        }
    }

    public void a(boolean z) {
        this.f1543b = z;
    }
}
