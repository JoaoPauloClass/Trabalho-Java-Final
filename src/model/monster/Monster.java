package model.monster;


import model.Attackable;
import model.monster.boss.DemonKing;
import model.monster.boss.Minotaur;

public abstract class Monster implements Attackable {

    protected String name;
    protected int attack;
    protected int defense;
    protected int health;
    protected int agility;
    protected int maxHealth;

    public void showStatus() {

        System.out.println("\n\nMonstro: " + name);
        System.out.print("\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + health);
        System.out.print("\tAgilidade: " + agility);
    }

    public abstract String getSprite();
    
    public Monster() {
    }

    public Monster(String name, int attack, int defense, int health, int agility, int maxHealth) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.agility = agility;
        this.maxHealth = maxHealth;
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

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public static Monster createMonster(String line) throws Exception{

        Monster tempMonster;

        switch (line) {
            case "GARGOYLE":
                tempMonster = new Gargoyle();
                break;
            case "CERBERUS":
                tempMonster = new Cerberus();
                break;
            case "LICH":
                tempMonster = new Lich();
                break;
            case "ORC":
                tempMonster = new Orc();
                break;
            case "SKELETON":
                tempMonster = new Skeleton();
                break;
            case "SLIME":
                tempMonster = new Slime();
                break;
            case "VAMPIRE":
                tempMonster = new Vampire();
                break;
            case "WOLF":
                tempMonster = new Wolf();
                break;
            case "DEMONKING":
                tempMonster = new DemonKing();
                break;
            case "MINOTAUR":
                tempMonster = new Minotaur();
                break;
            default:
                throw new Exception("Erro no txt, não foi informado o tipo do monstro");

        }

        return tempMonster;
    }

    

}
