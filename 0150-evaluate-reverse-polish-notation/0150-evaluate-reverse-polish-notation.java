class Solution {
    public int evalRPN(String[] tokens) {
        // init a stack which is going to include all the numbers present on the tokens
        Stack<Integer> numbers = new Stack<>();
        for(String token: tokens){
            // check if string is a math symbol
            if(token.equals("/")){
                int a = numbers.pop(), b = numbers.pop();
                numbers.push(b / a);
            }else if(token.equals("+")){
                int a = numbers.pop(), b = numbers.pop();
                numbers.push(b + a);
            }else if(token.equals("-")){
                int a = numbers.pop(), b = numbers.pop();
                numbers.push(b - a);
            }else if(token.equals("*")){
                int a = numbers.pop(), b = numbers.pop();
                numbers.push(b * a);
            }else{ // we have a number
                // convert to int and store in stack
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }
}