package dsa.brackets.balancer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BracketsBalancer {

    String expression;

    public BracketsBalancer(String expression) {

        this.expression = expression;
    }

    public void check() {


        Stack<Character> stack = new Stack<>();

        //  (  [  [  {  }  ]  ]  )

        // Visit each character from the expression

        // for-character
        // close-bracket

        int length = expression.length();

        if (length %2 != 0) {
            System.out.println("Odd number of character - Invalid Expression");
            return;
        }

        for (int index = 0; index < length; index ++) {

            Character visitedChar = expression.charAt(index);

            if (getOpenBrackets().contains(visitedChar)) {

                // open-bracket
                // push()

                stack.push(visitedChar);

            }else if (getClosedBrackets().contains(visitedChar)) {

                // pop()
                // check between
                // popped-out item [open-bracket-char] // {
                // visited item [closed-bracket-char // }

                Character poppedItem = stack.pop();

                Character assumedOpenBracketChar = poppedItem;
                Character assumedClosedBracketChar = visitedChar;

                Character openBracketChar
                        = getOpenBracketChar(assumedClosedBracketChar);

                if (assumedOpenBracketChar == openBracketChar) {

                    // Match
                    continue;
                }else {
                    System.out.println("Non-matching Bracket");
                    break;
                }
            }else {

                System.out.println("Invalid characters encountered :"
                        + visitedChar);
                break;
            }
        }

        if (stack.isEmpty()) {

            System.out.println("Bracket Expression Valid");
        }else {
            System.out.println("Bracket Expression Invalid");
        }

    }

    Set<Character> getOpenBrackets(){

        // LinkedHashSet -> Order
        // HashSet -> No Order
        // <, {, [, (

        Set<Character> openBracketSet = new HashSet<>();

        openBracketSet.add('<');
        openBracketSet.add('{');
        openBracketSet.add('[');
        openBracketSet.add('(');

        return openBracketSet;
    }

    Set<Character> getClosedBrackets(){

        Set<Character> closeBracketSet = new HashSet<>();

        closeBracketSet.add('>');
        closeBracketSet.add('}');
        closeBracketSet.add(']');
        closeBracketSet.add(')');

        return closeBracketSet;

        // >, ], }, )
    }

    Character getOpenBracketChar(Character closedBracketChar) {


        if (closedBracketChar == '>') {
            return '<';
        }else if (closedBracketChar == '}') {
            return '{';
        }else if (closedBracketChar == ']') {
            return '[';
        }else if (closedBracketChar == ')') {
            return '(';
        }
        return ' ';
    }


    public static void main(String[] args) {

        BracketsBalancer balancer
                //  {[()]}
                //  ({[<>]})
                //  [<<]
                //  [<>]]
                //  [<#|>]
                = new BracketsBalancer("{[()]}");

        balancer.check();
    }
}