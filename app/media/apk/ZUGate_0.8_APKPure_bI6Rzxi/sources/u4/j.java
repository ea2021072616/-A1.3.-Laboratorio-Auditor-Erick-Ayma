package u4;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.d0;
import androidx.fragment.app.r;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import d.n;
import java.util.List;
import ru.zdevs.zugate.MainActivity;
import ru.zdevs.zugate.activity.CreateEncFSActivity;
import ru.zdevs.zugate.jni.EncFS;
/* loaded from: classes.dex */
public class j extends r {

    /* renamed from: w  reason: collision with root package name */
    public View f5166w;

    /* renamed from: x  reason: collision with root package name */
    public Uri f5167x;

    /* renamed from: y  reason: collision with root package name */
    public static final String[] f5164y = {"ssl/aes", "ssl/blowfish", "ssl/camellia"};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f5165z = {512, 1024, 2048};
    public static final int[] A = {128, 192, 256};
    public static final String[] B = {"nameio/stream", "nameio/block", "nameio/null"};

    @Override // androidx.fragment.app.r
    public final Dialog h(Bundle bundle) {
        onCreateView(getLayoutInflater(), null, bundle);
        this.f5166w.findViewById(R.id.create).setVisibility(8);
        d.m mVar = new d.m(a());
        mVar.e(R.string.activity_encfs);
        mVar.f(this.f5166w);
        mVar.d(R.string.create, null);
        mVar.b(R.string.cancel, new t4.b(2));
        final n a5 = mVar.a();
        a5.setOnShowListener(new DialogInterface.OnShowListener() { // from class: u4.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                String[] strArr = j.f5164y;
                j jVar = j.this;
                jVar.getClass();
                n nVar = a5;
                nVar.f(-1).setOnClickListener(new r3.n(jVar, 2, nVar));
            }
        });
        return a5;
    }

    public final boolean k() {
        int i5;
        List list;
        x4.c cVar;
        if (this.f5167x == null) {
            Toast.makeText(a(), (int) R.string.choouse_location, 0).show();
            return false;
        }
        String charSequence = ((TextView) this.f5166w.findViewById(R.id.password)).getText().toString();
        String charSequence2 = ((TextView) this.f5166w.findViewById(R.id.password_confirm)).getText().toString();
        if (charSequence.isEmpty()) {
            Toast.makeText(a(), (int) R.string.please_enter_password, 0).show();
            return false;
        } else if (!charSequence.equals(charSequence2)) {
            Toast.makeText(a(), (int) R.string.password_mismatch, 0).show();
            return false;
        } else {
            EncFS.EncFSContext encFSContext = new EncFS.EncFSContext();
            encFSContext.subVersion = 20100713;
            encFSContext.cipherVer = 196608;
            encFSContext.cipherAlg = f5164y[((Spinner) this.f5166w.findViewById(R.id.algorithm)).getSelectedItemPosition()];
            int selectedItemPosition = ((Spinner) this.f5166w.findViewById(R.id.filename_encoding)).getSelectedItemPosition();
            if (selectedItemPosition == 0) {
                encFSContext.nameVer = 131073;
            } else if (selectedItemPosition == 1) {
                encFSContext.nameVer = 262144;
            } else {
                encFSContext.nameVer = 0;
            }
            encFSContext.nameAlg = B[selectedItemPosition];
            encFSContext.keySize = A[((Spinner) this.f5166w.findViewById(R.id.key_size)).getSelectedItemPosition()];
            encFSContext.blockSize = f5165z[((Spinner) this.f5166w.findViewById(R.id.block_size)).getSelectedItemPosition()];
            try {
                i5 = Integer.parseInt(((TextView) this.f5166w.findViewById(R.id.kdf_iterations)).getText().toString());
            } catch (Exception unused) {
                i5 = 0;
            }
            encFSContext.kdfIterations = i5;
            if (i5 > 1000000) {
                encFSContext.kdfIterations = 1000000;
            }
            if (((CheckBox) this.f5166w.findViewById(R.id.unique_iv)).isChecked()) {
                encFSContext.flags |= 2;
            }
            if (((CheckBox) this.f5166w.findViewById(R.id.filename_iv_chaining)).isChecked()) {
                encFSContext.flags |= 4;
            }
            if (((CheckBox) this.f5166w.findViewById(R.id.allow_empty_blocks)).isChecked()) {
                encFSContext.flags |= 16;
            }
            d0 a5 = a();
            if (a5 instanceof CreateEncFSActivity) {
                CreateEncFSActivity createEncFSActivity = (CreateEncFSActivity) a5;
                list = createEncFSActivity.f4586g;
                cVar = createEncFSActivity.f4587h;
            } else if (!(a5 instanceof MainActivity)) {
                return false;
            } else {
                MainActivity mainActivity = (MainActivity) a5;
                list = mainActivity.f4554i;
                cVar = mainActivity.f4555j;
            }
            new i(list, this.f5167x, charSequence, encFSContext).b(null, cVar);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i5, int i6, Intent intent) {
        d0 a5;
        super.onActivityResult(i5, i6, intent);
        if (i5 != 1990 || intent == null || intent.getData() == null || (a5 = a()) == null) {
            return;
        }
        this.f5167x = intent.getData();
        ContentResolver contentResolver = a5.getContentResolver();
        Cursor B2 = i0.B(contentResolver, this.f5167x, "");
        boolean z4 = false;
        if (B2 != null) {
            int count = B2.getCount();
            if (count == 1) {
                B2.moveToFirst();
                if (".nomedia".equalsIgnoreCase(B2.getString(1))) {
                    count = 0;
                }
            }
            B2.close();
            if (count == 0) {
                z4 = true;
            }
        }
        if (z4) {
            ((TextView) this.f5166w.findViewById(R.id.location_path)).setText(i0.C(contentResolver, this.f5167x));
            return;
        }
        this.f5167x = null;
        Toast.makeText(a5, (int) R.string.location_must_be_empty, 1).show();
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f5166w;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_encfs, viewGroup, false);
        this.f5166w = inflate;
        ((Button) inflate.findViewById(R.id.location_select)).setOnClickListener(new View.OnClickListener(this) { // from class: u4.g

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ j f5158h;

            {
                this.f5158h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = r2;
                j jVar = this.f5158h;
                switch (i5) {
                    case 0:
                        String[] strArr = j.f5164y;
                        d0 a5 = jVar.a();
                        if (a5 == null) {
                            return;
                        }
                        Intent u3 = i0.u(a5, "android.intent.action.OPEN_DOCUMENT_TREE");
                        u3.putExtra("android.intent.extra.LOCAL_ONLY", true);
                        a5.startActivityForResult(u3, 1990);
                        return;
                    default:
                        String[] strArr2 = j.f5164y;
                        jVar.k();
                        return;
                }
            }
        });
        ((Spinner) this.f5166w.findViewById(R.id.block_size)).setSelection(1);
        ((Spinner) this.f5166w.findViewById(R.id.key_size)).setSelection(1);
        ((CheckBox) this.f5166w.findViewById(R.id.unique_iv)).setChecked(true);
        this.f5166w.findViewById(R.id.create).setOnClickListener(new View.OnClickListener(this) { // from class: u4.g

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ j f5158h;

            {
                this.f5158h = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = r2;
                j jVar = this.f5158h;
                switch (i5) {
                    case 0:
                        String[] strArr = j.f5164y;
                        d0 a5 = jVar.a();
                        if (a5 == null) {
                            return;
                        }
                        Intent u3 = i0.u(a5, "android.intent.action.OPEN_DOCUMENT_TREE");
                        u3.putExtra("android.intent.extra.LOCAL_ONLY", true);
                        a5.startActivityForResult(u3, 1990);
                        return;
                    default:
                        String[] strArr2 = j.f5164y;
                        jVar.k();
                        return;
                }
            }
        });
        return this.f5166w;
    }
}
