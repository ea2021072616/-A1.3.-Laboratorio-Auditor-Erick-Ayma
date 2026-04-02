package com.fotoable.youtube.music.newplayer.popup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.newplayer.d.c;
import com.fotoable.youtube.music.service.MainService;
import com.fotoable.youtube.music.util.u;
/* loaded from: classes.dex */
public class YoutubeWarnTipView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f3069a;

    /* renamed from: b  reason: collision with root package name */
    private CheckBox f3070b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f3071c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;

    public YoutubeWarnTipView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_float_window_youtube_tip, this);
        this.f3069a = (LinearLayout) findViewById(R.id.ck_panel);
        this.d = (RelativeLayout) findViewById(R.id.max_view);
        this.f3070b = (CheckBox) findViewById(R.id.ck_don_not_again);
        this.f3071c = (TextView) findViewById(R.id.confirm);
        this.e = (TextView) findViewById(R.id.lock_warn_msg_des);
        this.f = (ImageView) findViewById(R.id.warn_img);
        this.f3069a.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YoutubeWarnTipView.this.f3070b.setChecked(!com.fotoable.youtube.music.a.r());
            }
        });
        this.f3070b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.fotoable.youtube.music.a.n(z);
                Intent intent = new Intent(YoutubeWarnTipView.this.getContext(), MainService.class);
                intent.setAction("action_syn_youtube_warn_switch");
                intent.putExtra(ServerProtocol.DIALOG_PARAM_STATE, z);
                YoutubeWarnTipView.this.getContext().startService(intent);
            }
        });
        this.f3071c.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a().m(YoutubeWarnTipView.this.getContext());
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a().m(YoutubeWarnTipView.this.getContext());
            }
        });
        findViewById(R.id.content_panel).setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.newplayer.popup.YoutubeWarnTipView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        u.a(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        layoutParams.height = getResources().getDisplayMetrics().heightPixels + a(getContext());
        this.d.setLayoutParams(layoutParams);
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
    }

    private int a(Context context) {
        if (u.c(context)) {
            return u.a(context);
        }
        return 0;
    }
}
