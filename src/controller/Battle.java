package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import model.Hability;
import model.player.Player;
import view.GraphicalCombatSystem;

public class Battle {

    public static void startBattle(Player p, Player m) {
        int damage = 10, energy = 0;

        do {
            GraphicalCombatSystem.MonsterBattle(m);

            GraphicalCombatSystem.playerTable(p, damage, energy);
            int option = GraphicalCombatSystem.playerOption();
            int action = GraphicalCombatSystem.readAction(option, p);

            if (option == 2) {
                while (true) {
                    try {
                        damageHability(p.getHabilities(), action);
                        energy = energyCostBattle(p.getHabilities(), action);

                        System.out.println(energy);
                        break;
                    } catch (Exception e) {

                        System.out.println("Numero invalido, tente com um dos numeros acima");
                        System.out.println("\033c");
                        action = GraphicalCombatSystem.playerHabilities(p);

                    }
                }

            }

        } while (true);

    }

    public static int damageHability(ArrayList<Hability> a, int t) {

        if (t == 1) {

            Hability b = a.get(0);
            return b.getBaseDamage();

        }
        return 0;
    }

    public static int energyCostBattle(ArrayList<Hability> a, int t) throws Exception {

        Hability b = a.get(t - 1);
        return b.getEnergyCost();

    }

}
