package algorithms;

public class GenericMergeSort<T extends Comparable<T>> {
    private int amountOfN = 0;
    private int spaceComplexity = 0;


    public T[] sortTheMerge(T arr[]){
        sort(arr, 0, arr.length-1);
        amountOfN = amountOfN/arr.length;
        return arr;
    }

    private void sort(T arr[], int l, int r) {

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

    public void merge(T arr[], int l, int m, int r) {



        //Calculate sizes of arrays to be sorted
        int arraySizeLeft = m - l + 1;
        int arraySizeRight = r - m;

        //Create arrays that you will put values from original array into before sorting

        Object[] array;
        T[] arrayLeft = (T[]) new Comparable[arraySizeLeft];
        T[] arrayRight = (T[]) new Comparable[arraySizeRight];

        //Constantly updates this variable to the largest space complexity its seen
        // Spoiler: will end up being N :)
        if(arrayLeft.length+arrayRight.length > this.spaceComplexity){
            spaceComplexity = arrayLeft.length+arrayRight.length;
        }

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
            if (arrayLeft[leftPointer].compareTo(arrayRight[rightPointer]) <= 0) {

                arr[pointerOriginalArray] = arrayLeft[leftPointer];
                leftPointer++;
            } else {

                //else the right is smaller insert left back into the original array
                arr[pointerOriginalArray] = arrayRight[rightPointer];
                rightPointer++;
            }
            pointerOriginalArray++;
            amountOfN++;
        }

        //Empty the left array if it isnt empty already, at this point one of the arrays will be empty
        while (leftPointer < arraySizeLeft) {
            arr[pointerOriginalArray] = arrayLeft[leftPointer];
            leftPointer++;
            pointerOriginalArray++;
            amountOfN++;
        }

        // empty the other array if it isnt empty already
        while (rightPointer < arraySizeRight) {
            arr[pointerOriginalArray] = arrayRight[rightPointer];
            rightPointer++;
            pointerOriginalArray++;
            amountOfN++;
        }
    }

    public int getamountOfN() {
        return amountOfN;
    }

    public void setamountOfN(int amountOfN) {
        this.amountOfN = amountOfN;
    }

    public int getSpaceComplexity() {
        return spaceComplexity;
    }

    public void setSpaceComplexity(int spaceComplexity) {
        this.spaceComplexity = spaceComplexity;
    }
}
