package com.newsum.sort;

/**
 * Radix sort makes assumption that data has same radix (number of unique digits or values, in the case of characters, that a numbering system, or alphabet has.
 * For example, the radix of the decimal system is 10 and 26 for the English language) and width (i.e. number of value 145 has width of 3 and "hello"
 * has width of 5). Must use stable sort.
 */
public class RadixSort implements Sortable{
  @Override
  public void sort(int[] ints) {
    radixSort(ints, 10, 4);
  }

  /**
   * radix and width must be equal among values
   * @param input
   * @param radix
   * @param width
   */
  private void radixSort(int[] input, int radix, int width){
    for (int i = 0; i < width; i++){
      radixSingleSort(input, i, radix);
    }
  }

  private void radixSingleSort(int[] input, int position, int radix){
    int numItems = input.length;

    int[] countArray = new int[radix];

    int digit;

    for (int value : input){
      digit = getDigit(position, value, radix);
      countArray[digit]++;
    }

    // Adjust the count array
    for (int j = 1; j < radix; j++){
      countArray[j] += countArray[j - 1];
    }

    int[] temp = new int[numItems];

    // Preserves order of duplicate values
    for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
      digit = getDigit(position, input[tempIndex], radix);
      temp[--countArray[digit]] = input[tempIndex];
    }

    // Copy temp array into input array
    for (int tempIndex = 0; tempIndex < numItems; tempIndex++){
      input[tempIndex] = temp[tempIndex];
    }
  }

  private int getDigit(int position, int value, int radix){
    return value / (int) Math.pow(radix, position) % radix;
  }
}
