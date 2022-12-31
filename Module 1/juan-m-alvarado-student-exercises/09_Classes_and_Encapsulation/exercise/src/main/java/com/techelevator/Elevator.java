package com.techelevator;

public class Elevator {

    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    //Constructor
    public Elevator(int numberOfLevels){
        numberOfFloors = numberOfLevels;
    }
    //Getters
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //methods
    public void openDoor(){doorOpen = true;}
    public void closeDoor(){doorOpen = false;}

    public void goUp(int desiredFloor){
        if(!isDoorOpen()) {
            if(desiredFloor <= numberOfFloors && desiredFloor > currentFloor)
                currentFloor = desiredFloor;
            else
                currentFloor = numberOfFloors;

        }


    }
    public void goDown(int desiredFloor){
        if(!isDoorOpen()) {
            if(desiredFloor >= 1 && desiredFloor < currentFloor)
                currentFloor = desiredFloor;
            else
                currentFloor = 1;

        }




    }


}
