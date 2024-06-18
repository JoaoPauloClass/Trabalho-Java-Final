package model.player;

import java.util.ArrayList;
import controller.HabilityController;
import controller.PotionBag;
import model.Armor;
import model.Hability;
import view.Color;
import view.Console;

public class Player implements Cloneable {

    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private int agility;
    private int mana;
    private int maxMana;
    private int floor;
    private int points;
    private String tooling;
    private String name;
    private String playerClass;
    private boolean introduction;
    private ArrayList<Hability> habilities;
    private Armor armor;

    public Player() {
    }

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;

        if (playerClass == "MAGO") {
            attack = 11;
            defense = 7;
            health = 10;
            maxHealth = 10;
            mana = 13;
            maxMana = 13;
            agility = 9;
            tooling = "Cajado do iniciante";
            floor = 5;
            try {
                habilities = HabilityController.initializeWizardHability();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            };

        } else if (playerClass == "GUERREIRO") {
            attack = 12;
            defense = 12;
            health = 11;
            maxHealth = 11;
            mana = 8;
            maxMana = 8;
            agility = 7;
            tooling = "Espada do iniciante";
            points = 0;
            try {
                habilities = HabilityController.initializeWarriorHability();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            };

        } else {

            attack = 11;
            defense = 8;
            health = 8;
            maxHealth = 8;
            mana = 11;
            agility = 12;
            tooling = "Adagas de iniciante";
            try {
                habilities = HabilityController.initializeAssassinHability();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            };

        }
    }

    public ArrayList<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(ArrayList<Hability> habilities) {
        this.habilities = habilities;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int heathy) {
        this.health = heathy;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getToling() {
        return tooling;
    }

    public void setToling(String toling) {
        this.tooling = toling;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTooling() {
        return tooling;
    }

    public void setTooling(String tooling) {
        this.tooling = tooling;
    }

    public boolean isIntroduction() {
        return introduction;
    }

    public void setIntroduction(boolean introduction) {
        this.introduction = introduction;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void showStatus() {

        // Clear console
        System.out.println("\033c");
        System.out.print("\n\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + health);
        if (playerClass == "MAGO") {

            System.out.println("\tmana: " + mana);
        } else {
            System.out.println("\tenergia: " + mana);
        }

        System.out.print("Agilidade: " + agility);
        System.out.println("\tArma: " + tooling);

        Console.readInt("Deseja voltar ?\n" + "1-Voltar\n");

    }

    public void addPoints() throws Exception {
        // Clear console
        System.out.println("\033c");

        while (points != 0) {

            System.out.print("\n\nAtaque:    " +
                    Color.getBrightRed() + attack +
                    Color.getBrightYellow() + " +" + points +
                    Color.getResetColor());

            System.out.print("\t\tDefesa: " +
                    Color.getBrightBlack() + defense +
                    Color.getBrightYellow() + " +" + points +
                    Color.getResetColor() + "\n");
            System.out.print("Vida:      " +
                    Color.getBrightGreen() + health +
                    Color.getBrightYellow() + " +" + points +
                    Color.getResetColor());

            if (playerClass == "MAGO") {
                System.out.print("\t\tmana: " +
                        Color.getBlue() + mana +
                        Color.getBrightYellow() + " +" + points +
                        Color.getResetColor() + "\n");
            } else {
                System.out.print("\t\tenergia: " + mana +
                        Color.getBrightYellow() + " +" + points +
                        Color.getResetColor() + "\n");

            }

            System.out.print("Agilidade: " +
                    Color.getCyan() + agility +
                    Color.getBrightYellow() + " +" + points +
                    Color.getResetColor());

            int choice = Console.readInt("\n\nEscolha onde será colocado seus pontos: ");

            readPoints(choice);
            points--;

        }
        throw new Exception("Não há pontos disponiveis");

    }

    public void habilities() {

        if (playerClass == "MAGO") {
            try {
                habilities = HabilityController.initializeWizardHability();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass == "GUERREIRO") {
            try {
                habilities = HabilityController.initializeWarriorHability();

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

        } else {
            try {
                habilities = HabilityController.initializeAssassinHability();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void showHabilities() {

        int mostrar = 1;
        for (Hability a : habilities) {
            System.out.print(mostrar++ + " ");
            System.out.println(a);

        }
    }

    public void readPoints(int choice) {

        switch (choice) {
            case 1:
                attack++;

                break;
            case 2:
                defense++;

                break;
            case 3:

                health++;

                break;
            case 4:
                mana++;

                break;
            case 5:
                agility++;

                break;
            default:
                System.out.println("Nao existe");
                break;
        }
    }

    public void useHealingPotion() throws Exception {

        if (health == maxHealth) {
            throw new Exception("Sua vida está cheia, não há necessidade de usar");
        } else {
            PotionBag.usePotion("LIFE");
            health += 2;
        }

    }

    public void useManaPotion() throws Exception {
        if (mana == maxMana) {
            throw new Exception("Sua energia está cheia, não há necessidade de usar");
        } else {
            PotionBag.usePotion("MANA");
            mana += 2;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

}
