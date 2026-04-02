package y0;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;
/* loaded from: classes.dex */
public final class g0 implements View.OnKeyListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f5620g;

    public g0(SeekBarPreference seekBarPreference) {
        this.f5620g = seekBarPreference;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        SeekBarPreference seekBarPreference = this.f5620g;
        if ((!seekBarPreference.V && (i5 == 21 || i5 == 22)) || i5 == 23 || i5 == 66) {
            return false;
        }
        SeekBar seekBar = seekBarPreference.T;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
        return seekBar.onKeyDown(i5, keyEvent);
    }
}
