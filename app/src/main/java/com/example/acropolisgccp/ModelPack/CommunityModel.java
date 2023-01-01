package com.example.acropolisgccp.ModelPack;

public class CommunityModel {
    int communityImage;
    String communityName;

    public CommunityModel(int communityImage, String communityName) {
        this.communityImage = communityImage;
        this.communityName = communityName;
    }

    public int getCommunityImage() {
        return communityImage;
    }

    public void setCommunityImage(int communityImage) {
        this.communityImage = communityImage;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
