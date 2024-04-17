package lab6;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> L) {
        if (L.isEmpty()){
            return L;
        } else if (L.size()==1) {
            return L;
        } else {
            Integer pivot = L.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> more = new ArrayList<>();
            partition(L, less, same, more, pivot);
            List<Integer> result = quickSort(less);
            result.addAll(same);
            result.addAll(quickSort(more));
            return result;
        }
    }

    public static void partition(List<Integer> L, List<Integer> less, List<Integer> same, List<Integer> more, Integer pivot) {
        for (Integer e: L){
            if (e < pivot){
                less.add(e);
            } else if (e > pivot){
                more.add(e);
            } else { same.add(e);}
        }
    }

    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(101);
        list.add(6);
//        System.out.println("Original List: " + list);
//        List<Integer> sortedList = quickSort(list);
//        System.out.println("Sorted List: " + sortedList);
        
//        sortWithPQ(list);
    }
}