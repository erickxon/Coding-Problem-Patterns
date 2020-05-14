# Sliding Window Pattern

`Example: Given an array, find the average of all contiguous subarrays of size 'K' in it`
    
 **Sample input:**
`    Array[1,3,2,6,-1,4,1,8,2], K=5`

## **Algorithm steps (Brute Force):**
    * For every subarray of length K
      * calculate the sum of subarray
          * divide by K and add result to array
        
    
    1. For first 5 numbers (index 0-4)
    average = (1+3+2+6-1)/5 = 2.2

    2. (3+2+6-1+4)) = 2.8

    3. ...
    
`Output: [2.2, 2.8, 2.4, 3.6, 2.8]`

### bruteforce.java

```java
    import java.util.Arrays;

    class AverageOfSubarrayOfSizeK {
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
            double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1,2,3,4,5,6,7,8,9,10 });
            System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
        }
    }
 ```
    
    
**Time Complexity**: O(N*K)
  - for every element, we are calculating the sum of its next 'K' elements
  - inefficient, any two consecutive arrays of length 5 will have 3 overlapping values
    - can we preserve these values without doing the calculation every time?

## **Algorithm Steps (Sliding Window solution)**
  * Sum the first K elements
    * divide by K
      * Add sum to result array A
  * for every element in A
    * subtract the edge going out (left)
    * add the edge going in (right)
    ![slidingwindow](./slidingwindow.png)

```java
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
```

**Time Complexity**: O(N)

By implementing sliding window, we have reduced the runtime from O(N*K) to O(N)



# Smallest Subarray with a given sum

```
Given an array of postiive numbers and a postive number 'S', find the length of the smallest contiguous subarray whose sum is greater than or equal to 'S'
```

```
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
```

Notes:
<list>
- This is a sliding window problem but the sliding window is dynamic
1. add the elements from index 0 to an index that makes the sum greater or equal to 'S'
2. This will be the initial sliding window; we must also keep track of the length of this window (initially, it will be the smallest)
3. Then slide the window from the beginning until the sum is smaller than S. <br>
a. when shrinking from the beginning, check if window is smaller than smallest length so far
<br>
b. when shrinking, subtract the removed item from the sum
</list>
```java
class SmallestSubArrayWithGivenSum {
  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    int windowSum = 0, minLength = Integer.MAX_VALUE;
    int windowStart = 0;

    for(int windowEnd = 0;windowEnd< arr.length; windowEnd++){
        windowSum+=arr[windowEnd];
        while(windowSum>=S){
            minLength = Math.min(minLength,windowEnd-windowStart+1);
            windowSum -= arr[windowStart];
            windowStart++;
        }
    }

    return minLength == Integer.MAX_VALUE?0:minLength;
  }

  public static void main(String[] args) {
    int result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = SmallestSubArrayWithGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}

```
    
**Time Complexity**: O(N)
- the outer for loop runs for all elements
- the inner while loop processes each element only once


    