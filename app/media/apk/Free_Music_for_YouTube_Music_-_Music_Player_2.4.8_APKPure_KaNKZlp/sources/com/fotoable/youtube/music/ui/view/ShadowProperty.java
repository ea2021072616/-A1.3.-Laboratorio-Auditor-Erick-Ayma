package com.fotoable.youtube.music.ui.view;
/* loaded from: classes.dex */
public class ShadowProperty {
    public static final int ALL = 4369;
    public static final int BOTTOM = 4096;
    public static final int LEFT = 1;
    public static final int RIGHT = 256;
    public static final int TOP = 16;
    private int shadowColor;
    private int shadowDx;
    private int shadowDy;
    private int shadowRadius;
    private int shadowSide = ALL;

    public int getShadowSide() {
        return this.shadowSide;
    }

    public ShadowProperty setShadowSide(int i) {
        this.shadowSide = i;
        return this;
    }

    public int getShadowOffset() {
        return getShadowOffsetHalf() * 2;
    }

    public int getShadowOffsetHalf() {
        if (this.shadowRadius <= 0) {
            return 0;
        }
        return Math.max(this.shadowDx, this.shadowDy) + this.shadowRadius;
    }

    public int getShadowColor() {
        return this.shadowColor;
    }

    public ShadowProperty setShadowColor(int i) {
        this.shadowColor = i;
        return this;
    }

    public int getShadowRadius() {
        return this.shadowRadius;
    }

    public ShadowProperty setShadowRadius(int i) {
        this.shadowRadius = i;
        return this;
    }

    public int getShadowDx() {
        return this.shadowDx;
    }

    public ShadowProperty setShadowDx(int i) {
        this.shadowDx = i;
        return this;
    }

    public int getShadowDy() {
        return this.shadowDy;
    }

    public ShadowProperty setShadowDy(int i) {
        this.shadowDy = i;
        return this;
    }
}
