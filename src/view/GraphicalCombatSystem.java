package view;

import model.monster.Monster;
import model.player.Player;

public class GraphicalCombatSystem {

    public static int mana = 10;
    public static int damage = 10;
    public static int life = 10;

    //Gera a tabela de vida do monstro
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


        if (damage <= 0) {
            damage = 1;
        }
        //Pega o tamanho os caracteres do inteiro tranforma em String para printar na tela de forma automatica sem precisar ficar mudando o tamanho
        //Manualmente
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



    //Gera a tabela de vida do life
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

        if (life <= 0) {
            life = 1;
        }

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
    //Cria outra parte da tabela do player versão guerreiro ou assassino
    public static void manaBarPlayer(Player player) {
        int manaBar = 10;
        if (player.getPlayerClass() == "MAGO") {
            wizardMana(player);
            return;
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
    //Gera segunda parte da tabela do mago
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
