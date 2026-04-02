package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public android.graphics.Typeface createFromFontInfo(android.content.Context r8, android.os.CancellationSignal r9, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r10, int r11) {
        /*
            r7 = this;
            r0 = 0
            int r1 = r10.length
            r2 = 1
            if (r1 >= r2) goto L6
        L5:
            return r0
        L6:
            android.support.v4.provider.FontsContractCompat$FontInfo r1 = r7.findBestInfo(r10, r11)
            android.content.ContentResolver r2 = r8.getContentResolver()
            android.net.Uri r1 = r1.getUri()     // Catch: java.io.IOException -> L56
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r3 = r2.openFileDescriptor(r1, r3, r9)     // Catch: java.io.IOException -> L56
            r2 = 0
            java.io.File r1 = r7.getFile(r3)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L25
            boolean r4 = r1.canRead()     // Catch: java.lang.Throwable -> L48
            if (r4 != 0) goto L7c
        L25:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48
            java.io.FileDescriptor r1 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L48
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L48
            r5 = 0
            android.graphics.Typeface r1 = super.createFromInputStream(r8, r4)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L3a
            if (r0 == 0) goto L58
            r4.close()     // Catch: java.lang.Throwable -> L43
        L3a:
            if (r3 == 0) goto L41
            if (r0 == 0) goto L64
            r3.close()     // Catch: java.lang.Throwable -> L5f
        L41:
            r0 = r1
            goto L5
        L43:
            r4 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r5, r4)     // Catch: java.lang.Throwable -> L48
            goto L3a
        L48:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L4a
        L4a:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L4e:
            if (r3 == 0) goto L55
            if (r2 == 0) goto L98
            r3.close()     // Catch: java.lang.Throwable -> L93
        L55:
            throw r1     // Catch: java.io.IOException -> L56
        L56:
            r1 = move-exception
            goto L5
        L58:
            r4.close()     // Catch: java.lang.Throwable -> L48
            goto L3a
        L5c:
            r1 = move-exception
            r2 = r0
            goto L4e
        L5f:
            r3 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r2, r3)     // Catch: java.io.IOException -> L56
            goto L41
        L64:
            r3.close()     // Catch: java.io.IOException -> L56
            goto L41
        L68:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L6a
        L6a:
            r1 = move-exception
        L6b:
            if (r4 == 0) goto L72
            if (r2 == 0) goto L78
            r4.close()     // Catch: java.lang.Throwable -> L73
        L72:
            throw r1     // Catch: java.lang.Throwable -> L48
        L73:
            r4 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r2, r4)     // Catch: java.lang.Throwable -> L48
            goto L72
        L78:
            r4.close()     // Catch: java.lang.Throwable -> L48
            goto L72
        L7c:
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r1)     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L87
            if (r0 == 0) goto L8f
            r3.close()     // Catch: java.lang.Throwable -> L8a
        L87:
            r0 = r1
            goto L5
        L8a:
            r3 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r2, r3)     // Catch: java.io.IOException -> L56
            goto L87
        L8f:
            r3.close()     // Catch: java.io.IOException -> L56
            goto L87
        L93:
            r3 = move-exception
            com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r2, r3)     // Catch: java.io.IOException -> L56
            goto L55
        L98:
            r3.close()     // Catch: java.io.IOException -> L56
            goto L55
        L9c:
            r1 = move-exception
            r2 = r0
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
