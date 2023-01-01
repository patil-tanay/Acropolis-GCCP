package com.example.acropolisgccp.ModelPack;

public class NoticeModel {

    private String date , image , notice ;

    public NoticeModel() {
    }

    public NoticeModel(String date, String image, String notice) {
        this.date = date;
        this.image = image;
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}

