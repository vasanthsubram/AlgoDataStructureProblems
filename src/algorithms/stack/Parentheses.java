package algorithms.stack;

import datastructure.stack.Stack;

/*************************************************************************
 *  Reads in a text file and checks to see if the parentheses, curly
 *  braces, and square brackets are balanced.
 *
 *  % java  java Parentheses
 *  [()]{}{[()()]()}
 *  true
 *
 *  % java Parentheses
 *  [(])
 *  false
 *
 *************************************************************************/

public class Parentheses {
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>(Character.class);
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == L_PAREN)   stack.push(L_PAREN);

            else if (s.charAt(i) == L_BRACE)   stack.push(L_BRACE);

            else if (s.charAt(i) == L_BRACKET) stack.push(L_BRACKET);

            else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_PAREN) return false;
            }

            else if (s.charAt(i) == R_BRACE) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACE) return false;
            }

            else if (s.charAt(i) == R_BRACKET) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACKET) return false;
            }

            // ignore all other characters

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
        
    }

}
