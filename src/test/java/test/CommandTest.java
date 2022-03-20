package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.jarexplorer.ClassInformation;
import org.jarexplorer.JarExplorer;
import org.junit.Test;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

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

    /**
     * mvn test -Dtest=test.CommandTest#genSerNumber
     * 生成打印条码序列
     * 规则：3位置工厂编码 + (99999999999999999-日期) + 4位自增序列号
     */
    @Test
    public void genSerNumber() {
        ConcurrentHashMap<Long,Boolean> concurrentHashMap = new ConcurrentHashMap();
        new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    functiont();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    functiont();
                }
            }
        }.start();
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void functiont() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println(id);
    }


}
