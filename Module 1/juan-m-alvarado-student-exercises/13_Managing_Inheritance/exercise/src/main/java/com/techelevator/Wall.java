package com.techelevator;

abstract class Wall  {
    private String name;
    private String color;

    public Wall(String name, String color){
        this.name = name;
        this.color = color;
    }
    public abstract int getArea();

    public String getColor(){
        return color;
    }
    public String getName(){
        return name;
    }


}
