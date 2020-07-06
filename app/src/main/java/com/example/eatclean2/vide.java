package com.example.eatclean2;

public class vide {
    int id;
    String ten;
    int idVideo;

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setId(int id) {
        this.id = id;
    }

    public vide(int id, String ten, int idVideo) {
        this.id = id;
        this.ten = ten;
        this.idVideo = idVideo;
    }
}
