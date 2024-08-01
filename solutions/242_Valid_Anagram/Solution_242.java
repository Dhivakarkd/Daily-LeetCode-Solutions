class Solution_242 {

    public static void main(String[] args) {


    }

    public static boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        for(char i: s.toCharArray()){
            count[i-'a']++;
        }

        for(char j: t.toCharArray()){
            count[j-'a']--;
        }

        for(int i: count){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
