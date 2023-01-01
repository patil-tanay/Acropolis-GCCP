package com.example.acropolisgccp.ModelPack;

public class DepartmentModel {
    int departmentImage;
    String departmentName , departmentDes ;

    public DepartmentModel(int departmentImage, String departmentName, String departmentDes) {
        this.departmentImage = departmentImage;
        this.departmentName = departmentName;
        this.departmentDes = departmentDes;
    }

    public int getDepartmentImage() {
        return departmentImage;
    }

    public void setDepartmentImage(int departmentImage) {
        this.departmentImage = departmentImage;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDes() {
        return departmentDes;
    }

    public void setDepartmentDes(String departmentDes) {
        this.departmentDes = departmentDes;
    }
}
