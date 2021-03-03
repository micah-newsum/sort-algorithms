package com.newsum.sort;

/**
 * Bubble sort is named as such because the sorted values seemingly bubble to the end of the array.
 * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may traverse the entire inner loop.
 * Therefore, n*n = n^2.
 */
public class BubbleSort implements Sortable {
  @Override
  public void sort(int[] ints) {
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
  private void swap(int ints[], int i, int j){
    // check if elements are equals
    if (i == j) return;

    int temp = ints[i];
    ints[i] = ints[j];
    ints[j] = temp;
  }
}
