


import controller.Battle;
import controller.FloorController;
import controller.PotionBag;

import model.monster.Monster;
import model.player.Player;



public class Main {
    
    public static void main(String[] args) {
        

        try{
            PotionBag.initialize();
            Player p = new Player("Gustavo", "GUERREIRO");
            FloorController.initializeFloor();
            Monster m =  FloorController.getFloor(1).getMonster();
            Battle.startBattle(p, m);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

     // GameSystem.execute();

    }
}
    