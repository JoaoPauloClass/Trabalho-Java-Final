import java.lang.reflect.Array;
import java.util.ArrayList;

import controller.Battle;
import model.Hability;
import model.player.Player;
import view.GraphicalCombatSystem;

public class Main {
    
    public static void main(String[] args) {
       
                Player p = new Player("gustavo", "GUERREIRO");
                Player m = new Player("Skeleton", "MAGO");
                p.habilities();
                Battle.startBattle(p, m);

                //SystemGame.introduction();
               /* try{
                    p.addPoints();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                */
              
                
                //GraphicalCombatSystem.playerTable(p,10);
                
                
                
        
            }
        }



