package algortihmTest;

import algorithms.GenericMergeSort;
import algorithms.GenericSelectionSort;
import algorithms.Trie;
import entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Random;

import java.io.IOException;

public class ProofOfConcepTests {

    public ProofOfConcepTests() {
    }

    @Test
    public void Test_Insertion_Is_OofLength_Trie() {
        String[] test = {"JesperSkriverNogleFantastiskeTests"};

        Trie t = new Trie();
        t.CreateTrie(test);
        int amountOfOperations = t.getInsertCounter();

        int expectedAmountOfOperations = test[0].length();
        Assert.assertEquals(expectedAmountOfOperations, amountOfOperations);
    }

    @Test
    public void Test_Trie_Search_is_OofLength_True() {
        String[] test = {"Jesper", "Per", "Perlt", "Anders", "Martin"};

        Trie t = new Trie();
        t.CreateTrie(test);
        t.setInsertCounter(0);

        Trie.Pair p = t.search("Jesper");

        int expectedAmountOfOperations = test[0].length();
        int amountOfOperations = t.getInsertCounter();

        Assert.assertEquals(amountOfOperations, expectedAmountOfOperations);
        Assert.assertEquals(p.getName(), test[0]);
    }

    @Test
    public void Test_Trie_Worst_Case_Space_Complexity(){

        String[] test = {"Jesper", "Pe", "Xylvia", "Ander", "Martin", "Catha"};
        Trie t = new Trie();
        t.CreateTrie(test);

        // (Avg word length * amount of words * length of array it stores(sizeOfAlphabet)
        int averageLengthOfWord = 0;

        for(String str: test){
            averageLengthOfWord += str.length();
        }
        averageLengthOfWord = averageLengthOfWord/test.length;

        int totalSpace = averageLengthOfWord*test.length*Trie.sizeOfAlphabet;
        int size = t.getSpace();

        Assert.assertEquals(totalSpace, size);

    }


    // Stable and not stable test
    @Test
    public void Test_MergeSort_Is_Stable() {
        GenericMergeSort<Person> gms = new GenericMergeSort<>();

        Person p = new Person("xx", 24);
        //We are expecting to find this person first as it was a stable algorithm i made
        Person p1 = new Person("cc", 100);
        Person p2 = new Person("aa", 27);
        Person p3 = new Person("bb", 220);
        Person p4 = new Person("cc", 800);

        Person[] peoples = {p, p1, p2, p3, p4};

        gms.sortTheMerge(peoples);

        for (Person x : peoples) {
            if (x.getName().equals("cc")) {
                Assert.assertEquals(x.getAge(), p1.getAge());
                break;
            }
        }
    }

    @Test
    public void Test_SelectionSort_Not_Stable() {
        GenericSelectionSort<Person> gss = new GenericSelectionSort();

        Person p = new Person("cc", 24);
        //In a world where this algo was stable, we would find the person with age 24 first
        // But in selection sort we end up finding the person(p1) with age 100 first
        // Because the two have been swapped
        Person p1 = new Person("cc", 100);
        Person p2 = new Person("aa", 27);

        Person[] peoples = {p, p1, p2};

        gss.sort(peoples);

        for (Person x : peoples) {
            if (x.getName().equals("cc")) {
                Assert.assertEquals(x.getAge(), p1.getAge());
                break;
            }
        }

    }

    // Log n proof for mergesort

