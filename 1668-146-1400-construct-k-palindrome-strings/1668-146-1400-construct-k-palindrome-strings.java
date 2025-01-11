class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;

        if(s.length() == k)
            return true;

        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int odds = 0;
        for(int i = 0; i < s.length(); i++) {
            if(count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) % 2 != 0)
                odds++;            
            count.remove(s.charAt(i));
        }
        return odds <= k;
    }
}