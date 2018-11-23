package com.iav.senamlantai.model;

import com.google.gson.annotations.SerializedName;

public class DataMenuModel {

    @SerializedName("video_youtube_id")
    private String videoYoutubeId;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("judul")
    private String judul;

    @SerializedName("type")
    private String type;

    @SerializedName("nama_teknik")
    private String namaTeknik;

    public void setVideoYoutubeId(String videoYoutubeId) {
        this.videoYoutubeId = videoYoutubeId;
    }

    public String getVideoYoutubeId() {
        return videoYoutubeId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setNamaTeknik(String namaTeknik) {
        this.namaTeknik = namaTeknik;
    }

    public String getNamaTeknik() {
        return namaTeknik;
    }
}