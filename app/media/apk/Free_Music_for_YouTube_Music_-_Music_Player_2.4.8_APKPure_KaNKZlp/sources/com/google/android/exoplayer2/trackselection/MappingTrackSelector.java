package com.google.android.exoplayer2.trackselection;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class MappingTrackSelector extends TrackSelector<MappedTrackInfo> {
    private final SparseBooleanArray rendererDisabledFlags;
    private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;

    protected abstract TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException;

    /* loaded from: classes.dex */
    public static final class SelectionOverride {
        public final TrackSelection.Factory factory;
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(TrackSelection.Factory factory, int i, int... iArr) {
            this.factory = factory;
            this.groupIndex = i;
            this.tracks = iArr;
            this.length = iArr.length;
        }

        public TrackSelection createTrackSelection(TrackGroupArray trackGroupArray) {
            return this.factory.createTrackSelection(trackGroupArray.get(this.groupIndex), this.tracks);
        }

        public boolean containsTrack(int i) {
            for (int i2 = 0; i2 < this.tracks.length; i2++) {
                if (this.tracks[i2] == i) {
                    return true;
                }
            }
            return false;
        }
    }

    public MappingTrackSelector(Handler handler) {
        super(handler);
        this.selectionOverrides = new SparseArray<>();
        this.rendererDisabledFlags = new SparseBooleanArray();
    }

    public final void setRendererDisabled(int i, boolean z) {
        if (this.rendererDisabledFlags.get(i) != z) {
            this.rendererDisabledFlags.put(i, z);
            invalidate();
        }
    }

    public final boolean getRendererDisabled(int i) {
        return this.rendererDisabledFlags.get(i);
    }

    public final void setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        if (map == null) {
            map = new HashMap<>();
            this.selectionOverrides.put(i, map);
        }
        if (!map.containsKey(trackGroupArray) || !Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
            map.put(trackGroupArray, selectionOverride);
            invalidate();
        }
    }

    public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        return map != null && map.containsKey(trackGroupArray);
    }

    public final SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        if (map != null) {
            return map.get(trackGroupArray);
        }
        return null;
    }

    public final void clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        if (map != null && map.containsKey(trackGroupArray)) {
            map.remove(trackGroupArray);
            if (map.isEmpty()) {
                this.selectionOverrides.remove(i);
            }
            invalidate();
        }
    }

    public final void clearSelectionOverrides(int i) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        if (map != null && !map.isEmpty()) {
            this.selectionOverrides.remove(i);
            invalidate();
        }
    }

    public final void clearSelectionOverrides() {
        if (this.selectionOverrides.size() != 0) {
            this.selectionOverrides.clear();
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelections<MappedTrackInfo> selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        TrackGroup[][] trackGroupArr = new TrackGroup[rendererCapabilitiesArr.length + 1];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][];
        for (int i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.length];
            iArr2[i] = new int[trackGroupArray.length];
        }
        int[] mixedMimeTypeAdaptationSupport = getMixedMimeTypeAdaptationSupport(rendererCapabilitiesArr);
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            int[] formatSupport = findRenderer == rendererCapabilitiesArr.length ? new int[trackGroup.length] : getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            int i3 = iArr[findRenderer];
            trackGroupArr[findRenderer][i3] = trackGroup;
            iArr2[findRenderer][i3] = formatSupport;
            iArr[findRenderer] = iArr[findRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            int i5 = iArr[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[i4], i5));
            iArr2[i4] = (int[][]) Arrays.copyOf(iArr2[i4], i5);
            iArr3[i4] = rendererCapabilitiesArr[i4].getTrackType();
        }
        TrackGroupArray trackGroupArray2 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length]));
        TrackSelection[] selectTracks = selectTracks(rendererCapabilitiesArr, trackGroupArrayArr, iArr2);
        for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
            if (this.rendererDisabledFlags.get(i6)) {
                selectTracks[i6] = null;
            } else {
                TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i6];
                Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i6);
                SelectionOverride selectionOverride = map == null ? null : map.get(trackGroupArray3);
                if (selectionOverride != null) {
                    selectTracks[i6] = selectionOverride.createTrackSelection(trackGroupArray3);
                }
            }
        }
        return new TrackSelections<>(new MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupport, iArr2, trackGroupArray2), selectTracks);
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        int i;
        int i2;
        int i3 = 0;
        int length = rendererCapabilitiesArr.length;
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i4];
            int i5 = 0;
            while (i5 < trackGroup.length) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i5));
                if (supportsFormat <= i3) {
                    i = length;
                    i2 = i3;
                } else if (supportsFormat == 3) {
                    return i4;
                } else {
                    i2 = supportsFormat;
                    i = i4;
                }
                i5++;
                i3 = i2;
                length = i;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 2;
        public static final int RENDERER_SUPPORT_UNPLAYABLE_TRACKS = 1;
        private final int[][][] formatSupport;
        private final int[] mixedMimeTypeAdaptiveSupport;
        private final int rendererCount;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray[] trackGroups;
        private final TrackGroupArray unassociatedTrackGroups;

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.trackGroups = trackGroupArrayArr;
            this.formatSupport = iArr3;
            this.mixedMimeTypeAdaptiveSupport = iArr2;
            this.unassociatedTrackGroups = trackGroupArray;
            this.rendererCount = trackGroupArrayArr.length;
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.trackGroups[i];
        }

        public int getRendererSupport(int i) {
            int[][] iArr = this.formatSupport[i];
            boolean z = false;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = 0;
                while (i3 < iArr[i2].length) {
                    if ((iArr[i2][i3] & 3) != 3) {
                        i3++;
                        z = true;
                    } else {
                        return 2;
                    }
                }
            }
            return !z ? 0 : 1;
        }

        public int getTrackFormatSupport(int i, int i2, int i3) {
            return this.formatSupport[i][i2][i3] & 3;
        }

        public int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = 0;
            int i4 = this.trackGroups[i].get(i2).length;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int trackFormatSupport = getTrackFormatSupport(i, i2, i5);
                if (trackFormatSupport == 3 || (z && trackFormatSupport == 2)) {
                    iArr[i3] = i5;
                    i3++;
                }
            }
            return getAdaptiveSupport(i, i2, Arrays.copyOf(iArr, i3));
        }

        public int getAdaptiveSupport(int i, int i2, int[] iArr) {
            boolean z;
            String str = null;
            int i3 = 0;
            boolean z2 = false;
            int i4 = 8;
            int i5 = 0;
            while (i3 < iArr.length) {
                String str2 = this.trackGroups[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    z = z2;
                } else {
                    String str3 = str;
                    z = (!Util.areEqual(str, str2)) | z2;
                    str2 = str3;
                }
                i4 = Math.min(i4, this.formatSupport[i][i2][i3] & 12);
                i3++;
                i5 = i6;
                z2 = z;
                str = str2;
            }
            if (!z2) {
                return i4;
            }
            return Math.min(i4, this.mixedMimeTypeAdaptiveSupport[i]);
        }

        public TrackGroupArray getUnassociatedTrackGroups() {
            return this.unassociatedTrackGroups;
        }

        public boolean hasOnlyUnplayableTracks(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.rendererCount; i3++) {
                if (this.rendererTrackTypes[i3] == i) {
                    i2 = Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2 == 1;
        }
    }
}
