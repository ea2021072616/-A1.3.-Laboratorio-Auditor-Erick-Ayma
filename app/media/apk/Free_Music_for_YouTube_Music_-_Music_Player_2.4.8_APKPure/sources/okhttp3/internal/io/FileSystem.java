package okhttp3.internal.io;

import c.l;
import c.r;
import c.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.io.FileSystem
        public s source(File file) throws FileNotFoundException {
            return l.a(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public r sink(File file) throws FileNotFoundException {
            try {
                return l.b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return l.b(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public r appendingSink(File file) throws FileNotFoundException {
            try {
                return l.c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return l.c(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    r appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    r sink(File file) throws FileNotFoundException;

    long size(File file);

    s source(File file) throws FileNotFoundException;
}
