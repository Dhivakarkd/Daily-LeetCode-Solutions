Solution
Overview
You are given two arrays, arr and target. In one step, we can reverse any subarray of arr. We need to determine whether or not it is possible to turn arr into target by performing any number of steps.

Approach 1: Sorting
Intuition
We can consider simulating a sequence of reversals on arr to see if it can be turned into target. Consider the following reversal strategy:

First, we iterate through each element target[i] from left to right. For each target[i], we locate the same element in arr, if it exists. If it does not exist, we can immediately return false as it is not possible to do any number of reversals for arr to match target. If the element arr[j] is found, but not in the same position as target[i], (i.e. j > i), we repeatedly swap arr[j] with the element in front of it, arr[j-1], until j == i. This effectively pushes arr[j] forward to the same position as target[i]. Note that this swapping is equivalent to repeatedly reversing the subarray arr[j-1:j] in which j is decremented at each step.

Current

This swapping strategy demonstrates that arr can be rearranged in any possible order. As long as arr contains the same elements as target, the ordering of arr does not matter because it can always be reordered into target using the swapping strategy mentioned above.

Thus, the problem boils down to whether or not arr and target contain the same elements. In order to determine this, we can sort both arrays. If the arrays have the same elements, then their sorted versions should be identical. If they don't have the same elements, then their sorted versions will have at least one differing value at some index i.

Algorithm
Sort both the input arrays arr and target in ascending order.
Iterate through the elements of both sorted arrays simultaneously:
Compare corresponding elements from arr and target.
If any pair of elements differs, return false as the arrays cannot be made equal.
If all elements match after the iteration, return true indicating that the arrays can be made equal by rearranging the elements.
Implementation

Complexity Analysis
Let N be the size of arrays target and arr.

Time Complexity: O(N⋅logN)

Sorting each array takes O(N⋅logN). Iterating through the two arrays to check for differences takes O(N).
Thus, the total time complexity is O(N⋅logN).

Space Complexity: O(logN)

Assuming the quicksort implementation for sorting, there is a recursive overhead where the maximum depth of the call stack is O(logN). Thus, the total space complexity is O(logN).

Approach 2: Frequency Counting With 2 Dictionaries
Intuition
Another way to determine whether or not arr and target have the same elements is to compare their frequency counts for each of their elements. We can use a dictionary for each array, where each key represents an element, and its value represents the number of occurrences of that element in the array.
If the dictionaries differ at any point, it means arr cannot be turned into target through any number of operations.

Algorithm
Create a frequency map arrFreq to count the occurrences of each number in the array arr.
Iterate through arr and for each number, update the frequency in arrFreq using getOrDefault to handle missing keys.
Create a frequency map targetFreq to count the occurrences of each number in the array target.
Iterate through target and for each number, update the frequency in targetFreq similarly.
Compare the size of the key sets of arrFreq and targetFreq.
If they differ in size, return false, indicating the arrays cannot be equal.
Iterate through the keys in arrFreq:
For each key, check if the frequency in targetFreq matches the frequency in arrFreq.
If any frequency does not match, return false.
If all checks are passed, return true, indicating the arrays can be made equal by reversing subarrays.
Implementation

Complexity Analysis
Let N be the size of arrays target and arr.

Time Complexity: O(N)

Iterating through each array and updating their dictionaries takes O(N) time. Iterating through one of the dictionary's keys and performing lookups will also take O(N) time. Thus, the total time complexity is O(N).

Space Complexity: O(N)

In the worst case, each array's dictionary will have arr.length keys, taking up O(N) space. Thus, the total space complexity is O(N).

Approach 3: Frequency Counting With 1 Dictionary
Intuition
In the previous approach, we check if there are any differences in the two arrays' frequencies by comparing their respective frequency dictionaries.

However, we can streamline this process using only one frequency dictionary for arr. By creating the frequency dictionary arrFreq for arr, we can iterate through the target and check if each element exists in arrFreq. If it does, we decrement its frequency value in arrFreq. If the dictionary is completely empty at the end of the iteration, it indicates that target and arr have matching elements.

Algorithm
Create a frequency map arrFreq to count the occurrences of each number in the array arr.
Iterate through arr and update the frequency of each number using getOrDefault to handle missing keys.
Iterate through each number in the target array:
Check if the number is present in arrFreq. If not, return false as the arrays cannot be made equal.
Decrease the frequency of the number in arrFreq by 1.
If the frequency of the number becomes 0, remove the number from arrFreq as there are no more occurrences needed.
After processing all numbers in target, check if arrFreq is empty.
If it is empty, return true, indicating that the arrays can be made equal.
If not, return false.
Implementation

Complexity Analysis
Let N be the size of arrays target and arr.

Time Complexity: O(N)

Iterating through one array and updating their dictionary takes O(N) time. Iterating through an array and performing lookups in the dictionary will also take O(N) time. Thus, the total time complexity is O(N).

Space Complexity: O(N)

In the worst case, the dictionary will have arr.length keys, taking up O(N) space. Thus, the total space complexity is O(N).