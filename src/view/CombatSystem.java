package view;

import model.player.Player;

public class CombatSystem {
    
    public static final String GREEN = "\u001B[32m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void MonsterBattle(Player p){

        //Line 1
        System.out.print("\t\t\t\t");
        for(int i = 0; i < 27; i++)
            System.out.print("-");
        
        System.out.print("\n\t\t\t\t|  ");
        String monsterName = p.getName();

        //Line 2
        for(int i =0; i < 23;i++){
            System.out.print(" ");
            if (i == 0) {
                for(char c: monsterName.toCharArray()){
                    System.out.print(c);
                    i++;
                }
            }  
        }
        System.out.println("|");

        //Line 3
        System.out.print(" \t\t\t\t|");
        System.out.print("\thp:(" + GREEN);
    
        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(RESET_COLOR);

        System.out.println(")   |");
        System.out.print("\t\t\t\t");
        //Line 4
        for(int i = 0; i < 27; i++)
            System.out.print("-");
}
        
    public static void playerTable(Player p){
        //Line 1
        System.out.print("\t\t\t\t");
        for(int i = 0; i < 27; i++)
            System.out.print("-");
        
        System.out.print("\n\t\t\t\t|  ");
        String monsterName = p.getName();

        //Line 2
        for(int i =0; i < 23;i++){
            System.out.print(" ");

            if (i == 0) {
                for(char c: monsterName.toCharArray()){
                    System.out.print(c);
                    i++;
                }
            }  
        }
        System.out.println("|");

        //Line 3
        System.out.print(" \t\t\t\t|");
        System.out.print("\thp:(" + GREEN);
    
        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(RESET_COLOR);

        System.out.println(")   |");
        
        //Line 4
        if (p.getPlayerClass() == "MAGO") {
                System.out.print(" \t\t\t\t|");
                System.out.print("\tsp:(" + BLUE);
            
            for (int i = 0; i < 10; i++)
                System.out.print("|");
            System.out.print(RESET_COLOR);

            System.out.println(")   |");
            System.out.print("\t\t\t\t");
                
                //Line 5
            for(int i = 0; i < 27; i++)
                System.out.print("-");
            return;
            }

        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(" + YELLOW);

        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(RESET_COLOR);

        System.out.println(")   |");
        System.out.print("\t\t\t\t");
        //Line 5
        for(int i = 0; i < 27; i++)
            System.out.print("-");
        }

    public static void playerOption(){



    }
}
