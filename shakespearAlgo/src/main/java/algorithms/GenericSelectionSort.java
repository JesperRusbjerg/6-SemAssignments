package algorithms;

public class GenericSelectionSort<T extends Comparable<T>> {

    private int amountOfN = 0;

    public T[] sort(T[] arr){

        int insert = 0;
        int smallestIndex;

        while(insert < arr.length){
            smallestIndex = insert;
            for (int i = 0; i < arr.length; i++) {
            amountOfN++;
                if(arr[i].compareTo(arr[smallestIndex]) < 0){
                    smallestIndex = i;
                }
            }

            swap(arr, insert, smallestIndex);

            insert ++;

        }
        return arr;
    }

    private void swap(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int getamountOfN() {
        return amountOfN;
    }

    public void setamountOfN(int amountOfN) {
        this.amountOfN = amountOfN;
    }
}
