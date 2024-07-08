Solution
Overview
In this circular game, n friends numbered from 1 to n stand in a circle. In the first round, we start counting from friend 1 and eliminate the k-th friend. In each subsequent round, counting starts from the friend immediately clockwise to the one just eliminated, and the k-th friend is eliminated again. This process repeats until only one person remains.

A straightforward approach for turn-based games can be to simulate the game's rules. Here, our algorithm can eliminate the k-th friend in each iteration. However, optimizations are often possible, as in this problem, where we can reduce space and time complexity.

We will start with a simulation approach and then explore more efficient methods that avoid manually following the game's rules.

Note: This is famously known as the Josephus Problem.

Approach 1: Simulation with List
Intuition
To simulate this elimination game, we can start by representing the n friends using a list data structure. Initially, this list contains all the friends labeled from 1 to n. The idea is to repeatedly count to the k-th friend in the list and remove them from the game. By continually removing every k-th friend and adjusting our starting point after each removal, we can narrow down the group until only one friend remains. This final remaining friend is the winner of the game.

Algorithm
Initialize a list of size n, representing n friends labeled from 1 to n
Maintain a startIndex variable that keeps track of the position from where counting begins, initially set to 0.
While more than 1 friend is remaining:
Calculate the new index of the next friend to remove as (startIndex + k - 1) % numFriendsRemaining. We apply the modulus operator to ensure counting wraps around the circle.
Remove the friend at the calculated index
Update startIndex to the removed index
Return the label of the last remaining friend

Approach 2: Simulation with Queue
Intuition
Instead of using a list to manage eliminations (which can be a costly O(n) operation), we can optimize the elimination process by using a queue. In a queue, removing the first element is done in O(1) time. Initially, we fill the queue with friends labeled from 1 to n. The key insight is how eliminations can be handled at each round. In each round, we simulate the process by rotating the queue k-1 times. This action effectively moves the k-th friend to the front of the queue, ready for removal. Once positioned, removing this front element simulates eliminating that friend from the game. This rotation and removal process continues until only one friend remains in the queue, who is then declared the winner of the game.

With the use of a queue, the cost of the pop operation, which was O(n) in the list approach, is now reduced to O(1). The traversal operation remains the only operation with linear time complexity.

Algorithm
Initialize a queue of size n, where the elements are labeled 1 to n.
While more than 1 friend is remaining
Remove the next k-1 friends and re-add them to the queue.
Remove the next friend (the k-th friend that should be eliminated in the game)
Return the value of the last friend remaining


