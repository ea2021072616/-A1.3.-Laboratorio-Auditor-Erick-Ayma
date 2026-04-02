package com.fotoable.youtube.music.bean;
/* loaded from: classes.dex */
public class SearchItemBean {
    private ContentDetail contentDetails;
    private String etag;
    private IdBean id;
    private String kind;
    private SnippetBean snippet;

    public ContentDetail getContentDetails() {
        return this.contentDetails;
    }

    public void setContentDetails(ContentDetail contentDetail) {
        this.contentDetails = contentDetail;
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

    public IdBean getId() {
        return this.id;
    }

    public void setId(IdBean idBean) {
        this.id = idBean;
    }

    public SnippetBean getSnippet() {
        return this.snippet;
    }

    public void setSnippet(SnippetBean snippetBean) {
        this.snippet = snippetBean;
    }
}
