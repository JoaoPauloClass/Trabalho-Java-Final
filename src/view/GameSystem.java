package view;

import controller.FloorController;
import model.player.Player;

public abstract class GameSystem {

    public static void execute() {

        initialize();
        Player player = introduction();

        player.showStatus();
        player.showHabilities();
    }

    private static Player introduction() {

        Console.printSlowly("Você acorda em um calabouço úmido e escuro, sem memória de como chegou ali.\n", 50);
        Console.printSlowly("As paredes de pedra fria ecoam com os sons de criaturas rastejantes e correntes arrastando. Com cada movimento cauteloso, você percebe que está preso neste labirinto de terror. Você deve confiar em sua astúcia e força para sobreviver aos horrores que se escondem nas sombras e encontrar uma maneira de escapar da dungeon que agora é sua prisão.\n", 50);

        Console.printSlowly("\n\n\nQual seu nome, bravo guerreiro?\n", 50);
        String name = Console.readString(">> ");

        int op = 0;

        System.out.printf("Qual sua classe %s ?%n", name);

        do {
            Console.printSlowly("1) Guerreiro\n2) Assassino\n3) Mago\n", 50);
            op = Console.readInt(">> ");

            if (op > 0 && op < 4) {
                break;
            }

            Console.printSlowly("Opção inválida, tente novamente", 50);
        } while (true);

        String playerClass = "";
        switch (op) {
            case 1:
                playerClass = "GUERREIRO";
                break;
            case 2:
                playerClass = "ASSASSINO";
                break;
            case 3:
                playerClass = "MAGO";
                break;
            default:
                break;
        }

        return new Player(name, playerClass);
        
    }

    private static void initialize() {
      
        try {
            FloorController.initializeFloor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}