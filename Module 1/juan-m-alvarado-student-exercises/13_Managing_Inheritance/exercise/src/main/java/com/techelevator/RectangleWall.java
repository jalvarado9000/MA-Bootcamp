package com.techelevator;

public class RectangleWall extends Wall{

    private int length;
    private int height;

    public RectangleWall(String name,String color, int length, int height){
        super(name,color);
        this.length = length;
        this.height = height;

    }

    public int getArea(){
        return length*height;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String toString(){
        return getName() + " (" +  length +"x" +height +") rectangle";
    }

}
