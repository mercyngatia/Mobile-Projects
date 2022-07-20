package com.example.normalrecyclerview.normalrecycler;

public class Planet {

    private String planetName;
    private int distanceFromSun;
    private int gravity;
    private int diameter;

    //constructor

    public Planet(String planetName, int distanceFromSun, int gravity, int diameter) {
        this.planetName = planetName;
        this.distanceFromSun = distanceFromSun;
        this.gravity = gravity;
        this.diameter = diameter;
    }

    //Getters
    public String getPlanetName() {
        return planetName;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getGravity() {
        return gravity;
    }

    public int getDiameter() {
        return diameter;
    }
}
