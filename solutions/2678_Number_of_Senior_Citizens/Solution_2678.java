 class Solution_2678 {

     public static void main(String[] args) {
        String[] details = new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"};

         System.out.println(countSeniors(details));
     }
    public static int countSeniors(String[] details) {

        int count=0;
        for(String s : details){

            int age = Integer.parseInt(""+s.charAt(s.length()-4) + s.charAt(s.length()-3));

            if(age>60){

                count++;
            }

        }
        return count;
    }
}