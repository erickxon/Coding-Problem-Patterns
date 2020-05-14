import java.util.Arrays;

class BruteForce {
  public static double[] findAverages(int K, int[] arr){
      double[] result = new double[arr.length - K + 1];
      for (int i =0;i<= arr.length - K; i++){
        //find sum of next 'K' elements
        double sum = 0;
        for (int j = i; j<i+K;j++) //start at index i; sum next K elements 
            sum+=arr[j];
        result[i] = sum/K;

      }
    return result;
  }


  public static void main(String[] args) {
    double[] result = BruteForce.findAverages(5, new int[] {1,2,3,4,5,6,7,8,9,10});
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }
}