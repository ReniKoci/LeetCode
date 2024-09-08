class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        String res = "";
        for(String a: arr){
            System.out.println(k + " " + res);
            if(map.get(a) == 1){
                res = a;
                k--;
            }

            if(k == 0)
                return res;
        }

        return "";
    }
}