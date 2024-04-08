class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0)
            return res;

        int borderUp = 0, borderLeft = 0;
        int borderDown = matrix.length - 1, borderRight = matrix[0].length - 1;

        while(borderUp <= borderDown && borderLeft <= borderRight){
            // go right
            for(int i = borderLeft; i <= borderRight; i++)
                res.add(matrix[borderUp][i]);
            
            borderUp++;
            // go down
            for(int i = borderUp; i <= borderDown; i++)
                res.add(matrix[i][borderRight]);
            
            borderRight--;
            // go left
            if(borderUp <= borderDown){
                for(int i = borderRight; i >= borderLeft; i--)
                    res.add(matrix[borderDown][i]);
            }
            borderDown--;
            // go up
            if(borderLeft <= borderRight){
                for(int i = borderDown; i >= borderUp; i--)
                    res.add(matrix[i][borderLeft]);
            }
            
            borderLeft++;
        }         
       return res;
    }
}