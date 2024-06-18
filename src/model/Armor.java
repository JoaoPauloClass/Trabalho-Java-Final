package model;

public class Armor {

    private String name;
    private String validClass;
    private int statUpgrade;
    private String typeUpgrade;
    private int defenseUpgrade;

    public Armor(String name, String validClass, int statUpgrade, String typeUpgrade, int defenseUpgrade) {
        this.name = name;
        this.validClass = validClass;
        this.statUpgrade = statUpgrade;
        this.typeUpgrade = typeUpgrade;
        this.defenseUpgrade = defenseUpgrade;
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

    public int getDefenseUpgrade() {
        return defenseUpgrade;
    }

    public void setDefenseUpgrade(int defenseUpgrade) {
        this.defenseUpgrade = defenseUpgrade;
    }

}

