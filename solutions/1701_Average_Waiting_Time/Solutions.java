class Solution {
    public double averageWaitingTime(int[][] customers) {

        long nextWaitingTime =0;
        int nextIdleTime =0;

        for (int i = 0; i < customers.length; i++) {

          nextIdleTime = Math.max(customers[i][0],nextIdleTime) + customers[i][1];

          nextWaitingTime += nextIdleTime - customers[i][0];
        }

        double average = (double) nextWaitingTime / customers.length;
        return average;
    }
}