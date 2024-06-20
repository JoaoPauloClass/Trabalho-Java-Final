package model.monster;

import java.util.Random;


import model.player.Player;

public class Lich  extends Monster{

    public Lich(){
        super("Lich", 10, 2, 10, 4);
    }

    public void attack(Player player)throws Exception{
        if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 6) {
            System.out.println("O Lich canaliza energia mágica em uma poderosa explosão ao seu redor.");
            if (d10Dodge < 4) {
                System.out.println("Você é acertado.");
                dano = attack + (player.getDefense() / 4);
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O Lich te ataca com sua mão esquelética");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        }


        if (this.heathy == 1) {
            System.out.println("O Lich está enfraquecido e começa a conjurar uma mágia estranha...");
            d10 = rand.nextInt(10);
            if (d10 >= 5) {
                System.out.println("Sua magia é um sucesso e ele se regenera");
                int restoredHealth = 6;
                this.heathy += restoredHealth;
                System.out.println("Vida restaurada: " + restoredHealth);
            }else{
                System.out.println("Sua magia fracassou, nada acontece...");
            }
        }
        }

    public String getSprite(){
        //TODO: arte lich
        return "";    
    }
    
}
