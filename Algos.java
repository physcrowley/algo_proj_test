/*
 * Développer les algorithmes pour les trois défis.
 * 
 * Les tests unitaires sont développés et lançables depuis AlgosTest.java
 * 
 * Si les tests unitaires échouent, vous pouvez lancez votre algorithme dans Driver.java 
 * en mode débogage avec des points d'arrêt aux endroits à vérifier dans le code ici. 
 * Cela vous permet de voir les valeurs des différentes variables à différents instants 
 * durant l'exécution de votre algorithme pour mieux trouver l'erreur.
 * 
 */

import java.io.*;
import java.util.*;

public class Algos {

    /** Pour le défi 1 - Voir la méthode {@code loadData(String)} dans la classe Questionnaire. */
    boolean willNotCrashLoadData(File test_file) {
        try (Scanner reader = new Scanner(test_file)) {

            // vos vérifications ici

        } catch (FileNotFoundException e) {
            System.out.printf(
                    "Nom/chemin de fichier invalide : %s. Analyse abandonnée.\n",
                    test_file);
        }

        return true; // valeur par défaut
    }

    /** Pour le défi 2 */
    String fileStructure(File current) {
        // à développer
        return null;
    }

    /** Pour le défi 3 */
    String prettyFileStructure(String compactFS) {
        // à développer
        return compactFS;
    }

}