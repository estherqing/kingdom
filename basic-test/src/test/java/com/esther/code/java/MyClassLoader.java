package com.esther.code.java;


import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author esther
 * 2018-07-11 15:17
 * $DESCRIPTION}
 */

public class MyClassLoader extends ClassLoader {
    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) {
        // First, check if the class has already been loaded
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            System.out.println("返回已经加载过的Class");
            return loadedClass;
        }
        ClassLoader parent = this.getParent();
        if (parent != null) {
            Class<?> c = null;
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("默认双亲委派机制没有加载到该类！");
            }
            if (c != null) {
                return c;
            }
        }
        String path = rootDir + name.replaceAll("\\.", "/") + ".class";
        System.out.println(path);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            byte[] classByteData = IOUtils.toByteArray(fileInputStream);
            loadedClass = defineClass(name, classByteData, 0, classByteData.length);
            if (loadedClass == null) {
                throw new ClassNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return loadedClass;
    }
}
