package model.player;

import java.util.ArrayList;

import view.Console;

public class Player {

    
    private int attack;
    private int defense;
    private int heathy;
    private int agility;
    private int mana;
    private int floor;
    private int points;
    private String tooling;
    private String name;
    private String classe;
    private boolean introduction;
    //private ArrayList<habibily> habibilies;
    //private PotionBag inventario;
    //private Armor armor;

    public Player(String name,String classe) {
        this.name = name;
        this.classe = classe;

        if (classe == "MAGO") {
            attack = 11;
            defense = 7;
            heathy = 10;
            mana = 13;
            agility = 9;
            tooling = "Cajado do iniciante";
            points = 2;
            
            
        }
        else if(classe == "GUERREIRO"){
            attack = 12;
            defense = 12;
            heathy = 11;
            mana = 8;
            agility = 7;
            tooling = "Espada do iniciante";
            points = 0;

        }else{
            attack = 11;
            defense = 8;
            heathy = 8;
            mana = 11;
            agility = 12;
            tooling = "Adagas de iniciante";
            points = 0;
        }
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

    
    public void showStatus(){

        System.out.print("\n\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + heathy);
        if (classe == "MAGO") {
            System.out.println("\tmana: " + mana);    
        }else{
            System.out.println("\tenergia: "+ mana);
        }
        System.out.print("Agilidade: " + agility);
        System.out.println("\tArma: " + tooling);
        
    }

    public void addPoints() throws Exception{

        while (points != 0){

        System.out.print("\n\nAtaque: " + attack + " +" + points);
        System.out.println("\t\tDefesa: " + defense + " +" + points);
        System.out.print("Vida: " + heathy + " +" + points);
        if (classe == "MAGO") {
            System.out.println("\t\tmana: " + mana + " +" + points);    
        }else{
            System.out.println("\tenergia: "+ mana + " +" + points);
        }
        System.out.print("Agilidade: " + agility + " +" + points);
        System.out.println("\t\tArma: " + tooling + " +" + points);
        points--;

    }

    throw new Exception("Não há pontos disponiveis");
        
        
    }

    public void inventario(){}

    
}
