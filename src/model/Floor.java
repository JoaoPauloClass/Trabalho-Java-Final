package model;

import model.monster.Monster;

public class Floor {

    private String name;
    private String description;
    private int level;
    private Monster monster;

    public Floor(String name, String description, int level, model.Monster monster) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.monster = monster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

}