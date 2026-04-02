package com.pili.pldroid.player.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.IMediaController;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.PlayerState;
import java.util.HashMap;
import java.util.Map;
/* compiled from: PLBaseVideoView.java */
/* loaded from: classes2.dex */
abstract class a extends FrameLayout implements IMediaController.MediaPlayerControl {
    public static final int ASPECT_RATIO_16_9 = 3;
    public static final int ASPECT_RATIO_4_3 = 4;
    public static final int ASPECT_RATIO_FIT_PARENT = 1;
    public static final int ASPECT_RATIO_ORIGIN = 0;
    public static final int ASPECT_RATIO_PAVED_PARENT = 2;
    private PLMediaPlayer.OnBufferingUpdateListener A;
    private PLMediaPlayer.OnSeekCompleteListener B;
    private PLMediaPlayer.OnVideoSizeChangedListener C;
    private PLMediaPlayer.a D;
    private PLMediaPlayer.OnPreparedListener E;
    private PLMediaPlayer.OnVideoSizeChangedListener F;
    private PLMediaPlayer.OnSeekCompleteListener G;
    private PLMediaPlayer.OnInfoListener H;
    private PLMediaPlayer.OnBufferingUpdateListener I;
    private PLMediaPlayer.OnCompletionListener J;
    private PLMediaPlayer.OnErrorListener K;
    private InterfaceC0100a.InterfaceC0101a L;

    /* renamed from: a  reason: collision with root package name */
    protected Surface f5100a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f5101b;

