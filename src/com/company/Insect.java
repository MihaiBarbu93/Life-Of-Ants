package com.company;

import java.awt.Point;



public abstract class Insect {

    protected Point position;




    public Insect(Point position){
        this.position=position;
    }


    public Point getPosition(){
        return this.position;
    }

    public void setPosition(Point position){
        this.position=position;
    }

}
