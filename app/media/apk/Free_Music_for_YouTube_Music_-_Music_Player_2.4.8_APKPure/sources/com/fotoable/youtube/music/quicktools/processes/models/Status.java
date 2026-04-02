package com.fotoable.youtube.music.quicktools.processes.models;

import java.io.IOException;
/* loaded from: classes.dex */
public final class Status extends ProcFile {
    public static Status get(int i) throws IOException {
        return new Status(String.format("/proc/%d/status", Integer.valueOf(i)));
    }

    private Status(String str) throws IOException {
        super(str);
    }

    public String getValue(String str) {
        String[] split;
        for (String str2 : this.content.split("\n")) {
            if (str2.startsWith(str + ":")) {
                return str2.split(str + ":")[1].trim();
            }
        }
        return null;
    }

    public int getUid() {
        try {
            return Integer.parseInt(getValue("Uid").split("\\s+")[0]);
        } catch (Exception e) {
            return -1;
        }
    }

    public int getGid() {
        try {
            return Integer.parseInt(getValue("Gid").split("\\s+")[0]);
        } catch (Exception e) {
            return -1;
        }
    }
}
