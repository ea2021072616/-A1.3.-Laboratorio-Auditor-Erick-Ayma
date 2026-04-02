package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
/* loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    public static Configuration f2865f;

    /* renamed from: a  reason: collision with root package name */
    public int f2866a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f2867b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f2868c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f2869d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f2870e;

    public d(Context context, int i5) {
        super(context);
        this.f2866a = i5;
    }

    public final void a(Configuration configuration) {
        if (this.f2870e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f2869d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f2869d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f2867b == null) {
            this.f2867b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2867b.setTo(theme);
            }
        }
        this.f2867b.applyStyle(this.f2866a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f2870e == null) {
            Configuration configuration = this.f2869d;
            if (configuration != null) {
                if (f2865f == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    f2865f = configuration2;
                }
                if (!configuration.equals(f2865f)) {
                    this.f2870e = createConfigurationContext(this.f2869d).getResources();
                }
            }
            this.f2870e = super.getResources();
        }
        return this.f2870e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f2868c == null) {
                this.f2868c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f2868c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f2867b;
        if (theme != null) {
            return theme;
        }
        if (this.f2866a == 0) {
            this.f2866a = 2131952193;
        }
        b();
        return this.f2867b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i5) {
        if (this.f2866a != i5) {
            this.f2866a = i5;
            b();
        }
    }
}
