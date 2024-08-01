public class Solution_1653 {
    public static void main(String[] args) {
        String s = "aababbab";
        int result = minimumDeletions(s);
        System.out.println(result);
    }
    public static int minimumDeletions(String s) {

        int len = s.length();
        int[] count_a = new int[len];
        int[] count_b = new int[len];

        int aCount=0;
        int bCount =0;
        for(int i=0;i<len;i++){
            count_b[i] = bCount;

            if(s.charAt(i) == 'b'){
                bCount++;
            }
        }

        for (int i = len-1 ; i >= 0 ; i--) {
            count_a[i] = aCount;

            if(s.charAt(i) == 'a'){
                aCount++;
            }
        }

        int minDiff = 0;

        for (int i = 0; i < len; i++) {
            minDiff =  Math.min(minDiff,count_a[i]+count_b[i]);
        }
        return 0;
    }
}
