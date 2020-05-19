package examExtras;

import algorithms.HeapSort;
import examExtrasInterfaces.PriorityQue;

public class PriorityQueue implements PriorityQue<String> {

    private final String[] items;
    private int size = 0;
    //private int head = 0; // index of the current front item, if one exists
    //private int tail = 0; // index of next item to be added


    public PriorityQueue(int capacity) {
        items = new String[capacity];
    }

    @Override
    public void enqueue(String item) {
        if (size == 0) {
            size++;
            items[1] = item;
            return;
        }
        ++size;
        items[size] = item;
        swim(item, size);
    }

    @Override
    public String dequeue() {
        items[0] = items[1];
        items[1] = items[size];
        items[size] = null;
        size--;

        sink(items[1], 1);

        String returnString = items[0];
        items[0] = null;
        return returnString;
    }

    @Override
    public String peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void swim(String element, int index) {
        int parent = index / 2;

        if (index > 1) {
            if (items[parent].compareTo(element) > 0) {
                swap(index, parent);
                swim(element, parent);
            }
        }
    }

    public void swap(int index, int parent) {
        String swappi = items[index];
        items[index] = items[parent];
        items[parent] = swappi;

    }

    @Override
    public void sink(String element, int index) {
        //2*k or 2*k+1
        int left = index * 2;
        int right = index * 2 + 1;
        int winner;

        if (left < size) {
            if (items[left].compareTo(items[right]) > 0) {
                winner = right;
            } else {
                winner = left;
            }

            if (items[winner].compareTo(element) < 0) {
                swap(index, winner);
                sink(element, winner);
            }
        }

    }

    public String[] getItems() {
        return items;
    }

    public static void main(String[] args) {
        PriorityQueue qs = new PriorityQueue(12);

        qs.enqueue("hej");
        qs.enqueue("bbb");
        qs.enqueue("bb");
        qs.enqueue("aaa");
        qs.enqueue("aaaaa");
        qs.enqueue("fff");
        qs.enqueue("kk");
        qs.enqueue("c");
        qs.enqueue("gg");
        qs.enqueue("xx");


        String tt = qs.dequeue();
        qs.dequeue();
        qs.dequeue();
        qs.dequeue();
        qs.dequeue();

        String[] items = qs.getItems();

        for (String e : items) {
            System.out.println(e);
        }

    }

}


