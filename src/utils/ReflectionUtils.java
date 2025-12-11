package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 反射工具类
 * 用于扫描指定包下的所有类
 */
public class ReflectionUtils {

    /**
     * 扫描指定包下的所有类
     */
    public static List<Class<?>> scanClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        
        // 获取类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(packagePath);
        
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            if (resource.getProtocol().equals("file")) {
                // 处理文件系统路径
                String filePath = resource.getPath().replace("%20", " ");
                findClassesInDirectory(packageName, filePath, classes);
            }
        }
        
        return classes;
    }
    
    /**
     * 在目录中查找类
     */
    private static void findClassesInDirectory(String packageName, String directoryPath, List<Class<?>> classes) 
            throws ClassNotFoundException {
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }
        
        // 查找所有文件和子目录
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归处理子目录
                    String subPackageName = packageName + "." + file.getName();
                    findClassesInDirectory(subPackageName, file.getAbsolutePath(), classes);
                } else if (file.getName().endsWith(".class")) {
                    // 处理类文件
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = Class.forName(className);
                    classes.add(clazz);
                }
            }
        }
    }
}