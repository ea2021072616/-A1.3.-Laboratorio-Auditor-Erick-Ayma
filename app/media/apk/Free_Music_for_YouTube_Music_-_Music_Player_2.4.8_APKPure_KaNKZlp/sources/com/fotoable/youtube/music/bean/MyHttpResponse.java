package com.fotoable.youtube.music.bean;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class MyHttpResponse<T> implements Serializable {
    @SerializedName("code")
    private int code;
    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_DATA)
    private T data;
    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)
    private String message;
    @SerializedName("meta")
    private Meta meta;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(T t) {
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public String toString() {
        return "MyHttpResponse{code=" + this.code + ", message='" + this.message + "', data=" + this.data.toString() + ", meta=" + this.meta + '}';
    }
}
