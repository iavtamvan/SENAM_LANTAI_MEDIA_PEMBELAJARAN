package com.iav.vlvollylearning.model;

import com.google.gson.annotations.SerializedName;

public class ImageSliderModel {

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("text")
    private String text;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}