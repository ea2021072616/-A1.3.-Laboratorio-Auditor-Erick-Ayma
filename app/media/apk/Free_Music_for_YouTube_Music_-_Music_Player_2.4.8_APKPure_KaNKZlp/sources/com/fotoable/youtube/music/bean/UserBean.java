package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class UserBean {
    private String auth;
    private String city;
    private String country;
    private long created_at;
    private String deviceid;
    private String iso_code;
    private String reg_ip;
    private int type;
    private String uid;
    private long updated_at;

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getIso_code() {
        return this.iso_code;
    }

    public void setIso_code(String str) {
        this.iso_code = str;
    }

    public String getReg_ip() {
        return this.reg_ip;
    }

    public void setReg_ip(String str) {
        this.reg_ip = str;
    }
}
