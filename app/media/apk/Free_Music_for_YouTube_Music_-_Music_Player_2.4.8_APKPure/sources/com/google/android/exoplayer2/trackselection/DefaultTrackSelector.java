package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = new int[0];
    private final TrackSelection.Factory adaptiveVideoTrackSelectionFactory;
    private final AtomicReference<Parameters> params;

    /* loaded from: classes.dex */
    public static final class Parameters {
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final boolean orientationMayChange;
        public final String preferredAudioLanguage;
        public final String preferredTextLanguage;
        public final int viewportHeight;
        public final int viewportWidth;

        public Parameters() {
            this(null, null, false, true, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true);
        }

        public Parameters(String str, String str2, boolean z, boolean z2, int i, int i2, boolean z3, int i3, int i4, boolean z4) {
            this.preferredAudioLanguage = str;
            this.preferredTextLanguage = str2;
            this.allowMixedMimeAdaptiveness = z;
            this.allowNonSeamlessAdaptiveness = z2;
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.exceedVideoConstraintsIfNecessary = z3;
            this.viewportWidth = i3;
            this.viewportHeight = i4;
            this.orientationMayChange = z4;
        }

        public Parameters withPreferredAudioLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            return TextUtils.equals(normalizeLanguageCode, this.preferredAudioLanguage) ? this : new Parameters(normalizeLanguageCode, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.exceedVideoConstraintsIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withPreferredTextLanguage(String str) {
            String normalizeLanguageCode = Util.normalizeLanguageCode(str);
            return TextUtils.equals(normalizeLanguageCode, this.preferredTextLanguage) ? this : new Parameters(this.preferredAudioLanguage, normalizeLanguageCode, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.exceedVideoConstraintsIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withAllowMixedMimeAdaptiveness(boolean z) {
            return z == this.allowMixedMimeAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, z, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.exceedVideoConstraintsIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withAllowNonSeamlessAdaptiveness(boolean z) {
            return z == this.allowNonSeamlessAdaptiveness ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, z, this.maxVideoWidth, this.maxVideoHeight, this.exceedVideoConstraintsIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withMaxVideoSize(int i, int i2) {
            return (i == this.maxVideoWidth && i2 == this.maxVideoHeight) ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, i, i2, this.exceedVideoConstraintsIfNecessary, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withMaxVideoSizeSd() {
            return withMaxVideoSize(1279, 719);
        }

        public Parameters withoutVideoSizeConstraints() {
            return withMaxVideoSize(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }

        public Parameters withExceedVideoConstraintsIfNecessary(boolean z) {
            return z == this.exceedVideoConstraintsIfNecessary ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, z, this.viewportWidth, this.viewportHeight, this.orientationMayChange);
        }

        public Parameters withViewportSize(int i, int i2, boolean z) {
            return (i == this.viewportWidth && i2 == this.viewportHeight && z == this.orientationMayChange) ? this : new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.exceedVideoConstraintsIfNecessary, i, i2, z);
        }

        public Parameters withViewportSizeFromContext(Context context, boolean z) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return withViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z);
        }

        public Parameters withoutViewportSizeConstraints() {
            return withViewportSize(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.orientationMayChange == parameters.orientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage);
        }

        public int hashCode() {
            return (((((((this.exceedVideoConstraintsIfNecessary ? 1 : 0) + (((((((this.allowNonSeamlessAdaptiveness ? 1 : 0) + (((this.allowMixedMimeAdaptiveness ? 1 : 0) + (((this.preferredAudioLanguage.hashCode() * 31) + this.preferredTextLanguage.hashCode()) * 31)) * 31)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31)) * 31) + (this.orientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }
    }

    public DefaultTrackSelector(Handler handler) {
        this(handler, null);
    }

    public DefaultTrackSelector(Handler handler, TrackSelection.Factory factory) {
        super(handler);
        this.adaptiveVideoTrackSelectionFactory = factory;
        this.params = new AtomicReference<>(new Parameters());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setParameters(Parameters parameters) {
        if (!this.params.get().equals(parameters)) {
            this.params.set(Assertions.checkNotNull(parameters));
            invalidate();
        }
    }

    public Parameters getParameters() {
        return this.params.get();
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    protected TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException {
        TrackSelection[] trackSelectionArr = new TrackSelection[rendererCapabilitiesArr.length];
        Parameters parameters = this.params.get();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rendererCapabilitiesArr.length) {
                return trackSelectionArr;
            }
            switch (rendererCapabilitiesArr[i2].getTrackType()) {
                case 1:
                    trackSelectionArr[i2] = selectAudioTrack(trackGroupArrayArr[i2], iArr[i2], parameters.preferredAudioLanguage);
                    break;
                case 2:
                    trackSelectionArr[i2] = selectVideoTrack(rendererCapabilitiesArr[i2], trackGroupArrayArr[i2], iArr[i2], parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.allowNonSeamlessAdaptiveness, parameters.allowMixedMimeAdaptiveness, parameters.viewportWidth, parameters.viewportHeight, parameters.orientationMayChange, this.adaptiveVideoTrackSelectionFactory, parameters.exceedVideoConstraintsIfNecessary);
                    break;
                case 3:
                    trackSelectionArr[i2] = selectTextTrack(trackGroupArrayArr[i2], iArr[i2], parameters.preferredTextLanguage, parameters.preferredAudioLanguage);
                    break;
                default:
                    trackSelectionArr[i2] = selectOtherTrack(rendererCapabilitiesArr[i2].getTrackType(), trackGroupArrayArr[i2], iArr[i2]);
                    break;
            }
            i = i2 + 1;
        }
    }

    protected TrackSelection selectVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, TrackSelection.Factory factory, boolean z4) throws ExoPlaybackException {
        TrackSelection trackSelection = null;
        if (factory != null) {
            trackSelection = selectAdaptiveVideoTrack(rendererCapabilities, trackGroupArray, iArr, i, i2, z, z2, i3, i4, z3, factory);
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, i, i2, i3, i4, z3, z4);
        }
        return trackSelection;
    }

    private static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i5 = z ? 12 : 8;
        boolean z4 = z2 && (rendererCapabilities.supportsMixedMimeTypeAdaptation() & i5) != 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < trackGroupArray.length) {
                TrackGroup trackGroup = trackGroupArray.get(i7);
                int[] adaptiveTracksForGroup = getAdaptiveTracksForGroup(trackGroup, iArr[i7], z4, i5, i, i2, i3, i4, z3);
                if (adaptiveTracksForGroup.length <= 0) {
                    i6 = i7 + 1;
                } else {
                    return factory.createTrackSelection(trackGroup, adaptiveTracksForGroup);
                }
            } else {
                return null;
            }
        }
    }

    private static int[] getAdaptiveTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, boolean z2) {
        String str;
        int i6;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i4, i5, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i7 = 0;
            int i8 = 0;
            while (i8 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i8).intValue()).sampleMimeType;
                if (!hashSet.contains(str3)) {
                    hashSet.add(str3);
                    i6 = getAdaptiveTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, viewportFilteredTrackIndices);
                    if (i6 > i7) {
                        i8++;
                        i7 = i6;
                        str2 = str3;
                    }
                }
                i6 = i7;
                str3 = str2;
                i8++;
                i7 = i6;
                str2 = str3;
            }
            str = str2;
        }
        filterAdaptiveTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            int intValue = list.get(i4).intValue();
            i4++;
            i5 = isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3) ? i5 + 1 : i5;
        }
        return i5;
    }

    private static void filterAdaptiveTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4) {
        return isSupported(i) && (i & i2) != 0 && (str == null || Util.areEqual(format.sampleMimeType, str)) && ((format.width == -1 || format.width <= i3) && (format.height == -1 || format.height <= i4));
    }

    private static TrackSelection selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int i5;
        int i6;
        TrackGroup trackGroup;
        boolean z4;
        TrackGroup trackGroup2 = null;
        int i7 = 0;
        int i8 = -1;
        boolean z5 = false;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= trackGroupArray.length) {
                break;
            }
            TrackGroup trackGroup3 = trackGroupArray.get(i10);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup3, i3, i4, z);
            int[] iArr2 = iArr[i10];
            int i11 = 0;
            while (i11 < trackGroup3.length) {
                if (isSupported(iArr2[i11])) {
                    Format format = trackGroup3.getFormat(i11);
                    z3 = viewportFilteredTrackIndices.contains(Integer.valueOf(i11)) && (format.width == -1 || format.width <= i) && (format.height == -1 || format.height <= i2);
                    int pixelCount = format.getPixelCount();
                    if (z5) {
                        z4 = z3 && comparePixelCounts(pixelCount, i8) > 0;
                    } else {
                        z4 = z3 || (z2 && (trackGroup2 == null || comparePixelCounts(pixelCount, i8) < 0));
                    }
                    if (z4) {
                        i6 = pixelCount;
                        trackGroup = trackGroup3;
                        i5 = i11;
                        i11++;
                        i7 = i5;
                        trackGroup2 = trackGroup;
                        i8 = i6;
                        z5 = z3;
                    }
                }
                z3 = z5;
                i5 = i7;
                i6 = i8;
                trackGroup = trackGroup2;
                i11++;
                i7 = i5;
                trackGroup2 = trackGroup;
                i8 = i6;
                z5 = z3;
            }
            i9 = i10 + 1;
        }
        if (trackGroup2 == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup2, i7);
    }

    private static int comparePixelCounts(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    protected TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, String str) {
        char c2;
        int i;
        TrackGroup trackGroup;
        char c3 = 0;
        int i2 = 0;
        TrackGroup trackGroup2 = null;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup3 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < trackGroup3.length) {
                if (isSupported(iArr2[i4])) {
                    Format format = trackGroup3.getFormat(i4);
                    boolean z = (format.selectionFlags & 1) != 0;
                    if (formatHasLanguage(format, str)) {
                        if (z) {
                            c2 = 4;
                        } else {
                            c2 = 3;
                        }
                    } else {
                        c2 = z ? (char) 2 : (char) 1;
                    }
                    if (c2 > c3) {
                        i = i4;
                        trackGroup = trackGroup3;
                        i4++;
                        trackGroup2 = trackGroup;
                        i2 = i;
                        c3 = c2;
                    }
                }
                c2 = c3;
                i = i2;
                trackGroup = trackGroup2;
                i4++;
                trackGroup2 = trackGroup;
                i2 = i;
                c3 = c2;
            }
        }
        if (trackGroup2 == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup2, i2);
    }

    protected TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, String str, String str2) {
        char c2;
        int i;
        TrackGroup trackGroup;
        TrackGroup trackGroup2 = null;
        int i2 = 0;
        char c3 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= trackGroupArray.length) {
                break;
            }
            TrackGroup trackGroup3 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            int i5 = 0;
            while (i5 < trackGroup3.length) {
                if (isSupported(iArr2[i5])) {
                    Format format = trackGroup3.getFormat(i5);
                    boolean z = (format.selectionFlags & 1) != 0;
                    boolean z2 = (format.selectionFlags & 2) != 0;
                    if (formatHasLanguage(format, str)) {
                        if (z) {
                            c2 = 6;
                        } else if (!z2) {
                            c2 = 5;
                        } else {
                            c2 = 4;
                        }
                    } else if (z) {
                        c2 = 3;
                    } else if (z2) {
                        if (formatHasLanguage(format, str2)) {
                            c2 = 2;
                        } else {
                            c2 = 1;
                        }
                    } else {
                        c2 = 0;
                    }
                    if (c2 > c3) {
                        i = i5;
                        trackGroup = trackGroup3;
                        i5++;
                        trackGroup2 = trackGroup;
                        i2 = i;
                        c3 = c2;
                    }
                }
                c2 = c3;
                i = i2;
                trackGroup = trackGroup2;
                i5++;
                trackGroup2 = trackGroup;
                i2 = i;
                c3 = c2;
            }
            i3 = i4 + 1;
        }
        if (trackGroup2 == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup2, i2);
    }

    protected TrackSelection selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr) {
        char c2;
        int i2;
        TrackGroup trackGroup;
        char c3 = 0;
        int i3 = 0;
        TrackGroup trackGroup2 = null;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup3 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            int i5 = 0;
            while (i5 < trackGroup3.length) {
                if (isSupported(iArr2[i5])) {
                    c2 = (trackGroup3.getFormat(i5).selectionFlags & 1) != 0 ? (char) 2 : (char) 1;
                    if (c2 > c3) {
                        i2 = i5;
                        trackGroup = trackGroup3;
                        i5++;
                        trackGroup2 = trackGroup;
                        i3 = i2;
                        c3 = c2;
                    }
                }
                c2 = c3;
                i2 = i3;
                trackGroup = trackGroup2;
                i5++;
                trackGroup2 = trackGroup;
                i3 = i2;
                c3 = c2;
            }
        }
        if (trackGroup2 == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup2, i3);
    }

    private static boolean isSupported(int i) {
        return (i & 3) == 3;
    }

    private static boolean formatHasLanguage(Format format, String str) {
        return str != null && str.equals(Util.normalizeLanguageCode(format.language));
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i6 = Integer.MAX_VALUE;
        while (i4 < trackGroup.length) {
            Format format = trackGroup.getFormat(i4);
            if (format.width > 0 && format.height > 0) {
                Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, format.width, format.height);
                i3 = format.width * format.height;
                if (format.width >= ((int) (maxVideoSizeInViewport.x * FRACTION_TO_CONSIDER_FULLSCREEN)) && format.height >= ((int) (maxVideoSizeInViewport.y * FRACTION_TO_CONSIDER_FULLSCREEN)) && i3 < i6) {
                    i4++;
                    i6 = i3;
                }
            }
            i3 = i6;
            i4++;
            i6 = i3;
        }
        if (i6 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                if (pixelCount == -1 || pixelCount > i6) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    private static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) != (i > i2)) {
                i = i2;
                i2 = i;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, Util.ceilDivide(i * i4, i3));
        }
        return new Point(Util.ceilDivide(i2 * i3, i4), i2);
    }
}
