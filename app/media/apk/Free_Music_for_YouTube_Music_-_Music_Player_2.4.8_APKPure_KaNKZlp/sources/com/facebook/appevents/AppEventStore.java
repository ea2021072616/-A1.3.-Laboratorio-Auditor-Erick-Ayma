package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[Catch: all -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #10 {, blocks: (B:4:0x0004, B:7:0x0021, B:8:0x0024, B:10:0x002f, B:14:0x0037, B:36:0x007e, B:37:0x0081, B:38:0x008a, B:40:0x008c, B:30:0x0065, B:31:0x0068, B:34:0x0074, B:21:0x0044, B:22:0x0047, B:25:0x0053), top: B:49:0x0004, inners: #2, #6, #7, #9 }] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            r2 = 0
            java.lang.Class<com.facebook.appevents.AppEventStore> r3 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r3)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> L3f
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r0 = r4.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L42 java.lang.Exception -> L5c java.lang.Throwable -> L7d
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r1 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch: java.io.FileNotFoundException -> L42 java.lang.Exception -> L5c java.lang.Throwable -> L7d
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.io.FileNotFoundException -> L42 java.lang.Exception -> L5c java.lang.Throwable -> L7d
            r5.<init>(r0)     // Catch: java.io.FileNotFoundException -> L42 java.lang.Exception -> L5c java.lang.Throwable -> L7d
            r1.<init>(r5)     // Catch: java.io.FileNotFoundException -> L42 java.lang.Exception -> L5c java.lang.Throwable -> L7d
            java.lang.Object r0 = r1.readObject()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97 java.io.FileNotFoundException -> L99
            com.facebook.appevents.PersistedEvents r0 = (com.facebook.appevents.PersistedEvents) r0     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L97 java.io.FileNotFoundException -> L99
            com.facebook.internal.Utility.closeQuietly(r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r4.getFileStreamPath(r1)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L3f
            r1.delete()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L3f
        L2d:
            if (r0 != 0) goto L34
            com.facebook.appevents.PersistedEvents r0 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L3f
            r0.<init>()     // Catch: java.lang.Throwable -> L3f
        L34:
            monitor-exit(r3)
            return r0
        L36:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L3f
            goto L2d
        L3f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L42:
            r0 = move-exception
            r0 = r2
        L44:
            com.facebook.internal.Utility.closeQuietly(r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.io.File r0 = r4.getFileStreamPath(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L52
            r0.delete()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L52
            r0 = r2
            goto L2d
        L52:
            r0 = move-exception
            java.lang.String r1 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r1, r4, r0)     // Catch: java.lang.Throwable -> L3f
            r0 = r2
            goto L2d
        L5c:
            r0 = move-exception
            r1 = r2
        L5e:
            java.lang.String r5 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L94
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r0)     // Catch: java.lang.Throwable -> L94
            com.facebook.internal.Utility.closeQuietly(r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.io.File r0 = r4.getFileStreamPath(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L73
            r0.delete()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L73
            r0 = r2
            goto L2d
        L73:
            r0 = move-exception
            java.lang.String r1 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r1, r4, r0)     // Catch: java.lang.Throwable -> L3f
            r0 = r2
            goto L2d
        L7d:
            r0 = move-exception
        L7e:
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r4.getFileStreamPath(r1)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L8b
            r1.delete()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L8b
        L8a:
            throw r0     // Catch: java.lang.Throwable -> L3f
        L8b:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventStore.TAG     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L3f
            goto L8a
        L94:
            r0 = move-exception
            r2 = r1
            goto L7e
        L97:
            r0 = move-exception
            goto L5e
        L99:
            r0 = move-exception
            r0 = r1
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    private static void saveEventsToDisk(PersistedEvents persistedEvents) {
        ObjectOutputStream objectOutputStream;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                try {
                    objectOutputStream.writeObject(persistedEvents);
                    Utility.closeQuietly(objectOutputStream);
                } catch (Exception e) {
                    e = e;
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e2) {
                    }
                    Utility.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = null;
            Utility.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            if (readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
            }
            return readClassDescriptor;
        }
    }
}
