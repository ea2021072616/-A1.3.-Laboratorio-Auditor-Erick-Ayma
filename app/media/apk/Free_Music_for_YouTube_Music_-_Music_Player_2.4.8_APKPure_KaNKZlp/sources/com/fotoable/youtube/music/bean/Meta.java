package com.fotoable.youtube.music.bean;

import java.io.Serializable;
/* loaded from: classes.dex */
public class Meta implements Serializable {
    private String country;
    private String countryCode;
    private String flagUrl;
    private String groups;
    private long mixid;
    private int total;

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getFlagUrl() {
        return this.flagUrl;
    }

    public void setFlagUrl(String str) {
        this.flagUrl = str;
    }

    public void setGroups(String str) {
        this.groups = str;
    }

    public String getGroups() {
        return this.groups;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public long getMixid() {
        return this.mixid;
    }

    public void setMixid(long j) {
        this.mixid = j;
    }
}
