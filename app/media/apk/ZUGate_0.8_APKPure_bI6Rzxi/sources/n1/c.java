package n1;

import androidx.appcompat.widget.b0;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f4083a = {"", "k", "m", "b", "t"};

    /* renamed from: b  reason: collision with root package name */
    public final DecimalFormat f4084b = new DecimalFormat("###E00");

    @Override // n1.d
    public final String a(float f5) {
        StringBuilder sb = new StringBuilder();
        String format = this.f4084b.format(f5);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f4083a[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= 5 && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return b0.i(sb, replaceAll, "");
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }
}
