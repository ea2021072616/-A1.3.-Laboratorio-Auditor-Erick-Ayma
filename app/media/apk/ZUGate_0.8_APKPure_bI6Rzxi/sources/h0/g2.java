package h0;

import android.view.WindowInsets;
/* loaded from: classes.dex */
public abstract class g2 {
    public static int a(int i5) {
        int statusBars;
        int i6 = 0;
        for (int i7 = 1; i7 <= 256; i7 <<= 1) {
            if ((i5 & i7) != 0) {
                if (i7 == 1) {
                    statusBars = WindowInsets.Type.statusBars();
                } else if (i7 == 2) {
                    statusBars = WindowInsets.Type.navigationBars();
                } else if (i7 == 4) {
                    statusBars = WindowInsets.Type.captionBar();
                } else if (i7 == 8) {
                    statusBars = WindowInsets.Type.ime();
                } else if (i7 == 16) {
                    statusBars = WindowInsets.Type.systemGestures();
                } else if (i7 == 32) {
                    statusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i7 == 64) {
                    statusBars = WindowInsets.Type.tappableElement();
                } else if (i7 == 128) {
                    statusBars = WindowInsets.Type.displayCutout();
                }
                i6 |= statusBars;
            }
        }
        return i6;
    }
}
