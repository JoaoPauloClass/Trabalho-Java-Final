package controller;

import java.io.*;
import java.util.ArrayList;

import model.Hability;

public class HabilityController {
    private static final File WARRIOR_HABILITY = new File("src/database/habilities/warrior.txt");
    private static final File WIZARD_HABILITY = new File("src/database/habilities/wizard.txt");
    private static final File ASSASSIN_HABILITY = new File("src/database/habilities/assassin.txt");

    private static final File MINOTAUR_HABILITY = new File("src/database/habilities/minotaur.txt");
    private static final File DEMONKING_HABILITY = new File("src/database/habilities/demonking.txt");

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
            throw new Exception("Erro, lista de habilidades vazia");
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
            throw new Exception("Erro, lista de habilidades vazia");
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
            throw new Exception("Erro, lista de habilidades vazia");
        }

        return list;
    }

    public static ArrayList<Hability> initializeMinotaurHability() throws Exception {

        String line;
        ArrayList<Hability> list = new ArrayList<Hability>();

        try (FileReader fr = new FileReader(MINOTAUR_HABILITY); BufferedReader reader = new BufferedReader(fr)) {

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

    public static ArrayList<Hability> initializeDemonKingHability() throws Exception {

        String line;
        ArrayList<Hability> list = new ArrayList<Hability>();

        try (FileReader fr = new FileReader(DEMONKING_HABILITY); BufferedReader reader = new BufferedReader(fr)) {

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
