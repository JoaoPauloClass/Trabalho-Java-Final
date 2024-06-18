package view;

import model.player.Player;

public class GraphicalCombatSystem {
    
    public static void MonsterBattle(Player p){
        //Clear console
        System.out.println("\033c");
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
            System.out.println(" ");
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
                            "1- Ataque\t"    + "2- habilidade\n" + 
                            "3-Inventario\t" + "4-Desistir");
        return Console.readInt("Ação: ");
        
    }

    public static void playerHabilities(Player player){
        //Clear console
        System.out.println("\033c");

        player.showHabilities();
        Console.readInt("\n\nSelecione uma habilidade: ");
        
    }   

    public static void playerGiveUp(){
        //Clear console
        System.out.println("\033c");

        int sair = Console.readInt("Você tem certeza que quer desistir ? \n" +
                                    "1-Sim\n" + 
                                    "2-Não\n" +
                                    "Escolha uma opção: ");
        if (sair == 1) {
            System.exit(0);
}
    }



    public static void playerInvetory(Player player){
        //Clean console
        System.out.println("\033c");

        //Create inventory
        System.out.println("_______________");
        System.out.println("Inventario:\n");
        
        if (player.getPlayerClass() == "MAGO") {
            System.out.println("    _______________       _______________");
            System.out.println("1- |" + 
                                Color.getPurple() + " Poção de vida "+
                                Color.getResetColor() + "|  2- |" + 
                                Color.getBrightBlue() + " Poção de mana " + 
                                Color.getResetColor() + "|");
            System.out.println("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            Console.readInt("\n\nSelecione uma habilidade: ");
            return;
        }

        System.out.println("    _______________       __________________");
        System.out.println("1- |" + 
                            Color.getPurple() + " Poção de vida "+
                            Color.getResetColor() + "|  2- |" + 
                            Color.getBrightYellow() + " Poção de energia " + 
                            Color.getResetColor() + "|");
        System.out.println("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        Console.readInt("\n\nSlecione 1 para voltar: ");
    }
    public static void readAction(int action, Player player){
        
        switch (action) {
            case 1:
               
                break;
            case 2:
                playerHabilities(player);
                break;
            case 3:
               playerInvetory(player);
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
