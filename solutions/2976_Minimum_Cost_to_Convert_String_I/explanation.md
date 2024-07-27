Solution
Overview
We have two strings, source and target, both of the same length. Additionally, we have three arrays: original, changed, and cost, each also of the same length.

Our task is to transform the source text into the target text using a series of character conversions. Each conversion works as follows:

Identify a character in source that does not match the corresponding character in target.
Find this mismatched character in the original array.
Replace it with the corresponding character from the changed array.
Each conversion has a cost specified in the cost array.
The goal is to determine the minimum total cost required to transform source into target.

Approach 1: Dijkstra's Algorithm
Intuition
Our task is to convert each mismatched character at the lowest possible cost. To tackle this, we can model each character as a node in a graph, with transformations represented as directed edges between nodes, each with a specific cost. The problem then becomes finding the minimum cost path from each character in source to the corresponding character in target.

Consider Example 1 from the problem description visualized as a graph:

Graph Representation

To find the minimum cost path between nodes, Dijkstra's Single Source Shortest Path algorithm is useful. It efficiently calculates the shortest path in a directed graph with non-negative edge weights. For more information, refer to this LeetCode Explore Card.

First, create a graph structure using an adjacency list to represent all possible character conversions. For each index i:

The character in original[i] is the starting point.
The character in changed[i] is the destination.
The value in cost[i] denotes the conversion cost.
Each conversion is an edge in our graph, mapping potential character transformations and their costs. Instead of running Dijkstra's algorithm for every differing character, precompute the shortest path from every character to every other character. This reduces the need to execute the algorithm multiple times, leveraging the fact that there are only 26 possible characters.

Finally, calculate the total minimum cost by summing the precomputed costs for each differing character in source and target.

Algorithm
Main method minimumCost:

Create an adjacencyList with 26 entries (one for each lowercase letter).
Iterate through the original array: For each index i:
Add an edge to adjacencyList from original[i] to changed[i], with the corresponding cost[i].
For each of the 26 characters, call dijkstra to find the shortest path from this character to all other characters.
Store the results in a 2D array minConversionCosts of size 26×26.
Initialize a variable totalCost to 0.
Iterate through the length of source:
If the character at the current position differs from target:
Look up the conversion cost in minConversionCosts:
If the conversion is impossible (cost is -1), return -1.
Else, add the cost to totalCost.
Return totalCost as the answer.
Helper method dijkstra:

Define a method dijkstra with parameters: startChar and adjacencyList.
Create a priority queue priorityQueue with each element as a pair of (cost, character). Sort the queue by cost (lowest first).
Initialize an array minCosts of size 26 with all values set to -1 (representing unreachable positions).
Add startChar to priorityQueue with a cost of 0.
While priorityQueue is not empty:
Poll a pair (currentCost, currentChar) from the queue.
Loop over all possible conversions from currentChar using the adjacencyList. For each conversion to targetChar:
Find the newTotalCost to do the conversion as currentCost + conversionCost.
If the conversion hasn't been reached yet minCosts[targetChar] == -1, or newTotalCost is less than the previous cost in minCosts[targetChar]:
Set minCosts[targetChar] as newTotalCost.
Add the pair (newTotalCost, targetChar) to the priority queue.
Return minCosts.