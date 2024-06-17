package model.player;

import java.util.ArrayList;

import controller.HabilityController;
import controller.PotionBag;
import model.Hability;
import view.Console;

public class Player {

    
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
    private String classe;
    private boolean introduction;
    private ArrayList<Hability> habilities;
    
    //private PotionBag inventario;
    //private Armor armor;

    public Player(String name,String classe) {
        this.name = name;
        this.classe = classe;

        if (classe == "MAGO") {
            attack = 11;
            defense = 7;
            health = 10;
            maxHealth = 10;
            mana = 13;
            maxMana = 13;
            agility = 9;
            tooling = "Cajado do iniciante";
            points = 2;
            
            
           
        }
        else if(classe == "GUERREIRO"){
            attack = 12;
            defense = 12;
            health = 11;
            maxHealth = 11;
            mana = 8;
            maxMana = 8;
            agility = 7;
            tooling = "Espada do iniciante";
            points = 0;

            
        } else {
            attack = 11;
            defense = 8;
            health = 8;
            maxHealth = 8;
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

    
    public void showStatus(){

        System.out.print("\n\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + health);
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
        System.out.print("Vida: " + health + " +" + points);
        if (classe == "MAGO") {
            System.out.println("\t\tmana: " + mana + " +" + points);    
        }else{
            System.out.println("\tenergia: "+ mana + " +" + points);
        }
        System.out.print("Agilidade: " + agility + " +" + points);
        System.out.println("\t\tArma: " + tooling + " +" + points);
        
        int choice = Console.readInt("Escolha onde será colocado seus pontos: ");

        readPoints(choice);
        points--;

    }
    

    throw new Exception("Não há pontos disponiveis");
        
        
    }
   
    public void habilities(){

        if (classe == "MAGO") {
            
        
        try {
            habilities = HabilityController.initializeWizardHability();
            for(Hability a: habilities){
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }else if (classe == "GUERREIRO") {

        try {
            habilities = HabilityController.initializeWarriorHability();
            for(Hability a: habilities){
                System.out.println(a);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }else {

        try {
            habilities = HabilityController.initializeAssassinHability();
            for(Hability a: habilities){
            System.out.println(a);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    }

    public void showHabilities(){

        for(Hability a: habilities){
            System.out.println(a);
        }
    }

    public void readPoints(int choice){

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
   
    public void useHealingPotion() throws Exception{
        
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
}
