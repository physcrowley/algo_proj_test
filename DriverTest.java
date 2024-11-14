import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
import java.io.*;

public class DriverTest {

    @Test
    public void testIsValidQuizDataFile() {


        Driver testClass = new Driver();
        File quizTestFolder = new File("./test_data");
        
        HashMap<String, Boolean> expected = new HashMap<>();
        expected.put("bad_index.qz", false);
        expected.put("empty.qz", false);
        expected.put("missing_options.qz", false);
        expected.put("not_a_number.qz", false);
        expected.put("valid.qz", true);
        expected.put("wrong_number.qz", false);
        expected.put("wrong_order.qz", false);
        expected.put("zero.qz", false);
        
        
        File[] testFiles = quizTestFolder.listFiles();

        // vérifier que `expected` a été bien définie
        for (File f : testFiles) {
            if (!expected.containsKey(f.getName())) {
                System.out.print(f.getName());
                System.out.println(" - Le test est mal formé. Revoir la définition des valeurs attendues");
                return;
            }
        }

        // tests
        for (File f : testFiles) {
            String fileName = f.getName();
            assertEquals(expected.get(fileName), testClass.isValidQuizDataFile(f));
        }

    }

    @Test
    public void testFileStructure() {

        Driver testClass = new Driver();

        String structureA = "./test_subfolderA";
        String structureB = "./test_subfolderB";

        HashMap<String, String> expected = new HashMap<>();
        expected.put(
                structureA,
                "test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),");
        expected.put(
                structureB,
                "test_subfolderB(.vscode(\"settings.json\",),bin(edu(ics4u(algos(\"App.class\",),),),),lib(\"hamcrest-core-1.3.jar\",\"junit-4.13.2.jar\",),src(edu(ics4u(algos(\"App.java\",),),),),\"README.md\",),");
        
        for (String root : new String[]{structureA, structureB})  {
            File rootFile = new File(root);
            assertEquals(expected.get(root), testClass.fileStructure(rootFile));
        }      

    }

    @Test
    public void testPrettyFileStructure() {

        Driver testClass = new Driver();

        HashMap<String, String> expected = new HashMap<>();
        expected.put(
                "test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),",
                "test_subfolderA\n    a\n        b\n            \"xx.txt\"\n            \"yy.txt\"\n        \"x.txt\"\n    c\n        \"z.txt\"\n        \"zzz.txt\"\n");
        expected.put(
                "test_subfolderB(.vscode(\"settings.json\",),bin(edu(ics4u(algos(\"App.class\",),),),),lib(\"hamcrest-core-1.3.jar\",\"junit-4.13.2.jar\",),src(edu(ics4u(algos(\"App.java\",),),),),\"README.md\",),",
                "test_subfolderB\n    .vscode\n        \"settings.json\"\n    bin\n        edu\n            ics4u\n                algos\n                    \"App.class\"\n    lib\n        \"hamcrest-core-1.3.jar\"\n        \"junit-4.13.2.jar\"\n    \"README.md\"\n    src\n        edu\n            ics4u\n                algos\n                    \"App.java\"");

        for (String fsOutput : expected.keySet()) {
            assertEquals(expected.get(fsOutput), testClass.prettyFileStructure(fsOutput));
        }

    }
}
