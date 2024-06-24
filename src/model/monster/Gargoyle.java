package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Gargoyle extends Monster {
    public Gargoyle() {
        super("Gárgula", 20, 22, 20, 8, 720);
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
            Console.printSlowly("A gárgula se lança contra o você usando seu corpo de pedra como uma arma.");
            if (d10Dodge < 5) {
                Console.printSlowly("Você é acertado.");
                dano = attack;
                Console.printSlowly("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!");
            }
        } else {
            Console.printSlowly("A gárgula ataca com suas garras afiadas feitas de pedra");
            if (d10Dodge < 8) {
                Console.printSlowly("Você é acertado.");
                dano = attack - 2;
                Console.printSlowly("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!");
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