package CS211_7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by RanPa on 5/30/2017.
 */

public class myHeapArray {
    public int size;
    private int[] IntList;

    public myHeapArray() {
        IntList = new int[100];
        size = 0;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

    private boolean hasParent(int index) {
        return index > 1;
    }

    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public int size() {
        return size;
    }

    public void add(int element) {
        if (size + 1 >= IntList.length) {
            IntList = Arrays.copyOf(IntList, IntList.length * 2);
        }
        IntList[size + 1] = element;
        int index = size + 1;
        boolean judge = false;
        while (!judge && hasParent(index)) {
            int parentIndex = parent(index);
            if (IntList[index] < IntList[parentIndex]) {
                swap(IntList, index, parent(index));
                index = parent(index);
            } else {
                judge = true;
            }
        }
        size++;
    }

    public int remove() {
        int result = peek();
        IntList[1] = IntList[size];
        size--;

        int index = 1;
        boolean judge = false;
        while (!judge && hasLeftChild(index)) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            int child = leftIndex;
            if (hasRightChild(index) && IntList[rightIndex] < IntList[leftIndex]) {
                child = rightIndex;
            }
            if (IntList[index] > IntList[child]) {
                swap(IntList, index, child);
                index = child;
            } else {
                judge = true;
            }
        }
        return result;
    }

    private int peek() {
        return IntList[1];
    }

    public void ToString() {
        System.out.print("[");
        for (int i = 1; i <= size; i++) {
            System.out.print(IntList[i]);
            System.out.print(" ");
        }
        System.out.println("]");

        int totalLine = countTotalLine();
        System.out.println("totalLine: " + totalLine);
        int index = 1;
        int lineMax = 1;
        int column = 1;
        String output = "";
        while (index <= size) {
            if (column == 1)
                output = output + buildBlacks(totalLine);
            else
                output = output + buildBlacks(totalLine + 1);
            output = output + IntList[index];
            index++;
            column++;
            if (column > lineMax) {
                output = output + "\n";
                column = 1;
                lineMax *= 2;
                totalLine--;
            }
        }
        System.out.println(output + "\n=====================\n");

    }

    public String buildBlacks(int input) {

        if (input == 0) return "";
        if (input == 1) return " ";
        int current = 1;
        String result = " ";
        while (current < input) {
            result = result.replace(" ", "  ") + "  ";
            current++;
        }
        return result;
    }

    public int countTotalLine() {
        int result = 1;
        int index = 1;
        int lineMax = 1;
        int column = 1;
        while (index <= size) {
            index++;
            column++;
            if (column > lineMax) {
                column = 1;
                lineMax *= 2;
                result++;
            }
        }
        return result;
    }
}