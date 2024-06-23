package view;

import model.monster.Monster;
import model.player.Player;

public class GraphicalCombatSystem {

    public static int mana = 10;
    public static int damage = 10;
    public static int life = 10;
    public static void MonsterBattle(Monster monster) {

        int lifeBar = 10;
        // Clear console
        System.out.println("\033c");
        // Line 1

        System.out.print("\t\t\t\t");
        for (int i = 0; i < 27; i++)
            System.out.print("-");

        System.out.print("\n\t\t\t\t|  ");
        String monsterName = monster.getName();

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

        if (lifeBar != damage) {
            for (int i = 0; i < damage; i++)
                System.out.print("|");
            System.out.print(Color.getBlack());
            lifeBar -= damage;
            for (int i = 0; i < lifeBar; i++)
                System.out.print("|");
        } else {
            for (int i = 0; i < damage; i++)
                System.out.print("|");
        }

        System.out.print(Color.getResetColor());
        System.out.println(")   |");
        System.out.print("\t\t\t\t");

        // Line 4
        for (int i = 0; i < 27; i++)
            System.out.print("-");
        System.out.println(" ");
    }

    public static void lifeBarPlayer(Player player) {

        int lifeBar = 10;

        // Line 1
        System.out.print("\t\t\t\t");

        for (int i = 0; i < 30; i++)
            System.out.print("-");

        System.out.print("\n\t\t\t\t|  ");
        String playerName = player.getName();

        // Line 2
        for (int i = 0; i < 26; i++) {
            System.out.print(" ");

            if (i == 0) {
                for (char c : playerName.toCharArray()) {
                    System.out.print(c);
                    i++;
                }
            }
        }
        System.out.println("|");

        // Line 3
        System.out.print(" \t\t\t\t|");
        System.out.print("\thp:(" + Color.getGreen());

        if (lifeBar != life) {
            for (int i = 0; i < life; i++)
                System.out.print("|");
            System.out.print(Color.getBlack());
            lifeBar -= life;
            for (int i = 0; i < lifeBar; i++)
                System.out.print("|");
        } else {
            for (int i = 0; i < life; i++)
                System.out.print("|");
        }

        System.out.print(Color.getResetColor() + ")");
        int cont = 0;


        //Pega o tamanho os caracteres do inteiro tranforma em String para printar na tela de forma automatica sem precisar ficar mudando o tamanho
        //Manualmente
        for (int j = 0; j < 5; j++) {
            if (cont == 0) {
                String gethealth = String.valueOf(player.getHealth());
                String maxhealth = String.valueOf(player.getMaxHealth());
                for (char c : gethealth.toCharArray()) {
                    System.out.print(c);
                    j++;
                }

                System.out.print("/");
                for (char c : maxhealth.toCharArray()) {
                    System.out.print(c);
                    j++;
                }
                cont++;
            }
            System.out.print(" ");
        }

        System.out.println("|");
    }

