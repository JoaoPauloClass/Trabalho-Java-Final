package view;

import java.io.IOException;

import controller.FloorController;
import controller.PlayerDataController;
import controller.PotionBag;
import model.Floor;
import model.player.Player;

public abstract class GameSystem {

    public static void execute() {

        try {
            game();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Player mainMenu() {

        Player tempPlayer;
        Console.printSlowly("\033c\t\t\t\t\tGame name");

        do {
            Console.printSlowly("\n\n\n1) Novo jogo\n");
            Console.printSlowly("2) Carregar jogo\n");

            int op = Console.readInt(">> ");

            switch (op) {
                case 1:
                    int op2;
                    do {
                        Console.printSlowly(
                                "Iniciar um novo jogo apagará os dados do antigo.\n Tem certeza ?\n1) Sim\n2) Não\n");
                        op2 = Console.readInt(">> ");

                        if (op2 == 1 || op2 == 2) {
                            break;
                        }

                    } while (true);

                    if (op2 == 1) {
                        tempPlayer = createNewPlayer();
                        return tempPlayer;
                    }
                    break;
                case 2:
                    tempPlayer = loadPlayer();
                    return tempPlayer;
                default:
                    Console.printSlowly("Opção inválida, tente novamente");
                    break;
            }
        } while (true);

    }

    private static void initialize() {
        try {
            FloorController.initializeFloor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PotionBag.initialize();
    }

    private static void introduction() {

        System.out.println("\033c");
        Console.printSlowly("Você acorda em um calabouço úmido e escuro, sem memória de como chegou ali.\n");
        Console.printSlowly(
                "As paredes de pedra fria ecoam com os sons de criaturas rastejantes e correntes arrastando. Com cada movimento cauteloso, você percebe que está preso neste labirinto de terror. Você deve confiar em sua astúcia e força para sobreviver aos horrores que se escondem nas sombras e encontrar uma maneira de escapar da dungeon que agora é sua prisão.\n");
    }

    private static Player createNewPlayer() {

        introduction();

        Console.printSlowly("\n\n\nQual seu nome, bravo guerreiro?\n");
        String name = Console.readString(">> ");

        int op = 0;

        System.out.printf("Qual sua classe %s ?%n", name);

        do {
            Console.printSlowly("1) Guerreiro\n2) Assassino\n3) Mago\n");
            op = Console.readInt(">> ");

            if (op > 0 && op < 4) {
                break;
            }

            Console.printSlowly("Opção inválida, tente novamente");
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

    private static Player loadPlayer() {

        Player player = new Player();
        try {
            player = PlayerDataController.loadPlayerData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (player.getName() == null) {
            player = createNewPlayer();
        }

        return player;
    }

    private static void game() throws Exception {
        initialize();
        Player player = mainMenu();

        for (int i = 0; i < FloorController.getNumberOfFloors(); i++) {
            i = player.getFloorNumber() - 1;
            Floor actualFloor;
            actualFloor = FloorController.getFloor(player.getFloorNumber());

            System.out.println("\033c");
            Console.printSlowly(actualFloor.getName() + "\n");
            Console.printSlowly(actualFloor.getDescription() + "\n");

            player.floorUp();

            if (!saveMenu(player)) {
                return;
            }
        }

    }

    private static boolean saveMenu(Player player) throws IOException {
        boolean continuar = true;
        int op;
        do {
            System.out.println("\033c");
            Console.printSlowly(
                    "Deseja salvar seu jogo ?\n1) Salvar e continuar\n2) Salvar e sair\n3) Continuar sem salvar\n");
            op = Console.readInt(">> ");

            switch (op) {
                case 1:
                    PlayerDataController.savePlayerData(player);
                    System.out.println("\033c");
                    Console.printSlowly("Jogo salvo");
                    break;
                case 2:
                    PlayerDataController.savePlayerData(player);
                    System.out.println("\033c");
                    Console.printSlowly("Jogo salvo");
                    continuar = false;
                    break;
                case 3:
                    break;
                default:
                    Console.printSlowly("Opção inválida.");
                    break;
            }

            if (op == 1 || op == 2 || op == 3) {
                break;
            }
        } while (true);

        return continuar;

    }
}
