package algorithms;

public class MergeSort {



    public MergeSort() {
    }

    public String[] sortTheMerge(String arr[]){
        sort(arr, 0, arr.length-1);
        return arr;
        
    }
    
    public void sort(String arr[], int l, int r) {
        
        //Has to be a diffrence in the sides for there to be a need to split further
        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;

            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves 
            merge(arr, l, m, r);
        }
    }



    public void merge(String arr[], int l, int m, int r) {

        //Calculate sizes of arrays to be sorted
        int arraySizeLeft = m - l + 1;
        int arraySizeRight = r - m;

        //Create arrays that you will put values from original array into before sorting
        String[] arrayLeft = new String[arraySizeLeft];
        String[] arrayRight = new String[arraySizeRight];

        //Insert values into the left array from original array
        for (int i = 0; i < arraySizeLeft; i++) {
            arrayLeft[i] = arr[i + l];
        }
        //Insert values into the right array from original array
        for (int j = 0; j < arraySizeRight; j++) {
            arrayRight[j] = arr[j + m + 1];
        }

        //Make a pointer for the left array
        int leftPointer = 0;
        //Make a pointer for the right array
        int rightPointer = 0;
        //Pointer that points to the left side of the sub arrays and the index we start from in the original array
        int pointerOriginalArray = l;

        //Run through both lists untill either is empty
        while (leftPointer < arraySizeLeft && rightPointer < arraySizeRight) {
            //Compare the left pointer to the right pointer, if theyre the same or left is smaller, insert left back into the original array
            if (arrayLeft[leftPointer].compareTo(arrayRight[rightPointer]) < 0) {

                arr[pointerOriginalArray] = arrayLeft[leftPointer];
                leftPointer++;
            } else {

            //else the right is smaller insert left back into the original array
                arr[pointerOriginalArray] = arrayRight[rightPointer];
                rightPointer++;
            }
            pointerOriginalArray++;
        }
        
        //Empty the left array if it isnt empty already, at this point one of the arrays will be empty
        while (leftPointer < arraySizeLeft) {
            arr[pointerOriginalArray] = arrayLeft[leftPointer];
            leftPointer++;
            pointerOriginalArray++;
        }

        // empty the other array if it isnt empty already
        while (rightPointer < arraySizeRight) {
            arr[pointerOriginalArray] = arrayRight[rightPointer];
            rightPointer++;
            pointerOriginalArray++;
        }

    }



    // Below this point its my first implementation, where i use actual arrays like its visualized
    // Little easier to understand because the array dosent sort "in place"

    public String[] mergeSort(String[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int n = arr.length;

        String[] left = new String[(n + 1) / 2];
        String[] right = new String[n - left.length];

        for (int i = 0; i < n; i++) {
            if (i < left.length) {
                left[i] = arr[i];
            } else {
                right[i - left.length] = arr[i];
            }
        }

        String[] res1 = mergeSort(left);
        String[] res2 = mergeSort(right);

        String[] s = merge(res1, res2);

        return s;
    }

    public String[] merge(String[] arr, String[] arr2) {
        String[] res = new String[arr.length + arr2.length];
        int rightPointer = 0;
        int leftPointer = 0;
        int i = 0;
        boolean leftEmpty = true;
        while (true) {
            if (leftPointer == arr.length) {
                //left empty
                leftEmpty = true;
                break;
            } else if (rightPointer == arr2.length) {
                //right empty
                leftEmpty = false;
                break;
            } else {
                if (arr[leftPointer].compareTo(arr2[rightPointer]) < 0) {
                    res[i] = arr[leftPointer];
                    leftPointer++;
                } else {
                    res[i] = arr2[rightPointer];
                    rightPointer++;
                }
            }
            i++;
        }

        if (leftEmpty) {
            for (int j = rightPointer; j < arr2.length; j++) {
                res[i] = arr2[rightPointer];
                rightPointer++;
                i++;
            }
        } else {
            for (int j = leftPointer; j < arr.length; j++) {
                res[i] = arr[leftPointer];
                leftPointer++;
                i++;

            }
        }
        return res;
    }



}
