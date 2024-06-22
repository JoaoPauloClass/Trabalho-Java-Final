package controller;

import java.util.ArrayList;

import model.Hability;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Battle {

    public static void startBattle(Player p, Player m) {
        int damage = 10, energy = 0;
        int mana = 10;
        int option =0;
        do {
          
            if (mana == -1) {
                mana = energy;
            }
            energy = mana;
            GraphicalCombatSystem.MonsterBattle(m);
            GraphicalCombatSystem.playerTable(p, damage, mana);
            
            option = GraphicalCombatSystem.playerOption();
            
            int action = GraphicalCombatSystem.readAction(option, p);
            if (option == 2) {

                while (true) {
                    try {
                        damageHability(p.getHabilities(), action);
                        mana = energyCostBattle(p.getHabilities(), action,mana);
                        
                        break;
                    } catch (Exception e) {

                    System.out.println(e.getMessage());
                    Console.readString("Pressione qualquer botao para prosseguir: ");
                    action = GraphicalCombatSystem.playerHabilities(p);

                    }

                }

            }


        } while (true);

    }

    public static int manaCalculator(int mana, int energy) throws Exception{
        
        if ((mana - energy) <= 0) {
            
        }
        mana -= energy;
        return mana;
    }

    public static int damageHability(ArrayList<Hability> a, int t) {

        if (t == 1) {

            Hability b = a.get(0);
            return b.getBaseDamage();

        }
        return 0;
    }

    public static int energyCostBattle(ArrayList<Hability> a, int t, int mana) throws Exception {

        if(t == 0){
            return -1;
        }else if(t > 3){
            System.out.println("\033c");
            throw new Exception("Numero invalido, tente com um dos numeros abaixo");
        }

        Hability b = a.get(t - 1);
        
        if ((mana - b.getEnergyCost()) < -1) {
            System.out.println("\033c");
            throw new Exception("Mana insuficiente!!!");
        }
        
        return mana - b.getEnergyCost();

    }


}
