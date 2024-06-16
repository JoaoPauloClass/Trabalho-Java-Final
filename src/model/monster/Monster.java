package model.monster;

public abstract class Monster {

    String name;
    int attack;
    int defense;
    int heathy;
    int agility;

    public void showStatus(){

        System.out.println("\n\nMonstro: " + name);
        System.out.print("\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + heathy);
        System.out.print("\tAgilidade: " + agility);

    }

    

    public abstract void atacar();

    public abstract String getSprite();

    public Monster(String name, int attack, int defense, int heathy, int agility) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.heathy = heathy;
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

    public int getHeathy() {
        return heathy;
    }

    public void setHeathy(int heathy) {
        this.heathy = heathy;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }


    
}
