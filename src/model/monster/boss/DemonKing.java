package model.monster.boss;

import java.util.Random;

import controller.HabilityController;
import model.Hability;
import model.player.Player;

public class DemonKing extends Boss{

    public DemonKing(){
        super("Rei Demônio", 25, 20, 30, 10, 20);
        setHabilities();
    }

    protected void setHabilities(){
        try {
            habilities = HabilityController.initializeDemonKingHability();
            for(Hability a: habilities){
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	public void attack(Player player){
		// TODO FAZER ATAQUE REI DEMONIO	
	}

    public void checkHability(Player player) {
        /*
         * IA do Rei demonio vai funcionar assim
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

        System.out.println("O Rei Demônio usa sua habilidade: " + hability.getName());
        System.out.println("Dano recebido: " + hability.getBaseDamage());
        player.takeDamage(hability.getBaseDamage());

    }

	public String getSprite() {
		// TODO fazer sprite rei demonio
        return "";
	}



    
    
}
