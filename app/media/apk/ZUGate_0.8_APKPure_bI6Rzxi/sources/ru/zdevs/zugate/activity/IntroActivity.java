package ru.zdevs.zugate.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class IntroActivity extends AppIntro {
    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.d0, androidx.activity.ComponentActivity, w.o, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addSlide(AppIntroFragment.newInstance(getString(R.string.welcome_title), getString(R.string.welcome_desc), R.mipmap.ic_launcher, getColor(R.color.ui_intro_bg1)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.usb_storage_title), getString(R.string.usb_storage_desc), R.drawable.intro_usb, getColor(R.color.ui_intro_bg1)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.image_file_title), getString(R.string.image_file_desc), R.drawable.intro_img, getColor(R.color.ui_intro_bg1)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.user_guide_title), getString(R.string.user_guide_desc), R.drawable.intro_rocket, getColor(R.color.ui_intro_bg2)));
    }

    @Override // com.github.appintro.AppIntroBase
    public final void onDonePressed(Fragment fragment) {
        super.onDonePressed(fragment);
        finish();
    }

    @Override // com.github.appintro.AppIntroBase
    public final void onSkipPressed(Fragment fragment) {
        super.onSkipPressed(fragment);
        finish();
    }
}
