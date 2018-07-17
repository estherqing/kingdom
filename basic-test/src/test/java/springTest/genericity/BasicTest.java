package springTest.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author esther
 * 2018-01-10 10:21
 * $DESCRIPTION}
 */

public class BasicTest {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(20);
        List<String> ls = list;
        //System.out.println(ls.get(0));

        faultyMethod(Arrays.asList("hello"),Arrays.asList("world"));
    }

   // @SafeVarargs
    private static void faultyMethod(List<String>... listStrArray) {
        List[] list = listStrArray;
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(20);
        list[0] = myList;
        String s = listStrArray[0].get(0);
    }
}
