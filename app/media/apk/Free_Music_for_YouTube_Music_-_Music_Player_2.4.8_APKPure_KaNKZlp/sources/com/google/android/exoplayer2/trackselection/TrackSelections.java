package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class TrackSelections<T> {
    private int hashCode;
    public final T info;
    public final int length;
    private final TrackSelection[] trackSelections;

    public TrackSelections(T t, TrackSelection... trackSelectionArr) {
        this.info = t;
        this.trackSelections = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public TrackSelection get(int i) {
        return this.trackSelections[i];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[]) this.trackSelections.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackSelections) + 527;
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.trackSelections, ((TrackSelections) obj).trackSelections);
    }
}
