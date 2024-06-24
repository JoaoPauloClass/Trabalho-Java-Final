package controller;

import model.Armor;
import model.player.Player;

public abstract class PlayerController {

    public static Player calculateAtributes(Player player) {

        Player tempPlayer = new Player();

        try {
            tempPlayer = (Player) player.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        Armor equipedArmor = tempPlayer.getArmor();
        String playerClass = player.getPlayerClass();

        if (playerClass.equals("WARRIOR")) {
            tempPlayer.setDefense(player.getDefense() + equipedArmor.getClassUpgrade());
        } else if (playerClass.equals("WIZARD")) {
            tempPlayer.setMana(player.getMana() + equipedArmor.getClassUpgrade());
        } else if (playerClass.equals("ASSASSIN")) {
            tempPlayer.setAttack(player.getAttack() + equipedArmor.getClassUpgrade());
        }

        if (equipedArmor.getTypeUpgrade().equals("ATTACK")) {
            tempPlayer.setAttack(player.getAttack() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade().equals("DEFENSE")) {
            tempPlayer.setDefense(player.getDefense() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade().equals("HEALTH")) {
            tempPlayer.setHealth(player.getHealth() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade().equals("AGILITY")) {
            tempPlayer.setAgility(player.getAgility() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade().equals("MANA")) {
            tempPlayer.setMana(player.getMana() + equipedArmor.getStatUpgrade());
        }

        return tempPlayer;
    }
}
