package controller;

import java.io.*;
import java.util.ArrayList;

import model.Floor;

public abstract class FloorController {

    private static final File FLOOR = new File("src/database/floor.txt");

    public static ArrayList<Floor> floors = new ArrayList<Floor>();
    
    // função para receber os dados do arquivo txt e coolocar na array list
    public static void initializeFloor() throws Exception{

        String line;

        try (FileReader fr = new FileReader(FLOOR); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {

                Floor tempFloor = Floor.fromString(line);

                floors.add(tempFloor);
            }

            if(floors.isEmpty()) {
                throw new Exception("No floor added.");
            } 

        }

    }

    // retorna o andar 
    public static Floor getFloor(int level) throws Exception {

        for (Floor floor : floors) {
            if(floor.getLevel() == level) {
                return floor;
            }
        }

        throw new Exception("Número de fase inválido");
    }

    // retorna numero de andares
    public static int getNumberOfFloors() {
        return floors.size();
    }

}
