package com.fotoable.youtube.music.quicktools.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class Cgroup extends ProcFile {
    public static final Parcelable.Creator<Cgroup> CREATOR = new Parcelable.Creator<Cgroup>() { // from class: com.fotoable.youtube.music.quicktools.processes.models.Cgroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Cgroup createFromParcel(Parcel parcel) {
            return new Cgroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Cgroup[] newArray(int i) {
            return new Cgroup[i];
        }
    };
    public final ArrayList<ControlGroup> groups;

    public static Cgroup get(int i) throws IOException {
        return new Cgroup(String.format("/proc/%d/cgroup", Integer.valueOf(i)));
    }

    private Cgroup(String str) throws IOException {
        super(str);
        String[] split = this.content.split("\n");
        this.groups = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.groups.add(new ControlGroup(str2));
            } catch (Exception e) {
            }
        }
    }

    private Cgroup(Parcel parcel) {
        super(parcel);
        this.groups = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }

    public ControlGroup getGroup(String str) {
        Iterator<ControlGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            for (String str2 : next.subsystems.split(",")) {
                if (str2.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.fotoable.youtube.music.quicktools.processes.models.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.groups);
    }
}
