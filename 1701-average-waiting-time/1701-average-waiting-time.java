class Solution {
    public double averageWaitingTime(int[][] customers) {
        double res = 0;
        int currentFinishTime = customers[0][0];
        for(int[] customer: customers){
            int startTime = customer[0];
            int prepTime = customer[1];

            if(currentFinishTime < startTime)
                currentFinishTime = startTime;
            currentFinishTime = prepTime + currentFinishTime;
            res += (currentFinishTime - startTime);
        }

      
        return (double) res / customers.length;
    }
}