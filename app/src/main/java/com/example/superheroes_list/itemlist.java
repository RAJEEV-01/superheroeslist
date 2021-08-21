package com.example.superheroes_list;

public class itemlist {
    private String name;
    private String imageurl;
    private String powdetails;
    private  int id;
    private String gender;
    private String race;
    private String height;
    private String weight;
    private int intelligence;
    private int strength;
    private int speed;
    private int power;
    private String app;

    public itemlist(String name, String imageurl, String powdetails, int id, String gender, String race, String height, String weight, int intelligence, int strength, int speed, int power, String app) {
        this.name = name;
        this.imageurl = imageurl;
        this.powdetails = powdetails;
        this.id = id;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.power = power;
        this.app = app;
    }


    public String getName() {
        return name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getDetails() {
        return powdetails;
    }


    public int getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public int getPower() {
        return power;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public String getApp() {
        return app;
    }
}
