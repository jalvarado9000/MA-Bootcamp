package com.techelevator;
/*
letterGrade is a derived attribute that's calculated using earnedMarks and possibleMarks:
For 90% or greater, it returns "A"
For 80-89%, it returns "B"
For 70-79%, it returns "C"
For 60-69%, it returns "D"
Otherwise, it returns "F"
hint: possibleMarks and earnedMarks are ints. What happens when a smaller integer is divided by a larger integer?
Constructor
The HomeworkAssignment class has a single constructor. It accepts two arguments: int possibleMarks and String submitterName. Use these parameters to set the instance variables of the class.
 */



public class HomeworkAssignment {
    private String submitterName;//The submitter's name for the assignment.
    private String letterGrade;//The letter grade for the assignment.
    private int earnedMarks;//The total number of correct marks submitter received on the assignment.
    private int possibleMarks = 100;//The number of possible marks on the assignment.
    private int score;

    public HomeworkAssignment(int possibleMarks,String submitterName){
       this.submitterName = submitterName;
       this.earnedMarks = earnedMarks;

    }
    public void setEarnedMarks(int earnedMarks){

        score = (earnedMarks*100)/(possibleMarks);
        if(score >= 90)
            letterGrade = "A";
        else if(score <= 89 && score >= 80)
            letterGrade = "B";
        else if(score <= 79 && score >= 70)
            letterGrade = "C";
        else if(score <= 69 && score >= 60)
            letterGrade = "D";
        else
            letterGrade = "F";
    }

    public int getPossibleMarks(){return possibleMarks;}
    public int getEarnedMarks(){return earnedMarks;}
    public String getSubmitterName(){return submitterName;};
    public String getLetterGrade(){return letterGrade;}







    }








