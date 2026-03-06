// class Solution {

//     int maxSubArray(int nums[]){
//         int sum=0;
//         int maxm=nums[0];
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//             maxm=max(sum,maxm);
//             if(sum<0){
//                 sum=0;
//             }
//          }
//         return maxm;
//     }
// };
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

// 📘 Maximum Subarray

// Platform: LeetCode
// Problem Number: 53
// Difficulty: Medium
// Topic: Array, Dynamic Programming, Kadane’s Algorithm

// 🧠 Problem Understanding

// Given an integer array nums, find the contiguous subarray that has the largest sum and return its sum.

// A subarray must contain continuous elements.

// Example
// Input:
// nums = [-2,1,-3,4,-1,2,1,-5,4]

// Output:
// 6

// Explanation:

// Subarray: [4, -1, 2, 1]

// Sum = 4 + (-1) + 2 + 1 = 6

// This is the maximum possible sum.

// 🔑 Key Idea

// At each index we decide:

// Start new subarray
// OR
// Extend previous subarray

// This idea leads to Kadane’s Algorithm.

// ✅ Approach 1: Brute Force
// 💡 Idea

// Check every possible subarray and calculate the sum.

// Steps:

// Fix starting index i

// Extend subarray until j

// Track maximum sum

// 🧾 Java Code
// class Solution {

//     public int maxSubArray(int[] nums) {

//         int maxSum = Integer.MIN_VALUE;

//         for(int i = 0; i < nums.length; i++){

//             int sum = 0;

//             for(int j = i; j < nums.length; j++){

//                 sum += nums[j];

//                 maxSum = Math.max(maxSum, sum);
//             }
//         }

//         return maxSum;
//     }
// }
// ⏱ Complexity
// Time Complexity: O(n²)
// Space Complexity: O(1)

// ❌ Not efficient for large arrays.

// ✅ Approach 2: Prefix Sum Idea
// 💡 Idea

// Maintain:

// current prefix sum
// minimum prefix sum seen before

// Then:

// maxSubarray = prefixSum - minPrefix

// This approach leads to Kadane optimization.

// 🚀 Approach 3: Kadane’s Algorithm (Most Optimal)
// 💡 Core Idea

// At every index:

// currentSum = max(nums[i], currentSum + nums[i])

// Meaning:

// Start new subarray
// OR
// Extend previous subarray

// We keep updating maximum sum found so far.

// 🧾 Java Code (Optimal)
// class Solution {

//     public int maxSubArray(int[] nums) {

//         int currentSum = nums[0];
//         int maxSum = nums[0];

//         for(int i = 1; i < nums.length; i++){

//             currentSum = Math.max(nums[i], currentSum + nums[i]);

//             maxSum = Math.max(maxSum, currentSum);
//         }

//         return maxSum;
//     }
// }
// ⏱ Complexity
// Time Complexity: O(n)
// Space Complexity: O(1)

// ✅ Best solution for interviews

// 📊 Kadane Dry Run

// Array:

// [-2,1,-3,4,-1,2,1,-5,4]

// Step-by-step:

// currentSum = -2
// maxSum = -2

// 1 → currentSum = max(1, -1) = 1
// maxSum = 1

// -3 → currentSum = -2
// maxSum = 1

// 4 → currentSum = 4
// maxSum = 4

// -1 → currentSum = 3
// maxSum = 4

// 2 → currentSum = 5
// maxSum = 5

// 1 → currentSum = 6
// maxSum = 6

// Final Answer:

// 6
// 🎯 How to Identify Kadane Pattern

// If question asks:

// Maximum subarray sum
// Maximum contiguous sum
// Largest sum subarray
// Maximum profit segment

// Think:

// Kadane Algorithm
// 🧩 Pattern Learning Notes

// This problem teaches:

// 1️⃣ Dynamic Programming on Arrays

// Decision at each index:

// take element
// or
// restart subarray
// 2️⃣ Kadane Algorithm Pattern

// Used in:

// Maximum Subarray
// Maximum Circular Subarray
// Maximum Product Subarray
// 2D Maximum Submatrix
// 📌 Related Important Problems

// Practice after this:

// LeetCode 918 – Maximum Sum Circular Subarray
// LeetCode 152 – Maximum Product Subarray
// LeetCode 121 – Best Time to Buy and Sell Stock
// LeetCode 363 – Max Sum of Rectangle
// 🏆 Interview Strategy

// Explain in this order:

// 1️⃣ Brute Force → O(n²)

// 2️⃣ Optimization idea

// 3️⃣ Kadane Algorithm → O(n)

// This shows:

// Problem solving ability
// Optimization thinking
// Algorithm knowledge
// 💪 What You Should Learn From This

// After solving this problem revise:

// Kadane Algorithm
// Dynamic Programming on Arrays
// Prefix Sum Thinking
// Subarray Problems