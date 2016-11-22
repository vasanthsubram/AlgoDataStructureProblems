package utils;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author vsubramanian
 */
public class CollectionPrinter {

    public static void print(Collection c){
        for(Object o : c){
            System.out.println(o);
        }
    }

    public static void print(Map map){
        for(Object o : map.values()){
            System.out.println(o);
        }
    }
}
