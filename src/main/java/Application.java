import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jarexplorer.ClassInformation;
import org.jarexplorer.JarExplorer;

/**
 * @time 2021-12-03 08:44:12
 **/
public class Application {

    /**
     * commit 1
     * commit 2
     * commit 3
     * commit 4
     */
    public static void main(String[] args) {
        try {
            String input = args[0];
            String search = args[1];
            String jarName = input.split("/")[input.split("/").length - 1];
            String jarPath = input.substring(0, input.length() - jarName.length());
            String classPath = "BOOT-INF/lib/";
            String destinationDir = jarPath + File.separator + classPath;

            Runtime.getRuntime().exec("jar xvf " + jarPath + File.separator + jarName);
            JarExplorer jarExplorer = new JarExplorer();
            jarExplorer.scanDirectory(new File(destinationDir), new ArrayList<>());
            jarExplorer.indexJarFile(jarPath + jarName);
            List<ClassInformation> arrayList = jarExplorer.search(search);
            arrayList = arrayList.stream().distinct().collect(Collectors.toList());
            for (ClassInformation classInformation : arrayList) {
                String tmp;
                if (classInformation.getJarFileName().split(classPath).length > 1) {
                    tmp = classInformation.getJarFileName()
                            .substring(classInformation.getJarFileName().split(classPath)[0].length() + classPath.length());
                } else {
                    tmp = classInformation.getJarFileName().split(classPath)[0];
                }
                System.out.println(classInformation.getClassName() + " → " + tmp);
            }
        } catch (Exception e) {
            System.out.println("useage:\n\tjava -jar x.jar YOUR_JAR_PATH SEARCH");
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        // ZipJar.deleteDir(new File(destinationDir));
    }

}
