package model.monster;

import java.util.Random;

import model.player.Player;

public class Skeleton extends Monster {
    

    public Skeleton(){
        super("Esqueleto", 7, 2, 6, 4);
    }

    public void attack(Player player){

        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int dano = attack;
        if (d10 >= 9 ) {
            System.out.println(".");
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
