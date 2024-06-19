package model.monster;
import java.util.Random;
import model.player.Player;

public class Slime extends Monster {
    
    public Slime(){
        super("Slime", 5, 3, 3, 4);
    }

    public void attack(Player player)throws Exception{
        if (!(player instanceof Player)) {
            throw new Exception("Nenhum player foi passado para a função.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 <= 5) {
            //! Caso eu va colocar em metodo o dodge, os parametros são => dodgeGoal, damage, multiplicator, player
            //TODO ver sobre isso ^^^^^^^^
            System.out.println("O Slime dipara um Golpe Ácido.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        }else{
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

