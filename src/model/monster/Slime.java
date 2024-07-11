package model.monster;

import view.*;
import java.util.Random;
import model.Attackable;
import model.player.Player;

public class Slime extends Monster {

    public Slime() {


        super("Slime", 9, 7, 13, 15, 13);
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
        int d10Dodge = (rand.nextInt(100) + 1) + (player.getAgility() / 4);
        int dano = attack;

        if (d10 <= 5) {
            Console.printSlowly("O Slime dipara um Golpe Ácido.\n");
            Console.readString("");
            if (d10Dodge < 80) {
                Console.printSlowly("\nVocê é acertado.\n");
                Console.readString("");
                dano = attack - 2;
                Console.printSlowly("\nDano recebido: " + dano + "\n");
                Console.readString("");
                player.takeDamage(dano);
            } else {
                Console.printSlowly("\nVocê consegue esquivar!\n");
            }

        } else {
            Console.printSlowly("\nO Slime pula em você.\n");

            Console.readString("");
            if (d10Dodge < 80) {
                Console.printSlowly("\nVocê é acertado.\n");
                Console.readString("");
                dano = attack;
                Console.printSlowly("\nDano recebido: " + dano + "\n");
                Console.readString("");

                player.takeDamage(dano);

            } else {
                Console.printSlowly("\nVocê consegue esquivar!\n");
                Console.readString("");
            }
        }
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

    public String getSprite() {
        return "              ░░░░░░░░░░              \r\n" + //
                "          ░░░░        ░░░░░░              \r\n" + //
                "        ░░                  ░░            \r\n" + //
                "      ░░                    ░░░░          \r\n" + //
                "    ░░                      ░░░░░░        \r\n" + //
                "    ░░                        ░░░░        \r\n" + //
                "  ░░                ░░    ░░  ░░░░░░      \r\n" + //
                "  ░░                ██░░  ██    ░░░░      \r\n" + //
                "  ░░                ██░░  ██    ░░░░      \r\n" + //
                "  ░░            ░░            ░░░░░░      \r\n" + //
                "  ░░░░░░                      ░░░░░░      \r\n" + //
                "    ░░░░░░                  ░░░░░░        \r\n" + //
                "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░        \r\n" + //
                "        ░░░░░░░░░░░░░░░░░░░░░░                                                                        \r\n"
                + //
                "                                         " + "\n\n";
    }

}
