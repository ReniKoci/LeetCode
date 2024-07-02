class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // value, frequency pair
        for(int i = 0; i < nums1.length; i++){
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }
        
        List<Integer> arrList = new ArrayList<>();
        // loop through next array and decrement if value is hit and save the value into an arraylist
        for(int i = 0; i < nums2.length; i++){
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i]) > 0){
                arrList.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
            }
        }
        
        int[] arr = new int[arrList.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = arrList.get(i);
        
        return arr;
        
    }
}