package com.newsum.sort;

/**
 * Quick sort is a recursive, in-place, and unstable algorithm that uses the concept of a pivot to partition an array.
 * The time complexity is O to the n * log(n) because it repeatedly partitions the array into two halves.
 */
public class QuickSort implements Sortable{
  @Override
  public void sort(int[] ints) {
    quickSort(ints, 0, ints.length);
  }

  private void quickSort(int[] ints, int start, int end){
    // check if dealing with one element array
    if (end - start < 2){
      return;
    }

    int pivotIndex = partition(ints,start,end);
    quickSort(ints, start, pivotIndex);
    quickSort(ints, pivotIndex + 1, end);
  }

  /**
   * Returns position of pivot with everything left of the pivot smaller and everything right to the pivot larger.
   * @param ints
   * @param start
   * @param end
   * @return
   */
  private int partition(int[] ints, int start, int end){
    // implementation uses first element as pivot
    int pivot = ints[start];
    int i = start;
    int j = end;

    // if i >= j then values have crossed
    while (i < j){

      // NOTE: empty loop body to decrement j
      while (i < j && ints[--j] >= pivot);
      if (i < j){
        ints[i] = ints[j];
      }

      // NOTE: empty loop body to increment i.
      while (i < j && ints[++i] <= pivot);
      if (i < j){
        ints[j] = ints[i];
      }
    }

    ints[j] = pivot;
    return j;
  }
}
