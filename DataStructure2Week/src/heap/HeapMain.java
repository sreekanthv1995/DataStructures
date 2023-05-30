package heap;

import java.util.ArrayList;

public class HeapMain {

    public static void main(String[] args) {
        Heap heap = new Heap();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(10);
        array.add(25);
        array.add(54);
        array.add(20);
        array.add(44);
        array.add(67);
        array.add(81);
        array.add(90);
        array.add(36);
        array.add(77);
        System.out.println(array);
        heap.buildHeap(array);
        System.out.println(array);
        heap.addElement(array,100);
        heap.addElement(array,200);
        System.out.println(array);
        heap.heapSort(array);
        System.out.println(array);

    }
}
