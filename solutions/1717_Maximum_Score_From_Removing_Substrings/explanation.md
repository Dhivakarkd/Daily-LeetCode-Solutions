🎯 Problem Description
You are given a string s and two integers y and x. You can do one of the following operations and want to get the maximum score possible:

Delete substring "ab" and get x scores
Delete substring "ba" and get y scores
📥⤵️ Input:
String s | s.length up to 10^5
Integer x | x up to 10^4
Integer y | y up to 10^4
📤⤴️ Output:
The maximum possible score after deleting substrings.

1️⃣🧠 Approach 1: Greedy With Stack
🤔 Intuition
If you understand this approach - you will understand all others. Let's look closer at the problem:

First of all, let's say we have string aba. What we want to remove here? Obviously we want to remove ab if x > y and ba in the other case. So this suggest that this problem is Greedy - we want to remove first all the substrings that will give us the most points.
Now, you need only one pass to ensure that you removed all possible substrings ab or ba. Here's why, for example, if you removed all ab from initial s you will never get any ab while removing ba after that:
When you removed all ab you removed ALL a that have b on the right of it.
Let's say we removed ba now and get ab (character a from the left of the b and character b on the right of the a, so after deleting ba strings concatenate into ab).
But stop, "character b on the fight of the a", but didn't I tell you one point back that we deleted ALL a that have b on right? This conclude my prove, you can prove so for ba as well, because situations are symmetrical.
Now if you understand this points (and I strongly believe you do, if not - please be free to ask questions in comments), all that remains is the way we will remove this "ab" or "ba" which is technical problem. Let's look at the dry run for my explanations and then look at two ways to code this problem (second solution has the same logic)
Dry run
As you guys liked the idea of dry run let's look at this example:

s = "axtababab"
x = 3
y = 4

Initial Conditions
String s = "axtababab"
x = 3
y = 4
Determining the Order of Substring Removal
top = "ba", top_score = 4
bot = "ab", bot_score = 3
Dry Run Steps
Step 1: Remove "ba" Substrings (y > x)
Character	Stack	Action	Resulting Stack	Points
a	[]	Push 'a'	[a]	0
x	[a]	Push 'x'	[a, x]	0
t	[a, x]	Push 't'	[a, x, t]	0
a	[a, x, t]	Push 'a'	[a, x, t, a]	0
b	[a, x, t, a]	Push 'b'	[a, x, t, a, b]	0
a	[a, x, t, a, b]	"ba" found, pop 'b', add 4 points	[a, x, t, a]	4
b	[a, x, t, a]	Push 'b'	[a, x, t, a, b]	4
a	[a, x, t, a, b]	"ba" found, pop 'b', add 4 points	[a, x, t, a]	8
b	[a, x, t, a]	Push 'b'	[a, x, t, a, b]	8
Stack after removing "ba" substrings: [a, x, t, a, b]
Step 2: Remove "ab" Substrings
Character	New Stack	Action	Resulting Stack	Points
a	[]	Push 'a'	[a]	8
x	[a]	Push 'x'	[a, x]	8
t	[a, x]	Push 't'	[a, x, t]	8
a	[a, x, t]	Push 'a'	[a, x, t, a]	8
b	[a, x, t, a]	"ab" found, pop 'a', add 3 points	[a, x, t]	11
Final Result
Stack after removing "ab" substrings: [a, x, t]
Total Points: 11
👩🏻‍💻 Coding
Initialize a variable res to 0 to store the total points.
Check if y is greater than x.
If y > x, prioritize removing the substring "ba" first.
Otherwise, prioritize removing the substring "ab" first.
Set the top substring and its score (top_score), and the bot substring and its score (bot_score) based on the comparison of x and y.
Initialize an empty list stack to keep track of characters for removing the top substring.
Iterate through each character in the string s.
If the current character is the second character of the top substring and the last character in the stack is the first character of the top substring:
Increment res by top_score.
Remove the last character from the stack.
Otherwise, add the current character to the stack.
Initialize a new empty list new_stack to keep track of characters for removing the bot substring.
Iterate through each character in the stack.
If the current character is the second character of the bot substring and the last character in the new_stack is the first character of the bot substring:
Increment res by bot_score.
Remove the last character from the new_stack.
Otherwise, add the current character to the new_stack.
Return the total points stored in res.
📘 Complexity Analysis
⏰ Time complexity: O(n), since we iterate through stacks of size up to n twice -> O(n)
🧺 Space complexity: O(n), since we use two stacks of size up to n -> O(n)
💻 Code
class Solution {
public int maximumGain(String s, int x, int y) {
int res = 0;
String top, bot;
int top_score, bot_score;

        if (y > x) {
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        } else {
            top = "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        // Removing first top substrings cause they give more points
        StringBuilder stack = new StringBuilder();
        for (char ch : s.toCharArray()) { // Changed 'char' to 'ch'
            if (ch == top.charAt(1) && stack.length() > 0 && stack.charAt(stack.length() - 1) == top.charAt(0)) {
                res += top_score;
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        // Removing bot substrings cause they give less or equal amount of scores
        StringBuilder new_stack = new StringBuilder();
        for (char ch : stack.toString().toCharArray()) { // Changed 'char' to 'ch'
            if (ch == bot.charAt(1) && new_stack.length() > 0 && new_stack.charAt(new_stack.length() - 1) == bot.charAt(0)) {
                res += bot_score;
                new_stack.setLength(new_stack.length() - 1);
            } else {
                new_stack.append(ch);
            }
        }

        return res;
    }
}
2️⃣🏆 Approach 2: Directly Modifying String (still greddy)
🤔 Intuition
Intuition for this approach is the same as for the previous one. All changed - now we directly modify string instead of using additional stacks. Alas, in languages like Python or JavaScript space complexity still will be O(n) because string data types of this languages are immutable and we need to convert string to array in order to work with it like in C++, although if we don't consider this specifics about languages this is still O(1) SC.

👩🏻‍💻 Coding
Define a helper function remove_pairs that takes a string string and a target substring target and returns a tuple containing the modified string and the count of removed target substrings.
Initialize write_ind to 0 for tracking the position to write the next character.
Initialize counting to 0 to count occurrences of the target substring.
Iterate through each character in the input string:
Write the current character to the position indicated by write_ind.
Increment write_ind by 1.
If write_ind is at least 2, check if the last two characters form the target substring:
If they do, increment counting and decrement write_ind by 2 to remove the target substring.
Return a tuple containing the modified string (up to write_ind) and the count of removed target substrings.
Initialize a variable res to 0 to store the total points.
Check if y is greater than x:
If y > x, prioritize removing the substring "ba" first.
Otherwise, prioritize removing the substring "ab" first.
Set the top substring and its score (top_score), and the bot substring and its score (bot_score) based on the comparison of x and y.
Call the remove_pairs function with the string s and the top substring.
Store the modified string in remainder and the count of removed top substrings in c.
Increment res by c times top_score.
Call the remove_pairs function again with the remainder string and the bot substring.
Increment res by the count of removed bot substrings times bot_score.
Return the total points stored in res.
📕 Complexity Analysis
⏰ Time complexity: O(n), since we go through string two times -> O(n)
🧺 Space complexity: O(1) or O(n), since we modifying string in-place O(1) but in some languages this is impossible which leads us to O(n)