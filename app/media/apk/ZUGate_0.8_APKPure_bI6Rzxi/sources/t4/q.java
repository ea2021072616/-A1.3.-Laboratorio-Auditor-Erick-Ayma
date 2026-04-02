package t4;

import android.database.MatrixCursor;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final int f5079a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5080b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5081c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5082d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5083e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5084f;

    public q(MatrixCursor matrixCursor) {
        this.f5079a = matrixCursor.getColumnIndex("document_id");
        this.f5080b = matrixCursor.getColumnIndex("_display_name");
        this.f5081c = matrixCursor.getColumnIndex("mime_type");
        this.f5082d = matrixCursor.getColumnIndex("flags");
        this.f5083e = matrixCursor.getColumnIndex("_size");
        this.f5084f = matrixCursor.getColumnIndex("last_modified");
    }
}
