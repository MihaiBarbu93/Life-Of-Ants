package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queen q = new Queen(new Point(50, 50));
        ArrayList<Ant> ants = new ArrayList();
        Soldier s1 = new Soldier(new Point(30,48));
        Soldier s2 = new Soldier(new Point(60,40));
        Worker w1 = new Worker(new Point(41,70));
        Worker w2 = new Worker(new Point(15,85));
        Drone d1 = new Drone(new Point(45, 45));
        Drone d2 = new Drone(new Point(55, 60));
        Drone d3 = new Drone(new Point(0, 50));
        Drone d4 = new Drone(new Point(25, 75));
        ants.add(d1);
        ants.add(d2);
        ants.add(d3);
        ants.add(d4);
        ants.add(s1);
        ants.add(s2);
        ants.add(w1);
        ants.add(w2);
        Hive hive = new Hive(q, ants, 1000);

        for(int i = 0; i < 1000; ++i) {
            hive.executeTimeStep();
        }
    }
}
