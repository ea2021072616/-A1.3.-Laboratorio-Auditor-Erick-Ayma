package com.fotoable.youtube.music.newplayer;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.newplayer.model.SystemMusicData;
import com.fotoable.youtube.music.newplayer.receiver.MediaButtonIntentReceiver;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: SystemMusicDataHelper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f3006a = new g();

    /* renamed from: b  reason: collision with root package name */
    private Context f3007b;

    /* renamed from: c  reason: collision with root package name */
    private MediaSessionCompat f3008c;

    public static g a() {
        return f3006a;
    }

    private g() {
    }

    public void a(Context context) {
        this.f3007b = context;
        c();
    }

    private void c() {
        try {
            if (this.f3007b == null) {
                this.f3007b = MusicApplication.c();
            }
            if (this.f3007b != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f3008c = new MediaSessionCompat(this.f3007b, "Free Music");
                    this.f3008c.setCallback(new MediaSessionCompat.Callback() { // from class: com.fotoable.youtube.music.newplayer.g.1
                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onPause() {
                            f.a().c(false);
                        }

                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onPlay() {
                            f.a().b(false);
                        }

                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onSeekTo(long j) {
                            f.a().f((int) j);
                        }

                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onSkipToNext() {
                            f.a().e(false);
                        }

                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onSkipToPrevious() {
                            f.a().d(false);
                        }

                        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                        public void onStop() {
                            f.a().c(false);
                        }
                    });
                    this.f3008c.setFlags(1);
                    this.f3008c.setActive(true);
                    return;
                }
                this.f3008c = new MediaSessionCompat(this.f3007b, "Free Music", new ComponentName(this.f3007b.getPackageName(), MediaButtonIntentReceiver.class.getName()), null);
                this.f3008c.setFlags(1);
                this.f3008c.setActive(true);
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(boolean z, long j) {
        if (this.f3008c != null && Build.VERSION.SDK_INT >= 21) {
            this.f3008c.setPlaybackState(new PlaybackStateCompat.Builder().setState(z ? 3 : 2, j, 1.0f).setActions(566L).build());
        }
    }

    public void a(boolean z, long j, SystemMusicData systemMusicData) {
        if (this.f3008c != null && Build.VERSION.SDK_INT >= 21) {
            this.f3008c.setMetadata(new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_ARTIST, systemMusicData.getArtist()).putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, systemMusicData.getAlbumArtist()).putString(MediaMetadataCompat.METADATA_KEY_ALBUM, systemMusicData.getAlbum()).putString(MediaMetadataCompat.METADATA_KEY_TITLE, systemMusicData.getTitle()).putLong(MediaMetadataCompat.METADATA_KEY_DURATION, systemMusicData.getDuration()).putLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER, systemMusicData.getTrackNumber() + 1).putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, systemMusicData.getNumTracks()).putString(MediaMetadataCompat.METADATA_KEY_GENRE, systemMusicData.getGenre()).putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, systemMusicData.getAlbumArt()).build());
            this.f3008c.setPlaybackState(new PlaybackStateCompat.Builder().setState(z ? 3 : 2, j, 1.0f).setActions(566L).build());
        }
    }

    public void b() {
        if (this.f3008c != null) {
            this.f3008c.setActive(false);
            this.f3008c.release();
        }
    }
}
