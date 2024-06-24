package model.monster;

import java.util.Random;
import view.Console;
import view.GraphicalCombatSystem;
import model.Attackable;
import model.player.Player;

public class Skeleton extends Monster {

    public Skeleton() {
        super("Esqueleto", 9, 4, 10, 6,10);
    }

    public String getSprite() {

        return "                            _.--\"\"-._                     \r\n" + //
                "  .                         .\"         \".                   \r\n" + //
                " / \\    ,^.         /(     Y             |      )\\          \r\n" + //
                "/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )         \r\n" + //
                "|        :|    `>   '.     l_..-------.._l      .'          \r\n" + //
                "|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"            \r\n" + //
                " \\  .-' | |  `              l._       _.'                   \r\n" + //
                "  \\/    | |                   l`^^'^^'j                     \r\n" + //
                "        | |                _   \\_____/     _                \r\n" + //
                "        j |               l `--__)-'(__.--' |               \r\n" + //
                "        | |               | /`---``-----'\"1 |  ,-----.      \r\n" + //
                "        | |               )/  `--' '---'   \\'-'  ___  `-.   \r\n" + //
                "        | |              //  `-'  '`----'  /  ,-'   I`.  \\  \r\n" + //
                "      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\ \r\n" + //
                "     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\r\n" + //
                "      `._;/7(-.......'  /        ) (     |  |            | |\r\n" + //
                "      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\r\n" + //
                "        | |                 .__ )-'\\  __  \\  \\  I   1   / / \r\n" + //
                "        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /  \r\n" + //
                "                           \\__  `-'    __/  `-. `---'',-'   \r\n" + //
                "                              )-._.-- (        `-----'      \r\n" + //
                "                             )(  l\\ o ('..-.                \r\n" + //
                "                       _..--' _'-' '--'.-. |                \r\n" + //
                "                __,,-'' _,,-''            \\ \\               \r\n" + //
                "               f'. _,,-'                   \\ \\              \r\n" + //
                "              ()--  |                       \\ \\             \r\n" + //
                "                \\.  |                       /  \\            \r\n" + //
                "                  \\ \\                      |._  |           \r\n" + //
                "                   \\ \\                     |  ()|           \r\n" + //
                "                    \\ \\                     \\  /            \r\n" + //
                "                     ) `-.                   | |            \r\n" + //
                "                    // .__)                  | |            \r\n" + //
                "                 _.//7'                      | |            \r\n" + //
                "               '---'                         j_| `          \r\n" + //
                "                                            (| |            \r\n" + //
                "                                             |  \\           \r\n" + //
                "                                             |lllj          ";
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
            Console.printSlowly("O Esqueleto atira uma flecha em você.");
            if (d10Dodge < 8) {
                Console.printSlowly("Você é acertado.");
                dano = attack - 2;
                Console.printSlowly("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!");
            }
        } else {
            Console.printSlowly("O Esqueleto avança e te corta com uma espada.");
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
