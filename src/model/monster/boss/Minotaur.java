package model.monster.boss;

import java.util.Random;

import controller.HabilityController;
import model.Attackable;
import model.Hability;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Minotaur extends Boss {

    public Minotaur() {

        super("Minotauro", 16, 14, 23, 6, 23, 20);
        setHabilities();
    }

    protected void setHabilities() {
        try {
            habilities = HabilityController.initializeMinotaurHability();
            for (Hability a : habilities) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkHability(Player player) {
        /*
         * IA do minotauro vai funcionar assim
         * -> no turno que ele escolherá (por meio de probabilidade) entre usar
         * habilidade ou atacar
         * -> checar se ele tem energia para ele usar habilidade
         * -> após checado, ele tem 75% de usar a habilidade
         * -> caso os testes falhem ele ataca normal
         */

        for (Hability hability : habilities) {
            // Condição 1: Mana suficiente
            if (energy >= hability.getEnergyCost()) {
                // Condição 2: Probabilidade de usar habilidade (simulação de decisão
                // inteligente)
                Random rand = new Random();
                if (rand.nextInt(100) < 75) { // 75% de chance de usar a habilidade

                    try {
                        useHability(hability, player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        attack(player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            } else {
                try {
                    attack(player);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }

    protected void useHability(Hability hability, Player player) throws Exception {
        if (hability == null || player == null) {
            throw new Exception("Nenhuma habilidade ou player foi passado para função");
        }

        Console.printSlowly("O Minotauro usa sua habilidade: " + hability.getName());
        energy -= hability.getEnergyCost();
        Console.printSlowly("Dano recebido: " + hability.getBaseDamage());
        player.takeDamage(hability.getBaseDamage());
        Console.readString("");

    }

    public String getSprite() {

        return "                                                                _\r\n" + //
                "                                                              _( (~\\\r\n" + //
                "       _ _                        /                          ( \\> > \\\r\n" + //
                "   -/~/ / ~\\                     :;                \\       _  > /(~\\/\r\n" + //
                "  || | | /\\ ;\\                   |l      _____     |;     ( \\/ /   /\r\n" + //
                "  _\\\\)\\)\\)/ ;;;                  `8o __-~     ~\\   d|      \\   \\  //\r\n" + //
                " ///(())(__/~;;\\                  \"88p;.  -. _\\_;.oP        (_._/ /\r\n" + //
                "(((__   __ \\\\   \\                  `>,% (\\  (\\./)8\"         ;:'  i\r\n" + //
                ")))--`.'-- (( ;,8 \\               ,;%%%:  ./V^^^V'          ;.   ;.\r\n" + //
                "((\\   |   /)) .,88  `: ..,,;;;;,-::::::'_::\\   ||\\         ;[8:   ;\r\n" + //
                " )|  ~-~  |(|(888; ..``'::::8888oooooo.  :\\`^^^/,,~--._    |88::| |\r\n" + //
                "  \\ -===- /|  \\8;; ``:.      oo.8888888888:`((( o.ooo8888Oo;:;:'  |\r\n" + //
                " |_~-___-~_|   `-\\.   `        `o`88888888b` )) 888b88888P\"\"'     ;\r\n" + //
                "  ;~~~~;~~         \"`--_`.       b`888888888;(.,\"888b888\"  ..::;-'\r\n" + //
                "   ;      ;              ~\"-....  b`8888888:::::.`8888. .:;;;''\r\n" + //
                "      ;    ;                 `:::. `:::OOO:::::::.`OO' ;;;''\r\n" + //
                " :       ;                     `.      \"``::::::''    .'\r\n" + //
                "    ;                           `.   \\_              /\r\n" + //
                "  ;       ;                       +:   ~~--  `:'  -';\r\n" + //
                "                                   `:         : .::/\r\n" + //
                "      ;                            ;;+_  :::. :..;;;";
    }

    @Override
    public void attack(Attackable target) throws Exception {
        Player player;

        if (target == null) {
            throw new Exception("Nenhum alvo foi passado para a função de ataque.");
        } else if (target instanceof Player) {
            player = (Player) target;
        } else {
            throw new Exception("ERRO, classe tipo player nao encontrada");
        }

        Random rand = new Random();
        int d20 = rand.nextInt(20) + 1; // Gera um número entre 1 e 20
        int d10Dodge = (rand.nextInt(100) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d20 >= 6) {
            Console.printSlowly("O minotauro se aproxima e tenta acertar você com seu machado.");
            if (d10Dodge < 80) {
                Console.printSlowly("\nVocê é acertado.");
                dano = attack - 2;
                Console.printSlowly("\nDano recebido: " + dano + "\n");
                player.takeDamage(dano);
            } else {
                Console.printSlowly("\nVocê consegue esquivar!");
                
            }
        } else {
            Console.printSlowly("O minotauro investe com seus chifres apontados para você.\n");
            
            if (d10Dodge < 80) {
                Console.printSlowly("\nVocê é acertado.");
                dano = attack - 2;
                Console.printSlowly("\nDano recebido: " + dano + "\n");
                player.takeDamage(dano);
            } else {
                Console.printSlowly("\nVocê consegue esquivar!");

            }
        }
        Console.readString("");


    }

    @Override
    public void takeDamage(int damage) {
        damage = (damage - defense / 2);

        if (damage < 0) {
            damage = 0;
        }

        health -= damage;
        if (this.health < 0) {
            this.health = 0;
            GraphicalCombatSystem.setDamage(0);
            return;
        }
        int temp = ((health * 10) / maxHealth);
        GraphicalCombatSystem.setDamage(temp);

    }

}
