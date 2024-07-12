class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        Stack<Character> stack = new Stack<>();
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        char first, second;
        if(x > y){
            first = 'a';
            second = 'b';
        }else{
            first = 'b';
            second = 'a';
        }

        // get the score from higher x or y
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == first && currentChar == second){
                stack.pop();
                score += max;
            }else{
                stack.push(currentChar);
            }
        }

        // process the left out x or y from the stack
        // e.g. if now we would check for ab, since stack is LIFO we check for ba 
        Stack<Character> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            char currentChar = stack.pop();
            if(!stack2.isEmpty() && stack2.peek() == first && currentChar == second){
                stack2.pop();
                score += min;
            }else{
                stack2.push(currentChar);
            }
        }

        return score;
    }

    
}