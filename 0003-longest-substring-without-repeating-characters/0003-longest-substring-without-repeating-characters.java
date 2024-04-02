class Solution {
    public int lengthOfLongestSubstring(String s) {
        // create a hashmap that will contain a pair of Character and index
        HashMap<Character, Integer> map = new HashMap<>();
        // variable for the longest substring
        int maxSubstring = 0;
        // variable to store the last seen character which is already part of the longes substring
        int j = 0;

        for(int i = 0; i < s.length(); i++){
            // if a character is already seen, update j to point to the next character of the seen character
            // idea: whatever character we see again, the characters previous to this are not revelevant
            // so also get rid of them
            // e.g. abcbb -> if we hit b again, the get rid of the a previous to the first b (j will point to c)
            //       ^ ^
            if(map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i))+1);

            // insert character into map
            map.put(s.charAt(i), i);

            // calculate max length of substring
            maxSubstring = Math.max(maxSubstring, i - j + 1);
        }

        return maxSubstring;
    }
}