package com.company;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Worker extends Ant {

    public Worker(Point position){
        super(position);

    }

    @Override
    public void move() {
        int newX = getPosition().x;
        int newY = getPosition().y;
        List givenList = (List) Arrays.asList("N","E","S","V");
        Random rand = new Random();
        String randomElement = givenList.getItem(rand.nextInt(givenList.getItemCount()));
        switch (randomElement) {
            case "N":
                if (!hive.isOutOfBounds(newX,newY+1)&&(hive.isPositionAvailable(newX,newY+1))){
                    newY +=1;
                }
                break;
            case "E":
                if (hive.isOutOfBounds(newX+1,newY)&&(!hive.isPositionAvailable(newX+1,newY))) {
                    newX += 1;
                }
                break;
            case "S":
                if (hive.isOutOfBounds(newX,newY-1)&&(!hive.isPositionAvailable(newX,newY-1))) {
                    newY -= 1;
                }
                break;
            case "V":
                if (hive.isOutOfBounds(newX-1,newY)&&(!hive.isPositionAvailable(newX-1,newY))) {
                    newX -= 1;
                }
        }
        moveToPosition(newX, newY);


    }
}
