import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriorityQueue<T> implements Queue<T> {

    private int size;
    private T[] arr;
    private HeapSort hs;

    private int start = 0;
    private int end = 0;
    private int arrLength;

    public ArrayPriorityQueue(T[] items, Comparator<T> comparator) {
        this.arr = items;
        this.hs = new HeapSort<T>(comparator);
        this.arrLength = items.length;
    }

    //Provide with a ascending comparator
    public void sortAscending(Comparator<T> comparator) {
        this.hs = new HeapSort<T>(comparator);
        sort();
    };

    //Provide with a descending comparator
    public void sortDescending(Comparator<T> comparator) {
        this.hs = new HeapSort<T>(comparator);
        sort();
    };

    public void sort() {
        T[] newArray = Arrays.copyOfRange(arr, start % arrLength, end % arrLength);

        hs.heapSort(newArray);

        int counter = 0;
        for (int i = start % arrLength; i < end % arrLength; i++) {
            arr[i] = newArray[counter];
            counter ++;
        }
    };

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIteratior();
    }

    @Override
    public void enqueue(T item) {
        int index = end % arrLength;
        arr[index] = item;
        end ++;
        size++;
        sort();
    }

    @Override
    public void dequeue() {
        start++;
        size--;
        sort();
    }


    public static void main(String[] args) {

        String[] gg = new String[10];

        Comparator ascending = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        Comparator descending = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        };

        ArrayPriorityQueue<String> g = new ArrayPriorityQueue<String>(gg, ascending);
        g.enqueue("q");
        g.enqueue("l");
        g.enqueue("i");
        g.enqueue("t");
        g.enqueue("x");
        g.enqueue("f");
        g.enqueue("g");
        g.enqueue("a");
        g.sort();

        for (String string : g) {
            System.out.println(string);
        }

    }

    private class TIteratior implements Iterator<T> {
        private int index = start;
        
        private int count = 0;

        public boolean hasNext() {
            if(count >= size){
                return false;
            }
             count++;
             return true;
            }

        public T next() { 
            T item = arr[index % arrLength];
            index ++;
            return item;

        }
    } 

};
