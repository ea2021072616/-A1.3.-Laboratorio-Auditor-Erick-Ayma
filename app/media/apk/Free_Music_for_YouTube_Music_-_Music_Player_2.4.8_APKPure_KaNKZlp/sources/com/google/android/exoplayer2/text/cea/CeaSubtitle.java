package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class CeaSubtitle implements Subtitle {
    private final List<Cue> cues;

    public CeaSubtitle(Cue cue) {
        if (cue == null) {
            this.cues = Collections.emptyList();
        } else {
            this.cues = Collections.singletonList(cue);
        }
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        return this.cues;
    }
}
