package com.fotoable.youtube.music.newplayer.a;

import com.fotoable.youtube.music.bean.RadioBean;
import com.fotoable.youtube.music.newplayer.model.RadioModel;
/* compiled from: RadioCover.java */
/* loaded from: classes.dex */
public class c {
    public static RadioModel a(RadioBean radioBean) {
        if (radioBean == null) {
            return null;
        }
        RadioModel radioModel = new RadioModel();
        radioModel.setId(radioBean.getId());
        radioModel.setAudioType(radioBean.getAudioType());
        radioModel.setAudioUrl(radioBean.getAudioUrl());
        radioModel.setCountryCode(radioBean.getCountryCode());
        radioModel.setImgUrl(radioBean.getImgUrl());
        radioModel.setTitle(radioBean.getTitle());
        return radioModel;
    }

    public static RadioBean a(RadioModel radioModel) {
        if (radioModel == null) {
            return null;
        }
        RadioBean radioBean = new RadioBean();
        radioBean.setId(radioModel.getId());
        radioBean.setAudioType(radioModel.getAudioType());
        radioBean.setAudioUrl(radioModel.getAudioUrl());
        radioBean.setCountryCode(radioModel.getCountryCode());
        radioBean.setImgUrl(radioModel.getImgUrl());
        radioBean.setTitle(radioModel.getTitle());
        return radioBean;
    }
}
