package androidx.appcompat.widget;

import android.widget.AbsListView;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public abstract class a2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f284a;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
        f284a = field;
    }
}
