package model.monster;

import model.Attack;
import model.monster.boss.DemonKing;
import model.monster.boss.Minotaur;
import model.player.Player;

public abstract class Monster implements Attack {

    // TODO: implementar interface atacar.
    // TODO: implementar metodo para dodge

    protected String name;
    protected int attack;
    protected int defense;
    protected int health;
    protected int agility;

    public abstract void attack(Player player) throws Exception;

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

    public Monster(String name, int attack, int defense, int heathy, int agility) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = heathy;
        this.agility = agility;
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
