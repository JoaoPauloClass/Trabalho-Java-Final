package model.monster;
import java.util.Random;

import model.Attackable;
import model.player.Player;

public class Slime extends Monster {
    
    public Slime(){
        super("Slime", 5, 3, 3, 4);
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
        if (d10 <= 5) {
            // ! Caso eu va colocar em metodo o dodge, os parametros são => dodgeGoal,
            // damage, multiplicator, player
            // TODO ver sobre isso ^^^^^^^^
            System.out.println("O Slime dipara um Golpe Ácido.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                target.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }

        } else {
            System.out.println("O Slime pula em você.");
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
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getSprite(){
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
                    "        ░░░░░░░░░░░░░░░░░░░░░░                                                                        \r\n" + //
                    "                                         " + "\n\n";
    }


   
}

