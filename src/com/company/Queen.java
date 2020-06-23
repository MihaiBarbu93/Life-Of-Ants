package com.company;

import java.awt.Point;

public class Queen extends Ant {
    boolean mood=true;
    private int timeStepsUntilMood=0;

    public Queen(Point position){
        super(position);
        System.out.println("Created the queen");
    }


    @Override
    public void move(){
        if (!mood){
            timeStepsUntilMood--;
            System.out.println("Queen still not in the mood, wait "+timeStepsUntilMood);
            if (timeStepsUntilMood==0) {
                System.out.println("Queen back in mood");
                mood = true;
            }
        }
    }

    public boolean isInMood() {
        return mood;
    }

    public void mate() {
        this.mood = false;
        timeStepsUntilMood=100+(int)(Math.random()*101);
        System.out.println("Queen is mating, mood will be false from now on, time steps until mood change: "+timeStepsUntilMood);
    }

}
