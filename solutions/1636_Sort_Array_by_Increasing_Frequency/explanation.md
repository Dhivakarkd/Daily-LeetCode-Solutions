Overview
The task is to sort an array of integers by their frequency, placing numbers with fewer occurrences first. If two numbers appear with the same frequency, they should be ordered by their values in descending order. Think of it as arranging a playlist by the least to most popular songs, or ranking search results to prioritize the most relevant and engaging options for a more intuitive user experience.

Approach: Customized Sorting
Intuition
To sort the numbers, we first arrange them based on their frequency in ascending order. Numbers that appear less frequently will come before those with higher frequencies. We use a hashmap, freq, to count the occurrences of each number in the array.

If two numbers have the same frequency, we then sort them by their values in descending order. This introduces a dual sorting criterion: first by frequency and then by value.

To accomplish this, we will apply a custom sorting function using lambda expressions. These anonymous functions let us define sorting logic inline. Specifically, our lambda function ensures that numbers are compared primarily by their frequency, and secondarily by their value if frequencies match. This approach guarantees that the final sorted list adheres to both sorting criteria.

C++ Lambda Function for Sorting by Increasing Frequency
sort(nums.begin(), nums.end(), [&](int a, int b) {
if (freq[a] == freq[b]) {
return a > b;
}
return freq[a] < freq[b];
});
The lambda [&](int a, int b) { ... } serves as the comparator for the sort function:

& captures all external variables (freq in this case) by reference, allowing the lambda to access and use freq.
(int a, int b) defines parameters for elements to compare.
Comparison logic:
If frequencies are equal (freq[a] == freq[b]), sort by value in descending order (a > b).
Otherwise, sort by frequency in ascending order (freq[a] < freq[b]).
Java Lambda Function for Sorting by Increasing Frequency
Arrays.sort(numsObj, (a, b) -> {
if (freq.get(a).equals(freq.get(b))) {
return Integer.compare(b, a);
}
return Integer.compare(freq.get(a), freq.get(b));
});
Lambda (a, b) -> { ... } as comparator for Arrays.sort:

Parameters a and b represent elements to compare.
Comparison logic:
If frequencies are equal (freq.get(a).equals(freq.get(b))), sort by value in descending order (Integer.compare(b, a)).
Otherwise, sort by frequency in ascending order (Integer.compare(freq.get(a), freq.get(b))).
Python Lambda Function for Sorting by Increasing Frequency
sorted(nums, key=lambda x: (freq[x], -x))
The lambda function lambda x: (freq[x], -x) is used as the key parameter in the sorted function call.

lambda x: creates an anonymous function with x as its parameter.
(freq[x], -x) is the tuple that the lambda function returns.
freq[x] is used to get the frequency of x from the freq dictionary as the main sorting criterion.
-x ensures that values are sorted in descending order when their frequencies are the same.
Algorithm
Initialize an unordered map freq to store the frequency of each integer in the input array nums.
Traverse through each integer num in the array nums.
Increase the count of num in the freq map using freq[num]++.
Sort the array nums using the sort function with a custom comparator:
Compare two integers a and b based on their frequencies stored in the freq map:
If freq[a] (frequency of a) equals freq[b] (frequency of b), then:
Return a > b to ensure that in case of tie-in frequency, larger values come first (decreasing order).
Otherwise, return freq[a] < freq[b] to sort by frequency in increasing order.
Return the sorted nums array, which now reflects the integers sorted primarily by frequency in ascending order, and by value in descending order when frequencies are tied.
