package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.GraphicalCombatSystem;

public class Vampire extends Monster {

    public Vampire() {
        super("Vampiro", 8, 2, 8, 10,8);
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
            System.out.println("O vampiro morde o seu pescoço, drenando seu sangue.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
                int restoredHealth = 4;
                this.health += restoredHealth;
                System.out.println("Após drenar seu sangue, ele se sente mais forte...");
                System.out.println("Vida restaurada: " + restoredHealth);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O vampiro te ataca com suas garras afiadas.");
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

    @Override
    public void takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }

        health -= damage - defense / 2;
        if (this.health < 0) {
            this.health = 0;
            GraphicalCombatSystem.setDamage(0);
            return;
        }
        int temp = ((health * 10) / maxHealth);
        GraphicalCombatSystem.setDamage(temp);
    
    }

}
