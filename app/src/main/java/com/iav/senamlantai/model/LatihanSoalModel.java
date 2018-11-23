package com.iav.senamlantai.model;

import com.google.gson.annotations.SerializedName;

public class LatihanSoalModel {

    @SerializedName("jawaban_e")
    private String jawabanE;

    @SerializedName("jawaban_c")
    private String jawabanC;

    @SerializedName("jawaban_d")
    private String jawabanD;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("jawaban_a")
    private String jawabanA;

    @SerializedName("jawaban_b")
    private String jawabanB;

    @SerializedName("jawaban_benar")
    private String jawabanBenar;

    @SerializedName("pertanyaan")
    private String pertanyaan;

    public void setJawabanE(String jawabanE) {
        this.jawabanE = jawabanE;
    }

    public String getJawabanE() {
        return jawabanE;
    }

    public void setJawabanC(String jawabanC) {
        this.jawabanC = jawabanC;
    }

    public String getJawabanC() {
        return jawabanC;
    }

    public void setJawabanD(String jawabanD) {
        this.jawabanD = jawabanD;
    }

    public String getJawabanD() {
        return jawabanD;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setJawabanA(String jawabanA) {
        this.jawabanA = jawabanA;
    }

    public String getJawabanA() {
        return jawabanA;
    }

    public void setJawabanB(String jawabanB) {
        this.jawabanB = jawabanB;
    }

    public String getJawabanB() {
        return jawabanB;
    }

    public void setJawabanBenar(String jawabanBenar) {
        this.jawabanBenar = jawabanBenar;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }
}