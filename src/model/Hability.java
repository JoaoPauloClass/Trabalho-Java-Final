package model;

import view.Color;

public class Hability {

    protected String name;
    protected int energyCost;
    protected int baseDamage;

    public Hability(String name, int energyCost, int baseDamage) {
        this.name = name;
        this.energyCost = energyCost;
        this.baseDamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int custoEnrgia) {
        this.energyCost = custoEnrgia;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int danoBase) {
        this.baseDamage = danoBase;
    }

    public static Hability fromString(String str) {
        String[] parts = str.split(", ");

        return new Hability(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }
    
    @Override
    public String toString() {

        return "nome: " + name + Color.getBlue() + " custo: " + energyCost + Color.getRed() + " Base damage: " + baseDamage + Color.getResetColor(); 
}

    public String useHability() {
        return "Você usou: " + name;

    }
}
