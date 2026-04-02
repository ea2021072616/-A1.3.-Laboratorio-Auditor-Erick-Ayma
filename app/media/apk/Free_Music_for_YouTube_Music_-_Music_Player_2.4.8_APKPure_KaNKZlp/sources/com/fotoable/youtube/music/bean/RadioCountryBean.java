package com.fotoable.youtube.music.bean;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RadioCountryBean implements Serializable {
    private String country;
    private String countryCode;
    private String flagUrl;

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
}
