package com.fotoable.youtube.music.newplayer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.newplayer.d.c;
/* loaded from: classes.dex */
public class PlayerInfo implements Parcelable {
    public static final Parcelable.Creator<PlayerInfo> CREATOR = new Parcelable.Creator<PlayerInfo>() { // from class: com.fotoable.youtube.music.newplayer.model.PlayerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayerInfo createFromParcel(Parcel parcel) {
            return new PlayerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlayerInfo[] newArray(int i) {
            return new PlayerInfo[i];
        }
    };
    public static final int PLAYER_TYPE_LOCAL = 2050;
    public static final int PLAYER_TYPE_NONE = 2048;
    public static final int PLAYER_TYPE_RADIO = 2051;
    public static final int PLAYER_TYPE_YOUTUBE = 2049;
    public static final int PLAY_STATE_BUFFERING = 2307;
    public static final int PLAY_STATE_ERROR = 2308;
    public static final int PLAY_STATE_LOADING = 2307;
    public static final int PLAY_STATE_NONE = 2304;
    public static final int PLAY_STATE_PAUSE = 2306;
    public static final int PLAY_STATE_PLAYING = 2305;
    public static final int PLAY_STATE_STOP = 2306;
    private String artistsName;
    private String coverImg;
    private long currentTime;
    private String duration;
    private String errorMsg;
    private boolean isPlaying;
    private String musicName;
    private int playState;
    private int playerType;
    private int radioId;
    private long songId;
    private long totalTime;
    private String videoId;

    public PlayerInfo() {
        this.playerType = 2048;
        this.playState = PLAY_STATE_NONE;
    }

    protected PlayerInfo(Parcel parcel) {
        this.playerType = 2048;
        this.playState = PLAY_STATE_NONE;
        this.playerType = parcel.readInt();
        this.videoId = parcel.readString();
        this.songId = parcel.readLong();
        this.radioId = parcel.readInt();
        this.musicName = parcel.readString();
        this.artistsName = parcel.readString();
        this.coverImg = parcel.readString();
        this.duration = parcel.readString();
        this.currentTime = parcel.readLong();
        this.totalTime = parcel.readLong();
        this.isPlaying = parcel.readByte() != 0;
        this.playState = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public boolean isYoutubePlayer() {
        return this.playerType == 2049;
    }

    public boolean isLocalPlayer() {
        return this.playerType == 2050;
    }

    public boolean isRadioPlayer() {
        return this.playerType == 2051;
    }

    public boolean isBuffering() {
        return this.playState == 2307 || this.playState == 2307;
    }

    public boolean isError() {
        return this.playState == 2308;
    }

    public void covert(PlayMusicModel playMusicModel) {
        this.playerType = PLAYER_TYPE_YOUTUBE;
        if (playMusicModel != null) {
            this.videoId = playMusicModel.getVideoId();
            this.musicName = playMusicModel.getTitle();
            this.artistsName = playMusicModel.getArtists();
            this.coverImg = playMusicModel.getCoverImg();
        }
    }

    public void covert(LocalMusicModel localMusicModel) {
        this.playerType = PLAYER_TYPE_LOCAL;
        if (localMusicModel != null) {
            this.songId = localMusicModel.getSongId();
            this.musicName = localMusicModel.getSongName();
            this.artistsName = localMusicModel.getArtistName();
            this.coverImg = localMusicModel.getAlbumData();
        }
    }

    public void covert(RadioModel radioModel) {
        this.playerType = PLAYER_TYPE_RADIO;
        if (radioModel != null) {
            this.radioId = radioModel.getId();
            this.musicName = radioModel.getTitle();
            this.coverImg = radioModel.getImgUrl();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.playerType);
        parcel.writeString(this.videoId);
        parcel.writeLong(this.songId);
        parcel.writeInt(this.radioId);
        parcel.writeString(this.musicName);
        parcel.writeString(this.artistsName);
        parcel.writeString(this.coverImg);
        parcel.writeString(this.duration);
        parcel.writeLong(this.currentTime);
        parcel.writeLong(this.totalTime);
        parcel.writeByte((byte) (this.isPlaying ? 1 : 0));
        parcel.writeInt(this.playState);
        parcel.writeString(this.errorMsg);
    }

    public int getPlayerType() {
        return this.playerType;
    }

    public void setPlayerType(int i) {
        this.playerType = i;
    }

    public int getPlayState() {
        return this.playState;
    }

    public void setPlayState(int i) {
        this.playState = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public long getSongId() {
        return this.songId;
    }

    public void setSongId(long j) {
        this.songId = j;
    }

    public int getRadioId() {
        return this.radioId;
    }

    public void setRadioId(int i) {
        this.radioId = i;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public void setMusicName(String str) {
        this.musicName = str;
    }

    public String getArtistsName() {
        return this.artistsName;
    }

    public void setArtistsName(String str) {
        this.artistsName = str;
    }

    public String getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(String str) {
        this.coverImg = str;
    }

    public String getDuration() {
        if (isYoutubePlayer()) {
            return c.a(this.totalTime - this.currentTime);
        }
        if (isLocalPlayer()) {
            return c.a((this.totalTime - this.currentTime) / 1000);
        }
        if (isRadioPlayer()) {
            return c.a(this.currentTime / 1000);
        }
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(long j) {
        this.totalTime = j;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public String toString() {
        return "PlayerInfo{playerType=" + this.playerType + ", videoId='" + this.videoId + "', songId=" + this.songId + ", radioId=" + this.radioId + ", musicName='" + this.musicName + "', artistsName='" + this.artistsName + "', coverImg='" + this.coverImg + "', duration='" + this.duration + "', currentTime=" + this.currentTime + ", totalTime=" + this.totalTime + ", isPlaying=" + this.isPlaying + ", playState=" + this.playState + ", errorMsg='" + this.errorMsg + "'}";
    }
}
