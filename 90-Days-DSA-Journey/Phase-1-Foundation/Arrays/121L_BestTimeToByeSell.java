// class Solution {
//    public static void main(String[] args) {
//     int[] prices = {7,1,5,3,6,4};
//     int minPrice = prices[0];
//     int maxProfit = 0;
//     for(int i = 1; i < prices.length; i++) {
//         if(prices[i] < minPrice) {
//             minPrice = prices[i];
//         }
//         if(prices[i] - minPrice > maxProfit) {
//             maxProfit = prices[i] - minPrice;
//         }
//     }
//     System.out.println("Maximum profit is: " + maxProfit);
//    }
// }


// Preprocessing + Prefix Minimum + Suffix Maximum approach.
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
     public int maxProfit(int[] prices) {
         int n=prices.length; int ans=0; 
         int left[]=new int[n]; 
         int right[]=new int[n];
          left[0]=prices[0]; 
          for(int i=1;i<n;i++){ 
            left[i]=Math.min(left[i-1],prices[i]);
         } 
         right[n-1]=prices[n-1]; 
         for(int i=n-2;i>=0;i--){ 
            right[i]=Math.max(right[i+1],prices[i]);
         } 
         for(int i=0;i<n;i++){ 
            ans=Math.max(ans,right[i]-left[i]);
         } 
         return ans;
     }
}

//  📌 Pattern: Preprocessing + Prefix Minimum + Suffix Maximum

// ## 🔷 Problem Context

// This pattern is commonly used in problems like:

// Best Time to Buy and Sell Stock (Single Transaction)

// Where:
// - You must buy before you sell
// - You must maximize difference
// - Condition: i < j

// # 🧠 Core Idea of This Pattern

// We precompute helpful information before calculating the final answer.

// We build:

// - `left[i]`  → minimum value from index `0 → i` (Prefix Minimum)
// - `right[i]` → maximum value from index `i → n-1` (Suffix Maximum)

// Then compute:


// answer = max(right[i] - left[i])


// Instead of checking every pair (i, j), we prepare data first.

// This is called:

// > Preprocessing / Precomputation using Prefix & Suffix Arrays

// ---

// # ⚡ Why Use This Approach?

// Brute force solution:


// for i
// for j > i


// Time Complexity = O(n²)

// Using prefix + suffix:

// - Build prefix array → O(n)
// - Build suffix array → O(n)
// - Compute result → O(n)

// Final Complexity:

// Time Complexity: O(n)  
// Space Complexity: O(n)

// ---

// # 🎯 When Should You Think of This Pattern?

// Use this approach when:

// ### ✅ 1. Problem involves:
// - Choosing one element from left
// - Choosing one element from right
// - Maximizing or minimizing difference

// ---

// ### ✅ 2. Problem contains keywords like:
// - Buy before sell
// - Choose i < j
// - Maximum difference
// - Minimum difference
// - Max value after index
// - Min value before index

// ---

// ### ✅ 3. Nested loop pattern appears:
// If you see:


// for i
// for j > i


// Immediately think:

// > Can I precompute prefix min or suffix max?


// # 🏗 Types of Questions Where This Pattern Is Used

// ## 1️⃣ Maximum Difference Problems

// Example Problems:

// - LeetCode 121 – Best Time to Buy and Sell Stock
// - LeetCode 2016 – Maximum Difference Between Increasing Elements
// - GFG – Maximum Difference Between Two Elements

// Pattern Used:

// max(arr[j] - arr[i]) where j > i


// ---

// ## 2️⃣ Trapping Rain Water Type Problems

// Example:
// - LeetCode 42 – Trapping Rain Water

// We build:


// leftMax[i]
// rightMax[i]


// Water at index i:


// min(leftMax[i], rightMax[i]) - height[i]


// Same prefix + suffix logic.

// ---

// ## 3️⃣ Partition / Split Array Problems

// Example:
// - LeetCode 915 – Partition Array into Disjoint Intervals

// Uses:

// prefixMax[]
// suffixMin[]


// ---

// ## 4️⃣ Maximum Sum of Two Non-Overlapping Subarrays

// Example:
// - LeetCode 1031

// Uses prefix sums + best left/right tracking.

// ---

// ## 5️⃣ Maximum Product / Triplet Problems

// Example:
// - LeetCode 628 – Maximum Product of Three Numbers

// Uses prefix/suffix min and max tracking.

// ---

// # 🧠 Mental Model for Quick Recognition

// When you see:


// Find max (arr[j] - arr[i]) where j > i


// Think:


// Prefix Minimum + Current Difference


// OR


// Prefix Minimum + Suffix Maximum


// ---

// # ⚖️ Comparison With One-Pass Method

// | Approach | Time | Space | Interview Preferred |
// |----------|------|-------|---------------------|
// | One pass tracking min | O(n) | O(1) | ✅ Yes |
// | Prefix + Suffix arrays | O(n) | O(n) | Good for pattern understanding |

// ---

// # 🪄 Step-by-Step Strategy to Apply This Pattern

// ### Step 1:
// Identify direction dependency.
// - Need past info → Prefix
// - Need future info → Suffix

// ### Step 2:
// Check if nested loops exist.
// If yes → Try preprocessing.

// ### Step 3:
// Build helper arrays like:

// prefixMin[]
// prefixMax[]
// suffixMin[]
// suffixMax[]
// prefixSum[]


// ---

// # 🚀 Edge Cases to Remember

// - If array size < 2 → return 0
// - If strictly decreasing array → answer = 0
// - If all elements equal → answer = 0

// ---

// # 🏁 Final Summary

// This pattern is powerful when:

// - Order matters (i < j)
// - Need future info at current index
// - Need past info at current index
// - Want to remove O(n²) solution
// - Precomputation can simplify logic

// ---

// # 🔥 Revision Trigger Keywords

// Whenever revising, remember:


// Not sliding window
// Not two pointer
// Sometimes greedy
// Mostly preprocessing
// Prefix & suffix arrays


// ---

// # 🎯 Practice Problems For Mastery

// Solve these to master the pattern:

// 1. LeetCode 121 – Best Time to Buy and Sell Stock
// 2. LeetCode 2016 – Maximum Difference Between Increasing Elements
// 3. LeetCode 42 – Trapping Rain Water
// 4. LeetCode 915 – Partition Array into Disjoint Intervals
// 5. LeetCode 1031 – Maximum Sum of Two Non-Overlapping Subarrays
// 6. GFG – Maximum Difference Between Two Elements

// ---

// # 🧩 Pattern Category

// Belongs to:
// - Array Preprocessing
// - Greedy Optimization
// - DP Preparation Technique
// - Prefix-Suffix Pattern

// ---

// # 📌 Final Memory Hook

// If problem says:

// “Choose i before j and maximize/minimize something”

