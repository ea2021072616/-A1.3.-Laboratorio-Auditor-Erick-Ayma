package com.google.android.exoplayer2.trackselection;

import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public abstract class TrackSelector<T> {
    private TrackSelections<T> activeSelections;
    private final Handler eventHandler;
    private InvalidationListener listener;
    private final CopyOnWriteArraySet<EventListener<? super T>> listeners = new CopyOnWriteArraySet<>();

    /* loaded from: classes.dex */
    public interface EventListener<T> {
        void onTrackSelectionsChanged(TrackSelections<? extends T> trackSelections);
    }

    /* loaded from: classes.dex */
    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public abstract TrackSelections<T> selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException;

    public TrackSelector(Handler handler) {
        this.eventHandler = (Handler) Assertions.checkNotNull(handler);
    }

    public final void addListener(EventListener<? super T> eventListener) {
        this.listeners.add(eventListener);
    }

    public final void removeListener(EventListener<? super T> eventListener) {
        this.listeners.remove(eventListener);
    }

    public final TrackSelections<T> getCurrentSelections() {
        return this.activeSelections;
    }

    public final void init(InvalidationListener invalidationListener) {
        this.listener = invalidationListener;
    }

    public final void onSelectionActivated(TrackSelections<T> trackSelections) {
        this.activeSelections = trackSelections;
        notifyTrackSelectionsChanged(trackSelections);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidate() {
        if (this.listener != null) {
            this.listener.onTrackSelectionsInvalidated();
        }
    }

    private void notifyTrackSelectionsChanged(final TrackSelections<T> trackSelections) {
        if (this.eventHandler != null) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.trackselection.TrackSelector.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = TrackSelector.this.listeners.iterator();
                    while (it.hasNext()) {
                        ((EventListener) it.next()).onTrackSelectionsChanged(trackSelections);
                    }
                }
            });
        }
    }
}
