package com.fotoable.youtube.music.newplayer;

import com.fotoable.youtube.music.newplayer.model.PlayerInfo;
/* compiled from: PlayerClientDataManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final d f2897a = new d();

    /* renamed from: b  reason: collision with root package name */
    private PlayerInfo f2898b;

    /* renamed from: c  reason: collision with root package name */
    private int f2899c;
    private int d = 0;

    public static d a() {
        return f2897a;
    }

    private d() {
    }

    public void a(PlayerInfo playerInfo) {
        this.f2898b = playerInfo;
    }

    public PlayerInfo b() {
        return this.f2898b;
    }

    public void a(int i) {
        this.f2899c = i;
    }

    public int c() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
        if (this.f2899c <= 0) {
            this.d = 0;
        }
    }
}
