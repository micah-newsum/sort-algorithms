package com.newsum.sort;

/**
 * Insertion sort is named as such because the element is inserted at specific positions within the array.
 * The time complexity of the algorithm is O(n^2) because the algorithm requires an iteration over every element n. Then, for each
 * value n, the algorithm may require a shift in value. Thus, n*n = n^2 (quadratic).
 */
public class InsertionSort implements Sortable{
  @Override
  public void sort(int[] input) {
    // starts with the understanding that the first element of an array with length 1 is already sorted.
    insertionSort(input,0,input.length);
  }

  private void insertionSort(int[] input, int start, int end){
    if (end - start < 2){
      return;
    }

    int firstUnsortedIndex = end - 1;

    insertionSort(input, start, firstUnsortedIndex);
    shift(input,firstUnsortedIndex);
  }

  /**
   * Shifts elements from right to left to sort in ascending order.
   * @param input
   * @param firstUnsortedIndex
   */
  private void shift(int[] input, int firstUnsortedIndex){
    int temp = input[firstUnsortedIndex];

    int i;

    for (i = firstUnsortedIndex; i > 0 && input[i - 1] > temp; i--)  {
      input[i] = input[i - 1];
    }

    input[i] = temp;
  }
}
