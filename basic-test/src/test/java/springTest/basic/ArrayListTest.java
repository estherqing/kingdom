package springTest.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author esther
 * 2018-03-09 11:36
 * $DESCRIPTION}
 */

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        for (String temp : a) {
            System.out.println(temp);
            if("2".equals(temp)){
//                a.add("4");
//                a.remove(temp);
            }
        }

        /*
        * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的add/remove/clear方法会抛出UnsupportedOperationException异常
        */
        List<String> t   = Arrays.asList("a","b","c");
        //warn
//        t.add("22");
        //warn
//        t.remove("22");
        //warn
//        t.clear();

        List<String> list = new ArrayList<String>();
        list.add("22");
        //warn
//        List<String> Test = (ArrayList<String>) list.subList(0, 1);
        System.out.println("-----------------");
        System.out.println( BigDecimal.valueOf(100).subtract(BigDecimal.valueOf(66.670000)).divide(BigDecimal.valueOf(100), BigDecimal.ROUND_CEILING));



    }
}
