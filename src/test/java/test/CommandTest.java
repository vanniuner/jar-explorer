package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jarexplorer.ClassInformation;
import org.jarexplorer.JarExplorer;
import org.junit.Test;

/**
 * @author LZJ
 * @time 2021-12-03 08:44:12
 **/
public class CommandTest {

    /**
     * mvn test -Dtest=test.CommandTest#testName
     */
    @Test
    public void testName() throws Exception {
        String input = "";
        String search = "";
        String jarName = input.split("/")[input.split("/").length - 1];
        String jarPath = input.substring(0, input.length() - jarName.length());
        String destinationDir = jarPath + File.separator + "BOOT-INF/lib/";

        Runtime.getRuntime().exec("jar xvf " + jarPath + File.separator + jarName);
        JarExplorer jarExplorer = new JarExplorer();
        jarExplorer.scanDirectory(new File(destinationDir), new ArrayList<>());
        jarExplorer.indexJarFile(jarPath + File.separator + jarName);
        List<ClassInformation> arrayList = jarExplorer.search(search);
        arrayList = arrayList.stream().distinct().collect(Collectors.toList());
        for (ClassInformation classInformation : arrayList) {
            System.out.println("result: " + classInformation.getJarFileName());
        }

        // ZipJar.deleteDir(new File(destinationDir));
    }

}
