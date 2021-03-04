package com.newsum;

import com.newsum.sort.BubbleSort;
import com.newsum.sort.CountingSort;
import com.newsum.sort.InsertionSort;
import com.newsum.sort.MergeSort;
import com.newsum.sort.QuickSort;
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

    // count sort
    int[] countSortInts = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
    runAlgorithm(new CountingSort(),countSortInts);
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
}
