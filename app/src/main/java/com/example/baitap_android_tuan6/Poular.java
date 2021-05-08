package com.example.baitap_android_tuan6;

import java.io.Serializable;

public class Poular implements Serializable {
    private int poularId;
    private int imagesPoular;
    private String pricePoular;
    private String namePoular;

    public Poular(int poularId, int imagesPoular, String pricePoular, String namePoular) {
        this.poularId = poularId;
        this.imagesPoular = imagesPoular;
        this.pricePoular = pricePoular;
        this.namePoular = namePoular;
    }

    public int getPoularId() {
        return poularId;
    }

    public void setPoularId(int poularId) {
        this.poularId = poularId;
    }

    public int getImagesPoular() {
        return imagesPoular;
    }

    public void setImagesPoular(int imagesPoular) {
        this.imagesPoular = imagesPoular;
    }

    public String getPricePoular() {
        return pricePoular;
    }

    public void setPricePoular(String pricePoular) {
        this.pricePoular = pricePoular;
    }

    public String getNamePoular() {
        return namePoular;
    }

    public void setNamePoular(String namePoular) {
        this.namePoular = namePoular;
    }
}
