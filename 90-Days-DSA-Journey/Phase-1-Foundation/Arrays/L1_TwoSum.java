// # LeetCode 1 — Two Sum

// ## Problem

// Given an array of integers `nums` and an integer `target`, return **indices of the two numbers** such that they add up to `target`.

// You may assume:

// - Each input has **exactly one solution**
// - You **cannot use the same element twice**
// - Return indices in any order

// ### Example

// Input:
// nums = [2,7,11,15]
// target = 9

// Output:
// [0,1]

// Explanation:
// nums[0] + nums[1] = 2 + 7 = 9
// Approach 1 — Brute Force
// Idea

// Check every pair of elements.

// Steps:

// Pick first element

// Check with every other element

// If sum equals target → return indices

// Time Complexity
// O(n²)
// Space Complexity
// O(1)
// Code
// public int[] twoSum(int[] nums, int target) {

//     for(int i=0;i<nums.length;i++){
//         for(int j=i+1;j<nums.length;j++){

//             if(nums[i]+nums[j]==target){
//                 return new int[]{i,j};
//             }

//         }
//     }

//     return new int[]{};
// }
// Approach 2 — HashMap (Optimal)
// Idea

// Instead of checking all pairs:

// For each element:

// complement = target - currentNumber

// If complement already exists in map → we found answer.

// Map stores:

// value -> index
// Example Walkthrough
// nums = [2,7,11,15]
// target = 9

// Step 1

// i = 0
// num = 2
// complement = 9 - 2 = 7

// map = {}
// store 2 → index 0

// Step 2

// i = 1
// num = 7
// complement = 9 - 7 = 2

// map contains 2
// answer = [0,1]
// Time Complexity
// O(n)
// Space Complexity
// O(n)
// Java Code
// import java.util.HashMap;
// import java.util.Map;

// public class L1_TwoSum {

//     public int[] twoSum(int[] nums, int target) {

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i=0;i<nums.length;i++){

//             int complement = target - nums[i];

//             if(map.containsKey(complement)){
//                 return new int[]{map.get(complement), i};
//             }

//             map.put(nums[i], i);
//         }

//         return new int[]{};
//     }

// }
// Approach 3 — Sorting + Two Pointers

// ⚠️ Works only if indices are not required or we store them.

// Steps:

// Sort array

// Use two pointers

// left = 0
// right = n-1

// Compare sum with target

// if sum < target → move left++
// if sum > target → move right--
// if sum == target → found
// Time Complexity
// O(n log n)

// (because sorting)

// Hint (For Interview)

// If interviewer asks hint:

// Think:

// target = a + b

// Rearrange:

// b = target - a

// So while scanning array:

// Check if (target - current) already exists

// Use:

// HashMap
// Pattern Learned

// This question teaches an important interview pattern

// Array + HashMap lookup

// When problem says:

// find pair

// find complement

// two numbers sum

// Think about:

// HashMap
// Key Learning Points
// 1. Complement Technique
// complement = target - currentNumber
// 2. HashMap Lookup Optimization

// Instead of

// O(n²)

// we reduce to

// O(n)
// 3. HashMap Structure
// value -> index

// Example:

// 2 -> 0
// 7 -> 1
// 11 -> 2
// 4. Important Interview Trick

// Always check map before inserting

// Correct order:

// 1 check complement
// 2 insert element
// Edge Cases
// Duplicate numbers

// Example

// nums = [3,3]
// target = 6

// Answer:

// [0,1]

// Works because we insert after check.

// Similar Problems

// Practice these after Two Sum:

// Easy
// LeetCode 217 – Contains Duplicate
// LeetCode 219 – Contains Duplicate II
// LeetCode 242 – Valid Anagram
// Medium
// LeetCode 15 – 3Sum
// LeetCode 18 – 4Sum
// LeetCode 167 – Two Sum II (Sorted Array)
// When to Use This Pattern

// If question says:

// find pair
// find complement
// sum equals target
// difference equals target

// Think:

// HashMap + Complement Pattern
// Revision Shortcut

// When revising remember:

// Problem Type:
// Pair Sum

// Technique:
// Complement + HashMap

// Time Complexity:
// O(n)

// Space Complexity:
// O(n)
// Core Idea:

// target = a + b
// b = target - a
