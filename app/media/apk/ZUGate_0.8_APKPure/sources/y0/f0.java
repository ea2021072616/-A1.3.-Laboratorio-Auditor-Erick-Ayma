package y0;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;
/* loaded from: classes.dex */
public final class f0 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f5619a;

    public f0(SeekBarPreference seekBarPreference) {
        this.f5619a = seekBarPreference;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i5, boolean z4) {
        SeekBarPreference seekBarPreference = this.f5619a;
        if (z4 && (seekBarPreference.X || !seekBarPreference.S)) {
            seekBarPreference.A(seekBar);
            return;
        }
        int i6 = i5 + seekBarPreference.P;
        TextView textView = seekBarPreference.U;
        if (textView != null) {
            textView.setText(String.valueOf(i6));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.f5619a.S = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarPreference seekBarPreference = this.f5619a;
        seekBarPreference.S = false;
        if (seekBar.getProgress() + seekBarPreference.P != seekBarPreference.O) {
            seekBarPreference.A(seekBar);
        }
    }
}
