package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes.dex */
public final class ChunkedTrackBlacklistUtil {
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private static final String TAG = "ChunkedTrackBlacklist";

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i, exc, 60000L);
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i, Exception exc, long j) {
        int i2;
        boolean z = false;
        if (trackSelection.length() != 1 && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode) == 404 || i2 == 410)) {
            z = trackSelection.blacklist(i, j);
            if (z) {
                Log.w(TAG, "Blacklisted: duration=" + j + ", responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
            } else {
                Log.w(TAG, "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i2 + ", format=" + trackSelection.getFormat(i));
            }
        }
        return z;
    }

    private ChunkedTrackBlacklistUtil() {
    }
}
