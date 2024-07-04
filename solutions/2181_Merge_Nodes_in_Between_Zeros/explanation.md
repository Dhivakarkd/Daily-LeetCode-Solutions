Solution
Approach 1: Two-Pointer (One-Pass)
Intuition
We can break this problem into two tasks: finding the sum of all the nodes between two consecutive 0s, and merging these values into a single list. One brute force idea is to iterate through the linked list, summing the node values, and adding this sum to a new linked list when we encounter a 0. However, we can modify the linked list in the given problem.

We can use a two-pointer approach to modify the list. The first pointer, modify, changes the linked list and the second pointer, nextSum, calculates the sum for each block between two 0s. Initially, both pointers start at the beginning of the list.

How can we manage both pointers while traversing the list? After nextSum calculates the sum for the current block, we store this value at the modify node. Since nextSum is at a 0 at the end of the block, it moves to the next node to start summing the next block.

The number of nodes in the modified linked list matches the number of blocks between consecutive 0s. After processing each block, we update modify's next pointer to nextSum, helping maintain the size of the modified list, with both pointers reaching the end simultaneously.

Algorithm
Initialize modify and nextSum with head->next that stores the first node with a non-zero value.
Iterate through the list until modify is not null:
Initialize sum with 0 to store the sum of the current block.
Iterate through the block until nextSum encounters a 0:
Add the value of the current node to sum.
Move nextSum to the next node.
Modify the node value at modify to sum.
Move nextSum to the next node that stores the next block's first non-zero value. Also, set modify->next to this node.
Move modify to it's next node.
Return head->next.