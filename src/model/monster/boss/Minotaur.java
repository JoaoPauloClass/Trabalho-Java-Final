package model.monster.boss;
import java.util.Random;

import controller.HabilityController;
import model.Hability;
import model.player.Player;

public class Minotaur extends Boss{

    public Minotaur(){
        super("Minotauro", 15, 10, 20, 10, 20);
        setHabilities();
    }

    protected void setHabilities(){
        try {
            habilities = HabilityController.initializeMinotaurHability();
            for (Hability a : habilities) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO: FAZER ATAQUES MINOTAURO
	public void attack(Player player) throws Exception {
		if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
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

    public void checkHability(Player player) {
        /*
         * IA do minotauro vai funcionar assim
         * -> no turno que ele escolherá (por meio de probabilidade) entre usar
         * habilidade ou atacar
         * -> checar se ele tem energia para ele usar habilidade
         * -> após checado, ele tem 75% de usar a habilidade
         * -> caso os testes falhem ele ataca normal
         */

        for (Hability hability : habilities) {
            // Condição 1: Mana suficiente
            if (energy >= hability.getEnergyCost()) {
                // Condição 2: Probabilidade de usar habilidade (simulação de decisão
                // inteligente)
                Random rand = new Random();
                if (rand.nextInt(100) < 75) { // 75% de chance de usar a habilidade

                    try {
                        useHability(hability, player);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                } else {
                    try {
                        attack(player);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }
            } else {
                try {
                    attack(player);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }

    }
    //TODO: custar energia
    protected void useHability(Hability hability, Player player) throws Exception {
        if (hability == null || player == null) {
            throw new Exception("Nenhuma habilidade ou player foi passado para função");
        }

        System.out.println("O Minotauro usa sua habilidade: " + hability.getName());
        System.out.println("Dano recebido: " + hability.getBaseDamage());
        player.takeDamage(hability.getBaseDamage());

    }

	public String getSprite() {
		// TODO fazer sprite minotauro
        return "";
	}



    
}
