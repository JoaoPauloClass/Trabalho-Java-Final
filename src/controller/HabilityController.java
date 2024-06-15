package controller;

import java.io.*;
import java.util.ArrayList;

import model.Hability;

public class HabilityController {
    private static final File WARRIOR_HABILITY = new File("src/database/habilities/warrior.txt");
    private static final File WIZARD_HABILITY = new File("src/database/habilities/wizard.txt");
    private static final File ASSASSIN_HABILITY = new File("src/database/habilities/assassin.txt");

    public static ArrayList<Hability> initializeWarriorHability() throws Exception {

        String line;
        ArrayList<Hability> list = new ArrayList<Hability>();

        try (FileReader fr = new FileReader(WARRIOR_HABILITY); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {
                Hability tempHability = Hability.fromString(line);

                list.add(tempHability);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if (list.isEmpty()) {
            throw new Exception("Error");
        }

        return list;
    }

    public static ArrayList<Hability> initializeWizardHability() throws Exception {

        String line;
        ArrayList<Hability> list = new ArrayList<Hability>();

        try (FileReader fr = new FileReader(WIZARD_HABILITY); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {
                Hability tempHability = Hability.fromString(line);

                list.add(tempHability);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if (list.isEmpty()) {
            throw new Exception("Error");
        }

        return list;
    }

    public static ArrayList<Hability> initializeAssassinHability() throws Exception {

        String line;
        ArrayList<Hability> list = new ArrayList<Hability>();

        try (FileReader fr = new FileReader(ASSASSIN_HABILITY); BufferedReader reader = new BufferedReader(fr)) {

            while ((line = reader.readLine()) != null) {
                Hability tempHability = Hability.fromString(line);

                list.add(tempHability);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if (list.isEmpty()) {
            throw new Exception("Error");
        }

        return list;
    }
}
