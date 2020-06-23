package com.company;

import java.awt.Point;

public abstract class Ant extends Insect {

    protected Hive hive;

    public Ant(Point position){
        super(position);

    }

    public void setHive(Hive hive){
        this.hive=hive;
    }

    public Hive getHive(){
        return this.hive;

    }

    public void moveToPosition(Point newPosition){
        hive.getBoard()[getPosition().x][getPosition().y]=null;
        setPosition(newPosition);
        hive.getBoard()[getPosition().x][getPosition().y]=this;
    }

    public void moveToPosition(int newX, int newY){
        moveToPosition(new Point(newX, newY));
    }

    public int getDistanceFromQueen(){
        Point queenPosition=hive.getQueen().getPosition();
        return Math.abs(queenPosition.x-position.x)+Math.abs(queenPosition.y-position.y);

    }


    public abstract void move();



}

