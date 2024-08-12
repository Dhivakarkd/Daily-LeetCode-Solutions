Solution
Overview
Imagine a university admissions office wants to keep track of the k-th highest test scores from applicants in real time. This allows them to dynamically determine the cut-off score as new applications come in. To achieve this, we'll create a class KthLargest that can return the k-th largest element for an incoming stream of numbers. Specifically, we need to implement:

The constructor KthLargest(int k, int[] nums), which initializes the class with k and the initial stream of numbers num,
The function add(int val), which adds a new number val into the existing stream of numbers, and returns the k-th largest element of the updated stream.
Approach 1: Maintain Sorted List
Intuition
In this problem, we need to be able to repeatedly fetch the k-th largest element from a growing stream of numbers. Suppose we assume that the stream of numbers is always sorted in ascending order. In that case, returning the k-th largest element becomes a straightforward operation of fetching the k-th element from the end of the stream.

Thus, one approach is to maintain a list that stores the entire stream of numbers seen so far, and ensure the list remains sorted each time we add a new element. This allows us to fetch the k-th largest element with no extra work.

For our constructor, we can initialize our list stream with the initial set of numbers nums provided, and then sort stream in ascending order.

For every new val added to the stream by the add(int val) call, we ensure val is inserted at the correct position so that stream remains sorted. Because stream is sorted beforehand, we can efficiently find the correct position for val by using binary search.

For this binary search insertion:

We start with the entirety of stream as our search space
We check the middle element stream[mid]
If stream[mid] == val then we know that we can add val at index mid
If stream[mid] < val, then val needs to be added to the right of stream[mid], so we limit the search space to the right half of stream.
If stream[mid] is greater than val,val needs to be added to the left of stream[mid], so we limit the search space to the left half of stream.
We can repeat this procedure until we narrow down our search space to the correct index to add val.
After inserting val in the correct position, we can return stream[stream.length - k], which is the k-th largest element in the stream.

Algorithm
In the constructor:
Initialize class variable k
Initialize class variable list stream
Add all of nums to stream, used to keep track of the total stream.
Sort stream in ascending order
In the add(int val) function:
Call helper function getIndex(int val) to find the index i to add val
Insert val in stream at index i
Return the k-th largest element in stream, at index stream.size() - k
In the getIndex(int val):
Define starting search space: Initialize left to 0 and right to stream.size() - 1
While left <= right:
Calculate index for middle element: Initialize mid to (left + right) / 2
Get middle element: Initialize midElement to stream.get(mid)
If midElement == val return mid
If midElement > val:
Go to left half of search space: Reassign right to mid - 1
If midElement < val:
Go to right half of search space: Reassign left to mid + 1