package t4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.github.appintro.R;
import ru.zdevs.zugate.MainActivity;
import ru.zdevs.zugate.ZApp;
/* loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5038a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MainActivity f5039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5040c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f5041d;

    public /* synthetic */ c(MainActivity mainActivity, a aVar, Object obj, int i5) {
        this.f5038a = i5;
        this.f5039b = mainActivity;
        this.f5040c = aVar;
        this.f5041d = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        int i5 = this.f5038a;
        final a aVar = this.f5040c;
        final MainActivity mainActivity = this.f5039b;
        Object obj = this.f5041d;
        switch (i5) {
            case 0:
                final TextView textView = (TextView) obj;
                int i6 = MainActivity.f4551q;
                mainActivity.getClass();
                Button f5 = ((d.n) dialogInterface).f(-3);
                if (f5 != null) {
                    f5.setOnClickListener(new View.OnClickListener() { // from class: t4.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i7 = r4;
                            a aVar2 = aVar;
                            MainActivity mainActivity2 = mainActivity;
                            Object obj2 = textView;
                            switch (i7) {
                                case 0:
                                    String str = (String) obj2;
                                    int i8 = MainActivity.f4551q;
                                    ClipboardManager clipboardManager = (ClipboardManager) mainActivity2.getSystemService("clipboard");
                                    if (clipboardManager == null) {
                                        return;
                                    }
                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(aVar2.f5028b, str));
                                    ZApp.c(R.string.data_copied, new Object[0]);
                                    return;
                                default:
                                    TextView textView2 = (TextView) obj2;
                                    int i9 = MainActivity.f4551q;
                                    ClipboardManager clipboardManager2 = (ClipboardManager) mainActivity2.getSystemService("clipboard");
                                    if (clipboardManager2 == null) {
                                        return;
                                    }
                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(aVar2.f5028b, textView2.getText().toString()));
                                    ZApp.c(R.string.data_copied, new Object[0]);
                                    return;
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                final String str = (String) obj;
                int i7 = MainActivity.f4551q;
                mainActivity.getClass();
                Button f6 = ((d.n) dialogInterface).f(-3);
                if (f6 != null) {
                    f6.setOnClickListener(new View.OnClickListener() { // from class: t4.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i72 = r4;
                            a aVar2 = aVar;
                            MainActivity mainActivity2 = mainActivity;
                            Object obj2 = str;
                            switch (i72) {
                                case 0:
                                    String str2 = (String) obj2;
                                    int i8 = MainActivity.f4551q;
                                    ClipboardManager clipboardManager = (ClipboardManager) mainActivity2.getSystemService("clipboard");
                                    if (clipboardManager == null) {
                                        return;
                                    }
                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(aVar2.f5028b, str2));
                                    ZApp.c(R.string.data_copied, new Object[0]);
                                    return;
                                default:
                                    TextView textView2 = (TextView) obj2;
                                    int i9 = MainActivity.f4551q;
                                    ClipboardManager clipboardManager2 = (ClipboardManager) mainActivity2.getSystemService("clipboard");
                                    if (clipboardManager2 == null) {
                                        return;
                                    }
                                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(aVar2.f5028b, textView2.getText().toString()));
                                    ZApp.c(R.string.data_copied, new Object[0]);
                                    return;
                            }
                        }
                    });
                    return;
                }
                return;
        }
    }
}
