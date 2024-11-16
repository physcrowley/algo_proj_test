/*
 * Développer les algorithmes.
 * 
 * Les tests automatisés sont développés et lançables depuis DriverTest.java
 * 
 * Il y a aussi une méthode `main` ici pour écrire vos propre tests, au besoin.
 * 
 */

import java.io.*;
import java.util.*;

public class Driver {

    boolean isValidQuizDataFile(File test_file) {
        // structure de base pour lire et analyser le fichier
        try (Scanner reader = new Scanner(test_file)) {

        } catch (FileNotFoundException e) {
            System.out.printf(
                    "Nom/chemin de fichier invalide : %s. Analyse abandonnée.\n",
                    test_file);
        }

        return true; // valeur par défaut
    }

    String fileStructure(File current) {
        // à développer
        return null;
    }

    String prettyFileStructure(String compactFS) {
        // à développer
        return compactFS;
    }

    /** Pour tester manuellement vos algorithmes */
    public static void main(String[] args) {
        // Driver testClass = new Driver();
                // utiliser testClass pour appeler les méthodes d'instance

    }

}
