package com.newsum.sort;

/**
 * Insertion sort is named as such because the element is inserted at specific positions within the array.
 * The time complexity of the algorithm is O(n^2) because the algorithm may require an iteration over every element n. Then, for each
 * value n, the algorithm may require a shift in value. Thus, n*n = n^2 (quadratic).
 */
public class InsertionSort implements Sortable{
  @Override
  public void sort(int[] ints) {
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
}
