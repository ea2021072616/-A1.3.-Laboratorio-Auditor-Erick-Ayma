package com.fotoable.youtube.music.bean;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PlayListDetailBean {
    private String etag;
    private List<ItemsEntity> items;
    private String kind;
    private String nextPageToken;
    private PageInfoEntity pageInfo;
    private String prevPageToken;

    public static PlayListDetailBean objectFromData(String str) {
        return (PlayListDetailBean) new Gson().fromJson(str, (Class<Object>) PlayListDetailBean.class);
    }

    public static PlayListDetailBean objectFromData(String str, String str2) {
        try {
            return (PlayListDetailBean) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) PlayListDetailBean.class);
        } catch (JSONException e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    public static List<PlayListDetailBean> arrayPlayListDetailBeanFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PlayListDetailBean>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.1
        }.getType());
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public void setNextPageToken(String str) {
        this.nextPageToken = str;
    }

    public String getPrevPageToken() {
        return this.prevPageToken;
    }

    public void setPrevPageToken(String str) {
        this.prevPageToken = str;
    }

    public PageInfoEntity getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfoEntity pageInfoEntity) {
        this.pageInfo = pageInfoEntity;
    }

    public List<ItemsEntity> getItems() {
        return this.items;
    }

    public void setItems(List<ItemsEntity> list) {
        this.items = list;
    }

    /* loaded from: classes.dex */
    public static class PageInfoEntity {
        private int resultsPerPage;
        private int totalResults;

        public static PageInfoEntity objectFromData(String str) {
            return (PageInfoEntity) new Gson().fromJson(str, (Class<Object>) PageInfoEntity.class);
        }

        public static PageInfoEntity objectFromData(String str, String str2) {
            try {
                return (PageInfoEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) PageInfoEntity.class);
            } catch (JSONException e) {
                ThrowableExtension.printStackTrace(e);
                return null;
            }
        }

        public static List<PageInfoEntity> arrayPageInfoEntityFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<PageInfoEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.PageInfoEntity.1
            }.getType());
        }

        public int getTotalResults() {
            return this.totalResults;
        }

        public void setTotalResults(int i) {
            this.totalResults = i;
        }

        public int getResultsPerPage() {
            return this.resultsPerPage;
        }

        public void setResultsPerPage(int i) {
            this.resultsPerPage = i;
        }
    }

    /* loaded from: classes.dex */
    public static class ItemsEntity {
        private ContentDetailsEntity contentDetails;
        private String etag;
        private String id;
        private String kind;
        private SnippetEntity snippet;

        public static ItemsEntity objectFromData(String str) {
            return (ItemsEntity) new Gson().fromJson(str, (Class<Object>) ItemsEntity.class);
        }

        public static ItemsEntity objectFromData(String str, String str2) {
            try {
                return (ItemsEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) ItemsEntity.class);
            } catch (JSONException e) {
                ThrowableExtension.printStackTrace(e);
                return null;
            }
        }

        public static List<ItemsEntity> arrayItemsEntityFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ItemsEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.1
            }.getType());
        }

        public String getKind() {
            return this.kind;
        }

        public void setKind(String str) {
            this.kind = str;
        }

        public String getEtag() {
            return this.etag;
        }

        public void setEtag(String str) {
            this.etag = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public SnippetEntity getSnippet() {
            return this.snippet;
        }

        public void setSnippet(SnippetEntity snippetEntity) {
            this.snippet = snippetEntity;
        }

        public ContentDetailsEntity getContentDetails() {
            return this.contentDetails;
        }

        public void setContentDetails(ContentDetailsEntity contentDetailsEntity) {
            this.contentDetails = contentDetailsEntity;
        }

        /* loaded from: classes.dex */
        public static class SnippetEntity {
            private String channelId;
            private String channelTitle;
            private String description;
            private String duration;
            private int isFav;
            private String playlistId;
            private int position;
            private String publishedAt;
            private ResourceIdEntity resourceId;
            private ThumbnailsEntity thumbnails;
            private String title;

            public String toString() {
                return "SnippetEntity{publishedAt='" + this.publishedAt + "', channelId='" + this.channelId + "', title='" + this.title + "', description='" + this.description + "', thumbnails=" + this.thumbnails + ", channelTitle='" + this.channelTitle + "', playlistId='" + this.playlistId + "', position=" + this.position + ", resourceId=" + this.resourceId + '}';
            }

            public String getDuration() {
                return this.duration;
            }

            public void setDuration(String str) {
                this.duration = str;
            }

            public int getIsFav() {
                return this.isFav;
            }

            public void setIsFav(int i) {
                this.isFav = i;
            }

            public static SnippetEntity objectFromData(String str) {
                return (SnippetEntity) new Gson().fromJson(str, (Class<Object>) SnippetEntity.class);
            }

            public static SnippetEntity objectFromData(String str, String str2) {
                try {
                    return (SnippetEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) SnippetEntity.class);
                } catch (JSONException e) {
                    ThrowableExtension.printStackTrace(e);
                    return null;
                }
            }

            public static List<SnippetEntity> arraySnippetEntityFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SnippetEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.1
                }.getType());
            }

            public String getPublishedAt() {
                return this.publishedAt;
            }

            public void setPublishedAt(String str) {
                this.publishedAt = str;
            }

            public String getChannelId() {
                return this.channelId;
            }

            public void setChannelId(String str) {
                this.channelId = str;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String str) {
                this.description = str;
            }

            public ThumbnailsEntity getThumbnails() {
                return this.thumbnails;
            }

            public void setThumbnails(ThumbnailsEntity thumbnailsEntity) {
                this.thumbnails = thumbnailsEntity;
            }

            public String getChannelTitle() {
                return this.channelTitle;
            }

            public void setChannelTitle(String str) {
                this.channelTitle = str;
            }

            public String getPlaylistId() {
                return this.playlistId;
            }

            public void setPlaylistId(String str) {
                this.playlistId = str;
            }

            public int getPosition() {
                return this.position;
            }

            public void setPosition(int i) {
                this.position = i;
            }

            public ResourceIdEntity getResourceId() {
                return this.resourceId;
            }

            public void setResourceId(ResourceIdEntity resourceIdEntity) {
                this.resourceId = resourceIdEntity;
            }

            /* loaded from: classes.dex */
            public static class ThumbnailsEntity {
                @SerializedName("default")
                private DefaultEntity defaultX;
                private HighEntity high;
                private MaxresEntity maxres;
                private MediumEntity medium;
                private StandardEntity standard;

                public static ThumbnailsEntity objectFromData(String str) {
                    return (ThumbnailsEntity) new Gson().fromJson(str, (Class<Object>) ThumbnailsEntity.class);
                }

                public static ThumbnailsEntity objectFromData(String str, String str2) {
                    try {
                        return (ThumbnailsEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) ThumbnailsEntity.class);
                    } catch (JSONException e) {
                        ThrowableExtension.printStackTrace(e);
                        return null;
                    }
                }

                public static List<ThumbnailsEntity> arrayThumbnailsEntityFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ThumbnailsEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.1
                    }.getType());
                }

                public DefaultEntity getDefaultX() {
                    return this.defaultX;
                }

                public void setDefaultX(DefaultEntity defaultEntity) {
                    this.defaultX = defaultEntity;
                }

                public MediumEntity getMedium() {
                    return this.medium;
                }

                public void setMedium(MediumEntity mediumEntity) {
                    this.medium = mediumEntity;
                }

                public HighEntity getHigh() {
                    return this.high;
                }

                public void setHigh(HighEntity highEntity) {
                    this.high = highEntity;
                }

                public StandardEntity getStandard() {
                    return this.standard;
                }

                public void setStandard(StandardEntity standardEntity) {
                    this.standard = standardEntity;
                }

                public MaxresEntity getMaxres() {
                    return this.maxres;
                }

                public void setMaxres(MaxresEntity maxresEntity) {
                    this.maxres = maxresEntity;
                }

                /* loaded from: classes.dex */
                public static class DefaultEntity {
                    private int height;
                    private String url;
                    private int width;

                    public static DefaultEntity objectFromData(String str) {
                        return (DefaultEntity) new Gson().fromJson(str, (Class<Object>) DefaultEntity.class);
                    }

                    public static DefaultEntity objectFromData(String str, String str2) {
                        try {
                            return (DefaultEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) DefaultEntity.class);
                        } catch (JSONException e) {
                            ThrowableExtension.printStackTrace(e);
                            return null;
                        }
                    }

                    public static List<DefaultEntity> arrayDefaultEntityFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<DefaultEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.DefaultEntity.1
                        }.getType());
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setWidth(int i) {
                        this.width = i;
                    }

                    public int getHeight() {
                        return this.height;
                    }

                    public void setHeight(int i) {
                        this.height = i;
                    }
                }

                /* loaded from: classes.dex */
                public static class MediumEntity {
                    private int height;
                    private String url;
                    private int width;

                    public static MediumEntity objectFromData(String str) {
                        return (MediumEntity) new Gson().fromJson(str, (Class<Object>) MediumEntity.class);
                    }

                    public static MediumEntity objectFromData(String str, String str2) {
                        try {
                            return (MediumEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) MediumEntity.class);
                        } catch (JSONException e) {
                            ThrowableExtension.printStackTrace(e);
                            return null;
                        }
                    }

                    public static List<MediumEntity> arrayMediumEntityFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MediumEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.MediumEntity.1
                        }.getType());
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setWidth(int i) {
                        this.width = i;
                    }

                    public int getHeight() {
                        return this.height;
                    }

                    public void setHeight(int i) {
                        this.height = i;
                    }
                }

                /* loaded from: classes.dex */
                public static class HighEntity {
                    private int height;
                    private String url;
                    private int width;

                    public static HighEntity objectFromData(String str) {
                        return (HighEntity) new Gson().fromJson(str, (Class<Object>) HighEntity.class);
                    }

                    public static HighEntity objectFromData(String str, String str2) {
                        try {
                            return (HighEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) HighEntity.class);
                        } catch (JSONException e) {
                            ThrowableExtension.printStackTrace(e);
                            return null;
                        }
                    }

                    public static List<HighEntity> arrayHighEntityFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<HighEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.HighEntity.1
                        }.getType());
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setWidth(int i) {
                        this.width = i;
                    }

                    public int getHeight() {
                        return this.height;
                    }

                    public void setHeight(int i) {
                        this.height = i;
                    }
                }

                /* loaded from: classes.dex */
                public static class StandardEntity {
                    private int height;
                    private String url;
                    private int width;

                    public static StandardEntity objectFromData(String str) {
                        return (StandardEntity) new Gson().fromJson(str, (Class<Object>) StandardEntity.class);
                    }

                    public static StandardEntity objectFromData(String str, String str2) {
                        try {
                            return (StandardEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) StandardEntity.class);
                        } catch (JSONException e) {
                            ThrowableExtension.printStackTrace(e);
                            return null;
                        }
                    }

                    public static List<StandardEntity> arrayStandardEntityFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<StandardEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.StandardEntity.1
                        }.getType());
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setWidth(int i) {
                        this.width = i;
                    }

                    public int getHeight() {
                        return this.height;
                    }

                    public void setHeight(int i) {
                        this.height = i;
                    }
                }

                /* loaded from: classes.dex */
                public static class MaxresEntity {
                    private int height;
                    private String url;
                    private int width;

                    public static MaxresEntity objectFromData(String str) {
                        return (MaxresEntity) new Gson().fromJson(str, (Class<Object>) MaxresEntity.class);
                    }

                    public static MaxresEntity objectFromData(String str, String str2) {
                        try {
                            return (MaxresEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) MaxresEntity.class);
                        } catch (JSONException e) {
                            ThrowableExtension.printStackTrace(e);
                            return null;
                        }
                    }

                    public static List<MaxresEntity> arrayMaxresEntityFromData(String str) {
                        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<MaxresEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ThumbnailsEntity.MaxresEntity.1
                        }.getType());
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public void setUrl(String str) {
                        this.url = str;
                    }

                    public int getWidth() {
                        return this.width;
                    }

                    public void setWidth(int i) {
                        this.width = i;
                    }

                    public int getHeight() {
                        return this.height;
                    }

                    public void setHeight(int i) {
                        this.height = i;
                    }
                }
            }

            /* loaded from: classes.dex */
            public static class ResourceIdEntity {
                private String kind;
                private String videoId;

                public static ResourceIdEntity objectFromData(String str) {
                    return (ResourceIdEntity) new Gson().fromJson(str, (Class<Object>) ResourceIdEntity.class);
                }

                public static ResourceIdEntity objectFromData(String str, String str2) {
                    try {
                        return (ResourceIdEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) ResourceIdEntity.class);
                    } catch (JSONException e) {
                        ThrowableExtension.printStackTrace(e);
                        return null;
                    }
                }

                public static List<ResourceIdEntity> arrayResourceIdEntityFromData(String str) {
                    return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ResourceIdEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.SnippetEntity.ResourceIdEntity.1
                    }.getType());
                }

                public String getKind() {
                    return this.kind;
                }

                public void setKind(String str) {
                    this.kind = str;
                }

                public String getVideoId() {
                    return this.videoId;
                }

                public void setVideoId(String str) {
                    this.videoId = str;
                }
            }
        }

        /* loaded from: classes.dex */
        public static class ContentDetailsEntity {
            private String videoId;
            private String videoPublishedAt;

            public static ContentDetailsEntity objectFromData(String str) {
                return (ContentDetailsEntity) new Gson().fromJson(str, (Class<Object>) ContentDetailsEntity.class);
            }

            public static ContentDetailsEntity objectFromData(String str, String str2) {
                try {
                    return (ContentDetailsEntity) new Gson().fromJson(new JSONObject(str).getString(str), (Class<Object>) ContentDetailsEntity.class);
                } catch (JSONException e) {
                    ThrowableExtension.printStackTrace(e);
                    return null;
                }
            }

            public static List<ContentDetailsEntity> arrayContentDetailsEntityFromData(String str) {
                return (List) new Gson().fromJson(str, new TypeToken<ArrayList<ContentDetailsEntity>>() { // from class: com.fotoable.youtube.music.bean.PlayListDetailBean.ItemsEntity.ContentDetailsEntity.1
                }.getType());
            }

            public String getVideoId() {
                return this.videoId;
            }

            public void setVideoId(String str) {
                this.videoId = str;
            }

            public String getVideoPublishedAt() {
                return this.videoPublishedAt;
            }

            public void setVideoPublishedAt(String str) {
                this.videoPublishedAt = str;
            }
        }
    }
}
