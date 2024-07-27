Solution
Overview
Imagine we're city planners analyzing the connectivity of cities in a region. We have:

A network of n cities, numbered from 0 to n-1.
A list of roads (edges) connecting these cities, with each road having a certain length (weight).
A maximum travel distance (distanceThreshold) we're willing to consider.
Our goal is to find the most isolated city — the one that can reach the fewest other cities within the distanceThreshold. If there's a tie, we choose the city with the highest number.

This is a graph problem where we calculate the reachability of each city within the given distance constraint and then select the optimal city accordingly.

In this article, we'll cover applications of four different graph algorithms to provide a comprehensive guide on the main traversal techniques used in graphs for finding the shortest path. If you are completely unaware of these algorithms, it is recommended to check them out first. Users can treat this as a template and refer back whenever they need clarification on shortest path algorithms. We will maintain a consistent main function throughout the article, changing only the specific algorithm logic. This article will help keep the focus on the dynamic parts that vary according to different algorithms, without overwhelming you with a wall of text.

The four algorithms we'll discuss are:

Dijkstra's Algorithm
Bellman-Ford Algorithm
Shortest Path First Algorithm (SPFA)
Floyd-Warshall Algorithm
Approach 1: Dijkstra Algorithm
Intuition
Dijkstra's algorithm is a graph search algorithm that finds the shortest paths between nodes in a graph. It is particularly effective for finding the shortest path from a single source node to all other nodes in graphs with non-negative edge weights.

The algorithm uses a greedy strategy, maintaining a set of vertices whose shortest distance from the source is known. At each step, it selects the vertex with the minimum distance value from the set of unvisited vertices.

We initialize distances to all vertices as infinity, except for the source vertex, which is set to zero. A priority queue is used to efficiently select the vertex with the minimum distance in each iteration, ensuring that the most promising paths are processed first and saving unnecessary computations.

For each neighbor of the current vertex, we calculate the distance through the current vertex. If this calculated distance is less than the previously known distance to that neighbor, the distance is updated — a process known as relaxation. Dijkstra's algorithm performs relaxation efficiently by always processing the most promising vertex next.

After computing all shortest paths, we count reachable cities and select the most isolated ones.

In summary, the algorithm involves three main steps:

Initialization: Set the distance to the source city as zero and all others as infinity. Use a priority queue to process cities based on their shortest distance.

Relaxation: Extract the city with the smallest distance from the priority queue. Update the distances to their neighboring cities, adding them back to the queue if their distances are updated.

Result Computation: Compute the shortest paths from each city. Count the number of reachable cities within the distance threshold. Choose the city with the fewest reachable cities or, in case of ties, the city with the greatest number.

Algorithm
Create an adjacency list adjacencyList to store the graph.

Create a 2D array shortestPathMatrix with dimensions n x n to store shortest path distances between all pairs of cities.

For each city i:

Set all distances in shortestPathMatrix[i] to the maximum integer value.
Set the distance from the city i to itself (shortestPathMatrix[i][i]) to 0.
Initialize adjacencyList[i] as an empty list.
Iterate through each edge in edges:

Extract start, end, and weight from each edge.
Add (end, weight) to adjacencyList[start].
Add (start, weight) to adjacencyList[end].
For each city i:

Call dijkstra(n, adjacencyList, shortestPathMatrix[i], i), where i is the source city and shortestPathMatrix[i] is the array that will hold the shortest path distances from city i.
Return the city identified by calling getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold) as having the fewest number of reachable cities within the given distance threshold.

dijkstra(n, adjacencyList, shortestPathDistances, source) Function:

Use a priority queue to process nodes with the smallest distance first:
Initialize the priority queue with the source city.
Set all distances in shortestPathDistances to Integer.MAX_VALUE.
Set the distance to the source city itself (shortestPathDistances[source]) to 0.
Process nodes in priority order:
For each node, update distances to neighboring cities if a shorter path is found.
getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold) Function:

Initialize cityWithFewestReachable to -1 and fewestReachableCount to n.

For each city i:

Count how many cities are reachable from the city i within the distanceThreshold:

