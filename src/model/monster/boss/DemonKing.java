package model.monster.boss;

import controller.HabilityController;
import model.Hability;
import model.player.Player;

public class DemonKing extends Boss{

    public DemonKing(){
        super("Rei Demônio", 25, 20, 30, 10, 20);
        habilities();
    }

    public void habilities(){
        try {
            habilities = HabilityController.initializeDemonKingHability();
            for(Hability a: habilities){
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	public void attack(Player player) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'attack'");
	}

	public String getSprite() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSprite'");
	}



    
    
}
