package com.example.videoapi.Models;

import java.util.ArrayList;

public class ExoModel {
    String video_url;
    public ExoModel(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