    public static void manaBarPlayer(Player player) {
        int manaBar = 10;
        if (player.getPlayerClass() == "MAGO") {
            wizardMana(player);
        }

        // Energy
        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(" + Color.getYellow());

        if (manaBar != mana) {
            for (int i = 0; i < mana; i++) {
                System.out.print("|");

            }
            System.out.print(Color.getBlack());
            manaBar -= mana;
            for (int i = 0; i < manaBar; i++) {
                System.out.print("|");

            }
            System.out.print(Color.getResetColor() + ")");
        } else {
            for (int i = 0; i < mana; i++) {
                System.out.print("|");

            }
            System.out.print(Color.getResetColor() + ")");
        }
        int cont = 0;
        for (int j = 0; j < 5; j++) {
            if (cont == 0) {
                String getmana = String.valueOf(player.getMana());
                String maxmana = String.valueOf(player.getMaxMana());
                for (char c : getmana.toCharArray()) {
                    System.out.print(c);
                    j++;
                }

                System.out.print("/");
                for (char c : maxmana.toCharArray()) {
                    System.out.print(c);
                    j++;
                }
                cont++;

            }
            System.out.print(" ");
        }

        System.out.println("|");
        System.out.print("\t\t\t\t");

        // Line 5

        for (int i = 0; i < 30; i++)
            System.out.print("-");

    }

    public static void wizardMana(Player player) {
        // Mana

        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(" + Color.getBlue());

        int manaBar = 10;

        if (manaBar != mana) {
            for (int i = 0; i < mana; i++)
                System.out.print("|");

            System.out.print(Color.getBlack());
            manaBar -= mana;
            for (int i = 0; i < manaBar; i++)
                System.out.print("|");

            System.out.print(Color.getResetColor() + ")");
        } else {
            for (int i = 0; i < mana; i++) {
                System.out.print("|");

            }
            System.out.print(Color.getResetColor() + ")");
        }
        int cont = 0;
        for (int j = 0; j < 5; j++) {
            if (cont == 0) {
                String getmana = String.valueOf(player.getMana());
                String maxmana = String.valueOf(player.getMaxMana());
                for (char c : getmana.toCharArray()) {
                    System.out.print(c);
                    j++;
                }
                System.out.print("/");
                for (char c : maxmana.toCharArray()) {
                    System.out.print(c);
                    j++;
                }
                cont++;
            }
            System.out.print(" ");
        }

        System.out.println("|");
        System.out.print("\t\t\t\t");

        // Line 5
        for (int i = 0; i < 30; i++)
            System.out.print("-");

    }

    public static void playerTable(Player player) {

        lifeBarPlayer(player);
        manaBarPlayer(player);

    }

    public static int playerOption() {

        System.out.println("\nEscolha uma ação: \n" +
                "1- Ataque\t" + "2- habilidade\n" +
                "3-Inventario\t" + "4-Desistir");
        return Console.readInt("Ação: ");

    }

    public static int playerHabilities(Player player) throws Exception {


        System.out.println("\033c");
        player.showHabilities();

        int select = Console.readInt("\n\nSelecione uma habilidade ou selecione 0 para voltar: ");
        //Volta ou lança uma excessão para selecionar a habilidade novamente

        if (select == 0) {
            return 0;
        } else if (select > 3) {
            throw new Exception("Digite um valor valido");
        }
        return select;
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

    public static int playerInvetory(Player player) throws Exception {
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


            int temp = Console.readInt("\n\nSelecione uma habilidade: ");
            if (temp < 0 || temp > 3) {
                throw new Exception("Valor invalido selecione um valor válido");
            }
            return temp;

        }

        System.out.println("    _______________       __________________");
        System.out.println("1- |" +
                Color.getPurple() + " Poção de vida " +
                Color.getResetColor() + "|  2- |" +
                Color.getBrightYellow() + " Poção de energia " +
                Color.getResetColor() + "|");
        System.out.println("    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

        int temp = Console.readInt("\n\nSelecione 1 poção: ");
        if (temp < 0 || temp > 3) {
            throw new Exception("Valor invalido selecione um valor válido");
        }

        return temp;
    }

    public static int readAction(int action, Player player, Monster monster) {

        switch (action) {
            case 1:
                try {
                    player.attack(monster);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return 0;

            case 2:
                while (true) {
                    try {
                        return playerHabilities(player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Console.readString("Pressione enter para prosseguir: ");
                    }
                }
            case 3:
            while (true) {
                
            
                try{
                return playerInvetory(player);

                }catch(Exception e){
                    System.out.println(e.getMessage());
                    Console.readString("Pressione enter para prosseguir: ");
                }
            }
            case 4:
                playerGiveUp();
                return 0;
            default:
                Console.printSlowly("Essa opção nao existe!");
                return 0;
        }

    }

    

    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int damage) {
        GraphicalCombatSystem.damage = damage;
    }

    public static int getMana() {
        return mana;
    }

    public static void setMana(int mana) {
        GraphicalCombatSystem.mana = mana;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        GraphicalCombatSystem.life = life;
    }
}
