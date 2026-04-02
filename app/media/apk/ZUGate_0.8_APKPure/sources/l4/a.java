package l4;

import e4.e;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/* loaded from: classes.dex */
public final class a extends k4.a {
    @Override // k4.a
    public final Random b() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        e.e(current, "current()");
        return current;
    }
}
