package model.monster;

import java.util.Random;

import model.player.Player;

public class Vampire extends Monster{
    
    
    public Vampire(){
        super("Vampiro", 8, 2, 8, 10);
    }

    public void attack(Player player)throws Exception{
        if (!(player instanceof Player)) {
            throw new Exception("Nenhum player foi passado para a função.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 8) {
            System.out.println("O vampiro morde o seu pescoço, drenando seu sangue.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
                int restoredHealth = 4;
                this.heathy += restoredHealth;
                System.out.println("Após drenar seu sangue, ele se sente mais forte...");
                System.out.println("Vida restaurada: " + restoredHealth);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O vampiro te ataca com suas garras afiadas.");
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
        //TODO: arte vampiro
        return "";    
    }


}
