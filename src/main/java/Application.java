import java.util.Arrays;

public class Application {
  public static void main(String[] args) {
    System.out.println("-----Bubble Sort-----");
    int[] ints = createUnsortedArray();
    System.out.println("Array Before Sort");
    printArray(ints);
    System.out.println("Array After Sort");
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
   * The time complexity for the algorithm is O(n^2) because for each array input n, the algorithm requires a full traversal of the inner loop.
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
}
