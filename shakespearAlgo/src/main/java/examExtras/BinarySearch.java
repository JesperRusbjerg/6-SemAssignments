package examExtras;

public class BinarySearch {

    private int[] numbers = {4, 3 , 5 , 7, 8 , 11, 14};


    public int binarySearch(int number){

        int end = numbers.length-1;
        int startPoint = 0;

        while(true){

            int indexToCheck = (startPoint+end)/2;

             if(numbers[indexToCheck] == number){
                return indexToCheck;
            }else if(numbers[indexToCheck] > number){
                end = indexToCheck;
            }else if(numbers[indexToCheck] < number){
                startPoint = indexToCheck;
            }
        }

    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        System.out.println(bs.binarySearch(11));
    }

}