For each city j, check if shortestPathMatrix[i][j] is less than or equal to distanceThreshold.
Increment reachableCount if city j is reachable within the threshold.
Update cityWithFewestReachable if the current city i has fewer reachable cities compared to previously evaluated cities.

Approach 2: Bellman-Ford Algorithm
Intuition
The Bellman-Ford algorithm is a graph search algorithm that finds the shortest paths from a single source vertex to all other vertices in a weighted graph. Unlike Dijkstra's algorithm, Bellman-Ford can handle graphs with negative edge weights, making it more versatile but potentially slower.

We start by initializing distances to all vertices as infinity, except the source vertex, which is set to zero. This initialization represents our initial state of knowledge - we don't know any paths yet, so we assume they're infinitely long, except for the trivial path from a vertex to itself.

Next, we perform the key operation, relaxation. For each edge in the graph, we check if the distance to the destination vertex can be improved by going through the source vertex of that edge. We repeat this relaxation step for V-1 times, where V is the number of vertices. In the worst case, where vertices form a line, it might take V-1 steps for changes to propagate from one end to the other.

In our implementation, we apply Bellman-Ford from each city as a source, giving us the shortest paths from every city to every other city. We could have used a single source and run Bellman-Ford once, then repeated for other sources, but running it independently for each source simplifies our code structure.

After computing all shortest paths, we count how many cities are reachable from each city within the distance threshold, and then select the city that can reach the fewest others, breaking ties by choosing the higher-numbered city.

This approach guarantees correctness even with negative edge weights (though we don't have those here). Its simplicity makes Bellman-Ford a good algorithm, even if it's not the most efficient for our specific problem. We don't need to implement cycle detection or early termination, keeping our code straightforward at the cost of potentially unnecessary computations.

Algorithm
Define INF as a large constant value (e.g., 1e9 + 7) to represent an infinite distance for initial comparisons.

Create a 2D array shortestPathMatrix with dimensions n x n to store shortest path distances between all pairs of cities.

For each city i:

Set all distances in shortestPathMatrix[i] to INF.
Set the distance from the city i to itself (shortestPathMatrix[i][i]) to 0.
Iterate through each edge in edges:

Extract start, end, and weight from each edge.
Update shortestPathMatrix[start][end] and shortestPathMatrix[end][start] with weight.
For each city i:

Call bellmanFord(n, edges, shortestPathMatrix[i], i), where i is the source city and shortestPathMatrix[i] is the array that will hold the shortest path distances from the city i.
Return the city identified by calling getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold) as having the fewest number of reachable cities within the given distance threshold.

bellmanFord(n, edges, shortestPathDistances, source) Function:

Initialize the distances from the source city:
Set all distances in shortestPathDistances (initially set to Integer.MAX_VALUE, which represents INF) to a large value, indicating that the shortest distance is unknown at the start.
Set the distance to the source city itself (shortestPathDistances[source]) to 0.
Relax edges up to n-1 times:
Iterate through all edges in edges:
For each edge, extract start, end, and weight.
Update the shortest path distances if a shorter path is found. Specifically:
If the distance from start to end can be reduced by taking the current edge, update shortestPathDistances[end].
Similarly, update shortestPathDistances[start] if a shorter path is found through the end city.
getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold) Function:

Initialize cityWithFewestReachable to -1 and fewestReachableCount to n.

For each city i:

Count how many cities are reachable from city i within the distanceThreshold:

For each city j, check if shortestPathMatrix[i][j] is less than or equal to distanceThreshold.
Increment reachableCount if city j is reachable within the threshold.
Update cityWithFewestReachable if the current city i has fewer reachable cities compared to previously evaluated cities.

Implementation
Note: We have introduced an updated flag to break out of the loop early (relaxation of edges) if no updates are made in an iteration. This optimization can reduce the number of iterations in some cases, addressing the Time Limit Exceeded (TLE) issues that occur when the algorithm is run without this adjustment in Python implementations. For those implementing this algorithm in C++ or Java, refer to the Python code to see how this simple updated flag has been integrated.

