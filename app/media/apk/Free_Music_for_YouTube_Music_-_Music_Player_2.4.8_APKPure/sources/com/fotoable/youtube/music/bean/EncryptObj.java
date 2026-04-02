package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class EncryptObj {
    private String iv;
    private String mac;
    private String value;

    public EncryptObj(String str, String str2, String str3) {
        this.iv = str;
        this.value = str2;
        this.mac = str3;
    }

    public byte[] getIv() {
        return this.iv.getBytes();
    }

    public byte[] getValue() {
        return this.value.getBytes();
    }

    public String getMac() {
        return this.mac;
    }

    public String toString() {
        return "EncryptObj{iv='" + this.iv + "', value='" + this.value + "', mac='" + this.mac + "'}";
    }
}
