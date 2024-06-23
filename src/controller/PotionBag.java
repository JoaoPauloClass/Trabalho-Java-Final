package controller;

import java.util.ArrayList;

import model.Potion;

public abstract class PotionBag {

    public static ArrayList<Potion> potionBag = new ArrayList<Potion>();

    public static void initialize() {

        Potion lifePotion = new Potion("LIFE", 1);
        Potion manaPotion = new Potion("MANA", 1);

        potionBag.add(lifePotion);
        potionBag.add(manaPotion);
    }

    public static void addPotion(String type) {
        if (type.equals("LIFE")) {
            potionBag.get(0).addQuantity();

        } else if (type.equals("MANA")) {
            potionBag.get(1).addQuantity();
        }
    }

    public static void usePotion(String type) throws Exception {
        if (type.equals("LIFE")) {
            if (potionBag.get(0).getQuantity() > 0) {
                potionBag.get(0).removeQuantity();
            } else {
                throw new Exception("Você não possui poção deste tipo.");
            }

        } else if (type.equals("MANA")) {
            if (potionBag.get(1).getQuantity() > 0) {
                potionBag.get(1).removeQuantity();
            }else {
                throw new Exception("Você não possui poção deste tipo.");
            }
            
        } else {
            throw new Exception("Você não possui poção deste tipo.");
        }
    }
}
