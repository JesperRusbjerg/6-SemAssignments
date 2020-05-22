package algorithms;

public class GenericSelectionSort<T extends Comparable<T>> {

    private int complexityCounter = 0;
    private int spaceComplexity = 0;

    public T[] sort(T[] arr){

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                complexityCounter++;
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;

            }
            // Swap the found minimum element with the first
            // element
            swap(arr, min_idx, i);
        }

        return arr;
    }

    private void swap(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int getComplexityCounter() {
        return complexityCounter;
    }

    public void setComplexityCounter(int complexityCounter) {
        this.complexityCounter = complexityCounter;
    }

    public int getSpaceComplexity() {
        return spaceComplexity;
    }

    public void setSpaceComplexity(int spaceComplexity) {
        this.spaceComplexity = spaceComplexity;
    }
}
