package com.newsum;

import com.newsum.sort.MergeSort;
import com.newsum.sort.Sortable;

import java.util.Arrays;

public class Application {
  public static void main(String[] args) {
    int[] ints;

    // bubble sort
    System.out.println("-----Bubble Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    bubbleSort(ints);
    printArray(ints);

    // selection sort
    System.out.println("-----Selection Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    selectionSort(ints);
    printArray(ints);

    // insertion sort
    System.out.println("-----Insertion Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    insertionSort(ints);
    printArray(ints);

    // shell sort
    System.out.println("-----Shell Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    shellSort(ints);
    printArray(ints);

    // merge sort
    System.out.println("-----Merge Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    Sortable mergeSort = new MergeSort();
    mergeSort.sort(ints);
    printArray(ints);
  }

  public static int[] createUnsortedArray(){
    return new int[] {20, 35, -15, 7, 55, 1, -22};
  }

  public static void printArray(int[] ints){
    Arrays.stream(ints)
        .forEach(System.out::println);
  }

  /**
   * Bubble sort is named as such because the sorted values seemingly bubble to the end of the array.
   * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may traverse the entire inner loop.
   * Therefore, n*n = n^2.
   * @param ints
   */
  public static void bubbleSort(int[] ints){
    for (int lastUnsortedIndex = ints.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
      for (int i = 0; i < lastUnsortedIndex; i++){
        if (ints[i] > ints[i+1]){
          swap(ints,i,i+1);
        }
      }
    }
  }

  /**
   * Swaps the position of element values i and j in the array.
   * @param ints
   * @param i
   * @param j
   */
  public static void swap(int ints[], int i, int j){
    // check if elements are equals
    if (i == j) return;

    int temp = ints[i];
    ints[i] = ints[j];
    ints[j] = temp;
  }

  /**
   * Selection sort is named as such because it selects the largest value and inserts it at the beginning of the unsorted array partition.
   * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may require a comparison with every other array element n.
   * Therefore, n*n = n^2.
   * @param ints
   */
  public static void selectionSort(int[] ints){
    for (int lastUnsortedIndex = ints.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
      int indexOfLargest = 0;

      for (int i = 1; i <= lastUnsortedIndex; i++){
        if (ints[i] > ints[indexOfLargest]){
          indexOfLargest = i;
        }
      }

      swap(ints,indexOfLargest,lastUnsortedIndex);
    }
  }

  /**
   * Insertion sort is named as such because the element is inserted at specific positions within the array.
   * The time complexity of the algorithm is O(n^2) because the algorithm may require an iteration over every element n. Then, for each
   * value n, the algorithm may require a shift in value. Thus, n*n = n^2 (quadratic).
   * @param ints
   */
  public static void insertionSort(int[] ints){
    // starts with the understanding that the first element of an array with length 1 is already sorted.
    for (int firstUnsortedIndex = 1; firstUnsortedIndex < ints.length; firstUnsortedIndex++){
      int temp = ints[firstUnsortedIndex];

      int i;

      for (i = firstUnsortedIndex; i > 0 && ints[i - 1] > temp; i--){
        ints[i] = ints[i - 1]; // shift from left to right
      }

      ints[i] = temp;
    }
  }

  /**
   * Goal of shell sort is to partially sort array prior to performing insertion sort using a gap value. This reduces the number
   * of element shifts in the array. As a result, the shell sort algorithm is an improvement over insertion sort. Shell sort has a time complexity of
   * O(n^2)
   * @param ints
   */
  public static void shellSort(int[] ints){
    // a gap value is defined based on the size of the array
    for (int gap = ints.length / 2; gap > 0; gap /= 2){
      for (int i = gap; i < ints.length; i++){
        int temp = ints[i];
        int j = i;

        // essentially insertion sort at this point
        while (j >= gap && ints[j - gap] > temp){
          ints[j] = ints[j - gap];
          j -= gap;
        }

        ints[j] = temp;
      }
    }
  }

  public static void mergeSort(int[] ints){
    mergeSort(ints,0,ints.length);
  }

  /**
   * A recursive algorithm with a time complexity of O(nlog(n))
   */
  public static void mergeSort(int[] ints, int start, int end){
    // base case of recursive method, which signifies a one element array
    if (end - start < 2){
      return;
    }

    int mid = (start + end) / 2;
    mergeSort(ints, start, mid);
    mergeSort(ints, mid, end);
    merge(ints, start, mid, end);
  }

  public static void merge(int[] ints, int start, int mid, int end){
    // this optimization prevents unnecessary merging
    if (ints[mid - 1] <= ints[mid]){
      return;
    }

    int i = start;
    int j = mid;
    int tempIndex = 0;

    // create temp array
    int[] temp = new int[end - start];

    // merges partitions
    while (i < mid && j < end){
      temp[tempIndex++] = ints[i] <= ints[j] ? ints[i++] : ints[j++];
    }

    System.arraycopy(ints, i, ints,start + tempIndex, mid - i);
    System.arraycopy(temp,0, ints, start, tempIndex);
  }
}
