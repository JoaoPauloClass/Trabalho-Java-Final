package model.monster.boss;
import java.util.Random;

import controller.HabilityController;
import model.Hability;
import model.player.Player;

public class Minotaur extends Boss{

    //todo ARRUMAR ISSO
    public Minotaur(){
        super("Minotauro", 15, 10, 20, 10, 20);
        habilities();
    }

    public void habilities(){
        try {
            habilities = HabilityController.initializeMinotaurHability();
            for(Hability a: habilities){
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	public void attack(Player player) throws Exception {
		if (!(player instanceof Player)) {
            throw new Exception("Nenhum player foi passado para a função.");
        }
        Random rand = new Random();
        int d20 = rand.nextInt(20) + 1; // Gera um número entre 1 e 20
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d20 >= 6) {
            System.out.println("O Esqueleto atira uma flecha em você.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O Esqueleto avança e te corta com uma espada.");
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

	public String getSprite() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSprite'");
	}



    
}
