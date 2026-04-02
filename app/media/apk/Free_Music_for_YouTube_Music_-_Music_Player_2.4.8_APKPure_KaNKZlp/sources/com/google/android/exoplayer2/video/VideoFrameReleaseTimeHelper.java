package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;
@TargetApi(16)
/* loaded from: classes.dex */
public final class VideoFrameReleaseTimeHelper {
    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    private static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private long adjustedLastFrameTimeNs;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private final boolean useDefaultDisplayVsync;
    private final long vsyncDurationNs;
    private final long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;

    public VideoFrameReleaseTimeHelper() {
        this(-1.0d, false);
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        this(getDefaultDisplayRefreshRate(context), true);
    }

    private VideoFrameReleaseTimeHelper(double d, boolean z) {
        this.useDefaultDisplayVsync = z;
        if (z) {
            this.vsyncSampler = VSyncSampler.getInstance();
            this.vsyncDurationNs = (long) (1.0E9d / d);
            this.vsyncOffsetNs = (this.vsyncDurationNs * VSYNC_OFFSET_PERCENTAGE) / 100;
            return;
        }
        this.vsyncSampler = null;
        this.vsyncDurationNs = -1L;
        this.vsyncOffsetNs = -1L;
    }

    public void enable() {
        this.haveSync = false;
        if (this.useDefaultDisplayVsync) {
            this.vsyncSampler.addObserver();
        }
    }

    public void disable() {
        if (this.useDefaultDisplayVsync) {
            this.vsyncSampler.removeObserver();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long adjustReleaseTime(long r12, long r14) {
        /*
            r11 = this;
            r8 = 0
            r6 = 0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r4 = r12 * r0
            boolean r0 = r11.haveSync
            if (r0 == 0) goto L68
            long r0 = r11.lastFramePresentationTimeUs
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 == 0) goto L1c
            long r0 = r11.frameCount
            r2 = 1
            long r0 = r0 + r2
            r11.frameCount = r0
            long r0 = r11.pendingAdjustedFrameTimeNs
            r11.adjustedLastFrameTimeNs = r0
        L1c:
            long r0 = r11.frameCount
            r2 = 6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L60
            long r0 = r11.syncFramePresentationTimeNs
            long r0 = r4 - r0
            long r2 = r11.frameCount
            long r0 = r0 / r2
            long r2 = r11.adjustedLastFrameTimeNs
            long r2 = r2 + r0
            boolean r0 = r11.isDriftTooLarge(r2, r14)
            if (r0 == 0) goto L59
            r11.haveSync = r6
            r0 = r14
            r2 = r4
        L38:
            boolean r6 = r11.haveSync
            if (r6 != 0) goto L48
            r11.syncFramePresentationTimeNs = r4
            r11.syncUnadjustedReleaseTimeNs = r14
            r11.frameCount = r8
            r4 = 1
            r11.haveSync = r4
            r11.onSynced()
        L48:
            r11.lastFramePresentationTimeUs = r12
            r11.pendingAdjustedFrameTimeNs = r2
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper$VSyncSampler r2 = r11.vsyncSampler
            if (r2 == 0) goto L58
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper$VSyncSampler r2 = r11.vsyncSampler
            long r2 = r2.sampledVsyncTimeNs
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L6b
        L58:
            return r0
        L59:
            long r0 = r11.syncUnadjustedReleaseTimeNs
            long r0 = r0 + r2
            long r6 = r11.syncFramePresentationTimeNs
            long r0 = r0 - r6
            goto L38
        L60:
            boolean r0 = r11.isDriftTooLarge(r4, r14)
            if (r0 == 0) goto L68
            r11.haveSync = r6
        L68:
            r0 = r14
            r2 = r4
            goto L38
        L6b:
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper$VSyncSampler r2 = r11.vsyncSampler
            long r2 = r2.sampledVsyncTimeNs
            long r4 = r11.vsyncDurationNs
            long r0 = closestVsync(r0, r2, r4)
            long r2 = r11.vsyncOffsetNs
            long r0 = r0 - r2
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.adjustReleaseTime(long, long):long");
    }

    protected void onSynced() {
    }

    private boolean isDriftTooLarge(long j, long j2) {
        return Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS;
    }

    private static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private static float getDefaultDisplayRefreshRate(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    /* loaded from: classes.dex */
    private static final class VSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread = new HandlerThread("ChoreographerOwner:Handler");
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs;

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            this.choreographerOwnerThread.start();
            this.handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            this.choreographer.postFrameCallbackDelayed(this, VideoFrameReleaseTimeHelper.CHOREOGRAPHER_SAMPLE_DELAY_MILLIS);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    createChoreographerInstanceInternal();
                    return true;
                case 1:
                    addObserverInternal();
                    return true;
                case 2:
                    removeObserverInternal();
                    return true;
                default:
                    return false;
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        private void addObserverInternal() {
            this.observerCount++;
            if (this.observerCount == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            this.observerCount--;
            if (this.observerCount == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = 0L;
            }
        }
    }
}
