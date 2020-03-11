package main;

import algorithms.HeapSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.SelectionSort;
import algorithms.Trie;
import java.io.*;
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

        // try (Stopwatch sw = new Stopwatch()) {
        // SelectionSort ss = new SelectionSort();
        // ss.sort(t1);
        // System.out.printf("%5.6f\n", sw.step());
        // sw.close();
        // }
        // try (Stopwatch sw = new Stopwatch()) {
        // InsertionSort is = new InsertionSort();
        // is.sort(t1);
        // System.out.printf("%5.6f\n", sw.step());
        // sw.close();
        // }
        try (Stopwatch sw = new Stopwatch()) {
            MergeSort ms = new MergeSort();
            String[] t1 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
            System.out.println("MERGE SORT DONE");
            ms.sortTheMerge(t1);
            System.out.printf("%5.6f\n", sw.step());
            sw.close();

            // for (int i = 0; i < t1.length; i++) {
            //     System.out.println(t1[i]);
            // }
        }

        try (Stopwatch sw = new Stopwatch()) {
            HeapSort hs = new HeapSort();
            String[] t2 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
            hs.heapSort(t2);
            System.out.println("HEAP SORT DONE");
            System.out.printf("%5.6f\n", sw.step());
            sw.close();
            // for (int i = 0; i < t2.length; i++) {
            //     System.out.println(t2[i]);
            // }
        }
        try (Stopwatch sw = new Stopwatch()) {
            String[] t3 = FileUtility.toStringArray("resources/shakespeare-complete-works.txt", "[^A-Za-z']+");
            Trie trie = new Trie(t3);
            System.out.println("TRIE IS DONE");
            System.out.printf("%5.6f\n", sw.step());
            sw.close();
            // for (int i = 0; i < t3.length; i++) {
            //     System.out.println(t3[i]);
            // }
        }

        System.out.println("--------------ALGO SORTING OVER BIP BOP---------------");

    }

}
