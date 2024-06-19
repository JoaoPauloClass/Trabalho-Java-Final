package controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import model.player.Player;

import java.io.*;

public class PlayerDataController {
    public static void savePlayerData(String filename, Player player) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name: " + player.getName() + "\n");
            writer.write("Attack: " + player.getAttack() + "\n");
            writer.write("Defense: " + player.getDefense() + "\n");
            writer.write("Health: " + player.getHealth() + "\n");
            writer.write("Mana: " + player.getMana() + "\n");
            writer.write("Agility: " + player.getAgility() + "\n");
        }
    }

    public static Player loadPlayerData(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Player player = new Player();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                switch (parts[0]) {
                    case "Name":
                        player.setName(parts[1]);
                        break;
                    case "Attack":
                        player.setAttack(Integer.parseInt(parts[1].trim()));
                        break;
                    case "Defense":
                        player.setDefense(Integer.parseInt(parts[1].trim()));
                        break;
                    case "Health":
                        player.setHealth(Integer.parseInt(parts[1].trim()));
                        break;
                    case "Mana":
                        player.setMana(Integer.parseInt(parts[1].trim()));
                        break;
                    case "Agility":
                        player.setAgility(Integer.parseInt(parts[1].trim()));
                        break;
                }
            }
            return player;
        }
    }

}