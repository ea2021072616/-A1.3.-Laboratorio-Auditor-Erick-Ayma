package com.fotoable.youtube.music.util;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;
import com.fotoable.free.music.R;
/* compiled from: RingUtils.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4900a = q.class.getSimpleName();

    public static void a(Context context, String str) {
        Uri contentUriForPath = MediaStore.Audio.Media.getContentUriForPath(str);
        Cursor query = context.getContentResolver().query(contentUriForPath, null, "_data=?", new String[]{str}, null);
        if (query == null) {
            Toast.makeText(context, (int) R.string.set_ring_failed_msg, 0).show();
            return;
        }
        if (query.moveToFirst() && query.getCount() > 0) {
            String string = query.getString(0);
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_music", (Boolean) true);
            contentValues.put("is_ringtone", (Boolean) true);
            contentValues.put("is_alarm", (Boolean) false);
            contentValues.put("is_notification", (Boolean) false);
            contentValues.put("is_podcast", (Boolean) false);
            context.getContentResolver().update(contentUriForPath, contentValues, "_data=?", new String[]{str});
            RingtoneManager.setActualDefaultRingtoneUri(context, 1, ContentUris.withAppendedId(contentUriForPath, Long.valueOf(string).longValue()));
            Toast.makeText(context, (int) R.string.set_ring_success_msg, 0).show();
        } else {
            Toast.makeText(context, (int) R.string.set_ring_failed_msg, 0).show();
        }
        if (query != null) {
            query.close();
        }
    }
}
