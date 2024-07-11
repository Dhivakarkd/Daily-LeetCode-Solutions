Solution
Overview
Given a list of strings logs, the task is to calculate the minimum steps needed to navigate back to the main folder.

Each string in logs represents a moving operation:

"../": To the Parent Folder
"./": Staying in the same Folder
"x/": To the Child Folder named x
Approach 1: Counter
Intuition
To solve this problem, we need to track the user's position within the folder structure relative to the main folder. We can achieve this using a numerical counter that represents the depth of the current folder.

Here's how the counter system works when we move around the file system:

We initialize the counter to 0, representing the main folder.
If we enter a child folder ("x/"), we increase the counter by 1 to go deeper into the folder structure.
When we encounter "../", we decrease the counter by 1 to move up a level. If the counter is already at 0, it remains at 0 because we can't move above the main folder.
"./" operations do not change the counter since they keep us in the current folder.
We process each operation in the logs sequentially, updating our counter according to these rules. This approach allows us to track the user's depth in the folder structure without needing to store or process the actual folder names or full paths.

Algorithm
Initialize folderDepth to 0 to keep track of the current depth in the file system.
For each currentOperation in logs, perform the following steps:
If currentOperation equals "../", decrease folderDepth by 1 to move up one directory level, but ensure folderDepth does not go below 0 (to prevent navigating above the root directory).
If currentOperation equals "./", ignore it, as it means staying in the current directory and does not affect folderDepth.
For any other currentOperation("x/"), increment folderDepth by 1, indicating moving into a new directory.
Return folderDepth as the minimum number of operations required to navigate back to the main folder.