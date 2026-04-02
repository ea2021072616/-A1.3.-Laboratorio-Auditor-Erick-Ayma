package com.github.appintro;

import j4.d;
/* loaded from: classes.dex */
public abstract class AppIntroPageTransformerType {

    /* loaded from: classes.dex */
    public static final class Depth extends AppIntroPageTransformerType {
        public static final Depth INSTANCE = new Depth();

        private Depth() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Fade extends AppIntroPageTransformerType {
        public static final Fade INSTANCE = new Fade();

        private Fade() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Flow extends AppIntroPageTransformerType {
        public static final Flow INSTANCE = new Flow();

        private Flow() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Parallax extends AppIntroPageTransformerType {
        private final double descriptionParallaxFactor;
        private final double imageParallaxFactor;
        private final double titleParallaxFactor;

        public Parallax() {
            this(0.0d, 0.0d, 0.0d, 7, null);
        }

        public final double getDescriptionParallaxFactor() {
            return this.descriptionParallaxFactor;
        }

        public final double getImageParallaxFactor() {
            return this.imageParallaxFactor;
        }

        public final double getTitleParallaxFactor() {
            return this.titleParallaxFactor;
        }

        public /* synthetic */ Parallax(double d5, double d6, double d7, int i5, d dVar) {
            this((i5 & 1) != 0 ? 1.0d : d5, (i5 & 2) != 0 ? -1.0d : d6, (i5 & 4) != 0 ? 2.0d : d7);
        }

        public Parallax(double d5, double d6, double d7) {
            super(null);
            this.titleParallaxFactor = d5;
            this.imageParallaxFactor = d6;
            this.descriptionParallaxFactor = d7;
        }
    }

    /* loaded from: classes.dex */
    public static final class SlideOver extends AppIntroPageTransformerType {
        public static final SlideOver INSTANCE = new SlideOver();

        private SlideOver() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Zoom extends AppIntroPageTransformerType {
        public static final Zoom INSTANCE = new Zoom();

        private Zoom() {
            super(null);
        }
    }

    private AppIntroPageTransformerType() {
    }

    public /* synthetic */ AppIntroPageTransformerType(d dVar) {
        this();
    }
}
