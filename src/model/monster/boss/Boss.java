package model.monster.boss;

import java.util.List;

import model.Hability;
import model.monster.Monster;
import model.player.Player;

public abstract class Boss extends Monster{
    
    int energy;
    protected List<Hability> habilities;

    public Boss(String name, int attack, int defense, int heathy, int agility, int energy){
        super(name, attack, defense, heathy, agility);
        this.energy = energy;
    }

    public abstract void habilities();

    public abstract void attack(Player player)throws Exception;

    public abstract String getSprite();

}
