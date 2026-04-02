package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ButtonIndexingLogger {
    private static final String API_ENDPOINT = "%s/button_indexing";
    private static final String TAG = ButtonIndexingLogger.class.getCanonicalName();
    private static volatile Set<String> clickedKeySet = new HashSet();
    private static volatile Set<String> loadedKeySet = new HashSet();

    private static JSONObject generateButtonDetail(View view, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] split = str.split("\\.", -1);
            int length = split.length - 1;
            View view2 = view;
            while (view2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put("index", split[length]);
                jSONObject2.put("id", view2.getId());
                jSONObject2.put(MimeTypes.BASE_TYPE_TEXT, SensitiveUserDataUtils.isSensitiveUserData(view2) ? "" : ViewHierarchy.getTextOfView(view2));
                jSONObject2.put("tag", view2.getTag() == null ? "" : String.valueOf(view2.getTag()));
                jSONObject2.put("description", view2.getContentDescription() == null ? "" : String.valueOf(view2.getContentDescription()));
                jSONArray.put(jSONObject2);
                view2 = ViewHierarchy.getParentOfView(view2);
                length--;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                jSONArray2.put(jSONArray.get(length2));
            }
            jSONObject.put("path", jSONArray2);
            jSONObject.put("is_from_click", z);
            if (view instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put(MessengerShareContentUtility.MEDIA_IMAGE, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
            return jSONObject;
        } catch (Exception e) {
            Log.e(TAG, "Log button indexing error", e);
            return new JSONObject();
        }
    }

    private static void sendGraphAPIRequest(Context context, String str, String str2) {
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            String appVersion = AppEventUtility.getAppVersion();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("app_version", appVersion);
                bundle.putString("indexed_button_list", str);
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, API_ENDPOINT, str2), null, null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (Exception e) {
                Log.e(TAG, "failed to send button indexing request", e);
            }
        }
    }

    public static void logIndexing(String str, View view, String str2, Context context) {
        if (!clickedKeySet.contains(str2)) {
            clickedKeySet.add(str2);
            JSONObject generateButtonDetail = generateButtonDetail(view, str2, true);
            if (generateButtonDetail.length() > 0) {
                sendGraphAPIRequest(context, new JSONArray((Collection) Arrays.asList(generateButtonDetail.toString())).toString(), str);
            }
        }
    }

    public static void logAllIndexing(final JSONObject jSONObject, final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.marketing.internal.ButtonIndexingLogger.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String applicationId = FacebookSdk.getApplicationId();
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    jSONObject2.put("screenname", str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONObject2.put("view", jSONArray);
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(jSONObject2.toString(), currentAccessToken, applicationId, Constants.BUTTON_SAMPLING);
                    if (buildAppIndexingRequest != null) {
                        buildAppIndexingRequest.executeAndWait();
                    }
                } catch (JSONException e) {
                    Utility.logd(ButtonIndexingLogger.TAG, e);
                }
            }
        });
    }
}
