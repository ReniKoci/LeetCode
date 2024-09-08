class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> s = new HashMap<>();
        for(int t: target){
            s.put(t, s.getOrDefault(t, 0) + 1);
        }

        for(int a: arr){
            if(!s.containsKey(a))
                return false;

            if(s.get(a) < 1)
                return false;

            s.put(a, s.get(a) - 1);
        }

        return true;
    }
}