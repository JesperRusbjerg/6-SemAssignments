package algorithms;

public class InsertionSort {

    public InsertionSort() {

    }

    public String[] sort(String[] arr) {

        int pin = 1;
        while (pin < arr.length) {
            int grabbed = pin;
            for (int i = pin - 1; i >= 0; i--) {
                if (arr[grabbed].compareTo(arr[i]) < 0) {
                    swap(arr, grabbed, i);
                    grabbed--;
                } else {
                    break;
                }
            }
            pin++;

        }
        return arr;

    }

    private void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}