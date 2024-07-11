package controller;

import model.monster.Monster;

import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Battle {

    public static int action = 0;

    public static Player startBattle(Player player, Monster monster) {
        
        Player tempPlayer = PlayerController.calculateAtributes(player);

        //Seta todos as vidas inicial do monstro e do player
        GraphicalCombatSystem.setDamage(10);
        
        GraphicalCombatSystem.setMana(10);

        //Começa o loop da battle
        do {

            //Criar as tabelas
            GraphicalCombatSystem.MonsterBattle(monster);
            GraphicalCombatSystem.playerTable(tempPlayer);

            //Le as opçoes do usuario
            int option = SelectOption.playerOption();
            action = SelectOption.readAction(option, tempPlayer, monster);

            if (action == 0)
                continue;

            // Action player
            int used = 0;
            if (option == 2){

                habilityBattle(tempPlayer, monster);
                used = 1;
            }

            else if (option == 3) {
                potioBattle(tempPlayer);
                used = 2;

            }
            //Para pular o loop e voltar para a tela inicial sem gerar dano
            if (action == 0)
                continue;

            // Verifica quem ataca primeiro
            if (monster.getAgility() > tempPlayer.getAgility())
                attackMonsterFirst(monster, tempPlayer, used);
                
            else {
                if (action == -1) {
                    try {
                        tempPlayer.attack(monster);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                playerAttackFirst(monster, tempPlayer, used);
                
                //Verifica se o monstro morreu
                if (monster.getHealth() <= 0) {
                    break;
                }

                if (tempPlayer.getHealth() <= 0) {
                    gameOver(tempPlayer);
                }
            }
            
            
        } while (monster.getHealth() > 0);
        

        
        

        tempPlayer.setMana(tempPlayer.getMaxMana());
        
        System.out.println("Derrotou");
        
        return tempPlayer;
    }
    //Pega a habilidade escolhida pelo player
    public static void habilityBattle(Player player, Monster monster) {

        try {
            player.damageBattle(action, monster, player);
            player.energyCostBattle(action);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Console.readString("Pressione enter para prosseguir: ");
            action = 0;
        }

    }
    //Pega a poção escolhida pelo player
    public static void potioBattle(Player player) {

        if (action == 1) {
            try {
                player.useHealingPotion();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readString("Pressione enter para prosseguir: ");
                action = 0;
            }
        } else {
            try {
                player.useManaPotion();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readString("Pressione enter para prosseguir: ");
                action = 0;
            }
        }
    }
    //Função chamada caso a agilidade do monstro for maior que a do player
    public static void attackMonsterFirst(Monster monster, Player player, int used) {

        
        // Monstro ataque
        Console.printSlowly(monster.getName() + " Atacou voce primeiro!!");

        Console.readString("");
        try {
            monster.attack(player);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Console.readString("");
        }
        if (player.getHealth() <= 0) {
            gameOver(player);
        }
        if (used == 2) {
            Console.printSlowly(" Voce usou uma pocao!!");
        } else if (used == 1) {
            Console.printSlowly(" Voce usou uma habilidade!!");
        }else {
            try {
                player.attack(monster);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //Chamada para terminar o jogo caso o monstro derrote o player
    public static void gameOver(Player player) {
        System.out.println("\033c");
        System.out.println("\nGame Over");
        System.out.println("Tabela de pontos");

        player.showHabilities();
        System.out.println(" ");
        System.exit(0);

    }
    //Função chamada caso a agilidade do player for maior que a do monstro
    public static void playerAttackFirst(Monster monster, Player player, int used) {
        if (used == 1) {
            Console.printSlowly("Voce usou uma habilidade!!");
        } else if (used == 2) {
            Console.printSlowly(" Voce usou uma pocao!!");
        }
        Console.readString("");

        if (monster.getHealth() <= 0) {
            return;
        }

        try {
            monster.attack(player);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Console.readString("");
        }
    }

    public static void recoverLifePlayer(Player tempPlayer){
        int recoverHealth = (tempPlayer.getMaxHealth() / 4) + tempPlayer.getHealth();

        if (recoverHealth >= tempPlayer.getMaxHealth()) {
            tempPlayer.setHealth(tempPlayer.getMaxHealth());
            GraphicalCombatSystem.setLife(10);
        }
        else{
        tempPlayer.setHealth(recoverHealth);
        int temp = ((recoverHealth * 10) / tempPlayer.getMaxHealth());
        GraphicalCombatSystem.setLife(temp);
        
        }
    }
}
