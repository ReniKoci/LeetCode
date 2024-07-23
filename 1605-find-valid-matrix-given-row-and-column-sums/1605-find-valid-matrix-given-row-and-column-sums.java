class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                int minVal = Math.min(rowSum[i], colSum[j]);
                res[i][j] = minVal;
                rowSum[i] = rowSum[i] - minVal;
                colSum[j] = colSum[j] - minVal;
            }
        }
        return res;
    }
}