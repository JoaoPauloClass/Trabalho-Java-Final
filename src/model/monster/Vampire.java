package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Vampire extends Monster {

    public Vampire() {
        super("Vampiro", 12, 11, 19, 11, 19);
    }

    public String getSprite() {

        return "            __.......__\r\n" + //
                "            .-:::::::::::::-.\r\n" + //
                "          .:::''':::::::''':::.\r\n" + //
                "        .:::'     `:::'     `:::. \r\n" + //
                "   .'\\  ::'   ^^^  `:'  ^^^   '::  /`.\r\n" + //
                "  :   \\ ::   _.__       __._   :: /   ;\r\n" + //
                " :     \\`: .' ___\\     /___ `. :'/     ; \r\n" + //
                ":       /\\   (_|_)\\   /(_|_)   /\\       ;\r\n" + //
                ":      / .\\   __.' ) ( `.__   /. \\      ;\r\n" + //
                ":      \\ (        {   }        ) /      ; \r\n" + //
                " :      `-(     .  ^\"^  .     )-'      ;\r\n" + //
                "  `.       \\  .'<`-._.-'>'.  /       .'\r\n" + //
                "    `.      \\    \\;`.';/    /      .'\r\n" + //
                "      `._    `-._       _.-'    _.'\r\n" + //
                "       .'`-.__ .'`-._.-'`. __.-'`.\r\n" + //
                "     .'       `.         .'       `.\r\n" + //
                "   .'           `-.   .-'           `.";
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
        if (d10 >= 8) {
            Console.printSlowly("O vampiro morde o seu pescoço, drenando seu sangue.\n");
            if (d10Dodge < 8) {
                Console.printSlowly("Você é acertado.\n");
                dano = attack - 2;
                Console.printSlowly("Dano recebido: " + dano + "\n");
                player.takeDamage(dano);
                int restoredHealth = 4;
                this.health += restoredHealth;
                Console.printSlowly("Após drenar seu sangue, ele se sente mais forte...\n");
                Console.printSlowly("Vida restaurada: " + restoredHealth);
            } else {
                Console.printSlowly("Você consegue esquivar!\n");
            }
        } else {
            Console.printSlowly("O vampiro te ataca com suas garras afiadas.\n");
            if (d10Dodge < 8) {
                Console.printSlowly("Você é acertado.\n");
                dano = attack;
                Console.printSlowly("Dano recebido: " + dano + "\n");
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!\n");
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

}
