import java.util.Comparator;

public class HeapSort<T> {

    private Comparator<T> comparator;

    public HeapSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T[] heapSort(T[] arr) {

        int lastNode = (arr.length / 2) - 1;

        for (int i = lastNode; i >= 0; i--) {
            heapify(arr, arr.length-1, i);

        }

    for (int i=arr.length-1; i>=0; i--) 
        { 
            
            T temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            heapify(arr, i, 0); 
        } 
        return arr;
    }

    public void heapify(T[] arr, int n, int i) {

        int largest = i; 
        int l = 2 * i + 1;  
        int r = 2 * i + 2; 

        if (l < n && comparator.compare(arr[l], arr[largest]) > 0) {
            largest = l;
        }


        if (r < n && comparator.compare(arr[r], arr[largest]) > 0) {
            largest = r;
        }

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

}
