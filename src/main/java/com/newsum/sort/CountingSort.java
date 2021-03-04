package com.newsum.sort;

/**
 * An unstable, non in-place algorithm that can achieve O(n) time complexity because assumptions are made about the data.
 * All values within the array are discrete non-negative numbers within a specific range, and no comparisons are made.
 */
public class CountingSort implements Sortable{

  @Override
  public void sort(int[] ints) {
    coutingSort(ints,1,10);
  }

  /**
   * Assumes all values fall within range min to max.
   * @param input
   * @param min
   * @param max
   */
  private void coutingSort(int[] input, int min, int max){
    int[] countArray = new int[(max - min) + 1];

    // counting phase
    for (int i = 0; i < input.length; i++){
      countArray[input[i] - min]++;
    }

    int j = 0;
    for (int i = min; i <= max; i++){
      while (countArray[i - min] > 0){
        input[j++] = i;
        countArray[i - min]--;
      }
    }
  }
}
