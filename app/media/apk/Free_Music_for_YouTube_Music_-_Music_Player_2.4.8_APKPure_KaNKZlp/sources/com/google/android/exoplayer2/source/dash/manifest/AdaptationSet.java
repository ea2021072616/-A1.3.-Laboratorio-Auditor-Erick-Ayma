package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AdaptationSet {
    public static final int UNSET_ID = -1;
    public final int id;
    public final List<Representation> representations;
    public final int type;

    public AdaptationSet(int i, int i2, List<Representation> list) {
        this.id = i;
        this.type = i2;
        this.representations = Collections.unmodifiableList(list);
    }
}
