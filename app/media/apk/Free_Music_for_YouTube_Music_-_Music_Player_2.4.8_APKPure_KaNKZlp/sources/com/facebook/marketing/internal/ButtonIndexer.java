package com.facebook.marketing.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ButtonIndexer {
    private static final String TAG = ButtonIndexer.class.getCanonicalName();
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private Set<Activity> activitiesSet = new HashSet();
    private Set<ViewProcessor> viewProcessors = new HashSet();
    private HashSet<String> delegateSet = new HashSet<>();

    public void add(Activity activity) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't add activity to ButtonIndexer on non-UI thread");
        }
        this.activitiesSet.add(activity);
        this.delegateSet.clear();
        startTracking();
    }

    public void remove(Activity activity) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't remove activity from ButtonIndexer on non-UI thread");
        }
        this.activitiesSet.remove(activity);
        this.viewProcessors.clear();
        this.delegateSet.clear();
    }

    private void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            processViews();
        } else {
            this.uiThreadHandler.post(new Runnable() { // from class: com.facebook.marketing.internal.ButtonIndexer.1
                @Override // java.lang.Runnable
                public void run() {
                    ButtonIndexer.this.processViews();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processViews() {
        for (Activity activity : this.activitiesSet) {
            this.viewProcessors.add(new ViewProcessor(activity.getWindow().getDecorView().getRootView(), activity.getClass().getSimpleName(), this.delegateSet, this.uiThreadHandler));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class ViewProcessor implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        private final String activityName;
        private HashSet<String> delegateSet;
        private final Handler handler;
        private WeakReference<View> rootView;
        public static volatile Set<String> loadedKeySet = new HashSet();
        private static volatile float displayDensity = -1.0f;
        private final String viewPlaceholder = "{\"classname\": \"placeholder\", \"id\": 1}";
        private HashMap<String, WeakReference<View>> viewMap = new HashMap<>();

        public ViewProcessor(View view, String str, HashSet<String> hashSet, Handler handler) {
            this.rootView = new WeakReference<>(view);
            this.handler = handler;
            this.activityName = str;
            this.delegateSet = hashSet;
            if (displayDensity < 0.0f) {
                displayDensity = view.getContext().getResources().getDisplayMetrics().density;
            }
            this.handler.postDelayed(this, 200L);
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteConfig remoteConfigWithoutQuery = RemoteConfigManager.getRemoteConfigWithoutQuery(FacebookSdk.getApplicationId());
            if (remoteConfigWithoutQuery != null && remoteConfigWithoutQuery.getEnableButtonIndexing()) {
                process();
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            process();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            process();
        }

        private void process() {
            View view = this.rootView.get();
            if (view != null) {
                attachListeners(view);
            }
        }

        public void attachListeners(View view) {
            JSONObject clickableElementsOfView = getClickableElementsOfView(view, -1, this.activityName, false);
            if (clickableElementsOfView != null) {
                ButtonIndexingLogger.logAllIndexing(clickableElementsOfView, this.activityName);
            }
            for (Map.Entry<String, WeakReference<View>> entry : this.viewMap.entrySet()) {
                attachListener(entry.getValue().get(), entry.getKey());
            }
        }

        @Nullable
        public JSONObject getClickableElementsOfView(View view, int i, String str, boolean z) {
            boolean z2;
            int i2;
            String str2 = str + "." + String.valueOf(i);
            if (view == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                z2 = ViewHierarchy.isClickableView(view) || (view instanceof Button);
                if (z2) {
                    this.viewMap.put(str2, new WeakReference<>(view));
                }
            } catch (JSONException e) {
                Utility.logd(ButtonIndexer.TAG, e);
            }
            if (((view instanceof TextView) || (view instanceof ImageView)) && (z || z2)) {
                if (loadedKeySet.contains(str2)) {
                    return null;
                }
                loadedKeySet.add(str2);
                return ViewHierarchy.setAppearanceOfView(view, ViewHierarchy.setBasicInfoOfView(view, jSONObject), displayDensity);
            }
            JSONArray jSONArray = new JSONArray();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i4 < childCount) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i2 = i3 + 1;
                        JSONObject clickableElementsOfView = getClickableElementsOfView(childAt, i3, str2, z || z2);
                        if (clickableElementsOfView != null) {
                            jSONArray.put(clickableElementsOfView);
                        } else {
                            getClass();
                            jSONArray.put(new JSONObject("{\"classname\": \"placeholder\", \"id\": 1}"));
                        }
                    } else {
                        i2 = i3;
                    }
                    i4++;
                    i3 = i2;
                }
            }
            if (jSONArray.length() > 0) {
                JSONObject basicInfoOfView = ViewHierarchy.setBasicInfoOfView(view, jSONObject);
                basicInfoOfView.put("childviews", jSONArray);
                return basicInfoOfView;
            }
            return null;
        }

        private void attachListener(View view, String str) {
            if (view != null) {
                try {
                    View.AccessibilityDelegate existingDelegate = ViewHierarchy.getExistingDelegate(view);
                    boolean z = existingDelegate != null;
                    boolean z2 = z && (existingDelegate instanceof CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate);
                    boolean z3 = z2 && ((CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate) existingDelegate).getSupportButtonIndexing();
                    if (this.delegateSet.contains(str)) {
                        return;
                    }
                    if (!z || !z2 || !z3) {
                        view.setAccessibilityDelegate(ButtonIndexingEventListener.getAccessibilityDelegate(view, str));
                        this.delegateSet.add(str);
                    }
                } catch (FacebookException e) {
                    Log.e(ButtonIndexer.TAG, "Failed to attach auto logging event listener.", e);
                }
            }
        }
    }
}
