package controller;

import model.Armor;
import model.player.Player;

public abstract class PlayerController {
    

    public Player calculateAtributes(Player player) {

        Player tempPlayer = new Player();

        try {
            tempPlayer = (Player) player.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        Armor equipedArmor = tempPlayer.getArmor();

        tempPlayer.setDefense(player.getDefense() + equipedArmor.getDefenseUpgrade());

        if (equipedArmor.getTypeUpgrade() == "ATTACK") {
            tempPlayer.setAttack(player.getAttack() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade() == "DEFENSE") {
            tempPlayer.setDefense(player.getDefense() + equipedArmor.getStatUpgrade());
        }else if (equipedArmor.getTypeUpgrade() == "HEALTH") {
            tempPlayer.setHealth(player.getHealth() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade() == "AGILITY") {
            tempPlayer.setAgility(player.getAgility() + equipedArmor.getStatUpgrade());
        } else if (equipedArmor.getTypeUpgrade() == "MANA") {
            tempPlayer.setMana(player.getMana() + equipedArmor.getStatUpgrade());
        }

        return tempPlayer;
    }
}
