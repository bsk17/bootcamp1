package com.dsc.android.bcamp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecyclerViewData implements Serializable {


    @SerializedName("image")
    @Expose
    private String Image;
    @SerializedName("name")
    @Expose
    private String Name;
    @SerializedName("number")
    @Expose
    private String Email;


    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
