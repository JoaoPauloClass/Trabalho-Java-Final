package view;

import model.monster.Monster;
import model.player.Player;

public class GraphicalCombatSystem {

    public static int mana = 10;
    public static int damage = 10;
    public static int life = 10;

    // Gera a tabela de vida do monstro
    public static void MonsterBattle(Monster monster) {

        int lifeBar = 10;
        // Clear console
        System.out.println("\033c");
        // Line 1

        System.out.print("\t\t\t\t");
        for (int i = 0; i < 30; i++)
            System.out.print("-");

        System.out.print("\n\t\t\t\t|  ");
        String monsterName = monster.getName();

        // Line 2
        for (int i = 0; i < 26; i++) {
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

        System.out.print("\thp:(");

        if (damage <= 0) {
            damage = 1;
        }
        // Verifica se a vida é menor que 5 barras se for fica amarelo se for menor que
        // 3 fica vermelho
        if (lifeBar != damage) {

            // Metade da vida (Amarelo)
            if (damage <= 6 && damage >= 3)
                System.out.print(Color.getYellow());
            // Menos da metade da vida (vermelho)
            else if (damage <= 3)
                System.out.print(Color.getRed());
            // Vida mais ou menos cheia
            else
                System.out.print(Color.getGreen());
            for (int i = 0; i < damage; i++)
                System.out.print("|");
            System.out.print(Color.getBlack());
            lifeBar -= damage;
            for (int i = 0; i < lifeBar; i++)
                System.out.print("|");
            // Vida totalmente cheia
        } else {
            System.out.print(Color.getGreen());
            for (int i = 0; i < damage; i++)
                System.out.print("|");
        }
        // Pega o tamanho os caracteres do inteiro tranforma em String para printar na
        // tela de forma automatica sem precisar ficar mudando o tamanho
        // Manualmente
        int cont = 0;
        System.out.print(Color.getResetColor() + ")");
        for (int j = 0; j < 5; j++) {
            if (cont == 0) {
                String gethealth = String.valueOf(monster.getHealth());
                String maxhealth = String.valueOf(monster.getMaxHealth());
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

        System.out.print(Color.getResetColor());
        System.out.println("|");
        System.out.print("\t\t\t\t");

        // Line 4
        for (int i = 0; i < 30; i++)
            System.out.print("-");
        System.out.println(" ");
    }

    // Gera a tabela de vida do life
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
            if (life <= 6 && life >= 3)
                System.out.print(Color.getYellow());
            // Menos da metade da vida (vermelho)
            else if (life <= 3)
                System.out.print(Color.getRed());
            // Vida mais ou menos cheia
            else
                System.out.print(Color.getGreen());
            //Gera as barras de vida
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

        // Pega o tamanho os caracteres do inteiro tranforma em String para printar na
        // tela de forma automatica sem precisar ficar mudando o tamanho
        // Manualmente
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

    // Cria outra parte da tabela do player versão guerreiro ou assassino
    public static void manaBarPlayer(Player player) {
        int manaBar = 10;
        if (player.getPlayerClass() == "MAGO") {
            wizardMana(player);
            return;
        }

        // Energy
        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(");

        if (manaBar != mana) {

            // Menos da metade da energia/mana (vermelho)
            if (mana <= 3)
                System.out.print(Color.getRed());
            // Vida mais ou menos cheia
            else
                System.out.print(Color.getYellow());
            for (int i = 0; i < mana; i++)
                System.out.print("|");

            System.out.print(Color.getBlack());
            manaBar -= mana;
            for (int i = 0; i < manaBar; i++)
                System.out.print("|");

            System.out.print(Color.getResetColor() + ")");
        } else {
            System.out.print(Color.getYellow());
            for (int i = 0; i < mana; i++)
                System.out.print("|");

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

    // Gera segunda parte da tabela do mago
    public static void wizardMana(Player player) {
        // Mana

        System.out.print(" \t\t\t\t|");
        System.out.print("\tsp:(");

        int manaBar = 10;

        if (manaBar != mana) {
            // Menos da metade da vida (vermelho)
            if (mana <= 3)
                System.out.print(Color.getRed());
            // Vida mais ou menos cheia
            else
                System.out.print(Color.getBlue());
            for (int i = 0; i < mana; i++)
                System.out.print("|");

            System.out.print(Color.getBlack());
            manaBar -= mana;
            for (int i = 0; i < manaBar; i++)
                System.out.print("|");

            System.out.print(Color.getResetColor() + ")");
        } else {
            System.out.println(Color.getBlue());
            for (int i = 0; i < mana; i++)
                System.out.print("|");
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
