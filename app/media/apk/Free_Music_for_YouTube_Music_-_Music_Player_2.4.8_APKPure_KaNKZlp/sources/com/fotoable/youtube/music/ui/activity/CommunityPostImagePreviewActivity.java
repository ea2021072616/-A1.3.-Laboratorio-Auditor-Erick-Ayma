package com.fotoable.youtube.music.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.adapter.CommunityPostmagePreviewAdapter;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.yanzhenjie.album.widget.photoview.FixViewPager;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class CommunityPostImagePreviewActivity extends BaseActivity {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    com.fotoable.youtube.music.b.c f3271a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f3272b;

    /* renamed from: c  reason: collision with root package name */
    private int f3273c;
    @BindView(R.id.tv_save_image)
    TextView tvSaveImage;
    @BindView(R.id.vp_post_image_preview)
    FixViewPager vpPostImagePreview;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return false;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_community_post_image_preview;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("imageList")) {
            this.f3272b = intent.getStringArrayListExtra("imageList");
            this.f3273c = intent.getIntExtra("position", 0);
        }
        if (this.f3272b != null) {
            if (this.f3272b.size() > 3) {
                this.vpPostImagePreview.setOffscreenPageLimit(3);
            } else if (this.f3272b.size() > 2) {
                this.vpPostImagePreview.setOffscreenPageLimit(2);
            }
            this.vpPostImagePreview.setAdapter(new CommunityPostmagePreviewAdapter(this, this.f3272b));
            this.vpPostImagePreview.setCurrentItem(this.f3273c);
        }
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
        i().a(this);
    }

    @OnClick({R.id.tv_save_image})
    public void onViewClick(View view) {
        int currentItem = this.vpPostImagePreview.getCurrentItem();
        if (this.f3272b != null && currentItem < this.f3272b.size()) {
            a(this.f3272b.get(currentItem));
        }
    }

    public void a(final String str) {
        this.f3271a.g(str).b(Schedulers.io()).c(Schedulers.io()).c(new rx.c.e<ResponseBody, InputStream>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity.3
            @Override // rx.c.e
            public InputStream a(ResponseBody responseBody) {
                return responseBody.byteStream();
            }
        }).a(Schedulers.computation()).a((rx.c.b) new rx.c.b<InputStream>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity.2
            @Override // rx.c.b
            /* renamed from: a */
            public void call(InputStream inputStream) {
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "/Free Music/images/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    CommunityPostImagePreviewActivity.this.a(inputStream, new File(file, com.fotoable.youtube.music.quicktools.a.b.a(str) + ".png"));
                } catch (Exception e) {
                    ThrowableExtension.printStackTrace(e);
                    throw e;
                }
            }
        }).a(rx.a.b.a.a()).b(new rx.l<InputStream>() { // from class: com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity.1
            @Override // rx.g
            public void onCompleted() {
            }

            @Override // rx.g
            public void onError(Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }

            @Override // rx.g
            /* renamed from: a */
            public void onNext(InputStream inputStream) {
                Toast.makeText(CommunityPostImagePreviewActivity.this, (int) R.string.success, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.io.InputStream r5, java.io.File r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L4
            if (r6 != 0) goto L5
        L4:
            return
        L5:
            boolean r0 = r6.exists()
            if (r0 == 0) goto Le
            r6.delete()
        Le:
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L6e java.io.FileNotFoundException -> L89
            r1.<init>(r6)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L6e java.io.FileNotFoundException -> L89
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.io.FileNotFoundException -> L23 java.lang.Throwable -> L85 java.lang.Exception -> L87
        L18:
            int r2 = r5.read(r0)     // Catch: java.io.FileNotFoundException -> L23 java.lang.Throwable -> L85 java.lang.Exception -> L87
            if (r2 <= 0) goto L37
            r3 = 0
            r1.write(r0, r3, r2)     // Catch: java.io.FileNotFoundException -> L23 java.lang.Throwable -> L85 java.lang.Exception -> L87
            goto L18
        L23:
            r0 = move-exception
        L24:
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)     // Catch: java.lang.Throwable -> L85
            if (r1 == 0) goto L2c
            r1.close()     // Catch: java.io.IOException -> L4f
        L2c:
            if (r5 == 0) goto L4
            r5.close()     // Catch: java.io.IOException -> L32
            goto L4
        L32:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L4
        L37:
            r1.flush()     // Catch: java.io.FileNotFoundException -> L23 java.lang.Throwable -> L85 java.lang.Exception -> L87
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.io.IOException -> L4a
        L3f:
            if (r5 == 0) goto L4
            r5.close()     // Catch: java.io.IOException -> L45
            goto L4
        L45:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L4
        L4a:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L3f
        L4f:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L2c
        L54:
            r0 = move-exception
            r1 = r2
        L56:
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)     // Catch: java.lang.Throwable -> L85
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L69
        L5e:
            if (r5 == 0) goto L4
            r5.close()     // Catch: java.io.IOException -> L64
            goto L4
        L64:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L4
        L69:
            r0 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r0)
            goto L5e
        L6e:
            r0 = move-exception
            r1 = r2
        L70:
            if (r1 == 0) goto L75
            r1.close()     // Catch: java.io.IOException -> L7b
        L75:
            if (r5 == 0) goto L7a
            r5.close()     // Catch: java.io.IOException -> L80
        L7a:
            throw r0
        L7b:
            r1 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r1)
            goto L75
        L80:
            r1 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.printStackTrace(r1)
            goto L7a
        L85:
            r0 = move-exception
            goto L70
        L87:
            r0 = move-exception
            goto L56
        L89:
            r0 = move-exception
            r1 = r2
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fotoable.youtube.music.ui.activity.CommunityPostImagePreviewActivity.a(java.io.InputStream, java.io.File):void");
    }
}
