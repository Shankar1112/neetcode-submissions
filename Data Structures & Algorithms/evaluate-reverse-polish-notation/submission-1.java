class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<Integer>();

        for (String c : tokens) {
            switch(c) {
                case "+" :
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-" : 
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
               case "*" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/" : 
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);   
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }                 
        }
        return stack.pop();
    }
}
