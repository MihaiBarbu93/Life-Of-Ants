package com.company;

import java.util.ArrayList;

public class Hive {
    private Insect board[][];
    private ArrayList<Ant> ants=new ArrayList<Ant>();
    private Queen queen;
    private int hiveSize;



    public Hive(Queen queen, ArrayList<Ant> ants, int sizeOfHive){
        this.queen=queen;
        this.ants=ants;
        this.hiveSize=sizeOfHive;
        board=new Insect[sizeOfHive][sizeOfHive];
        board[queen.getPosition().x][queen.getPosition().y]=queen;
        queen.setHive(this);
        for (Ant ant : this.ants){
            board[ant.getPosition().x][ant.getPosition().y]=ant;
            ant.setHive(this);
        }
    }


    public int getHiveSize(){
        return this.hiveSize;
    }

    public Insect[][] getBoard(){
        return this.board;
    }

    public Queen getQueen(){
        return this.queen;
    }

    public void executeTimeStep(){
        queen.move();
        for (Ant ant : this.ants)
            ant.move();
    }

    public boolean isPositionAvailable(int x, int y){
        return board[x][y]==null;
    }

    public boolean isOutOfBounds(int x, int y){
        return (x<0||x>=this.getHiveSize()||y<0||y>=this.getHiveSize());
    }



}
