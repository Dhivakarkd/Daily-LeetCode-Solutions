This sortArray method sorts an array of integers using a counting sort algorithm. Let's break down the code step by step:

Code Explanation
java
Copy code
class Solution {
public int[] sortArray(int[] nums) {
var map = new int[100001];
map is an array of 100,001 integers initialized to zero. This array will be used to count the occurrences of each number in the nums array.
The size 100,001 is chosen to cover the range of possible values in nums, which is from -50,000 to 50,000 (inclusive).
java
Copy code
for (var n : nums)
map[n + 50000]++;
This loop iterates over each number n in the nums array.
n + 50000 shifts the value n to a non-negative index (since n can be negative). For example, if n is -50,000, n + 50000 is 0; if n is 50,000, n + 50000 is 100,000.
map[n + 50000]++ increments the count of the number n in the map array.
java
Copy code
var k = 0;
for (var i = 0; i < 100001; i++)
for (var j = 0; j < map[i]; j++)
nums[k++] = i - 50000;
k is initialized to 0. It will be used as an index to place sorted values back into the nums array.
The outer loop iterates over each index i in the map array.
The inner loop iterates map[i] times (the count of the number i - 50000).
nums[k++] = i - 50000 places the number i - 50000 back into the nums array in sorted order and increments k.
Overall Process
Counting Phase:
The first loop counts the occurrences of each number in the nums array and stores these counts in the map array.
Sorting Phase:
The second nested loop reconstructs the sorted array using the counts stored in the map array. It writes the numbers back into the nums array in sorted order based on the counts.
Example
Let's consider an example with the input array nums = {3, -1, 2, -1, 4}.

Counting Phase:

Initialize map with zeros.
Count occurrences:
3 + 50000 -> 50003, map[50003] becomes 1.
-1 + 50000 -> 49999, map[49999] becomes 1.
2 + 50000 -> 50002, map[50002] becomes 1.
-1 + 50000 -> 49999, map[49999] becomes 2.
4 + 50000 -> 50004, map[50004] becomes 1.
Sorting Phase:

Iterate over map and reconstruct nums:
map[49999] is 2 -> nums becomes {-1, -1}.
map[50002] is 1 -> nums becomes {-1, -1, 2}.
map[50003] is 1 -> nums becomes {-1, -1, 2, 3}.
map[50004] is 1 -> nums becomes {-1, -1, 2, 3, 4}.
Thus, the sorted array is {-1, -1, 2, 3, 4}.