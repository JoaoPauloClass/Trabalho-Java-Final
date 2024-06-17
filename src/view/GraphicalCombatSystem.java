package view;


import javax.swing.JOptionPane;

import model.player.Player;

public class GraphicalCombatSystem {
    
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
        System.out.print("\thp:(" + Color.getGreen());
    
        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(Color.getResetColor());
       /* if (lifeBar_slime != vida) {
            lifeBar_slime -= vida;
            for (int i = 0; i < lifeBar_slime; i++) {
                System.out.print("|");

            }
*/
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
        System.out.print("\thp:(" + Color.getGreen());
    
        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(Color.getResetColor());

       /* if (lifeBar_slime != vida) {
            lifeBar_slime -= vida;
            for (int i = 0; i < lifeBar_slime; i++) {
                System.out.print("|");

            }
*/
        System.out.println(")   |");
        
        //Line 4
        if (p.getPlayerClass() == "MAGO") {
                System.out.print(" \t\t\t\t|");
                System.out.print("\tsp:(" + Color.getBlue());
            
            for (int i = 0; i < 10; i++)
                System.out.print("|");
            System.out.print(Color.getResetColor());

            /* if (lifeBar_slime != vida) {
                    lifeBar_slime -= vida;
                    for (int i = 0; i < lifeBar_slime; i++) {
                        System.out.print("|");

                    }
    */
            System.out.println(")   |");
            System.out.print("\t\t\t\t");
                
                //Line 5
            for(int i = 0; i < 27; i++)
                System.out.print("-");
            return;
            }

        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(" + Color.getYellow());

        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(Color.getResetColor());
    /* if (lifeBar_slime != vida) {
            lifeBar_slime -= vida;
            for (int i = 0; i < lifeBar_slime; i++) {
                System.out.print("|");

            }
    */
        System.out.println(")   |");
        System.out.print("\t\t\t\t");
        //Line 5
        for(int i = 0; i < 27; i++)
            System.out.print("-");
        }

    public static int playerOption(){

        System.out.println("\nEscolha uma ação: \n" +
                            "1- Ataque\t" + "2- habilidade\n" + 
                            "3-Inventario\t" + "4-Desistir");
        return Console.readInt("Ação: ");
        
    }

    public static void playerHabilities(Player player){
        
        player.showHabilities();
        
    }

    public static void playerGiveUp(){

        int sair = Console.readInt("Você tem certeza que quer desistir ? \n" +
                                    "1-Sim\n" + 
                                    "2-Não\n" +
                                    "Escolha uma opção: ");
        if (sair == 1) {
            System.exit(0);
}
    }
    public static void readAction(int action, Player player){
        
        switch (action) {
            case 1:
               
                break;
            case 2:
                playerHabilities(player);
                break;
            case 3:
               // playerInvetory();
                break;
            case 4:
                playerGiveUp();
                break;
            default:
                System.out.println("Essa opção nao existe!");
                break;
        }
    }
}
