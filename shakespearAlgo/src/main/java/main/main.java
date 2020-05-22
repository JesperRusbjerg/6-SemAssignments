package main;

import algorithms.*;
import entity.Person;

import java.io.*;
import java.util.List;
import java.util.Random;

public class main {

    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(1) + 2]; // words of length 3 through 10. (1 and 2 letter words are
                                                           // boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("--------------ALGO SORTING STARTING BIP BOP---------------");

        // ---- SLOW SORTING ALGOS ARE COMMENTED OUT --- //

        // COMMENTED OUT SELECTION + INSERTION SORT CUZ THE TAKE FOREVER 8)))))


//        try (Stopwatch sw = new Stopwatch()) {
//            InsertionSort is = new InsertionSort();
//            is.sort(t1);
//            System.out.printf("%5.6f\n", sw.step());
//            sw.close();
//        }

//        try (Stopwatch sw = new Stopwatch()) {
//
//            SelectionSort ss = new SelectionSort();
//
//            Person p = new Person("cc", 24);
//            Person p1 = new Person("cc", 100);
//            Person p4 = new Person("aa", 27);
//
//            Person[] peoples = {p, p1, p4};
//
//            GenericSelectionSort<Person> gss = new GenericSelectionSort();
//
//            gss.sort(peoples);
//
//            for(Person x: peoples){
//                System.out.println(x);
//            }
//
//            System.out.printf("%5.6f\n", sw.step());
//            sw.close();
//        }

        try (Stopwatch sw = new Stopwatch()) {
            MergeSort ms = new MergeSort();
            GenericMergeSort<Person> gms = new GenericMergeSort<>();
            String[] t1 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
            System.out.println("MERGE SORT DONE");

            Person p = new Person("xx", 24);
            Person p1 = new Person("cc", 100);
//            Person p2 = new Person("aa", 27);
//            Person p3 = new Person("bb", 27);
//            Person p4 = new Person("xx", 24);
//            Person p5 = new Person("cc", 100);
//            Person p6 = new Person("aa", 27);
//            Person p7 = new Person("bb", 27);
//            Person p8 = new Person("bb", 27);
//            Person p9 = new Person("bb", 27);
//            Person p10 = new Person("bb", 27);
//            Person p11 = new Person("bb", 27);
//            Person p12 = new Person("bb", 27);
//            Person p13 = new Person("bb", 27);
//            Person p14 = new Person("bb", 27);
//            Person p15 = new Person("bb", 27);

            Person[] peoples = {p, p1};


            gms.sortTheMerge(peoples);

            System.out.println((gms.getSpaceComplexity()));

//            ms.sortTheMerge(t1);
            System.out.printf("%5.6f\n", sw.step());
            sw.close();

            for(Person x: peoples){
                System.out.println(x);
            }

        }



//        try (Stopwatch sw = new Stopwatch()) {
//            HeapSort hs = new HeapSort();
//            String[] t2 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
//            hs.heapSort(t2);
//            System.out.println("HEAP SORT DONE");
//            System.out.printf("%5.6f\n", sw.step());
//            sw.close();
//            // for (int i = 0; i < t2.length; i++) {
//            //     System.out.println(t2[i]);
//            // }
//        }
//        try (Stopwatch sw = new Stopwatch()) {
//            String[] t3 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
//            String[] test = {"Jesper"};
//
//            Trie trie = new Trie();
//            trie.CreateTrie(test);
//
//            trie.printTrieInOrder();
//            System.out.println("TRIE IS DONE");
//            System.out.printf("%5.6f\n", sw.step());
//
//
//        }

        System.out.println("--------------ALGO SORTING OVER BIP BOP---------------");

    }


}

