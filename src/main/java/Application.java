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
}
