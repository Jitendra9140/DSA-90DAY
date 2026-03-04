class L42_TrapinRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int trappedWater = 0;
        for(int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.out.println("Trapped water: " + trappedWater);
    }
}



// 📘 Trapping Rain Water

// 🔗 Problem: Trapping Rain Water
// Platform: LeetCode
// Problem Number: 42

// 🧠 Problem Understanding

// Given an array height[] where each element represents elevation at that index.

// We need to calculate how much rainwater can be trapped after raining.

// Example
// Input:
// height = [0,1,0,2,1,0,1,3,2,1,2,1]

// Output:
// 6
// ✅ Approach 1: Prefix Max + Suffix Max (Your Approach)
// 💡 Idea

// At every index:

// Water trapped =

// min(max height on left, max height on right) - current height

// So we:

// Precompute leftMax[]

// Precompute rightMax[]

// Calculate trapped water

// 🧾 Code (Java)
// class L42_TrapinRainWater {
//     public static void main(String[] args) {
//         int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//         int n = height.length;

//         int[] leftMax = new int[n];
//         int[] rightMax = new int[n];

//         leftMax[0] = height[0];
//         rightMax[n-1] = height[n-1];

//         for(int i = 1; i < n; i++) {
//             leftMax[i] = Math.max(leftMax[i-1], height[i]);
//         }

//         for(int i = n-2; i >= 0; i--) {
//             rightMax[i] = Math.max(rightMax[i+1], height[i]);
//         }

//         int trappedWater = 0;
//         for(int i = 0; i < n; i++) {
//             trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
//         }

//         System.out.println("Trapped water: " + trappedWater);
//     }
// }
// ⏱ Time & Space Complexity

// Time Complexity: O(n)

// Space Complexity: O(n)

// 🚀 More Efficient Approach (Best for Interviews)
// ✅ Approach 2: Two Pointer (Most Optimal)
// 💡 Core Idea

// Instead of storing arrays:

// Use two pointers → left and right

// Maintain:

// leftMax

// rightMax

// Move the pointer with smaller height

// Why This Works?

// Water level depends on the smaller boundary.

// 🧾 Code (Java – Optimal)
// class TrapRainWaterTwoPointer {
//     public static void main(String[] args) {

//         int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//         int left = 0;
//         int right = height.length - 1;

//         int leftMax = 0;
//         int rightMax = 0;

//         int trappedWater = 0;

//         while(left < right) {

//             if(height[left] < height[right]) {
//                 if(height[left] >= leftMax) {
//                     leftMax = height[left];
//                 } else {
//                     trappedWater += leftMax - height[left];
//                 }
//                 left++;
//             } else {
//                 if(height[right] >= rightMax) {
//                     rightMax = height[right];
//                 } else {
//                     trappedWater += rightMax - height[right];
//                 }
//                 right--;
//             }
//         }

//         System.out.println("Trapped water: " + trappedWater);
//     }
// }
// ⏱ Complexity

// Time: O(n)

// Space: O(1) ✅ (Best)

// 👉 This is the most asked interview solution.

// 🔥 Advanced Approach (For Concept Clarity)
// ✅ Approach 3: Monotonic Stack
// Idea:

// Use a stack to store indices.

// When current height > stack top:

// We found a boundary

// Calculate trapped water between them

// Time: O(n)
// Space: O(n)

// Used in:

// Histogram problems

// Next Greater Element

// Area problems

// 🎯 How to Identify This Pattern in Exam

// If question says:

// "Water trapped"

// "Between bars"

// "Area between elevations"

// "Find bounded region"

// Think:

// LEFT BOUNDARY + RIGHT BOUNDARY

// This means:

// Prefix/Suffix
// OR

// Two Pointer
// OR

// Monotonic Stack

// 🧩 Pattern Learning Notes

// This problem teaches:

// 1️⃣ Prefix Maximum Array

// Used in:

// Stock problems

// Range problems

// Maximum difference problems

// 2️⃣ Two Pointer Technique

// Used in:

// Container With Most Water

// Sorted array problems

// Sliding window

// Trapping Rain Water

// 3️⃣ Monotonic Stack

// Used in:

// Largest Rectangle in Histogram

// Next Greater Element

// Daily Temperatures

// 📌 Related Important Problems

// Container With Most Water – LeetCode

// Largest Rectangle in Histogram – LeetCode

// Best Time to Buy and Sell Stock – LeetCode

// 🏆 Interview Strategy

// When interviewer gives this:

// First explain brute force

// Then prefix/suffix

// Then say:

// "We can optimize space using two pointer approach"

// This shows:

// Thinking ability

// Optimization skill

// Pattern recognition

// 💪 What You Should Learn From This

// Jitendra, since you are preparing serious DSA:

// After solving this problem, revise:

// Prefix array concept

// Suffix array concept

// Two pointer pattern

// Monotonic stack pattern

// Boundary-based problems