package model.monster;
import java.util.Random;

import model.player.Player;

public class Wolf extends Monster{

    public Wolf(){
        super("Wolf", 6, 2, 4, 6);
    }

    public void attack(Player player){

        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int dano = attack;
        if (d10 >= 9 ) {
            System.out.println("O Lobo se enche de raiva e te morde profundamente.");
            dano = attack + 2;
            System.out.println("Dano recebido: " + dano);
            player.takeDamage(dano);
        }else{
            System.out.println("O Lobo te morde raivosamente.");
            System.out.println("Dano recebido: " + dano);
            player.takeDamage(dano);
        }
    }

    public String getSprite(){
        //TODO: arte lobo
        return "";    
    }

   
}

