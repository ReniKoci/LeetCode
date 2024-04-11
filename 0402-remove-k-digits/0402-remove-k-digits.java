class Solution {
    public String removeKdigits(String num, int k) {

        // if k is same length of num means we delete all digits
        if(k == num.length())
            return "0";

        Stack<Character> stack = new Stack<>();

        // add first element 
        stack.push(num.charAt(0));

        for(int i = 1; i < num.length(); i++){

            // while there are elements greater then current element, remove them and decrement k
            // for characters, the ascii value is used for comparisons
            // a < z
            while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // in case we have a incrementing num or same value num, k will still be > 0
        // e.g. 6789 or 1111
        while(k > 0){
            stack.pop();
            k--;
        }

        // our string is the reverse of the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        // remove leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}