package d;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class q0 implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public final View f2448g;

    /* renamed from: h  reason: collision with root package name */
    public final String f2449h;

    /* renamed from: i  reason: collision with root package name */
    public Method f2450i;

    /* renamed from: j  reason: collision with root package name */
    public Context f2451j;

    public q0(View view, String str) {
        this.f2448g = view;
        this.f2449h = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id;
        String str;
        Method method;
        if (this.f2450i == null) {
            View view2 = this.f2448g;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f2449h;
                if (context == null) {
                    if (view2.getId() == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f2450i = method;
                        this.f2451j = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f2450i.invoke(this.f2451j, view);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalStateException("Could not execute method for android:onClick", e6);
        }
    }
}
