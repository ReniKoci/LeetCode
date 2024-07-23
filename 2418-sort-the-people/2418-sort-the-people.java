class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < heights.length; i++)
            map.put(heights[i], i);

        Arrays.sort(heights);

        String[] res = new String[names.length];
        for(int i = 0, j = heights.length - 1; i < heights.length; i++, j--)
            res[i] = names[map.get(heights[j])];
        

        return res;
    }
}