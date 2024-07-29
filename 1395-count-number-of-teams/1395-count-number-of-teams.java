class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for(int i = 0; i < rating.length; i++){
            int left_less = 0;
            int left_more = 0;
            int right_less = 0;
            int right_more = 0;



            // left side
            for(int j = 0; j < i; j++){
                if(rating[j] < rating[i])
                    left_less++;
                if(rating[j] > rating[i])
                    left_more++;
            }

            // right side
            for(int j = i + 1; j < rating.length; j++){
                if(rating[j] < rating[i])
                    right_less++;
                if(rating[j] > rating[i])
                    right_more++;
            }

            res += left_less * right_more + left_more * right_less;
        }


        return res;
    }
}