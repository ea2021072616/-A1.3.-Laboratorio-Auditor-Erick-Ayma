package com.fotoable.youtube.music.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class UserInfoModel {
    private String auth;
    private String avatar;
    private long created_at;
    @SerializedName("deviceid")
    private String deviceId;
    private int isVip;
    private String name;
    private int type;
    private String uid;
    private long updated_at;

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getAuth() {
        return this.auth;
    }

    public void setAuth(String str) {
        this.auth = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(long j) {
        this.created_at = j;
    }

    public long getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(long j) {
        this.updated_at = j;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public boolean isVip() {
        return this.isVip == 1;
    }

    public void setIsVip(int i) {
        this.isVip = i;
    }

    public String toString() {
        return "UserInfoModel{uid='" + this.uid + "', name='" + this.name + "', avatar='" + this.avatar + "', deviceId='" + this.deviceId + "', auth='" + this.auth + "', type=" + this.type + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", isVip=" + this.isVip + '}';
    }
}
