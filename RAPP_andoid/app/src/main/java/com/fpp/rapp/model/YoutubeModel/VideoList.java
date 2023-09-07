package com.fpp.rapp.model.YoutubeModel;

import java.util.List;

public class VideoList {

    String kind;
    String etag;
    String nextPageToken;
    String prevPageToken;
    List<Items> items;
    PageInfo pageInfo;

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }



    public VideoList(String kind, String etag, String nextPageToken, List<Items> items, PageInfo pageInfo) {
        this.kind = kind;
        this.etag = etag;
        this.nextPageToken = nextPageToken;
        this.items = items;
        this.pageInfo = pageInfo;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
