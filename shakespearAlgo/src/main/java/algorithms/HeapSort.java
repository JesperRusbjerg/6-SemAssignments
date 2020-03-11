package algorithms;

public class HeapSort {

    public String[] heapSort(String[] arr) {

        int lastNode = (arr.length / 2) - 1;

        for (int i = lastNode; i >= 0; i--) {
            heapify(arr, arr.length-1, i);

        }

    for (int i=arr.length-1; i>=0; i--) 
        { 
            
            String temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            heapify(arr, i, 0); 
        } 
        return arr;
    }

    public void heapify(String[] arr, int n, int i) {

        int largest = i; 
        int l = 2 * i + 1;  
        int r = 2 * i + 2; 

        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }

        if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }

        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

}
