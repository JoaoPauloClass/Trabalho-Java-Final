package controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


import model.player.Player;

import java.io.*;

public static void savePlayerData(String filename, Player player) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        writer.write("Name: " + player.getName() + "\n");
        writer.write("Attack: " + player.getAttack() + "\n");
        writer.write("Defense: " + player.getDefense() + "\n");
        writer.write("Health: " + player.getHeathy() + "\n");
        writer.write("Mana: " + player.getMana() + "\n");
        writer.write("Agility: " + player.getAgility() + "\n");
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

