import java.util.*;
import java.io.*;

void main() {
    // declare an object to inspect a folder structure
    File cwd = new File("./test_subfolderB");

    // String output = fileStructure(cwd);
    String output = prettyFileStructure(fileStructure(cwd));
    output = output.replace("\n", "\\n").replace("\"", "\\\"");
    System.out.println(output);
    // System.out.println(output.equals(
    //         "test_subfolderA(a(b(\"xx.txt\",\"yy.txt\",),\"x.txt\",),c(\"z.txt\",\"zzz.txt\",),),"));
}

String fileStructure(File dir) {
    // cas de base
    if (dir.isFile()) {
        return "\"" + dir.getName() + "\",";
    }
    if (dir.getName().equals(".git")) {
        return "";
    }
    // cas récursif
    String result = dir.getName() + "(";
    for (File f : dir.listFiles()) {
        result += fileStructure(f);
    }
    return result + "),";
}

String prettyFileStructure(String fs) {
    if (fs.length() == 0) {
        return fs;
    }
    String indent = "";
    String pfs = "" + fs.charAt(0);
    int cur = 1;
    while (cur < fs.length() - 2) {
        switch (fs.charAt(cur)) {
            case ',':
                pfs += fs.charAt(cur + 1) == ')' ? "" : "\n" + indent;
                break;
            case '(':
                indent += "    "; // 4 espaces
                pfs += "\n" + indent;
                break;
            case ')':
                indent = indent.length() > 4 ? indent.substring(4) : "";

                break;
            default:
                pfs += fs.charAt(cur);
        }
        cur++;
    }
    return pfs;
}