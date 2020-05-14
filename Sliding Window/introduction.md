# Sliding Window Pattern

`Example: Given an array, find the average of all contiguous subarrays of size 'K' in it`
    
 **Sample input:**
`    Array[1,3,2,6,-1,4,1,8,2], K=5`

## **Algorithm steps (Brute Force):**
  -For every subarray of length K
    -calculate the sum of subarray
        -divide by K and add result to array
        
    
    1. For first 5 numbers (index 0-4)
    average = (1+3+2+6-1)/5 = 2.2

    2. (3+2+6-1+4)) = 2.8

    3...
    
`Output: [2.2, 2.8, 2.4, 3.6, 2.8]`
    
    
**Time Complexity**: O(N*K)
  - for every element, we are calculating the sum of its next 'K' elements
  - inefficient, any two consecutive arrays of length 5 will have 3 overlapping values
    - can we preserve these values without doing the calculation every time?

## **Reusing Sum (Sliding Window solution)**
  * Sum the first K elements
    * divide by K
      * Add sum to result array A
  * for every element in A
    * subtract the edge going out (left)
    * add the edge going in (right)

    ![slidingwindow](/slidingwindow.png)
    
**Time Complexity**: O(N)

    

    
    