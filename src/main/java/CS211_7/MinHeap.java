package CS211_7;

import java.util.Random;

/**
 * Created by RanPa on 5/30/2017.
 */
public class MinHeap {
    public static void main(String[] args) {
        myHeapArray heap = new myHeapArray();
        Random r = new Random();
        while (heap.size < 31) {
            int element = r.nextInt(100) + 1;
            heap.add(element);
            System.out.println("Add " + element + "; ");
            System.out.println("Heap size: " + heap.size);
            heap.ToString();
        }
        System.out.println();
        while (!heap.isEmpty()) {
            System.out.println("Remove Min: " + heap.remove());
            System.out.print("size: " + heap.size() + "  ");
            heap.ToString();
            System.out.println();
        }
    }
}