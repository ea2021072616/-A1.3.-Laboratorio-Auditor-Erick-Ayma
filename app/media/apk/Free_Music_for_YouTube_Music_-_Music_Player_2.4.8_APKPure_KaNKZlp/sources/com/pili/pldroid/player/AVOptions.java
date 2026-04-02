package com.pili.pldroid.player;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AVOptions {
    public static final String KEY_AUDIO_DATA_CB_ENABLE = "audio-data-cb-enable";
    public static final String KEY_AUDIO_RENDER_MSG = "audio-render-msg-cb";
    public static final String KEY_BUFFER_TIME = "rtmp_buffer";
    public static final String KEY_CACHE_BUFFER_DURATION = "cache-buffer-duration";
    public static final String KEY_DELAY_OPTIMIZATION = "delay-optimization";
    public static final String KEY_FFLAGS = "fflags";
    public static final String KEY_GET_AV_FRAME_TIMEOUT = "get-av-frame-timeout";
    public static final String KEY_LIVE_STREAMING = "live-streaming";
    public static final String KEY_MAX_CACHE_BUFFER_DURATION = "max-cache-buffer-duration";
    public static final String KEY_MEDIACODEC = "mediacodec";
    public static final String KEY_PREPARE_TIMEOUT = "timeout";
    public static final String KEY_PROBESIZE = "probesize";
    public static final String KEY_RECONNECT = "reconnect";
    public static final String KEY_RTMP_LIVE = "rtmp_live";
    public static final String KEY_START_ON_PREPARED = "start-on-prepared";
    public static final String KEY_VIDEO_DATA_CB_ENABLE = "video-data-cb-enable";
    public static final String KEY_VIDEO_DISPLAY_DISABLE = "nodisp";
    public static final String KEY_VIDEO_RENDER_MSG = "video-render-msg-cb";
    public static final int MEDIA_CODEC_AUTO = 2;
    public static final int MEDIA_CODEC_HW_DECODE = 1;
    public static final int MEDIA_CODEC_SW_DECODE = 0;
    public static final String VALUE_FFLAGS_NOBUFFER = "nobuffer";
    private Map<String, Object> mMap = new HashMap();

    public final boolean containsKey(String str) {
        return this.mMap.containsKey(str);
    }

    public final int getInteger(String str) {
        return ((Integer) this.mMap.get(str)).intValue();
    }

    public final int getInteger(String str, int i) {
        try {
            return getInteger(str);
        } catch (ClassCastException e) {
            return i;
        } catch (NullPointerException e2) {
            return i;
        }
    }

    public final long getLong(String str) {
        return ((Long) this.mMap.get(str)).longValue();
    }

    public final float getFloat(String str) {
        return ((Float) this.mMap.get(str)).floatValue();
    }

    public final String getString(String str) {
        return (String) this.mMap.get(str);
    }

    public final void setInteger(String str, int i) {
        this.mMap.put(str, Integer.valueOf(i));
    }

    public final void setLong(String str, long j) {
        this.mMap.put(str, Long.valueOf(j));
    }

    public final void setFloat(String str, float f) {
        this.mMap.put(str, Float.valueOf(f));
    }

    public final void setString(String str, String str2) {
        this.mMap.put(str, str2);
    }

    public Map<String, Object> getMap() {
        return this.mMap;
    }
}
