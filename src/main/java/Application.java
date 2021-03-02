import java.util.Arrays;

public class Application {
  public static void main(String[] args) {
    int[] ints;

    // bubble sort
    System.out.println("-----Bubble Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    bubbleSort(ints);
    printArray(ints);

    // selection sort
    System.out.println("-----Selection Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    selectionSort(ints);
    printArray(ints);

    // insertion sort
    System.out.println("-----Insertion Sort-----");
    ints = createUnsortedArray();
    System.out.println("Before Sort");
    printArray(ints);
    System.out.println("After Sort");
    insertionSort(ints);
    printArray(ints);
  }

  public static int[] createUnsortedArray(){
    return new int[] {20, 35, -15, 7, 55, 1, -22};
  }

  public static void printArray(int[] ints){
    Arrays.stream(ints)
        .forEach(System.out::println);
  }

  /**
   * Bubble sort is named as such because the sorted values seemingly bubble to the end of the array.
   * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may traverse the entire inner loop.
   * Therefore, n*n = n^2.
   * @param ints
   */
  public static void bubbleSort(int[] ints){
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
  public static void swap(int ints[], int i, int j){
    // check if elements are equals
    if (i == j) return;

    int temp = ints[i];
    ints[i] = ints[j];
    ints[j] = temp;
  }

  /**
   * Selection sort is named as such because it selects the largest value and inserts it at the beginning of the unsorted array partition.
   * The time complexity for this algorithm is O(n^2) because for each array input n, the algorithm may require a comparison with every other array element n.
   * Therefore, n*n = n^2.
   * @param ints
   */
  public static void selectionSort(int[] ints){
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
   * Insertion sort is named as such because the element is inserted at specific positions within the array.
   * The time complexity of the algorithm is O(n^2) because the algorithm may require an iteration over every element n. Then, for each
   * value n, the algorithm may require a value comparison. Thus, n*n = n^2.
   * @param ints
   */
  public static void insertionSort(int[] ints){
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
