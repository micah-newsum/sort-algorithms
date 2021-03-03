package com.newsum.sort;

/**
 * Encapsulates merge sort algorithm.
 *  - Time complexity: n * log(n)
 *  - In place: no
 *  - Stable: yes
 */
public class MergeSort implements Sortable{
  @Override
  public void sort(int[] ints) {
    mergeSort(ints,0,ints.length);
  }

  private void mergeSort(int[] ints){
    mergeSort(ints,0,ints.length);
  }

  /**
   * A recursive algorithm with a time complexity of O(nlog(n))
   */
  private void mergeSort(int[] ints, int start, int end){
    // base case of recursive method, which signifies a one element array
    if (end - start < 2){
      return;
    }

    int mid = (start + end) / 2;
    mergeSort(ints, start, mid);
    mergeSort(ints, mid, end);
    merge(ints, start, mid, end);
  }

  private void merge(int[] ints, int start, int mid, int end){
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
