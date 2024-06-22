package model.monster;

import java.util.Random;

import model.player.Player;

public class Skeleton extends Monster {

    public Skeleton() {
        super("Esqueleto", 7, 2, 6, 4);
    }

    public void attack(Player player) throws Exception {
        if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 6) {
            System.out.println("O Esqueleto atira uma flecha em você.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O Esqueleto avança e te corta com uma espada.");
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
}
