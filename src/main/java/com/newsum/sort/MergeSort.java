package com.newsum.sort;

/**
 * Encapsulates the recursive merge sort algorithm.
 *  - Time complexity: n * log(n)
 *  - In place: no
 *  - Stable: yes
 */
public class MergeSort implements Sortable{
  @Override
  public void sort(int[] input) {
    mergeSort(input,0,input.length);
  }

  private void mergeSort(int[] input){
    mergeSort(input,0,input.length);
  }
  
  private void mergeSort(int[] input, int start, int end){
    // base case of recursive method signifying a one element array
    if (end - start < 2){
      return;
    }

    // set point at which to split array in 2 logical partitions
    int mid = (start + end) / 2;

    // merge sort logical left array
    mergeSort(input, start, mid);

    // merge sort logical right array
    mergeSort(input, mid, end);

    // merge logical left & right arrays
    merge(input, start, mid, end);
  }

  /**
   *
   * @param input
   * @param start
   * @param mid
   * @param end
   */
  private void merge(int[] input, int start, int mid, int end){
    // this optimization prevents unnecessary merging of left & array
    if (input[mid - 1] >= input[mid]){
      return;
    }

    int i = start;
    int j = mid;
    int tempIndex = 0; // keeps track of location in temp array

    // create temp array
    int[] temp = new int[end - start];

    // merges left & right into temp array
    while (i < mid && j < end){
      temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
    }

    // copies elements from logical left array to input array that weren't copied to temp array
    System.arraycopy(input, i, input,start + tempIndex, mid - i);

    // copy all elements from temp array to input array
    System.arraycopy(temp,0, input, start, tempIndex);
  }
}
