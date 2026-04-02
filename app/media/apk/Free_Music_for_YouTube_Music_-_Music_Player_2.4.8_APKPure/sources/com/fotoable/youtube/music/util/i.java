package com.fotoable.youtube.music.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.dialog.l;
import com.google.android.gms.actions.SearchIntents;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: MusicMenuUtils.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f4867a;

    /* renamed from: b  reason: collision with root package name */
    private com.fotoable.youtube.music.ui.dialog.l f4868b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4869c;

    public static i a(Context context) {
        if (f4867a == null) {
            f4867a = new i(context);
        }
        if (f4867a.f4869c != context) {
            f4867a = new i(context);
        }
        return f4867a;
    }

    public i(Context context) {
        this.f4869c = context;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "https://www.youtube.com/watch?v=" + str;
                if (Build.VERSION.SDK_INT >= 16) {
                    ((ClipboardManager) this.f4869c.getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(this.f4869c.getContentResolver(), "URL", Uri.parse(str2)));
                } else {
                    ((android.text.ClipboardManager) this.f4869c.getSystemService("clipboard")).setText(str2);
                }
                Toast.makeText(this.f4869c, this.f4869c.getResources().getString(R.string.copy_tip_success), 0).show();
                b.b("Song-CopyYoutubeUrl", "videoId", str);
            } catch (Throwable th) {
                ThrowableExtension.printStackTrace(th);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!v.c(this.f4869c, "Go_To_Browser_For_MP3_Tip", false)) {
                    e(str);
                } else {
                    b(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    b.b("Song-FindMp3", "videoId", str2);
                }
            }
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    public void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!v.c(this.f4869c, "Go_To_Browser_For_Lyric_Tip", false)) {
                    d(str);
                } else {
                    c(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    b.b("Song-FindLyric", "videoId", str2);
                }
            }
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            Intent intent = new Intent("android.intent.action.WEB_SEARCH");
            intent.addFlags(268435456);
            intent.putExtra(SearchIntents.EXTRA_QUERY, str + " " + this.f4869c.getResources().getString(R.string.lyric));
            this.f4869c.startActivity(intent);
            com.fotoable.youtube.music.newplayer.e.a().d(PointerIconCompat.TYPE_WAIT);
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    private void d(final String str) {
        final l.a aVar = new l.a(this.f4869c);
        this.f4868b = aVar.b(199).c(310).a(true).d(com.fotoable.youtube.music.R.style.Theme_Light_Dialog).a(R.layout.dialog_go_to_bowser).a(R.id.txt_cancel, new View.OnClickListener() { // from class: com.fotoable.youtube.music.util.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v.b(i.this.f4869c, "Go_To_Browser_For_Lyric_Tip", false);
                i.this.f4868b.cancel();
            }
        }).a(R.id.txt_ok, new View.OnClickListener() { // from class: com.fotoable.youtube.music.util.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.c(str);
                i.this.f4868b.cancel();
                boolean isChecked = aVar.e(R.id.checkbox).isChecked();
                v.b(i.this.f4869c, "Go_To_Browser_For_Lyric_Tip", isChecked);
                if (isChecked) {
                }
            }
        }).a(R.id.checkbox, new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.util.i.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                v.b(i.this.f4869c, "Go_To_Browser_For_Lyric_Tip", z);
            }
        }).a();
        this.f4868b.show();
    }

    public void b(String str) {
        try {
            Intent intent = new Intent("android.intent.action.WEB_SEARCH");
            intent.addFlags(268435456);
            intent.putExtra(SearchIntents.EXTRA_QUERY, str + " " + this.f4869c.getResources().getString(R.string.mp3));
            this.f4869c.startActivity(intent);
            com.fotoable.youtube.music.newplayer.e.a().d(PointerIconCompat.TYPE_WAIT);
        } catch (Throwable th) {
            ThrowableExtension.printStackTrace(th);
        }
    }

    private void e(final String str) {
        final l.a aVar = new l.a(this.f4869c);
        this.f4868b = aVar.b(199).c(310).a(true).d(com.fotoable.youtube.music.R.style.Theme_Light_Dialog).a(R.layout.dialog_go_to_bowser).a(R.id.txt_cancel, new View.OnClickListener() { // from class: com.fotoable.youtube.music.util.i.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v.b(i.this.f4869c, "Go_To_Browser_For_MP3_Tip", false);
                i.this.f4868b.cancel();
            }
        }).a(R.id.txt_ok, new View.OnClickListener() { // from class: com.fotoable.youtube.music.util.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.b(str);
                i.this.f4868b.cancel();
                boolean isChecked = aVar.e(R.id.checkbox).isChecked();
                v.b(i.this.f4869c, "Go_To_Browser_For_MP3_Tip", isChecked);
                if (isChecked) {
                }
            }
        }).a(R.id.checkbox, new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.util.i.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                v.b(i.this.f4869c, "Go_To_Browser_For_MP3_Tip", z);
            }
        }).a();
        this.f4868b.show();
    }
}
