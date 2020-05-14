import java.util.Arrays;

class SlidingWindow {
  public static double[] findAverages(int K, int[] arr){
    double[] result = new double[arr.length - K + 1];
    double windowSum = 0;
    int windowStart=0;

    for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){
        windowSum+=arr[windowEnd]; //add the next element
        //slide the window; only start adding to result array until we reach K elements (window is big enough)
        if(windowEnd >= K-1){
            result[windowStart] = windowSum/K;
            windowSum -= arr[windowStart];
            windowStart++;
            }

        }
    return result;
    }

  public static void main(String[] args) {
    double[] result = SlidingWindow.findAverages(5, new int[] {1,2,3,4,5,6,7,8,9,10});
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }
}