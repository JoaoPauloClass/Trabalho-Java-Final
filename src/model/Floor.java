package model;

import model.monster.Monster;

public class Floor {

    private String name;
    private String description;
    private int level;
    private Monster monster;

    public Floor(String name, String description, int level, Monster monster) {
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

    public static Floor fromString(String line) {

        String[] parts = line.split(", ");

        Monster monster;
        try {
            monster = Monster.createMonster(parts[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        Floor tempFloor = new Floor(parts[0], parts[1], Integer.parseInt(parts[2]), monster);

        return tempFloor;
    }

}