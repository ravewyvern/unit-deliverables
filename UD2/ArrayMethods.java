
public class ArrayMethods
{

  /**
   * Swaps two elements in an integer array.
   *
   * @param array The array to swap elements in.
   * @param a     The index of the first element to swap.
   * @param b     The index of the second element to swap.
   */
  public static void swapInt(int[] array, int a, int b)
  {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

    /**
     * Swaps two elements in a string array.
     *
     * @param array The array to swap elements in.
     * @param a     The index of the first element to swap.
     * @param b     The index of the second element to swap.
     */
  public static void swapString(String[] array, int a, int b)
  {
    String temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

    /**
     * Swaps two elements in a double array.
     *
     * @param array The array to swap elements in.
     * @param a     The index of the first element to swap.
     * @param b     The index of the second element to swap.
     */
  public static void swapDouble(double[] array, int a, int b)
  {
    double temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

    /**
     * Finds the index of the minimum value in an integer array.
     *
     * @param array      The array to search.
     * @param startIndex The index to start searching from.
     * @return The index of the minimum value.
     */
  public static int indexOfMin(int[] array, int startIndex)
  {
    int index = startIndex, min = 2147483647, minIndex = 0;

    while (index < array.length)
    {
      if (array[index] < min) {
        min = array[index];
        minIndex = index;
      }
      index++;
    }
    return minIndex;
  }


    /**
     * Resizes an integer array by the specified amount.
     *
     * @param array      The array to resize.
     * @param changeSize The amount to resize the array by.
     * @return The resized array.
     */
    public static int[] resizeIntArray(int[] array, int changeSize) {
      //Checks if the array is being resized by 0
      if (changeSize == 0) {
          return array;
      }
      //Creates a new array with the new size and copies the elements
      //from the old array to the new array
      int[] newArray = new int[array.length + changeSize];
      int elementsToCopy = UD2Main.mathMin(array.length, newArray.length);
      for (int i = 0; i < elementsToCopy; i++) {
          newArray[i] = array[i];
      }
      return newArray;
  }

  /**
   * Resizes a double array by the specified amount.
   *
   * @param array      The array to resize.
   * @param changeSize The amount to resize the array by.
   * @return The resized array.
   */
  public static double[] resizeDoubleArray(double[] array, int changeSize) {
      //Checks if the array is being resized by 0
      if (changeSize == 0) {
          return array;
      }
      //Creates a new array with the new size and copies the elements
      //from the old array to the new array
      double[] newArray = new double[array.length + changeSize];
      int elementsToCopy = UD2Main.mathMin(array.length, newArray.length);
      for (int i = 0; i < elementsToCopy; i++) {
          newArray[i] = array[i];
      }
      return newArray;
  }

  /**
   * Resizes a string array by the specified amount.
   *
   * @param array      The array to resize.
   * @param changeSize The amount to resize the array by.
   * @return The resized array.
   */
  public static String[] resizeStringArray(String[] array, int changeSize) {
      //Checks if the array is being resized by 0
      if (changeSize == 0) {
          return array;
      }
      //Creates a new array with the new size and copies the elements
      //from the old array to the new array
      String[] newArray = new String[array.length + changeSize];
      int elementsToCopy = UD2Main.mathMin(array.length, newArray.length);
      for (int i = 0; i < elementsToCopy; i++) {
          newArray[i] = array[i];
      }
      return newArray;
  }

}
