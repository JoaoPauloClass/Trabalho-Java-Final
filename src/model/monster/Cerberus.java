package model.monster;

import java.util.Random;

import model.player.Player;

public class Cerberus extends Monster {
    public Cerberus() {
        super("Cerbero", 8, 8, 15, 6);
    }

    public void attack(Player player) throws Exception {
        if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
        }
        Random rand = new Random();
        int d10 = rand.nextInt(10) + 1; // Gera um número entre 1 e 10
        int d5;
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d10 >= 6) {
            System.out.println("Cérbero ataca com todas as três cabeças simultaneamente.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = 0;
                for (int i = 0; i < 3; i++) {
                    d5 = rand.nextInt(5) + 1;
                    dano += d5;
                }
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("Cérbero te ataca com sua cauda poderosa");
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

    public String getSprite() {
        
        return "                            /\\_/\\____,\r\n" + //
                "                  ,___/\\_/\\ \\  ~     /\r\n" + //
                "                  \\     ~  \\ )   XXX\r\n" + //
                "                    XXX     /    /\\_/\\___,\r\n" + //
                "                       \\o-o/-o-o/   ~    /\r\n" + //
                "                        ) /     \\    XXX\r\n" + //
                "                       _|    / \\ \\_/\r\n" + //
                "                    ,-/   _  \\_/   \\\r\n" + //
                "                   / (   /____,__|  )\r\n" + //
                "                  (  |_ (    )  \\) _|\r\n" + //
                "                 _/ _)   \\   \\__/   (_\r\n" + //
                "                (,-(,(,(,/      \\,),),)";
    }
}
