package model.monster;

import java.util.Random;

import model.Attackable;
import model.player.Player;
import view.Console;
import view.GraphicalCombatSystem;

public class Lich extends Monster {

    public Lich() {
        super("Lich", 15, 12, 18, 12, 18);
    }

    public String getSprite() {
        return "\r\n" + //
                "                                                                    ,>' Y  '.                                                          \r\n"
                + //
                "                                                                   /   _   _ \\                                                         \r\n"
                + //
                "                                                                   {|)(_) (_)(                                                         \r\n"
                + //
                "                                                                   \\{   A4   }                                                         \r\n"
                + //
                "                                                                   {/JJuLu/}                                                           \r\n"
                + //
                "                                                                   \\(/   |                                                            \r\n"
                + //
                "                                                                    \\\\n" + //
                "_mnn\\\\                                                              \r\n" + //
                "                                                                     \\\\_>-<_/                                                           \r\n"
                + //
                "                                                      =+-+:  +*=*+##+==++++=+ ==++-                                                  \r\n"
                + //
                "                                                     ::--+##**+=+*+++=-----=******+=++-                                                \r\n"
                + //
                "                                               -=+***+=-=+******#+=+*+=---=++***********+-                                             \r\n"
                + //
                "                                             =****+==:   :+*++++**+=+***************##***##=                                           \r\n"
                + //
                "                                           =+*#*+=----:-: -==+*++**++*****++**###*****###*##=                                              \r\n"
                + //
                "                                         :+*#**+=-  ----==++-::-+**++*****+*####**#***#*##*+#*                                         \r\n"
                + //
                "                                        =******==   ::-==+=-:    -=*****+++**+****##**++=+:-  :-                                       \r\n"
                + //
                "                                      -==+***++=:=+  -=+++*+==: :-=*******###***#*****+==-:                                                \r\n"
                + //
                "                                     -=====+**+=::=++**###***++---****+++++******###*#*=--=**-                                         \r\n"
                + //
                "                                      -===-------  -+++#####**###*==++++---=+*++++*##*#*-:=+-                                          \r\n"
                + //
                "                                       --=----:    ===##***********+==++----=**++*****##*--- -                                         \r\n"
                + //
                "                                          - :=+=-:-+###**##**+=-=+***+++=---===+*****####+---                                          \r\n"
                + //
                "                                            -+**+*######**++=------=+++++====+##*****#####+=--         +*****#*+:                      \r\n"
                + //
                "                                          =--=+##########*+++++*#*+-=++++===**+=-=+*#####*:=----==   -*##**#*#*##***+                  \r\n"
                + //
                "                                       ---=--+############++++++**+==+******#*=-=***#####+-====--=+*##*#**#***********=                    \r\n"
                + //
                "                                     :=+=====##=+##########*++++++=++*##*+**##*+**#######= ---+=-=+*****##******#*#****+:              \r\n"
                + //
                "                                    =*****+==*#++############*++***####+---+####*########-  ++-+++***#####***####*+*##***#=                \r\n"
                + //
                "                                  =**+++=++*-+#++######*:--=+#*#%####*+++++############**:   =*+**********##**##******#***##-          \r\n"
                + //
                "                                 =**+++===+*= =#########--=--=***#####+=--+#####+=*####+-  :+******+++*******+******##*####*#+             \r\n"
                + //
                "                                =****+*+==++:  *##=:*####+=-=-**++###=-==+*#*+=====-+##-  =*###****++=++++****###*##*****######+       \r\n"
                + //
                "                                =***+=====+-   ++*: -***###==+**++==++===++=----=++--##- :**##*****+++++++*########****##########*+:       \r\n"
                + //
                "                               -*#*++===+*+:   -:=-=+*******++******+=--===--==-=+++==+  +###*###**+++++*##*++****#***++*#**##- -= -+:  \r\n"
                + //
                "                              +*++=+=++++=+      --===++#*****+-+*****+*##*+====+=++-   =######**#****###****##*++#######******=       \r\n"
                + //
                "                              +*+====+++--=        -==-==*************######++==++++   +###*=*###**####****####*########***###=        \r\n"
                + //
                "                            =*+=====++**+==        =*=--=*#*********+-=*##+===+*+*++=  -****##################++****###****#*-         \r\n"
                + //
                "                           +++====++*==**+         =*=--+###*******++++====-=**+*+++++:-*****######******#*+++#**#####******-       \r\n"
                + //
                "\r\n" + //
                "\r\n" + //
                "\r\n" + //
                "";
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
            Console.printSlowly("O Lich canaliza energia mágica em uma poderosa explosão ao seu redor.");
            if (d10Dodge < 4) {
                Console.printSlowly("Você é acertado.");
                dano = attack + (player.getDefense() / 4);
                Console.printSlowly("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!");
            }
        } else {
            Console.printSlowly("O Lich te ataca com sua mão esquelética");
            if (d10Dodge < 8) {
                Console.printSlowly("Você é acertado.");
                dano = attack - 2;
                Console.printSlowly("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                Console.printSlowly("Você consegue esquivar!");
            }
        }

        if (this.health == 1) {
            Console.printSlowly("O Lich está enfraquecido e começa a conjurar uma mágia estranha...");
            d10 = rand.nextInt(10);
            if (d10 >= 5) {
                Console.printSlowly("Sua magia é um sucesso e ele se regenera");
                int restoredHealth = 6;
                this.health += restoredHealth;
                Console.printSlowly("Vida restaurada: " + restoredHealth);
            } else {
                Console.printSlowly("Sua magia fracassou, nada acontece...");
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
