package com.company;

import javax.swing.event.SwingPropertyChangeSupport;
import java.awt.*;

public class Soldier extends Ant {

    private String coord = "N";

    public Soldier(Point position){
        super(position);

    }


    @Override
    public void move() {
        int newX = getPosition().x;
        int newY = getPosition().y;
        switch (coord) {
            case "N":
                if (!hive.isOutOfBounds(newX,newY+1)&&(hive.isPositionAvailable(newX,newY+1))){
                    newY +=1;
                    coord="E";
                }
                break;
            case "E":
                if (hive.isOutOfBounds(newX+1,newY)&&(!hive.isPositionAvailable(newX+1,newY))) {
                    newX += 1;
                    coord = "S";
                }
                break;
            case "S":
                if (hive.isOutOfBounds(newX,newY-1)&&(!hive.isPositionAvailable(newX,newY-1))) {
                    newY -= 1;
                    coord = "V";
                }
                break;
            case "V":
                if (hive.isOutOfBounds(newX-1,newY)&&(!hive.isPositionAvailable(newX-1,newY))) {
                    newX -= 1;
                    coord = "N";
                }
        }
        moveToPosition(newX, newY);
    }
}

