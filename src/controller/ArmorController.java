package controller;

import java.io.*;
import java.util.ArrayList;

import model.Armor;

public class ArmorController {

    private static final File WARRIOR = new File("src/database/armor/warrior.txt");
    private static final File WIZARD = new File("src/database/armor/wizard.txt");
    private static final File ASSASSIN = new File("src/database/armor/assassin.txt");

    public static ArrayList<Armor> list = new ArrayList<>();

    public static ArrayList<Armor> initializaWarriorArmor() throws Exception {

        String line;
        try (FileReader fr = new FileReader(WARRIOR); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {

                Armor tempArmor = Armor.fromString(line);

                list.add(tempArmor);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (list.isEmpty()) {
            throw new Exception("Erro, lista de armaduras vazia");
        }

        return list;

    }

    public static ArrayList<Armor> initializaAssassinArmor() throws Exception {

        String line;
        try (FileReader fr = new FileReader(ASSASSIN); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {

                Armor tempArmor = Armor.fromString(line);

                list.add(tempArmor);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (list.isEmpty()) {
            throw new Exception("Erro, lista de armaduras vazia");
        }

        return list;

    }

    public static ArrayList<Armor> initializaWizardArmor() throws Exception {

        String line;
        try (FileReader fr = new FileReader(WIZARD); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {

                Armor tempArmor = Armor.fromString(line);

                list.add(tempArmor);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (list.isEmpty()) {
            throw new Exception("Erro, lista de armaduras vazia");
        }

        return list;

    }
}
