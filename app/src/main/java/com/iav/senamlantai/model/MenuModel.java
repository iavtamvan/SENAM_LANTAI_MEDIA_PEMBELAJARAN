package com.iav.senamlantai.model;

import com.google.gson.annotations.SerializedName;

public class MenuModel {

    @SerializedName("nama_menu")
    private String namaMenu;

    @SerializedName("image_menu")
    private String imageMenu;

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setImageMenu(String imageMenu) {
        this.imageMenu = imageMenu;
    }

    public String getImageMenu() {
        return imageMenu;
    }
}