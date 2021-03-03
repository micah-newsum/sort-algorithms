package com.newsum.sort;

/**
 * Selection sort is named as such because it selects the largest value and inserts it at the beginning of the unsorted array partition.
 * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may require a comparison with every other array element n.
 * Therefore, n*n = n^2.
 */
public class SelectionSort implements Sortable{
  @Override
  public void sort(int[] ints) {
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
