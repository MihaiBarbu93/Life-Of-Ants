package com.company;

import java.awt.Point;

public class Drone extends Ant{
    private int timeStepsToPause=0;


    public Drone(Point position){
        super(position);

    }
    public void move(){

        if (timeStepsToPause>0){
            timeStepsToPause--;
            System.out.println("This drone is still pausing for "+timeStepsToPause);
            if (timeStepsToPause==0) {
                kickToRandomPosition();
            }
            return;
        }

        if (getDistanceFromQueen()<=3){
            System.out.println("This drone can now mate with the queen");
            if (hive.getQueen().isInMood()){
                System.out.println("The queen is in mood, the mating process begins");
                System.out.println("HALLELUJAH");
                timeStepsToPause=10;
                hive.getQueen().mate();
            }
            else
            {
                System.out.println("D'OH, no luck this time, getting kicked to random point");
                kickToRandomPosition();
            }
        } else{

            int dx=hive.getQueen().getPosition().x-getPosition().x;
            if (dx==0) {
                int dy = hive.getQueen().getPosition().y - getPosition().y;
                dy=dy/Math.abs(dy);
                moveToPosition(getPosition().x,getPosition().y+dy);
            } else {
                dx=dx/Math.abs(dx);
                moveToPosition(getPosition().x + dx, getPosition().y);
            }

        }



    }

    private void kickToRandomPosition() {
        int newX=-1;
        int newY=-1;
        while (hive.isOutOfBounds(newX,newY)||(!hive.isPositionAvailable(newX,newY))) {
            int dx = (int) (Math.random() * 101);
            int dy = 100 - dx;
            newX = getPosition().x + ((Math.random()<0.5)?dx:-dx);
            newY = getPosition().y + ((Math.random()<0.5)?dy:-dy);
            System.out.println("random position generated: "+newX+" "+newY);
        }
        System.out.println("Drone being kicked off to random point");
        moveToPosition(newX,newY);
    }


}
