package model;

public class Armor {

    private String name;
    private String validClass;
    private int statUpgrade;
    private String typeUpgrade;
    private int classUpgrade;

    public Armor(String name, String validClass, int statUpgrade, String typeUpgrade, int classUpgrade) {
        this.name = name;
        this.validClass = validClass;
        this.statUpgrade = statUpgrade;
        this.typeUpgrade = typeUpgrade;
        this.classUpgrade = classUpgrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidClass() {
        return validClass;
    }

    public void setValidClass(String validClass) {
        this.validClass = validClass;
    }

    public int getStatUpgrade() {
        return statUpgrade;
    }

    public void setStatUpgrade(int statUpgrade) {
        this.statUpgrade = statUpgrade;
    }

    public String getTypeUpgrade() {
        return typeUpgrade;
    }

    public void setTypeUpgrade(String typeUpgrade) {
        this.typeUpgrade = typeUpgrade;
    }

    public int getClassUpgrade() {
        return classUpgrade;
    }

    public void setClassUpgrade(int classUpgrade) {
        this.classUpgrade = classUpgrade;
    }

    public static Armor fromString(String line) {
        String[] list = line.split(", ");

        Armor tempArmor = new Armor(list[0], list[1], Integer.parseInt(list[2].trim()), list[3], Integer.parseInt(list[4].trim()));

        return tempArmor;
    }

    @Override
    public String toString() {
        String txt = "";

        txt += "Armadura: " + name + "\nClasse: " + validClass + "\nBonus de classe: " + classUpgrade +"\nTipo de bonus: " + typeUpgrade + "\nBonus: " + statUpgrade;

        
        return txt;
    }
}

