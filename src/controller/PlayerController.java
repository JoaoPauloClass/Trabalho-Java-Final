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

        tempPlayer.setDefense(player.getDefense() + equipedArmor.getDefenseUpgrade());

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
