package controller;

import java.io.*;
import java.util.ArrayList;

import model.Floor;

public abstract class FloorController {

    private static final File FLOOR = new File("src/database/floor.txt");

    public static ArrayList<Floor> initializeFloor() throws Exception{
        
        ArrayList<Floor> floors = new ArrayList<Floor>();
        String line;

        try (FileReader fr = new FileReader(FLOOR); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {

                Floor tempFloor = Floor.fromString(line);

                floors.add(tempFloor);
            }

            if(floors.isEmpty()) {
                throw new Exception("Np floor added.");
            } 

        }

        return floors;
    }

}
