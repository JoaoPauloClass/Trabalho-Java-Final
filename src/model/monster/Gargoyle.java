package model.monster;

import java.util.Random;

import model.player.Player;

public class Gargoyle extends Monster{
    public Gargoyle(){
        super("Gárgula", 8, 4, 7, 6);
    }

    public void attack(Player player)throws Exception{
        if (!(player instanceof Player)) {
            throw new Exception("Nenhum player foi passado para a função.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 6) {
            System.out.println("A gárgula se lança contra o você usando seu corpo de pedra como uma arma.");
            if (d10Dodge < 5) {
                System.out.println("Você é acertado.");
                dano = attack;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("A gárgula ataca com suas garras afiadas feitas de pedra");
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

    public String getSprite(){
        //TODO: arte gargola
        return "";    
    }
    
}