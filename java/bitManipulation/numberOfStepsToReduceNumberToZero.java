/*
1342. Number of Steps to Reduce a Number to Zero
[Difficulty --> Easy]

Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, 
otherwise, you have to subtract 1 from it.

 
  Example 1:
Input: num = 14
Output: 6
Explanation: 
Step 1) 14 is even; divide by 2 and obtain 7. 
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3. 
Step 4) 3 is odd; subtract 1 and obtain 2. 
Step 5) 2 is even; divide by 2 and obtain 1. 
Step 6) 1 is odd; subtract 1 and obtain 0.

  Example 2:
Input: num = 8
Output: 4
Explanation: 
Step 1) 8 is even; divide by 2 and obtain 4. 
Step 2) 4 is even; divide by 2 and obtain 2. 
Step 3) 2 is even; divide by 2 and obtain 1. 
Step 4) 1 is odd; subtract 1 and obtain 0.

  Example 3:
Input: num = 123
Output: 12
 

  Constraints:
0 <= num <= 106
/*

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---

// Brute Force arithmetic:
// class Solution {
//     public int numberOfSteps(int num) {
//         int stepCount = 0;
//         while (num > 0) {
//             if (num % 2 == 0) {
//                 num = num / 2;
//             } else {
//                 num -= 1;
//             }
//             stepCount++;
//         }
//         return stepCount;
//     }
// }

// Brute Force Bit Manipulation
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            if ((num & 1) == 0) num >>= 1;
            else num ^= 1;
        }
        return count;
    }
}

/* 
// docs: https://www.educative.io/blog/bit-manipulation-in-java
// docs: https://www.geeksforgeeks.org/shift-operator-in-java/
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            
            if ((num & 1) == 0) {  // multiplies each position in the bit string
                                   // by the corresponding bit in the other operand
                                   // so if there is anything other than a zero in
                                   // either bit string, this if-condition is entered
                
                num >>= 1; // signed (all ints are signed in Java) right bit shift
                           // formula for x>>y --> x / (2^y)
                           // so this is: (num/(2^1))
            }
            else num ^= 1; // XOR, exclusive or, binary operator compares every bit
                           // with the corresponding bit and creates an output
                           // bit string wherein matching values result in 0 and
                           // non-matching result in a 1
                           // ^= 1 is therefore the same as subtracting 1
                           // since the bit string of 1 is "...0001"
        }
        return count;
    }
}
*/


// Optimized Bit Manipulation Approach
// Pulled from nesarptr@: 
//  https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/discuss/1988154/JAVA-less-than-O(logn)-2-100-faster-Solution-where-n-is-the-input-number
/*
If we Observe then we can see that the 
number of steps == number of zeros + 1 (in the binary) + 2 * number of Ones - 1 (in the binary form)

Because every 1's value first it will be reset to 0 bit and then it will be canceled by dividing it by two.

But the most significant bit will not take two steps it only will be subtracted that 
is why I have subtracted 1 from the total number of ones and added it with the total
number of zeros.
*/
/*
class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int totalDigits = (int)(Math.log(num) / Math.log(2)) + 1;
        int totalOnes = 0;
        while (num != 0) {
            totalOnes++;
            num -= (num & -num);
        }
        if (totalOnes > 0) totalOnes--;
        int totalZeros = totalDigits - totalOnes;
        totalOnes *= 2;
        return totalZeros + totalOnes;
    }
}
*/

// Time Complexity:  O(log(n))2
// Space Complexity: O(n)
