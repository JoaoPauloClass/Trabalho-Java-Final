package controller;

import java.util.ArrayList;

import model.Hability;

import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Battle {

    public static void startBattle(Player p, Player m) {
        int lifeMonster = 10, energy = 0;
        int lifePlayer = 10, lifeAgain = 10;
        int manaBar = 10;
        do {
            // Garantia que não vai zerar a mana apertando zero para voltar nas escolhas de
            // habilidades
            if (manaBar == -1) {
                manaBar = energy;
            }
            energy = manaBar;
            lifeAgain = lifeMonster;
            // Start

            GraphicalCombatSystem.MonsterBattle(m, lifeMonster);
            GraphicalCombatSystem.playerTable(p, lifePlayer, manaBar);
            
            int option = GraphicalCombatSystem.playerOption();
            int action = GraphicalCombatSystem.readAction(option, p);
            if (option == 2) {

                while (true) {
                    try {
                        lifeMonster = p.damageHability(action, lifeMonster);
                        manaBar = p.energyCostBattle(action);
                
                        break;
                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                        Console.readString("Pressione enter para prosseguir: ");
                        action = GraphicalCombatSystem.playerHabilities(p);
                    }
                }
            }
            if (lifeMonster == -1) {
                lifeMonster = lifeAgain;
            } else if (option == 3) {
                if (action == 1) {
                    try {
                        lifePlayer += p.useHealingPotion();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                try {
                    manaBar = p.useManaPotion();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    Console.readString("Pressione enter para prosseguir: ");
                }
            }

        } while (lifeMonster > 0 && lifePlayer > 0);

        System.out.println("Derrotou");
    }

    public static int manaPotionCalculator(Player p){
        
        
        return 0;
    }
}
