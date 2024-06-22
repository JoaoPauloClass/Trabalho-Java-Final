package model.monster.boss;

import java.util.Random;

import controller.HabilityController;
import model.Hability;
import model.player.Player;

public class DemonKing extends Boss {

    public DemonKing() {
        super("Rei Demônio", 25, 20, 30, 10, 20);
        setHabilities();
    }

    protected void setHabilities() {
        try {
            habilities = HabilityController.initializeDemonKingHability();
            for (Hability a : habilities) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void attack(Player player) throws Exception {

        if (player == null) {
            throw new Exception("Nenhum player foi passado para a função de ataque.");
        }
        Random rand = new Random();
        int d20 = rand.nextInt(20) + 1; // Gera um número entre 1 e 20
        int d10Dodge = (rand.nextInt(10) + 1) + (player.getAgility() / 4);
        int dano = attack;
        if (d20 >= 6) {
            System.out.println("O rei demônio lança uma bola de magia negra em sua direção.");
            if (d10Dodge < 8) {
                System.out.println("Você é acertado.");
                dano = attack - 2;
                System.out.println("Dano recebido: " + dano);
                player.takeDamage(dano);
            } else {
                System.out.println("Você consegue esquivar!");
            }
        } else {
            System.out.println("O rei demônio invoca uma espada flutuante que voa em sua direção.");
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
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        attack(player);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            } else {
                try {
                    attack(player);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }

    protected void useHability(Hability hability, Player player) throws Exception {
        if (hability == null || player == null) {
            throw new Exception("Nenhuma habilidade ou player foi passado para função");
        }

        System.out.println("O Rei Demônio usa sua habilidade: " + hability.getName());
        energy -= hability.getEnergyCost();
        System.out.println("Dano recebido: " + hability.getBaseDamage());
        player.takeDamage(hability.getBaseDamage());

    }

    public String getSprite() {
        
        return "   ,    ,    /\\   /\\\r\n" + //
                "  /( /\\ )\\  _\\ \\_/ /_\r\n" + //
                "  |\\_||_/| < \\_   _/ >\r\n" + //
                "  \\______/  \\|0   0|/\r\n" + //
                "    _\\/_   _(_  ^  _)_\r\n" + //
                "   ( () ) /`\\|V\"\"\"V|/`\\\r\n" + //
                "     {}   \\  \\_____/  /\r\n" + //
                "     ()   /\\   )=(   /\\\r\n" + //
                "     {}  /  \\_/\\=/\\_/  \\";
    }

}
