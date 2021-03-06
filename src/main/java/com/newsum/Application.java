package com.newsum;

import com.newsum.sort.BubbleSort;
import com.newsum.sort.BucketSort;
import com.newsum.sort.CountingSort;
import com.newsum.sort.InsertionSort;
import com.newsum.sort.MergeSort;
import com.newsum.sort.QuickSort;
import com.newsum.sort.RadixSort;
import com.newsum.sort.SelectionSort;
import com.newsum.sort.ShellSort;
import com.newsum.sort.Sortable;

import java.util.Arrays;

public class Application {
  public static void main(String[] args) {
    // bubble sort
    runAlgorithm(new BubbleSort());

    // selection sort
    runAlgorithm(new SelectionSort());

    // insertion sort
    runAlgorithm(new InsertionSort());

    // shell sort
    runAlgorithm(new ShellSort());

    // merge sort
    runAlgorithm(new MergeSort());

    // quick sort
    runAlgorithm(new QuickSort());

    // bucket sort
    int[] bucketSortInts = {54, 46, 83, 66, 95, 92, 43};
    runAlgorithm(new BucketSort(), bucketSortInts);

    // count sort
    int[] countSortInts = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
    runAlgorithm(new CountingSort(),countSortInts);

    // radix sort
    int[] radixArray = {4725, 4586, 8792, 1594, 5729};
    runAlgorithm(new RadixSort(), radixArray);

    // jdk sort
    runJdkSortAlgorithm();

    // jdk parallel sort
    runJdkParallelSortAlgorithm();
  }

  public static int[] createUnsortedArray(){
    return new int[] {20, 35, -15, 7, 55, 1, -22};
  }

  public static void printArray(int[] ints){
    Arrays.stream(ints)
        .forEach(System.out::println);
  }

  public static void runAlgorithm(Sortable sortable){
    System.out.printf("-----%s-----\n",sortable.getClass().getSimpleName());
    int[] ints = createUnsortedArray();
    System.out.println("Before Sort:");
    printArray(ints);
    System.out.println("After Sort:");
    sortable.sort(ints);
    printArray(ints);
  }

  public static void runAlgorithm(Sortable sortable, int[] ints){
    System.out.printf("-----%s-----\n",sortable.getClass().getSimpleName());
    System.out.println("Before Sort:");
    printArray(ints);
    System.out.println("After Sort:");
    sortable.sort(ints);
    printArray(ints);
  }

  public static void runJdkSortAlgorithm(){
    System.out.println("-----JDK-----");
    int[] ints = createUnsortedArray();
    System.out.println("Before Sort:");
    printArray(ints);
    System.out.println("After Sort:");
    Arrays.sort(ints);
    printArray(ints);
  }

  public static void runJdkParallelSortAlgorithm(){
    System.out.println("-----JDK Parallel Sorts-----");
    int[] ints = createUnsortedArray();
    System.out.println("Before Sort:");
    printArray(ints);
    System.out.println("After Sort:");
    Arrays.parallelSort(ints);
    printArray(ints);
  }
}
