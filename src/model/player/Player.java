package model.player;

import java.util.ArrayList;

import controller.ArmorController;
import controller.HabilityController;
import controller.PotionBag;
import model.Armor;
import model.Attackable;
import model.Hability;
import model.monster.Monster;
import view.Color;
import view.Console;
import view.GraphicalCombatSystem;

public class Player implements Cloneable, Attackable {

    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private int agility;
    private int mana;
    private int maxMana;
    private int floor;
    private int points;
    private String tooling;
    private String name;
    private String playerClass;
    private boolean introduction;
    private ArrayList<Hability> habilities;
    private Armor armor;

    public Player() {
    }

    public Player(String name, int attack, int defense, int health, int mana, int agility) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.mana = mana;
        this.agility = agility;
        this.floor = 1;
    }

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.floor = 1;

        initializePlayer(playerClass);
    }

    // inicializa os atributos, habilidades e armadura com base na classe do player
    private void initializePlayer(String playerClass) {
        if (playerClass.equals("MAGO")) {
            attack = 10;
            defense = 8;
            health = 10;
            maxHealth = 10;
            mana = 15;
            maxMana = 15;
            agility = 9;
            tooling = "Cajado";
            try {
                initializeHabilities();
                initializeArmor();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("GUERREIRO")) {
            attack = 10;
            defense = 12;
            health = 13;
            maxHealth = 13;
            mana = 8;
            maxMana = 8;
            agility = 7;
            tooling = "Espada";
            try {
                initializeHabilities();
                initializeArmor();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("ASSASSINO")) {

            attack = 11;
            defense = 8;
            health = 8;
            maxHealth = 8;
            mana = 11;
            maxMana = 11;
            agility = 12;
            tooling = "Adagas";
            try {
                initializeHabilities();
                initializeArmor();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    //inicializa armadura com base na classe e equipa com base no andar alcançado
    private void initializeArmor() {

        int armorNumber;

        if(floor <= 4) {
            armorNumber = 0;
        } else if (floor <= 8) {
            armorNumber = 1;
        } else {
            armorNumber = 2;
        }

        if (playerClass.equals("MAGO")) {
            try {
                ArmorController.initializaWizardArmor();
                armor = ArmorController.getList().get(armorNumber);
                tooling = "Cajado";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("GUERREIRO")) {

            try {
                ArmorController.initializaWarriorArmor();
                armor = ArmorController.getList().get(armorNumber);
                tooling = "Espada";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("ASSASSINO")) {
            try {
                ArmorController.initializaAssassinArmor();
                armor = ArmorController.getList().get(armorNumber);
                tooling = "Adagas";
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    // inicializa habilidades com base na classe
    private void initializeHabilities() {
        if (playerClass.equals("MAGO")) {
            try {
                habilities = HabilityController.initializeWizardHability();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("GUERREIRO")) {

            try {
                habilities = HabilityController.initializeWarriorHability();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass.equals("ASSASSINO")) {
            try {
                habilities = HabilityController.initializeAssassinHability();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public ArrayList<Hability> getHabilities() {
        return habilities;
    }

    public void setHabilities(ArrayList<Hability> habilities) {
        this.habilities = habilities;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
        initializeHabilities();
        initializeArmor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getToling() {
        return tooling;
    }

    public void setToling(String toling) {
        this.tooling = toling;
    }

    public int getFloorNumber() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void floorUp() {
        floor += 1;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTooling() {
        return tooling;
    }

    public void setTooling(String tooling) {
        this.tooling = tooling;
    }

    public boolean isIntroduction() {
        return introduction;
    }

    public void setIntroduction(boolean introduction) {
        this.introduction = introduction;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    // mostra o status do player
    public void showStatus() {

        // Clear console
        System.out.println("\033c");
        System.out.print("\n\nAtaque: " + Color.getBrightRed() + attack + Color.getResetColor());
        System.out.println("\tDefesa: " + Color.getBrightBlack() +  defense + Color.getResetColor());
        System.out.print("Vida: " + Color.getBrightGreen() + health + Color.getResetColor());
        if (playerClass == "MAGO") {

            System.out.println("\tmana: " + Color.getBlue() + mana + Color.getResetColor());
        } else {
            System.out.println("\tenergia: " + Color.getBrightYellow() + mana + Color.getResetColor());
        }

        System.out.print("Agilidade: " + agility);
        System.out.println("\tArma: " + tooling);
        System.out.println("\n\n");

        Console.printSlowly(armor.toString());

        Console.readString("\nDigite enter para continuar.");

    }

    // adiciona pontos de atributos para o player
    public void addPoints(int points) {
        // Clear console
        System.out.println("\033c");
        System.out.println("Pontos disponiveis: " + points);

        while (points != 0) {

            System.out.print("\n\n1) Ataque:    " +
                    Color.getBrightRed() + attack +
                    Color.getBrightYellow() + " + 1" +
                    Color.getResetColor());

            System.out.print("\t\t2) Defesa: " +
                    Color.getBrightBlack() + defense +
                    Color.getBrightYellow() + " + 1" +
                    Color.getResetColor() + "\n");
            System.out.print("3) Vida:      " +
                    Color.getBrightGreen() + maxHealth +
                    Color.getBrightYellow() + " + 1" +
                    Color.getResetColor());

            if (playerClass == "MAGO") {
                System.out.print("\t\t4) mana: " +
                        Color.getBlue() + maxMana +
                        Color.getBrightYellow() + " + 1" +
                        Color.getResetColor() + "\n");
            } else {
                System.out.print("\t\t4) energia: " + mana +
                        Color.getBrightYellow() + " + 1" +
                        Color.getResetColor() + "\n");

            }

            System.out.print("5) Agilidade: " +
                    Color.getCyan() + agility +
                    Color.getBrightYellow() + " + 1" +
                    Color.getResetColor());

            int choice = Console.readInt("\n\nEscolha onde será colocado seus pontos: ");

            readPoints(choice);
            points--;

        }

    }

    public void habilities() {

        if (playerClass == "MAGO") {
            try {
                habilities = HabilityController.initializeWizardHability();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (playerClass == "GUERREIRO") {
            try {
                habilities = HabilityController.initializeWarriorHability();

            } catch (Exception e) {

                System.out.println(e.getMessage());
            }

        } else {
            try {
                habilities = HabilityController.initializeAssassinHability();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void showHabilities() {

        int mostrar = 1;
        for (Hability a : habilities) {
            System.out.print(mostrar++ + " ");
            System.out.println(a);

        }
    }

    public void readPoints(int choice) {

        switch (choice) {
            case 1:
                attack++;

                break;
            case 2:
                defense++;

                break;
            case 3:

                health++;
                maxHealth++;

                break;
            case 4:
                mana++;
                maxMana++;

                break;
            case 5:
                agility++;

                break;
            default:
                System.out.println("Nao existe");
                break;
        }
    }

    // usa uma poção de cura
    public void useHealingPotion() throws Exception {

        if (health == maxHealth) {
            throw new Exception("Sua vida está cheia, não há necessidade de usar");
        } else {
            PotionBag.usePotion("LIFE");
            health += 3;

            if (health > maxHealth) {
                health = maxHealth;
            }
            int temp = ((health * 10) / maxHealth);
            GraphicalCombatSystem.setLife(temp);
        }
    }

    // usa uma poção de mana
    public void useManaPotion() throws Exception {
        if (mana == maxMana) {
            throw new Exception("Sua energia está cheia, não há necessidade de usar");
        } else {
            PotionBag.usePotion("MANA");
            mana += 3;
            if (mana > maxMana) {
                mana = maxMana;
            }
            int temp = ((mana * 10) / maxMana);
            GraphicalCombatSystem.setMana(temp);
        }
    }

    // realiza o gasto de mana no uso de habilidades e atualiza a barra de energia
    public void energyCostBattle(int action) throws Exception {

        Hability hability = habilities.get(action - 1);

        if ((mana - hability.getEnergyCost()) <= -1) {
            System.out.println("\033c");
            throw new Exception("Mana insuficiente!!!");
        }

        mana = mana - hability.getEnergyCost();
        int temp = ((mana * 10) / maxMana);
        GraphicalCombatSystem.mana = temp;
    }

    // calcula o dano e atualiza a barra de vida
    public void damageBattle(int action, Monster monster, Player player) throws Exception {

        Hability hability = habilities.get(action - 1);

        if ((mana - hability.getEnergyCost()) <= -1) {
            System.out.println("\033c");
            throw new Exception("Mana insuficiente!!!");
        }

        // Slime damage
        int MHealth = monster.getHealth();
        int PAttack = (int)(player.getAttack() *0.75);
        int HDamage = hability.getBaseDamage();
        int sum = MHealth - (PAttack + HDamage);

        int lostLife = sum;
        monster.setHealth(lostLife);

        lostLife = (lostLife * 10) / monster.getMaxHealth();
        GraphicalCombatSystem.setDamage(lostLife);

    }

    // permite a clonagem do obj Player
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // calcula o dano recebido e o reduz da vida do player
    @Override
    public void takeDamage(int damage) {
        
        damage -= (defense / 2);
        if (damage < 0) {
            damage = 0;
        }
        health -= damage;
        if (this.health < 0) {
            this.health = 0;
            GraphicalCombatSystem.setLife(0);
            return;
        }

        int temp = ((health * 10) / maxHealth);

        GraphicalCombatSystem.setLife(temp);

    }

    // realiza o ataque do player
    @Override
    public void attack(Attackable target) throws Exception {

        Monster monster;

        if (target == null) {
            throw new Exception("Nenhum alvo foi passado para a função de ataque.");
        } else if (target instanceof Monster) {
            monster = (Monster) target;
        } else {
            throw new Exception("ERRO, classe tipo monster nao encontrada");
        }
        int dano = attack; 
        

        Console.printSlowly("Você ataca com sua arma.\n");
        Console.printSlowly("Você acerta o inimigo.\n");

        monster.takeDamage(dano);

       

    }

}
