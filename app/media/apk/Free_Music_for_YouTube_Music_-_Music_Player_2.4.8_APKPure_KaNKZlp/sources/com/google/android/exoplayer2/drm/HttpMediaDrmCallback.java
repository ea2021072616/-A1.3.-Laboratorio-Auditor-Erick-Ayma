package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@TargetApi(18)
/* loaded from: classes.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final Map<String, String> PLAYREADY_KEY_REQUEST_PROPERTIES = new HashMap();
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultUrl;
    private final Map<String, String> keyRequestProperties;

    static {
        PLAYREADY_KEY_REQUEST_PROPERTIES.put("Content-Type", "text/xml");
        PLAYREADY_KEY_REQUEST_PROPERTIES.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
    }

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, factory, null);
    }

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory, Map<String, String> map) {
        this.dataSourceFactory = factory;
        this.defaultUrl = str;
        this.keyRequestProperties = map;
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        return executePost(provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData()), new byte[0], null);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception {
        String defaultUrl = keyRequest.getDefaultUrl();
        if (TextUtils.isEmpty(defaultUrl)) {
            defaultUrl = this.defaultUrl;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream");
        if (C.PLAYREADY_UUID.equals(uuid)) {
            hashMap.putAll(PLAYREADY_KEY_REQUEST_PROPERTIES);
        }
        if (this.keyRequestProperties != null) {
            hashMap.putAll(this.keyRequestProperties);
        }
        return executePost(defaultUrl, keyRequest.getData(), hashMap);
    }

    private byte[] executePost(String str, byte[] bArr, Map<String, String> map) throws IOException {
        HttpDataSource createDataSource = this.dataSourceFactory.createDataSource();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                createDataSource.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec(Uri.parse(str), bArr, 0L, 0L, -1L, null, 1));
        try {
            return Util.toByteArray(dataSourceInputStream);
        } finally {
            dataSourceInputStream.close();
        }
    }
}
