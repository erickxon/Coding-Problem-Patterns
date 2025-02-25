import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int windowStart=0, maxLength=0;
        //key: character
    //value: last index
    Map<Character,Integer> charIndexMap = new HashMap<>();
    //try to extend the range [windowStart,windowEnd]
    for(int windowEnd = 0; windowEnd < str.length();windowEnd++){
      char rightChar = str.charAt(windowEnd);
      //if the map already contains the 'rightChar', shrink the window from the beginning so that 
      //we have only one occurence of 'rightChar'
      if(charIndexMap.containsKey(rightChar)){
        //this is tricky ; in the current window, we will not have any 'rightChar' after its previous index>
        //and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
        windowStart=Math.max(windowStart,charIndexMap.get(rightChar)+1);
            //starts a new sliding window
            //eliminates the repeated character
            //keep track of maxLength
            //if it is 2nd occurence of a character, but is greater than the windowStart (no longer in the window), we keep the windowStart
                //we will later replace the value of 'rightChar'key to the currentIndex outside of the ifStatement.
      }
      charIndexMap.put(rightChar, windowEnd); // insert 'rightChar' into the map verbatim
      maxLength = Math.max(maxLength,windowEnd-windowStart+1); // remember the max length so far
    }
    return maxLength;
  }
  
}
