package Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicStream {
    static int[] array ={1,2,3,11,7,2,9,4,11};

    public static void main(String[] args) {
        Integer sum = Arrays.stream(array).map(array->array)
                .filter(array->array>=10)
                .reduce(0,(a,b)->a+b);
//        System.out.println(sum);
        Set<Integer> items = new HashSet<>();
        //find duplicate
        Arrays.stream(array).filter(array->!items.add(array))
                .forEach(value -> System.out.print(" "+value));



    }
}
