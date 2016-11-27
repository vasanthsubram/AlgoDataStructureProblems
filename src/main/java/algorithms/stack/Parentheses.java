package algorithms.stack;

/*
 *  Reads input text and checks to see if the parentheses, curly
 *  braces, and square brackets are balanced.
*/

import java.util.*;

public class Parentheses {
    public static boolean isBalanced(String expression) {
        if(expression.length()%2 != 0){
            return false;
        }
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    if(stack.pop()!= '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    if(stack.pop()!= '['){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    if(stack.pop()!= '('){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String balanced = "[()]{}{[()()]()}";
        System.out.println(isBalanced(balanced));
        
        String balanced2 = "[(((((())))))]";
        System.out.println(isBalanced(balanced2));
        
        String unbalanced = "[(])";
        System.out.println(isBalanced(unbalanced));

        String balanced3 = "[()][{}()][](){}([{}(())([[{}]])][])[]([][])(){}{{}{[](){}}}()[]({})[{}{{}([{}][])}]";
        System.out.println(isBalanced(balanced3));
    }

}
