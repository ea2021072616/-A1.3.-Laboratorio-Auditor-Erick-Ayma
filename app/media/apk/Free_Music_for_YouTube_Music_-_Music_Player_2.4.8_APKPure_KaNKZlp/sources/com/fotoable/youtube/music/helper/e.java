package com.fotoable.youtube.music.helper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
/* compiled from: RSBlur.java */
/* loaded from: classes.dex */
public class e {
    @TargetApi(18)
    public static Bitmap a(Context context, Bitmap bitmap, int i) throws RSRuntimeException {
        Allocation allocation;
        Allocation allocation2;
        RenderScript renderScript;
        ScriptIntrinsicBlur scriptIntrinsicBlur = null;
        try {
            renderScript = RenderScript.create(context);
            try {
                renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation2 = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocation = Allocation.createTyped(renderScript, allocation2.getType());
                } catch (Throwable th) {
                    th = th;
                    allocation = null;
                }
                try {
                    scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                    scriptIntrinsicBlur.setInput(allocation2);
                    scriptIntrinsicBlur.setRadius(i);
                    scriptIntrinsicBlur.forEach(allocation);
                    allocation.copyTo(bitmap);
                    if (renderScript != null) {
                        renderScript.destroy();
                    }
                    if (allocation2 != null) {
                        allocation2.destroy();
                    }
                    if (allocation != null) {
                        allocation.destroy();
                    }
                    if (scriptIntrinsicBlur != null) {
                        scriptIntrinsicBlur.destroy();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    if (renderScript != null) {
                        renderScript.destroy();
                    }
                    if (allocation2 != null) {
                        allocation2.destroy();
                    }
                    if (allocation != null) {
                        allocation.destroy();
                    }
                    if (scriptIntrinsicBlur != null) {
                        scriptIntrinsicBlur.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                allocation = null;
                allocation2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            allocation = null;
            allocation2 = null;
            renderScript = null;
        }
    }
}
