package model.monster.boss;

import java.util.List;

import model.Hability;
import model.monster.Monster;
import model.player.Player;

public abstract class Boss extends Monster{
    
    protected int energy;
    protected List<Hability> habilities;

    public Boss(String name, int attack, int defense, int heathy, int agility, int energy){
        super(name, attack, defense, heathy, agility);
        this.energy = energy;
    }

    protected abstract void setHabilities();

    public abstract void attack(Player player)throws Exception;

    public abstract void checkHability(Player player)throws Exception;

    protected abstract void useHability(Hability hability, Player player) throws Exception;

    public abstract String getSprite();

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public List<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(List<Hability> habilities) {
        this.habilities = habilities;
    }

}
