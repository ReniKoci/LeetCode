class Solution {
    public int strStr(String haystack, String needle) {
        int needleWindow = 0, index = -1;
        for(int i = 0; i < haystack.length(); i++){
            if(needle.charAt(needleWindow) != haystack.charAt(i)){
                System.out.println(needle.charAt(needleWindow) + " " +  haystack.charAt(i));

                i = i - needleWindow;
                needleWindow = 0;
                continue;
            }else{
                if(needleWindow == needle.length() - 1){
                    index = i - needle.length() + 1;
                    break;
                }
                needleWindow++;
            }
        }
        return index;
    }
}