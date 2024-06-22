package controller;

import model.player.Player;

import java.io.*;

public class PlayerDataController {
   
    private static final File PLAYER_SAVE_FILE = new File("src/database/Player/player.txt");

    public static void savePlayerData(Player player) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PLAYER_SAVE_FILE))) {
            writer.write("Name: " + player.getName() + "\n");
            writer.write("Attack: " + player.getAttack() + "\n");
            writer.write("Defense: " + player.getDefense() + "\n");
            writer.write("Health: " + player.getHealth() + "\n");
            writer.write("Mana: " + player.getMana() + "\n");
            writer.write("Agility: " + player.getAgility() + "\n");
            writer.write("Floor: " + player.getFloorNumber() + "\n");
        }
    }

    
    public static Player loadPlayerData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(PLAYER_SAVE_FILE))) {
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
                    case "Floor":
                        player.setFloor(Integer.parseInt(parts[1].trim()));
                        break;
                }
            }
            return player;
        }
    }

}
