package com.fotoable.youtube.music.bean;

import java.util.List;
/* loaded from: classes.dex */
public class VideoInfoBean {
    private String etag;
    private List<ItemsBean> items;
    private String kind;
    private PageInfoBean pageInfo;

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

    public PageInfoBean getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfoBean) {
        this.pageInfo = pageInfoBean;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }

    /* loaded from: classes.dex */
    public static class PageInfoBean {
        private int resultsPerPage;
        private int totalResults;

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
    public static class ItemsBean {
        private ContentDetailsBean contentDetails;
        private String etag;
        private String id;
        private String kind;
        private SnippetBean snippet;

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

        public SnippetBean getSnippet() {
            return this.snippet;
        }

        public void setSnippet(SnippetBean snippetBean) {
            this.snippet = snippetBean;
        }

        public ContentDetailsBean getContentDetails() {
            return this.contentDetails;
        }

        public void setContentDetails(ContentDetailsBean contentDetailsBean) {
            this.contentDetails = contentDetailsBean;
        }

        /* loaded from: classes.dex */
        public static class ContentDetailsBean {
            private String caption;
            private String definition;
            private String dimension;
            private String duration;
            private boolean licensedContent;
            private String projection;

            public String getDuration() {
                return this.duration;
            }

            public void setDuration(String str) {
                this.duration = str;
            }

            public String getDimension() {
                return this.dimension;
            }

            public void setDimension(String str) {
                this.dimension = str;
            }

            public String getDefinition() {
                return this.definition;
            }

            public void setDefinition(String str) {
                this.definition = str;
            }

            public String getCaption() {
                return this.caption;
            }

            public void setCaption(String str) {
                this.caption = str;
            }

            public boolean isLicensedContent() {
                return this.licensedContent;
            }

            public void setLicensedContent(boolean z) {
                this.licensedContent = z;
            }

            public String getProjection() {
                return this.projection;
            }

            public void setProjection(String str) {
                this.projection = str;
            }
        }
    }
}