    @Test
    public void Test_MergeSort_NLogn_time_complexity() {
        Random r = new Random();
        String alphabet = "123xyzabcdefghijklmn";
        Person[] people2 = new Person[2];
        Person[] people4 = new Person[4];
        Person[] people8 = new Person[8];
        Person[] people16 = new Person[16];
        Person[] people32 = new Person[32];
        for (int i = 0; i < 32; i++) {
            if (i < 2) people2[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 4) people4[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 8) people8[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 16) people16[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            people32[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
        }
        GenericMergeSort<Person> gms = new GenericMergeSort();
        gms.sortTheMerge(people2);
        int layersNeededFor2Elements = gms.getamountOfN();
        Assert.assertEquals(layersNeededFor2Elements, 1);
        gms.setamountOfN(0);

        gms.sortTheMerge(people4);
        int layersNeededFor4Elements = gms.getamountOfN();
        Assert.assertEquals(layersNeededFor4Elements, 2);
        gms.setamountOfN(0);

        gms.sortTheMerge(people8);
        int layersNeededFor8Elements = gms.getamountOfN();
        Assert.assertEquals(layersNeededFor8Elements, 3);
        gms.setamountOfN(0);

        gms.sortTheMerge(people16);
        int layersNeededFor16Elements = gms.getamountOfN();
        Assert.assertEquals(layersNeededFor16Elements, 4);
        gms.setamountOfN(0);

        gms.sortTheMerge(people32);
        int layersNeededFor32Elements = gms.getamountOfN();
        Assert.assertEquals(layersNeededFor32Elements, 5);
        gms.setamountOfN(0);

    }

    @Test
    public void Test_Merge_sort_Space_complexity(){

        Random r = new Random();
        String alphabet = "123xyzabcdefghijklmn";
        Person[] people2 = new Person[2];
        Person[] people4 = new Person[4];
        Person[] people8 = new Person[8];
        Person[] people16 = new Person[16];
        Person[] people32 = new Person[32];
        for (int i = 0; i < 32; i++) {
            if (i < 2) people2[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 4) people4[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 8) people8[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 16) people16[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            people32[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
        }
        GenericMergeSort<Person> gms = new GenericMergeSort();
        gms.sortTheMerge(people2);
        int spaceComplexity2 = gms.getSpaceComplexity();
        Assert.assertEquals(spaceComplexity2, 2);
        gms.setSpaceComplexity(0);

        gms.sortTheMerge(people4);
        int spaceComplexity4 = gms.getSpaceComplexity();
        Assert.assertEquals(spaceComplexity4, 4);
        gms.setSpaceComplexity(0);

        gms.sortTheMerge(people8);
        int spaceComplexity8 = gms.getSpaceComplexity();
        Assert.assertEquals(spaceComplexity8, 8);
        gms.setSpaceComplexity(0);

        gms.sortTheMerge(people16);
        int spaceComplexity16 = gms.getSpaceComplexity();
        Assert.assertEquals(spaceComplexity16, 16);
        gms.setSpaceComplexity(0);

        gms.sortTheMerge(people32);
        int spaceComplexity32 = gms.getSpaceComplexity();
        Assert.assertEquals(spaceComplexity32, 32);
        gms.setSpaceComplexity(0);

    }

    //n^2 proof for insertion sort

    @Test
    public void Test_Selectionsort_Sort_N_squared(){
        Random r = new Random();
        String alphabet = "xyzabcdefghijklmn";
        Person[] people2 = new Person[2];
        Person[] people4 = new Person[4];
        Person[] people8 = new Person[8];
        Person[] people16 = new Person[16];
        Person[] people32 = new Person[32];
        for (int i = 0; i < 32; i++) {
            if (i < 2) people2[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 4) people4[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 8) people8[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            if (i < 16) people16[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
            people32[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
        }
        GenericSelectionSort<Person> gss = new GenericSelectionSort();

        //Formular for calculating amount of operations needed ( 1/2(n^2 -n) which ends up being n^2

        gss.sort(people2);
        int twoElements = gss.getamountOfN();
        gss.setamountOfN(0);
        int n = people2.length;
        int twoElementsCalculation = 2/(n*n-n);
        Assert.assertEquals(twoElementsCalculation, twoElements);


        gss.sort(people4);
        int fourElements = gss.getamountOfN();
        gss.setamountOfN(0);
         n = people4.length;
        int fourElementsCalculation = (n*n-n)/2;
        Assert.assertEquals(fourElementsCalculation, fourElements);

        gss.sort(people8);
        int eightElements = gss.getamountOfN();
        gss.setamountOfN(0);
        n = people8.length;
        int eightElementsCalculation = (n*n-n)/2;
        Assert.assertEquals(eightElementsCalculation, eightElements);

        gss.sort(people16);
        int sixteenElements = gss.getamountOfN();
        gss.setamountOfN(0);
        n = people16.length;
        int sixTeenElementsCalculation = (n*n-n)/2;
        Assert.assertEquals(sixTeenElementsCalculation, sixteenElements);

        gss.sort(people32);
        int thirtyTwoElements = gss.getamountOfN();
        gss.setamountOfN(0);
        n = people32.length;
        int thirtyTwoElementsCalculation = ((n*n-n)/2);
        Assert.assertEquals(thirtyTwoElementsCalculation, thirtyTwoElements);


    }

    //Pretty stupid test, created it for the sake of it
    @Test
    public void Test_Selection_sort_time_complexity(){

        Random r = new Random();
        String alphabet = "123xyzabcdefghijklmn";
        Person[] people32 = new Person[32];
        for (int i = 0; i < 32; i++) {
            people32[i] = new Person("Peter" + alphabet.charAt(r.nextInt(alphabet.length())), i);
        }
        GenericSelectionSort<Person> gss = new GenericSelectionSort();
        int spaceUsed = gss.getSpaceComplexity();
        Assert.assertEquals(spaceUsed, 0);
    }





}
