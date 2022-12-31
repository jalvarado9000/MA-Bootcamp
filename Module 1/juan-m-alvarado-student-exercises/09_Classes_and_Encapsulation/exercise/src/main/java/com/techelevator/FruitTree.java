package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int piecesOfFruitLeft){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;


    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove){
        boolean availableFruit = false;
        if(piecesOfFruitLeft == 0)
            piecesOfFruitLeft = 0;
        else{
            availableFruit = piecesOfFruitLeft < numberOfPiecesToRemove ? false : true;
            piecesOfFruitLeft -= numberOfPiecesToRemove;

        }
        return availableFruit;

    }





}
