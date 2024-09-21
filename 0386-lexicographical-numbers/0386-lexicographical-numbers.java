class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> out = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            dfs(i, n, out);

        return out;
    }

    public void dfs(int num, int n, List<Integer> out){
        if(num > n)
            return;

        out.add(num);
        for(int i = 0; i < 10; i++){
            if(10 * num + i > n)
                return;

            dfs(10 * num + i, n, out); 
        }
    }
}