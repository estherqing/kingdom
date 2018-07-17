package springTest.mad_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author esther
 * 2018-01-04 10:35
 * $DESCRIPTION}
 */

public class MyTest {
    public static void main(String[] args) {
        System.out.println(args.length);
        Stream.of(args).forEach(arg -> System.out.println(arg));

        // scanner(); // 键盘输入
        // scannerFile(); // 从文件获取
        // system(); // 系统相关环境变量和属性
//        hashcode();
//        runtime();

    }



    private static void runtime(){
        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
        //直接单独启动一个进程来运行操作系统的命令
        try {
            runtime.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void hashcode() {
        String s1 = new String("java");
        String s2 = new String("java");
        // String类重写了hashcode函数，是根据字符序列计算的
        System.out.println(s1.hashCode() + "---" + s2.hashCode());
       //  identityHashCode根据对象的地址计算的，所有任何两个对象的identityHashCode值总是不相等的。
        System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));
        String s3 = "java";
        String s4 = "java";
        System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));

    }

    private static void system() {
        Map<String, String> map = System.getenv();
        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
        System.out.println(System.getenv("JAVA_HOME"));
        Properties prps = System.getProperties();
        // 将所有的系统属性保存到props.txt文件中
        try {
            prps.store(new FileOutputStream("props.txt"), "System Properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.getProperty("os.name"));
    }

    private static void scanner() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            System.out.println("键盘输入的内容是：" + scanner.next());
        }
    }

    private static void scannerFile() {
        try {
            Scanner sc = new Scanner(new File("E:\\IdeaProjects\\springTest\\src\\test\\java\\com\\springTest\\mad_java\\MyTest.java"));
            System.out.println("文件内容如下：");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
