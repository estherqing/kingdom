package springTest.basic;


import com.esther.code.common.utils.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author esther
 * 2018-03-27 14:47
 * $DESCRIPTION}
 */

public class GetFieldsAnnotationTest {
    // 年龄
    public int age;
    /**
     * 姓名
     */
    public String name;

    public int getAge(){
        return  this.age;
    }
    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        getPKName(GetFieldsAnnotationTest.class);
    }
    public static String getPKName(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] annotations = f.getAnnotations();
            System.out.println(f.getName());
            if (annotations.length <= 0) {
                String name = f.getName();
                String setMethodName = "get" + StringUtils.left(name, 1).toUpperCase() + StringUtils.substring(name, 1);
                try {
                    System.out.println(setMethodName);
                    Method method = clazz.getDeclaredMethod(setMethodName);
                    annotations = method.getAnnotations();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Annotation anno : annotations) {
                if (anno.toString().contains("@javax.persistence.Id()")) {
                    System.out.println(f.getName());
                    return f.getName();
                }
            }
        }
        return null;
    }
}
