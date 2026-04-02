package com.fotoable.youtube.music.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.ui.view.ShadowProperty;
import com.fotoable.youtube.music.ui.view.ShadowViewDrawable;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: CommunityPostTypeDialog.java */
/* loaded from: classes.dex */
public class g extends PopupWindow {

    /* compiled from: CommunityPostTypeDialog.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i);
    }

    public g(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
    }

    public static void a(Context context, View view, a aVar) {
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_community_post_type_list, (ViewGroup) null);
            g gVar = new g(inflate, -2, -2, true);
            a(context, inflate, aVar, gVar);
            gVar.setTouchable(true);
            gVar.setBackgroundDrawable(new ColorDrawable());
            int[] a2 = com.fotoable.youtube.music.util.n.a(view, inflate);
            a2[0] = a2[0] - 20;
            a2[0] = (int) (context.getResources().getDisplayMetrics().density * 10.0f);
            a2[1] = a2[1] - ((int) (context.getResources().getDisplayMetrics().density * 4.0f));
            gVar.showAtLocation(view, 8388659, a2[0], a2[1]);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static void b(Context context, View view, a aVar) {
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_community_post_type_list, (ViewGroup) null);
            g gVar = new g(inflate, -2, -2, true);
            a(context, inflate, aVar, gVar);
            inflate.findViewById(R.id.ll_all).setVisibility(8);
            gVar.setTouchable(true);
            gVar.setBackgroundDrawable(new ColorDrawable());
            int[] a2 = com.fotoable.youtube.music.util.n.a(view, inflate);
            a2[0] = a2[0] - 20;
            a2[0] = (int) (context.getResources().getDisplayMetrics().density * 80.0f);
            a2[1] = a2[1] - ((int) (context.getResources().getDisplayMetrics().density * 5.0f));
            gVar.showAtLocation(view, 51, a2[0], a2[1]);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private static void a(Context context, View view, final a aVar, final g gVar) {
        View findViewById = view.findViewById(R.id.shadow_view);
        ViewCompat.setBackground(findViewById, new ShadowViewDrawable(new ShadowProperty().setShadowColor(context.getResources().getColor(R.color.black)).setShadowDy(com.fotoable.youtube.music.util.w.a(context, 0.5f)).setShadowRadius(com.fotoable.youtube.music.util.w.a(context, 5.0f)).setShadowSide(ShadowProperty.ALL), -1, 0.0f, 0.0f));
        ViewCompat.setLayerType(findViewById, 1, null);
        view.findViewById(R.id.ll_music_resources).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a(AppEventsConstants.EVENT_PARAM_VALUE_YES, R.string.music_resources);
                }
                gVar.dismiss();
            }
        });
        view.findViewById(R.id.ll_lyrics).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a("2", R.string.lyrics);
                }
                gVar.dismiss();
            }
        });
        view.findViewById(R.id.ll_share_music).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a("3", R.string.share_your_music);
                }
                gVar.dismiss();
            }
        });
        view.findViewById(R.id.ll_wallpapers).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a("4", R.string.wallpapers);
                }
                gVar.dismiss();
            }
        });
        view.findViewById(R.id.ll_feedback).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a("5", R.string.feedback);
                }
                gVar.dismiss();
            }
        });
        view.findViewById(R.id.ll_all).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.dialog.g.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this != null) {
                    a.this.a("all", R.string.all);
                }
                gVar.dismiss();
            }
        });
    }
}
