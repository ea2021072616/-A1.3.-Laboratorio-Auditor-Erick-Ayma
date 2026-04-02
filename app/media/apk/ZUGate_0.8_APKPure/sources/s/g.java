package s;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f4698a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray f4699b = new SparseArray();

    public g(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            int eventType = xml.getEventType();
            androidx.activity.result.j jVar = null;
            while (true) {
                char c5 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c5 = 4;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c5 = 3;
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    if (c5 == 2) {
                        androidx.activity.result.j jVar2 = new androidx.activity.result.j(context, xml);
                        this.f4698a.put(jVar2.f99g, jVar2);
                        jVar = jVar2;
                        continue;
                    } else if (c5 == 3) {
                        f fVar = new f(context, xml);
                        if (jVar != null) {
                            ((ArrayList) jVar.f101i).add(fVar);
                            continue;
                        } else {
                            continue;
                        }
                    } else if (c5 != 4) {
                        continue;
                    } else {
                        a(context, xml);
                        continue;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x0226, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.g.a(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
