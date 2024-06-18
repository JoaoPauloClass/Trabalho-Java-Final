package model.monster;
import java.util.Random;
import model.player.Player;

public class Slime extends Monster {
    
    public Slime(){
        super("Slime", 5, 3, 3, 4);
    }

    public void attack(Player player){
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int dano = attack;
        if (d10 <= 5) {
            System.out.println("O Slime dipara um Golpe Ácido.");
            dano = attack - 2;
            System.out.println("Dano recebido: " + dano);
            player.takeDamage(dano);
        }else{
            System.out.println("O Slime pula em você.");
            System.out.println("Dano recebido: " + dano);
            player.takeDamage(dano);
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

