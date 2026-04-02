package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class CountryCodeModel {
    private String cityName;
    private String countryCode;
    private String countryName;
    private String ip;

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String toString() {
        return "CountryCodeModel{ip='" + this.ip + "', countryCode='" + this.countryCode + "', countryName='" + this.countryName + "', cityName='" + this.cityName + "'}";
    }
}
