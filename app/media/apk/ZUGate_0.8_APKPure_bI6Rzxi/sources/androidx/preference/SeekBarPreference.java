package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import com.github.appintro.R;
import y0.d0;
import y0.e0;
import y0.f0;
import y0.g0;
import y0.h0;
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public SeekBar T;
    public TextView U;
    public final boolean V;
    public final boolean W;
    public final boolean X;
    public final f0 Y;
    public final g0 Z;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        this.Y = new f0(this);
        this.Z = new g0(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f5615k, R.attr.seekBarPreferenceStyle, 0);
        this.P = obtainStyledAttributes.getInt(3, 0);
        int i5 = obtainStyledAttributes.getInt(1, 100);
        int i6 = this.P;
        i5 = i5 < i6 ? i6 : i5;
        if (i5 != this.Q) {
            this.Q = i5;
            i();
        }
        int i7 = obtainStyledAttributes.getInt(4, 0);
        if (i7 != this.R) {
            this.R = Math.min(this.Q - this.P, Math.abs(i7));
            i();
        }
        this.V = obtainStyledAttributes.getBoolean(2, true);
        this.W = obtainStyledAttributes.getBoolean(5, false);
        this.X = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    public final void A(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.P;
        if (progress != this.O) {
            if (!a(Integer.valueOf(progress))) {
                seekBar.setProgress(this.O - this.P);
                int i5 = this.O;
                TextView textView = this.U;
                if (textView != null) {
                    textView.setText(String.valueOf(i5));
                    return;
                }
                return;
            }
            int i6 = this.P;
            if (progress < i6) {
                progress = i6;
            }
            int i7 = this.Q;
            if (progress > i7) {
                progress = i7;
            }
            if (progress != this.O) {
                this.O = progress;
                TextView textView2 = this.U;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(progress));
                }
                u(progress);
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void m(d0 d0Var) {
        super.m(d0Var);
        d0Var.f1376a.setOnKeyListener(this.Z);
        this.T = (SeekBar) d0Var.q(R.id.seekbar);
        TextView textView = (TextView) d0Var.q(R.id.seekbar_value);
        this.U = textView;
        if (this.W) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.U = null;
        }
        SeekBar seekBar = this.T;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.Y);
        this.T.setMax(this.Q - this.P);
        int i5 = this.R;
        if (i5 != 0) {
            this.T.setKeyProgressIncrement(i5);
        } else {
            this.R = this.T.getKeyProgressIncrement();
        }
        this.T.setProgress(this.O - this.P);
        int i6 = this.O;
        TextView textView2 = this.U;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i6));
        }
        this.T.setEnabled(h());
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i5) {
        return Integer.valueOf(typedArray.getInt(i5, 0));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(h0.class)) {
            super.q(parcelable);
            return;
        }
        h0 h0Var = (h0) parcelable;
        super.q(h0Var.getSuperState());
        this.O = h0Var.f5622b;
        this.P = h0Var.f5623c;
        this.Q = h0Var.f5624d;
        i();
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        this.K = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f1193s) {
            return absSavedState;
        }
        h0 h0Var = new h0(absSavedState);
        h0Var.f5622b = this.O;
        h0Var.f5623c = this.P;
        h0Var.f5624d = this.Q;
        return h0Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int e5 = e(((Integer) obj).intValue());
        int i5 = this.P;
        if (e5 < i5) {
            e5 = i5;
        }
        int i6 = this.Q;
        if (e5 > i6) {
            e5 = i6;
        }
        if (e5 != this.O) {
            this.O = e5;
            TextView textView = this.U;
            if (textView != null) {
                textView.setText(String.valueOf(e5));
            }
            u(e5);
            i();
        }
    }
}
