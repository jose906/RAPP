package com.fpp.rapp.model.YoutubeModel;

public class ResourceId {

    String kind;
    String videoId;

    public ResourceId(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
