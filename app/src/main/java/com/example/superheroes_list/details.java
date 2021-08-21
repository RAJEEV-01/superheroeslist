package com.example.superheroes_list;

import com.google.gson.annotations.SerializedName;

public class details {
    @SerializedName("name")
    private String name;
    private String slug;
    private String images;

    public details(String name, String slug, String images) {
        this.name = name;
        this.slug = slug;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getImages() {
        return images;
    }
}
