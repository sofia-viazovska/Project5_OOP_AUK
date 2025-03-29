package experiments_part0;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Part 0. Experiments with ArrayList and LinkedList
public class exper {
    public static void main(String[] args) {
        int numElements = 100000; // number of elements to test
        DecimalFormat formatter = new DecimalFormat("#,###"); // format numbers with commas

        // Initialize both lists
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Measure insertion at the beginning (add(0, element))
        long start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList - insertion at beginning: " + formatter.format(end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(0, i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList - insertion at beginning: " + formatter.format(end - start) + " ns");

        // Measure access by index (get(i))
        start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList - get by index: " + formatter.format(end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList - get by index: " + formatter.format(end - start) + " ns");

        // Measure removal from beginning (remove(0))
        start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.remove(0);
        }
        end = System.nanoTime();
        System.out.println("ArrayList - remove from beginning: " + formatter.format(end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.remove(0);
        }
        end = System.nanoTime();
        System.out.println("LinkedList - remove from beginning: " + formatter.format(end - start) + " ns");
    }
}
