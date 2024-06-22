package model.monster;

import view.*;
import java.util.Random;
import model.Attackable;
import model.player.Player;

public class Slime extends Monster {
    
    public Slime(){
        super("Slime", 15, 3, 10, 4,11);
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
            Console.printSlowly("O Slime dipara um Golpe Ácido.");
            Console.readString("");
            if (d10Dodge < 8) {
                Console.printSlowly("\nVocê é acertado.");
                Console.readString("");
                dano = attack - 2;
                dano -= player.getDefense();
                Console.printSlowly("\nDano recebido: " + dano);
                Console.readString("");
                target.takeDamage(dano);
            } else {
                Console.printSlowly("\nVocê consegue esquivar!");
            }
            
        } else {
            Console.printSlowly("\nO Slime pula em você.");

            Console.readString("");
            if (d10Dodge < 8) {
                Console.printSlowly("\nVocê é acertado.");
                Console.readString("");
                dano = attack;
                Console.printSlowly("\nDano recebido: " + dano);
                Console.readString("");
                dano -= player.getDefense();
                player.takeDamage(dano);
            } else {
                Console.printSlowly("\nVocê consegue esquivar!");
                Console.readString("");
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

