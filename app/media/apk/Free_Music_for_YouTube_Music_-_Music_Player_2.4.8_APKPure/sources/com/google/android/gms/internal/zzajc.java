package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@zzzt
/* loaded from: classes.dex */
public final class zzajc {
    private static List<MediaCodecInfo> zzddx;
    private static Map<String, List<Map<String, Object>>> zzddw = new HashMap();
    private static final Object zzddy = new Object();

    @TargetApi(21)
    private static Integer[] zza(Range<Integer> range) {
        return new Integer[]{range.getLower(), range.getUpper()};
    }

    @TargetApi(16)
    public static List<Map<String, Object>> zzcp(String str) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        synchronized (zzddy) {
            if (zzddw.containsKey(str)) {
                return zzddw.get(str);
            }
            try {
                synchronized (zzddy) {
                    if (zzddx == null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            zzddx = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else if (Build.VERSION.SDK_INT >= 16) {
                            int codecCount = MediaCodecList.getCodecCount();
                            zzddx = new ArrayList(codecCount);
                            for (int i = 0; i < codecCount; i++) {
                                zzddx.add(MediaCodecList.getCodecInfoAt(i));
                            }
                        } else {
                            zzddx = Collections.emptyList();
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : zzddx) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("codecName", mediaCodecInfo.getName());
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        hashMap.put("profileLevels", arrayList2);
                        if (Build.VERSION.SDK_INT >= 21) {
                            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            hashMap.put("bitRatesBps", zza(videoCapabilities.getBitrateRange()));
                            hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                            hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                            hashMap.put("frameRates", zza(videoCapabilities.getSupportedFrameRates()));
                            hashMap.put("widths", zza(videoCapabilities.getSupportedWidths()));
                            hashMap.put("heights", zza(videoCapabilities.getSupportedHeights()));
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        }
                        arrayList.add(hashMap);
                    }
                }
                zzddw.put(str, arrayList);
                return arrayList;
            } catch (LinkageError e) {
                e = e;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", e.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(hashMap2);
                zzddw.put(str, arrayList3);
                return arrayList3;
            } catch (RuntimeException e2) {
                e = e2;
                HashMap hashMap22 = new HashMap();
                hashMap22.put("error", e.getClass().getSimpleName());
                ArrayList arrayList32 = new ArrayList();
                arrayList32.add(hashMap22);
                zzddw.put(str, arrayList32);
                return arrayList32;
            }
        }
    }
}
