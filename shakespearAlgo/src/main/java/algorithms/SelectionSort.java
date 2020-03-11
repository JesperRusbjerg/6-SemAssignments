package algorithms;

public class SelectionSort {

    public SelectionSort(){
        
    }
    
    public String[] sort(String[] arr){

        int insert = 0;
        int smallestIndex;
        
        while(insert < arr.length-1){
            smallestIndex = insert;
            for (int i = insert+1; i < arr.length; i++) {
                if(arr[i].compareTo(arr[smallestIndex]) < 0){
                    smallestIndex = i;
                }
            }
            
            System.out.println("First round done, Time to swap: " +arr[insert] + " and " + arr[smallestIndex]);
            
            swap(arr, insert, smallestIndex);

            insert ++;  

        }
        return arr;
    }

    private void swap(String[] arr, int a, int b){
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}