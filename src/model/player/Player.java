package model.player;


import java.util.ArrayList;
import controller.HabilityController;
import model.Hability;
import view.Color;
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
    private String playerClass;
    private boolean introduction;
    private ArrayList<Hability> habilities;
    //private PotionBag inventario;
    //private Armor armor;

    public Player(String name,String playerClass) {
        this.name = name;
        this.playerClass = playerClass;

        if (playerClass == "MAGO") {
            attack = 11;
            defense = 7;
            heathy = 10;
            mana = 13;
            agility = 9;
            tooling = "Cajado do iniciante";
            floor = 5;
            
        }
        else if(playerClass == "GUERREIRO"){
            attack = 12;
            defense = 12;
            heathy = 11;
            mana = 8;
            agility = 7;
            tooling = "Espada do iniciante";
          
        }else{
            attack = 11;
            defense = 8;
            heathy = 8;
            mana = 11;
            agility = 12;
            tooling = "Adagas de iniciante";
 
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

        //Clear console
        System.out.println("\033c");
        System.out.print("\n\nAtaque: " + attack);
        System.out.println("\tDefesa: " + defense);
        System.out.print("Vida: " + heathy);

        if (playerClass == "MAGO") {
            System.out.println("\tmana: " + mana);    
        }
        else{
            System.out.println("\tenergia: "+ mana);
        }

        System.out.print("Agilidade: " + agility);
        System.out.println("\tArma: " + tooling);

        Console.readInt("Deseja voltar ?\n" + "1-Voltar\n");
        
    }

    public void addPoints() throws Exception{
        //Clear console
        System.out.println("\033c");

        while (points != 0){

        System.out.print("\n\nAtaque:    " + 
                        Color.getBrightRed()+ attack + 
                        Color.getBrightYellow() + " +" + points + 
                        Color.getResetColor());
                        
        System.out.print("\t\tDefesa: "+
                        Color.getBrightBlack() + defense + 
                        Color.getBrightYellow()+ " +" + points + 
                        Color.getResetColor() +"\n");
        System.out.print("Vida:      " +
                        Color.getBrightGreen() +  heathy + 
                        Color.getBrightYellow() + " +" + points + 
                        Color.getResetColor());

        if (playerClass == "MAGO") {
            System.out.print("\t\tmana: "+ 
                            Color.getBlue() + mana+ 
                            Color.getBrightYellow() + " +" + points + 
                            Color.getResetColor() + "\n");    
        }
        else{
            System.out.print("\t\tenergia: " + mana + 
                        Color.getBrightYellow()+ " +" + points + 
                        Color.getResetColor() + "\n");
        }

        System.out.print("Agilidade: "+ 
                        Color.getCyan() + agility + 
                        Color.getBrightYellow() + " +" + points + 
                        Color.getResetColor());
        
        int choice = Console.readInt("\n\nEscolha onde será colocado seus pontos: ");

        readPoints(choice);
        points--;

    }
    throw new Exception("Não há pontos disponiveis");
    
    }

    
    public void habilities(){

    if (playerClass == "MAGO") {
        try {
            habilities = HabilityController.initializeWizardHability();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }else if (playerClass == "GUERREIRO") {
        try {
            habilities = HabilityController.initializeWarriorHability();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }else {
        try {
            habilities = HabilityController.initializeAssassinHability();
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
    public void showHabilities(){
        
        int mostrar =1;
        for(Hability a: habilities){
            System.out.print(mostrar++ + " ");
        System.out.println(a);    
        
    }
}

    public void inventario(){
        
     
        
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
                heathy++;
               
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


}
