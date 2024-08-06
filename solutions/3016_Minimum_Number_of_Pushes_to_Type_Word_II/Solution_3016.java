import java.util.Arrays;

class Solution_3016 {
    public int minimumPushes(String word) {

        //char count array
        int[] countArr = new int[26];

        //use -ve counter to change default behaviour, as in java arrays sorts in increasing order
        for(int i = 0; i < word.length(); i++){ // O(n)
            countArr[word.charAt(i) - 'a']--;
        }

        //since we used -ve counter, highest freq will come first
        Arrays.sort(countArr); // O(26*log26) ~ O(1)

        int res = 0;

        //iterate via chars, use (i/8) + 1 to get press count
        for(int i = 0; i < 26; i++){ //O(26) ~ O(1)
            res += -countArr[i] * ((i / 8) + 1);
        }

        return res;
    }
}
