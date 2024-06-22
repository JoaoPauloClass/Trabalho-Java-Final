package controller;

import model.monster.Monster;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Battle {

    public static int action = 0;
    public static void startBattle(Player p, Monster m) {
        int lifePlayer = 10;
        int cont = 0;
        do {

            GraphicalCombatSystem.MonsterBattle(m);
            GraphicalCombatSystem.playerTable(p, lifePlayer);

            int option = GraphicalCombatSystem.playerOption();
            action = GraphicalCombatSystem.readAction(option, p);

            if (action == 0)
                continue;

            if (m.getAgility() < p.getAgility()) {

                // todo: Monster Attack
                if (option == 2 && lifePlayer > 0)
                    habilityBattle(p);
                else if (option == 3 && lifePlayer > 0) 
                    potioBattle(p);
                if (action == 0)
                    continue;
            } else {
                if (option == 2 && lifePlayer > 0)
                    habilityBattle(p);
                else if (option == 3 && p.getHealth() > 0) 
                    potioBattle(p);
            }
            
            if (cont == 0) {
                p.setHealth(5);
                GraphicalCombatSystem.setLife(5);
                cont++;
            }
           

        } while (m.getHealth() > 0 && lifePlayer > 0);

        p.setHealth(p.getMaxHealth());
        p.setMana(p.getMaxMana());
        System.out.println("Derrotou");
    }

    public static void habilityBattle(Player p) {

            try {
                p.damageBattle(action);
                p.energyCostBattle(action);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readString("Pressione enter para prosseguir: ");
                action = 0;
            }
        
    }

    public static void potioBattle(Player p) {

        if (action == 1) {
            try {
                p.useHealingPotion();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readString("Pressione enter para prosseguir: ");
                action =0;
            }
        } else {
            try {
                p.useManaPotion();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readString("Pressione enter para prosseguir: ");
                action =0;
            }
        }
    }
}
