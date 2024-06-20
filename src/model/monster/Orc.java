package model.monster;
import java.util.Random;
import model.player.Player;

public class Orc extends Monster {
    
    public Orc(){
        super("Orc", 8, 4, 10, 2);
    }

    public void attack(Player player) throws Exception{
        if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
        }
        Random rand = new Random();
        int d10Attack = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10Attack > 7 ) {
            System.out.println("O Orc se enfurece e faz uma investida em sua direção.");
            if (d10Dodge < 5) {
                System.out.println("Você é acertado.");
                dano = attack;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            }else{
                System.out.println("Você consegue esquivar!");
            }
        }else{
            System.out.println("O Orc tenta te acertar com sua maça.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            }else{
                System.out.println("Você consegue esquivar!");
            }
        }
    }

    public String getSprite(){
        //TODO: arte orc
        return "";    
    }
}