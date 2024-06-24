package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.GraphicalCombatSystem;

public class Gargoyle extends Monster {
    public Gargoyle() {
        super("Gárgula", 20, 22, 20, 8,720);
    }

    public String getSprite() {
        
        return ",                                                               ,\r\n" + //
                " \\'.                                                           .'/\r\n" + //
                "  ),\\                                                         /,(\r\n" + //
                " /__\\'.                                                     .'/__\\\r\n" + //
                " \\  `'.'-.__                                           __.-'.'`  /\r\n" + //
                "  `)   `'-. \\                                         / .-'`   ('\r\n" + //
                "  /   _.--'\\ '.          ,               ,          .' /'--._   \\\r\n" + //
                "  |-'`      '. '-.__    / \\             / \\    __.-' .'      `'-|\r\n" + //
                "  \\         _.`'-.,_'-.|/\\ \\    _,_    / /\\|.-'_,.-'`._         /\r\n" + //
                "   `\\    .-'       /'-.|| \\ |.-\"   \"-.| / ||.-'\\       '-.    /`\r\n" + //
                "     )-'`        .'   :||  / -.\\\\ //.- \\  ||:   '.        `'-(\r\n" + //
                "    /          .'    / \\\\_ |  /o`^'o\\  | _// \\    '.          \\\r\n" + //
                "    \\       .-'    .'   `--|  `\"/ \\\"`  |--`   '.    '-.       /\r\n" + //
                "     `)  _.'     .'    .--.; |\\__\"__/| ;.--.    '.     '._  ('\r\n" + //
                "     /_.'     .-'  _.-'     \\\\ \\/^\\/ //     `-._  '-.     '._\\\r\n" + //
                "     \\     .'`_.--'          \\\\     //          `--._`'.     /\r\n" + //
                "      '-._' /`            _   \\\\-.-//   _            `\\ '_.-'\r\n" + //
                "          `<     _,..--''`|    \\`\"`/    |`''--..,_     >`\r\n" + //
                "           _\\  ``--..__   \\     `'`     /   __..--``  /_\r\n" + //
                "          /  '-.__     ``'-;    / \\    ;-'``     __.-'  \\\r\n" + //
                "         |    _   ``''--..  \\'-' | '-'/  ..--''``   _    |\r\n" + //
                "         \\     '-.       /   |/--|--\\|   \\       .-'     /\r\n" + //
                "          '-._    '-._  /    |---|---|    \\  _.-'    _.-'\r\n" + //
                "              `'-._   '/ / / /---|---\\ \\ \\ \\'   _.-'`\r\n" + //
                "                   '-./ / / / \\`---`/ \\ \\ \\ \\.-'\r\n" + //
                "                       `)` `  /'---'\\  ` `(`\r\n" + //
                "                      /`     |       |     `\\\r\n" + //
                "                     /  /  | |       | |  \\  \\\r\n" + //
                "                 .--'  /   | '.     .' |   \\  '--.\r\n" + //
                "                /_____/|  / \\._\\   /_./ \\  |\\_____\\\r\n" + //
                "               (/      (/'     \\) (/     `\\)      \\)";
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
        if (d10 >= 6) {
            System.out.println("A gárgula se lança contra o você usando seu corpo de pedra como uma arma.");
            if (d10Dodge < 5) {
                System.out.println("Você é acertado.");
                dano = attack;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("A gárgula ataca com suas garras afiadas feitas de pedra");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
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