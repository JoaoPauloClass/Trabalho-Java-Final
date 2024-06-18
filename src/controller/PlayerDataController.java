package controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import model.player.Player;

import java.io.*;

public class PlayerDataController {
    public static void savePlayerData(String filename, Player player) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(player.getName() + "," + player.getAttack() + "," + player.getDefense() + "," +
                         player.getHealth() + "," + player.getMana() + "," + player.getAgility());
        }
    }

    public static Player loadPlayerData(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] data = reader.readLine().split(",");
            return new Player(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                              Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
        }
    }
}

