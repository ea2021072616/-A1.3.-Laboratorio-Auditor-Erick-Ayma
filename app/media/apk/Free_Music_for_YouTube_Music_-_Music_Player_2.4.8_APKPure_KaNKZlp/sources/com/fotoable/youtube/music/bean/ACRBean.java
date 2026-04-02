package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class ACRBean {
    private MetadataBean metadata;
    private int result_type;
    private StatusBean status;

    public StatusBean getStatus() {
        return this.status;
    }

    public void setStatus(StatusBean statusBean) {
        this.status = statusBean;
    }

    public MetadataBean getMetadata() {
        return this.metadata;
    }

    public void setMetadata(MetadataBean metadataBean) {
        this.metadata = metadataBean;
    }

    public int getResult_type() {
        return this.result_type;
    }

    public void setResult_type(int i) {
        this.result_type = i;
    }

    /* loaded from: classes.dex */
    public static class StatusBean {
        private int code;
        private String msg;
        private String version;

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    /* loaded from: classes.dex */
    public static class MetadataBean {
        private List<MusicBean> music;
        private String timestamp_utc;

        public String getTimestamp_utc() {
            return this.timestamp_utc;
        }

        public void setTimestamp_utc(String str) {
            this.timestamp_utc = str;
        }

        public List<MusicBean> getMusic() {
            return this.music;
        }

        public void setMusic(List<MusicBean> list) {
            this.music = list;
        }

        /* loaded from: classes.dex */
        public static class MusicBean {
            private String acrid;
            private AlbumBean album;
            private List<ArtistsBean> artists;
            private int duration_ms;
            private ExternalIdsBean external_ids;
            private ExternalMetadataBean external_metadata;
            private List<GenresBean> genres;
            private String label;
            private int play_offset_ms;
            private String release_date;
            private int result_from;
            private int score;
            private String title;

            public ExternalIdsBean getExternal_ids() {
                return this.external_ids;
            }

            public void setExternal_ids(ExternalIdsBean externalIdsBean) {
                this.external_ids = externalIdsBean;
            }

            public int getPlay_offset_ms() {
                return this.play_offset_ms;
            }

            public void setPlay_offset_ms(int i) {
                this.play_offset_ms = i;
            }

            public ExternalMetadataBean getExternal_metadata() {
                return this.external_metadata;
            }

            public void setExternal_metadata(ExternalMetadataBean externalMetadataBean) {
                this.external_metadata = externalMetadataBean;
            }

            public String getLabel() {
                return this.label;
            }

            public void setLabel(String str) {
                this.label = str;
            }

            public AlbumBean getAlbum() {
                return this.album;
            }

            public void setAlbum(AlbumBean albumBean) {
                this.album = albumBean;
            }

            public String getRelease_date() {
                return this.release_date;
            }

            public void setRelease_date(String str) {
                this.release_date = str;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public int getDuration_ms() {
                return this.duration_ms;
            }

            public void setDuration_ms(int i) {
                this.duration_ms = i;
            }

            public String getAcrid() {
                return this.acrid;
            }

            public void setAcrid(String str) {
                this.acrid = str;
            }

            public int getResult_from() {
                return this.result_from;
            }

            public void setResult_from(int i) {
                this.result_from = i;
            }

            public int getScore() {
                return this.score;
            }

            public void setScore(int i) {
                this.score = i;
            }

            public List<ArtistsBean> getArtists() {
                return this.artists;
            }

            public void setArtists(List<ArtistsBean> list) {
                this.artists = list;
            }

            public List<GenresBean> getGenres() {
                return this.genres;
            }

            public void setGenres(List<GenresBean> list) {
                this.genres = list;
            }

            /* loaded from: classes.dex */
            public static class ExternalIdsBean {
                private String isrc;
                private String upc;

                public String getIsrc() {
                    return this.isrc;
                }

                public void setIsrc(String str) {
                    this.isrc = str;
                }

                public String getUpc() {
                    return this.upc;
                }

                public void setUpc(String str) {
                    this.upc = str;
                }
            }

            /* loaded from: classes.dex */
            public static class ExternalMetadataBean {
                private YoutubeBean youtube;

                public YoutubeBean getYoutube() {
                    return this.youtube;
                }

                public void setYoutube(YoutubeBean youtubeBean) {
                    this.youtube = youtubeBean;
                }

                /* loaded from: classes.dex */
                public static class YoutubeBean {
                    private String vid;

                    public String getVid() {
                        return this.vid;
                    }

                    public void setVid(String str) {
                        this.vid = str;
                    }
                }
            }

            /* loaded from: classes.dex */
            public static class AlbumBean {
                private String name;

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }

            /* loaded from: classes.dex */
            public static class ArtistsBean {
                private String name;

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }

            /* loaded from: classes.dex */
            public static class GenresBean {
                private String name;

                public String getName() {
                    return this.name;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }
        }
    }
}
