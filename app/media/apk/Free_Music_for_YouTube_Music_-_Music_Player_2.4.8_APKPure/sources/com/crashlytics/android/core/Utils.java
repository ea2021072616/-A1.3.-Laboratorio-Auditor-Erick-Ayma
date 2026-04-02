package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
final class Utils {
    private Utils() {
    }

    public static void capFileCount(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles != null && listFiles.length > i) {
            Arrays.sort(listFiles, comparator);
            int length = listFiles.length;
            for (File file2 : listFiles) {
                if (length > i) {
                    file2.delete();
                    length--;
                } else {
                    return;
                }
            }
        }
    }
}
