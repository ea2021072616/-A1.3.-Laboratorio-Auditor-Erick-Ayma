package com.github.appintro;

import com.github.appintro.model.SliderPage;
import e4.e;
import j4.d;
/* loaded from: classes.dex */
public final class AppIntroFragment extends AppIntroBaseFragment {
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d dVar) {
            this();
        }

        public static /* synthetic */ AppIntroFragment newInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                charSequence = null;
            }
            if ((i12 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i12 & 4) != 0) {
                i5 = 0;
            }
            if ((i12 & 8) != 0) {
                i6 = 0;
            }
            if ((i12 & 16) != 0) {
                i7 = 0;
            }
            if ((i12 & 32) != 0) {
                i8 = 0;
            }
            if ((i12 & 64) != 0) {
                i9 = 0;
            }
            if ((i12 & 128) != 0) {
                i10 = 0;
            }
            if ((i12 & 256) != 0) {
                i11 = 0;
            }
            return companion.newInstance(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, i11);
        }

        public final AppIntroFragment newInstance() {
            return newInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence) {
            return newInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
            return newInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5) {
            return newInstance$default(this, charSequence, charSequence2, i5, 0, 0, 0, 0, 0, 0, 504, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6) {
            return newInstance$default(this, charSequence, charSequence2, i5, i6, 0, 0, 0, 0, 0, 496, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7) {
            return newInstance$default(this, charSequence, charSequence2, i5, i6, i7, 0, 0, 0, 0, 480, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8) {
            return newInstance$default(this, charSequence, charSequence2, i5, i6, i7, i8, 0, 0, 0, 448, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9) {
            return newInstance$default(this, charSequence, charSequence2, i5, i6, i7, i8, i9, 0, 0, 384, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10) {
            return newInstance$default(this, charSequence, charSequence2, i5, i6, i7, i8, i9, i10, 0, 256, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            return newInstance(new SliderPage(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, null, null, i11, 768, null));
        }

        public final AppIntroFragment newInstance(SliderPage sliderPage) {
            e.f(sliderPage, "sliderPage");
            AppIntroFragment appIntroFragment = new AppIntroFragment();
            appIntroFragment.setArguments(sliderPage.toBundle());
            return appIntroFragment;
        }
    }

    public static final AppIntroFragment newInstance() {
        return Companion.newInstance$default(Companion, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    @Override // com.github.appintro.AppIntroBaseFragment
    public int getLayoutId() {
        return R.layout.appintro_fragment_intro;
    }

    public static final AppIntroFragment newInstance(SliderPage sliderPage) {
        return Companion.newInstance(sliderPage);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence) {
        return Companion.newInstance$default(Companion, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, 0, 0, 0, 0, 0, 0, 504, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, i6, 0, 0, 0, 0, 0, 496, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, i6, i7, 0, 0, 0, 0, 480, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, i6, i7, i8, 0, 0, 0, 448, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, i6, i7, i8, i9, 0, 0, 384, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i5, i6, i7, i8, i9, i10, 0, 256, null);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return Companion.newInstance(charSequence, charSequence2, i5, i6, i7, i8, i9, i10, i11);
    }
}
