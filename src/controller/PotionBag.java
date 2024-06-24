package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Potion;
import view.Console;

public abstract class PotionBag {

    public static ArrayList<Potion> potionBag = new ArrayList<Potion>();

    // inicializa lista de poções
    public static void initialize() {

        Potion lifePotion = new Potion("LIFE", 2);
        Potion manaPotion = new Potion("MANA", 2);

        potionBag.add(lifePotion);
        potionBag.add(manaPotion);
    }
    // adiciona  uma poção ao determinado tipo
    public static void addPotion(String type) {
        if (type.equals("LIFE")) {
            potionBag.get(0).addQuantity();

        } else if (type.equals("MANA")) {
            potionBag.get(1).addQuantity();
        }
    }

    // usa uma poção
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
            } else {
                throw new Exception("Você não possui poção deste tipo.");
            }

        } else {
            throw new Exception("Você não possui poção deste tipo.");
        }
    }

    // utiliza um numero randomico para decidir qual vai ser o drop
    public static void randomPotionDrop() {

        Random random = new Random();

        int randomNumber = random.nextInt(6) + 1;

        switch (randomNumber) {
            case 1:
                Console.printSlowly("Voce encontrou uma pocao de vida no chao apos derrotar o monstro.");
                addPotion("LIFE");
                
                break;
            case 2:
                Console.printSlowly("Voce encontrou duas pocoes de vida no chão após derrotar o monstro");
                addPotion("LIFE");
                addPotion("LIFE");
                break;
            case 3:
                Console.printSlowly("Voce encontrou uma pocao de mana no chao apos derrotar o monstro");
                addPotion("MANA");
                break;
            case 4:
                Console.printSlowly("Voce encontrou uma pocao de mana no chao apos derrotar o monstro");
                addPotion("MANA");
                addPotion("MANA");
                break;
            case 5:
                Console.printSlowly("Voce nao encontrou nada apos derrotar o monstro");
                break;
            case 6:
                Console.printSlowly("Voce nao encontrou nada apos derrotar o monstro");
                break;

            default:
                break;
        }
        Console.readString("");
    }
}
