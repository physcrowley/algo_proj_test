import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
import java.io.*;

public class AlgosTest {

    /** Objet qui contient les méthodes à tester */
    Algos testClass;

    @Test
    public void testWillNotCrashLoadData() {

        testClass = new Algos(); // nouvelle instance pour le test

        /*
         * Enlever les commentaires pour ajouter les cas de tests.
         * 
         * Les cas de test sont déclarés dans l'ordre logique pour la 
         * structure valide de fichier pour un quiz.
         * 
         * Le premier test, pour un fichier vide, est actif (décommenté).
         * 
         */
        HashMap<String, Boolean> expected = new HashMap<>();
        expected.put("empty.qz", false);
        // expected.put("zero.qz", false);
        // expected.put("missing_options.qz", false);
        // expected.put("wrong_order.qz", false);
        // expected.put("not_a_number.qz", false);
        // expected.put("bad_index.qz", false);
        // expected.put("wrong_number.qz", false);
        // expected.put("valid.qz", true);

        // liste de fichiers correspondant aux cas de test définis
        File folder = new File("./test_data/");
        File[] files = folder.listFiles(f -> expected.containsKey(f.getName()));

        // tests
        for (File f : files) {
            String fileName = f.getName();
            String msg = "Test pour " + fileName + " : échoué";
            assertEquals(msg, expected.get(fileName), testClass.willNotCrashLoadData(f));
        }

    }

    @Test
    public void testFileStructure() {

        testClass = new Algos(); // nouvelle instance pour le test

        // cas de test
        String structureA = "./test_subfolderA";
        String structureB = "./test_subfolderB";

        HashMap<String, String> expected = new HashMap<>();
        expected.put(
                structureA,
                "test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),");
        expected.put(
                structureB,
                "test_subfolderB(.vscode(\"settings.json\",),bin(edu(ics4u(algos(\"App.class\",),),),),lib(\"hamcrest-core-1.3.jar\",\"junit-4.13.2.jar\",),src(edu(ics4u(algos(\"App.java\",),),),),\"README.md\",),");
       
        // tests
        for (String root : new String[] { structureA, structureB }) {
            File rootFile = new File(root);
            assertEquals(expected.get(root), testClass.fileStructure(rootFile));
        }

    }

    @Test
    public void testPrettyFileStructure() {

        testClass = new Algos(); // nouvelle instance pour le test

        // cas de test
        HashMap<String, String> expected = new HashMap<>();

        expected.put(
                "test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),",

                "test_subfolderA\n    a\n        b\n            \"xx.txt\"\n            \"yy.txt\"\n        \"x.txt\"\n    c\n        \"z.txt\"\n        \"zzz.txt\"");

        expected.put(
                "test_subfolderB(.vscode(\"settings.json\",),bin(edu(ics4u(algos(\"App.classy\",),),),),lib(\"hamcrest-core-1.3.jar\",\"junit-4.13.2.jar\",),\"README.md\",src(edu(ics4u(algos(\"App.coffee\",),),),),),",

                "test_subfolderB\n    .vscode\n        \"settings.json\"\n    bin\n        edu\n            ics4u\n                algos\n                    \"App.classy\"\n    lib\n        \"hamcrest-core-1.3.jar\"\n        \"junit-4.13.2.jar\"\n    \"README.md\"\n    src\n        edu\n            ics4u\n                algos\n                    \"App.coffee\"");

        // tests
        for (String fsOutput : expected.keySet()) {
            assertEquals(expected.get(fsOutput), testClass.prettyFileStructure(fsOutput));
        }

    }

}