    /* renamed from: c  reason: collision with root package name */
    private int f5102c;
    private int d;
    private long e;
    private int f;
    private Uri g;
    private AVOptions h;
    private int i;
    private int j;
    private View k;
    private InterfaceC0100a l;
    private PLMediaPlayer m;
    private IMediaController n;
    private View o;
    private int p;
    private boolean q;
    private boolean r;
    private int s;
    private float t;
    private float u;
    private boolean v;
    private PLMediaPlayer.OnCompletionListener w;
    private PLMediaPlayer.OnPreparedListener x;
    private PLMediaPlayer.OnErrorListener y;
    private PLMediaPlayer.OnInfoListener z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: PLBaseVideoView.java */
    /* renamed from: com.pili.pldroid.player.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0100a {

        /* compiled from: PLBaseVideoView.java */
        /* renamed from: com.pili.pldroid.player.widget.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0101a {
            void a(Surface surface);

            void a(Surface surface, int i, int i2);

            void b(Surface surface, int i, int i2);
        }

        void a(int i, int i2);

        View getView();

        void setRenderCallback(InterfaceC0101a interfaceC0101a);
    }

    protected abstract InterfaceC0100a getRenderView();

    public a(Context context) {
        super(context);
        this.f5102c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.o = null;
        this.p = 1;
        this.q = false;
        this.r = true;
        this.s = 1;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = false;
        this.f5101b = true;
        this.E = new PLMediaPlayer.OnPreparedListener() { // from class: com.pili.pldroid.player.widget.a.1
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnPreparedListener
            public void onPrepared(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.i = 2;
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.x != null) {
                    a.this.x.onPrepared(pLMediaPlayer, i);
                }
                if (a.this.n != null) {
                    a.this.n.setEnabled(true);
                }
                if (a.this.e != 0) {
                    a.this.seekTo(a.this.e);
                }
                if (a.this.j == 3) {
                    a.this.start();
                    if (a.this.n != null) {
                        a.this.n.show();
                    }
                }
            }
        };
        this.F = new PLMediaPlayer.OnVideoSizeChangedListener() { // from class: com.pili.pldroid.player.widget.a.2
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(PLMediaPlayer pLMediaPlayer, int i, int i2, int i3, int i4) {
                if (a.this.C != null) {
                    a.this.C.onVideoSizeChanged(pLMediaPlayer, i, i2, i3, i4);
                }
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.f5102c != 0 && a.this.d != 0) {
                    a.this.l.a(a.this.f5102c, a.this.d);
                    a.this.requestLayout();
                }
            }
        };
        this.G = new PLMediaPlayer.OnSeekCompleteListener() { // from class: com.pili.pldroid.player.widget.a.3
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(PLMediaPlayer pLMediaPlayer) {
                if (a.this.B != null) {
                    a.this.B.onSeekComplete(pLMediaPlayer);
                }
            }
        };
        this.H = new PLMediaPlayer.OnInfoListener() { // from class: com.pili.pldroid.player.widget.a.4
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnInfoListener
            public boolean onInfo(PLMediaPlayer pLMediaPlayer, int i, int i2) {
                if (a.this.z != null) {
                    a.this.z.onInfo(pLMediaPlayer, i, i2);
                }
                if (a.this.k != null) {
                    if (i == 701 && !pLMediaPlayer.a()) {
                        a.this.k.setVisibility(0);
                    } else if (i == 702 || i == 10002 || i == 3) {
                        a.this.k.setVisibility(8);
                    }
                }
                if (i == 3 && a.this.o != null) {
                    a.this.o.setVisibility(8);
                    return true;
                }
                return true;
            }
        };
        this.I = new PLMediaPlayer.OnBufferingUpdateListener() { // from class: com.pili.pldroid.player.widget.a.5
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.f = i;
                if (a.this.A != null) {
                    a.this.A.onBufferingUpdate(pLMediaPlayer, i);
                }
            }
        };
        this.J = new PLMediaPlayer.OnCompletionListener() { // from class: com.pili.pldroid.player.widget.a.6
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnCompletionListener
            public void onCompletion(PLMediaPlayer pLMediaPlayer) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.w != null) {
                    a.this.w.onCompletion(pLMediaPlayer);
                }
                a.this.i = 5;
                a.this.j = 5;
            }
        };
        this.K = new PLMediaPlayer.OnErrorListener() { // from class: com.pili.pldroid.player.widget.a.7
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnErrorListener
            public boolean onError(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.i = -1;
                a.this.j = -1;
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.y != null) {
                    return a.this.y.onError(pLMediaPlayer, i);
                }
                return true;
            }
        };
        this.L = new InterfaceC0100a.InterfaceC0101a() { // from class: com.pili.pldroid.player.widget.a.8
            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface, int i, int i2) {
                if (a.this.f5100a == null) {
                    a.this.f5100a = surface;
                }
                if (a.this.m != null) {
                    a.this.a(a.this.m, surface);
                } else {
                    a.this.c();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void b(Surface surface, int i, int i2) {
                boolean z = true;
                boolean z2 = a.this.j == 3;
                if (a.this.f5102c != i || a.this.d != i2) {
                    z = false;
                }
                if (a.this.m != null && z2 && z) {
                    if (a.this.e != 0) {
                        a.this.seekTo(a.this.e);
                    }
                    a.this.start();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                a.this.a();
            }
        };
        a(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5102c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.o = null;
        this.p = 1;
        this.q = false;
        this.r = true;
        this.s = 1;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = false;
        this.f5101b = true;
        this.E = new PLMediaPlayer.OnPreparedListener() { // from class: com.pili.pldroid.player.widget.a.1
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnPreparedListener
            public void onPrepared(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.i = 2;
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.x != null) {
                    a.this.x.onPrepared(pLMediaPlayer, i);
                }
                if (a.this.n != null) {
                    a.this.n.setEnabled(true);
                }
                if (a.this.e != 0) {
                    a.this.seekTo(a.this.e);
                }
                if (a.this.j == 3) {
                    a.this.start();
                    if (a.this.n != null) {
                        a.this.n.show();
                    }
                }
            }
        };
        this.F = new PLMediaPlayer.OnVideoSizeChangedListener() { // from class: com.pili.pldroid.player.widget.a.2
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(PLMediaPlayer pLMediaPlayer, int i, int i2, int i3, int i4) {
                if (a.this.C != null) {
                    a.this.C.onVideoSizeChanged(pLMediaPlayer, i, i2, i3, i4);
                }
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.f5102c != 0 && a.this.d != 0) {
                    a.this.l.a(a.this.f5102c, a.this.d);
                    a.this.requestLayout();
                }
            }
        };
        this.G = new PLMediaPlayer.OnSeekCompleteListener() { // from class: com.pili.pldroid.player.widget.a.3
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(PLMediaPlayer pLMediaPlayer) {
                if (a.this.B != null) {
                    a.this.B.onSeekComplete(pLMediaPlayer);
                }
            }
        };
        this.H = new PLMediaPlayer.OnInfoListener() { // from class: com.pili.pldroid.player.widget.a.4
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnInfoListener
            public boolean onInfo(PLMediaPlayer pLMediaPlayer, int i, int i2) {
                if (a.this.z != null) {
                    a.this.z.onInfo(pLMediaPlayer, i, i2);
                }
                if (a.this.k != null) {
                    if (i == 701 && !pLMediaPlayer.a()) {
                        a.this.k.setVisibility(0);
                    } else if (i == 702 || i == 10002 || i == 3) {
                        a.this.k.setVisibility(8);
                    }
                }
                if (i == 3 && a.this.o != null) {
                    a.this.o.setVisibility(8);
                    return true;
                }
                return true;
            }
        };
        this.I = new PLMediaPlayer.OnBufferingUpdateListener() { // from class: com.pili.pldroid.player.widget.a.5
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.f = i;
                if (a.this.A != null) {
                    a.this.A.onBufferingUpdate(pLMediaPlayer, i);
                }
            }
        };
        this.J = new PLMediaPlayer.OnCompletionListener() { // from class: com.pili.pldroid.player.widget.a.6
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnCompletionListener
            public void onCompletion(PLMediaPlayer pLMediaPlayer) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.w != null) {
                    a.this.w.onCompletion(pLMediaPlayer);
                }
                a.this.i = 5;
                a.this.j = 5;
            }
        };
        this.K = new PLMediaPlayer.OnErrorListener() { // from class: com.pili.pldroid.player.widget.a.7
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnErrorListener
            public boolean onError(PLMediaPlayer pLMediaPlayer, int i) {
                a.this.i = -1;
                a.this.j = -1;
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.y != null) {
                    return a.this.y.onError(pLMediaPlayer, i);
                }
                return true;
            }
        };
        this.L = new InterfaceC0100a.InterfaceC0101a() { // from class: com.pili.pldroid.player.widget.a.8
            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface, int i, int i2) {
                if (a.this.f5100a == null) {
                    a.this.f5100a = surface;
                }
                if (a.this.m != null) {
                    a.this.a(a.this.m, surface);
                } else {
                    a.this.c();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void b(Surface surface, int i, int i2) {
                boolean z = true;
                boolean z2 = a.this.j == 3;
                if (a.this.f5102c != i || a.this.d != i2) {
                    z = false;
                }
                if (a.this.m != null && z2 && z) {
                    if (a.this.e != 0) {
                        a.this.seekTo(a.this.e);
                    }
                    a.this.start();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                a.this.a();
            }
        };
        a(context);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5102c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.o = null;
        this.p = 1;
        this.q = false;
        this.r = true;
        this.s = 1;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = false;
        this.f5101b = true;
        this.E = new PLMediaPlayer.OnPreparedListener() { // from class: com.pili.pldroid.player.widget.a.1
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnPreparedListener
            public void onPrepared(PLMediaPlayer pLMediaPlayer, int i2) {
                a.this.i = 2;
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.x != null) {
                    a.this.x.onPrepared(pLMediaPlayer, i2);
                }
                if (a.this.n != null) {
                    a.this.n.setEnabled(true);
                }
                if (a.this.e != 0) {
                    a.this.seekTo(a.this.e);
                }
                if (a.this.j == 3) {
                    a.this.start();
                    if (a.this.n != null) {
                        a.this.n.show();
                    }
                }
            }
        };
        this.F = new PLMediaPlayer.OnVideoSizeChangedListener() { // from class: com.pili.pldroid.player.widget.a.2
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(PLMediaPlayer pLMediaPlayer, int i2, int i22, int i3, int i4) {
                if (a.this.C != null) {
                    a.this.C.onVideoSizeChanged(pLMediaPlayer, i2, i22, i3, i4);
                }
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.f5102c != 0 && a.this.d != 0) {
                    a.this.l.a(a.this.f5102c, a.this.d);
                    a.this.requestLayout();
                }
            }
        };
        this.G = new PLMediaPlayer.OnSeekCompleteListener() { // from class: com.pili.pldroid.player.widget.a.3
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(PLMediaPlayer pLMediaPlayer) {
                if (a.this.B != null) {
                    a.this.B.onSeekComplete(pLMediaPlayer);
                }
            }
        };
        this.H = new PLMediaPlayer.OnInfoListener() { // from class: com.pili.pldroid.player.widget.a.4
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnInfoListener
            public boolean onInfo(PLMediaPlayer pLMediaPlayer, int i2, int i22) {
                if (a.this.z != null) {
                    a.this.z.onInfo(pLMediaPlayer, i2, i22);
                }
                if (a.this.k != null) {
                    if (i2 == 701 && !pLMediaPlayer.a()) {
                        a.this.k.setVisibility(0);
                    } else if (i2 == 702 || i2 == 10002 || i2 == 3) {
                        a.this.k.setVisibility(8);
                    }
                }
                if (i2 == 3 && a.this.o != null) {
                    a.this.o.setVisibility(8);
                    return true;
                }
                return true;
            }
        };
        this.I = new PLMediaPlayer.OnBufferingUpdateListener() { // from class: com.pili.pldroid.player.widget.a.5
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(PLMediaPlayer pLMediaPlayer, int i2) {
                a.this.f = i2;
                if (a.this.A != null) {
                    a.this.A.onBufferingUpdate(pLMediaPlayer, i2);
                }
            }
        };
        this.J = new PLMediaPlayer.OnCompletionListener() { // from class: com.pili.pldroid.player.widget.a.6
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnCompletionListener
            public void onCompletion(PLMediaPlayer pLMediaPlayer) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.w != null) {
                    a.this.w.onCompletion(pLMediaPlayer);
                }
                a.this.i = 5;
                a.this.j = 5;
            }
        };
        this.K = new PLMediaPlayer.OnErrorListener() { // from class: com.pili.pldroid.player.widget.a.7
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnErrorListener
            public boolean onError(PLMediaPlayer pLMediaPlayer, int i2) {
                a.this.i = -1;
                a.this.j = -1;
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.y != null) {
                    return a.this.y.onError(pLMediaPlayer, i2);
                }
                return true;
            }
        };
        this.L = new InterfaceC0100a.InterfaceC0101a() { // from class: com.pili.pldroid.player.widget.a.8
            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface, int i2, int i22) {
                if (a.this.f5100a == null) {
                    a.this.f5100a = surface;
                }
                if (a.this.m != null) {
                    a.this.a(a.this.m, surface);
                } else {
                    a.this.c();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void b(Surface surface, int i2, int i22) {
                boolean z = true;
                boolean z2 = a.this.j == 3;
                if (a.this.f5102c != i2 || a.this.d != i22) {
                    z = false;
                }
                if (a.this.m != null && z2 && z) {
                    if (a.this.e != 0) {
                        a.this.seekTo(a.this.e);
                    }
                    a.this.start();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                a.this.a();
            }
        };
        a(context);
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5102c = 0;
        this.d = 0;
        this.e = 0L;
        this.f = 0;
        this.i = 0;
        this.j = 0;
        this.o = null;
        this.p = 1;
        this.q = false;
        this.r = true;
        this.s = 1;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = false;
        this.f5101b = true;
        this.E = new PLMediaPlayer.OnPreparedListener() { // from class: com.pili.pldroid.player.widget.a.1
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnPreparedListener
            public void onPrepared(PLMediaPlayer pLMediaPlayer, int i22) {
                a.this.i = 2;
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.x != null) {
                    a.this.x.onPrepared(pLMediaPlayer, i22);
                }
                if (a.this.n != null) {
                    a.this.n.setEnabled(true);
                }
                if (a.this.e != 0) {
                    a.this.seekTo(a.this.e);
                }
                if (a.this.j == 3) {
                    a.this.start();
                    if (a.this.n != null) {
                        a.this.n.show();
                    }
                }
            }
        };
        this.F = new PLMediaPlayer.OnVideoSizeChangedListener() { // from class: com.pili.pldroid.player.widget.a.2
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(PLMediaPlayer pLMediaPlayer, int i22, int i222, int i3, int i4) {
                if (a.this.C != null) {
                    a.this.C.onVideoSizeChanged(pLMediaPlayer, i22, i222, i3, i4);
                }
                a.this.f5102c = pLMediaPlayer.getVideoWidth();
                a.this.d = pLMediaPlayer.getVideoHeight();
                if (a.this.f5102c != 0 && a.this.d != 0) {
                    a.this.l.a(a.this.f5102c, a.this.d);
                    a.this.requestLayout();
                }
            }
        };
        this.G = new PLMediaPlayer.OnSeekCompleteListener() { // from class: com.pili.pldroid.player.widget.a.3
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(PLMediaPlayer pLMediaPlayer) {
                if (a.this.B != null) {
                    a.this.B.onSeekComplete(pLMediaPlayer);
                }
            }
        };
        this.H = new PLMediaPlayer.OnInfoListener() { // from class: com.pili.pldroid.player.widget.a.4
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnInfoListener
            public boolean onInfo(PLMediaPlayer pLMediaPlayer, int i22, int i222) {
                if (a.this.z != null) {
                    a.this.z.onInfo(pLMediaPlayer, i22, i222);
                }
                if (a.this.k != null) {
                    if (i22 == 701 && !pLMediaPlayer.a()) {
                        a.this.k.setVisibility(0);
                    } else if (i22 == 702 || i22 == 10002 || i22 == 3) {
                        a.this.k.setVisibility(8);
                    }
                }
                if (i22 == 3 && a.this.o != null) {
                    a.this.o.setVisibility(8);
                    return true;
                }
                return true;
            }
        };
        this.I = new PLMediaPlayer.OnBufferingUpdateListener() { // from class: com.pili.pldroid.player.widget.a.5
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(PLMediaPlayer pLMediaPlayer, int i22) {
                a.this.f = i22;
                if (a.this.A != null) {
                    a.this.A.onBufferingUpdate(pLMediaPlayer, i22);
                }
            }
        };
        this.J = new PLMediaPlayer.OnCompletionListener() { // from class: com.pili.pldroid.player.widget.a.6
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnCompletionListener
            public void onCompletion(PLMediaPlayer pLMediaPlayer) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.w != null) {
                    a.this.w.onCompletion(pLMediaPlayer);
                }
                a.this.i = 5;
                a.this.j = 5;
            }
        };
        this.K = new PLMediaPlayer.OnErrorListener() { // from class: com.pili.pldroid.player.widget.a.7
            @Override // com.pili.pldroid.player.PLMediaPlayer.OnErrorListener
            public boolean onError(PLMediaPlayer pLMediaPlayer, int i22) {
                a.this.i = -1;
                a.this.j = -1;
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                if (a.this.k != null) {
                    a.this.k.setVisibility(8);
                }
                if (a.this.y != null) {
                    return a.this.y.onError(pLMediaPlayer, i22);
                }
                return true;
            }
        };
        this.L = new InterfaceC0100a.InterfaceC0101a() { // from class: com.pili.pldroid.player.widget.a.8
            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface, int i22, int i222) {
                if (a.this.f5100a == null) {
                    a.this.f5100a = surface;
                }
                if (a.this.m != null) {
                    a.this.a(a.this.m, surface);
                } else {
                    a.this.c();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void b(Surface surface, int i22, int i222) {
                boolean z = true;
                boolean z2 = a.this.j == 3;
                if (a.this.f5102c != i22 || a.this.d != i222) {
                    z = false;
                }
                if (a.this.m != null && z2 && z) {
                    if (a.this.e != 0) {
                        a.this.seekTo(a.this.e);
                    }
                    a.this.start();
                }
            }

            @Override // com.pili.pldroid.player.widget.a.InterfaceC0100a.InterfaceC0101a
            public void a(Surface surface) {
                if (a.this.n != null) {
                    a.this.n.hide();
                }
                a.this.a();
            }
        };
        a(context);
    }

    public void setDebugLoggingEnabled(boolean z) {
        this.v = z;
        if (this.m != null) {
            this.m.setDebugLoggingEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        this.l = getRenderView();
        this.l.setRenderCallback(this.L);
        this.l.getView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        addView(this.l.getView());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.i = 0;
        this.j = 0;
    }

    public void setDisplayAspectRatio(int i) {
        this.p = i;
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.requestLayout();
        }
    }

    public int getDisplayAspectRatio() {
        return this.p;
    }

    public void stopPlayback() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.m != null) {
            this.m.setDisplay(null);
        }
    }

    public void setAVOptions(AVOptions aVOptions) {
        this.h = aVOptions;
    }

    public void setVideoPath(String str) {
        if (str != null) {
            this.g = Uri.parse(str);
            setVideoURI(this.g);
            return;
        }
        this.g = null;
    }

    public void setVideoPath(String str, Map<String, String> map) {
        if (str != null) {
            setVideoURI(Uri.parse(str), map);
        } else {
            this.g = null;
        }
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.g = uri;
        if (uri != null) {
            this.e = 0L;
            this.f5101b = true;
            a(map);
            requestLayout();
            invalidate();
        }
    }

    public void setBufferingIndicator(View view) {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        this.k = view;
    }

    public void setCoverView(View view) {
        this.o = view;
    }

    public void setMediaController(IMediaController iMediaController) {
        if (this.n != null) {
            this.n.hide();
        }
        this.n = iMediaController;
        b();
    }

    public void setVolume(float f, float f2) {
        this.t = f;
        this.u = f2;
        if (this.m != null) {
            this.m.setVolume(f, f2);
        }
    }

    public void setWakeMode(Context context, int i) {
        this.s = i;
        if (this.m != null) {
            this.m.setWakeMode(context.getApplicationContext(), i);
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.r = z;
        if (this.m != null) {
            this.m.setScreenOnWhilePlaying(z);
        }
    }

    public void setLooping(boolean z) {
        this.q = z;
        if (this.m != null) {
            this.m.setLooping(z);
        }
    }

    public boolean isLooping() {
        return this.q;
    }

    protected void b() {
        if (this.m != null && this.n != null) {
            this.n.setMediaPlayer(this);
            this.n.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.n.setEnabled(e());
        }
    }

    protected void c() {
        a((Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a(java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pili.pldroid.player.widget.a.a(java.util.Map):void");
    }

    protected void a(boolean z) {
        if (this.m != null) {
            if (z) {
                this.j = 0;
                this.g = null;
            }
            this.m.stop();
            this.m.release();
            this.m = null;
            this.i = 0;
            ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void start() {
        if (this.i == 5) {
            setVideoURI(this.g);
            this.j = 3;
            return;
        }
        if (e()) {
            this.m.start();
            this.i = 3;
        }
        this.j = 3;
    }

    public void pause() {
        if (e() && this.m.isPlaying()) {
            this.m.pause();
            this.i = 4;
        }
        this.j = 4;
    }

    public long getDuration() {
        if (e()) {
            return this.m.getDuration();
        }
        return -1L;
    }

    public long getCurrentPosition() {
        if (e()) {
            return this.m.getCurrentPosition();
        }
        return 0L;
    }

    public void seekTo(long j) {
        if (e()) {
            this.m.seekTo(j);
            this.e = 0L;
            return;
        }
        this.e = j;
    }

    public boolean isPlaying() {
        return e() && this.m.isPlaying();
    }

    public int getBufferPercentage() {
        return this.f;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public PlayerState getPlayerState() {
        return this.m != null ? this.m.getPlayerState() : PlayerState.IDLE;
    }

    public HashMap<String, String> getMetadata() {
        if (this.m != null) {
            return this.m.getMetadata();
        }
        return null;
    }

    public long getVideoBitrate() {
        if (this.m != null) {
            return this.m.getVideoBitrate();
        }
        return 0L;
    }

    public int getVideoFps() {
        if (this.m != null) {
            return this.m.getVideoFps();
        }
        return 0;
    }

    public String getResolutionInline() {
        if (this.m != null) {
            return this.m.getResolutionInline();
        }
        return null;
    }

    private boolean e() {
        return (this.m == null || this.i == -1 || this.i == 0 || this.i == 1) ? false : true;
    }

    public void setOnInfoListener(PLMediaPlayer.OnInfoListener onInfoListener) {
        this.z = onInfoListener;
    }

    public void setOnErrorListener(PLMediaPlayer.OnErrorListener onErrorListener) {
        this.y = onErrorListener;
    }

    public void setOnPreparedListener(PLMediaPlayer.OnPreparedListener onPreparedListener) {
        this.x = onPreparedListener;
    }

    public void setOnCompletionListener(PLMediaPlayer.OnCompletionListener onCompletionListener) {
        this.w = onCompletionListener;
    }

    public void setOnBufferingUpdateListener(PLMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.A = onBufferingUpdateListener;
    }

    public void setOnSeekCompleteListener(PLMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.B = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(PLMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.C = onVideoSizeChangedListener;
    }

    public void setOnMediaDataListener(PLMediaPlayer.a aVar) {
        this.D = aVar;
        if (this.m != null) {
            this.m.setOnMediaDataListener(this.D);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (e() && this.n != null) {
            d();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (e() && this.n != null) {
            d();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (e() && z && this.n != null) {
            if (i == 79 || i == 85) {
                if (this.m.isPlaying()) {
                    pause();
                    this.n.show();
                    return true;
                }
                start();
                this.n.hide();
                return true;
            } else if (i == 126) {
                if (this.m.isPlaying()) {
                    return true;
                }
                start();
                this.n.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.m.isPlaying()) {
                    pause();
                    this.n.show();
                    return true;
                }
                return true;
            } else {
                d();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void d() {
        if (this.n.isShowing()) {
            this.n.hide();
        } else {
            this.n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PLMediaPlayer pLMediaPlayer, Surface surface) {
        if (pLMediaPlayer != null && surface != null) {
            pLMediaPlayer.setSurface(surface);
        }
    }
}
