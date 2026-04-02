package com.yanzhenjie.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.fragment.CompatActivity;
/* compiled from: NoFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {
    private static final int REQUEST_CODE_INVALID = -1;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;
    private CompatActivity mActivity;
    private CompatActivity.a mStackEntity;
    private Toolbar mToolbar;

    @Deprecated
    public static <T extends a> T instantiate(Context context, Class<T> cls) {
        return (T) instantiate(context, cls.getName(), (Bundle) null);
    }

    @Deprecated
    public static <T extends a> T instantiate(Context context, Class<T> cls, Bundle bundle) {
        return (T) instantiate(context, cls.getName(), bundle);
    }

    public final <T extends a> T fragment(Class<T> cls) {
        return (T) instantiate(getContext(), cls.getName(), (Bundle) null);
    }

    public final <T extends a> T fragment(Class<T> cls, Bundle bundle) {
        return (T) instantiate(getContext(), cls.getName(), bundle);
    }

    protected final CompatActivity getCompatActivity() {
        return this.mActivity;
    }

    protected final <T extends Activity> void startActivity(Class<T> cls) {
        startActivity(new Intent((Context) this.mActivity, (Class<?>) cls));
    }

    protected final <T extends Activity> void startActivityFinish(Class<T> cls) {
        startActivity(new Intent((Context) this.mActivity, (Class<?>) cls));
        this.mActivity.finish();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (CompatActivity) context;
    }

    public void finish() {
        this.mActivity.onBackPressed();
    }

    public final void setToolbar(@NonNull Toolbar toolbar) {
        this.mToolbar = toolbar;
        onCreateOptionsMenu(this.mToolbar.getMenu(), new SupportMenuInflater(this.mActivity));
        this.mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.yanzhenjie.fragment.a.1
            @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                return a.this.onOptionsItemSelected(menuItem);
            }
        });
    }

    public final void displayHomeAsUpEnabled(@DrawableRes int i) {
        displayHomeAsUpEnabled(ContextCompat.getDrawable(this.mActivity, i));
    }

    public final void displayHomeAsUpEnabled(Drawable drawable) {
        this.mToolbar.setNavigationIcon(drawable);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.yanzhenjie.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.onInterceptToolbarBack()) {
                    a.this.finish();
                }
            }
        });
    }

    public boolean onInterceptToolbarBack() {
        return false;
    }

    @Nullable
    protected final Toolbar getToolbar() {
        return this.mToolbar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitle(CharSequence charSequence) {
        if (this.mToolbar != null) {
            this.mToolbar.setTitle(charSequence);
        }
    }

    protected void setTitle(int i) {
        if (this.mToolbar != null) {
            this.mToolbar.setTitle(i);
        }
    }

    protected void setSubtitle(CharSequence charSequence) {
        if (this.mToolbar != null) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    protected void setSubtitle(int i) {
        if (this.mToolbar != null) {
            this.mToolbar.setSubtitle(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setResult(int i) {
        this.mStackEntity.f5191a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setResult(int i, @NonNull Bundle bundle) {
        this.mStackEntity.f5191a = i;
        this.mStackEntity.f5192b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setStackEntity(@NonNull CompatActivity.a aVar) {
        this.mStackEntity = aVar;
    }

    public void onFragmentResult(int i, int i2, @Nullable Bundle bundle) {
    }

    public final <T extends a> void startFragment(Class<T> cls) {
        try {
            startFragment(cls.newInstance(), true, -1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends a> void startFragment(Class<T> cls, boolean z) {
        try {
            startFragment(cls.newInstance(), z, -1);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends a> void startFragment(T t) {
        startFragment(t, true, -1);
    }

    public final <T extends a> void startFragment(T t, boolean z) {
        startFragment(t, z, -1);
    }

    @Deprecated
    public final <T extends a> void startFragmentForResquest(Class<T> cls, int i) {
        startFragmentForResult(cls, i);
    }

    @Deprecated
    public final <T extends a> void startFragmentForResquest(T t, int i) {
        startFragmentForResult(t, i);
    }

    public final <T extends a> void startFragmentForResult(Class<T> cls, int i) {
        try {
            startFragment(cls.newInstance(), true, i);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public final <T extends a> void startFragmentForResult(T t, int i) {
        startFragment(t, true, i);
    }

    private <T extends a> void startFragment(T t, boolean z, int i) {
        this.mActivity.startFragment(this, t, z, i);
    }
}
