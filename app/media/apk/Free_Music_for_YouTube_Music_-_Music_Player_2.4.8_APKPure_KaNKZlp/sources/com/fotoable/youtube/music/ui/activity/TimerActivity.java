package com.fotoable.youtube.music.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.facebook.appevents.AppEventsConstants;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.ui.adapter.BaseAdapter;
import com.fotoable.youtube.music.ui.dialog.SleepTimerDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TimerActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3838a = TimerActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private SimpleDateFormat f3839b;

    /* renamed from: c  reason: collision with root package name */
    private a f3840c;
    private int d;
    @BindView(R.id.play_end_checkbox)
    CheckBox play_end_checkbox;
    @BindView(R.id.recycle_view)
    RecyclerView recycle_view;

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public boolean f() {
        return true;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public int g() {
        return R.layout.activity_timer;
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(@Nullable Bundle bundle) {
        d();
        s();
        this.f3839b = new SimpleDateFormat("HH:mm");
        this.play_end_checkbox.setChecked(com.fotoable.youtube.music.a.j());
        this.play_end_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.fotoable.youtube.music.ui.activity.TimerActivity.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.fotoable.youtube.music.a.c(z);
                com.fotoable.youtube.music.newplayer.e.a().g(z);
            }
        });
        com.fotoable.youtube.music.util.b.b("定时关闭界面-进入次数");
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void a(com.fotoable.youtube.music.e.a aVar) {
        super.a(aVar);
        switch (aVar.f2726a) {
            case 8004:
                this.d = aVar.d;
                if (this.f3840c != null) {
                    this.f3840c.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void s() {
        this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.turn_off_sleep_timer));
        arrayList.add(getString(R.string.min_later_15));
        arrayList.add(getString(R.string.min_later_30));
        arrayList.add(getString(R.string.min_later_45));
        arrayList.add(getString(R.string.min_later_60));
        arrayList.add(getString(R.string.custom));
        this.f3840c = new a(getSupportFragmentManager(), this, arrayList, com.fotoable.youtube.music.newplayer.d.a().c());
        this.recycle_view.setAdapter(this.f3840c);
    }

    @Override // com.fotoable.youtube.music.base.BaseActivity
    public void h() {
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter<C0065a> {

        /* renamed from: b  reason: collision with root package name */
        private FragmentManager f3843b;

        /* renamed from: c  reason: collision with root package name */
        private Context f3844c;
        private LayoutInflater d;
        private List<String> e;
        private int f;

        public a(FragmentManager fragmentManager, Context context, List<String> list, int i) {
            this.f3843b = fragmentManager;
            this.f = i;
            this.f3844c = context;
            this.d = LayoutInflater.from(this.f3844c);
            this.e = list;
        }

        @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
        public void onDestroy() {
            this.f3843b = null;
            this.f3844c = null;
            this.d = null;
            this.e = null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public C0065a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0065a(this.d.inflate(R.layout.view_holder_timer_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0065a c0065a, final int i) {
            if (i == getItemCount() - 1) {
                c0065a.d.setVisibility(8);
            } else {
                c0065a.d.setVisibility(0);
            }
            if (this.f == i) {
                c0065a.f3851c.setVisibility(0);
            } else {
                c0065a.f3851c.setVisibility(8);
            }
            if (com.fotoable.youtube.music.newplayer.d.a().c() == i) {
                c0065a.f3850b.setVisibility(0);
                if (TimerActivity.this.d > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i2 = TimerActivity.this.d / 216000;
                    int i3 = (TimerActivity.this.d % 216000) / 60;
                    int i4 = (TimerActivity.this.d % 216000) % 60;
                    if (i2 > 0) {
                        sb.append(i2 + ":");
                    }
                    if (i3 > 0) {
                        if (i3 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i3 + ":");
                    } else {
                        sb.append("00:");
                    }
                    if (i4 > 0) {
                        if (i4 < 10) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(i4 + "");
                    } else {
                        sb.append("00");
                    }
                    c0065a.f3850b.setText(sb.toString() + "");
                    c0065a.f3850b.setVisibility(0);
                } else {
                    c0065a.f3850b.setVisibility(8);
                }
            } else {
                c0065a.f3850b.setVisibility(8);
            }
            c0065a.f3849a.setText(this.e.get(i) + "");
            c0065a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.activity.TimerActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long j;
                    final boolean z = a.this.f == a.this.getItemCount() + (-1);
                    a.this.f = i;
                    if (a.this.f == 0) {
                        com.fotoable.youtube.music.util.h.a(TimerActivity.f3838a, "关闭定时");
                        Toast.makeText(a.this.f3844c, (int) R.string.timer_cancel_msg, 0).show();
                        com.fotoable.youtube.music.newplayer.e.a().a(-1, -1L);
                    } else if (i == a.this.getItemCount() - 1) {
                        com.fotoable.youtube.music.util.h.a(TimerActivity.f3838a, "自定义定时");
                        SleepTimerDialog.a(a.this.f3843b, new SleepTimerDialog.a() { // from class: com.fotoable.youtube.music.ui.activity.TimerActivity.a.1.1
                            @Override // com.fotoable.youtube.music.ui.dialog.SleepTimerDialog.a
                            public void a() {
                                if (!z) {
                                    a.this.f = 0;
                                    a.this.notifyDataSetChanged();
                                }
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.SleepTimerDialog.a
                            public void b() {
                                if (!z) {
                                    a.this.f = 0;
                                    a.this.notifyDataSetChanged();
                                }
                            }

                            @Override // com.fotoable.youtube.music.ui.dialog.SleepTimerDialog.a
                            public void a(long j2, int i5, int i6) {
                                if (i5 != 0 || i6 != 0) {
                                    com.fotoable.youtube.music.newplayer.e.a().a(a.this.f, j2);
                                    Toast.makeText(a.this.f3844c, a.this.f3844c.getString(R.string.timer_set_ok_msg) + " " + TimerActivity.this.f3839b.format(Long.valueOf(System.currentTimeMillis() + (1000 * j2))), 0).show();
                                    return;
                                }
                                a.this.f = 0;
                                a.this.notifyDataSetChanged();
                            }
                        });
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (i == 1) {
                            com.fotoable.youtube.music.newplayer.e.a().a(a.this.f, 900L);
                            j = 900000 + currentTimeMillis;
                            com.fotoable.youtube.music.util.b.b("定时关闭界面-选择时间", "时间", "15");
                        } else if (i == 2) {
                            com.fotoable.youtube.music.newplayer.e.a().a(a.this.f, 1800L);
                            j = 1800000 + currentTimeMillis;
                            com.fotoable.youtube.music.util.b.b("定时关闭界面-选择时间", "时间", "30");
                        } else if (i == 3) {
                            com.fotoable.youtube.music.newplayer.e.a().a(a.this.f, 2700L);
                            j = 2700000 + currentTimeMillis;
                            com.fotoable.youtube.music.util.b.b("定时关闭界面-选择时间", "时间", "45");
                        } else if (i == 4) {
                            com.fotoable.youtube.music.newplayer.e.a().a(a.this.f, 3600L);
                            j = 3600000 + currentTimeMillis;
                            com.fotoable.youtube.music.util.b.b("定时关闭界面-选择时间", "时间", "60");
                        } else {
                            j = currentTimeMillis;
                        }
                        Toast.makeText(a.this.f3844c, a.this.f3844c.getString(R.string.timer_set_ok_msg) + " " + TimerActivity.this.f3839b.format(Long.valueOf(j)), 0).show();
                    }
                    a.this.notifyDataSetChanged();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.e != null) {
                return this.e.size();
            }
            return 0;
        }

        /* renamed from: com.fotoable.youtube.music.ui.activity.TimerActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0065a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f3849a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f3850b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f3851c;
            public View d;

            public C0065a(View view) {
                super(view);
                this.f3849a = (TextView) view.findViewById(R.id.timer_type);
                this.f3850b = (TextView) view.findViewById(R.id.timer_real);
                this.f3851c = (ImageView) view.findViewById(R.id.timer_selected);
                this.d = view.findViewById(R.id.line);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.play_end_panel, R.id.back_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_view /* 2131820733 */:
                finish();
                return;
            case R.id.play_end_panel /* 2131820944 */:
                this.play_end_checkbox.setChecked(!this.play_end_checkbox.isChecked());
                return;
            default:
                return;
        }
    }
}
