package ua.nure.antoniuk.Practice6.part2;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Max on 05.12.2017.
 */
public class Part2 {

    public static void remove1(List<Object> list, int k) {
        //List<Object> l = new ;
        //Collections.copy(l, list);
        int i = 0;
        Iterator<Object> it;
        while (list.size() != 1) {

            it = list.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
                if (i == k) {
                    it.remove();
                    i = 0;
                }
            }
        }
    }

    public static void remove2(List<Object> list, int k) {
        int ri = 0;
        while (!list.isEmpty()) {
            int index = ri + k - 1;

            if (index > list.size() - 1) {
                index %= list.size();
            }
            list.remove(index);
            ri = index;
        }
    }

    public static void init(List<Object> list) {
        for(int i = 0; i < 100000; i++) {
            list.add(new Object());
        }
    }

    public static void main(String[] args) {
        List<Object> list = new LinkedList<>();
        List<Object> arr = new ArrayList<>();
        List<Object> list1 = new LinkedList<>();
        List<Object> arr1 = new ArrayList<>();
        init(list);
        init(arr);
        init(list1);
        init(arr1);

        long before = System.currentTimeMillis();
        remove1(list, 3);
        long after = System.currentTimeMillis();
        System.out.println("Iterator remove LinkedList: " + (after - before));
        before = System.currentTimeMillis();
        remove1(arr, 3);
        after = System.currentTimeMillis();
        System.out.println("Iterator remove ArrayList: " + (after - before));
        before = System.currentTimeMillis();
        remove2(list1, 3);
        after = System.currentTimeMillis();
        System.out.println("Index remove LinkedList: " + (after - before));
        before = System.currentTimeMillis();
        remove2(arr1, 3);
        after = System.currentTimeMillis();
        System.out.println("Index remove ArrayList: " + (after - before));
    }
}
