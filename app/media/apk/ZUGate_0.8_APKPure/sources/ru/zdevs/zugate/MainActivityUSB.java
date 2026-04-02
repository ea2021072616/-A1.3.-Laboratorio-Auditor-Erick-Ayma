package ru.zdevs.zugate;

import android.content.Intent;
import android.os.Bundle;
import d.q;
/* loaded from: classes.dex */
public class MainActivityUSB extends q {
    @Override // androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, MainActivity.class);
        intent.hasExtra("UPDATE_LIST");
        startActivity(intent);
        finish();
    }
}
