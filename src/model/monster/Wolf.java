package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.GraphicalCombatSystem;

public class Wolf extends Monster {

    public Wolf() {
        super("Lobo", 8, 6, 10, 12, 10);
    }

    public void attack(Player player) throws Exception {

    }

    public String getSprite() {

        return "                              __\r\n" + //
                "                            .d$$b\r\n" + //
                "                          .' TO$;\\\r\n" + //
                "                         /  : TP._;\r\n" + //
                "                        / _.;  :Tb|\r\n" + //
                "                       /   /   ;j$j\r\n" + //
                "                   _.-\"       d$$$$\r\n" + //
                "                 .' ..       d$$$$;\r\n" + //
                "                /  /P'      d$$$$P. |\\\r\n" + //
                "               /   \"      .d$$$P' |\\^\"l\r\n" + //
                "             .'           `T$P^\"\"\"\"\"  :\r\n" + //
                "         ._.'      _.'                ;\r\n" + //
                "      `-.-\".-'-' ._.       _.-\"    .-\"\r\n" + //
                "    `.-\" _____  ._              .-\"\r\n" + //
                "   -(.g$$$$$$$b.              .'\r\n" + //
                "     \"\"^^T$$$P^)            .(:\r\n" + //
                "       _/  -\"  /.'         /:/;\r\n" + //
                "    ._.'-'`-'  \")/         /;/;\r\n" + //
                " `-.-\"..--\"\"   \" /         /  ;\r\n" + //
                ".-\" ..--\"\"        -'          :\r\n" + //
                "..--\"\"--.-\"         (\\      .-(\\\r\n" + //
                "  ..--\"\"              `-\\(\\/;`\r\n" + //
                "    _.                      :\r\n" + //
                "                            ;`-\r\n" + //
                "                           :\\\r\n" + //
                "                           ;  ";
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
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 9) {
            System.out.println("O Lobo se enche de raiva e te morde profundamente.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack + 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O Lobo te morde raivosamente.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        }
    }

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
