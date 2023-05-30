package heap;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    public void addElement(ArrayList<Integer>array,int data){

        array.add(data);

        int n = array.size()-1;
        int parent = (n-1)/2;

        while (array.get(n) > array.get(parent)){

            int temp = array.get(n);
            array.set(n, array.get(parent));
            array.set(parent,temp);

            n = parent;
            parent = (n-1)/2;
        }
    }

    public int peek(ArrayList<Integer> array){
        return array.get(0);
    }
    public void buildHeap(ArrayList<Integer>array){
        int n = array.size();
        for (int i = (n/2)-1; i>=0; i--){
            heapify(array, i, n);
        }
    }

    public void heapify(ArrayList<Integer> array, int i, int n) {

        int left = 2*i+1;
        int right = 2*i+2;
        int minIdx = i;

        if (left < n && array.get(left) > array.get(minIdx)){
            minIdx = left;
        }
        if (right < n && array.get(right) > array.get(minIdx)){
            minIdx = right;
        }
        if (minIdx != i){
            int temp = array.get(i);
            array.set(i, array.get(minIdx));
            array.set(minIdx, temp);
            heapify(array, minIdx, n);
        }
    }

    public int remove(ArrayList<Integer>array){
        int n = array.size();

        int data = array.get(0);
//        int temp = array.get(0);

        array.set(0, array.get(n-1));
        array.remove(n-1);

        heapify(array, 0, n);

        return data;
    }

    public void heapSort(ArrayList<Integer> array){
        int n = array.size();

        for (int i = (n/2)-1; i>=0; i--){
            heapify(array, i, n);
        }
        for (int i = n-1; i >=0; i--){

            int temp = array.get(0);
            array.set(0,array.get(i));
            array.set(i, temp);

            heapify(array,0, i);

        }
    }
}
