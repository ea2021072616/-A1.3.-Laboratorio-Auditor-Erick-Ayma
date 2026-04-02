package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import e4.e;
import j4.d;
import y.n;
import y.q;
/* loaded from: classes.dex */
public final class TypefaceContainer {
    private int typeFaceResource;
    private String typeFaceUrl;

    public TypefaceContainer() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ TypefaceContainer copy$default(TypefaceContainer typefaceContainer, String str, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = typefaceContainer.typeFaceUrl;
        }
        if ((i6 & 2) != 0) {
            i5 = typefaceContainer.typeFaceResource;
        }
        return typefaceContainer.copy(str, i5);
    }

    public final void applyTo(final TextView textView) {
        if (textView == null || textView.getContext() == null) {
            return;
        }
        if (this.typeFaceUrl == null && this.typeFaceResource == 0) {
            return;
        }
        n nVar = new n() { // from class: com.github.appintro.internal.TypefaceContainer$applyTo$callback$1
            @Override // y.n
            public void onFontRetrievalFailed(int i5) {
            }

            @Override // y.n
            public void onFontRetrieved(Typeface typeface) {
                e.f(typeface, "typeface");
                textView.setTypeface(typeface);
            }
        };
        if (this.typeFaceResource != 0) {
            q.b(textView.getContext(), this.typeFaceResource, nVar);
            return;
        }
        CustomFontCache customFontCache = CustomFontCache.INSTANCE;
        Context context = textView.getContext();
        e.e(context, "textView.context");
        customFontCache.getFont(context, this.typeFaceUrl, nVar);
    }

    public final String component1() {
        return this.typeFaceUrl;
    }

    public final int component2() {
        return this.typeFaceResource;
    }

    public final TypefaceContainer copy(String str, int i5) {
        return new TypefaceContainer(str, i5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TypefaceContainer) {
                TypefaceContainer typefaceContainer = (TypefaceContainer) obj;
                return e.a(this.typeFaceUrl, typefaceContainer.typeFaceUrl) && this.typeFaceResource == typefaceContainer.typeFaceResource;
            }
            return false;
        }
        return true;
    }

    public final int getTypeFaceResource() {
        return this.typeFaceResource;
    }

    public final String getTypeFaceUrl() {
        return this.typeFaceUrl;
    }

    public int hashCode() {
        String str = this.typeFaceUrl;
        return ((str != null ? str.hashCode() : 0) * 31) + this.typeFaceResource;
    }

    public final void setTypeFaceResource(int i5) {
        this.typeFaceResource = i5;
    }

    public final void setTypeFaceUrl(String str) {
        this.typeFaceUrl = str;
    }

    public String toString() {
        return "TypefaceContainer(typeFaceUrl=" + this.typeFaceUrl + ", typeFaceResource=" + this.typeFaceResource + ")";
    }

    public TypefaceContainer(String str, int i5) {
        this.typeFaceUrl = str;
        this.typeFaceResource = i5;
    }

    public /* synthetic */ TypefaceContainer(String str, int i5, int i6, d dVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? 0 : i5);
    }
}
