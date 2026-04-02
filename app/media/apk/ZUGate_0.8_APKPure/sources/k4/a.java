package k4;

import java.util.Random;
/* loaded from: classes.dex */
public abstract class a extends e {
    @Override // k4.e
    public final int a() {
        return b().nextInt(2147418112);
    }

    public abstract Random b();
}
