package model;

public interface Attackable {
    
    public void attack(Attackable target) throws Exception;
    public void takeDamage(int damage);
}
