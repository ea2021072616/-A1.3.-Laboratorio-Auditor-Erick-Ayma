package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.cues = list;
        this.numCues = list.size();
        this.cueTimesUs = new long[this.numCues * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.numCues) {
                WebvttCue webvttCue = list.get(i2);
                int i3 = i2 * 2;
                this.cueTimesUs[i3] = webvttCue.startTime;
                this.cueTimesUs[i3 + 1] = webvttCue.endTime;
                i = i2 + 1;
            } else {
                this.sortedCueTimesUs = Arrays.copyOf(this.cueTimesUs, this.cueTimesUs.length);
                Arrays.sort(this.sortedCueTimesUs);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j, false, false);
        if (binarySearchCeil < this.sortedCueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        WebvttCue webvttCue;
        ArrayList arrayList;
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = null;
        int i = 0;
        WebvttCue webvttCue2 = null;
        ArrayList arrayList2 = null;
        while (i < this.numCues) {
            if (this.cueTimesUs[i * 2] > j || j >= this.cueTimesUs[(i * 2) + 1]) {
                SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                webvttCue = webvttCue2;
                arrayList = arrayList2;
                spannableStringBuilder = spannableStringBuilder3;
            } else {
                ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                WebvttCue webvttCue3 = this.cues.get(i);
                if (webvttCue3.isNormalCue()) {
                    if (webvttCue2 == null) {
                        arrayList = arrayList3;
                        spannableStringBuilder = spannableStringBuilder2;
                        webvttCue = webvttCue3;
                    } else if (spannableStringBuilder2 == null) {
                        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder();
                        spannableStringBuilder4.append(webvttCue2.text).append((CharSequence) "\n").append(webvttCue3.text);
                        spannableStringBuilder = spannableStringBuilder4;
                        webvttCue = webvttCue2;
                        arrayList = arrayList3;
                    } else {
                        spannableStringBuilder2.append((CharSequence) "\n").append(webvttCue3.text);
                        spannableStringBuilder = spannableStringBuilder2;
                        webvttCue = webvttCue2;
                        arrayList = arrayList3;
                    }
                } else {
                    arrayList3.add(webvttCue3);
                    spannableStringBuilder = spannableStringBuilder2;
                    webvttCue = webvttCue2;
                    arrayList = arrayList3;
                }
            }
            i++;
            SpannableStringBuilder spannableStringBuilder5 = spannableStringBuilder;
            arrayList2 = arrayList;
            webvttCue2 = webvttCue;
            spannableStringBuilder2 = spannableStringBuilder5;
        }
        if (spannableStringBuilder2 != null) {
            arrayList2.add(new WebvttCue(spannableStringBuilder2));
        } else if (webvttCue2 != null) {
            arrayList2.add(webvttCue2);
        }
        return arrayList2 != null ? arrayList2 : Collections.emptyList();
    }
}
