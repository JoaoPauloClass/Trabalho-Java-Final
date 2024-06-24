package controller;

import model.monster.Monster;

import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Battle {

    public static int action = 0;

    public static void startBattle(Player player, Monster monster) {
        
        Player tempPlayer = PlayerController.calculateAtributes(player);

        int lifePlayer = 10;
        GraphicalCombatSystem.setDamage(10);
        GraphicalCombatSystem.setLife(10);
        GraphicalCombatSystem.setMana(10);
        do {

            GraphicalCombatSystem.MonsterBattle(monster);
            GraphicalCombatSystem.playerTable(tempPlayer);

            int option = SelectOption.playerOption();
            action = SelectOption.readAction(option, tempPlayer, monster);

            if (action == 0)
                continue;

            // Action player
            int used = 0;
            if (option == 2 && lifePlayer > 0){

                habilityBattle(tempPlayer, monster);
                used = 1;
            }

            else if (option == 3 && lifePlayer > 0) {
                potioBattle(tempPlayer);
                used = 2;

            }
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
                
                
                if (monster.getHealth() <= 0) {
                    break;
                }

                if (tempPlayer.getHealth() <= 0) {
                    gameOver(tempPlayer);
                }
            }
            

        } while (monster.getHealth() > 0);

        tempPlayer.setHealth(tempPlayer.getMaxHealth());
        tempPlayer.setMana(tempPlayer.getMaxMana());
        System.out.println("Derrotou");

    }

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

    public static void gameOver(Player player) {
        System.out.println("\033c");
        System.out.println("\nGame Over");
        System.out.println("Tabela de pontos");

        player.showHabilities();
        System.out.println(" ");
        System.exit(0);

    }

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

}
