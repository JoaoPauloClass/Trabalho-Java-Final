package view;

import java.io.IOException;

import controller.ArmorController;
import controller.Battle;
import controller.FloorController;
import controller.PlayerDataController;
import controller.PotionBag;
import model.Floor;
import model.monster.Monster;
import model.player.Player;

public abstract class GameSystem {

    public static void execute() {

        try {
            game();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void game() throws Exception {
        initialize();
        Player player = mainMenu();

        for (int i = 0; i < FloorController.getNumberOfFloors(); i++) {
            i = player.getFloorNumber() - 1;
            Floor actualFloor;
            actualFloor = FloorController.getFloor(player.getFloorNumber());
            Monster actualMonster = actualFloor.getMonster();

            System.out.println("\033c");
            Console.printSlowly(actualFloor.getName() + "\n");
            Console.printSlowly(actualFloor.getDescription() + "\n");
            Console.readString("Pressione enter para continuar");

            System.out.println("\033c");
            Console.printSlowly("Inimigo: " + actualMonster.getName() + "\n\n\n");
            System.out.println(actualMonster.getSprite());
            Console.readString("Pressione enter para continuar");

            Battle.startBattle(player, actualMonster);

            if (player.getHealth() == 0) {
                return;
            }

            if(player.getFloorNumber() == 4) {
                // ao finalizar andar 4 e 8 uma nova armadura será automaticamente equipada
                //TODO: criar interface quando armadura é equipada;
                //TODO: criar armaduras

                equipNewArmor(1, player);
            } else if(player.getFloorNumber() == 8) {

                equipNewArmor(2, player);
            }

            player.addPoints(1);
            player.floorUp();

            if (!saveMenu(player)) {
                return;
            }
        }

        winMessage();
    }

    private static void equipNewArmor(int armorNumber, Player player) {
        System.out.println("\033c");
        Console.printSlowly("Após derrotar o monstro, você encontra uma nova armadura e a coloca.\n");

        Console.printSlowly(ArmorController.getList().get(armorNumber).toString());
    
        player.setArmor(ArmorController.getList().get(armorNumber));
        Console.readString("");

    }

    private static void winMessage() {
        System.out.println("\033c");
        Console.printSlowly("Parabéns, Aventureiro!\n\n");
        Console.printSlowly("Você atravessou os domínios mais sombrios e enfrentou criaturas das profundezas que poucos ousaram desafiar. Cada andar do labirinto trouxe novos desafios que testaram sua coragem, habilidade e determinação. Desde os pântanos enevoados habitados pelo Slime até as profundezas ardentes onde o Demon King esperava, você provou ser um verdadeiro herói.\n");
        Console.printSlowly("Através de catacumbas repletas de esqueletos, florestas sombrias vigiadas por lobos ferozes, e castelos góticos dominados por vampiros ancestrais,\n sua jornada foi nada menos que épica. Sua habilidade em superar o Lich em sua cripta gélida e o desafiante Cerberus em sua lair infernal destaca seu destemor e destreza.\n");
        Console.printSlowly("Ao derrotar o Demon King, você não só salvou inúmeras almas das garras de um destino terrível, mas também garantiu seu lugar entre as lendas.\n O mundo fora deste labirinto infernal lhe agradece e celebra seu retorno triunfante.\n");
        Console.printSlowly("Descanse agora, herói, pois você mereceu. As histórias de suas façanhas ecoarão através dos tempos, inspirando corações valentes que ousam seguir seus passos. \n\nLembre-se sempre: sua coragem e espírito indomável foram a chave para sua vitória.\n");
        Console.printSlowly("Você superou todos os Floors e sobreviveu a todos os desafios. Parabéns pela sua coragem e destreza!\n");
    }

    private static Player mainMenu() {

        Player tempPlayer;
        Console.printSlowly("\033c\t\t\t\t\tRPG Orion");

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
