package h0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
/* loaded from: classes.dex */
public abstract class r {
    public static int a(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    public static CharSequence b(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    public static ColorStateList c(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    public static PorterDuff.Mode d(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    public static int e(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    public static CharSequence f(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    public static MenuItem g(MenuItem menuItem, char c5, int i5) {
        return menuItem.setAlphabeticShortcut(c5, i5);
    }

    public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    public static MenuItem k(MenuItem menuItem, char c5, int i5) {
        return menuItem.setNumericShortcut(c5, i5);
    }

    public static MenuItem l(MenuItem menuItem, char c5, char c6, int i5, int i6) {
        return menuItem.setShortcut(c5, c6, i5, i6);
    }

    public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}
