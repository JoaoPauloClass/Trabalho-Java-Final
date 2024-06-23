package controller;

import model.monster.Monster;
import model.player.Player;
import view.Color;
import view.Console;

public class SelectOption {
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
}
