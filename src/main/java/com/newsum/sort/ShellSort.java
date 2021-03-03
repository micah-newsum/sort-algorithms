package com.newsum.sort;

/**
 * Goal of shell sort is to partially sort array prior to performing insertion sort using a gap value. This reduces the number
 * of element shifts in the array. As a result, the shell sort algorithm is an improvement over insertion sort. Shell sort has a time complexity of
 * O(n^2)
 */
public class ShellSort implements Sortable{
  @Override
  public void sort(int[] ints) {
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
}
