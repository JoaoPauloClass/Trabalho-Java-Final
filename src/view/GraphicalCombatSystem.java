package view;


import model.player.Player;

public class GraphicalCombatSystem {

    public static int vida = 10;
    public static int lifeBar = 10;
    public static int manaBar = 10;

    public static void MonsterBattle(Player p) {

        // Clear console
        System.out.println("\033c");
        // Line 1

        System.out.print("\t\t\t\t");
        for (int i = 0; i < 27; i++)
            System.out.print("-");

        System.out.print("\n\t\t\t\t|  ");
        String monsterName = p.getName();

        // Line 2
        for (int i = 0; i < 23; i++) {
            System.out.print(" ");
            if (i == 0) {
                for (char c : monsterName.toCharArray()) {
                    System.out.print(c);
                    i++;
                }
            }
        }
        System.out.println("|");

        // Line 3
        System.out.print(" \t\t\t\t|");
        System.out.print("\thp:(" + Color.getGreen());

        for (int i = 0; i < 10; i++)
            System.out.print("|");

        System.out.print(Color.getResetColor());
        /*
         * if (lifeBar_slime != vida) {
         * lifeBar_slime -= vida;
         * for (int i = 0; i < lifeBar_slime; i++) {
         * System.out.print("|");
         * 
         * }
         */
        System.out.println(")   |");
        System.out.print("\t\t\t\t");
        
        // Line 4
        for (int i = 0; i < 27; i++)
            System.out.print("-");
        System.out.println(" ");
    }

    public static void lifeBarPlayer(Player p, int damage) {

        // vida -= damage;
        // Line 1
        System.out.print("\t\t\t\t");

        for (int i = 0; i < 27; i++)
            System.out.print("-");

        System.out.print("\n\t\t\t\t|  ");
        String monsterName = p.getName();

        // Line 2
        for (int i = 0; i < 23; i++) {
            System.out.print(" ");

            if (i == 0) {
                for (char c : monsterName.toCharArray()) {
                    System.out.print(c);
                    i++;
                }
            }
        }
        System.out.println("|");

        // Line 3
        System.out.print(" \t\t\t\t|");
        System.out.print("\thp:(" + Color.getGreen());

        if (lifeBar != vida) {
            System.out.print(Color.getBlack());
            lifeBar -= vida;
            for (int i = 0; i < lifeBar; i++)
                System.out.print("|");
        } else {
            for (int i = 0; i < lifeBar; i++)
                System.out.print("|");
        }
        System.out.println(Color.getResetColor() + ")   |");

    }
    public static void manaBarPlayer(Player p,int mana) {
        
        // Energy
        
        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(" + Color.getYellow());

        manaBar = 10;
        
        if (manaBar != mana) {
            for (int i = 0; i < mana; i++)
                System.out.print("|");
            System.out.print(Color.getBlack());
            manaBar -= mana;
            for (int i = 0; i < manaBar; i++)
                System.out.print("|");
        } else {
            for (int i = 0; i < mana; i++)
                System.out.print("|");
        }

        System.out.println(Color.getResetColor() + ")   |");
        System.out.print("\t\t\t\t");
        // Line 5
        for (int i = 0; i < 27; i++)
            System.out.print("-");

    }

    /*
     * 
     * //Mana
     * if (p.getPlayerClass() == "MAGO") {
     * System.out.print(" \t\t\t\t|");
     * System.out.print("\tsp:(" + Color.getBlue());
     * 
     * for (int i = 0; i < mana; i++)
     * System.out.print("|");
     * 
     * if (manaBar != mana) {
     * System.out.print(Color.getBlack());
     * manaBar -= mana;
     * for (int i = 0; i < manaBar; i++)
     * System.out.print("|");
     * }
     * else{
     * for (int i = 0; i < manaBar; i++)
     * System.out.print("|");
     * }
     * 
     * System.out.println(Color.getResetColor()+")   |");
     * System.out.print("\t\t\t\t");
     * 
     * //Line 5
     * for(int i = 0; i < 27; i++)
     * System.out.print("-");
     * return;
     * }
     */
    public static void playerTable(Player p, int damage,int mana) {

        lifeBarPlayer(p, damage);
        manaBarPlayer(p, mana);

    }

    public static int playerOption() {

        System.out.println("\nEscolha uma ação: \n" +
                "1- Ataque\t" + "2- habilidade\n" +
                "3-Inventario\t" + "4-Desistir");
        return Console.readInt("Ação: ");

    }

    public static int playerHabilities(Player player) {
        
        System.out.println("\033c");
        player.showHabilities();
        return Console.readInt("\n\nSelecione uma habilidade ou selecione 0 para sair: ");

    }

    public static void playerGiveUp() {
        // Clear console
        System.out.println("\033c");

        int sair = Console.readInt("Você tem certeza que quer desistir ? \n" +
                "1-Sim\n" +
                "2-Não\n" +
                "Escolha uma opção: ");
        if (sair == 1) {
            System.exit(0);
        }
    }

    public static int playerInvetory(Player player) {
        // Clean console
        System.out.println("\033c");

        // Create inventory
        System.out.println("_______________");
        System.out.println("Inventario:\n");

        if (player.getPlayerClass() == "MAGO") {
            System.out.println("    _______________       _______________");
            System.out.println("1- |" +
                    Color.getPurple() + " Poção de vida " +
                    Color.getResetColor() + "|  2- |" +
                    Color.getBrightBlue() + " Poção de mana " +
                    Color.getResetColor() + "|");
            System.out.println("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            return Console.readInt("\n\nSelecione uma habilidade: ");

        }

        System.out.println("    _______________       __________________");
        System.out.println("1- |" +
                Color.getPurple() + " Poção de vida " +
                Color.getResetColor() + "|  2- |" +
                Color.getBrightYellow() + " Poção de energia " +
                Color.getResetColor() + "|");
        System.out.println("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        return 10 + Console.readInt("\n\nSelecione 1 poção: ");
    }

    public static int readAction(int action, Player player) {

        switch (action) {
            case 1:
                return 0;

            case 2:
                return playerHabilities(player);

            case 3:
                return playerInvetory(player);

            case 4:
                playerGiveUp();
                return 0;
            default:
                System.out.println("Essa opção nao existe!");
                return 0;
        }
    }
}
