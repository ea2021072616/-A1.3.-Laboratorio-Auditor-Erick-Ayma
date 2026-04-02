package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: classes.dex */
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        Uri createFile = createFile(this.mContext, this.mUri, str, str2);
        if (createFile != null) {
            return new TreeDocumentFile(this, this.mContext, createFile);
        }
        return null;
    }

    private static Uri createFile(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        Uri createFile = createFile(this.mContext, this.mUri, "vnd.android.document/directory", str);
        if (createFile != null) {
            return new TreeDocumentFile(this, this.mContext, createFile);
        }
        return null;
    }

    @Override // android.support.v4.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[LOOP:1: B:12:0x0069->B:14:0x006c, LOOP_END] */
    @Override // android.support.v4.provider.DocumentFile
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.support.v4.provider.DocumentFile[] listFiles() {
        /*
            r9 = this;
            r6 = 0
            r7 = 0
            android.content.Context r0 = r9.mContext
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = r9.mUri
            android.net.Uri r2 = r9.mUri
            java.lang.String r2 = android.provider.DocumentsContract.getDocumentId(r2)
            android.net.Uri r1 = android.provider.DocumentsContract.buildChildDocumentsUriUsingTree(r1, r2)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L87
            r3 = 0
            java.lang.String r4 = "document_id"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L87
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L87
        L28:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L85
            if (r0 == 0) goto L7a
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L85
            android.net.Uri r2 = r9.mUri     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L85
            android.net.Uri r0 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r2, r0)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L85
            r8.add(r0)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L85
            goto L28
        L3d:
            r0 = move-exception
        L3e:
            java.lang.String r2 = "DocumentFile"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r3.<init>()     // Catch: java.lang.Throwable -> L85
            java.lang.String r4 = "Failed query: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L85
            android.util.Log.w(r2, r0)     // Catch: java.lang.Throwable -> L85
            closeQuietly(r1)
        L59:
            int r0 = r8.size()
            android.net.Uri[] r0 = new android.net.Uri[r0]
            java.lang.Object[] r0 = r8.toArray(r0)
            android.net.Uri[] r0 = (android.net.Uri[]) r0
            int r1 = r0.length
            android.support.v4.provider.DocumentFile[] r2 = new android.support.v4.provider.DocumentFile[r1]
            r1 = r6
        L69:
            int r3 = r0.length
            if (r1 >= r3) goto L84
            android.support.v4.provider.TreeDocumentFile r3 = new android.support.v4.provider.TreeDocumentFile
            android.content.Context r4 = r9.mContext
            r5 = r0[r1]
            r3.<init>(r9, r4, r5)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L69
        L7a:
            closeQuietly(r1)
            goto L59
        L7e:
            r0 = move-exception
            r1 = r7
        L80:
            closeQuietly(r1)
            throw r0
        L84:
            return r2
        L85:
            r0 = move-exception
            goto L80
        L87:
            r0 = move-exception
            r1 = r7
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.TreeDocumentFile.listFiles():android.support.v4.provider.DocumentFile[]");
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, str);
            if (renameDocument != null) {
                this.mUri = renameDocument;
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
